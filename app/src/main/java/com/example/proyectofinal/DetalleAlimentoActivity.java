package com.example.proyectofinal;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.proyectofinal.entidades.Alimento;
import com.example.proyectofinal.utilidades.Utilidades;

public class DetalleAlimentoActivity extends AppCompatActivity {

    ConexionSQLiteHelper conn;
    TextView  campoNombreMascota, campoRaza;
    TextView campoIdPersona, campoNombrePersona, campoTelefonoPersona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_alimentos);

        conn=new ConexionSQLiteHelper(getApplicationContext(),"bd_usuarios",null,1);

        campoIdPersona = (TextView) findViewById(R.id.campoId);
        campoNombrePersona = (TextView) findViewById(R.id.campoNombre);
        campoTelefonoPersona = (TextView) findViewById(R.id.campoTelefono);

        //campoIdMascota = (TextView) findViewById(R.id.campoIdMascota);
        campoNombreMascota = (TextView) findViewById(R.id.campoNombreMascota);
        campoRaza = (TextView) findViewById(R.id.campoRaza);

        Bundle objetoEnviado=getIntent().getExtras();
        Alimento alimento =null;

        if(objetoEnviado!=null){
            alimento = (Alimento) objetoEnviado.getSerializable("mascota");
           // campoIdMascota.setText(mascota.getIdMascota().toString());
            campoNombreMascota.setText(alimento.getNombreMascota().toString());
            campoRaza.setText(alimento.getRaza().toString());
            consultarPersona(alimento.getIdDuenio());
        }

    }

    private void consultarPersona(String idPersona) {
        SQLiteDatabase db=conn.getReadableDatabase();
        String[] parametros={idPersona.toString()};
        String[] campos={Utilidades.CAMPO_NOMBRE,Utilidades.CAMPO_TELEFONO};
        Toast.makeText(getApplicationContext(),"El documento "+idPersona,Toast.LENGTH_LONG).show();
        try {
            Cursor cursor =db.query(Utilidades.TABLA_USUARIO,campos,Utilidades.CAMPO_ID+"=?",parametros,null,null,null);
            cursor.moveToFirst();
            campoIdPersona.setText(idPersona.toString());
            campoNombrePersona.setText(cursor.getString(0));
            campoTelefonoPersona.setText(cursor.getString(1));
            cursor.close();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"El documento no existe",Toast.LENGTH_LONG).show();
            campoNombrePersona.setText("");
            campoTelefonoPersona.setText("");
        }

    }
}