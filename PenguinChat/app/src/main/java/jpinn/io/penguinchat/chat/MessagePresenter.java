package jpinn.io.penguinchat.chat;

import jpinn.io.penguinchat.Message;

/**
 * Created by pujan on 6/14/2016.
 */
public interface MessagePresenter {
    void sendMessageToAdapter(Message message);
    void requestMessages();
}

