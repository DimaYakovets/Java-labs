import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SmartphoneRepository {
    private  DataBaseConnector _connector;

    public SmartphoneRepository(DataBaseConnector _connector) {
        this._connector = _connector;
    }

    //Create
    public boolean add(Smartphone phone) {
        try {
            var st =  _connector
                    .createPreparedStatement("INSERT INTO Smartphones (Manufacturer, Name, Storage, Ram) " +
                            "VALUES (?, ?, ?, ?)");

            st.setString(1, phone.getManufacturer());
            st.setString(2, phone.getName());
            st.setInt(3, phone.getStorage());
            st.setInt(4, phone.getRam());

            return st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean addArray(Smartphone[] phones) {
        try {

            for(Smartphone phone : phones) {
                var st =  _connector
                        .createPreparedStatement("INSERT INTO Smartphones (Manufacturer, Name, Storage, Ram) " +
                                "VALUES (?, ?, ?, ?)");

                st.setString(1, phone.getManufacturer());
                st.setString(2, phone.getName());
                st.setInt(3, phone.getStorage());
                st.setInt(4, phone.getRam());

                st.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    //retrieve
    public List<Smartphone> getPhones() {
        List<Smartphone> ls = new ArrayList<Smartphone>();
        try {
            var result = _connector.executeSQLWithResult("SELECT * FROM Smartphones;");
            while (result.next()) {
                ls.add(new Smartphone.SmartphoneBuilder()
                           .setManufacturer(result.getString("Manufacturer"))
                           .setName(result.getString("Name"))
                           .setStorage(result.getInt("Storage"))
                           .setRam(result.getInt("Ram"))
                           .CreateInstance());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ls;
    }
    // Update
    public void update(Smartphone oldPhone, Smartphone newPhone) {
        String sql = "UPDATE Smartphones " +
                     "SET Manufacturer = '" + newPhone.getManufacturer() + "'," +
                     "Name = '" + newPhone.getName() + "'," +
                     "Storage = " + newPhone.getStorage() + "," +
                     "Ram = " + newPhone.getRam() + " " +

                     "WHERE Manufacturer = '" + oldPhone.getManufacturer() + "' AND " +
                     "Name = '" + oldPhone.getName() + "' AND " +
                     "Storage = " + oldPhone.getStorage() + " AND " +
                     "Ram = " + oldPhone.getRam() + ";";
        _connector.executeSQL(sql);
    }
    //Delete
    public void delete(Smartphone phone) {
        String sql = "DELETE FROM Smartphones " +
                "WHERE Manufacturer = '" + phone.getManufacturer() + "' AND " +
                "Name = '" + phone.getName() + "' AND " +
                "Storage = " + phone.getStorage() + " AND " +
                "Ram = " + phone.getRam() + ";";

        _connector.executeSQL(sql);
    }
    //Lab 3
    public float getPriceWithDiscount(float discount) {
        float price = 0;
        try {
            String sql = "SELECT sum((Storage / 64 + Ram / 64) * 1000) AS result FROM Smartphones;";
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
    public List<Smartphone> getCheaperDevices(float price) {
        return getPhones().stream().filter((p)-> p.getPrice() < price).toList();
    }
    public List<Smartphone> getExpensiveDevices(float price) {
        return getPhones().stream().filter((p)-> p.getPrice() > price).toList();
    }
}
