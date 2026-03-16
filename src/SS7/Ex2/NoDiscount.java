package SS7.Ex2;

public class NoDiscount implements DiscountStrategy {

    @Override
    public double applyDiscount(double totalAmount) {
        return totalAmount;
    }
}
