package com.carlosdelachica.sample.adapter;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.carlosdelachica.easyrecycleradapters.sample.R;
import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class ImageItem extends LinearLayout {

    @InjectView(R.id.image)
    ImageView image;
    @InjectView(R.id.text)
    TextView title;

    public ImageItem(Context context) {
        super(context);
        initLayout();
    }

    public ImageItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        initLayout();
    }

    public ImageItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initLayout();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ImageItem(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initLayout();
    }

    private void initLayout() {
        setOrientation(VERTICAL);
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rootView = inflater.inflate(R.layout.image_item, this, true);
        ButterKnife.inject(this, rootView);
//        setForeground(getResources().getDrawable(R.drawable.custom_selector));
    }

    public void bindTo(ImageData item) {
        title.setText(item.getTitle());
        Picasso.with(getContext()).load(item.getImageUrl()).placeholder(R.drawable.ic_launcher).into(image);
    }

}
