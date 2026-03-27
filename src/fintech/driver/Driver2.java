package fintech.driver;
import fintech.model.*;
import java.util.*;
/**
 * @author 12S24016 Boy Harendy Simamora
 */
public class Driver2 {
    public static void main(String[] _args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Account> accounts = new HashMap<>();

        while (true) {
            String input = sc.nextLine();
            if (input.equals("---")) break;
            
            String[] parts = input.split("#");
            
            try {
                switch (parts[0]) {
                    case "create-account":
                        accounts.put(parts[2], new Account(parts[1], parts[2]));
                        break;

                    case "deposit":
                        Account accDep = accounts.get(parts[1]);
                        double amountDep = Double.parseDouble(parts[2]);
                        accDep.deposit(amountDep); 
                        break;

                    case "withdraw":
                        Account accWith = accounts.get(parts[1]);
                        double amountWith = Double.parseDouble(parts[2]);
                        boolean success = accWith.withdraw(amountWith);

                        if (!success) {
                            throw new NegativeBalanceException("Saldo tidak cukup");
                        }
                        break;
            
                }
            } catch (NegativeBalanceException e){
            }
        }

        for (Account acc : accounts.values()) {
            System.out.println(
                acc.getUsername() + "|" +
                acc.getName() + "|" +
                acc.getBalance()
            );
        }

        sc.close();
    }
}




        
    



