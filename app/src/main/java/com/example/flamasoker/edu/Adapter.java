package com.example.flamasoker.edu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Flamasoker on 18/11/2019. hola
 */

public class Adapter extends BaseAdapter{

    private static LayoutInflater inflater=null;

    Context context;
    String [][] data;
    int [] positionImg;

    public Adapter(Context context, String [][] data, int [] image) {
        this.context = context;
        this.data=data;
        this.positionImg=image;
        inflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {

        final View view =inflater.inflate(R.layout.elements_list,null);
        TextView title=(TextView) view.findViewById(R.id.txtTitle);
        TextView description=(TextView) view.findViewById(R.id.txtDescription);
        ImageView img=(ImageView) view.findViewById(R.id.imgView);



        title.setText(data[i][0]);
        description.setText(data[i][1]);
        img.setImageResource(positionImg[i]);
        img.setTag(i);

        /**
        img.setOnClickListener(new View.OnClickListener() {

        });

         */
        return view;
    }

    @Override
    public int getCount() {
        return positionImg.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


}
