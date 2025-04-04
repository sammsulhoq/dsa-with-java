package graphs;

import java.util.List;
import java.util.ArrayList;

public class Path {
    private List<String> nodes = new ArrayList<>();

    public void add(String node) {
        nodes.add(node);
    }

    @Override
    public String toString() {
        return nodes.toString();
    }
}
