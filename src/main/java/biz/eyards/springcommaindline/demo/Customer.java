package biz.eyards.springcommaindline.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by enshahar on 23/09/2015.
 */

@Entity
public class Customer {
    @Id
    @GeneratedValue
    Long id;
    String name;

    /**
     * Hibernate requires default constructor
     */
    public Customer() {
    }

    public Customer(String name) {
        this.name = name;
    }

    public String toSting() {
        return "Customer [id=" + id + ", name=" + name + "]";
    }
}
