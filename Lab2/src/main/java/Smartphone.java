
public class Smartphone{
    private int _storage;
    private String _manufacturer;
    private String _name;
    private int _ram;

    public int getStorage() {
        return _storage;
    }

    public String getManufacturer() {
        return _manufacturer;
    }

    public String getName() {
        return _name;
    }

    public int getRam() {
        return _ram;
    }

    public void setStorage(int _storage) {
        this._storage = _storage;
    }

    public void setManufacturer(String _manufacturer) {
        this._manufacturer = _manufacturer;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public void setRam(int _ram) {
        this._ram = _ram;
    }

    public Smartphone()
    {}

    private Smartphone(SmartphoneBuilder b)
    {
        _storage = b._storage;
        _name=b._name;
        _manufacturer = b._manufacturer;
        _ram = b._ram;
    }
    public float calculatePrice() {
        return ((float) _storage / 64 + (float) _ram / 64)*1000;
    }
    public String toString() {
        return getManufacturer() + " " + getName()+" "+getRam()+"/" + getStorage();
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

    public static class SmartphoneBuilder
    {
        private String _name;
        private String _manufacturer;
        private int _ram;
        private int _storage;

        public SmartphoneBuilder setName(String name) {
            if(name == null || name.charAt(0) > 'Z')
                throw new IllegalArgumentException();

            _name = name;
            return this;
        }

        public SmartphoneBuilder setManufacturer(String manufacturer) {
            if(manufacturer == null || manufacturer.charAt(0) > 'Z')
                throw new IllegalArgumentException();

            _manufacturer = manufacturer;
            return this;
        }

        public SmartphoneBuilder setRam(int ram) {
            if(ram < 1 || ram > 128 )
                throw new IllegalArgumentException();
            _ram = ram;
            return this;
        }

        public SmartphoneBuilder setStorage(int storage) {
            if(storage < 0)
                throw new IllegalArgumentException();
            _storage = storage;
            return this;
        }

        public Smartphone CreateInstance()
        {
            return  new Smartphone(this);
        }
    }

}
