package com.example.android.tourguideproject;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android.tourguideproject.citydata.TownItem;
import com.example.android.tourguideproject.citydata.UtilsData;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import butterknife.Unbinder;
/**
 * Created by Emanuele on 15/12/2017.
 * This class creates one fragment for each list in the view pager
 */
public class ListFragment extends Fragment {
    @BindView(R.id.list_view)
    ListView listView;
    private ArrayList<TownItem> itemList = null;
    private String barLabel = null;
    private Unbinder unbinder;
    public ListFragment() {
    }
    /**
     * Called to have the fragment instantiate its user interface view.
     * This is optional, and non-graphical fragments can return null (which
     * is the default implementation).  This will be called between
     * {@link #onCreate(Bundle)} and {@link #onActivityCreated(Bundle)}.
     * <p>
     * <p>If you return a View from here, you will later be called in
     * {@link #onDestroyView} when the view is being released.
     *
     * @param inflater           The LayoutInflater object that can be used to inflate
     *                           any views in the fragment,
     * @param container          If non-null, this is the parent view that the fragment's
     *                           UI should be attached to.  The fragment should not add the view itself,
     *                           but this can be used to generate the LayoutParams of the view.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     *                           from a previous saved state as given here.
     * @return Return the View for the fragment's UI, or null.
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //set layout
        View rootView = inflater.inflate(R.layout.items_list, container, false);
        unbinder = ButterKnife.bind(this, rootView);
        //getting data
        @UtilsData.FragmentType String fragmentType = getArguments().getString("FRAGMENT_TYPE");
        switch (fragmentType) {
            case UtilsData.FragmentType.MONUMENTS:
                //getting list of monuments and creating bar label
                itemList = UtilsData.getData(getContext()).getMonuments();
                barLabel = getString(R.string.bar_label, getString(R.string.city_name),
                        getString(R.string.places_tab).toUpperCase());
                break;
            case UtilsData.FragmentType.EVENTS:
                //getting list of events and creating bar label
                itemList = UtilsData.getData(getContext()).getEvents();
                barLabel = getString(R.string.bar_label, getString(R.string.city_name),
                        getString(R.string.event_tab).toUpperCase());
                break;
            case UtilsData.FragmentType.HOTELS_RESTAURANTS:
                //getting list of hotels and restaurants and creating bar label
                itemList = UtilsData.getData(getContext()).getHotelsRestaurants();
                barLabel = getString(R.string.bar_label, getString(R.string.city_name),
                        getString(R.string.hotel_restaurants_tab).toUpperCase());
                break;
            default:
                //getting list of shops and creating bar label
                itemList = UtilsData.getData(getContext()).getShopping();
                barLabel = getString(R.string.bar_label, getString(R.string.city_name),
                        getString(R.string.shopping_tab).toUpperCase());
        }
        //creating and setting adapter
        ItemsAdapter adapter = new ItemsAdapter(getContext(), itemList);
        listView.setAdapter(adapter);
        return rootView;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
    /**
     * handle user click on list view
     *
     * @param parent   the listview adapter
     * @param position the position element
     */
    @OnItemClick(R.id.list_view)
    public void onItemClick(AdapterView<?> parent, int position) {
        //open selected item
        Intent intent = new Intent(getContext(), SingleItemActivity.class);
        //putting town item selected into the intent
        intent.putExtra("TOWN_ITEM", itemList.get(position));
        //putting the bar label into the intent
        intent.putExtra("BAR_LABEL", barLabel);
        startActivity(intent);
    }
}
