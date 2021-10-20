import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class Smartphone extends Device {


    private int _storage;

    private Smartphone(SmartphoneBuilder b) {
        super(b._name, b._manufacturer, b._ram);
        _storage = b._storage;

    }


    @Override
    public float getPrice() {
        return ((float) _storage / 64 + (float) _ram / 64) * 1000;
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

    public static class SmartphoneBuilder {
        @Pattern(regexp = "[A-Z][a-zA-Z0-9 ]*", message = "Name must begins with capital")
        private String _name;

        @Pattern(regexp = "[A-Z][a-zA-Z0-9 ]*", message = "Manufacturer must begins with capital")
        private String _manufacturer;

        @Min(value = 1, message = "Ram must be between 1 and 128")
        @Max(value = 128, message = "Ram must be between 1 and 128")
        private int _ram;

        @Min(value = 1, message = "Storage must be bigger than 0")
        private int _storage;

        public SmartphoneBuilder() {
            _ram = 1;
            _storage = 1;
        }

        public void validate(Smartphone phone) {
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();

            Set<ConstraintViolation<SmartphoneBuilder>> constraintViolations = validator.validate(this);

            StringBuilder sb = new StringBuilder();

            for (var t : constraintViolations) {
                sb.append("Error for '" + t.getInvalidValue() + "' : " + t.getMessage() + '\n');
            }

            if (sb.length() > 0){
                throw new IllegalArgumentException(sb.toString());
            }
        }

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

        public Smartphone createInstance() {
            var phone = new Smartphone(this);
            validate(phone);
            return phone;
        }
    }

}
