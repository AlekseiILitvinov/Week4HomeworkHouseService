package ru.itpark;

import ru.itpark.model.House;

import java.util.ArrayList;

public class HouseService {
    private int id=0;
    private ArrayList<House> housesList;

    public HouseService() {
        housesList = new ArrayList<>();
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
        for (House house : housesList) {
            if (district.toLowerCase().contains(house.getDistrict().toLowerCase()) &&
                    house.getPrice() <= max && house.getPrice() >= min) {
                results.add(house);
            }
        }
        return results;
    }

    public ArrayList<House> searchByDistrictAndPrice(String district, int max) {
        return searchByDistrictAndPrice(district, 0, max);
    }
}