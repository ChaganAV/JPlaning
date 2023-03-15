import java.io.*;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class FileRepository implements IRepository{
    private String dir;
    private String filename;
    private File file;

    public FileRepository(String dir,String filename) {
        this.dir = dir;
        this.filename = filename;
    }

    @Override
    public List<Line> loadData() throws IOException{
        List<Line> lines = new ArrayList<>();
        try {
            this.file = new File(this.dir, this.filename);
            if (file.exists()) {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                //Map<Integer,Line> lines = new HashMap<Integer,Line>();
                while (br.ready()){
                    Line line = new Line();
                    String[] s = br.readLine().split(";");
                    line.setId(Integer.parseInt(s[0]));
                    line.setDate(Date.valueOf(s[1]));
                    //line.setTime(Time.valueOf(s[2]));
                    line.setNote(s[3]);
                    line.setDeadline(Date.valueOf(s[4]));
                    Person person = new Person();
                    String[] p = s[5].split(" ");
                    person.setFirstname(p[0]);
                    person.setSecondname(p[1]);
                    person.setLastname(p[2]);
                    line.setAutor(person);
                    lines.add(line);
                }
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return lines;
    }

    @Override
    public void unloadData(List lines) throws IOException{
        List<Line> list = lines;
        try {
            this.file = new File(this.dir, this.filename);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fs = new FileOutputStream(file);
            OutputStreamWriter ow = new OutputStreamWriter(fs,"windows-1251");
            //FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(ow);
            for(Line l: list){
                String s = String.format("%s;%s;%s;%s;%s;",l.getId(),l.getDate(),l.getNote(),l.getDeadline(),l.getAutor());
                bw.write(s);
            }
            bw.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

}
