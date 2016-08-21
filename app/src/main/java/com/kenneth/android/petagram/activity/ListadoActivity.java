package com.kenneth.android.petagram.activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.kenneth.android.petagram.R;
import com.kenneth.android.petagram.adapter.PageAdapter;
import com.kenneth.android.petagram.fragment.ListadoFragment;
import com.kenneth.android.petagram.fragment.PerfilFragment;

import java.util.ArrayList;

public class ListadoActivity extends AppCompatActivity {

    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    ArrayList<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        setupViewPager();

    }

    private ArrayList<Fragment> agregarFragments() {
        fragments = new ArrayList<>();
        fragments.add(new ListadoFragment());
        fragments.add(new PerfilFragment());
        return fragments;
    }

    private void setupViewPager() {
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_dog_house_w);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_dog_w);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones_listado, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent intent;

        switch (item.getItemId()) {

            case R.id.action_favoritos:
                intent = new Intent(this, FavoritosActivity.class);
                startActivity(intent);
                break;

            case R.id.action_contacto:
                intent = new Intent(this, ContactoActivity.class);
                startActivity(intent);
                break;

            case R.id.action_about:
                intent = new Intent(this, AboutActivity.class);
                startActivity(intent);
                break;

        }

        return super.onOptionsItemSelected(item);
    }
}
