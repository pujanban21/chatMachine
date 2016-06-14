package jpinn.io.penguinchat.chat;

/**
 * Created by pujan on 6/14/2016.
 */
public class FirebaseChatLoginPresenterImpl implements FirebaseChatLoginPresenter {
    private final ChatLoginInteractor interactor;

    public FirebaseChatLoginPresenterImpl() {
        this.interactor = new ChatLoginInteractor();
    }

    @Override
    public void removeUserFromCurrentUsers(String uid) {
        interactor.logTheUserOut(uid);
    }
}
