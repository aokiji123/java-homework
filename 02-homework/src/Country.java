import java.util.ArrayList;
import java.util.List;

public class Country {
    private String countryName;
    private String continentName;
    private long population;
    private String phoneCode;
    private String capital;
    private List<String> cities;

    public Country() {
        this.cities = new ArrayList<>();
    }

    public Country(
            String countryName,
            String continentName,
            long population,
            String phoneCode,
            String capital,
            List<String> cities
    ) {
        this.countryName = countryName;
        this.continentName = continentName;
        this.population = population;
        this.phoneCode = phoneCode;
        this.capital = capital;
        this.cities = cities != null ? cities : new ArrayList<>();
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getContinentName() {
        return continentName;
    }

    public void setContinentName(String continentName) {
        this.continentName = continentName;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public List<String> getCities() {
        return cities;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }

    public void addCity(String city) {
        cities.add(city);
    }

    public void displayInfo() {
        System.out.println("Назва країни: " + countryName);
        System.out.println("Континент: " + continentName);
        System.out.println("Кількість жителів: " + population);
        System.out.println("Телефонний код: " + phoneCode);
        System.out.println("Столиця: " + capital);
        System.out.println("Міста: " + cities);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Country)) return false;
        Country other = (Country) obj;
        return countryName.equals(other.countryName);
    }

    @Override
    public int hashCode() {
        return countryName.hashCode();
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryName='" + countryName + '\'' +
                ", continentName='" + continentName + '\'' +
                ", population=" + population +
                ", phoneCode='" + phoneCode + '\'' +
                ", capital='" + capital + '\'' +
                ", cities=" + cities +
                '}';
    }
}
