import java.io.IOException;

public interface Serializer {

    void Serialize(Store obj, String path) throws IOException;
    Store DeSerialize(String path) throws IOException;
}
