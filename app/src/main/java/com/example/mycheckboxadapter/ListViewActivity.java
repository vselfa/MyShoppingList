package com.example.mycheckboxadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends MainMenu {

    // Llista productes. Static per accedir des de l'adapter
    static List<Producte> llistaProductes;
    // La ListViww que mostra els productes
    private ListView listViewProductes;
    Integer numProductes = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);

        listViewProductes = (ListView) findViewById(android.R.id.list);
        llistaProductes = new ArrayList<Producte>(30);
        Producte producte = null;

        producte = new Producte("Paella marisc", "La típica paella valenciana de marisc",  R.drawable.plat_paella_marisc);
        llistaProductes.add(producte);
        producte =  new Producte("Fideuà", "Fideuà peix amb fieus fins", R.drawable.plat_fideua);
        llistaProductes.add(producte);
        producte = new Producte("Tortilla de creïlles", "Amb creïlles i sense ceba",  R.drawable.plat_tortilla_creilles);
        llistaProductes.add(producte);

        listViewProductes.setAdapter(new CustomArrayAdapter(this, llistaProductes));

    }
}