package application;

import model.entities.Account;
import model.exceptions.DomainException;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        try {
            Locale.setDefault(Locale.US);
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter account data");
            System.out.print("Number: ");
            int number = sc.nextInt();
            System.out.print("Holder: ");
            sc.nextLine();
            String holderName = sc.nextLine();
            System.out.print("Initial balance: ");
            double balance = sc.nextDouble();
            System.out.print("Withdraw limit: ");
            double withdrawLimit = sc.nextDouble();
            Account account = new Account(number, holderName, balance, withdrawLimit);

            System.out.println();
            System.out.print("Enter amount for withdraw: ");
            double withdraw = sc.nextDouble();
            account.withdraw(withdraw);
            System.out.println("New balance: " + String.format("%.2f", account.getBalance()));

            sc.close();
        }
        catch (DomainException e){
            System.out.println("Withdraw error: "+ e.getMessage());
        }
    }
}
