package spring.civilstatus.blockchain.response;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import spring.civilstatus.blockchain.domain.Transaction;

public class MineResponse {
	private String message;
	private Long index;
	private List<Transaction> transactions;
	private Long proof;
	private String previousHash;
	public String getMessage() {
		return message;
	}
	public Long getIndex() {
		return index;
	}
	public List<Transaction> getTransactions() {
		return transactions;
	}
	public Long getProof() {
		return proof;
	}
	public String getPreviousHash() {
		return previousHash;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setIndex(Long index) {
		this.index = index;
	}
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	public void setProof(Long proof) {
		this.proof = proof;
	}
	public void setPreviousHash(String previousHash) {
		this.previousHash = previousHash;
	}

	


}
