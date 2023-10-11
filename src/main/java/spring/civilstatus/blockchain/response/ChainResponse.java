package spring.civilstatus.blockchain.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import spring.civilstatus.blockchain.domain.Block;

public class ChainResponse {
	private Integer length;
	private List<Block> chain;
	public Integer getLength() {
		return length;
	}
	public List<Block> getChain() {
		return chain;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
	public void setChain(List<Block> chain) {
		this.chain = chain;
	}


}
