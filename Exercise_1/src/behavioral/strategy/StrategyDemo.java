
public class StrategyDemo {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        context.setPaymentStrategy(new CreditCardStrategy("1234-5678-9876-5432"));
        context.pay(100);

        context.setPaymentStrategy(new PayPalStrategy("user@example.com"));
        context.pay(200);
    }
}
