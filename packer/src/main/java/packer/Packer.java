package packer;

import exceptions.APIException;

import java.util.List;

public class Packer {
    public static String pack(final String filePath) throws APIException {
        PacketFilerReader packetFilerReader = new PacketFilerReader();
        List<Packet> packets = packetFilerReader.readFile(filePath);
        packets.forEach(a -> filterItemsByWeight(a));

        return "";
    }

    private static void filterItemsByWeight(Packet packet){
        packet.getItems().removeIf(a -> a.getWeight()>packet.getWeightCapacity());
    }

    public int[][] createMatrix(Packet packet){
        int[][] matrix = new int[packet.getItems().size() + 1][packet.getWeightCapacity()+1];
        for(Item item : packet.getItems()){
            matrix[item.getIndex()][item.getWeight()]=item.getCost();
        }
        return matrix;
    }


}
