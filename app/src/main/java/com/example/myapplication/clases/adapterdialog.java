package com.example.myapplication.clases;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.ArrayList;


public class adapterdialog extends RecyclerView.Adapter<adapterdialog.ExampleViewHolder> {
    private ArrayList<datos> mExampleList;
    private OnItemClickListener mListener;
    public interface OnItemClickListener {
        void onItemClick(int position, String cuerpo);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }
    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView1;
        public TextView mTextView2;

        public ExampleViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            mTextView1 = itemView.findViewById(R.id.text);
            mTextView2 = itemView.findViewById(R.id.text2);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            int dato=Integer.parseInt(mTextView2.getText().toString());
                            String cuerpo=mTextView1.getText().toString();
                            listener.onItemClick(dato,cuerpo);
                        }
                    }
                }
            });

        }
    }
    public adapterdialog(ArrayList<datos> exampleList) {
        mExampleList = exampleList;
    }
    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dialog, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v, mListener);
        return evh;
    }
    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        datos currentItem = mExampleList.get(position);
        holder.mTextView1.setSelected(true);
        holder.mTextView1.setText(currentItem.getObjeto());
        holder.mTextView2.setText(currentItem.getId());
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
    public void filtrar(ArrayList<datos> filtroUsuarios) {
        this.mExampleList = filtroUsuarios;
        notifyDataSetChanged();
    }
}
