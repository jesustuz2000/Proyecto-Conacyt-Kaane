package com.example.proyectofinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd_usuarios",null,1);
    }

    public void onClick(View view) {
        Intent miIntent=null;
        switch (view.getId()){
            case R.id.btnOpcionRegistro:
                miIntent=new Intent(MainActivity.this,RegistroUsuariosActivity.class);
                break;
            case R.id.btnAceptar:
                miIntent=new Intent(MainActivity.this, RegistroAlimentoActivity.class);
                break;
            case R.id.btnConsultaIndividual:
              miIntent=new Intent(MainActivity.this,ConsultarUsuariosActivity.class);
              break;
            case R.id.btnConsultaListaAlimento:
                miIntent=new Intent(MainActivity.this, ListaAlimentosActivity.class);
                break;
            case R.id.btnInicioSesion:
                miIntent=new Intent(MainActivity.this, InicioUsuarioActivity.class);
                break;
        }
        if (miIntent!=null){
            startActivity(miIntent);
        }

    }
}
