package jpinn.io.penguinchat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by pujan on 6/14/2016.
 */
public class User implements Serializable {
    private String username;
    private String uid;
    private Date date;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

