import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
import java.io.IOException;

public class XMLSerializer implements Serializer {

    @Override
    public void Serialize(Store obj, String path) throws IOException {
        XmlMapper mapper = new XmlMapper();
        mapper.writeValue(new File(path), obj);
    }

    @Override
    public Store DeSerialize(String path) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        Store value = xmlMapper.readValue(new File(path), Store.class);
        return  value;
    }
}
