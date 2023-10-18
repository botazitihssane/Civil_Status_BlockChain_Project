package spring.civilstatus.blockchain.response;

import java.util.List;

import spring.civilstatus.models.Acte;

public class MineResponse {
	private String message;
	private Long index;
	private List<Acte> actes;
	private Long proof;
	private String previousHash;
	public String getMessage() {
		return message;
	}
	public Long getIndex() {
		return index;
	}
	public List<Acte> getTransactions() {
		return actes;
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
	public void setTransactions(List<Acte> actes) {
		this.actes = actes;
	}
	public void setProof(Long proof) {
		this.proof = proof;
	}
	public void setPreviousHash(String previousHash) {
		this.previousHash = previousHash;
	}

	


}
