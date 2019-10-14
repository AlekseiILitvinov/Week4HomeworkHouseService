package ru.itpark;

import ru.itpark.model.ApartmentType;
import ru.itpark.model.House;
import ru.itpark.model.OfferType;

public class Main {
    public static void main(String[] args) {
        HouseService service = new HouseService();

        service.addHouse(new House(OfferType.RENT_LONG, ApartmentType.APARTMENT, 1, 1, 10_000, "Ново-Савиновский"));
        service.addHouse(new House(OfferType.RENT_LONG, ApartmentType.APARTMENT, 1, 5, 17_000, "Советский"));
        service.addHouse(new House(OfferType.RENT_LONG, ApartmentType.APARTMENT, 3, 4, 27_000, "Приволжский"));
        service.addHouse(new House(OfferType.RENT_LONG, ApartmentType.APARTMENT, 2, 14, 25_000, "Приволжский"));

        System.out.println(service.searchByPrice(5_000, 20_000));
        System.out.println(service.searchByDistrict("приволжский, советский"));
        System.out.println(service.searchByDistrictAndPrice("приволжский", 25_000));
    }
}
