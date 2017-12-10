package Model;
/**
 *  This class exists simply to encapsulate the data regarding a users adress or the
 *  destination of a product.
 */
public class Adress {

    private int adress;
    private String country;
    private String province;
    private String city;

    public int getAdress() {
        return adress;
    }

    public void setAdress(int adress) {
        this.adress = adress;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
