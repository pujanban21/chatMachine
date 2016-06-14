package jpinn.io.penguinchat.users;

/**
 * Created by pujan on 6/14/2016.
 */

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

import jpinn.io.penguinchat.User;

class CurrentUsersInteractor {
    private final CurrentUsersPresenter presenter;
    private final Firebase currentUsersRef = new Firebase("https://<your-firebase>/currentUsers");

    public CurrentUsersInteractor(CurrentUsersPresenter pre) {
        this.presenter = pre;
    }

    public void request() {
        currentUsersRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<User> mListOfUsers = new ArrayList<>();
                for (DataSnapshot x : dataSnapshot.getChildren()) {
                    mListOfUsers.add(x.getValue(User.class));
                }
                presenter.getChildren(mListOfUsers);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });
    }
}
