import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

public class BillQuery {
    static Scanner scanner = new Scanner(System.in);
    static FileIO fileIO = new FileIO();
    private Apartment apartment = new Apartment(fileIO.getFlatsWithBills());
    private Bill[] bills = fileIO.getBills("HW1-BillingInfo-2018-10-01.csv");;
    private Flat[] flats = fileIO.getFlatsWithoutBills("HW1-ApartmentInfo.csv");


    //Total amount of unpaid bills
    public void amountOfUnpaidBills() {
        int amount = 0;
        for(Bill bill : this.bills) {
            if (!bill.isPaymentInfo()) {
                amount += bill.getAmount();

            }
        }
        System.out.println("The total unpaid bills  of the apartment is " + amount + "$");
    }

    // Total amount of unpaid bills of a certain bill type (to be executed by taking input from Scanner)
    public void amountOfUnpaidBillsAccordingType() {

        System.out.println("What types of unpaid bills do you want to know? (heating,cleaning,water,electric)");
        String input = scanner.nextLine();
        if (!input.equals("heating") && !input.equals("cleaning") && !input.equals("water") && !input.equals("electric")) {
            System.out.println("Please enter a valid type");
        } else {
            int amount = 0;
            for(Bill bill : this.bills) {
                if(input.equals(bill.getType())) {
                    if(!bill.isPaymentInfo()) {
                        amount += bill.getAmount();
                    }


                }
            }
            System.out.println("Total of unpaid " + input  +" bills " + amount + "$");

        }
    }

    //Total bill amount of a certain floor (to be executed by taking input from Scanner)
    public void billAmountOfCertainFloor() {
        System.out.println("Which floor do you want to know the total of the bills?");
        int input = scanner.nextInt();
        int amount = 0;
        if (input <= apartment.getFlats().length) {
            for(Flat flat : apartment.getFlats()[input-1]) {
                ArrayList<Bill> bills = flat.getBills();
                for(Bill bill : bills) {
                    System.out.println(bill.getAmount());
                    amount+= bill.getAmount();
                }
            }
            System.out.println(input + " floor total bill is " + amount );
        } else {
            System.out.println("Please enter valid floor");
        }
    }

    //List of the unpaid bills with the information of the remaining time (in days) before their
    //deadlines
    public void remainingTimeOfUnpaidBills() {
        for(Bill bill : this.bills) {
            if(!bill.isPaymentInfo()) {
                long daysBetween = ChronoUnit.DAYS.between(bill.getLastUpdate(), bill.getPaymentDeadline());
                System.out.println("Remaining time: " + daysBetween);
            }
        }
    }

    // Average total amount of bills of N room flats (N should be taken from Scanner)
    public void averageTotalAmountOfNRoomFlats() {
        System.out.println("Average total amount of bills of N room flats : ");
        int input = scanner.nextInt();
        int counter = 0;
        int totalBill = 0;
        for(int i = 0; i < apartment.getFlats().length; i++) {
            for (int j = 0; j < apartment.getFlats()[i].length; j++) {
                if (input == apartment.getFlats()[i][j].getNumberOfRooms()) {
                    counter++;
                    ArrayList<Bill> bills = apartment.getFlats()[i][j].getBills();
                    for (Bill bill : bills) {
                        totalBill += bill.getAmount();


                    }
                }

            }
        }

        System.out.println("Average bills for " +  input +  " room flats is " + (totalBill/counter));
    }

    //Average total amount of bills of flats with square meter greater than N (N should be taken
    //from Scanner)
    public void averageTotalAmountOfFlatsAccordingSquareMeter() {
        int input = scanner.nextInt();
        System.out.println("Average total amount of bills of flats with square meter greater than N ");
        int counter = 0;
        int totalBill = 0;
        for(int i = 0; i < apartment.getFlats().length; i++) {
            for (int j = 0; j < apartment.getFlats()[i].length; j++) {
                if (input >= apartment.getFlats()[i][j].getSquareMeter()) {
                    counter++;
                    ArrayList<Bill> bills = apartment.getFlats()[i][j].getBills();
                    for (Bill bill : bills) {
                        totalBill += bill.getAmount();
                    }
                }

            }
        }
        System.out.println("Average bills for greater then " +  input +  " m^2 flats is " + (totalBill/counter));
    }

}
