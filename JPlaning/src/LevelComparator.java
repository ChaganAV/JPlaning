import java.util.Comparator;

public class LevelComparator implements Comparator<Line> {
    @Override
    public int compare(Line o1, Line o2) {
        return o1.getLevel()-o2.getLevel();
    }
}
