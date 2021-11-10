
public class Smartphone extends Device {
    private int _storage;

    private Smartphone(SmartphoneBuilder b)
    {
        super(b._name, b._manufacturer, b._ram);
        _storage = b._storage;
    }
    @Override
    public float getPrice() {
        return ((float) _storage / 64 + (float) _ram / 64)*1000;
    }

    @Override
    public int getStorage() {
        return _storage;
    }
    @Override
    public String toString() {
        return "Phone: " + super.toString();
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