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
        System.out.println("----- Get Vendors -----");
        for (String vendor : store.getVendors()) {
            System.out.println(vendor);
        };

        System.out.println("----- Get Vendors Stream -----");
        for (String vendor : store.getVendors()) {
            System.out.println(vendor);
        };

        System.out.println("----- Sort By Cost -----");
        for (Smartphone vendor : store.sortByCostStream()) {
            System.out.println(vendor);
        };

        System.out.println("----- Sort By Cost Stream -----");
        for (Smartphone vendor : store.sortByCostStream()) {
            System.out.println(vendor);
        };

        System.out.println("----- Get Price With Discount -----");
        System.out.println(store.getPriceWithDiscount(phones, 0.15f));

        System.out.println("----- Get Price With Discount Stream-----");
        System.out.println(store.getPriceWithDiscountStream(phones, 0.15f));
    }
}
