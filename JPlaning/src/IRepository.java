import java.io.File;
import java.nio.file.Path;

public interface IRepository {
    public File getFile(Path path);
}
