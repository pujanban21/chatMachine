package jpinn.io.penguinchat.chat;

import com.firebase.client.Firebase;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pujan on 6/14/2016.
 */
public class ChatMessageInteractor implements ChatMessageInterface {

    @Override
    public void pushMessageToFirebase(String author, String message, String date) {
        Firebase messageRef = new Firebase("https://<your-firebase>/messages");
        messageRef.push().setValue(createMessage(message, author, date));
    }

    @Override
    public Map<String, Object> createMessage(String message, String author, String date) {
        Map<String, Object> values = new HashMap<>();
        values.put("message", message);
        values.put("author", author);
        values.put("date", date);
        return values;
    }
}
