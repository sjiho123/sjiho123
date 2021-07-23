package kr.or.smhrd.myapplication0723;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    FrameLayout frame;
    BottomNavigationView navigation;
    Fragment fragment1;
    Fragment fragment2;
    Fragment fragment3;
    Fragment fragment4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigation = findViewById(R.id.navigation);
        fragment1 = new fragment1();
        fragment2 = new fragment2();
        fragment3 = new fragment3();
        fragment4 = new fragment4();

        //프레그먼트 매니저를 이용하여 FrameLayout에 Fragment화면을 설정
        getSupportFragmentManager().beginTransaction().replace(R.id.frame,fragment1).commit();


        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                int itemId = item.getItemId();

                if(itemId == R.id.item_home){
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,fragment1).commit();

                }else if (itemId == R.id.item_camera){
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,fragment2).commit();

                }else if (itemId == R.id.item_news){
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,fragment3).commit();

                }else {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,fragment4).commit();

                }

                //true : 클릭한 메뉴아이템에 포커싱
                return true;
            }
        });
    }
}