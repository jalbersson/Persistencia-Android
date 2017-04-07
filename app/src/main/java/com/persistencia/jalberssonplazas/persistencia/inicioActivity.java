package com.persistencia.jalberssonplazas.persistencia;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class inicioActivity extends AppCompatActivity
{

    EditText correoIn, usuarioIn, correoOut, usuarioOut;
    Button btnGuardar, btnMostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        correoIn=(EditText) findViewById(R.id.etxtCorreoIn);
        correoOut=(EditText) findViewById(R.id.etxtCorreoOut);
        usuarioIn=(EditText) findViewById(R.id.etxtUsuarioIn);
        usuarioOut=(EditText) findViewById(R.id.etxtUsuarioOut);
        btnGuardar=(Button) findViewById(R.id.btnGuardar);
        btnMostrar=(Button) findViewById(R.id.btnMostrar);

        btnGuardar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                SharedPreferences.Editor editor= getSharedPreferences("misPreferencias",MODE_PRIVATE).edit();
                if(correoIn.getText().toString().equals("") ||usuarioIn.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Debe ingresar los datos primero", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    editor.putString("mail",correoIn.getText().toString());
                    editor.putString("usuario",usuarioIn.getText().toString());
                    editor.commit();
                }
            }
        });
        btnMostrar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                SharedPreferences preferences;
                preferences=getSharedPreferences("misPreferencias", Context.MODE_PRIVATE);
                correoOut.setText(preferences.getString("mail",""));
                usuarioOut.setText(preferences.getString("usuario",""));
            }
        });
    }
}
