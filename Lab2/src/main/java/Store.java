import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Store {
    private String _storeName;
    private List<Smartphone> _phones;

    public String getStoreName(){
        return _storeName;
    }

    public void setStoreName(String name) {
        this._storeName = name;
    }

    public List<Smartphone> getPhones() {
        return _phones;
    }

    public void setPhones(List<Smartphone> _phones) {
        this._phones = _phones;
    }

    public Store() {
        _phones = new ArrayList<Smartphone>();
    }
    public Store(List<Smartphone> _phones) {
        this._phones = _phones;
    }

    public Store(Smartphone[] devices)
    {
        _phones = Arrays.asList(devices);
    }

    /**
     * Returns Devices that have bigger or the same price as price argument
     * @param price The started price
     * @return Array of Devices
     */
    public Smartphone[] getExpensiveDevices(float price)
    {
        ArrayList<Smartphone> devslist = new ArrayList<Smartphone>();

        for (Smartphone d: _phones) {
            if(d.calculatePrice() >= price)
            {
                devslist.add(d);
            }
        }

        Smartphone[] devs = new Smartphone[devslist.size()];

        devslist.toArray(devs);
        return devs;
    }
    /**
     * Returns Devices that have lower or the same price as price argument
     * @param price The maximum price
     * @return Array of Devices
     */
    public Smartphone[] getCheaperDevices(float price)
    {
        ArrayList<Smartphone> devslist = new ArrayList<Smartphone>();

        for (Smartphone d: _phones) {
            if(d.calculatePrice() <= price)
            {
                devslist.add(d);
            }
        }

        Smartphone[] devs = new Smartphone[devslist.size()];

        devslist.toArray(devs);
        return devs;
    }

    /**
     * Gets price of devices with discount
     * @param devs Device list
     * @param discount Discount value (should be in range between 0 and 1)
     * @return Calculated price on devices
     */
    public float getPriceWithDiscount(Smartphone[] devs, float discount)
    {
        float price = 0f;
        for (Smartphone d: devs) {
            price += d.calculatePrice();
        }
        return price * (1 - discount);
    }


}
