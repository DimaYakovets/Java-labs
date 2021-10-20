import org.testng.annotations.Test;

public class StoreTest {

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void LaptopRamTestFailure() {
        new Laptop.LaptopBuilder().setRam(999).CreateInstance();
    }
    @Test
    public void LaptopRamTest() {
        new Laptop.LaptopBuilder().setRam(64).CreateInstance();
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void LaptopNameTestFailure() {
        new Laptop.LaptopBuilder().setName("asus").CreateInstance();
    }
    @Test
    public void LaptopNameTest() {
        new Laptop.LaptopBuilder().setName("Asus").CreateInstance();
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void LaptopUsbTestFailure() {
        new Laptop.LaptopBuilder().setUsb(5).CreateInstance();
    }
    @Test
    public void LaptopUsbTest() {
        new Laptop.LaptopBuilder().setUsb(3).CreateInstance();
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void SmartphoneStorageTestFailure() {
        new Smartphone.SmartphoneBuilder().setStorage(-999).createInstance();
    }
    @Test
    public void SmartphoneStorageTest() {
        new Smartphone.SmartphoneBuilder().setStorage(512).createInstance();
    }
}
