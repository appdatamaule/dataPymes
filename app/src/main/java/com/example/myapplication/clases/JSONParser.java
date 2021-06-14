package com.example.myapplication.clases;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

public class JSONParser {
    static JSONArray jarray2= null;
    static JSONArray jarray3= null;
    JSONObject jsonObject,jsonObject2;
    //url es http://192.168.1.84:3000/
    public JSONParser(){

    }

    public JSONArray Getcontoken(String url,String token){
        jarray2=null;
        StringBuilder builder = new StringBuilder();
        HttpClient client = new DefaultHttpClient();
        HttpGet getData = new HttpGet(url);
        getData.setHeader("x-access-token",token);
        try {
            HttpResponse response = client.execute(getData);
            StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            if (statusCode == 200){
                HttpEntity entity = response.getEntity();
                InputStream content = entity.getContent();
                BufferedReader reader = new BufferedReader(new InputStreamReader(content));
                String line;
                while ((line = reader.readLine())!=null) {
                    builder.append(line);
                }
            }else{
                Log.e("==>"," fallo la descarga de JSON");

            }

        }catch(ClientProtocolException e){
            System.out.println("Error " + e.getMessage());

        } catch (IOException e2) {
            System.out.println("Error " + e2.getMessage());
        }
        try {
            jarray2 = new JSONArray(builder.toString());

        }catch (JSONException e){
            Log.e("JSON Parser","Error traduciendo datos"+ e.toString());
        }

        return  jarray2;
    }
    public JSONObject Getcontoken2(String url, String token){
        jsonObject2=null;
        StringBuilder builder = new StringBuilder();
        HttpClient client = new DefaultHttpClient();
        HttpGet getData = new HttpGet(url);
        getData.setHeader("x-access-token",token);
        try {
            HttpResponse response = client.execute(getData);
            StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            if (statusCode == 200){
                HttpEntity entity = response.getEntity();
                InputStream content = entity.getContent();
                BufferedReader reader = new BufferedReader(new InputStreamReader(content));
                String line;
                while ((line = reader.readLine())!=null) {
                    builder.append(line);
                }
            }else{
                Log.e("==>"," fallo la descarga de JSON");

            }

        }catch(ClientProtocolException e){
            System.out.println("Error " + e.getMessage());

        } catch (IOException e2) {
            System.out.println("Error " + e2.getMessage());
        }
        try {
            jsonObject2 = new JSONObject(builder.toString());

        }catch (JSONException e){
            Log.e("JSON Parser","Error traduciendo datos"+ e.toString());
        }

        return  jsonObject2;
    }
    public JSONObject enviarpost(String urlx,String datax,String token){
        BufferedReader reader=null;
        StringBuilder sb = new StringBuilder();
        try
        {
            URL url = new URL(urlx);
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestProperty("x-access-token",token);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(datax);
            wr.flush();
            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            sb = new StringBuilder();
            String line = null;
            while((line = reader.readLine()) != null)
            {
                sb.append(line + "\n");
            }
        }
        catch(Exception ex)
        {
        }
        finally
        {
            try
            {
                reader.close();
            }

            catch(Exception ex) {
            }
        }
        try {
            jsonObject =new JSONObject(sb.toString());

        }catch (JSONException e){
            Log.e("JSON Parser","Error traduciendo datos"+ e.toString());
        }
        return jsonObject;
    }
    public JSONArray enviarpost2(String urlx,String datax,String token){
        BufferedReader reader=null;
        StringBuilder sb = new StringBuilder();
        try
        {
            URL url = new URL(urlx);
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestProperty("x-access-token",token);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(datax);
            wr.flush();
            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            sb = new StringBuilder();
            String line = null;
            while((line = reader.readLine()) != null)
            {
                sb.append(line + "\n");
            }
        }
        catch(Exception ex)
        {
        }
        finally
        {
            try
            {
                reader.close();
            }

            catch(Exception ex) {
            }
        }
        try {
            jarray3 = new JSONArray(sb.toString());

        }catch (JSONException e){
            Log.e("JSON Parser","Error traduciendo datos"+ e.toString());
        }
        return jarray3;
    }
    public JSONObject enviarpostlogin(String urlx, String datax){
        BufferedReader reader=null;
        StringBuilder sb = new StringBuilder();
        try
        {
            URL url = new URL(urlx);
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(datax);
            wr.flush();
            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = null;
            while((line = reader.readLine()) != null)
            {
                sb.append(line);
            }
        }
        catch(Exception ex)
        {

        }
        finally
        {
            try
            {

                reader.close();

            }

            catch(Exception ex) {
            }
        }
        try {
            jsonObject =new JSONObject(sb.toString());

        }catch (JSONException e){
            Log.e("JSON Parser","Error traduciendo datos"+ e.toString());
        }
        return jsonObject;
    }

}

