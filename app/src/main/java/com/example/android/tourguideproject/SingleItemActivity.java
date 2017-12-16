package com.example.android.tourguideproject;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.tourguideproject.citydata.TownItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
/**
 * Created by Emanuele on 15/12/2017.
 * This activity is used to show a single item town with longer description, address and opening schedule
 */
public class SingleItemActivity extends AppCompatActivity {
    @BindView(R.id.main_image)
    ImageView imageView;
    @BindView(R.id.title_view)
    TextView titleView;
    @BindView(R.id.location_view)
    TextView locationView;
    @BindView(R.id.schedule_view)
    TextView scheduleView;
    @BindView(R.id.description_view)
    TextView descriptionView;
    private TownItem townItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_item);
        //using butterKnife to bind View
        ButterKnife.bind(this);
        //retrieve town object
        Intent intent = getIntent();
        townItem = intent.getParcelableExtra("TOWN_ITEM");
        //setting values
        imageView.setImageResource(townItem.getMainImage());
        titleView.setText(townItem.getName());
        locationView.setText(townItem.getLocation());
        scheduleView.setText(townItem.getTimetable());
        descriptionView.setText(townItem.getDescription());
        //retrieving and setting bar title
        String title = intent.getStringExtra("BAR_LABEL");
        setTitle(title);
        //setting content description for the image
        imageView.setContentDescription(getString(R.string.image_of, townItem.getName()));
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //make the up button acts as back button
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    /**
     * handle user click in location view
     *
     * @param view the view clicked by the user
     */
    @OnClick(R.id.location_view)
    public void showOnMap(View view) {
        //creating an implicit intent to view the item on the map
        Intent intent = new Intent(Intent.ACTION_VIEW);
        String uriBegin = "geo:" + townItem.getGeoUri();
        String query = townItem.getGeoUri() + "(" + townItem.getName().toUpperCase() + ")";
        //encode query using UTF-8 scheme
        String encodeQuery = Uri.encode(query);
        String geoUri = uriBegin + "?q=" + encodeQuery + "&z=20";
        intent.setData(Uri.parse(geoUri));
        startActivity(intent);
    }
}
