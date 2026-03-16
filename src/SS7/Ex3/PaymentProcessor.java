package SS7.Ex3;

public class PaymentProcessor {

    public void processCOD(CODPayable payment, double amount) {
        payment.processCOD(amount);
    }

    public void processCard(CardPayable payment, double amount) {
        payment.processCard(amount);
    }

    public void processEWallet(EWalletPayable payment, double amount) {
        payment.processEWallet(amount);
    }
}
