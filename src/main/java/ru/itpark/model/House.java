package ru.itpark.model;

import java.util.ArrayList;

public class House {
    private ArrayList<String> imagesUrls;
    private OfferType offerType;
    private ApartmentType apartmentType;
    private int rooms;
    private int price;
    private boolean isOwner;
    private String district;
    private int id;

    public House(OfferType offerType, ApartmentType apartmentType, int rooms, int price, String district) {
        this.offerType = offerType;
        this.apartmentType = apartmentType;
        this.rooms = rooms;
        this.price = price;
        this.district = district;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ArrayList<String> getImagesUrls() {
        return imagesUrls;
    }

    public void setImagesUrls(ArrayList<String> imagesUrls) {
        this.imagesUrls = imagesUrls;
    }

    public OfferType getOfferType() {
        return offerType;
    }

    public void setOfferType(OfferType offerType) {
        this.offerType = offerType;
    }

    public ApartmentType getApartmentType() {
        return apartmentType;
    }

    public void setApartmentType(ApartmentType apartmentType) {
        this.apartmentType = apartmentType;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public boolean isOwner() {
        return isOwner;
    }

    public void setOwner(boolean owner) {
        isOwner = owner;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", offerType=" + offerType +
                ", apartmentType=" + apartmentType +
                ", rooms=" + rooms +
                ", price=" + price +
                ", district='" + district + '\'' +
                "}\n";
    }
}
