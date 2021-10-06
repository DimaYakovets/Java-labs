import org.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JSONSerializer implements Serializer{
    @Override
    public void Serialize(Store obj, String path) throws IOException {
        try (PrintWriter out = new PrintWriter(path)) {
            out.println(new JSONObject(obj));
        }
    }

    @Override
    public Store DeSerialize(String path) throws IOException {

        Store store = new Store();

        String json = new String(Files.readAllBytes(Paths.get(path)));
        var obj = new JSONObject(json);
        store.setStoreName(obj.getString("storeName"));
        var arr = obj.getJSONArray("phones");
        for (int i = 0; i < arr.length(); i++) {
            var phone = new Smartphone();
            var item =  (JSONObject)arr.get(i);
            phone.setManufacturer((String)item.get("manufacturer"));
            phone.setName((String)item.get("name"));
            phone.setRam((int)item.get("ram"));
            phone.setStorage((int)item.get("storage"));
            store.getPhones().add(phone);
        }


        return store;
    }
}
