package jpinn.io.penguinchat.chat;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import jpinn.io.penguinchat.Message;
import jpinn.io.penguinchat.R;

/**
 * Created by pujan on 6/14/2016.
 */
public class CustomMessageRecyclerAdapter extends RecyclerView.Adapter<CustomMessageRecyclerAdapter.ViewHolder> implements MessageAdapterView {
    private final ArrayList<Message> mMessageList = new ArrayList<>();
    private final String user;
    private final MessagePresenterImpl presenter;
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddmmss");


    public CustomMessageRecyclerAdapter(String username) {
        this.user = username;
        presenter = new MessagePresenterImpl(this);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_message, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Message current = mMessageList.get(position);
        if (current.getmSender().equals(user)) {
            holder.mAuthorTextView.setText("You");
        } else {
            holder.mAuthorTextView.setText(current.getmSender());
        }
        holder.mMessageTextView.setText(current.getmText());
        holder.dateTextView.setText(dateFormat.format(current.getmDAte()));
    }

    @Override
    public int getItemCount() {
        return mMessageList.size();
    }

    @Override
    public void addItem(Message message) {
        mMessageList.add(message);
        notifyDataSetChanged();
    }

    @Override
    public void request() {
        presenter.requestMessages();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mAuthorTextView;
        private TextView mMessageTextView;
        private TextView dateTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mAuthorTextView = (TextView) itemView.findViewById(R.id.message_sender);
            mMessageTextView = (TextView) itemView.findViewById(R.id.message_value);
            dateTextView = (TextView) itemView.findViewById(R.id.message_date);
        }
    }
}
