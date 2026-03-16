package SS7.Ex3;

public class Main {

    public static void main(String[] args) {

        PaymentProcessor processor = new PaymentProcessor();

        CODPayable cod = new CODPayment();
        processor.processCOD(cod, 500000);

        CardPayable card = new CreditCardPayment();
        processor.processCard(card, 1000000);

        EWalletPayable momo = new MomoPayment();
        processor.processEWallet(momo, 750000);

        System.out.println("\nKiểm tra LSP:");

        EWalletPayable wallet = new MomoPayment();
        processor.processEWallet(wallet, 300000);

    }
}
