package java8.data;

public class Account {

    private Person owner;
    private Integer balance;
    public final static int DEFAULT_SOLDE = 100;
    
    public Account(Person owner) {
    	this.owner = owner;
    	this.balance =  DEFAULT_SOLDE;
    }
    
    public Account(Person owner, int solde) {
    	this.owner = owner;
    	this.balance = solde;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }
}
