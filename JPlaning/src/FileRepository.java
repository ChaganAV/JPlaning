import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class FileRepository implements IFileRepository{
    private String dir;
    private String filename;
    private File file;

    public FileRepository(String dir,String filename) {
        this.dir = dir;
        this.filename = filename;
    }

    @Override
    public void setFile() throws IOException {
        this.file = new File(this.dir,this.filename);
        if(!file.exists()){
            file.createNewFile();
        }else {

        }
    }

    @Override
    public void loadData() {

    }

    @Override
    public void unloadData() {

    }
}
