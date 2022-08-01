package io.fall;

import java.util.Scanner;

import io.fall.models.Account;
import io.fall.services.AccountUtils;


public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        AccountUtils accountUtils = AccountUtils.getInstance();
        
        while (true) {
            System.out.println("\n----------x-x-x-x----------");
                System.out.println("1. Add Account");
                System.out.println("2. Display an Account");
                System.out.println("3. Display All Accounts");
                System.out.println("4. Remove an Account by email");
                System.out.println("5. withdraw");
                System.out.println("6. deposit");
                System.out.println("7. transfer");
                System.out.println("8. search account using name");
                System.out.println("9. search account using email");
                System.out.println("10. search account using phone");
                System.out.println("11. Exit");
            System.out.println("----------------------");

            System.out.print("Enter your choice: ");

            int choice = 0;
            Account foundResults;

            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid choice");
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 11:
                    System.out.println("Exiting from application... Have a great day!");
                    scanner.close();
                    System.exit(0);
                case 1:
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter your email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter your phone: ");
                    String phone = scanner.nextLine();
                    Account account = new Account(name, email, phone);
                    accountUtils.addAccount(account);
                    break;
                case 2:
                    System.out.print("Enter your account number: ");
                    int accountNumber = scanner.nextInt();
                    accountUtils.displayAccount(accountNumber);
                    break;
                case 3:
                    accountUtils.displayAllAccounts();
                    break;
                case 4:
                    System.out.print("Enter your email: ");
                    String accountWithEmailToRemove = scanner.nextLine();
                    accountUtils.removeAccountByEmail(accountWithEmailToRemove);
                    break;
                case 5:
                    System.out.print("Enter your account number: ");
                    int accountNumberToWithdraw = scanner.nextInt();
                    System.out.print("Enter the amount to withdraw: ");
                    double amountToWithdraw = scanner.nextDouble();
                    accountUtils.withdrawMoney(accountNumberToWithdraw, amountToWithdraw);
                    break;
                case 6:
                    System.out.print("Enter your account number: ");
                    int accountNumberToDeposit = scanner.nextInt();
                    System.out.print("Enter the amount to deposit: ");
                    double amountToDeposit = scanner.nextDouble();
                    accountUtils.depositMoney(accountNumberToDeposit, amountToDeposit);
                    break;
                case 7:
                    System.out.print("Enter your account number: ");
                    int accountNumberToTransferFrom = scanner.nextInt();
                    System.out.print("Enter the amount to transfer: ");
                    double amountToTransfer = scanner.nextDouble();
                    System.out.print("Enter the account number to transfer to: ");
                    int accountNumberToTransferTo = scanner.nextInt();
                    accountUtils.transferMoney(accountNumberToTransferFrom, accountNumberToTransferTo, amountToTransfer);
                    break;
                case 8:
                    System.out.print("Enter your name: ");
                    String nameToSearch = scanner.nextLine();
                    foundResults = accountUtils.searchAccountByName(nameToSearch);
                    if(foundResults != null)
                        {
                            System.out.println("Result found...");
                            System.out.println(foundResults);
                        }
                    break;
                case 9:
                    System.out.print("Enter your email: ");
                    String emailToSearch = scanner.nextLine();
                    foundResults = accountUtils.searchAccountByEmail(emailToSearch);
                    if(foundResults != null)
                        {
                            System.out.println("Result found...");
                            System.out.println(foundResults);
                        }
                    break;
                case 10:
                    System.out.print("Enter your phone: ");
                    String phoneToSearch = scanner.nextLine();
                    foundResults = accountUtils.searchAccountByPhone(phoneToSearch);
                    if(foundResults != null)
                        {
                            System.out.println("Result found...");
                            System.out.println(foundResults);
                        }
                    break;
                default:
                    System.out.println(choice + " is not a valid choice");
                    break;
            }
        }
    }
}
