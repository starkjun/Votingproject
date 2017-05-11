package com.example.yongjunxiao.voting.Activity;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.yongjunxiao.voting.Fragment.ContactsFragment;
import com.example.yongjunxiao.voting.Fragment.MessageFragment;
import com.example.yongjunxiao.voting.Fragment.NewsFragment;
import com.example.yongjunxiao.voting.Fragment.P2pFragment;
import com.example.yongjunxiao.voting.R;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener
        , NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private BottomNavigationBar bottomnavigationBar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private Button menu;
    private TextView account;
    private View headerView;
    private MessageFragment messageFragment;
    private ContactsFragment contactsFragment;
    private NewsFragment newsFragment;
    private P2pFragment p2pFragment;
    private Toolbar toolbar;
    private TextView toolbar_title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setDefaultFragment();

        account.setText("帐号： starkjun0@gmail.com");

    }

    private void initView() {

        initToolbar();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
            layoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | layoutParams.flags);
        }
        bottomnavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        navigationView = (NavigationView) findViewById(R.id.sliding_navigation_view);
        drawerLayout = (DrawerLayout) findViewById(R.id.activity_main);
        menu = (Button) findViewById(R.id.menu_btn);
        headerView = navigationView.getHeaderView(0);
        account = (TextView) headerView.findViewById(R.id.account);

        bottomnavigationBar.addItem(new BottomNavigationItem(R.drawable.message, "消息"))
                .addItem(new BottomNavigationItem(R.drawable.friend_icon, "好友"))
                .addItem(new BottomNavigationItem(R.drawable.news, "新闻热点"))
                .addItem(new BottomNavigationItem(R.drawable.wifip2p_icon, "P2P"))
                .setFirstSelectedPosition(0).initialise();


        navigationView.setItemTextColor(ContextCompat.getColorStateList(this, R.color.sliding_menu_seleted_color));
        navigationView.setItemIconTintList(ContextCompat.getColorStateList(this, R.color.sliding_menu_seleted_color));
        navigationView.setNavigationItemSelectedListener(this);
        bottomnavigationBar.setTabSelectedListener(this);
        menu.setOnClickListener(this);
    }


    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        toolbar_title = (TextView) findViewById(R.id.toolbar_title);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
    }

    private void setDefaultFragment() {

        messageFragment = new MessageFragment();
        contactsFragment = new ContactsFragment();
        newsFragment = new NewsFragment();
        p2pFragment = new P2pFragment();

        android.app.FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;
        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, messageFragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.account_icon:
                slidingMenuSelected(2);
                startActivity(new Intent(MainActivity.this, ModifyPersonalInfo.class));
                break;
            case R.id.identified:
                slidingMenuSelected(3);
                startActivity(new Intent(MainActivity.this, Authentication.class));
                break;
            case R.id.vote_record:
                slidingMenuSelected(4);
                startActivity(new Intent(MainActivity.this, VoteRecord.class));
                break;
            case R.id.reset_psw:
                slidingMenuSelected(5);
                startActivity(new Intent(MainActivity.this, ResetPassword.class));
                break;
        }

        return true;
    }

    @Override
    public void onTabSelected(int position) {

        android.app.FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;
        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        switch (position) {

            case 0:
                fragmentTransaction.replace(R.id.frame_layout, messageFragment);
                fragmentTransaction.commit();
                toolbar_title.setText("消息");
                break;
            case 1:
                fragmentTransaction.replace(R.id.frame_layout, contactsFragment);
                fragmentTransaction.commit();
                toolbar_title.setText("好友");
                break;
            case 2:
                fragmentTransaction.replace(R.id.frame_layout, newsFragment);
                fragmentTransaction.commit();
                toolbar_title.setText("新闻热点");
                break;
            case 3:
                fragmentTransaction.replace(R.id.frame_layout, p2pFragment);
                fragmentTransaction.commit();
                toolbar_title.setText("P2P");
                break;
            default:
                break;

        }


    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.menu_btn:
                drawerLayout.openDrawer(navigationView);
                break;
        }
    }

    /**
     * If I use the method slidingMenuSelected(int) to set the navigationView's Item
     * selected or not instead of setting navigationView.getMenu().getItem(i).setChecked
     * directly in the onNavigationItemSelected() method,I think it will make it inefficiently,
     * because the method slidingMenuSelected contains a 'for loop' and in the loop it contains
     * a if judgement.  this method will use more calculating resource.
     * <p>
     * So,this method need to be optimized ..................................
     */
    public void slidingMenuSelected(int position) {
        for (int i = 2; i <= 5; i++) {
            if (i == position) {
                navigationView.getMenu().getItem(i).setChecked(true);
            } else {
                navigationView.getMenu().getItem(i).setChecked(false);
            }
        }
    }
}
