package jpinn.io.penguinchat.chat;

import jpinn.io.penguinchat.Message;

/**
 * Created by pujan on 6/14/2016.
 */
public interface MessageAdapterView {
    void addItem(Message message);
    void request();
}

