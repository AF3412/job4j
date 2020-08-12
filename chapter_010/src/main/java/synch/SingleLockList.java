package synch;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import ru.af3412.list.DynamicListArray;

import java.util.Iterator;

@ThreadSafe
public class SingleLockList<T> implements Iterable<T> {

    @GuardedBy("this")
    private final DynamicListArray<T> list = new DynamicListArray<>();

    public synchronized void add(T value) {
        list.add(value);
    }

    public synchronized T get(int index) {
        return list.getValue(index);
    }

    @Override
    public synchronized Iterator<T> iterator() {
        return copy(this.list).iterator();
    }

    private DynamicListArray<T> copy(DynamicListArray<T> list) {
        DynamicListArray<T> tmpList = new DynamicListArray<>();
        list.forEach(tmpList::add);
        return tmpList;
    }

}
