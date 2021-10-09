package lab3;

public class Main {

    public static void main(String[] args) {
        Smartphone[] phones = new Smartphone[] {
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
                        .CreateInstance(),

                new Smartphone.SmartphoneBuilder()
                        .setManufacturer("Samsung")
                        .setName("Galaxy S20")
                        .setStorage(128)
                        .setRam(8)
                        .CreateInstance()
        };
        var store = new Store(phones);
        for (var d : store.sortByCost()){
            System.out.println(d);
        }
    }
}
