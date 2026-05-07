package com.bankaccount.entities;

import java.time.LocalDateTime;

public class Transaction {

	private String type;
	private Double amount;
	private LocalDateTime date;

	public Transaction() {
	}

	public Transaction(String type, Double amount) {
		this.type = type;
		this.amount = amount;
		this.date = LocalDateTime.now();
	}

	public String getType() {
		return type;
	}

	public Double getAmount() {
		return amount;
	}

	public LocalDateTime getDate() {
		return date;
	}

	@Override
	public String toString() {
		return "Transaction [type=" + type + ", amount=" + amount + ", date=" + date + "]";
	}

}
