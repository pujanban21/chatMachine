package jpinn.io.penguinchat.users;

import java.util.ArrayList;

import jpinn.io.penguinchat.User;

/**
 * Created by pujan on 6/14/2016.
 */
public interface CurrentUsersPresenter {
    void getChildren(ArrayList<User> users);
    void request();
}
