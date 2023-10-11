package spring.civilstatus.blockchain.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class Block {
	private Long index;
	private Long timestamp;
	private List<Transaction> data;
	private Long proof;
	private String previousBlockHash;
	public static final Long GENESIS_BLOCK_PROOF = 100L;
	public static final String GENESIS_BLOCK_PREV_HASH = "1";

	public Long getIndex() {
		return index;
	}

	public String getPreviousBlockHash() {
		return previousBlockHash;
	}

	public Long getProof() {
		return proof;
	}

	public List<Transaction> getTransactionList() {
		return data;
	}

	public Block() {
	}

	public Block(Builder builder) {
		this.index = builder.index;
		this.timestamp = builder.timestamp;
		this.data = builder.data;
		this.proof = builder.proof;
		this.previousBlockHash = builder.previousBlockHash;
	}

	public static class Builder {
		private Long index;
		private Long timestamp;
		private List<Transaction> data;
		private Long proof;
		private String previousBlockHash;

		public Builder index(Long index) {
			this.index = index;
			return this;
		}

		public Builder timestamp(Long timestamp) {
			this.timestamp = timestamp;
			return this;
		}

		public Builder data(List<Transaction> data) {
			this.data = data;
			return this;
		}

		public Builder proof(Long proof) {
			this.proof = proof;
			return this;
		}

		public Builder previousBlockHash(String previousBlockHash) {
			this.previousBlockHash = previousBlockHash;
			return this;
		}

		public Block build() {
			return new Block(this);
		}
	}

	public String hash(ObjectMapper mapper) throws JsonProcessingException {
		String json = mapper.writeValueAsString(this);
		return Hashing.sha256().hashString(json, StandardCharsets.UTF_8).toString();
	}

}