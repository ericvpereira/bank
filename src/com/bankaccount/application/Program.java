package com.bankaccount.application;

import com.bankaccount.entities.Account;

public class Program {

	public static void main(String[] args) {

		Account c1 = new Account();

		c1.setHolder("Eric");
		c1.setNumber(540831959);
		c1.setBalance(14000.00);

		System.out.println(c1.toString());

	}

}
