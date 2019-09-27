package packer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Packet {
    private int weightCapacity;
    private List<Item> items;

    public Packet(final int weightCapacity, final List<Item> items){
        this.weightCapacity = weightCapacity;
        this.items = items;
    }

    public Packet(){

    }

    public void setWeightCapacity(int weightCapacity) {
        this.weightCapacity = weightCapacity;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getWeightCapacity() {
        return weightCapacity;
    }

    public List<Item> getItems() {
        if(items == null){
            items = new ArrayList<>();
        }
        return items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Packet)) return false;
        Packet packet = (Packet) o;
        boolean equalFlag = Integer.compare(packet.weightCapacity, weightCapacity) == 0;
        if(equalFlag && packet != null && packet.getItems() != null && items != null && items.size() == packet.getItems().size()){
            Iterator<Item> itemIterator = items.iterator();
            while(itemIterator.hasNext()){
                Item item = itemIterator.next();
                if(!packet.getItems().contains(item)){
                    return false;
                }
            }
        }
        return equalFlag;

    }
}
