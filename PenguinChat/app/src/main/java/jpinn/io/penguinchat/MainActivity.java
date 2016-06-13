package jpinn.io.penguinchat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.firebase.client.snapshot.StringNode;

public class MainActivity extends AppCompatActivity {
    TextView fireData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fireData = (TextView) findViewById(R.id.new_message);

        Firebase ref = FirebaseUtility.getmRef();
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String SuperData = (String)(dataSnapshot.getValue());
                fireData.setText(SuperData);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }
}
