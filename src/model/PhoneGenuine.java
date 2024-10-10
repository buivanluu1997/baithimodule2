package model;

public class PhoneGenuine extends Phone{
    private int warrantyPeriod;
    private String warrantyScope;

    public PhoneGenuine(int id, String name, double price, int quantity, String manufacturer, int warrantyPeriod, String warrantyScope) {
        super(id, name, price, quantity, manufacturer);
        this.warrantyPeriod = warrantyPeriod;
        this.warrantyScope = warrantyScope;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    public String getWarrantyScope() {
        return warrantyScope;
    }

    public void setWarrantyScope(String warrantyScope) {
        this.warrantyScope = warrantyScope;
    }

    @Override
    public String displayInfo() {
        return "Điện thoại chính hãng: " + super.toString() + ", thời gian bảo hành: " + warrantyPeriod + ", phạm vi bảo hành " + warrantyScope;
    }

    public String csvPhoneGenuine(){
        return super.csv() + "," + warrantyPeriod + "," + warrantyScope + ",";
    }
}
