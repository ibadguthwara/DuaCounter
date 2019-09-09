package id.ibadguthwara.proyek.duacounter;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DzikirIstighfar extends AppCompatActivity {

    ImageButton imageBtnKurangi, getar, tombol, replay, lampu;
    Button btnTambahi;
    TextView jumlah_hitung_dzikir_1;
    Integer valueJumlahHitung = 0;
    Vibrator vibrator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dzikir_istighfar);

        //
        imageBtnKurangi = findViewById(R.id.btn_kurangi_1);
        replay = findViewById(R.id.btn_replay);
        btnTambahi = findViewById(R.id.btn_tambahi_1);
        jumlah_hitung_dzikir_1 = findViewById(R.id.jumlah_hitung_dzikir_1);
        getar = (ImageButton) findViewById(R.id.btn_getar);
        tombol = (ImageButton) findViewById(R.id.btn_open_informasi_hadits);
        lampu = (ImageButton) findViewById(R.id.btn_lampu);

        //
        imageBtnKurangi.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                if (vibrator != null){
                    getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
                    vibrator.vibrate(30);
                }
                valueJumlahHitung -= 1;
                if(valueJumlahHitung < 0 ){
                    valueJumlahHitung = 0;
                }
                jumlah_hitung_dzikir_1.setText(valueJumlahHitung.toString());

            }
        });

        //
        replay.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  /* inisialisasi custom dialog */
                  final Dialog dialog = new Dialog(DzikirIstighfar.this);
                  dialog.setContentView(R.layout.info_replay_verifikasi);

                  /* tombol ya */
                  Button buttonYes = (Button) dialog.findViewById(R.id.btn_replay_yes);
                  buttonYes.setOnClickListener(new View.OnClickListener() {
                      @Override
                      public void onClick(View v) {
                          valueJumlahHitung = 0;
                          jumlah_hitung_dzikir_1.setText(valueJumlahHitung.toString());
                          dialog.dismiss();
                      }
                  });

                  /* tombol tidak */
                  Button buttonNo = (Button) dialog.findViewById(R.id.btn_replay_no);
                  buttonNo.setOnClickListener(new View.OnClickListener() {
                      @Override
                      public void onClick(View v) {
                          dialog.dismiss();
                      }
                  });
                  dialog.show();
              }
        });


        //
        btnTambahi.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                if (vibrator != null){
                    getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
                    vibrator.vibrate(30);
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
        lampu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (vibrator == null){
                    vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    lampu.setImageDrawable(getDrawable(R.drawable.ic_lightbulb_off_outline));
                }else {
                    vibrator = null;
                    lampu.setImageDrawable(getDrawable(R.drawable.ic_lightbulb_on_outline));
                }
            }
        });


        //
        tombol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* inisialisasi custom dialog */
                final Dialog dialog = new Dialog(DzikirIstighfar.this);
                dialog.setContentView(R.layout.info_dzikir_istighfar);

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

        // === Tanggal ===
        Calendar calendar1 = Calendar.getInstance();
        SimpleDateFormat sdf1 = new SimpleDateFormat("EEEE, dd MMMM yyyy", Locale.getDefault());
        String strdate1 = sdf1.format(calendar1.getTime());
        TextView txtHari = findViewById(R.id.txt_tanggal);
        txtHari.setText(strdate1);
    }
}
