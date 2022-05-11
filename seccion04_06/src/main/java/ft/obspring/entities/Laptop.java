
package ft.obspring.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Franco Tallei    
 */

@Entity
public class Laptop implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String color;
    private String model;
    private double price;

    public Laptop() {
    }

    public Laptop(String color, String model, double price) {
        this.color = color;
        this.model = model;
        this.price = price;
    }

    public Laptop(Long id, String color, String model, double price) {
        this.id = id;
        this.color = color;
        this.model = model;
        this.price = price;
    }
    
    

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    
    
    
}
