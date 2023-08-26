package Model;

public class Toy {

    private int id;
    private String name;
    private int quantity;
    private double weight;

    /**
     * @apiNote Class for toys
     * @param id       - ID of the toy
     * @param name     - name of the toy
     * @param quantity - quantity in stock
     * @param weight   - weight for participating in random prizes draw (0-100%)
     */
    public Toy(int id, String name, int quantity, double weight) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.weight = weight;
    }

    public Toy() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getWeight() {
        return weight;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "[ID = " + id + ", name = " + name + ", quantity = " + quantity + ", weight = " + weight + "]";
    }

}
