package ru.itpark.service;

import ru.itpark.model.ApartmentType;
import ru.itpark.model.House;
import ru.itpark.model.OfferType;
import ru.itpark.model.SearchParameters;

import java.util.ArrayList;

public class HouseService {
    private int id = 0;
    private ArrayList<House> housesList = new ArrayList<>();

    public HouseService() {
    }

    public void addHouse(House house) {
        house.setId(id++);
        housesList.add(house);
    }

    public ArrayList<House> searchByPrice(int min, int max) {
        ArrayList<House> results = new ArrayList<>();
        for (House house : housesList) {
            if (house.getPrice() <= max && house.getPrice() >= min) {
                results.add(house);
            }
        }
        return results;
    }

    public ArrayList<House> searchByPrice(int max) {
        return searchByPrice(0, max);
    }

    public ArrayList<House> searchByDistrict(String district) {
        ArrayList<House> results = new ArrayList<>();
        for (House house : housesList) {
            if (district.toLowerCase().contains(house.getDistrict().toLowerCase())) {
                results.add(house);
            }
        }
        return results;
    }

    public ArrayList<House> searchByDistrictAndPrice(String district, int min, int max) {
        ArrayList<House> results = new ArrayList<>();
        ArrayList<House> intermediateResults = searchByPrice(min, max);
        for (House house : intermediateResults) {
            if (district.toLowerCase().contains(house.getDistrict().toLowerCase())) {
                results.add(house);
            }
        }
        return results;
    }

    public ArrayList<House> searchByDistrictAndPrice(String district, int max) {
        return searchByDistrictAndPrice(district, 0, max);
    }

    public ArrayList<House> searchComplex(SearchParameters parameters) {
        ArrayList<House> results = searchByPrice(parameters.getPriceMin(), parameters.getPriceMax());
        results = filterDistrict(parameters.getDistrict(), results);
        results = filterRooms(parameters.getRoomsList(), results);
        results = filterApartmentType(parameters.getApartmentType(), results);
        results = filterOfferType(parameters.getOfferType(), results);
        return results;
    }

    private ArrayList<House> filterDistrict(String district, ArrayList<House> list) {
        ArrayList<House> results = new ArrayList<>();
        for (House house : list) {
            if (district.toLowerCase().contains(house.getDistrict().toLowerCase())) {
                results.add(house);
            }
        }
        return results;
    }

    private ArrayList<House> filterPrice(int min, int max, ArrayList<House> list) {
        ArrayList<House> results = new ArrayList<>();
        for (House house : list) {
            if (house.getPrice() <= max && house.getPrice() >= min) {
                results.add(house);
            }
        }
        return results;
    }

    private ArrayList<House> filterRooms(ArrayList<Integer> roomList, ArrayList<House> list) {
        ArrayList<House> results = new ArrayList<>();
        for (House house : list) {
            if (roomList.isEmpty() || roomList.contains(house.getRooms())) {
                results.add(house);
            }
        }
        return results;
    }

    private ArrayList<House> filterApartmentType(ApartmentType apartmentType, ArrayList<House> list) {
        ArrayList<House> results = new ArrayList<>();
        for (House house : list) {
            if (house.getApartmentType() == apartmentType) {
                results.add(house);
            }
        }
        return results;
    }

    private ArrayList<House> filterOfferType(OfferType offerType, ArrayList<House> list) {
        ArrayList<House> results = new ArrayList<>();
        for (House house : list) {
            if (house.getOfferType() == offerType) {
                results.add(house);
            }
        }
        return results;
    }
}
