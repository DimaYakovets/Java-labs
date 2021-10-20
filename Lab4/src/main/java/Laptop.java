import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.util.Set;

public class Laptop extends Device {
    private int _hddSize;
    private int _usbVersion;

    private Laptop(LaptopBuilder b) {
        super(b._name, b._manufacturer, b._ram);
        _hddSize = b._hdd;
        _usbVersion = b._usb;
    }

    @Override
    public float getPrice() {
        return ((float) _hddSize / 64 + (float) _ram / 32) * 1000;
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
        if (this == o) {
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

    public static class LaptopBuilder {
        @Pattern(regexp = "[A-Z][a-zA-Z0-9 ]*", message = "Name must begins with capital")
        private String _name;

        @Pattern(regexp = "[A-Z][a-zA-Z0-9 ]*", message = "Manufacturer must begins with capital")
        private String _manufacturer;

        @Min(value = 1, message = "Ram must be between 1 and 128")
        @Max(value = 128, message = "Ram must be between 1 and 128")
        private int _ram;

        @Min(value = 1, message = "Hdd must be bigger than 1")
        private int _hdd;

        @Min(value = 1, message = "USB version must be between 1 and 3")
        @Max(value = 3, message = "USB version must be between 1 and 3")
        private int _usb;

        public LaptopBuilder() {
            _usb = 1;
            _hdd = 1;
            _ram = 1;
        }

        public LaptopBuilder setName(String name) {
            _name = name;
            return this;
        }

        public LaptopBuilder setManufacturer(String manufacturer) {
            _manufacturer = manufacturer;
            return this;
        }

        public LaptopBuilder setRam(int ram) {
            _ram = ram;
            return this;
        }

        public LaptopBuilder setHdd(int hdd) {
            _hdd = hdd;
            return this;
        }

        public LaptopBuilder setUsb(int usb) {
            _usb = usb;
            return this;
        }

        void validate() {
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();

            Set<ConstraintViolation<Laptop.LaptopBuilder>> constraintViolations = validator.validate(this);

            StringBuilder sb = new StringBuilder();

            for (var t : constraintViolations) {
                sb.append("Error for '" + t.getInvalidValue() + "' : " + t.getMessage() + '\n');
            }

            if (sb.length() > 0){
                throw new IllegalArgumentException(sb.toString());
            }
        }

        public Laptop CreateInstance() {
            var laptop = new Laptop(this);
            validate();
            return laptop;
        }
    }
}
