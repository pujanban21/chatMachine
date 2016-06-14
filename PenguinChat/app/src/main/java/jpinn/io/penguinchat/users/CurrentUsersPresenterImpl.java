package jpinn.io.penguinchat.users;

import java.util.ArrayList;

import jpinn.io.penguinchat.User;

/**
 * Created by pujan on 6/14/2016.
 */
public class CurrentUsersPresenterImpl implements CurrentUsersPresenter {
    private final CurrentAdapterView adapterView;
    private final CurrentUsersInteractor interactor;


    public CurrentUsersPresenterImpl(CurrentAdapterView view) {
        this.adapterView = view;
        this.interactor = new CurrentUsersInteractor(this);
    }

    @Override
    public void getChildren(ArrayList<User> users) {
        adapterView.addAll(users);
    }

    @Override
    public void request() {
        interactor.request();
    }

}