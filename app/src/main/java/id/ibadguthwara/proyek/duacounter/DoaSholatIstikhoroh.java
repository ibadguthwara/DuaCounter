package id.ibadguthwara.proyek.duacounter;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class DoaSholatIstikhoroh extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doa_sholat_istikhoroh);

        ImageButton tombol = (ImageButton) findViewById(R.id.btn_open_informasi_hadits);
        tombol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* inisialisasi custom dialog */
                final Dialog dialog = new Dialog(DoaSholatIstikhoroh.this);
                dialog.setContentView(R.layout.info_doa_sholat_istikhoroh);

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
