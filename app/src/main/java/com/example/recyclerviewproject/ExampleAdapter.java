package com.example.recyclerviewproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {
    private ArrayList<ExampleItem> mExampleList;

    /**
     * Constructor
     * @param exampleList
     */
    public ExampleAdapter(ArrayList<ExampleItem> exampleList) {
        mExampleList = exampleList;
    }

    // Global Initialization
    private OnItemClickListener mListener;

    /**
     * Interface Creation
     */
    public interface OnItemClickListener {
        void onItemClick(int position);
        void onDeleteIconClick(int position);
    }

    /**
     * Setting listener
     * @param listener
     */
    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    /**
     * ViewHolder Creation
     */
    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2;
        public ImageView mDeleteIcon;
        public ExampleViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView);
            mTextView1 = itemView.findViewById(R.id.textView1);
            mTextView2 = itemView.findViewById(R.id.textView2);
            /**
             * ItemView OnCLickListener
             * It is for when we click on an item view,
             * it will change its TEXT1 Value.
             */
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
            /**
             * Delete Icon Image OnClockListener
             * It is for when clicking on Delete Icon,
             * it will remove the itemView.
             */
            mDeleteIcon = itemView.findViewById(R.id.image_delete);
            mDeleteIcon.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onDeleteIconClick(position);
                        }
                    }
                }
            });
        }
    }

    /**
     * This method is called when the adapter is created and
     * is used to initialize your ViewHolder
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v, mListener);
        return evh;
    }

    /**
     * This method is called for each ViewHolder to bind it to the adapter.
     * This is where we will pass our data to our ViewHolder
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        ExampleItem currentItem = mExampleList.get(position);
        holder.mImageView.setImageResource(currentItem.getImageResource());
        holder.mTextView1.setText(currentItem.getText1());
        holder.mTextView2.setText(currentItem.getText2());
    }

    /**
     * This method returns the size of the collection
     * that contains the items we want to display
     * @return
     */
    @Override
    public int getItemCount() {
        return mExampleList.size();
    }
}