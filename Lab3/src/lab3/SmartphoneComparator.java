package lab3;

import java.util.Comparator;

public class SmartphoneComparator implements Comparator<Smartphone> {
    @Override
    public int compare(Smartphone o1, Smartphone o2) {
        return o1.compareTo(o2);
    }
}
