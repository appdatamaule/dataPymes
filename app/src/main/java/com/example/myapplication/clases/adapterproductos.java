package com.example.myapplication.clases;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.ArrayList;


public class adapterproductos extends RecyclerView.Adapter<adapterproductos.ExampleViewHolder> {
    private ArrayList<datosproductos> mExampleList;
    private OnItemClickListener mListener;
    private final double precioe;

    public interface OnItemClickListener {
        void onItemClick(String id_producto, String nombre_producto, String desc, double bruto);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView0;
        public TextView mTextView1;
        public TextView mTextView2;
        public TextView mTextView3;
        public ImageView imagen;

        public ExampleViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            mTextView0 = itemView.findViewById(R.id.id_producto);
            mTextView1 = itemView.findViewById(R.id.nombre_producto);
            mTextView2 = itemView.findViewById(R.id.precio);
            mTextView3 = itemView.findViewById(R.id.desc);

            imagen= itemView.findViewById(R.id.imageview69);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            String id_producto=mTextView0.getText().toString();
                            String nombre_producto=mTextView1.getText().toString();
                            String precio=mTextView2.getText().toString();
                            String desc=mTextView3.getText().toString();
                            listener.onItemClick(id_producto,nombre_producto,desc,precio);
                        }
                    }
                }
            });

        }
    }

    public adapterproductos(ArrayList<datosproductos> exampleList) {
        mExampleList = exampleList;
    }

    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_productos, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v, mListener);
        return evh;
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        datosproductos currentItem = mExampleList.get(position);
        holder.imagen.setImageResource(R.drawable.datamaule);
        holder.mTextView0.setText(currentItem.getId_producto());
        holder.mTextView1.setSelected(true);
        holder.mTextView1.setText(currentItem.getNombre_producto());
        precio=currentItem.getBruto();
        int bruto_redondeado= (int) Math.round(currentItem.getBruto());
        holder.mTextView2.setText(String.valueOf(bruto_redondeado));
        holder.mTextView3.setText(currentItem.getDesc());
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
    public void filtrar(ArrayList<datosproductos> filtroUsuarios) {
        this.mExampleList = filtroUsuarios;
        notifyDataSetChanged();
    }
}
