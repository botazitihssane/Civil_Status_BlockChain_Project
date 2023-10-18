package spring.civilstatus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.validation.Valid;
import spring.civilstatus.blockchain.response.ChainResponse;
import spring.civilstatus.blockchain.response.MineResponse;
import spring.civilstatus.blockchain.response.TransactionResponse;
import spring.civilstatus.blockchain.util.BlockProofOfWorkGenerator;
import spring.civilstatus.models.ActeDeces;
import spring.civilstatus.models.Block;
import spring.civilstatus.service.impl.ActeDecesService;

@RestController
@RequestMapping("/api/actes/deces")
public class ActeDecesController {
	@Autowired
	private ActeDecesService acte;

	@Autowired
	private ObjectMapper objectMapper;

	@GetMapping("/mine")
	public MineResponse mine() throws JsonProcessingException {
		// Calculate Proof of work
		Block lastBlock = acte.lastBlock();
		Long lastProof = lastBlock.getProof();
		Long proof = BlockProofOfWorkGenerator.proofOfWork(lastProof);

		// Add the new block to the chain
		Block newBlock = acte.createBlock(proof, lastBlock.hash(objectMapper));

		MineResponse mineResponse = new MineResponse();
		mineResponse.setMessage("New Block Added");
		mineResponse.setIndex(newBlock.getIndex());
		mineResponse.setTransactions(newBlock.getTransactionList());
		mineResponse.setProof(newBlock.getProof());
		mineResponse.setPreviousHash(newBlock.getPreviousBlockHash());

		return mineResponse;
	}

	@GetMapping("/chain")
	public ChainResponse fullChain() {
		ChainResponse chainResponse = new ChainResponse();
		chainResponse.setChain(acte.getChain());
		chainResponse.setLength(acte.getChain().size());
		return chainResponse;
	}

	@PostMapping("/transactions")
	public TransactionResponse newTransaction(@RequestBody @Valid ActeDeces acteDeces) {
		Long index = acte.addTransaction(acteDeces.getId(), acteDeces.getTypeEnregistrement(),
				acteDeces.getDateEnregistrement(), acteDeces.getLieuEnregistrement(), acteDeces.getOfficierValidant(),
				acteDeces.getRegistre(), acteDeces.getNom(), acteDeces.getPrenom(), acteDeces.getCauseDeces(),
				acteDeces.getDateDeces(), acteDeces.getHeureDeces(), acteDeces.getLieuDeces(), acteDeces.getDeclarant(),
				acteDeces.getRelationAvecDefunt(), acteDeces.getConjoint(), acteDeces.getPere(), acteDeces.getMere(),
				acteDeces.getProfession(), acteDeces.getAdresse(),acteDeces.getDateNaissance(),acteDeces.getLieuNaissance());
		TransactionResponse transactionResponse = new TransactionResponse();
		transactionResponse.setIndex(index);
		return transactionResponse;
	}

	@GetMapping("/transactions/id/{transactionId}")
	public ResponseEntity<ActeDeces> getTransactionById(@PathVariable int transactionId) {
		ActeDeces transaction = acte.getActeDecesById(transactionId);

		if (transaction != null) {
			return ResponseEntity.ok(transaction);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
