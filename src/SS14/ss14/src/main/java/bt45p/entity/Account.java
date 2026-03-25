package bt45p.entity;

public class Account {
    private String accountId;
    private String fullName ;
    private Double balance;

    public Account() {
    }

    public Account(String accountId, String fullName, Double blence) {
        this.accountId = accountId;
        this.fullName = fullName;
        this.balance = blence;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double blence) {
        this.balance = blence;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId='" + accountId + '\'' +
                ", fullName='" + fullName + '\'' +
                ", blence=" + balance +
                '}';
    }
}
