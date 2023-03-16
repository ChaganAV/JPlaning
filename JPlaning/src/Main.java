import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Main {
    public static void main(String[] args){
        App app = new App();

        try {
            app.start();
            app.add();
            app.select();
            app.save();

        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}