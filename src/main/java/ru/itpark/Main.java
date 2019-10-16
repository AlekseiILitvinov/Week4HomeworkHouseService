package ru.itpark;

import ru.itpark.model.ApartmentType;
import ru.itpark.model.House;
import ru.itpark.model.OfferType;
import ru.itpark.model.SearchParameters;

import java.util.ArrayList;

public class Main {

    public static final String NEW_SAVINOVO = "Ново-Савиновский";
    public static final String SOVIET = "Советский";
    public static final String VOLGA_BY = "Приволжский";

    public static void main(String[] args) {
        HouseService service = new HouseService();

        service.addHouse(new House(OfferType.RENT_LONG, ApartmentType.APARTMENT, 1, 10_000, NEW_SAVINOVO));
        service.addHouse(new House(OfferType.RENT_LONG, ApartmentType.APARTMENT, 2, 15_000, NEW_SAVINOVO));
        service.addHouse(new House(OfferType.RENT_LONG, ApartmentType.APARTMENT, 1, 17_000, SOVIET));
        service.addHouse(new House(OfferType.RENT_LONG, ApartmentType.APARTMENT, 3, 27_000, VOLGA_BY));
        service.addHouse(new House(OfferType.RENT_LONG, ApartmentType.APARTMENT, 2, 25_000, VOLGA_BY));
        service.addHouse(new House(OfferType.RENT_SHORT, ApartmentType.APARTMENT, 2, 3_000, VOLGA_BY));
        service.addHouse(new House(OfferType.BUY, ApartmentType.APARTMENT, 2, 3_500_000, VOLGA_BY));
        service.addHouse(new House(OfferType.RENT_SHORT, ApartmentType.HOUSE_SECTION, 2, 13_000, VOLGA_BY));

        System.out.println(service.searchByPrice(5_000, 20_000));
        System.out.println(service.searchByDistrict("приволжский, советский"));
        System.out.println(service.searchByDistrictAndPrice("приволжский", 25_000));

        ArrayList<Integer> roomsList = new ArrayList<Integer>();
        roomsList.add(2);
        roomsList.add(3);
        ArrayList<String> districtsToSearch = new ArrayList<>();
        districtsToSearch.add("приволжский");
        districtsToSearch.add("Ново-савиновский");

        SearchParameters parameters = new SearchParameters(OfferType.RENT_LONG, ApartmentType.APARTMENT, roomsList, districtsToSearch, 50_000);
        System.out.println("Complex search engine v0.01");
        System.out.println(service.searchComplex(parameters));
    }
}
