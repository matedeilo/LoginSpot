package com.mate.registerspotify;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class SimpleViewPagerAdapter extends PagerAdapter {

    private LayoutInflater layoutInflater;
    private Context context;
    int[] arrayTitle = {R.string.slide_1_title, R.string.slide_2_title, R.string.slide_3_title,
            R.string.slide_4_title};
    int[] arrayDesc = {R.string.slide_1_desc, R.string.slide_2_desc, R.string.slide_3_desc,
            R.string.slide_4_desc};

    public SimpleViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.item_layout_intro, container, false);
        container.addView(view);

        String title = context.getString(arrayTitle[position]);
        String desc = context.getString(arrayDesc[position]);

        TextView textViewTitle = (TextView) view.findViewById(R.id.tview_title);
        textViewTitle.setText(title);
        TextView textViewDescription = (TextView) view.findViewById(R.id.tview_description);
        textViewDescription.setText(desc);

        return view;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
    }
}
