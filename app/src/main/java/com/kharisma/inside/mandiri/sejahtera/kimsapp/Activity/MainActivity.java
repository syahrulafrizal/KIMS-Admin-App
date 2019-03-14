package com.kharisma.inside.mandiri.sejahtera.kimsapp.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kharisma.inside.mandiri.sejahtera.kimsapp.Adapter.AdapterMenu;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.Fragment.ApprovalFragment;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.Fragment.ClaimFragment;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.Fragment.TaskFragment;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.HolderData.HolderDataMenu;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.Model.ModelMenu;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements HolderDataMenu.MenuItemClickListener,
BottomNavigationView.OnNavigationItemSelectedListener {

    ImageView imgToggle;
    DrawerLayout drawer;
    Toolbar toolbar;
    TextView textName, textEmail;
    List<ModelMenu> modelMenuList;
    RecyclerView listMenu;
    RecyclerView.Adapter adapterMenu;
    RecyclerView.LayoutManager layoutManagerMenu;
    private Dialog dialog;
    BottomNavigationView bottomNavigationView;
    private long backPressedTime;
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        imgToggle = findViewById(R.id.imageToggle);
        textName = findViewById(R.id.textName);
        textEmail = findViewById(R.id.textEmail);
        modelMenuList = new ArrayList<>();
        listMenu = findViewById(R.id.main_nav_menu);
        layoutManagerMenu = new LinearLayoutManager(this);
        listMenu.setLayoutManager(layoutManagerMenu);

        bottomNavigationView = findViewById(R.id.navigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.bottom_task);

        dialog = new Dialog(this);
        dialog.setContentView(R.layout.loading);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawableResource(android.R.color.transparent);
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogTheme;
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);

        ModelMenu modelMenu1 = new ModelMenu(R.string.profile, R.drawable.ic_user);
        ModelMenu modelMenu2 = new ModelMenu(R.string.product, R.drawable.ic_product);
        ModelMenu modelMenu3 = new ModelMenu(R.string.store, R.drawable.ic_store);
        ModelMenu modelMenu4 = new ModelMenu(R.string.sales, R.drawable.ic_sales);
        ModelMenu modelMenu5 = new ModelMenu(R.string.reward, R.drawable.ic_reward);
        ModelMenu modelMenu6 = new ModelMenu(R.string.faq, R.drawable.ic_faq);
        ModelMenu modelMenu7 = new ModelMenu(R.string.customer_service, R.drawable.ic_cs);
        ModelMenu modelMenu8 = new ModelMenu(R.string.admin_level, R.drawable.ic_admin_level);
        ModelMenu modelMenu9 = new ModelMenu(R.string.logout, R.drawable.ic_logout);

        modelMenuList.add(modelMenu1);
        modelMenuList.add(modelMenu2);
        modelMenuList.add(modelMenu3);
        modelMenuList.add(modelMenu4);
        modelMenuList.add(modelMenu5);
        modelMenuList.add(modelMenu6);
        modelMenuList.add(modelMenu7);
        modelMenuList.add(modelMenu8);
        modelMenuList.add(modelMenu9);

        adapterMenu = new AdapterMenu(modelMenuList, this, this);
        listMenu.setAdapter(adapterMenu);
        adapterMenu.notifyDataSetChanged();
        listMenu.setItemAnimator(new DefaultItemAnimator());

        textName.setText("Hi Syahrul Afrizal");

        drawer = findViewById(R.id.drawer_layout);

        imgToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawer.isDrawerOpen(Gravity.END)) {
                    drawer.closeDrawer(Gravity.END);
                } else {
                    drawer.openDrawer(Gravity.END);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.END)) {
            drawer.closeDrawer(GravityCompat.END);
        } else {
            FragmentManager fragmentManager = getSupportFragmentManager();
            if (fragmentManager.getBackStackEntryCount() >= 0 ){
                if (backPressedTime + 2000 > System.currentTimeMillis()) {
                    backToast.cancel();
                    finish();
                } else {
                    backToast = Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT);
                    backToast.show();
                }

                backPressedTime = System.currentTimeMillis();
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
//        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
//        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        dialog.dismiss();
        drawer.closeDrawer(Gravity.END);
//        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
//        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
//        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onMenuItemClick(int itemString) {
        String menu = (String) getResources().getText(itemString);
        Intent intentMenu = null;
        switch (menu){
            case "Profile" :
                intentMenu = new Intent(MainActivity.this, ProfileActivity.class);
                intentMenu.putExtra("title", menu);
                break;

            case "Product" :
                intentMenu = new Intent(MainActivity.this, ProductActivity.class);
                intentMenu.putExtra("title", menu);
                break;

            case "Store" :
                intentMenu = new Intent(MainActivity.this, StoreActivity.class);
                intentMenu.putExtra("title", menu);
                break;

            case "Sales" :
                intentMenu = new Intent(MainActivity.this, SalesActivity.class);
                intentMenu.putExtra("title", menu);
                break;

            case "Reward" :
                intentMenu = new Intent(MainActivity.this, RewardActivity.class);
                intentMenu.putExtra("title", menu);
                break;

            case "FAQ" :
                intentMenu = new Intent(MainActivity.this, FAQActivity.class);
                intentMenu.putExtra("title", menu);
                break;

            case "Customer Service" :
                intentMenu = new Intent(MainActivity.this, CustomerServiceActivity.class);
                intentMenu.putExtra("title", menu);
                break;

            case "Admin Level" :
                intentMenu = new Intent(MainActivity.this, AdminLevelActivity.class);
                intentMenu.putExtra("title", menu);
                break;
        }
        if (intentMenu != null){
            dialog.show();
            startActivity(intentMenu);
            overridePendingTransition(R.anim.intent_in, R.anim.intent_out);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        final FragmentManager fragmentManager = getSupportFragmentManager();

        switch (menuItem.getItemId()) {
            case R.id.bottom_task:
                fragment = new TaskFragment();
                break;
            case R.id.bottom_claim:
                fragment = new ClaimFragment();
                break;
            case R.id.bottom_approve:
                fragment = new ApprovalFragment();
                break;
        }
        assert fragment != null;
        fragmentManager
                .beginTransaction()
                .replace(R.id.frame, fragment)
                .addToBackStack(fragment.getClass().getName())
                .commit();
        return true;
    }

}
