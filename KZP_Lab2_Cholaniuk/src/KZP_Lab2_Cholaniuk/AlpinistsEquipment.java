package KZP_Lab2_Cholaniuk;

import java.io.*;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AlpinistsEquipment {
    //Fields
    private String item;
    private double weight;
    private String description;
    private double price;
    private static final String LOG_File_Name="gearLog.txt";

    public AlpinistsEquipment(String item, double weight, String description, double price) {
        this.item = item;
        this.weight = weight;
        this.description = description;
        this.price = price;
    }

    public AlpinistsEquipment(String item, double weight, String description) {
        this.item = item;
        this.weight = weight;
        this.description = description;
    }

    public AlpinistsEquipment(String item, double weight) {
        this.item = item;
        this.weight = weight;
    }

    public String getItemName() {
        return item;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    private void logToFile(String message) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = dateFormat.format(new Date());

        String logMessage = "[" + timestamp + "] " + message;

        try (FileWriter writer = new FileWriter(LOG_File_Name, true)) {
            writer.write(logMessage + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void logItemToFile(String filename) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(filename, true);
            writer.write("Name: " + item + "\n");
            writer.write("Weight: " + weight + " g\n");
            writer.write("Price: $" + price + "\n");
            writer.write("Description: " + description + "\n\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        logToFile("Logged equipment item: " + item);

    }

    public void use() {
        System.out.println("\nYou use an item of equipment: " + item);
        System.out.println("The " + item + " weighs " + weight + " gram(s)");
        System.out.println("The " + item + " costs $" + price);
        System.out.println("The " + item + " has the following description: " + description);
        logToFile("Equipment item used: " + item);
    }

    public void inspect() {
        System.out.println("\nEquipment Overview:");

        System.out.println("Name: " + item);
        System.out.println("Weight: " + weight + " g");
        System.out.println("Price: $" + price);
        System.out.println("Description: " + description);

        if (weight >= 2000) {
            System.out.println("This gear is quite heavy.");
        } else if (weight < 2000 && weight > 500) {
            System.out.println("This equipment is not too heavy.");
        } else {
            System.out.println("This is light equipment, ideal for long hikes.");
        }

        if(price == 0){
            System.out.println("This equipment you got for free.");
        }
        else if (price > 600) {
            System.out.println("This equipment is quite expensive.");
        } else if (price <= 600 && price > 200) {
            System.out.println("This equipment is not too expensive.");
        } else {
            System.out.println("This equipment is available at a lower price.");
        }

        if (description.contains("rain protection")) {
            System.out.println("This equipment provides excellent protection against rain.");
        }
        if (description.contains("for safety")) {
            System.out.println("This equipment is perfect for safety.");
        }
        if (description.contains("easy to carry")) {
            System.out.println("This is compact equipment that is convenient to carry.");
        }
        if (description.contains("high-quality materials")) {
            System.out.println("This equipment is of very high quality and reliability.");
        }
        logToFile("Inspected equipment: " + item);
    }
}


