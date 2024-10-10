package model;

public class PhoneCellular extends Phone{
    private String country;
    private String status;

    public PhoneCellular(int id, String name, double price, int quantity, String manufacturer, String country, String status) {
        super(id, name, price, quantity, manufacturer);
        this.country = country;
        this.status = status;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String displayInfo() {
        return "Điện thoại xách tay: " + super.toString() + ", quốc gia xách tay: " + country + ", trạng thái: " + status ;
    }

    public String csvPhoneCellular(){
        return super.csv() + "," + country + "," + status;
    }
}
