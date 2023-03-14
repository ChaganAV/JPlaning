import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public interface IFileRepository {
    public void setFile() throws IOException;
    public void loadData();
    public void unloadData();
}
