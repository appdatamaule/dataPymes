package com.example.myapplication.clases;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.ArrayList;


public class exampleadapterclientes extends RecyclerView.Adapter<exampleadapterclientes.ExampleViewHolder> {
    private ArrayList<datoslistaclientes> mExampleList;
    private OnItemClickListener mListener;
    private String id;
    public interface OnItemClickListener {
        void onItemClick(int position,String cuerpo);
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
        public TextView mTextView5;

        public ExampleViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageview69);
            mTextView1 = itemView.findViewById(R.id.text1);
            mTextView2 = itemView.findViewById(R.id.text2);
            mTextView3 = itemView.findViewById(R.id.text3);
            mTextView4 = itemView.findViewById(R.id.text4);
            mTextView5 = itemView.findViewById(R.id.text5);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            int dato=Integer.parseInt(mTextView5.getText().toString());
                            String cuerpo=mTextView1.getText().toString();
                            listener.onItemClick(dato,cuerpo);
                        }
                    }
                }
            });

        }
    }

    public exampleadapterclientes(ArrayList<datoslistaclientes> exampleList) {
        mExampleList = exampleList;
    }

    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_clientes, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v, mListener);
        return evh;
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        datoslistaclientes currentItem = mExampleList.get(position);
        holder.mTextView1.setSelected(true);
        holder.mTextView1.setText(currentItem.getNombre_cliente());
        holder.mTextView2.setText("Comuna: "+currentItem.getComuna());
        holder.mTextView3.setText("Rut: "+currentItem.getrut_cliente());
        holder.mTextView4.setText("Direccion: "+currentItem.getdireccion());
        holder.mImageView.setImageResource(currentItem.getImagenid());
        holder.mTextView5.setText(String.valueOf(currentItem.getid_cliente()));

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
    public void filtrar(ArrayList<datoslistaclientes> filtroUsuarios) {
        this.mExampleList = filtroUsuarios;
        notifyDataSetChanged();
    }
}
