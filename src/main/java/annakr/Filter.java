package annakr;

import java.util.*;

public class Filter {

    public List<User> filter(List<User> users) {
        List<User> filteredUsers = new ArrayList<User>();
        Map<NameAgePair, List<User>> groupedUsers = groupByNameAndAge(users);
        for (Map.Entry<NameAgePair, List<User>> userEntry : groupedUsers.entrySet()) {
            List<User> usersInGroup = userEntry.getValue();
            User userWithLeastSequenceNumber = Collections.min(usersInGroup, new UserSequenceComparator());
            filteredUsers.add(userWithLeastSequenceNumber);
        }
        return filteredUsers;
    }

    private Map<NameAgePair, List<User>> groupByNameAndAge(List<User> users) {
        Map<NameAgePair, List<User>> groupedUsers = new HashMap<NameAgePair, List<User>>();
        for (User user : users) {
            NameAgePair discriminator = new NameAgePair(user.getName(), user.getAge());
            List<User> usersInGroup = groupedUsers.get(discriminator);
            if (usersInGroup == null) {
                usersInGroup = new ArrayList<User>();
                groupedUsers.put(discriminator, usersInGroup);
            }
            usersInGroup.add(user);
        }
        return groupedUsers;
    }

    private static class UserSequenceComparator implements Comparator<User> {

        public int compare(User user1, User user2) {
            if (user1.getSequenceNumber() == null)
                return -1;
            else if (user2.getSequenceNumber() == null)
                return 1;
            else
                return Integer.compare(user1.getSequenceNumber(), user2.getSequenceNumber());
        }
    }
}
