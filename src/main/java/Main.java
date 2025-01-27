import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        User user = new User(12, "Name");
        User user1 = new User(53, "Name1");
        User user2 = new User(35, "Name3");

        ArrayList<User> users = new ArrayList<>();

        users.add(user1);
        users.add(user2);
        users.add(user);

        Comparator<User> userComparator = new Comparator<>() {
            @Override
            public int compare(User o1, User o2) {
                if (o1.getAge() > o2.getAge()) {
                    return 1;
                } else if (o1.getAge() < o2.getAge()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        };

        users.sort(userComparator);
        System.out.println(users);
    }
}
