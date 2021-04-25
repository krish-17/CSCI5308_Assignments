import operations.receive.*;
import operations.ship.*;
import workers.humanresources.*;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    private static final String SHIP = "SHIP";
    private static final String RECEIVE = "RECEIVE";
    private static HumanResourcesAPI humanResourcesAPI;
    private static ReceivingAPI receivingAPI;
    private static ShippingAPI shippingAPI;

    public static void main(String[] args) {
        System.out.println("Welcome to the warehouse!");
        initialize();
        try {
            String currentDIR = new java.io.File(".").getCanonicalPath();
            System.out.println("Current directory:" + currentDIR);
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            String line = reader.readLine();
            while (line != null) {
                if (line.length() > 0)
                    executeInstruction(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Error working with filesystem: " + e.getMessage());
        }
        System.out.println("Human resources reports " + humanResourcesAPI.getTotalMinutesWorked() + " minutes worked.");
    }

    private static void initialize() {
        humanResourcesAPI = new HumanResources();
        shippingAPI = new Shipping(humanResourcesAPI);
        receivingAPI = new Receiving(humanResourcesAPI);
    }

    private static void executeInstruction(String line) {
        String[] parts = line.split(" ");
        if (parts[0].equals(RECEIVE)) {
            receivingAPI.receive(parts[1], Integer.parseInt(parts[2]));
        }
        if (parts[0].equals(SHIP)) {
            shippingAPI.ship(parts[1], parts[2], Integer.parseInt(parts[3]));
        }
    }
}
