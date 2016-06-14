package jpinn.io.penguinchat.chat;

/**
 * Created by pujan on 6/14/2016.
 */
public class FirebaseChatMessagePresenterImpl implements FirebaseChatMessagePresenter {
    private final ChatMessageInteractor interactor;

    public FirebaseChatMessagePresenterImpl() {
        this.interactor = new ChatMessageInteractor();
    }

    @Override
    public void sendMessage(String author, String message, String emoji) {
        interactor.pushMessageToFirebase(author, message, emoji);
    }
}
