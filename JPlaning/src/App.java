import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class App implements IApp{
    private Setting setting;
    private String dir;
    private String file;
    private Repository repository;
    public void addSetting(Setting setting){
        this.setting = setting;
    }
    public void add(){
        List<Line> lines = repository.getRepository();
        Line line = new Line();
        line.setId(lines.size()+1);
        LocalDate date = LocalDate.now();
        line.setDate(date);
        LocalTime time = LocalTime.now();
        line.setTime(time);
        line.setLevel(2);
        line.setNote("Доделать отчет по закупкам");
        LocalDate deadline = date.plusDays(7);
        line.setDeadline(deadline);
        Person person = new Person();
        person.setFirstname("Александр");
        person.setSecondname("Сергеевич");
        person.setLastname("Пушкин");
        line.setAutor(person);
        lines.add(line);
    }
    public void update(int item){

    }
    public void select() throws IOException{
            List<Line> lines = repository.getRepository();
            for (Line l : lines) {
                System.out.println(String.format("%d %s %s %s %s", l.getId(), l.getDate().toString(), l.getNote(), l.getDeadline().toString(), l.getAutor()));
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
