package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity @Table(name = "FOOD")
public class Food implements Serializable {

    @Id    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "PRICE")
    private float price;
    @Column(name = "WEIGHT")
    private float weight;
    @Column(name = "QUANTITY")
    private int quantity;
    @Column(name = "CATEGORY")
    private String category;

    public Food(){}

    public Food(int id, String name, float price, float weight, int quantity, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.quantity = quantity;
        this.category = category;
    }

    public int getId() {   return id;    }
    public void setId(int id) {   this.id = id;    }
    public String getName() {    return name;    }
    public void setName(String name) {   this.name = name;    }
    public float getPrice() {   return price;    }
    public void setPrice(float price) {   this.price = price;    }
    public float getWeight() {   return weight;    }
    public void setWeight(float weight) {   this.weight = weight;    }
    public int getQuantity() {   return quantity;    }
    public void setQuantity(int quantity) {   this.quantity = quantity;    }
    public String getCategory() {    return category;   }
    public void setCategory(String category) {   this.category = category;    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                ", quantity=" + quantity +
                ", category='" + category + '\'' +
                '}';
    }
}
