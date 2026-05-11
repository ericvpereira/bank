package com.bankaccount.application;

import java.util.Scanner;

import com.bankaccount.entities.Account;
import com.bankaccount.entities.CheckingAccount;

public class Program {

	private static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int option;

		do {
			showMenu();
			option = readInt("Choose an option: ");

			switch (option) {
			case 1:
				handleCheckingAccount();
				break;

			case 0:
				System.out.println("Exiting...");
				break;

			default:
				System.out.println("Invalid option!");
			}
		} while (option != 0);

		sc.close();

	}

	// ==============MENU===================
	public static void showMenu() {
		System.out.println("1 - Create checking account");
		System.out.println("2 - Create savings account");
		System.out.println("3 - Deposit");
		System.out.println("4 - Withdraw");
		System.out.println("5 - Transfer");
		System.out.println("6 - List accounts");
		System.out.println("7 - See history");
		System.out.println("0 - Exit");
	}

	// =================HANDLERS===============
	public static void handleCheckingAccount() {
		String holder = readString("Enter the holder: ");
		int number = readInt("Enter the number: ");
		double balance = readDouble("Enter the balance: ");
		double overdraft = readDouble("Enter overrdraft limit: ");

		Account account = createCheckingAccount(number, holder, balance, overdraft);

		System.out.println("Account created!");
		System.out.println(account);
	}

	// ==============BUSINESS RULES============
	public static Account createCheckingAccount(int number, String holder, double balance, double overdraft) {
		return new CheckingAccount(number, holder, balance, overdraft);
	}

	// ==============INPUT UTILS===============
	public static int readInt(String message) {
		while (true) {
			try {
				System.out.print(message);
				return Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Invalid number, try again...");
			}
		}
	}

	public static double readDouble(String message) {
		while (true) {
			try {
				System.out.println(message);
				return Double.parseDouble(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Invalid number, try again...");
			}
		}
	}

	public static String readString(String message) {
		System.out.println(message);
		return sc.nextLine();
	}

}
