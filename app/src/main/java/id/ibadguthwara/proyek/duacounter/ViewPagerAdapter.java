package id.ibadguthwara.proyek.duacounter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ViewPagerAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private Integer [] images = {
            R.drawable.img_info_dzikir_istighfar_dalil,
            R.drawable.img_info_dzikir_tahlil_dalil,
            R.drawable.img_info_dzikir_lailatul_qodr_dalil,
            R.drawable.img_info_doa_mendoakan_orang_yang_sakit_satu_dalil,
            R.drawable.img_info_doa_mendoakan_orang_yang_sakit_dua_dalil,
            R.drawable.img_info_doa_mendoakan_orang_yang_sakit_tiga_dalil,
            R.drawable.img_info_doa_sholat_istikhoroh_dalil,
    };

    public ViewPagerAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.info_doa_pr_13, null);
        ImageView imageView =(ImageView) view.findViewById(R.id.img_pr_13);
        imageView.setImageResource(images[position]);

        ViewPager vp = (ViewPager) container;
        vp.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);
    }
}
