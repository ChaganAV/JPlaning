import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class App implements IApp{
    private Setting setting;
    private String dir;
    private String file;
    private Repository repository;
    public void addSetting(Setting setting){
        this.setting = setting;
    }
    public void add(Line l){
        List<Line> lines = repository.getRepository();
        Line line = l;
        line.setId(lines.size()+1);
        lines.add(line);
    }
    public void update(int item){

    }
    public void select(String sortItem) throws IOException{
        List<Line> lines = repository.getRepository();
        if(sortItem.equals("2")) {
            for (Line l : lines) {
                System.out.println(String.format("%d %s (%d) %s %s %s", l.getId(), l.getDate().toString(), l.getLevel(), l.getNote(), l.getDeadline().toString(), l.getAutor()));
            }
        }else {
            Collections.sort(lines,new LevelComparator());
            for(Line l: lines){
                System.out.println(String.format("%d %s (%d) %s %s %s", l.getId(), l.getDate().toString(), l.getLevel(), l.getNote(), l.getDeadline().toString(), l.getAutor()));
            }
        }
    }
    public void delete(int item){

    }
    public void start(){
        try {
            this.dir = System.getProperty("user.dir");
            this.file = "Planing.csv";
            CvsRepository fileRepository = new CvsRepository(dir, file);
            this.repository = new Repository(fileRepository);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    public void save() throws IOException {
        CvsRepository fileRepository = new CvsRepository(dir,file);
        List<Line> lines = repository.getRepository();
        fileRepository.unloadData(lines);
    }
}
