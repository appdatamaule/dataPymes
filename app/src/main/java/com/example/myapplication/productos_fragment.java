package com.example.myapplication;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.myapplication.clases.adapterproductos;
import com.example.myapplication.clases.datosproductos;

import org.postgresql.replication.fluent.AbstractStreamBuilder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class productos_fragment extends Fragment {
    ProgressDialog pd,pd2;
    Connection conexion=null;
    ArrayList<datosproductos> datosproductos;
    adapterproductos adapterproductos;
    RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_menu_admin, container, false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("");

        datosproductos = new ArrayList<>();
        datosproductos=new ArrayList<>();
        recyclerView=view.findViewById(R.id.recyclerView);
        new llenarbodega(getContext(),"localhost","5432","postgres","159753","dataPymes").execute();
        return view;
    }
    public class llenarbodega extends AsyncTask<String, Void, String> {
        private final String db_servidor, db_puerto, db_usuario, db_contrasena, db_batabase;
        private final Context context;

        public llenarbodega(Context context, String db_servidor, String db_puerto, String db_usuario, String db_contrasena, String db_batabase) {
            this.db_servidor = db_servidor;
            this.context = context;
            this.db_puerto = db_puerto;
            this.db_usuario = db_usuario;
            this.db_contrasena = db_contrasena;
            this.db_batabase = db_batabase;

        }

        @Override
        protected void onPreExecute() {
            pd2 = ProgressDialog.show(context, "Cargando", "Obteniendo productos");
        }

        protected String doInBackground(final String... args) {
            try {
                Class.forName("org.postgresql.Driver");
                conexion = DriverManager.getConnection("jdbc:postgresql://" + db_servidor + ":" + db_puerto + "/" + db_batabase, db_usuario, db_contrasena);
                String sql = "select p.id_producto,p.nombre_producto,p.cbarra, dlp.total from producto p inner join detalle_lprecio dlp on p.id_producto=dlp.id_producto LIMIT 50";
                Statement st = conexion.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    String id_producto = rs.getString(1);
                    String nombre_producto = rs.getString(2);
                    String desc = rs.getString(3);
                    double bruto = rs.getDouble(4);
                    datosproductos.add(new datosproductos(id_producto, nombre_producto, desc, bruto));
                }
                conexion.close();

            } catch (ClassNotFoundException | SQLException e) {
                Toast toast = Toast.makeText(getContext(), "error" + e.toString(), Toast.LENGTH_SHORT);
                toast.show();

            }

            return "Exito";
        }

        protected void onPostExecute(String success) {
            if (success.equals("Exito")) {
                buildRecyclerView();
                pd2.dismiss();
            }
        }
    }
    public void buildRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterproductos = new adapterproductos(datosproductos);
        recyclerView.setAdapter(adapterproductos);
        adapterproductos.setOnItemClickListener(new adapterproductos.OnItemClickListener(){
            @Override
            public void onItemClick(String id_producto, String nombre_producto, String desc, String bruto) {
                Toast toast = Toast.makeText(getContext(), "aaaaaa", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}
