import java.io.IOException;

public interface IRepository {
    public void setData() throws IOException;
    public void loadData();
    public void unloadData();
}
