package structural;
// Old Payment System
class OldPaymentSystem {
    public void makePayment(String amount) {
        System.out.println("Payment of $" + amount + " done using Old System");
    }
}

// New Payment Interface
interface NewPaymentSystem {
    void pay(double amount);
}

// Adapter
class PaymentAdapter implements NewPaymentSystem {
    private OldPaymentSystem oldSystem;
    public PaymentAdapter(OldPaymentSystem oldSystem) { this.oldSystem = oldSystem; }
    public void pay(double amount) {
        oldSystem.makePayment(String.valueOf(amount));
    }
}

public class AdapterPatternDemo {
    public static void main(String[] args) {
        OldPaymentSystem oldSystem = new OldPaymentSystem();
        NewPaymentSystem payment = new PaymentAdapter(oldSystem);
        payment.pay(150.75);
    }
}
