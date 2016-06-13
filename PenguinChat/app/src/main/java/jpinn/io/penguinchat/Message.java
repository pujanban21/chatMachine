package jpinn.io.penguinchat;

import java.util.Date;

/**
 * Created by pujan on 6/13/2016.
 */
public class Message {

    private String mText;
    private String mSender;
    private Date mDAte;

    public String getmText() {
        return mText;
    }

    public void setmText(String mText) {
        this.mText = mText;
    }

    public String getmSender() {
        return mSender;
    }

    public void setmSender(String mSender) {
        this.mSender = mSender;
    }

    public Date getmDAte() {
        return mDAte;
    }

    public void setmDAte(Date mDAte) {
        this.mDAte = mDAte;
    }
}
