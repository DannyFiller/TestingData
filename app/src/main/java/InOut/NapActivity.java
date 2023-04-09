package InOut;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sotietkiem.MainActivity;
import com.example.sotietkiem.R;
import com.example.sotietkiem.RegisterActivity;
import com.example.sotietkiem.SignInActivity;
import com.example.sotietkiem.fragment.HomeFragment;

import data.DataQuery;
import data.DatabaseHandler;
import data.User;

public class NapActivity extends AppCompatActivity {

    TextView tvTen;
    EditText edSoTien;
    Button btnXacNhan;


    DatabaseHandler helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nap);

        tvTen = findViewById(R.id.tvUserNameNap);
        btnXacNhan = findViewById(R.id.btnXacNhanNap);
        edSoTien = findViewById(R.id.edSoTienNap);

        tvTen.setText(SignInActivity.loginUser.getUserName());


        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sotien = edSoTien.getText().toString();
                SignInActivity.loginUser.setMoney(Integer.parseInt(sotien));
                DataQuery.insertMoney(NapActivity.this,SignInActivity.loginUser);

                Intent i = new Intent(NapActivity.this,MainActivity.class);
                startActivity(i);
            }
        });





    }

}