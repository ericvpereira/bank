package com.bankaccount.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Account {

	private Integer number;
	private String holder;
	protected Double balance;

	private List<Transaction> transactions = new ArrayList<>();

	public Account() {
	}

	public Account(Integer number, String holder, Double balance) {
		setNumber(number);
		setHolder(holder);
		setBalance(balance);
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {

		if (number == null || number <= 0) {
			throw new IllegalArgumentException("Invalid account number.");
		}
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {

		if (holder == null || holder.trim().isEmpty()) {
			throw new IllegalArgumentException("Holder cannot be empty");
		}

		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {

		if (balance < 0) {
			throw new IllegalArgumentException("Balance cannot be negative.");
		}

		this.balance = balance;
	}

	public List<Transaction> getTransaction() {
		return transactions;
	}

	public void deposit(double amount) {

		validateAmount(amount);
		balance += amount;
		transactions.add(new Transaction("DEPOSIT", amount));
	}

	public boolean withdraw(double amount) {

		validateAmount(amount);

		if (amount > balance) {
			return false;
		}

		balance -= amount;

		transactions.add(new Transaction("WITHDRAW", amount));

		return true;
	}

	protected void validateAmount(double amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("Amount must be positive.");
		}
	}

	@Override
	public String toString() {
		return "Account [number=" + number + ", holder=" + holder + ", balance=" + balance + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(number, other.number);
	}

}
