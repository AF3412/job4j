package nonblocking;

import java.util.concurrent.ConcurrentHashMap;

public class NonBlockingCache {

    private final ConcurrentHashMap<Integer, Base> cache = new ConcurrentHashMap<>();

    public int size() {
        return cache.size();
    }

    public void add(Base model) {
        cache.putIfAbsent(model.id, model);
    }

    public void update(Base model) throws OptimisticException {
        cache.computeIfPresent(model.id, (k, v) -> {
            if (v.version == model.version) {
                v.updateVersion();
                v.values = model.values;
            } else {
                throw new OptimisticException("Object change two or more threads at the same time!");
            }
            return v;
        });
    }

    public Base get(int id) {
        return cache.get(id);
    }

    public void delete(Base model) {
        cache.remove(model.id);
    }

}
