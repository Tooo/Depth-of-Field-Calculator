package camera.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LensManager implements Iterable<Lens>{
    private List<Lens> lens = new ArrayList<>();

    public void add(Lens len) {
        lens.add(len);
    }

    @Override
    public Iterator<Lens> iterator() {
        return lens.iterator();
    }
}
