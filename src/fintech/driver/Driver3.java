package fintech.driver;
import java.util.ArrayList;
import java.util.Scanner;
import fintech.model.*;

/**
 * @author 12S24016 Boy Harendy Simamora
 */

public class Driver3 {

    public static void main(String[] _args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Account> accounts = new ArrayList<>();
        ArrayList<Transaction> Transactions = new ArrayList<>();

        while (sc.hasNext()) {
            String input = sc.nextLine();
            if (input.equals("---")) {
                break;
            }

            String[] parts = input.split("#");
            String command = parts[0];

            if (command.equals("create-account")) {
                String name = parts[1];
                String username = parts[2];
                Account account = new Account(name, username);
                accounts.add(account);
                System.out.println(account.getUsername() + "|" + account.getName() + "|" + account.getBalance());
            

            } else if (command.equals("find-account")) {
                String accountName = parts[1];
                String searchKey = accountName.toLowerCase();
                
                for (Account account : accounts) {
                    if (account.getUsername().toLowerCase().equals(searchKey)) {
                        System.out.println(account.getUsername() + "|" + account.getName() + "|" + account.getBalance());
                        break;
                    }
                }
            }else if (command.equals("create-transaction")) {
                String username = parts[1];
                double amount = Double.parseDouble(parts[2]);
                String timestamp = parts[3];
                String description = parts[4];
                String searchKey = username.toLowerCase();
                for (Account account : accounts) {
                  if (account.getUsername().toLowerCase().equals(searchKey)) {
                      account.addBalance(amount);
                      Transaction transaction = new Transaction(username, amount, timestamp, description);
                      Transactions.add(transaction);
                      break;
                  }
                }
            }
        }
        sc.close();
    }
}       