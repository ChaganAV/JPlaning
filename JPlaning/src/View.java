import java.io.IOException;
import java.util.Scanner;

public class View {
    public void run(IApp app){
        App applic = (App)app;
        System.out.println("1 - добавить заметку");
        System.out.println("2 - вывести заметки");
        System.out.println("3 - выход");
        Scanner scanner = new Scanner(System.in);
        Boolean quit = true;
        while (quit){
            String input = scanner.nextLine();
            switch (input){
                case "1":
                    applic.add();
                    break;
                case "2":
                    try {
                        applic.select();
                    }catch (IOException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "3":
                    quit = false;
                    break;
            }
        }
    }
}
