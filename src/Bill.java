import java.time.LocalDate;

public class Bill {
    private int billID;
    private int flatID;
    private double amount;

    private String type;

    private boolean paymentInfo;

    private LocalDate paymentDeadline;
    private LocalDate lastUpdate;

    public Bill(int billID, int flatID, double amount, String type, boolean paymentInfo, LocalDate paymentDeadline, LocalDate lastUpdate) {
        this.billID = billID;
        this.flatID = flatID;
        this.amount = amount;
        this.type = type;
        this.paymentInfo = paymentInfo;
        this.paymentDeadline = paymentDeadline;
        this.lastUpdate = lastUpdate;
    }

    public int getBillID() {
        return billID;
    }

    public void setBillID(int billID) {
        this.billID = billID;
    }

    public int getFlatID() {
        return flatID;
    }

    public void setFlatID(int flatID) {
        this.flatID = flatID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(boolean paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public LocalDate getPaymentDeadline() {
        return paymentDeadline;
    }

    public void setPaymentDeadline(LocalDate paymentDeadline) {
        this.paymentDeadline = paymentDeadline;
    }

    public LocalDate getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDate lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
