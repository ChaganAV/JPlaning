import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class CvsRepository implements IRepository{
    private String dir;
    private String filename;
    private File file;
    private List<Line> lines;

    public CvsRepository(String dir,String filename) {
        this.dir = dir;
        this.filename = filename;
    }
    public void setData(List<Line> lines){
        this.lines = lines;
    }
    @Override
    public List<Line> loadData() throws IOException{
        List<Line> lines = new ArrayList<>();
        try {
            this.file = new File(this.dir, this.filename);
            if (file.exists()) {
                FileInputStream fs = new FileInputStream(file);
                InputStreamReader iw = new InputStreamReader(fs,"windows-1251");
                BufferedReader br = new BufferedReader(iw);
                while (br.ready()){
                    Line line = new Line();
                    String[] s = br.readLine().split(";");
                    line.setId(Integer.parseInt(s[0]));
                    line.setDate(LocalDate.parse(s[1]));
                    line.setLevel(Integer.parseInt(s[2]));
                    line.setTime(LocalTime.parse(s[3]));
                    line.setNote(s[4]);
                    line.setDeadline(LocalDate.parse(s[5]));
                    Person person = new Person();
                    String[] p = s[6].split(" ");
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
        this.lines = lines;
        return lines;
    }

    public void unloadData(List<Line> lines) throws IOException{
        try {
            this.file = new File(this.dir, this.filename);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fs = new FileOutputStream(file);
            OutputStreamWriter ow = new OutputStreamWriter(fs,"windows-1251");
            //FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(ow);
            for(Line l: lines){
                String s = String.format("%d;%s;%d;%s;%s;%s;%s;",l.getId(),l.getDate().toString(),l.getLevel(),l.getTime().toString(),l.getNote(),l.getDeadline().toString(),l.getAutor());
                bw.write(s);
                bw.newLine();
            }
            bw.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

}
