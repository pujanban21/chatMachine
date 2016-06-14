package jpinn.io.penguinchat.chat;

/**
 * Created by pujan on 6/14/2016.
 */
public interface FirebaseChatMessagePresenter {
    void sendMessage(String author, String message, String emoji);
}

