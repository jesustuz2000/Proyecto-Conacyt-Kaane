package com.example.proyectofinal;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.proyectofinal.entidades.Alimento;
import com.example.proyectofinal.utilidades.Utilidades;

import java.util.ArrayList;

public class ListaAlimentosActivity extends AppCompatActivity {

    ListView listViewMascota;
    ArrayList<String> listaInformacion;
    ArrayList<Alimento> listaAlimentos;

    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alimentos);

        conn=new ConexionSQLiteHelper(getApplicationContext(),"bd_usuarios",null,1);

        listViewMascota= (ListView) findViewById(R.id.listViewMascotas);

        consultarListaPersonas();

        ArrayAdapter adaptador=new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaInformacion);
        listViewMascota.setAdapter(adaptador);

        listViewMascota.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {

                Alimento alimento = listaAlimentos.get(pos);

                Intent intent=new Intent(ListaAlimentosActivity.this, DetalleAlimentoActivity.class);

                Bundle bundle=new Bundle();
                bundle.putSerializable("mascota", alimento);

                intent.putExtras(bundle);
                startActivity(intent);

            }
        });

    }

    private void consultarListaPersonas() {
        SQLiteDatabase db=conn.getReadableDatabase();

        Alimento alimento =null;
        listaAlimentos =new ArrayList<Alimento>();
        //select * from usuarios
        Cursor cursor=db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_MASCOTA,null);

        while (cursor.moveToNext()){
            alimento =new Alimento();
            alimento.setIdMascota(cursor.getString(0));
            alimento.setNombreMascota(cursor.getString(1));
            alimento.setRaza(cursor.getString(2));
            alimento.setIdDuenio(cursor.getString(3));


            listaAlimentos.add(alimento);
        }
        obtenerLista();
    }

    private void obtenerLista() {
        listaInformacion=new ArrayList<String>();

        for (int i = 0; i< listaAlimentos.size(); i++){
            listaInformacion.add(listaAlimentos.get(i).getIdMascota()+" - "
                    + listaAlimentos.get(i).getNombreMascota());
        }

    }
}
