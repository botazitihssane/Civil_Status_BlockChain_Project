package spring.civilstatus.service;

import com.fasterxml.jackson.core.JsonProcessingException;

import spring.civilstatus.blockchain.response.ChainResponse;
import spring.civilstatus.blockchain.response.MineResponse;
import spring.civilstatus.blockchain.response.TransactionResponse;
import spring.civilstatus.models.Acte;

public interface ActeService {
	MineResponse mine() throws JsonProcessingException;

	ChainResponse fullChain();

	TransactionResponse addTransaction(Acte acte);

	Acte getActeById(int transactionId);
	
	Acte getActeByCIN(String cin);
}
