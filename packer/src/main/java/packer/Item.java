package packer;

public class Item {
    private int index;
    private int weight;
    private int cost;

    public Item(final int index, final int weight, final int cost){
        this.index = index;
        this.weight = weight;
        this.cost = cost;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return index == item.index &&
                Integer.compare(item.weight, weight) == 0 &&
                cost == item.cost;
    }
}
