package spring.civilstatus.blockchain.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import spring.civilstatus.blockchain.domain.Acte;
import spring.civilstatus.blockchain.domain.ActeNaissance;
import spring.civilstatus.blockchain.domain.Block;
import spring.civilstatus.blockchain.util.BlockProofOfWorkGenerator;
@Service
public class ActeNaissanceService {
	private List<Block> chain;
	private List<Acte> currentTransactions;

	@Autowired
	private ObjectMapper mapper;
	
	 @Autowired
	 public ActeNaissanceService(ObjectMapper mapper) {
	        this.chain = new ArrayList<>();
	        this.currentTransactions = new ArrayList<>();
	        try {
				createBlock(Block.GENESIS_BLOCK_PROOF, Block.GENESIS_BLOCK_PREV_HASH);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
	 }
	 
	public void Blockchain() throws JsonProcessingException {
		chain = new ArrayList<>();
		currentTransactions = new ArrayList<>();
		createBlock(Block.GENESIS_BLOCK_PROOF, Block.GENESIS_BLOCK_PREV_HASH);
	}

	public Long addTransaction(int id, String typeEnregistrement, LocalDate dateEnregistrement, String lieuEnregistrement, String nouveauNe, String typeNaissance, String declarant , String relationAvecNouveauNe) {
		ActeNaissance acte = new ActeNaissance(id,typeEnregistrement, dateEnregistrement,lieuEnregistrement, nouveauNe,typeNaissance,declarant,relationAvecNouveauNe);
		currentTransactions.add(acte);
		return lastBlock().getIndex() + 1L;
	}

	public Block createBlock(Long proof, String previusHash) throws JsonProcessingException {
		Block block = new Block.Builder().index(chain.size() + 1L)
				.previousBlockHash((previusHash != null) ? previusHash : lastBlock().hash(mapper)).proof(proof)
				.timestamp(new Date().getTime()).data(currentTransactions).build();

		this.chain.add(block);
		this.currentTransactions = new ArrayList<>();
		return block;
	}

	public Block lastBlock() {
		return chain.get(this.chain.size() - 1);
	}

	public static boolean validChain(List<Block> chain, ObjectMapper mapper) throws JsonProcessingException {
		if (chain == null || chain.isEmpty())
			return false;
		Block lastBlock = chain.get(0);
		for (int currentIndex = 1; currentIndex < chain.size(); currentIndex++) {
			Block currentBlock = chain.get(currentIndex);
			// log.debug("lastBlock={}", lastBlock);
			// log.debug("currentBlock={}", currentBlock);
			if (!currentBlock.getPreviousBlockHash().equals(lastBlock.hash(mapper))) {
				return false;
			}
			if (!BlockProofOfWorkGenerator.validProof(lastBlock.getProof(), currentBlock.getProof())) {
				return false;
			}
			lastBlock = currentBlock;
		}
		return true;
	}

	public boolean validChain() throws JsonProcessingException {
		return validChain(chain, mapper);
	}

	public List<Block> getChain() {
		return chain;
	}

	public void setChain(List<Block> chain) {
		this.chain = chain;
	}

	public List<Acte> getCurrentTransactions() {
		return currentTransactions;
	}

	public void setCurrentTransactions(List<Acte> currentTransactions) {
		this.currentTransactions = currentTransactions;
	}

	public ObjectMapper getMapper() {
		return mapper;
	}

	public void setMapper(ObjectMapper mapper) {
		this.mapper = mapper;
	}
	
	
}
