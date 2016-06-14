package jpinn.io.penguinchat.main;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

/**
 * Created by pujan on 6/14/2016.
 */
public class MainInteractor implements MainInteractorInterface {
    private final Firebase mainRef = new Firebase("https://<your-firebase>/currentUsers");
    private final MainPresenterInterface presenter;

    public MainInteractor(MainPresenterInterface pre) {
        this.presenter = pre;
    }

    @Override
    public void receiveRequest() {
        mainRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                presenter.sendNumberOfChildren(dataSnapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });
    }
}