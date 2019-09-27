package packer;

import exceptions.APIException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PacketFilerReader {

    public List<Packet> readFile(String filePath) throws APIException {

        List<Packet> packets = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))){
            String text = "";
            while((text = bufferedReader.readLine()) != null) {
                String weight = text.substring(0, text.indexOf(':')).trim();
                String items = text.substring(text.indexOf(':') + 1).trim().replaceAll("\\(", "")
                        .replaceAll("\\)", "").replaceAll("\\€", "");
                String[] itemArray = items.split(" ");
                packets.add(createPacket(weight, itemArray));
            }
        }catch (IOException e) {
            throw new APIException("Failed to read the file " + filePath, e);
        }

        return packets;
    }

    private Packet createPacket(String weight, String[] itemArray) {
        Packet packet = new Packet();
        packet.setWeightCapacity(Double.parseDouble(weight));
        packet.setItems(createItem(itemArray));
        return packet;
    }

    private List<Item> createItem(String[] itemArray) {
        List<Item> items = new ArrayList<>();
        for(String value : itemArray){
            String[] itemDetailArray = value.split(",");
            items.add(new Item((Integer.parseInt(itemDetailArray[0])), Double.parseDouble(itemDetailArray[1]),
                    Integer.parseInt(itemDetailArray[2])));

        }
        return items;
    }
}
