package com.example.myapplication.clases;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.ArrayList;


public class exampleadaptersucursales extends RecyclerView.Adapter<exampleadaptersucursales.ExampleViewHolder> {
    private ArrayList<datoslistasucursales> mExampleList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int id,String nombre,String direccion,String comuna,String idcomuna,String referencia);
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
        public TextView mTextView6;

        public ExampleViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageview69);
            mTextView1 = itemView.findViewById(R.id.text1);
            mTextView2 = itemView.findViewById(R.id.text2);
            mTextView3 = itemView.findViewById(R.id.text3);
            mTextView4 = itemView.findViewById(R.id.text4);
            mTextView5 = itemView.findViewById(R.id.text5);
            mTextView6 = itemView.findViewById(R.id.text6);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            int id=Integer.parseInt(mTextView5.getText().toString());
                            String nombreb=mTextView2.getText().toString();
                            String direccion=mTextView1.getText().toString();
                            String comunab=mTextView3.getText().toString();
                            String idcomuna=mTextView6.getText().toString();
                            String referenciab=mTextView4.getText().toString();
                            String nombre=nombreb.replace("Cliente: ","");
                            String comuna=comunab.replace("Comuna: ","");
                            String referencia=referenciab.replace("Referencia: ","");
                            listener.onItemClick(id,nombre,direccion,comuna,idcomuna,referencia);
                        }
                    }
                }
            });

        }
    }

    public exampleadaptersucursales(ArrayList<datoslistasucursales> exampleList) {
        mExampleList = exampleList;
    }

    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sucursales, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v, mListener);
        return evh;
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        datoslistasucursales currentItem = mExampleList.get(position);
        holder.mTextView1.setSelected(true);
        holder.mTextView1.setText(currentItem.getDireccion());
        holder.mTextView2.setText("Cliente: "+currentItem.getNombre_cliente());
        holder.mTextView3.setText("Comuna: "+currentItem.getComuna());
        holder.mTextView4.setText("Referencia: "+currentItem.getReferencia());
        holder.mImageView.setImageResource(currentItem.getImagenid());
        holder.mTextView5.setText(String.valueOf(currentItem.getId_sucursal()));
        holder.mTextView6.setText(String.valueOf(currentItem.getIdcomuna()));
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
    public void filtrar(ArrayList<datoslistasucursales> filtroUsuarios) {
        this.mExampleList = filtroUsuarios;
        notifyDataSetChanged();
    }
}
