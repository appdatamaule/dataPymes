package com.example.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.myapplication.clases.JSONParser;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class LOGIN extends AppCompatActivity {
    String token,id_usuario;
    EditText usuario,passw;
    TextView database;
    Button login;
    SharedPreferences mPrefs;
    String uss,pas,dat,mensaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l_o_g_i_n);
        usuario = findViewById(R.id.ussr);
        passw = findViewById(R.id.pass);
        login = findViewById(R.id.lgin);
        database = findViewById(R.id.database);
        mPrefs = getSharedPreferences("label", 0);
        String mString = mPrefs.getString("database", "");
        String mString2 = mPrefs.getString("USER", "");
        String mString3 = mPrefs.getString("PASS", "");
        final SharedPreferences.Editor mEditor = mPrefs.edit();
        usuario.setText(mString2);
        passw.setText(mString3);
        database.setText(mString);
        database.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(LOGIN.this);
                builder.setTitle("Ingrese la base de datos");
                final EditText input = new EditText(LOGIN.this);
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setView(input);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dat = input.getText().toString();
                        dat=dat.toUpperCase();

                        mEditor.putString("database", dat).apply();
                        database.setText(dat);
                    }
                });
                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.show();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uss = usuario.getText().toString();
                pas = passw.getText().toString();
                dat = database.getText().toString();
                int resp= textvalido();
                uss =uss.toUpperCase();
                if(dat.equals("")){
                    AlertDialog.Builder dialogo1 = new AlertDialog.Builder(LOGIN.this);
                    dialogo1.setTitle("Error");
                    dialogo1.setMessage("Escriba una base de datos");
                    dialogo1.setCancelable(false);
                    dialogo1.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogo1, int id) {
                            dialogo1.dismiss();
                        }
                    });
                    dialogo1.show();
                }else{
                    if (resp!=0) {
                        try {
                            mEditor.putString("USER", uss).apply();
                            mEditor.putString("PASS", pas).apply();
                            GetText(uss,pas,dat);
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
    }
    public void GetText(String usuario,String contrasena,String database) throws  UnsupportedEncodingException {
        String data = URLEncoder.encode("username", "UTF-8")+"="+URLEncoder.encode(usuario, "UTF-8");
        data += "&"+URLEncoder.encode("password", "UTF-8")+"="+URLEncoder.encode(contrasena, "UTF-8");
        data += "&"+URLEncoder.encode("db", "UTF-8")+"="+URLEncoder.encode(database, "UTF-8");
        new recibirdatos2(getApplicationContext(), data, usuario).execute();
    }
    public class recibirdatos2 extends AsyncTask<String, Void, String> {
        private Context context;
        private String usuario, data;
        public recibirdatos2(Context context,String data,String usuarrio){
            this.context=context;
            this.data=data;
            this.usuario=usuarrio;
        }
        protected  String doInBackground(final String... args){
            boolean internet=isNetworkAvailable();
            if(internet){
                String urlvar="http://192.168.1.84:3000/login";
                JSONParser jParser = new JSONParser();
                JSONObject json = jParser.enviarpostlogin(urlvar,data);
                for (int i=0; i< json.length();i++) {
                    try {
                        mensaje=json.getString("mensaje");
                        if(mensaje.equals("Autenticación correcta")){
                            token=json.getString("token");
                            id_usuario=json.getString("IDuser");
                        }else{
                            if(mensaje.equals("Usuario o contraseña incorrectos")){
                                return "conmala";
                            }else{
                                if(mensaje.equals("La base de datos ingresada no existe")){
                                    return "nodb";
                                }
                            }
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        return "Error creando variables";
                    }
                }
                return "internetsi";
            }else{
                return "internetno";
            }
        }
        protected void onPostExecute(String success){
            if(success.equals("internetsi")){
                Intent intent = new Intent();
                intent.putExtra("nombre", usuario);
                intent.putExtra("rol", "Vendedor");
                intent.putExtra("token", token);
                intent.putExtra("id_usuario",id_usuario);
                String dat2=dat.replace(" ","+");
                intent.putExtra("db",dat2);
                setResult(RESULT_OK,intent);
                finish();
            }else{
                if(success.equals("internetno")){
                    sinconexion();
                }else{
                    if(success.equals("conmala")){
                        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(LOGIN.this);
                        dialogo1.setTitle("Datos incorrectos");
                        dialogo1.setMessage("Los datos ingresados no son correctos, intentelo nuevamente");
                        dialogo1.setCancelable(false);
                        dialogo1.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogo1, int id) {
                                dialogo1.dismiss();
                            }
                        });
                        dialogo1.show();
                    }else{
                        if(success.equals("nodb")){
                            AlertDialog.Builder dialogo1 = new AlertDialog.Builder(LOGIN.this);
                            dialogo1.setTitle("Error");
                            dialogo1.setMessage("Base de datos no encontrada");
                            dialogo1.setCancelable(false);
                            dialogo1.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialogo1, int id) {
                                    dialogo1.dismiss();
                                }
                            });
                            dialogo1.show();
                        }
                    }
                }
            }
        }
    }
    public int textvalido(){
        if(pas.equals("") && uss.equals("")){
            Toast toast = Toast.makeText(this, "Porfavor! Escriba su nombre de usuario y contraseña!", Toast.LENGTH_SHORT);
            toast.show();
            return 0;
        }else{
            if(pas.equals("")){
                Toast toast = Toast.makeText(this, "Porfavor! Escriba la contraseña!", Toast.LENGTH_SHORT);
                toast.show();
                return 0;
            }else{
                if(uss.equals("")){
                    Toast toast = Toast.makeText(this, "Porfavor! Escriba el nombre de usuario!", Toast.LENGTH_SHORT);
                    toast.show();
                    return 0;
                }else{
                    return 1;
                }
            }
        }
    }
    @Override
    public void onBackPressed() {
    }
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
    public void sinconexion(){
        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(LOGIN.this);
        dialogo1.setTitle("Sin conexión");
        dialogo1.setMessage("Vuelva a intentarlo más tarde por favor");
        dialogo1.setCancelable(false);
        dialogo1.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                dialogo1.dismiss();
            }
        });
        dialogo1.show();
    }
}