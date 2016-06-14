package jpinn.io.penguinchat.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.Firebase;

import jpinn.io.penguinchat.R;

/**
 * Created by pujan on 6/14/2016.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener, MainView {
    private TextView mOnlineUsers;
    private Button mLoginButton;
    private Button mRegisterButton;
    private MainActivityPresenterImpl presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_1);
        Firebase.setAndroidContext(this);
        setUI();
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter = new MainActivityPresenterImpl(this);
        presenter.receiveRequest();
    }

    private void setUI() {
        mOnlineUsers = (TextView) findViewById(R.id.current_number_of_users_text_view);
        mLoginButton = (Button) findViewById(R.id.login_button);
        mLoginButton.setOnClickListener(this);
        mRegisterButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
            //startActivity(new Intent(this, LoginActivity.class));
    }

    @Override
    public void setNumberOfUsersTextView(String numberOfUsers) {
        mOnlineUsers.setText(numberOfUsers);
    }
}