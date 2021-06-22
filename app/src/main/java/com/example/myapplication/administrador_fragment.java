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
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.clases.adapterproductos;
import com.example.myapplication.clases.datosproductos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class administrador_fragment extends Fragment {
    ProgressDialog pd,pd2;
    Connection conexion=null;
    ArrayList<datosproductos> datosproductos;
    adapterproductos adapterproductos;
    RecyclerView recyclerView;

    //DATOS DE EMPRESA
    TextView nombreEmpresa;
    TextView rutEmpresa;
    TextView Categorias;

    //DATOS USUARIO
    TextView Usuario;
    TextView nombreUsuario;
    TextView nombreCompleto;
    TextView localAsignado;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_menu_admin, container, false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Menú Principal");

        nombreEmpresa = (TextView) view.findViewById(R.id.nombre_empresa);
        rutEmpresa = (TextView) view.findViewById(R.id.rut_empresa);
        Categorias = (TextView) view.findViewById(R.id.categoria_empresa);
        Usuario = (TextView) view.findViewById(R.id.usuario);
        nombreUsuario = (TextView) view.findViewById(R.id.nombre_usuario);
        nombreCompleto = (TextView) view.findViewById(R.id.nombre_completo_usuario);
        localAsignado = (TextView) view.findViewById(R.id.nombre_local);


        new llenarbodega(getContext(),"192.168.1.174","5432","postgres","159753","dataPymes").execute();
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
                String sql = "select e.nombre_empresa, e.rut_empresa, u.nombre_usuario, c.nombre_categoria, u.nombre_completo_usuario, l.nombre_local from empresa as e join usuario as u on u.id_usuario = e.id_empresa left join categoria as c on c.id_categoria = e.id_empresa left join local as l on l.id_local = u.id_usuario where u.id_usuario = 1";
                Statement st = conexion.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    String nombre_empresa = rs.getString(1);
                    String rut_empresa = rs.getString(2);
                    String nombre_usuario = rs.getString(3);
                    String nombre_categoria = rs.getString(4);
                    String nombre_completo_usuario = rs.getString(5);
                    String nombre_local = rs.getString(6);
                    nombreEmpresa.setText(nombre_empresa);
                    rutEmpresa.setText(rut_empresa);
                    Usuario.setText(nombre_usuario);
                    nombreUsuario.setText(nombre_usuario);
                    Categorias.setText(nombre_categoria);
                    nombreCompleto.setText(nombre_completo_usuario);
                    localAsignado.setText(nombre_local);
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
                pd2.dismiss();
            }
        }
    }
}
