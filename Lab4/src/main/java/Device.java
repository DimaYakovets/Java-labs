
public abstract class Device {
    protected String _name;
    protected String _manufacturer;
    protected int _ram;

    protected Device(String name, String manufacturer, int ram)
    {
        _name = name;
        _manufacturer = manufacturer;
        _ram = ram;
    }

    public String getName() {
        return _name;
    }

    public String getManufacturer() {
        return _manufacturer;
    }

    public int getRam() {
        return _ram;
    }


    public abstract float getPrice();

    public abstract int getStorage();

    @Override
    public String toString() {
        return _manufacturer + " " + _name + " " + _ram + "/" + getStorage();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        return o.hashCode() == this.hashCode();
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }
}

