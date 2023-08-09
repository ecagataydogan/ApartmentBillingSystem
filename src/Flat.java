import java.util.ArrayList;

public class Flat {
    private int flatID;
    private int floorNumber;
    private int flatNumber;
    private int numberOfRooms;
    private int squareMeter;
    private ArrayList<Bill> bills = new ArrayList<Bill>();

    public Flat(int flatID, int floorNumber, int flatNumber, int numberOfRooms, int squareMeter) {
        this.flatID = flatID;
        this.floorNumber = floorNumber;
        this.flatNumber = flatNumber;
        this.numberOfRooms = numberOfRooms;
        this.squareMeter = squareMeter;
    }

    public void setFlatID(int flatID) {
        this.flatID = flatID;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public int getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(int flatNumber) {
        this.flatNumber = flatNumber;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public int getSquareMeter() {
        return squareMeter;
    }

    public void setSquareMeter(int squareMeter) {
        this.squareMeter = squareMeter;
    }

    public ArrayList<Bill> getBills() {
        return bills;
    }

    public void setBills(ArrayList<Bill> bills) {
        this.bills = bills;
    }

    public int getFlatID() {
        return flatID;
    }

    public void addBill(Bill bill) {
        this.bills.add(bill);
    }
}
