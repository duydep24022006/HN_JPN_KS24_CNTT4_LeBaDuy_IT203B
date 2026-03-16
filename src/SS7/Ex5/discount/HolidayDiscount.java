package SS7.Ex5.discount;

public class HolidayDiscount implements DiscountStrategy {

    public double apply(double amount){
        return amount*0.85;
    }
}
