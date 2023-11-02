package KZP_Lab2_Cholaniuk;
import KZP_Lab2_Cholaniuk.AlpinistsEquipment;
import java.io.*;
public class AlpinistsEquipmentApp {

    public static void main(String[] args) throws FileNotFoundException {
        // Create instances of AlpinistsEquipment to test different constructors
        AlpinistsEquipment gear1 = new AlpinistsEquipment("Climbing Rope", 2500, "High-quality climbing rope for alpinists", 150);
        AlpinistsEquipment gear2 = new AlpinistsEquipment("Carabiner", 100, "Durable carabiner for safety", 20);
        AlpinistsEquipment gear3 = new AlpinistsEquipment("Crampons", 1800, "Spiked boots for ice climbing");

        // Inspect the equipment
        gear1.inspect();
        gear2.inspect();
        gear3.inspect();

        // Use the equipment
        gear1.use();
        gear2.use();

        // Log equipment details to a file
        String path = "equipment_log.txt";
        gear1.logItemToFile(path);
        gear2.logItemToFile(path);
        gear3.logItemToFile(path);
    }


}

