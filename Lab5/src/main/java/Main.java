import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        Smartphone[] smartphones =  new Smartphone[]{
                new Smartphone.SmartphoneBuilder()
                        .setManufacturer("Google")
                        .setName("Pixel 4a")
                        .setStorage(128)
                        .setRam(6)
                        .CreateInstance(),

                new Smartphone.SmartphoneBuilder()
                        .setManufacturer("Google")
                        .setName("Pixel 5")
                        .setStorage(128)
                        .setRam(8)
                        .CreateInstance(),

                new Smartphone.SmartphoneBuilder()
                        .setManufacturer("Samsung")
                        .setName("Galaxy S21")
                        .setStorage(256)
                        .setRam(8)
                        .CreateInstance()
        };
        Laptop[] laptops = new Laptop[] {
                new Laptop.LaptopBuilder()
                        .setManufacturer("Asus")
                        .setName("ROG Strix")
                        .setHdd(1024)
                        .setRam(32)
                        .CreateInstance(),

                new Laptop.LaptopBuilder()
                        .setManufacturer("HP")
                        .setName("Omen")
                        .setHdd(512)
                        .setRam(16)
                        .CreateInstance()
        };
        DataBaseConnector connector = new DataBaseConnector();
        connector.executeSQL("CREATE TABLE Smartphones (" +
                "Id INT IDENTITY(1,1) PRIMARY KEY, " +
                "Manufacturer NVARCHAR(30) NOT NULL, " +
                "Name NVARCHAR(30) NOT NULL, " +
                "Storage INT NOT NULL, " +
                "Ram INT NOT NULL);");

        connector.executeSQL("CREATE TABLE Laptops (" +
                "Id INT IDENTITY(1,1) PRIMARY KEY, " +
                "Manufacturer NVARCHAR(30) NOT NULL, " +
                "Name NVARCHAR(30) NOT NULL, " +
                "Storage INT NOT NULL, " +
                "Ram INT NOT NULL, " +
                "Usb INT NOT NULL);");

        for (Smartphone phone : smartphones) {
            String manufacturer = phone.getManufacturer();
            String name = phone.getName();
            int storage = (int)phone.getStorage();
            int ram = (int)phone.getRam();

            var values = String.format("('%s', '%s', %d, %d)", manufacturer, name, storage, ram);

            connector.executeSQL("INSERT INTO Smartphones (Manufacturer, Name, Storage, Ram) " +
                    "VALUES " + values + ";");
        }

        for (Laptop laptop : laptops) {
            String manufacturer = laptop.getManufacturer();
            String name = laptop.getName();
            int storage = (int)laptop.getStorage();
            int ram = (int)laptop.getRam();
            int usb = (int)laptop.getRam();

            var values = String.format("('%s', '%s', %d, %d, %d)", manufacturer, name, storage, ram, usb);

            connector.executeSQL("INSERT INTO Laptops (Manufacturer, Name, Storage, Ram, Usb) " +
                    "VALUES " + values + ";");
        }

        try {
            var result = connector.executeSQLWithResult("SELECT * FROM Smartphones");
            System.out.println("Smartphones: ");
            while (result.next()) {
                System.out.print(result.getString("Manufacturer") + " ");
                System.out.println(result.getString("Name"));
            }
            result = connector.executeSQLWithResult("SELECT * FROM Laptops");
            System.out.println("Laptops: ");
            while (result.next()) {
                System.out.print(result.getString("Manufacturer") + " ");
                System.out.println(result.getString("Name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
