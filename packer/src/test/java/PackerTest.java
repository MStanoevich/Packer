import exceptions.APIException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import packer.Item;
import packer.Packer;
import packer.Packet;
import packer.PacketFilerReader;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PackerTest {

    @Test
    @DisplayName("Should open the input file")
    void readInputFile() throws APIException {
        List<Packet> expectedPackets = Arrays.asList(createSamplePacketWith6Items());
         PacketFilerReader packetFilerReader = new PacketFilerReader();
         List<Packet> packetList = packetFilerReader.readFile("src/test/resources/input.txt");
         assertEquals(expectedPackets.get(0).getWeightCapacity()*100, packetList.get(0).getWeightCapacity());
    }

    @Test
    @DisplayName("Should check whether the matrix is correctly initialized")
    void checkMatrixInitialisation(){
        Packet packet = createSamplePacketWith1Item();
        int[][] matrix = new int[packet.getItems().size() + 1][packet.getWeightCapacity()+1];
        matrix[1][6] = packet.getItems().get(0).getCost();
        Packer packer = new Packer();
        assertEquals(matrix, packer.createMatrix(packet));
    }

    //TODO rename to a more understandable name
    @Test
    @DisplayName("Should multiply the values of the weights by 100, so that they can be represented with integers")
    void checkRerepresentationOfWeights(){
        PacketFilerReader packetFilerReader = new PacketFilerReader();
        assertEquals(110, packetFilerReader.changeWeightRepresentation(1.10));
    }

    Packet createSamplePacketWith6Items(){
        return new Packet(81, Arrays.asList(new Item(1,5338,45),
                new Item(1,5338,45),
                new Item(2,8862,98),
                new Item(3,7848,3),
                new Item(4,7230,76),
                new Item(5,3018,9),
                new Item(6,4634,48)));
    }

    Packet createSamplePacketWith1Item(){
        return new Packet(8, Arrays.asList(new Item(1,600,45)));
    }
}
