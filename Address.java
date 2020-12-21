package exercise;

public class Address {
    String cityName;

    public Address(String cityName, int zipCode, String streetName, int buildingNumber, char buildingLetter, int apartamentNumber) {
        this.cityName = cityName;
        this.zipCode = zipCode;
        this.streetName = streetName;
        this.buildingNumber = buildingNumber;
        this.buildingLetter = buildingLetter;
        this.apartamentNumber = apartamentNumber;
    }

    int zipCode;

    public String getCityName() {
        return cityName;
    }

    public int getZipCode() {
        return zipCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public int getBuildingNumber() {
        return buildingNumber;
    }

    public char getBuildingLetter() {
        return buildingLetter;
    }

    public int getApartamentNumber() {
        return apartamentNumber;
    }

    String streetName;
    int buildingNumber;
    char buildingLetter;
    int apartamentNumber;
    public Address EMPTY_ADRESS;
}