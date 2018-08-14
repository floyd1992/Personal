package com.tieguo.personal;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.tieguo.personal.fragment.HomeFragment;
import com.tieguo.personal.fragment.MemoFragment;
import com.tieguo.personal.fragment.MineFragment;
import com.tieguo.personal.fragment.NoteFragment;
import com.tieguo.personal.sdk.activity.BaseCompatActivity;
import com.tieguo.personal.utils.BottomNavigationViewHelper;

import butterknife.BindView;
import me.yokeyword.fragmentation.SupportFragment;

public class MainActivity extends BaseCompatActivity {

    @BindView(R.id.nv_menu)
    NavigationView nvMenu;
    @BindView(R.id.dl_root)
    DrawerLayout dlRoot;
    @BindView(R.id.bviv_bar)
    BottomNavigationView bottomNavigationView;

    public static final int FIRST = 0;
    public static final int SECOND = 1;
    public static final int THIRD = 2;
    public static final int FOURTH = 3;

    private SupportFragment[] mFragments = new SupportFragment[4];

    private ImageView mAvatarIv;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            mFragments[FIRST] = HomeFragment.newInstance();
            mFragments[SECOND] = MemoFragment.newInstance();
            mFragments[THIRD] = NoteFragment.newInstance();
            mFragments[FOURTH] = MineFragment.newInstance();
            loadMultipleRootFragment(R.id.fl_container, FIRST,
                    mFragments[FIRST],
                    mFragments[SECOND],
                    mFragments[THIRD],
                    mFragments[FOURTH]);
        } else {
            // 这里库已经做了Fragment恢复,所有不需要额外的处理了, 不会出现重叠问题
            // 这里我们需要拿到mFragments的引用,也可以通过getSupportFragmentManager.getFragments()
            // 自行进行判断查找(效率更高些),用下面的方法查找更方便些
            mFragments[FIRST] = findFragment(HomeFragment.class);
            mFragments[SECOND] = findFragment(MemoFragment.class);
            mFragments[THIRD] = findFragment(NoteFragment.class);
            mFragments[FOURTH] = findFragment(MineFragment.class);
        }

        mAvatarIv = nvMenu.getHeaderView(0).findViewById(R.id.civ_head);
        mAvatarIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dlRoot.closeDrawer(GravityCompat.START);
                bottomNavigationView.setSelectedItemId(R.id.menu_item_mine);
            }
        });
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_item_home:
                        showHideFragment(mFragments[FIRST]);
                        break;
                    case R.id.menu_item_memo:
                        showHideFragment(mFragments[SECOND]);
                        break;
                    case R.id.menu_item_note:
                        showHideFragment(mFragments[THIRD]);
                        break;
                    case R.id.menu_item_mine:
                        showHideFragment(mFragments[FOURTH]);
                        break;
                }
                return true;
            }
        });

        dlRoot.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
            }

            @Override
            public void onDrawerOpened(View drawerView) {
            }

            @Override
            public void onDrawerClosed(View drawerView) {
            }

            @Override
            public void onDrawerStateChanged(int newState) {
            }
        });

    }

}
