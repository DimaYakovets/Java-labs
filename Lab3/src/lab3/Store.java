package lab3;

import java.util.*;


public class Store {
    private String _storeName;
    private List<Smartphone> _phones;

    public String getStoreName() {
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

    public Store(Smartphone[] devices) {
        _phones = Arrays.asList(devices);
    }


    public String[] getVendorsStream() {
        return _phones.stream().map(Smartphone::getManufacturer).distinct().toArray(String[]::new);
    }

    public String[] getVendors() {
        Set<String> vendors = new HashSet<>();

        for (Smartphone _phone : _phones) {
            String manufacturer = _phone.getManufacturer();
            vendors.add(manufacturer);
        }

        return vendors.toArray(String[]::new);
    }

    public Smartphone[] sortByCostStream() {
        return _phones.stream().sorted(new SmartphoneComparator()).toArray(Smartphone[]::new);
    }

    public Smartphone[] sortByCost() {
        var arr = new ArrayList<Smartphone>(_phones);

        for (int i = 0; i < arr.size() - 1; i++) {
            for (int j = 0; j < arr.size() - i - 1; j++) {
                if (arr.get(j).compareTo(arr.get(j + 1)) > 0) {
                    Smartphone temp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);
                }
            }
        }

        return arr.toArray(Smartphone[]::new);
    }

    /**
     * Returns Devices that have bigger or the same price as price argument
     *
     * @param price The started price
     * @return Array of Devices
     */
    public Smartphone[] getExpensiveDevices(float price) {
        ArrayList<Smartphone> devslist = new ArrayList<Smartphone>();

        for (Smartphone d : _phones) {
            if (d.calculatePrice() >= price) {
                devslist.add(d);
            }
        }

        Smartphone[] devs = new Smartphone[devslist.size()];

        devslist.toArray(devs);
        return devs;
    }

    /**
     * Returns Devices that have lower or the same price as price argument
     *
     * @param price The maximum price
     * @return Array of Devices
     */
    public Smartphone[] getCheaperDevices(float price) {
        ArrayList<Smartphone> devslist = new ArrayList<Smartphone>();

        for (Smartphone d : _phones) {
            if (d.calculatePrice() <= price) {
                devslist.add(d);
            }
        }

        Smartphone[] devs = new Smartphone[devslist.size()];

        devslist.toArray(devs);
        return devs;
    }

    /**
     * Gets price of devices with discount
     *
     * @param devs     Device list
     * @param discount Discount value (should be in range between 0 and 1)
     * @return Calculated price on devices
     */
    public float getPriceWithDiscount(Smartphone[] devs, float discount) {
        float price = 0f;
        for (Smartphone d : devs) {
            price += d.calculatePrice();
        }
        return price * (1 - discount);
    }

    public float getPriceWithDiscountStream(Smartphone[] devs, float discount) {
        return (float) (_phones.stream().map(Smartphone::calculatePrice).mapToDouble(d -> d).sum() * (1d - discount));
    }
}
