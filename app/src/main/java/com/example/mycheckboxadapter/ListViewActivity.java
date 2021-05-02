package com.example.mycheckboxadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    List<Producte> productes;
    private ListView listViewProductes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);

        listViewProductes = (ListView) findViewById(android.R.id.list);
        productes = new ArrayList<Producte>(30);
        Producte producte = null;

        /*
        for (int i = 0; i < 3; i++) {
            producte = new Producte();
            producte.setNomProducte("Nom " + i);
            producte.setDescripcioProducte("Descripció " + i);
            producte.setDescripcioProducte("Descripció " + i);
            productes.add(producte);
        }*/

        producte = new Producte("Paella marisc", "La típica paella valenciana de marisc",  R.drawable.plat_paella_marisc);
        productes.add(producte);
        producte =  new Producte("Fideuà", "Fideuà peix amb fieus fins", R.drawable.plat_fideua);
        productes.add(producte);
        producte = new Producte("Tortilla de creïlles", "Amb creïlles i sense ceba",  R.drawable.plat_tortilla_creilles);
        productes.add(producte);

        // Seleccionem productes a l'atzar
        productes.get(0).setChecked(true);
        productes.get(2).setChecked(true);

        listViewProductes.setAdapter(new CustomArrayAdapter(this, productes));

        listViewProductes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(ListViewActivity.this,
                        productes.get(position).getNomProducte(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}