import java.io.IOException;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String dir = System.getProperty("user.dir");
        String csv = "Planing.csv";
        FileRepository fileRepository = new FileRepository(dir,csv);
        //fileRepository.loadData();
        Repository repository = new Repository(fileRepository);
        List<Line> lines = new ArrayList<>();
        Line line = new Line();
        line.setId(1);
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        line.setDate(date);
        line.setNote("Создать планировщик заданий");
        Calendar deadline = Calendar.getInstance();
        deadline.set(2023,03,20);
        line.setDeadline(deadline.getTime());
        Person person = new Person();
        person.setFirstname("Александр");
        person.setSecondname("Сергеевич");
        person.setLastname("Пушкин");
        line.setAutor(person);
        lines.add(line);
        fileRepository.unloadData(lines);
        System.out.println("Hello world!");
    }
}