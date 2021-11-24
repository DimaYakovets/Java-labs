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

        Smartphone googlePixel6 =
                new Smartphone.SmartphoneBuilder()
                .setManufacturer("Google")
                .setName("Pixel 6")
                .setStorage(512)
                .setRam(12)
                .CreateInstance();

        Laptop[] laptops = new Laptop[] {
                new Laptop.LaptopBuilder()
                        .setManufacturer("Asus")
                        .setName("ROG Strix")
                        .setHdd(1024)
                        .setRam(32)
                        .setUsb(2)
                        .CreateInstance(),

                new Laptop.LaptopBuilder()
                        .setManufacturer("HP")
                        .setName("Omen")
                        .setHdd(512)
                        .setRam(16)
                        .setUsb(3)
                        .CreateInstance()
        };
        DataBaseConnector connector = new DataBaseConnector();
        connector.create();

        SmartphoneRepository phonesRep = new SmartphoneRepository(connector);
        LaptopRepository laptopRep = new LaptopRepository(connector);

        laptopRep.addArray(laptops);

        phonesRep.addArray(smartphones);
        phonesRep.add(googlePixel6);
        phonesRep.update(googlePixel6, new Smartphone.SmartphoneBuilder()
                                       .setManufacturer("Google")
                                       .setName("Pixel 6")
                                       .setStorage(512)
                                       .setRam(12)
                                       .CreateInstance());

        phonesRep.delete(googlePixel6);

        System.out.println("== Phones ==");
        for (Smartphone phone: phonesRep.getPhones()) {
            System.out.println(phone);
        }
        System.out.println("== Laptop ==");
        for (Laptop laptop: laptopRep.getLaptops()) {
            System.out.println(laptop);
        }

        System.out.println("= Laptops cost with discount 50% = " + laptopRep.getPriceWithDiscount(0.50f));
        System.out.println();

        System.out.println("= Laptops that are cheaper than 16000");
        for (Laptop laptop: laptopRep.getCheaperDevices(16000)) {
            System.out.println(laptop);
        }
        System.out.println();

        System.out.println("= Laptops that are expensive than 5000");
        for (Laptop laptop: laptopRep.getExpensiveDevices(5000)) {
            System.out.println(laptop);
        }
    }
}
