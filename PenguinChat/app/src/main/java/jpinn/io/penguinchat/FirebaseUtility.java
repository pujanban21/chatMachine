package jpinn.io.penguinchat;

import com.firebase.client.Firebase;
import java.text.SimpleDateFormat;
/**
 * Created by pujan on 6/13/2016.
 */
public class FirebaseUtility {
    private static Firebase mRef;
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddmmss");
    private static String TAG ="firebaseUtility";
    private static String COLUMN_TEXT ="text";
    private static String COLUMN_SENDER ="sender";

    public static Firebase getmRef(){
        if (mRef == null){
            mRef = new Firebase("https://penguin-chat-engine.firebaseio.com/Pujan");
        }
        return mRef;
    }

    
}
