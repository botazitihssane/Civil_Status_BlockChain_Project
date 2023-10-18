package spring.civilstatus.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import spring.civilstatus.blockchain.response.ChainResponse;
import spring.civilstatus.blockchain.response.MineResponse;
import spring.civilstatus.blockchain.response.TransactionResponse;
import spring.civilstatus.blockchain.util.BlockProofOfWorkGenerator;
import spring.civilstatus.models.ActeNaissance;
import spring.civilstatus.models.Block;
import spring.civilstatus.service.impl.ActeNaissanceService;

@RestController
@RequestMapping("/api/actes/naissance")
public class ActeNaissanceController {

	@Autowired
	private ActeNaissanceService acte;

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
	public TransactionResponse newTransaction(@RequestBody @Valid ActeNaissance acteNaissance) {
		Long index = acte.addTransaction(acteNaissance.getId(), acteNaissance.getTypeEnregistrement(),
				acteNaissance.getDateEnregistrement(), acteNaissance.getLieuEnregistrement(),
				acteNaissance.getOfficierValidant(), acteNaissance.getRegistre(), acteNaissance.getNom(), acteNaissance.getPrenom(),
				acteNaissance.getTypeNaissance(), acteNaissance.getDeclarant(),
				acteNaissance.getRelationAvecNouveauNe(),acteNaissance.getPere(),acteNaissance.getMere(),
				acteNaissance.getSexe(),acteNaissance.getNationalite(),acteNaissance.getDateNaissance(),acteNaissance.getLieuNaissance());
		TransactionResponse transactionResponse = new TransactionResponse();
		transactionResponse.setIndex(index);
		return transactionResponse;
	}

	@GetMapping("/transactions/id/{transactionId}")
	public ResponseEntity<ActeNaissance> getTransactionById(@PathVariable int transactionId) {
		ActeNaissance transaction = acte.getActeById(transactionId);

		if (transaction != null) {
			return ResponseEntity.ok(transaction);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
