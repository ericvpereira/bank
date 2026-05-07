package com.bankaccount.entities;

public class CheckingAccount extends Account {

	private Double overdraftLimit;

	public CheckingAccount() {
	}

	public CheckingAccount(Integer number, String holder, Double balance, Double overdraftLimit) {
		super(number, holder, balance);
		this.overdraftLimit = overdraftLimit;
	}

	public Double getOverdraftLimit() {
		return overdraftLimit;
	}

	public void setOverdraftLimit(Double overdraftLimit) {
		this.overdraftLimit = overdraftLimit;
	}

	@Override
	public boolean withdraw(double amount) {

		validateAmount(amount);

		if (amount > (balance + overdraftLimit)) {
			return false;
		}

		balance -= amount;

		return true;
	}

}
