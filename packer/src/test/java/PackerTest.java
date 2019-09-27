import exceptions.APIException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import packer.Item;
import packer.Packet;
import packer.PacketFilerReader;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PackerTest {

    @Test
    @DisplayName("Should open the input file")
    void readInputFile() throws APIException {
        List<Packet> expectedPackets = Arrays.asList(createSamplePacket());
         PacketFilerReader packetFilerReader = new PacketFilerReader();
         List<Packet> packetList = packetFilerReader.readFile("src/test/resources/input.txt");
         assertEquals(expectedPackets.get(0).getWeightCapacity(), packetList.get(0).getWeightCapacity());
    }

    @Test
    @DisplayName("Should check whether the matrix is correctly initialized")
    void checkMatrixInitialisation(){

    }

    //TODO rename to a more understandable name
    @Test
    @DisplayName("Should multiply the values of the weights by 100, so that they can be represented with integers")
    void checkRerepresentationOfWeights(){
        PacketFilerReader packetFilerReader = new PacketFilerReader();
        assertEquals(110, packetFilerReader.changeWeightRepresentation(1.10));
    }

    Packet createSamplePacket(){
        return new Packet(81, Arrays.asList(new Item(1,53.38,45),
                new Item(1,53.38,45),
                new Item(2,88.62,98),
                new Item(3,78.48,3),
                new Item(4,72.30,76),
                new Item(5,30.18,9),
                new Item(6,46.34,48)));
    }
}
