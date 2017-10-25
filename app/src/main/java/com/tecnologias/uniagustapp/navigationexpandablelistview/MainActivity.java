package com.tecnologias.uniagustapp.navigationexpandablelistview;

import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //ListView
    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String,List<String>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        //ListView
        listView = (ExpandableListView)findViewById(R.id.ex_lits_menu);
        initData();
        listAdapter = new ExpandableListAdapter(this, listDataHeader,listHash);
        listView.setAdapter(listAdapter);

    }

    //Cargue ListView
    private void initData() {

        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();

        listDataHeader.add("Portal");
        listDataHeader.add("Plataformas");
        listDataHeader.add("Redes Sociales");
        listDataHeader.add("Entretenimiento");

        List<String> itemMenus1 = new ArrayList<>();
        itemMenus1.add("Home");
        itemMenus1.add("Biblioteca");
        itemMenus1.add("EduVirtual");
        itemMenus1.add("Directorio");
        itemMenus1.add("Preguntas");

        List<String> itemMenus2 = new ArrayList<>();
        itemMenus2.add("Siga");
        itemMenus2.add("Siga");
        itemMenus2.add("Apoyo a la Presencialidad");
        itemMenus2.add("Virtualidad");

        List<String> itemMenus3 = new ArrayList<>();
        itemMenus3.add("Youtube");
        itemMenus3.add("Twitter");
        itemMenus3.add("Facebook");
        itemMenus3.add("Flicker");
        itemMenus3.add("Google +");
        itemMenus3.add("Instagram");
        itemMenus3.add("LinkedIn");

        List<String> itemMenus4 = new ArrayList<>();
        itemMenus4.add("Tour 360");
        itemMenus4.add("Juegos");

        listHash.put(listDataHeader.get(0),itemMenus1);
        listHash.put(listDataHeader.get(1),itemMenus2);
        listHash.put(listDataHeader.get(2),itemMenus3);
        listHash.put(listDataHeader.get(3),itemMenus4);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
