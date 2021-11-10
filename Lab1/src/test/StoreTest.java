package test;
import lab1.*;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class StoreTest {
    @Test()
    public void laptopBuilderNameSuccessTest()
    {
        Device d = new Laptop.LaptopBuilder().setName("Omen 15").CreateInstance();
        assertEquals(d.getName(), "Omen 15");
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void laptopBuilderNameFailureTest()
    {
        Device d = new Laptop.LaptopBuilder().setName("omen 15").CreateInstance();
    }

    @Test()
    public void laptopBuilderRamSuccessTest()
    {
        Device d = new Laptop.LaptopBuilder().setRam(16).CreateInstance();
        assertEquals(d.getRam(), 16);
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void laptopBuilderRamFailureTest()
    {
        Device d = new Laptop.LaptopBuilder().setRam(999).CreateInstance();
    }


    @Test()
    public void phoneBuilderManufacturerSuccessTest()
    {
        Device d = new Smartphone.SmartphoneBuilder().setManufacturer("Apple").CreateInstance();
        assertEquals(d.getManufacturer(), "Apple");
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void phoneBuilderNameFailureTest()
    {
        Device d = new Smartphone.SmartphoneBuilder().setName("samsung").CreateInstance();
    }

    @Test()
    public void phoneBuilderStorageSuccessTest()
    {
        Device d = new Smartphone.SmartphoneBuilder().setStorage(128).CreateInstance();
        assertEquals(d.getStorage(), 128);
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void phoneBuilderStorageFailureTest()
    {
        Device d = new Smartphone.SmartphoneBuilder().setStorage(-5000).CreateInstance();
    }


    @Test(dataProvider = "getExpensiveDevicesData")
    public void getExpensiveDevicesTest(Device[] devs, int price, Device[] answer)
    {
        Store store = new Store(devs);
        var res = store.getExpensiveDevices(price);

        assertEquals(res.length, answer.length);

        for (int i = 0; i < res.length; i++) {
            assertEquals(res[i], answer[i]);
        }
    }
    @Test(dataProvider = "getCheaperDevicesData")
    public void getCheaperDevicesTest(Device[] devs, int price, Device[] answer)
    {
        Store store = new Store(devs);
        var res = store.getCheaperDevices(price);

        assertEquals(res.length, answer.length);

        for (int i = 0; i < res.length; i++) {
            assertEquals(res[i], answer[i]);
        }
    }
    @Test(dataProvider = "getPriceDiscountData")
    public void getPriceWithDiscount(Device[] devs, float discount, float price)
    {
        Store store = new Store(devs);
        assertEquals(store.getPriceWithDiscount(devs, discount), price, 0.01);
    }

    @DataProvider
    public Object[][] getExpensiveDevicesData()
    {
        return new Object[][]
        {
            {
                new Device[]{
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
                },
                4000,
                new Device[]{
                        new Smartphone.SmartphoneBuilder()
                                .setManufacturer("Samsung")
                                .setName("Galaxy S21")
                                .setStorage(256)
                                .setRam(8)
                                .CreateInstance(),

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
                }
            }
        };
    }
    @DataProvider
    public Object[][] getCheaperDevicesData()
    {
        return new Object[][]
        {
            {
                new Device[]{
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
                },
                4000,
                new Device[]{
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
                }
            }
        };
    }
    @DataProvider
    public Object[][] getPriceDiscountData()
    {
        return new Object[][]
        {
            {
                new Device[]{
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
                },
                0.15f,
                28767.18f
            }
        };
    }
}
