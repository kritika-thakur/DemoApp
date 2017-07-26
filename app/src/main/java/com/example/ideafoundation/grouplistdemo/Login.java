package com.example.ideafoundation.grouplistdemo;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.multidex.MultiDex;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity implements View.OnClickListener{

    EditText phn, passwrd;
    Button sign_in, sign_up;
    ImageView clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        phn=(EditText)findViewById(R.id.phoneNumber);
        passwrd=(EditText)findViewById(R.id.Password);
        sign_in=(Button) findViewById(R.id.sign_in);
        sign_up=(Button) findViewById(R.id.sign_up);
        sign_in.setOnClickListener(this);
        clear=(ImageView) findViewById(R.id.imageclose);
        clear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //v.getId() will give you the image id
                phn.setText("");
            }
        });
        //statuscheck
        /*SharedPreferences sharedPrf= getSharedPreferences("mypref", 0);
        String statuscheck = sharedPrf.getString("status", null);
        if(statuscheck != null) {
            String tokencheck = sharedPrf.getString("token", null);
            if(tokencheck != null) {
                String licensecheck = sharedPrf.getString("license", null);
                if(licensecheck != null) {
                   launchHome(statuscheck,tokencheck,licensecheck);
                }
            }
        }*/
    }

    private void launchHome(String code, String tok, String lic) {
        Intent intent=new Intent(Login.this,MainActivity.class);
        intent.putExtra("code",code);
        intent.putExtra("token",tok);
        intent.putExtra("license",lic);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.sign_in:
                SignIn();
                break;
            case R.id.sign_up:
                break;
        }
    }
    public void SignIn()
    {
        final ProgressDialog pd = new ProgressDialog(this);
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pd.setMessage("Signing in.....");
        pd.setIndeterminate(true);
        pd.setCancelable(false);
        pd.show();

        final String username = phn.getText().toString().trim();
        final String password = passwrd.getText().toString().trim();

        String url="https://pandayg-api-staging.azurewebsites.net/v1/auth/signin";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {


                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String array = jsonObject.getString("data");
                            String status = jsonObject.getString("code");
                            JSONObject jsonObjec = new JSONObject(array);
                            String token = jsonObjec.getString("token");
                            String license = jsonObjec.getString("license");
                            // Create object of SharedPreferences.
                            SharedPreferences sharedPref= getSharedPreferences("mypref", 0);
                            SharedPreferences.Editor editor= sharedPref.edit();
                            editor.putString("status", status);
                            editor.putString("token",token);
                            editor.putString("license", license);
                            editor.commit();
                            launchHome(status,token,license);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        pd.dismiss();
                        Toast.makeText(Login.this,error.toString(),Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put("phoneNumber",username);
                params.put("password",password);
                return params;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
        pd.dismiss();
    }

}
