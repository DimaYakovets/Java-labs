package lab4;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;

public class Smartphone extends Device {
    private int _storage;

    private Smartphone(@Valid SmartphoneBuilder b)
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

        @Min(value = 1)
        @Min(value = 128)
        private int _ram;
        private int _storage;

        public SmartphoneBuilder setName(String name) {
            _name = name;
            return this;
        }

        public SmartphoneBuilder setManufacturer(String manufacturer) {
            _manufacturer = manufacturer;
            return this;
        }

        public SmartphoneBuilder setRam(int ram) {
            _ram = ram;
            return this;
        }

        public SmartphoneBuilder setStorage(int storage) {
            _storage = storage;
            return this;
        }

        public Smartphone createInstance()
        {
            return new Smartphone(this);
        }
    }

}
