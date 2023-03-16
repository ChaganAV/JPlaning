import java.io.IOException;
import java.util.List;

public interface IRepository{
    public List<Line> loadData() throws IOException;

    public void unloadData() throws IOException;
}
