import java.io.IOException;

public class Main {
    private static final String XMLPath = "C:\\Users\\NImpha\\Desktop\\store.xml";
    private static final String JSONPath = "C:\\Users\\NImpha\\Desktop\\store.json";
    private static final String TEXTPath = "C:\\Users\\NImpha\\Desktop\\store.txt";

    public static void main(String[] args) throws IOException {
        Smartphone[] devices = new Smartphone[] {
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

        Store store = new Store(devices);
        store.setStoreName("Some store");
        XMLSerializer xml = new XMLSerializer();
        TEXTSerializer text = new TEXTSerializer();
        JSONSerializer json = new JSONSerializer();

        xml.Serialize(store, XMLPath);
        json.Serialize(store, JSONPath);
        text.Serialize(store, TEXTPath);

        var des = text.DeSerialize(TEXTPath);
        var phns = des.getPhones();
        System.out.println(des.getStoreName());
        for (Smartphone p : phns) {
            System.out.println(p.toString());
        }
    }
}
