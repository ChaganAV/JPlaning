import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Repository {
    List<Line> repository = new ArrayList<>();
    IRepository file;

    public Repository(IRepository repository) throws IOException {

        this.repository = repository.loadData();
    }

    public List<Line> getRepository() {
        return repository;
    }

    public void setRepository(List<Line> repository) {
        this.repository = repository;
    }
}
