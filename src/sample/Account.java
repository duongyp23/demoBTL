package sample;

public class Account {
    public String account;
    public String password;
    Account(){}
    Account(String account, String password){
        this.account=account;
        this.password=password;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

}
