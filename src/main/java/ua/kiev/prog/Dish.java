package ua.kiev.prog;

/**
 * Created by User on 04.01.2017.
 */
public class Dish {
    private int id;
    private String name;
    private double price;
    private int weight;
    private boolean isDiscount;

    public Dish() {
    }

    public Dish(String name, double price, int weight, boolean isDiscount) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.isDiscount = isDiscount;
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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isDiscount() {
        return isDiscount;
    }

    public void setDiscount(boolean discount) {
        isDiscount = discount;
    }
}
