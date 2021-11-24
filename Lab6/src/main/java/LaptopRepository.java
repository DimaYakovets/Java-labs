import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LaptopRepository {
    private  DataBaseConnector _connector;

    public LaptopRepository(DataBaseConnector _connector) {
        this._connector = _connector;
    }

    //Create
    public boolean add(Laptop laptop) {
        try {
            var st =  _connector
                    .createPreparedStatement("INSERT INTO Laptops (Manufacturer, Name, Storage, Ram) " +
                            "VALUES (?, ?, ?, ?)");

            st.setString(1, laptop.getManufacturer());
            st.setString(2, laptop.getName());
            st.setInt(3, laptop.getStorage());
            st.setInt(4, laptop.getRam());

            return st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean addArray(Laptop[] laptops) {
        try {

            for(Laptop laptop : laptops) {
                var st =  _connector
                        .createPreparedStatement("INSERT INTO Laptops (Manufacturer, Name, Hdd, Ram, Usb) " +
                                "VALUES (?, ?, ?, ?, ?)");

                st.setString(1, laptop.getManufacturer());
                st.setString(2, laptop.getName());
                st.setInt(3, laptop.getHddSize());
                st.setInt(4, laptop.getRam());
                st.setInt(5, laptop.getUsbVersion());

                st.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    //retrieve
    public List<Laptop> getLaptops() {
        List<Laptop> ls = new ArrayList<Laptop>();
        try {
            var result = _connector.executeSQLWithResult("SELECT * FROM Laptops;");
            while (result.next()) {
                ls.add(new Laptop.LaptopBuilder()
                        .setManufacturer(result.getString("Manufacturer"))
                        .setName(result.getString("Name"))
                        .setHdd(result.getInt("Hdd"))
                        .setRam(result.getInt("Ram"))
                        .setUsb(result.getInt("Usb"))
                        .CreateInstance());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ls;
    }
    // Update
    public void update(Laptop oldlaptop, Laptop newlaptop) {
        String sql = "UPDATE Laptops " +
                "SET Manufacturer = '" + newlaptop.getManufacturer() + "'," +
                "Name = '" + newlaptop.getName() + "'," +
                "Hdd = " + newlaptop.getStorage() + "," +
                "Usb = " + newlaptop.getUsbVersion() + "," +
                "Ram = " + newlaptop.getRam() + " " +

                "WHERE Manufacturer = '" + oldlaptop.getManufacturer() + "' AND " +
                "Name = '" + oldlaptop.getName() + "' AND " +
                "Hdd = " + oldlaptop.getHddSize() + " AND " +
                "Usb = " + oldlaptop.getHddSize() + " AND " +
                "Ram = " + oldlaptop.getRam() + ";";

        _connector.executeSQL(sql);
    }
    //Delete
    public void delete(Laptop laptop) {
        String sql = "DELETE FROM Laptops " +
                "WHERE Manufacturer = '" + laptop.getManufacturer() + "' AND " +
                "Name = '" + laptop.getName() + "' AND " +
                "Hdd = " + laptop.getHddSize() + " AND " +
                "Usb = " + laptop.getHddSize() + " AND " +
                "Ram = " + laptop.getRam() + ";";

        _connector.executeSQL(sql);
    }
    //Lab 3
    public float getPriceWithDiscount(float discount) {
        float price = 0;
        try {
            String sql = "SELECT sum((Hdd / 64 + Ram / 32) * 1000) AS result FROM Laptops;";
            var rs = _connector.executeSQLWithResult(sql);

            if(rs.next()){
                price = (float)rs.getFloat("result");
                price *= 1 - discount;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return price;
    }
    public List<Laptop> getCheaperDevices(float price) {
        return getLaptops().stream().filter((l)-> l.getPrice() < price).toList();
    }
    public List<Laptop> getExpensiveDevices(float price) {
        return getLaptops().stream().filter((l)-> l.getPrice() > price).toList();
    }
}
