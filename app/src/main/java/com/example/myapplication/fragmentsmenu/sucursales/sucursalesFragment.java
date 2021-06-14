package com.example.myapplication.fragmentsmenu.sucursales;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.example.myapplication.R;



public class sucursalesFragment extends Fragment {
    RecyclerView recyclerView;

    Button agregarcliente;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_sucursales, container, false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Sucursales");
        recyclerView=view.findViewById(R.id.recyclerView);
        agregarcliente=view.findViewById(R.id.botonagregarcliente);
        return view;
    }
}
