import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String dir = System.getProperty("user.dir");
        String xml = "Planing.xml";
        FileRepository fileRepository = new FileRepository(dir,xml);
        fileRepository.setData();
        Repository repository = new Repository(fileRepository);
        System.out.println("Hello world!");
    }
}