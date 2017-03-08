package com.lwh.whitebook;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.lwh.whitebook.bookmarks.BookMarksFragment;
import com.lwh.whitebook.homepages.MainFragment;
import com.lwh.whitebook.presenter.BookMarksPresenter;

/**
 * Created by Administrator on 2017/2/17.
 */

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private MainFragment mainFragment;
    private BookMarksFragment bookMarksFragment;


    private NavigationView navigationView;
    private DrawerLayout main_drawer;
    private Toolbar toolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        if (savedInstanceState != null){
            mainFragment = (MainFragment) getSupportFragmentManager().getFragment(savedInstanceState,"MainFragment");
            bookMarksFragment = (BookMarksFragment) getSupportFragmentManager().getFragment(savedInstanceState,"BookMarksFragment");
        }else {
            mainFragment = MainFragment.newInstanc();
            bookMarksFragment = BookMarksFragment.newInstanc();
        }

        if (!mainFragment.isAdded())
        {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.main_frag,mainFragment,"MainFragment")
                    .commit();
        }
        if (!bookMarksFragment.isAdded()){
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.main_frag,bookMarksFragment,"BookMarksFragment")
                    .commit();
        }

        //Initialized an BookMarksPresenter instance
        new BookMarksPresenter(this,bookMarksFragment);

        //显示首页
        showMainFragment();

    }


    /**
     * 显示首页
     */
    private void showMainFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.show(mainFragment);
        transaction.hide(bookMarksFragment);
        transaction.commit();

        toolbar.setTitle(getResources().getString(R.string.home_page));
    }

    /**
     * 显示首页
     */
    private void showBookMarksFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.show(bookMarksFragment);
        transaction.hide(mainFragment);
        transaction.commit();

        toolbar.setTitle(getResources().getString(R.string.bookmarks));
    }

    /**
     * init all the view
     */
    private void initViews() {
        toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        main_drawer = (DrawerLayout) findViewById(R.id.main_drawer);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                main_drawer,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);

        main_drawer.setDrawerListener(toggle);
        toggle.syncState();

        //navigationView set listener
        navigationView = (NavigationView) findViewById(R.id.main_navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mainFragment.isAdded()){
            getSupportFragmentManager().putFragment(outState,"MainFragment",mainFragment);
        }
        if (bookMarksFragment.isAdded()){
            getSupportFragmentManager().putFragment(outState,"BookMarksFragment",bookMarksFragment);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {

            case R.id.drawer_about:

                break;

            case R.id.drawer_bookmarks:

                break;

            case R.id.drawer_change_style:

                break;

            case R.id.drawer_home_page:

                break;

            case R.id.drawer_send_log:

                break;

        }

        return true;
    }
}
