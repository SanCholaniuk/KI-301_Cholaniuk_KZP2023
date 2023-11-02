package KZP.Lab3.Cholaniuk;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Main {
    private String item;
    private double weight;
    private String description;
    private double price;
    private static final String LOG_FILE_NAME = "gear_log.txt";

    public Main(String itemName, double weight, String description, double price) {
        this.item = itemName;
        this.weight = weight;
        this.description = description;
        this.price = price;
    }

    public Main(String itemName, double weight, String description) {
        this.item = itemName;
        this.weight = weight;
        this.description = description;
    }

    public Main(String itemName, double weight) {
        this.item = itemName;
        this.weight = weight;
    }

    public void setItemName(String itemName) {this.item = itemName;}

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

        try (FileWriter writer = new FileWriter(LOG_FILE_NAME, true)) {
            writer.write(logMessage + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void logItemToFile(String filename) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(filename, true);
            writer.write("Назва: " + item + "\n");
            writer.write("Вага: " + weight + " g\n");
            writer.write("Ціна: $" + price + "\n");
            writer.write("Опис: " + description + "\n\n");
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
        logToFile("Зареєстрований елемент обладнання: " + item);
    }

    public void use() {
        System.out.println("\nВи використовуєте предмет обладнання: " + item);
        System.out.println(item + "Вага " + weight + " gram(s)");
        System.out.println(item + " Ціна $" + price);
        System.out.println(item + " Має такий опис: " + description);
        logToFile("Елемент обладнання, що використовується: " + item);
    }

    public void inspect() {
        System.out.println("\nОгляд обладнання:");

        System.out.println("Назва: " + item);
        System.out.println("Вага: " + weight + " g");
        System.out.println("Ціна: $" + price);
        System.out.println("Опис: " + description);

        if (weight >= 2000) {
            System.out.println("Це спорядження досить важке.");
        } else if (weight < 2000 && weight > 500) {
            System.out.println("Це спорядження не досить важке.");
        } else {
            System.out.println("Це легке спорядження, ідеальне для тривалих походів.");
        }

        if(price == 0){
            System.out.println("Це обладнання ви отримали безкоштовно.");
        }
        else if (price > 600) {
            System.out.println("Це обладнання досить дороге.");
        } else if (price <= 600 && price > 200) {
            System.out.println("Коштує таке обладнання не надто дорого.");
        } else {
            System.out.println("Це обладнання доступне за нижчою ціною.");
        }

        if (description.contains("захист від дощу")) {
            System.out.println("Це обладнання чудово захищає від дощу.");
        }
        if (description.contains("для безпеки")) {
            System.out.println("Це обладнання ідеально підходить для безпеки.");
        }
        if (description.contains("легко переносити")) {
            System.out.println("Це компактне обладнання, яке зручно носити з собою.");
        }
        if (description.contains("високоякісні матеріали")) {
            System.out.println("Дане обладнання відрізняється високою якістю і надійністю.");
        }
        logToFile("Оглянуте обладнання: " + item);
    }
}
