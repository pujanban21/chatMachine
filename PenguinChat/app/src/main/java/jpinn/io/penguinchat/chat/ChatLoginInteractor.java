package jpinn.io.penguinchat.chat;

import com.firebase.client.Firebase;

/**
 * Created by pujan on 6/14/2016.
 */
public class ChatLoginInteractor implements CLoginInteractor{
    @Override
    public void logTheUserOut(String uid) {
        Firebase userRef = new Firebase("https://<your-firebase>/currentUsers/" + uid);
        userRef.removeValue();
    }
}
