package com.example.android.tourguideproject;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.tourguideproject.citydata.TownItem;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
/**
 * Created by Emanuele on 15/12/2017.
 * Custom array adapter class
 */
public class ItemsAdapter extends ArrayAdapter<TownItem> {
    public ItemsAdapter(Context context, ArrayList<TownItem> list) {
        super(context, 0, list);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        //getting item from the list
        TownItem townItem = getItem(position);
        //setting values
        holder.mainImage.setImageResource(townItem.getMainImage());
        holder.mainImage.setContentDescription(getContext().getString(R.string.image_of, townItem.getName()));
        holder.titleView.setText(townItem.getName());
        holder.descriptionView.setText(townItem.getDescription());
        return convertView;
    }
    static class ViewHolder {
        @BindView(R.id.main_image)
        ImageView mainImage;
        @BindView(R.id.title_view)
        TextView titleView;
        @BindView(R.id.description_view)
        TextView descriptionView;
        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
