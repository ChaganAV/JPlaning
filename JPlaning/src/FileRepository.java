import java.io.File;
import java.nio.file.Path;

public class FileRepository implements IRepository{
    private String dir;
    private String filename;

    public FileRepository(String dir,String filename) {
        this.dir = dir;
        this.filename = filename;
    }

    @Override
    public File getFile(Path path) {
        return null;
    }
}
