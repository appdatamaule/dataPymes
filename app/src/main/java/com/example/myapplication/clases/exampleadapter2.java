package com.example.myapplication.clases;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.ArrayList;


public class exampleadapter2 extends RecyclerView.Adapter<exampleadapter2.ExampleViewHolder> {
    private ArrayList<datoslista2> mExampleList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2;
        public TextView mTextView3;
        public TextView mTextView4;

        public ExampleViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageview69);
            mTextView1 = itemView.findViewById(R.id.text1);
            mTextView2 = itemView.findViewById(R.id.text2);
            mTextView3 = itemView.findViewById(R.id.text3);
            mTextView4 = itemView.findViewById(R.id.text4);



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

        }
    }

    public exampleadapter2(ArrayList<datoslista2> exampleList) {
        mExampleList = exampleList;
    }

    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notapendiente, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v, mListener);
        return evh;
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        datoslista2 currentItem = mExampleList.get(position);
        holder.mTextView1.setSelected(true);
        holder.mTextView1.setText(currentItem.getNombre_cliente());
        holder.mTextView2.setText("Total: "+currentItem.getTotal());
        holder.mTextView3.setText("Creada por: "+currentItem.getNombre_vendedor());
        holder.mTextView4.setText("Fecha: "+currentItem.getFecha());
        holder.mImageView.setImageResource(currentItem.getImagenid());
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }
    public void clear() {
        int size = mExampleList.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                mExampleList.remove(0);
            }

        }
    }
}
