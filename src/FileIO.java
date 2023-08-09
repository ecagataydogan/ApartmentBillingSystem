import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

public class FileIO {
    public Flat[][] getFlatsWithBills() {
        FileIO fileIO = new FileIO();
        Flat[] flats = fileIO.getFlatsWithoutBills("HW1-ApartmentInfo.csv");
        Bill[] bills = fileIO.getBills("HW1-BillingInfo-2018-10-01.csv");
        fileIO.addBillsToFlats(bills,flats);

        int totalFloor = 0;
        for (Flat flat : flats) {
            if (flat.getFloorNumber() > totalFloor) {
                totalFloor = flat.getFloorNumber();
            }

        }
        int totalFlat = 0;
        for (Flat flat : flats ) {
            if (flat.getFloorNumber() == 1) {
                totalFlat++;
            }
        }

        Flat[][] apartmentFlats = new Flat[totalFloor][totalFlat];

        for (Flat flat : flats) {
            apartmentFlats[flat.getFloorNumber()-1][flat.getFlatNumber()-1] = flat;
        }
        return apartmentFlats;

    }

    public void addBillsToFlats(Bill[] bills , Flat[] flats) {
        for (Bill bill : bills) {
            for (Flat flat : flats) {
                if(bill.getFlatID() == flat.getFlatID()) {
                    flat.addBill(bill);
                }
            }
        }

    }
    public Flat[] getFlatsWithoutBills(String fileName) {
        try {
            Scanner scanner = new Scanner(new File(fileName));
            Flat[] allFlats = new Flat[6];
            int index = 0;
            while (scanner.hasNextLine()) {

                String info = scanner.nextLine();
                String[] infoArr = info.split(",");
                int flatID = Integer.parseInt(infoArr[0]);
                int floorNumber = Integer.parseInt(infoArr[1]);
                int flatNumber = Integer.parseInt(infoArr[2]);
                int numberOfRooms = Integer.parseInt(infoArr[3]);
                int squareMeter = Integer.parseInt(infoArr[4]);
                Flat flat = new Flat(flatID,floorNumber,flatNumber,numberOfRooms,squareMeter);
                allFlats[index] = flat;
                index++;

            }
            return allFlats;


        } catch (FileNotFoundException e ) {
            System.out.println("There is no file");
            return null;
        }

    }


    public Bill[] getBills(String fileName) {
        try {
            Scanner scanner = new Scanner (new File(fileName));
            Bill[] bills = new Bill[12];
            int index = 0;
            while(scanner.hasNextLine()) {
                String billInfo = scanner.nextLine();
                String[] billInfoArr = billInfo.split(",");
                int billID = Integer.parseInt(billInfoArr[0]);
                int flatID = Integer.parseInt(billInfoArr[1]);
                double amount = Double.parseDouble(billInfoArr[2]);
                String type = billInfoArr[3];
                boolean paymentInfo = Boolean.parseBoolean(billInfoArr[4]);

                String[] deadlineArr = billInfoArr[5].split("-");
                LocalDate paymentDeadline = LocalDate.of(Integer.parseInt(deadlineArr[0]),Integer.parseInt(deadlineArr[1]),Integer.parseInt(deadlineArr[2]));

                String[] lastUpdateArr = billInfoArr[6].split("-");
                LocalDate lastUpdate = LocalDate.of(Integer.parseInt(lastUpdateArr[0]),Integer.parseInt(lastUpdateArr[1]),Integer.parseInt(lastUpdateArr[2]));

                Bill bill = new Bill(billID,flatID,amount,type,paymentInfo,paymentDeadline,lastUpdate);
                bills[index] = bill;
                index++;

            }
            return bills;

        }catch (FileNotFoundException e) {
            System.out.println("File not found");
            return null;
        }
    }


}
