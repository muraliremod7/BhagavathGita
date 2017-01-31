package com.murali.hariprahlad.bhagavathgita.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.murali.hariprahlad.bhagavathgita.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Hari Prahlad on 07-01-2017.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private ArrayList<String> main_Name;
    private ArrayList<String> sponser_Name;
    int[] arrayimages = {
            R.drawable.viswaswararao,
            R.drawable.karunakargaru,
            R.drawable.smtumasasisrisarma,
            R.drawable.drrajagopalrao,
            R.drawable.venkatraogaru,
            R.drawable.haribabugaru,
            R.drawable.sambasivagaru,
            R.drawable.mallikarjunagaru,
            R.drawable.nageswarraogaru,
            R.drawable.drnarasingaraogaru,
            R.drawable.ramanamurthygaru,
            R.drawable.hindutemple,
            R.drawable.ramachandragaru,
            R.drawable.rameshbabugaru,
            R.drawable.ramakrishnagaru,
            R.drawable.sridoondy,
            R.drawable.krishnakeya,
            R.drawable.ravuri,
            R.drawable.prabhakarreddy,
            R.drawable.srisriniraju

    };
    public DataAdapter(ArrayList<String> mainname,ArrayList<String> sponsername) {
        this.main_Name = mainname;
        this.sponser_Name = sponsername;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_row, viewGroup, false);
        //arrayimages = r.getIntArray(R.array.sponserimages);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder viewHolder, int i) {

        viewHolder.main_name.setText(main_Name.get(i));
        viewHolder.sponser_Image.setImageResource(arrayimages[i]);
        viewHolder.sponser_name.setText(sponser_Name.get(i));
    }

    @Override
    public int getItemCount() {
        return main_Name.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView main_name;
        private ImageView sponser_Image;
        private TextView sponser_name;
        public ViewHolder(View view) {
            super(view);

            main_name = (TextView)view.findViewById(R.id.main_name);
            sponser_Image = (ImageView)view.findViewById(R.id.sponser_pic);
            sponser_name = (TextView)view.findViewById(R.id.sponser_name);
        }
    }

}
