package com.example.android.tourguideproject.citydata;
import android.os.Parcel;
import android.os.Parcelable;
/**
 * Created by Emanuele on 14/12/2017.
 * This class represents a town item like an event, a place, a shop, a hotel/restaurant
 */
public class TownItem implements Parcelable {
    private final String name;
    private final int mainImage;
    private final String description;
    private final String location;
    private final String timetable;
    private final String geoUri;
    /**
     * Construct a town item object
     *
     * @param name        the name of the item
     * @param mainImage   the image of the item
     * @param description the description
     * @param location    the address of the item
     * @param timetable   the opening schedule
     * @param geoUri      the geo coordinates in the form of lat,lng
     */
    public TownItem(String name, int mainImage, String description, String location,
                    String timetable, String geoUri) {
        this.name = name;
        this.mainImage = mainImage;
        this.description = description;
        this.location = location;
        this.timetable = timetable;
        this.geoUri = geoUri;
    }
    /**
     * Returns the name of the item
     *
     * @return a String that represents the name of the item
     */
    public String getName() {
        return name;
    }
    /**
     * Returns the image of the item
     *
     * @return an int that represents the image id of the item
     */
    public int getMainImage() {
        return mainImage;
    }
    /**
     * Returns the item description
     *
     * @return a String that represents the description of the item
     */
    public String getDescription() {
        return description;
    }
    /**
     * Returns the address of the item
     *
     * @return a String that represents the address of the item
     */
    public String getLocation() {
        return location;
    }
    /**
     * Returns the opening schedule of the item
     *
     * @return a String that describes the opening schedule of the item
     */
    public String getTimetable() {
        return timetable;
    }
    /**
     * Returns the geo coordinates of the item
     *
     * @return a String in the forrm lat,lng that represents the coordinates of the item
     */
    public String getGeoUri() {
        return geoUri;
    }
    @Override
    public int describeContents() {
        return 0;
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.mainImage);
        dest.writeString(this.description);
        dest.writeString(this.location);
        dest.writeString(this.timetable);
        dest.writeString(this.geoUri);
    }
    private TownItem(Parcel in) {
        this.name = in.readString();
        this.mainImage = in.readInt();
        this.description = in.readString();
        this.location = in.readString();
        this.timetable = in.readString();
        this.geoUri = in.readString();
    }
    public static final Parcelable.Creator<TownItem> CREATOR = new Parcelable.Creator<TownItem>() {
        @Override
        public TownItem createFromParcel(Parcel source) {
            return new TownItem(source);
        }
        @Override
        public TownItem[] newArray(int size) {
            return new TownItem[size];
        }
    };
}
