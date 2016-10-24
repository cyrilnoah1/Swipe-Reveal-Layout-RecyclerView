package com.cyril.training.dayseventeen;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.chauthai.swipereveallayout.SwipeRevealLayout;
import com.chauthai.swipereveallayout.ViewBinderHelper;

import java.util.List;

/**
 * RecyclerAdapter for using TimelineView library to populate the list items with timeline icons.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.TimeLineViewHolder> {
    // List containing RecyclerData to populate the RecyclerView.
    private List<RecyclerData> gameList;
    private final ViewBinderHelper binderHelper = new ViewBinderHelper();
    private Context mContext;

    public class TimeLineViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        SwipeRevealLayout swipeRevealLayout;
        Button btnDelete;

        public TimeLineViewHolder(View itemView, int viewType) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.textView_for_genre);


            btnDelete = (Button) itemView.findViewById(R.id.btn_delete);

            swipeRevealLayout = (SwipeRevealLayout) itemView.findViewById(R.id.swipe_reveal_view);
        }
    }

    /**
     * Setting the Recycler List's data to RecyclerData
     *
     * @param gameList
     */
    public RecyclerAdapter(List<RecyclerData> gameList, Context context) {
        this.gameList = gameList;
        this.mContext = context;
    }

    @Override
    public TimeLineViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        // Inflating the Recycler view.
        final View view = View.inflate(parent.getContext(), R.layout.recycler_view_layout, null);

        return new TimeLineViewHolder(view, viewType);
    }

    /**
     * Method to bind the required data to the RecyclerView.
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(final TimeLineViewHolder holder, final int position) {
        RecyclerData recyclerData = gameList.get(position);

        holder.mTextView.setText(recyclerData.getTextData());

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Position: " + String.valueOf(position + 1),
                        Toast.LENGTH_SHORT).show();
            }
        });

        binderHelper.bind(holder.swipeRevealLayout, String.valueOf(position));
        binderHelper.setOpenOnlyOne(true);

    }

    @Override
    public int getItemCount() {
        return gameList.size();
    }
}
