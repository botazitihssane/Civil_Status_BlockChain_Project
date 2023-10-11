package spring.civilstatus.blockchain.domain;

import java.math.BigDecimal;

public class Transaction {
	private String sender;
	private String recipient;
	private BigDecimal amount;

	public static TransactionBuilder builder() {
		return new TransactionBuilder();
	}

	public String getSender() {
		return sender;
	}

	public String getRecipient() {
		return recipient;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public static class TransactionBuilder {
		private String sender;
		private String recipient;
		private BigDecimal amount;

		public TransactionBuilder sender(String sender) {
			this.sender = sender;
			return this;
		}

		public TransactionBuilder recipient(String recipient) {
			this.recipient = recipient;
			return this;
		}

		public TransactionBuilder amount(BigDecimal amount) {
			this.amount = amount;
			return this;
		}

		public Transaction build() {
			Transaction transaction = new Transaction();
			transaction.sender = sender;
			transaction.recipient = recipient;
			transaction.amount = amount;
			return transaction;
		}
	}
}