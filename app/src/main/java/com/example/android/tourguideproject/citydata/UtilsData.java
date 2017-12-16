package com.example.android.tourguideproject.citydata;
import android.content.Context;
import android.support.annotation.StringDef;

import com.example.android.tourguideproject.R;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
/**
 * Created by Emanuele on 14/12/2017.
 * This class contains all the data of the app. Instead of storing data, they are referenced from
 * string resources. Moreover it contains utility methods to access data
 */
public class UtilsData {
    //using StringDef to avoid invalid fragment type
    @StringDef({FragmentType.MONUMENTS,
            FragmentType.EVENTS,
            FragmentType.HOTELS_RESTAURANTS,
            FragmentType.SHOPPING})
    @Retention(RetentionPolicy.SOURCE)
    public @interface FragmentType {
        String MONUMENTS = "monuments";
        String EVENTS = "events";
        String HOTELS_RESTAURANTS = "hotels_restaurants";
        String SHOPPING = "shopping";
    }
    private static Data data;
    private static Context context;
    private static UtilsData utilsData = new UtilsData();
    //prevent creation
    private UtilsData() {
    }
    private static class Data {
        private ArrayList<TownItem> monuments = null;
        private ArrayList<TownItem> events = null;
        private ArrayList<TownItem> hotelsRestaurants = null;
        private ArrayList<TownItem> shopping = null;
        private Data() {
            //Monuments data
            monuments = new ArrayList<>();
            monuments.add(new TownItem(
                    context.getString(R.string.telusiano_title),
                    R.drawable.telusiano_main,
                    context.getString(R.string.telusiano_description),
                    context.getString(R.string.telusiano_address),
                    context.getString(R.string.telusiano_schedule),
                    context.getString(R.string.telusiano_geouri)));
            monuments.add(new TownItem(
                    context.getString(R.string.bonafede_title),
                    R.drawable.bonafede_main,
                    context.getString(R.string.bonafede_description),
                    context.getString(R.string.bonafede_address),
                    context.getString(R.string.bonafede_schedule),
                    context.getString(R.string.bonafede_geouri)));
            monuments.add(new TownItem(
                    context.getString(R.string.museo_title),
                    R.drawable.museo_main,
                    context.getString(R.string.museo_description),
                    context.getString(R.string.museo_address),
                    context.getString(R.string.museo_schedule),
                    context.getString(R.string.museo_geouri)));
            monuments.add(new TownItem(
                    context.getString(R.string.porte_title),
                    R.drawable.porte_main,
                    context.getString(R.string.porte_description),
                    context.getString(R.string.porte_address),
                    context.getString(R.string.porte_schedule),
                    context.getString(R.string.porte_geouri)));
            monuments.add(new TownItem(
                    context.getString(R.string.priori_title),
                    R.drawable.priori_main,
                    context.getString(R.string.priori_description),
                    context.getString(R.string.priori_address),
                    context.getString(R.string.priori_schedule),
                    context.getString(R.string.priori_geouri)));
            //Events data
            events = new ArrayList<>();
            events.add(new TownItem(
                    context.getString(R.string.teatrando_title),
                    R.drawable.teatrando_main,
                    context.getString(R.string.teatrando_description),
                    context.getString(R.string.teatrando_address),
                    context.getString(R.string.teatrando_schedule),
                    context.getString(R.string.teatrando_geouri)));
            events.add(new TownItem(
                    context.getString(R.string.carnival_title),
                    R.drawable.carnival_main,
                    context.getString(R.string.carnival_description),
                    context.getString(R.string.carnival_address),
                    context.getString(R.string.carnival_schedule),
                    context.getString(R.string.carnival_geouri)));
            events.add(new TownItem(
                    context.getString(R.string.spring_festival_title),
                    R.drawable.spring_festival_main,
                    context.getString(R.string.spring_festival_description),
                    context.getString(R.string.spring_festival_address),
                    context.getString(R.string.spring_festival_schedule),
                    context.getString(R.string.spring_festival_geouri)));
            events.add(new TownItem(
                    context.getString(R.string.tammuria_title),
                    R.drawable.tammuria_main,
                    context.getString(R.string.tammuria_description),
                    context.getString(R.string.tammuria_address),
                    context.getString(R.string.tammuria_schedule),
                    context.getString(R.string.tammuria_geouri)));
            events.add(new TownItem(
                    context.getString(R.string.clown_title),
                    R.drawable.clown_main,
                    context.getString(R.string.clown_description),
                    context.getString(R.string.clown_address),
                    context.getString(R.string.clown_schedule),
                    context.getString(R.string.clown_geouri)));
            //Hotel/Restaurants data
            hotelsRestaurants = new ArrayList<>();
            hotelsRestaurants.add(new TownItem(
                    context.getString(R.string.rosa_title),
                    R.drawable.rosa_main,
                    context.getString(R.string.rosa_description),
                    context.getString(R.string.rosa_address),
                    context.getString(R.string.rosa_schedule),
                    context.getString(R.string.rosa_geouri)));
            hotelsRestaurants.add(new TownItem(
                    context.getString(R.string.noceto_title),
                    R.drawable.noceto_main,
                    context.getString(R.string.noceto_description),
                    context.getString(R.string.noceto_address),
                    context.getString(R.string.noceto_schedule),
                    context.getString(R.string.noceto_geouri)));
            hotelsRestaurants.add(new TownItem(
                    context.getString(R.string.country_title),
                    R.drawable.country_main,
                    context.getString(R.string.country_description),
                    context.getString(R.string.country_address),
                    context.getString(R.string.country_schedule),
                    context.getString(R.string.country_geouri)));
            hotelsRestaurants.add(new TownItem(
                    context.getString(R.string.nicoli_title),
                    R.drawable.nicoli_main,
                    context.getString(R.string.nicoli_description),
                    context.getString(R.string.nicoli_address),
                    context.getString(R.string.nicoli_schedule),
                    context.getString(R.string.nicoli_geouri)));
            //SHOPPING
            shopping = new ArrayList<>();
            shopping.add(new TownItem(
                    context.getString(R.string.baiocco_title),
                    R.drawable.baiocco_main,
                    context.getString(R.string.baiocco_description),
                    context.getString(R.string.baiocco_address),
                    context.getString(R.string.baiocco_schedule),
                    context.getString(R.string.baiocco_geouri)));
            shopping.add(new TownItem(
                    context.getString(R.string.rondinella_title),
                    R.drawable.rondinella_main,
                    context.getString(R.string.rondinella_description),
                    context.getString(R.string.rondinella_address),
                    context.getString(R.string.rondinella_schedule),
                    context.getString(R.string.rondinella_geouri)));
            shopping.add(new TownItem(
                    context.getString(R.string.torresi_title),
                    R.drawable.torresi_main,
                    context.getString(R.string.torresi_description),
                    context.getString(R.string.torresi_address),
                    context.getString(R.string.torresi_schedule),
                    context.getString(R.string.torresi_geouri)));
            shopping.add(new TownItem(
                    context.getString(R.string.ciampechini_title),
                    R.drawable.ciampechini_main,
                    context.getString(R.string.ciampechini_description),
                    context.getString(R.string.ciampechini_address),
                    context.getString(R.string.ciampechini_schedule),
                    context.getString(R.string.ciampechini_geouri)));
            shopping.add(new TownItem(
                    context.getString(R.string.joelle_title),
                    R.drawable.joelle_main,
                    context.getString(R.string.joelle_description),
                    context.getString(R.string.joelle_address),
                    context.getString(R.string.joelle_schedule),
                    context.getString(R.string.joelle_geouri)));
        }
        private ArrayList<TownItem> getMonuments() {
            return monuments;
        }
        private ArrayList<TownItem> getEvents() {
            return events;
        }
        private ArrayList<TownItem> getHotelsRestaurants() {
            return hotelsRestaurants;
        }
        private ArrayList<TownItem> getShopping() {
            return shopping;
        }
    }
    public static UtilsData getData(Context c) {
        context = c;
        if (data == null) {
            //creating data
            data = new Data();
        }
        return utilsData;
    }
    /**
     * Returns an ArrayList whose type is TownItem that represents a list of places and monuments
     *
     * @return a TownItem ArrayList that presents a list of places and monuments
     */
    public static ArrayList<TownItem> getMonuments() {
        return data.getMonuments();
    }
    /**
     * Returns an ArrayList whose type is TownItem that represents a list of events
     *
     * @return a TownItem ArrayList that presents a list of events
     */
    public static ArrayList<TownItem> getEvents() {
        return data.getEvents();
    }
    /**
     * Returns an ArrayList whose type is TownItem that represents a list of hotels and restaurants
     *
     * @return a TownItem ArrayList that presents a list of hotels and restaurants
     */
    public static ArrayList<TownItem> getHotelsRestaurants() {
        return data.getHotelsRestaurants();
    }
    /**
     * Returns an ArrayList whose type is TownItem that represents a list of shops
     *
     * @return a TownItem ArrayList that presents a list of shops
     */
    public static ArrayList<TownItem> getShopping() {
        return data.getShopping();
    }
}
