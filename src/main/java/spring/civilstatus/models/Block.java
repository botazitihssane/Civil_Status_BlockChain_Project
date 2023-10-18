package spring.civilstatus.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class Block {
	private Long index;
	private Long timestamp;
	private List<Acte> actes;
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

	public List<Acte> getTransactionList() {
		return actes;
	}

	public Block() {
	}

	public Block(Builder builder) {
		this.index = builder.index;
		this.setTimestamp(builder.timestamp);
		this.actes = builder.actes;
		this.proof = builder.proof;
		this.previousBlockHash = builder.previousBlockHash;
	}

	public static class Builder {
		private Long index;
		private Long timestamp;
		private List<Acte> actes;
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

		public Builder data(List<Acte> actes) {
			this.actes = actes;
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

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

}
