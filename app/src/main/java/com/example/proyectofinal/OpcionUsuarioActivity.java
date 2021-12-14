package com.example.proyectofinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
public class OpcionUsuarioActivity extends AppCompatActivity {

        ConexionSQLiteHelper conn;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_opcion_usuario);

            conn = new ConexionSQLiteHelper(getApplicationContext(), "bd_usuarios", null, 1);

        }

        public void onClick(View view) {
            Intent miIntent = null;
            miIntent = new Intent(OpcionUsuarioActivity.this, RegistroAlimentoActivity.class);
            startActivity(miIntent);
        }

}