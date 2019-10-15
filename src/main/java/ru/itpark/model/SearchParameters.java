package ru.itpark.model;

import java.util.ArrayList;

public class SearchParameters extends House {
    private int priceMin = 0;
    private int priceMax;
    private ArrayList<Integer> roomsList = new ArrayList<>();

    public SearchParameters(OfferType offerType, ApartmentType apartmentType, ArrayList<Integer> roomsList, ArrayList<String> district, int priceMin, int priceMax) {
        super(offerType, apartmentType, 0, 0, district.toString());
        this.priceMin = priceMin;
        this.priceMax = priceMax;
        this.roomsList = roomsList;
    }

    public SearchParameters(OfferType offerType, ApartmentType apartmentType, ArrayList<Integer> roomsList, ArrayList<String> district, int priceMax) {
        super(offerType, apartmentType, 0, 0, district.toString());
        this.priceMax = priceMax;
        this.roomsList = roomsList;
    }

    public int getPriceMin() {
        return priceMin;
    }

    public void setPriceMin(int priceMin) {
        this.priceMin = priceMin;
    }

    public int getPriceMax() {
        return priceMax;
    }

    public void setPriceMax(int priceMax) {
        this.priceMax = priceMax;
    }

    public ArrayList<Integer> getRoomsList() {
        return roomsList;
    }

    public void setRoomsList(ArrayList<Integer> roomsList) {
        this.roomsList = roomsList;
    }
}
