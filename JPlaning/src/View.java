import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class View {
    public void run(IApp applic){
        App app = (App)applic;
        System.out.println("1 - добавить заметку");
        System.out.println("2 - вывести заметки");
        //System.out.println("3 - вывести по дедлайну");
        System.out.println("3 - вывести по важности");
        System.out.println("4 - выход");
        Scanner scanner = new Scanner(System.in);
        Boolean quit = true;
        while (quit){
            System.out.println("Введите номер команды: " );
            //System.out.println(">> ");
            String input = scanner.nextLine();
            switch (input){
                case "1":
                    Line line = new Line();
                    //line.setId(lines.size()+1);
                    LocalDate date = LocalDate.now();
                    line.setDate(date);
                    LocalTime time = LocalTime.now();
                    line.setTime(time);

                    line.setLevel(2);
                    System.out.println("Введите наименование заметки: ");
                    //System.out.println(">> ");
                    input = scanner.nextLine();
                    line.setNote(input);
                    System.out.println("Введите приоритет (1,2,3): ");
                    //System.out.println(">> ");
                    input = scanner.nextLine();
                    try {
                        int level = Integer.parseInt(input);
                        line.setLevel(level);
                    }catch (NumberFormatException ex){
                        System.out.println(ex.getMessage());
                    }
                    LocalDate deadline;
                    System.out.println("Введите количество дней для выполнения: ");
                    //System.out.println(">> ");
                    input = scanner.nextLine();
                    try {
                        int day = Integer.parseInt(input);
                        deadline = date.plusDays(day);
                        line.setDeadline(deadline);
                    }catch (NumberFormatException ex){
                        System.out.println(ex.getMessage());
                    }
                    Person person = new Person();
                    person.setFirstname("Александр");
                    person.setSecondname("Сергеевич");
                    person.setLastname("Пушкин");
                    line.setAutor(person);
                    app.add(line);
                    try {
                        app.save();
                    }catch (IOException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "2":
                    try {
                        app.select(input);
                    }catch (IOException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "3":
                    try {
                        app.select(input);
                    }catch (IOException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "4":
                    quit = false;
                    break;
            }
        }
    }
}
