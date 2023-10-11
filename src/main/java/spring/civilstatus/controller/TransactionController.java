package spring.civilstatus.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.validation.Valid;
import spring.civilstatus.blockchain.domain.Block;
import spring.civilstatus.blockchain.domain.Transaction;
import spring.civilstatus.blockchain.response.ChainResponse;
import spring.civilstatus.blockchain.response.MineResponse;
import spring.civilstatus.blockchain.response.TransactionResponse;
import spring.civilstatus.blockchain.service.BlockChain;
import spring.civilstatus.blockchain.util.BlockProofOfWorkGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.UUID;

@RestController
@RequestMapping("/")

public class TransactionController {

	@Autowired
	private BlockChain blockchain;

	@Autowired
	private ObjectMapper objectMapper;

	public static final String NODE_ID = UUID.randomUUID().toString().replace("-", "");
	public static final String NODE_ACCOUNT_ADDRESS = "0";
	public static final BigDecimal MINING_CASH_REWARDS = BigDecimal.ONE;

	@GetMapping("mine")
	public MineResponse mine() throws JsonProcessingException {
		// Calculate Proof of work
		Block lastBlock = blockchain.lastBlock();
		Long lastProof = lastBlock.getProof();
		Long proof = BlockProofOfWorkGenerator.proofOfWork(lastProof);
		// Reward the miner by adding a transaction

		blockchain.addTransaction(NODE_ACCOUNT_ADDRESS, NODE_ID, MINING_CASH_REWARDS);

		// Add the new block to the chain
		Block newBlock = blockchain.createBlock(proof, lastBlock.hash(objectMapper));

		 MineResponse mineResponse = new MineResponse();
		    mineResponse.setMessage("New Block Added");
		    mineResponse.setIndex(newBlock.getIndex());
		    mineResponse.setTransactions(newBlock.getTransactionList());
		    mineResponse.setProof(newBlock.getProof());
		    mineResponse.setPreviousHash(newBlock.getPreviousBlockHash());

		    return mineResponse;}

	@GetMapping("chain")
	public ChainResponse fullChain() {
	    ChainResponse chainResponse = new ChainResponse();
	    chainResponse.setChain(blockchain.getChain());
	    chainResponse.setLength(blockchain.getChain().size());
	    return chainResponse;
	}

	@PostMapping("transactions")
	public TransactionResponse newTransaction(@RequestBody @Valid Transaction transaction) {
	    Long index = blockchain.addTransaction(transaction.getSender(), transaction.getRecipient(), transaction.getAmount());
	    
	    TransactionResponse transactionResponse = new TransactionResponse();
	    transactionResponse.setIndex(index);
	    
	    return transactionResponse;
	}

}
