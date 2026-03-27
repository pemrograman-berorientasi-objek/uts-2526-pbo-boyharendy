package fintech.driver;
import fintech.model.*;
import java.util.*;
/**
 * @author 12S24016 Boy Harendy Simamora
 */
public class Driver1 {

    public static void main(String[] _args) {

        Scanner sc = new Scanner(System.in);
        Map<String, Account> accounts = new HashMap<>();

        while (true) {
            String input = sc.nextLine();
            if (input.equals("---")) {
                break;
            }

            String[] parts = input.split("#");

            if (parts[0].equals("create-account")) {
                String name = parts[1];
                String username = parts[2];
                
                Account acc = new Account(name, username);
                accounts.put(username,acc);
            }
            
        }

        for (Account acc : accounts.values()){
            System.out.println(
                acc.getUsername() + "|" +
                acc.getName() + "|" +
                acc.getBalance()
            );
        }

    }

}