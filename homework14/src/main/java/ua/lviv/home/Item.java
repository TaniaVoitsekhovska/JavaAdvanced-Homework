package ua.lviv.home;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Item {


    private int id;
    private double total;
    private Set<Cart> carts =new HashSet<>();

    public Item() {
    }
    public Item(double total) {
        this.total = total;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Set<Cart> getCarts() {
        return carts;
    }

    public void setCarts(Set<Cart> carts) {
        this.carts = carts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id &&
                Double.compare(item.total, total) == 0 &&
                Objects.equals(carts, item.carts);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, total, carts);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", total=" + total +
                '}';
    }
}
