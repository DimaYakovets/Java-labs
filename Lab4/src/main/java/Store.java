
import java.util.ArrayList;

public class Store {
    private Device[] _devices;

    public Store(Device[] devices)
    {
        _devices = devices;
    }

    /**
     * Returns Devices that have bigger or the same price as price argument
     * @param price The started price
     * @return Array of Devices
     */
    public Device[] getExpensiveDevices(float price)
    {
        ArrayList<Device> devslist = new ArrayList<Device>();

        for (Device d: _devices) {
            if(d.getPrice() >= price)
            {
                devslist.add(d);
            }
        }

        Device[] devs = new Device[devslist.size()];

        devslist.toArray(devs);
        return devs;
    }
    /**
     * Returns Devices that have lower or the same price as price argument
     * @param price The maximum price
     * @return Array of Devices
     */
    public Device[] getCheaperDevices(float price)
    {
        ArrayList<Device> devslist = new ArrayList<Device>();

        for (Device d: _devices) {
            if(d.getPrice() <= price)
            {
                devslist.add(d);
            }
        }

        Device[] devs = new Device[devslist.size()];

        devslist.toArray(devs);
        return devs;
    }

    /**
     * Gets price of devices with discount
     * @param devs Device list
     * @param discount Discount value (should be in range between 0 and 1)
     * @return Calculated price on devices
     */
    public float getPriceWithDiscount(Device[] devs, float discount)
    {
        float price = 0f;
        for (Device d: devs) {
            price += d.getPrice();
        }
        return price * (1 - discount);
    }


}
