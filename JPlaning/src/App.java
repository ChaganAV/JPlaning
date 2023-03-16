import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class App {
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
        line.setId(1);
        LocalDate date = LocalDate.now();
        line.setDate(date);
        LocalTime time = LocalTime.now();
        line.setTime(time);
        line.setLevel(2);
        line.setNote("Доделать отчет по закупкам");
        LocalDate deadline = LocalDate.of(2023,03,21);
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
        for(Line l: lines){
            System.out.println(String.format("%d %s %s %s %s",l.getId(),l.getDate().toString(),l.getNote(),l.getDeadline().toString(),l.getAutor()));
        }
        //fileRepository.unloadData();
    }
    public void delete(int item){

    }
    public void start() throws IOException{
        String dir = System.getProperty("user.dir");
        String file = "Planing.csv";
        FileRepository fileRepository = new FileRepository(dir,file);
        this.repository = new Repository(fileRepository);
    }
    public void save(){

    }
}
