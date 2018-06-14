package java8.data;

public class Account {

    private Person owner;
    private Integer balance;
    public static final int DEFAULT_BALANCE = 1000;

    public Account(Person p, int i) {
		this.owner = p;
		this.balance = i;
	}
    
    public Account(Person p) {
		this.owner = p;
		this.balance = DEFAULT_BALANCE;
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
