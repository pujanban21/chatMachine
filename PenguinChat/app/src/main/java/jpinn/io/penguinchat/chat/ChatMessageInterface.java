package jpinn.io.penguinchat.chat;

import java.util.Map;

/**
 * Created by pujan on 6/14/2016.
 */
public interface ChatMessageInterface {
    void pushMessageToFirebase(String author, String message, String emoji);

    Map<String, Object> createMessage(String message, String author, String emoji);
}
