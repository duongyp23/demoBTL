package sample;

import java.util.ArrayList;

public class ManageAccount {
    static ArrayList<Account> manageAccount = new ArrayList<Account>();
    public static void addAccount(Account a){
        manageAccount.add(a);
    }
}
