package jpinn.io.penguinchat;

import android.util.Log;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by pujan on 6/14/2016.
 */
public class MessageUtility {
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddmmss");
    private static String TAG ="firebaseUtility";
    private static String COLUMN_TEXT ="text";
    private static String COLUMN_SENDER ="sender";

    private static Firebase firebaseRef = FirebaseUtility.getmRef();

    public static void saveMessage(Message message,String convoId){
        Date date = message.getmDAte();
        String key = dateFormat.format(date);
        HashMap<String, String> msg = new HashMap<>();
        msg.put(COLUMN_TEXT,message.getmText());
        msg.put(COLUMN_SENDER, "Ashok");

        firebaseRef.child(convoId).child(key).setValue(msg);
    }


    public static MessagesListener addMessagesListener(String convoId, final MesssageCallBack callback){
        MessagesListener listener = new MessagesListener(callback);
        firebaseRef.child(convoId).addChildEventListener(listener);
        return listener;

    }

    public static void stop(MessagesListener listener){
        firebaseRef.removeEventListener(listener);
    }

    public static class MessagesListener implements ChildEventListener {
        private MesssageCallBack callBack;
        MessagesListener(MesssageCallBack callBack){
            this.callBack = callBack;
        }
        @Override
        public void onChildAdded(DataSnapshot dataSnapshot, String s) {
            HashMap<String, String> msg = (HashMap<String,String>)dataSnapshot.getValue();
            Message message = new Message();
            message.setmSender(msg.get(COLUMN_SENDER));
            message.setmText((msg.get(COLUMN_TEXT)));

            try {
                message.setmDAte(dateFormat.parse(dataSnapshot.getKey()));
            } catch (ParseException e) {
                Log.d(TAG, "Couldn't parse the data" + e);
            }

            if(callBack!=null){
                callBack.onMessageAdd(message);
            }
        }

        @Override
        public void onChildChanged(DataSnapshot dataSnapshot, String s) {

        }

        @Override
        public void onChildRemoved(DataSnapshot dataSnapshot) {

        }

        @Override
        public void onChildMoved(DataSnapshot dataSnapshot, String s) {

        }

        @Override
        public void onCancelled(FirebaseError firebaseError) {

        }
    }

    public interface MesssageCallBack{
        public void onMessageAdd(Message message);
    }
}
