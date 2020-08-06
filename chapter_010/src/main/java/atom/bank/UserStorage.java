package atom.bank;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.ArrayList;
import java.util.List;

@ThreadSafe
public class UserStorage {

    @GuardedBy("this")
    private final List<User> users = new ArrayList<>();

    synchronized boolean add(User user) {
        System.out.println("add: " + Thread.currentThread().getName());
        return this.users.add(user);
    }

    synchronized List<User> get() {
        return this.users;
    }

    synchronized boolean update(User user) {
        for (User u : users) {
            if (u.equals(user)) {
                u.amount = user.amount;
                return true;
            }
        }
        return false;
    }

    synchronized boolean delete(User user) {
        return this.users.remove(user);
    }

    synchronized boolean transfer(int fromId, int toId, int amount) {
        User from = null;
        User to = null;
        for (User user : users) {
            if (user.id == fromId) {
                from = user;
            }
            if (user.id == toId) {
                to = user;
            }
            if (from != null && to != null ) {
                from.amount -= amount;
                to.amount += amount;
                return true;
            }
        }
        return false;
    }
}
