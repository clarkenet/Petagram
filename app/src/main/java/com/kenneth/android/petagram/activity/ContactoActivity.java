package com.kenneth.android.petagram.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.kenneth.android.petagram.R;
import com.kenneth.android.petagram.utils.SendMail;

public class ContactoActivity extends AppCompatActivity {

    private static final int CODIGO_SOLICITUD_PERMISO = 1;
    TextInputLayout tilName;
    TextInputLayout tilEmail;
    TextInputLayout tilComments;
    TextInputEditText tieName;
    TextInputEditText tieEmail;
    TextInputEditText tieComments;
    Button btnComments;
    String name, email, comments;
    SendMail sendMail;
    Context context;
    Activity activity;
    Toolbar toolbarGral;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        context = getApplicationContext();
        activity = this;

        toolbarGral = (Toolbar) findViewById(R.id.toolbarGral);
        if (toolbarGral != null) {
            setSupportActionBar(toolbarGral);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        tilName = (TextInputLayout) findViewById(R.id.tilName);
        tilEmail = (TextInputLayout) findViewById(R.id.tilEmail);
        tilComments = (TextInputLayout) findViewById(R.id.tilComments);
        tieName = (TextInputEditText) findViewById(R.id.tieName);
        tieEmail = (TextInputEditText) findViewById(R.id.tieEmail);
        tieComments = (TextInputEditText) findViewById(R.id.tieComments);
        btnComments = (Button) findViewById(R.id.btnComments);

        tieName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                tilName.setErrorEnabled(false);
            }
        });

        tieEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                tilEmail.setErrorEnabled(false);
            }
        });

        tieComments.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                tilComments.setErrorEnabled(false);
            }
        });

        btnComments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name = tieName.getText().toString();
                email = tieEmail.getText().toString();
                comments = tieComments.getText().toString();
                int flag = 0;

                if (!isOnline()) {
                    flag = 1;
                }

                if (tieName.length() < 1) {
                    tilName.setErrorEnabled(true);
                    tilName.setError("Este campo es requerido");
                    flag = 1;
                } else {
                    tilName.setErrorEnabled(false);
                    tilName.setError(null);
                }

                if (tieEmail.length() < 1) {
                    tilEmail.setErrorEnabled(true);
                    tilEmail.setError("Este campo es requerido");
                    flag = 1;
                } else {
                    tilEmail.setErrorEnabled(false);
                    tilEmail.setError(null);
                }

                if (tieComments.length() < 1) {
                    tilComments.setErrorEnabled(true);
                    tilComments.setError("Este campo es requerido");
                    flag = 1;
                } else {
                    tilComments.setErrorEnabled(false);
                    tilComments.setError(null);
                }

                if (flag == 0) {
                    sendMail = new SendMail(comments, email, name);
                    if (sendMail.isSended()) {
                        Toast.makeText(ContactoActivity.this, "Mensaje enviado!", Toast.LENGTH_SHORT).show();
                        tieName.setText("");
                        tieEmail.setText("");
                        tieComments.setText("");
                    } else {
                        Toast.makeText(ContactoActivity.this, "Error al enviar el mensaje!", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

    }


    private boolean isOnline() {

        solicitarPermiso();
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checarPermisos() {
        int resultado = ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_NETWORK_STATE);
        int resultado2 = ContextCompat.checkSelfPermission(context, Manifest.permission.INTERNET);
        if(resultado == PackageManager.PERMISSION_GRANTED && resultado2 == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }

    private void solicitarPermiso() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.ACCESS_NETWORK_STATE) &&
                ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.INTERNET)) {
            Toast.makeText(ContactoActivity.this, "El Permiso ya fue otorgado", Toast.LENGTH_SHORT).show();
        } else {
            ActivityCompat.requestPermissions(activity, new String[] {Manifest.permission.ACCESS_NETWORK_STATE, Manifest.permission.INTERNET}, CODIGO_SOLICITUD_PERMISO);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        
        switch (requestCode) {
            case CODIGO_SOLICITUD_PERMISO:
                if (checarPermisos()) {
                    Toast.makeText(ContactoActivity.this, "Ya esta activo el permiso para conexion a Internet", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ContactoActivity.this, "No esta activo el permiso para conexión a Internet", Toast.LENGTH_SHORT).show();
                }
                break;
        }
        
    }
}
