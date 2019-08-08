package id.ibadguthwara.proyek.duacounter;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class DzikirLailatulQodr extends AppCompatActivity {

    ImageButton imageBtnKurangi, getar, tombol;
    Button btnTambahi;
    TextView jumlah_hitung_dzikir_1;
    Integer valueJumlahHitung = 0;
    Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dzikir_lailatul_qodr);

        //
        imageBtnKurangi = findViewById(R.id.btn_kurangi_1);
        btnTambahi = findViewById(R.id.btn_tambahi_1);
        jumlah_hitung_dzikir_1 = findViewById(R.id.jumlah_hitung_dzikir_1);
        getar = (ImageButton) findViewById(R.id.btn_getar);
        tombol = (ImageButton) findViewById(R.id.btn_open_informasi_hadits);

        //
        imageBtnKurangi.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                if (vibrator != null){
                    vibrator.vibrate(VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE));
                }
                valueJumlahHitung -= 1;
                if(valueJumlahHitung < 0 ){
                    valueJumlahHitung = 0;
                }
                jumlah_hitung_dzikir_1.setText(valueJumlahHitung.toString());

            }
        });

        //
        btnTambahi.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                if (vibrator != null){
                    vibrator.vibrate(VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE));
                }
                valueJumlahHitung += 1;
                jumlah_hitung_dzikir_1.setText(valueJumlahHitung.toString());
            }
        });


        //
        getar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (vibrator == null){
                    vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    getar.setImageDrawable(getDrawable(R.drawable.ic_vibrate_on));
                }else {
                    vibrator = null;
                    getar.setImageDrawable(getDrawable(R.drawable.ic_vibrate_off));
                }
            }
        });


        //
        tombol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* inisialisasi custom dialog */
                final Dialog dialog = new Dialog(DzikirLailatulQodr.this);
                dialog.setContentView(R.layout.info_dzikir_lailatul_qodr);

                /* tombol close */
                ImageButton dialogImageButton = (ImageButton) dialog.findViewById(R.id.btn_close_informasi_hadits);
                dialogImageButton.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
    }
}