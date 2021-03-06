package structures;

import java.util.ArrayList;

public class Order implements DataInterface {

    private int id;
    private String customer;
    private int confirmNumber;
    private double cost;
    private ArrayList<Product> products;
    private String shipping_Address;
    private Company company;
    private int creditNum;
    private String creditName;
    private boolean credit;

    public Order(){
        this.id = 0;
        this.customer = "";
        this.confirmNumber = 0;
        this.cost = 0;
        this.products = new ArrayList<>();
        this.shipping_Address = "";
        this.company = new Company(0,"",0);
        this.creditNum = 0;
        this.creditName = "";
    }

    public Order(int id, String customer, int confirmNumber, double cost, ArrayList<Product> products,
                 String shipping_Address, Company company, int creditNum, String creditName) {
        this.id = id;
        this.customer = customer;
        this.confirmNumber = confirmNumber;
        this.cost = cost;
        this.products = products;
        this.shipping_Address = shipping_Address;
        this.company = company;
        this.creditName = creditName;
        this.creditNum = creditNum;
    }

    public Order(String customer, double cost, String shipping_Address, ArrayList<Product> products, int creditNum, String creditName, boolean credit) {
        this.confirmNumber = confirmNumber;
        this.customer = customer;
        this.cost = cost;
        this.shipping_Address = shipping_Address;
        this.products = products;
        this.company = new Company(0,"",0);
        this.creditNum = creditNum;
        this.creditName = creditName;
        this.credit = credit;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public int getConfirmNumber() {
        return confirmNumber;
    }

    public double getCost() {
        return cost;
    }

    public double getShipping_Cost() {
        return company.getCost();
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public String getShipping_Address() {
        return shipping_Address;
    }

    public String getShipping_Company() {
        return company.getName();
    }

    public Company getCompany(){ return company; }

    public int getCreditNum() { return creditNum; }

    public String getCreditName(){ return creditName; }

    public boolean getCredit(){ return credit; }
}
