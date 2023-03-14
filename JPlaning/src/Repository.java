import java.util.ArrayList;
import java.util.List;

public class Repository {
    List<Line> repository = new ArrayList<>();
    IFileRepository file;

    public Repository(IFileRepository repository) {
        this.file = repository;
    }
}
