package com.store;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
            PreparedStatement st =  _connector
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
                PreparedStatement st =  _connector
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
            ResultSet result = _connector.executeSQLWithResult("SELECT * FROM Smartphones;");
            while (result.next()) {
                ls.add(new Smartphone.SmartphoneBuilder()
                		   .setId(result.getInt("Id"))
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
    public Smartphone getPhone(int id) {
        Smartphone phone = null;
        try {
            ResultSet result = _connector.executeSQLWithResult("SELECT * FROM Smartphones WHERE id = " + id + " ;");
            while (result.next()) {
            	phone = new Smartphone.SmartphoneBuilder()
                		   .setId(result.getInt("Id"))
                           .setManufacturer(result.getString("Manufacturer"))
                           .setName(result.getString("Name"))
                           .setStorage(result.getInt("Storage"))
                           .setRam(result.getInt("Ram"))
                           .CreateInstance();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return phone;
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
    public void update(int id, Smartphone newPhone) {
        String sql = "UPDATE Smartphones " +
                     "SET Manufacturer = '" + newPhone.getManufacturer() + "'," +
                     "Name = '" + newPhone.getName() + "'," +
                     "Storage = " + newPhone.getStorage() + "," +
                     "Ram = " + newPhone.getRam() + " " +

                     "WHERE Id = " + id + ";";
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
}
