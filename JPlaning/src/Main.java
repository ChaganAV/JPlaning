public class Main {
    public static void main(String[] args) {
        String dir = System.getProperty("user.dir");
        String xml = "Planing.xml";
        FileRepository fileRepository = new FileRepository(dir,xml);
        Repository repository = new Repository(fileRepository);
        System.out.println("Hello world!");
    }
}