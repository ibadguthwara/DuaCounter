package id.ibadguthwara.proyek.duacounter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button dzikir1 = findViewById(R.id.btn_mulai_dzikir_1);
        dzikir1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DzikirIstighfar.class);
                startActivity(intent);
            }
        });

        Button dzikir2 = findViewById(R.id.btn_mulai_dzikir_2);
        dzikir2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DzikirTasbih.class);
                startActivity(intent);
            }
        });

        Button dzikir3 = findViewById(R.id.btn_mulai_dzikir_3);
        dzikir3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DzikirTahlil.class);
                startActivity(intent);
            }
        });
        Button dzikir4 = findViewById(R.id.btn_mulai_dzikir_4);
        dzikir4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DzikirLailatulQodr.class);
                startActivity(intent);
            }
        });


        ImageButton doa1 = findViewById(R.id.btn_mulai_doa_1);
        doa1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DoaMendoakanOrangYangSakit.class);
                startActivity(intent);
            }
        });

        ImageButton doa2 = findViewById(R.id.btn_mulai_doa_2);
        doa2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DoaSholatIstikhoroh.class);
                startActivity(intent);
            }
        });
    }
}
