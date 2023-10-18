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
import spring.civilstatus.models.ActeMariage;
import spring.civilstatus.models.Block;
import spring.civilstatus.service.impl.ActeMariageService;

@RestController
@RequestMapping("/api/actes/mariage")
public class ActeMariageController {
	@Autowired
	private ActeMariageService acte;

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
	public TransactionResponse newTransaction(@RequestBody @Valid ActeMariage acteMariage) {
		Long index = acte.addTransaction(acteMariage.getId(), acteMariage.getTypeEnregistrement(),
				acteMariage.getDateEnregistrement(), acteMariage.getLieuEnregistrement(), acteMariage.getLieuMariage(),
				acteMariage.getOfficierValidant(), acteMariage.getRegistre(), acteMariage.getDateMariage(),
				acteMariage.getEpouse(), acteMariage.getEpoux(), acteMariage.getMereEpouse(),
				acteMariage.getPereEpouse(), acteMariage.getMereEpoux(), acteMariage.getPereEpoux(),
				acteMariage.getCinEpouse(), acteMariage.getCinEpoux(), acteMariage.getDateNaissanceEpouse(),
				acteMariage.getDateNaissanceEpoux(),acteMariage.getLieuNaissanceEpouse(),acteMariage.getLieuNaissanceEpoux());
		TransactionResponse transactionResponse = new TransactionResponse();
		transactionResponse.setIndex(index);
		return transactionResponse;
	}

	@GetMapping("/transactions/id/{transactionId}")
	public ResponseEntity<ActeMariage> getTransactionById(@PathVariable int transactionId) {
		ActeMariage transaction = acte.getActeMariageById(transactionId);

		if (transaction != null) {
			return ResponseEntity.ok(transaction);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
