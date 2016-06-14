package jpinn.io.penguinchat.main;

/**
 * Created by pujan on 6/14/2016.
 */
public interface MainPresenterInterface {
    void receiveRequest();
    String getNumberOfUsers(long numberOfUsers);
    void sendNumberOfChildren(long number);
}
