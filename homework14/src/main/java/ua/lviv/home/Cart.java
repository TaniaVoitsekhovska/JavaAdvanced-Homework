package ua.lviv.home;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Cart {

    private int id;
    private double total;
    private String name;
    private Set<Item> items = new HashSet<>();

    public Cart() {
    }
    public Cart(double total, String name) {
        this.total = total;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return id == cart.id &&
                Double.compare(cart.total, total) == 0 &&
                Objects.equals(name, cart.name) &&
                Objects.equals(items, cart.items);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, total, name, items);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", total=" + total +
                ", name='" + name + '\'' +
                '}';
    }
}
