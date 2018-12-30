package com.appy.ndpsh.project_001.Activities;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;



import com.appy.ndpsh.project_001.Fragments.AnimeFragment;
import com.appy.ndpsh.project_001.Fragments.BooksFragment;
import com.appy.ndpsh.project_001.Fragments.MangaFragment;
import com.appy.ndpsh.project_001.Fragments.MovieFragment;
import com.appy.ndpsh.project_001.Fragments.SeriesFragment;
import com.appy.ndpsh.project_001.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //@BindView(R.id.tabLayout)
    //TabLayout tabLayout;
    //@BindView(R.id.toolbar)
    //android.support.v7.widget.Toolbar toolbar;

    @BindView(R.id.navview)
    NavigationView navigationView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //setTabLayout();
        //setToolbar();
        setFragmentsByDefault();

    }

    //private void setTabLayout(){
    //    tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab_title_first)));
    //    tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab_title_second)));
    //    tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab_title_third)));
    //    tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab_title_quarter)));
    //    tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab_title_five)));
    //}


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        boolean fragmentsTransaction = false;
        Fragment fragment = null;

        switch (menuItem.getItemId()){
            case R.id.menu_list_anime:
                fragment = new AnimeFragment();
                fragmentsTransaction = true;
                break;

            case R.id.menu_list_manga:
                fragment = new MangaFragment();
                fragmentsTransaction = true;
                break;

            case R.id.menu_list_movies:
                fragment = new MovieFragment();
                fragmentsTransaction = true;
                break;

            case R.id.menu_list_series:
                fragment = new SeriesFragment();
                fragmentsTransaction = true;
                break;

            case R.id.menu_list_books:
                fragment = new BooksFragment();
                fragmentsTransaction = true;
                break;
        }

        if (fragmentsTransaction){
            changeFragment(fragment,menuItem);
            drawerLayout.closeDrawers();
        }

        return true;
    }
    //private void setToolbar(){
    //    setSupportActionBar(toolbar);
    //    // Para habilitar en la barra justo al lado del nombre
    //    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    //}



    private void changeFragment (Fragment fragment, MenuItem menuItem){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, fragment)
                .commit();

        menuItem.setChecked(true);
        //getSupportActionBar().setTitle(menuItem.getTitle());

    }

    private void setFragmentsByDefault(){
        changeFragment(new MovieFragment(), navigationView.getMenu().getItem(0));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                // abrir el nav_options lateral
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
