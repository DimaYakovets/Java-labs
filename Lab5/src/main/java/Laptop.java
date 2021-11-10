public class Laptop extends Device{
    private int _hddSize;
    private int _usbVersion;

    private Laptop(LaptopBuilder b)
    {
        super(b._name, b._manufacturer, b._ram);
        _hddSize = b._hdd;
        _usbVersion = b._usb;
    }

    @Override
    public float getPrice() {
        return ((float)_hddSize / 64 + (float) _ram / 32)*1000;
    }

    public int getUsbVersion() {
        return _usbVersion;
    }

    public int getHddSize() {
        return _hddSize;
    }

    @Override
    public int getStorage() {
        return _hddSize;
    }

    @Override
    public String toString() {
        return "Laptop: " + super.toString() + " " + _usbVersion;
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

    public static class LaptopBuilder
    {
        private String _name;
        private String _manufacturer;
        private int _ram;
        private int _hdd;
        private int _usb;

        public LaptopBuilder setName(String name) {
            if(name == null || name.charAt(0) > 'Z')
                throw new IllegalArgumentException();

            _name = name;
            return this;
        }

        public LaptopBuilder setManufacturer(String manufacturer) {
            if(manufacturer == null || manufacturer.charAt(0) > 'Z')
                throw new IllegalArgumentException();

            _manufacturer = manufacturer;
            return this;
        }

        public LaptopBuilder setRam(int ram) {
            if(ram < 1 || ram > 128 )
                throw new IllegalArgumentException();
            _ram = ram;
            return this;
        }

        public LaptopBuilder setHdd(int hdd) {
            if(hdd < 0)
                throw new IllegalArgumentException();
            _hdd = hdd;
            return this;
        }

        public LaptopBuilder setUsb(int usb) {
            if(usb < 1 || usb > 3) throw new IllegalArgumentException();
            _usb = usb;
            return this;
        }

        public Laptop CreateInstance()
        {
            return new Laptop(this);
        }
    }
}