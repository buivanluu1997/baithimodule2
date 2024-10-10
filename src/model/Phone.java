package model;

public abstract class Phone {
    private int id;
    private String name;
    private double price;
    private int quantity;
    private String manufacturer;

    public Phone() {
    }

    public Phone(int id, String name, double price, int quantity, String manufacturer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.manufacturer = manufacturer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public abstract String displayInfo();

    @Override
    public String toString() {
        return "id: " + this.id + ", tên: " + this.name + " giá: "
                + this.price + ", số lượng: " + this.quantity + ", nhà sản xuât: " + this.manufacturer;
    }

    public String csv() {
        return id + "," + name + "," + price + "," + quantity + "," + manufacturer;
    }

}
