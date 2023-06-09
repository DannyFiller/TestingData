//package com.example.sotietkiem;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Context;
//import android.content.SharedPreferences;
//import android.os.Bundle;
//import android.text.TextUtils;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//
//import com.google.gson.Gson;
//
//import data.User;
//import data.Utils;
//
//public class MainActivity extends AppCompatActivity {
//
//    EditText edSoTien;
//    Button btnXacNhan,btnDangNhap;
//    TextView tvKetQua,tvTen;
//    private  final Gson gson = new Gson();
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        edSoTien = findViewById(R.id.edSotien);
//        btnXacNhan = findViewById(R.id.btnXacNhan);
//        tvKetQua = findViewById(R.id.tvKetQua);
//        tvTen = findViewById(R.id.tvTen );
//
//
//        SharedPreferences shareget = getSharedPreferences(Utils.SHARE_PREFERENCES_APP, Context.MODE_PRIVATE);
//        String userPref = shareget.getString(Utils.KEY_USER,null);
//
//        User user = gson.fromJson(userPref,User.class);
//
//        if (user == null) {
//            tvTen.setText("Tên tài khoản");
//
//        }
//        else {
//            String info = user.getUserName();
//            tvTen.setText(info);
//        }
//
//
//
////        btnXacNhan.setOnClickListener(view -> Cong());
//
//        btnXacNhan.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Cong();
//
//                edSoTien.setText(String.valueOf(("")));
//            }
//        });
//
//    }
//
//    void ShowData(int rs){
//        tvKetQua.setText(String.valueOf(rs));
//    }
//
//    void Cong(){
//        String txtSoTienCong = edSoTien.getText().toString();
//        String txtSoTienHienTai = tvKetQua.getText().toString();
//        if (txtSoTienCong.isEmpty()){
//            tvKetQua.setText("Số tiền hiện có");
//            return;
//        }
//        int a = Integer.valueOf(txtSoTienHienTai);
//        int b = Integer.valueOf(txtSoTienCong);
//
//        int c = a+b;
//
//        ShowData(c);
//    }
//}

package com.example.sotietkiem;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.sotietkiem.fragment.HomeFragment;
import com.example.sotietkiem.fragment.InfoFragment;
import com.example.sotietkiem.fragment.ListFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView mnBottom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mnBottom = findViewById(R.id.navMenu);
        loadFragment(new HomeFragment());


        mnBottom.setOnItemSelectedListener(getListener());

//        ActionBar actionBar = getSupportActionBar();
//        getSupportActionBar().setTitle("Main");
//        actionBar.setDisplayHomeAsUpEnabled(true);

        //Load len fragment

    }

//    boolean IsClickReturn;


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.top_menu,menu);
//        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
//        return true;
//    }

    @NonNull
    private NavigationBarView.OnItemSelectedListener getListener() {
        return new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.mnHome:
                        loadFragment(new HomeFragment());
                        return  true;


                    case R.id.mnList:
                        loadFragment(new ListFragment());
                        return  true;


                    case R.id.mnInfo:
                        loadFragment(new InfoFragment());
                        return  true;

//                    case R.id.mnSetting:
//                        loadFragment(new SettingFragment());
//                        return  true;
                }
                return true;

            }
        };
    }

    //Ham  Load fragment
    void loadFragment(Fragment fmNew)
    {
        FragmentTransaction fmTran  = getSupportFragmentManager().beginTransaction();
        fmTran.replace(R.id.main_fragment,fmNew);
        fmTran.addToBackStack(null);
        fmTran.commit();
    }
}