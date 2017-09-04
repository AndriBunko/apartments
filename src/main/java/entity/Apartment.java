package entity;

/**
 * Created by Andrew on 01.09.2017.
 */
public class Apartment {
    private int id;
    private String district;
    private String adres;
    private int area;
    private int numOfRoom;
    private int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getNumOfRoom() {
        return numOfRoom;
    }

    public void setNumOfRoom(int numOfRoom) {
        this.numOfRoom = numOfRoom;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "id=" + id +
                ", district='" + district + '\'' +
                ", adres='" + adres + '\'' +
                ", area=" + area +
                ", numOfRoom=" + numOfRoom +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Apartment apartment = (Apartment) o;

        if (id != apartment.id) return false;
        if (area != apartment.area) return false;
        if (numOfRoom != apartment.numOfRoom) return false;
        if (price != apartment.price) return false;
        if (district != null ? !district.equals(apartment.district) : apartment.district != null) return false;
        return adres != null ? adres.equals(apartment.adres) : apartment.adres == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (district != null ? district.hashCode() : 0);
        result = 31 * result + (adres != null ? adres.hashCode() : 0);
        result = 31 * result + area;
        result = 31 * result + numOfRoom;
        result = 31 * result + price;
        return result;
    }
}
