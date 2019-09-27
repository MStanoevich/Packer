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

    List<Packet> expectedPackets = Arrays.asList(
            new Packet(81, Arrays.asList(new Item(1,53.38,45),
                    new Item(1,53.38,45),
                    new Item(2,88.62,98),
                    new Item(3,78.48,3),
                    new Item(4,72.30,76),
                    new Item(5,30.18,9),
                    new Item(6,46.34,48)))
    );

    @Test
    @DisplayName("Should open the input file")
    void readInputFile() throws APIException {
         PacketFilerReader packetFilerReader = new PacketFilerReader();
         List<Packet> packetList = packetFilerReader.readFile("/Users/mstanoevich/Desktop/Packer/input.txt");
         assertEquals(expectedPackets.get(0).getWeightCapacity(), packetList.get(0).getWeightCapacity());
    }
}
