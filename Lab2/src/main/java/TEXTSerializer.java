import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class TEXTSerializer implements Serializer{
    @Override
    public void Serialize(Store obj, String path) throws IOException {
        var phones = obj.getPhones();
        var i = 1;
        try (PrintWriter out = new PrintWriter(path)) {
            out.println(obj.getStoreName());
            out.println(phones.size());
            for(var p : phones) {
                out.println(" " + p.getManufacturer());
                out.println(" " + p.getName());
                out.println(" " + p.getRam());
                out.println(" " + p.getStorage());
                if(i++!=obj.getPhones().size())
                    out.println();
            }
        }
    }

    @Override
    public Store DeSerialize(String path) throws IOException {
        var store = new Store();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            line = br.readLine();
            store.setStoreName(line);
            line = br.readLine();
            var count = Integer.parseInt(line);
            for (int i = 0; i < count; i++) {
                var phone = new Smartphone();
                phone.setManufacturer(br.readLine().trim());
                phone.setName(br.readLine().trim());
                phone.setRam(Integer.parseInt(br.readLine().trim()));
                phone.setStorage(Integer.parseInt(br.readLine().trim()));
                store.getPhones().add(phone);
                br.readLine();
            }
        }
        return store;
    }
}
