import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class FileRepository implements IRepository{
    private String dir;
    private String filename;
    private File file;

    public FileRepository(String dir,String filename) {
        this.dir = dir;
        this.filename = filename;
    }

    @Override
    public void setData() throws IOException {
        try {
            this.file = new File(this.dir, this.filename);
            if (!file.exists()) {
                file.createNewFile();
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                String begin = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
                bw.write(begin);
                bw.write("<records></records>");
                bw.close();
            } else {
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.close();
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void loadData() {

    }

    @Override
    public void unloadData() {

    }
}
