package damc.castro.com.android.marketlist.model.Persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import damc.castro.com.android.marketlist.model.Interfaces.UserDaoInterface;
import damc.castro.com.android.marketlist.model.Interfaces.UserInterface;

public class UserDaoLocalList implements UserDaoInterface {

    List<UserInterface> usersList = new ArrayList<>();

    @Override
    public UserInterface getUser(final String userEmail, final String userNickName) {

        return (UserInterface) usersList.stream()
                .filter(user -> 
                        user.getUserEmail().equals(userEmail) && 
                                user.getUserNickName().equals(userNickName));
    }

    @Override
    public void newUser(UserInterface newUser) {
        
    }

    @Override
    public void changeUser(UserInterface user2bChanged) {
        usersList.stream()
                .filter(user ->
                        user.getUserEmail().equals(user2bChanged.getUserEmail()) &&
                                user.getUserNickName().equals(user2bChanged.getUserNickName()))
        ;
    }
}
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  