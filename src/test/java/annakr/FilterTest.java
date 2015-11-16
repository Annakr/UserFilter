package annakr;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class FilterTest {

    private Filter filter;

    @Before
    public void setUp() throws Exception {
        filter = new Filter();
    }

    @Test
    public void test() {
        List<User> users = createTestUsers();
        Collections.shuffle(users);
        List<User> filteredUsers = filter.filter(users);

        Assert.assertEquals(6, filteredUsers.size());
        User userJohn = getUsersByUserNameAndAge("John", 35, filteredUsers);
        assertEquals(userJohn.getSequenceNumber(), null);
        User userKarl = getUsersByUserNameAndAge("Karl", 27, filteredUsers);
        assertEquals(userKarl.getSequenceNumber(), Integer.valueOf(0));

        User user7 = getUsersByUserNameAndAge("Name3", 50, filteredUsers);
        assertEquals(user7.getSequenceNumber(), null);

        User user8 = getUsersByUserNameAndAge("Name4", 40, filteredUsers);
        assertEquals(user8.getSequenceNumber(), Integer.valueOf(3));

        User user9 = getUsersByUserNameAndAge("Name5", 30, filteredUsers);
        assertEquals(user9.getSequenceNumber(), Integer.valueOf(8));

        User user10 = getUsersByUserNameAndAge("Name6", 20, filteredUsers);
        assertEquals(user10.getSequenceNumber(), Integer.valueOf(7));
    }

    private User getUsersByUserNameAndAge(String name, Integer age, List<User> users) {
        List<User> foundUsers = new ArrayList<User>();
        for (User user : users) {
            if (user.getName().equals(name) && user.getAge().equals(age)) {
                foundUsers.add(user);
            }
        }
        if (foundUsers.size() == 0)
            fail("User not found");
        else if (foundUsers.size() == 1)
            return foundUsers.get(0);
        else
            fail("Duplicate");
        //shouldn't get here
        return null;
    }

    private List<User> createTestUsers() {
        List<User> users = new ArrayList<User>();

        String userName1 = "John";
        String userName2 = "Karl";

        String userName3 = "Name3";
        String userName4 = "Name4";
        String userName5 = "Name5";
        String userName6 = "Name6";

        Integer age1 = 35;
        Integer age2 = 27;

        Integer age3 = 50;
        Integer age4 = 40;
        Integer age5 = 30;
        Integer age6 = 20;

        User user1 = new User(userName1, age1, null);
        User user2 = new User(userName1, age1, 1);
        User user3 = new User(userName1, age1, 5);

        User user4 = new User(userName2, age2, 3);
        User user5 = new User(userName2, age2, 0);
        User user6 = new User(userName2, age2, 2);

        User user7 = new User(userName3, age3, null);
        User user8 = new User(userName4, age4, 3);
        User user9 = new User(userName5, age5, 8);
        User user10 = new User(userName6, age6, 7);


        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);
        users.add(user7);
        users.add(user8);
        users.add(user9);
        users.add(user10);

        return users;
    }

}
