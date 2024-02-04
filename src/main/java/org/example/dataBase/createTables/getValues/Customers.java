package org.example.dataBase.createTables.getValues;

public class Customers {
    private String companyName;
    private String contactName;
    private String address;

    public Customers() {
    }

    public Customers(String companyName, String contactName, String address) {
        this.companyName = companyName;
        this.contactName = contactName;
        this.address = address;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "companyName='" + companyName + '\'' +
                ", contactName='" + contactName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
