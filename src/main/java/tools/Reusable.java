package tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class Reusable<E> {
    private List<E> used = new ArrayList<>();
    private List<E> unused = new ArrayList<>();


    public void supplement(E e) {
        Condition.check().nonNull(e);
        used.add(e);
    }

    public void release(E e) {
        Condition.check().nonNull(e);
        used.remove(e);
        unused.add(e);
    }

    public E getUnused() {

        if (unused.isEmpty()) {
            return null;
        } else {
            E e = unused.get(0);
            unused.remove(e);
            unused.add(e);
            return e;
        }
    }

    public void reset() {
        unused.addAll(used);
        used.clear();
    }
}
