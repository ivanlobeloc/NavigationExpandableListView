package com.tecnologias.uniagustapp.navigationexpandablelistview;

import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.tecnologias.uniagustapp.navigationexpandablelistview.objects.ElementoMenu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //ExpandableListView
    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String,List<ElementoMenu>> listHash;

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
        listView.setAdapter(listAdapter);//*

        //Tutorial: https://www.youtube.com/watch?v=oPGdPQvqPVM
        // Evento Grupo expandido
        listView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                Toast.makeText(MainActivity.this, listDataHeader.get(groupPosition)+" was expanded", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        //Evento Grupo Contraido
        listView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(MainActivity.this, listDataHeader.get(groupPosition)+" was collapsed", Toast.LENGTH_SHORT).show();
            }
        });
        //Evento Child Item
        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(MainActivity.this, listDataHeader.get(groupPosition)+" was expanded", Toast.LENGTH_SHORT).show();
                //Integer in=(Integer)listHash;
                //int num = Integer.parseInt(String.valueOf(listHash));
                Toast.makeText(MainActivity.this, listHash.get(childPosition)+" was clicked", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    //Cargue ListView
    private void initData() {

        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();

        listDataHeader.add("Portal");
        listDataHeader.add("Plataformas");
        listDataHeader.add("Redes Sociales");
        listDataHeader.add("Entretenimiento");

        List<ElementoMenu> itemMenus1 = new ArrayList<>();
        ElementoMenu elemento = new ElementoMenu("Home", R.drawable.img1);
        itemMenus1.add(elemento);
        elemento = new ElementoMenu("Biblioteca", R.drawable.img2);
        itemMenus1.add(elemento);
        elemento = new ElementoMenu("EduVirtual", R.drawable.img3);
        itemMenus1.add(elemento);
        elemento = new ElementoMenu("Directorio", R.drawable.img4);
        itemMenus1.add(elemento);
        elemento = new ElementoMenu("Preguntas", R.drawable.img1);
        itemMenus1.add(elemento);

        List<ElementoMenu> itemMenus2 = new ArrayList<>();
        elemento = new ElementoMenu("Siga", R.drawable.img1);
        itemMenus2.add(elemento);
        elemento = new ElementoMenu("Apoyo a la Presencialidad", R.drawable.img2);
        itemMenus2.add(elemento);
        elemento = new ElementoMenu("Virtualidad", R.drawable.img3);
        itemMenus2.add(elemento);

        List<ElementoMenu> itemMenus3 = new ArrayList<>();
        elemento = new ElementoMenu("Youtube", R.drawable.img1);
        itemMenus3.add(elemento);
        elemento = new ElementoMenu("Twitter", R.drawable.img2);
        itemMenus3.add(elemento);
        elemento = new ElementoMenu("Facebook", R.drawable.img3);
        itemMenus3.add(elemento);
        elemento = new ElementoMenu("Flicker", R.drawable.img4);
        itemMenus3.add(elemento);
        elemento = new ElementoMenu("Google +", R.drawable.img1);
        itemMenus3.add(elemento);
        elemento = new ElementoMenu("Instagram", R.drawable.img2);
        itemMenus3.add(elemento);
        elemento = new ElementoMenu("LinkedIn", R.drawable.img3);
        itemMenus3.add(elemento);

        List<ElementoMenu> itemMenus4 = new ArrayList<>();
        elemento = new ElementoMenu("Tour 360", R.drawable.img1);
        itemMenus4.add(elemento);
        elemento = new ElementoMenu("Juegos", R.drawable.img2);
        itemMenus4.add(elemento);

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
