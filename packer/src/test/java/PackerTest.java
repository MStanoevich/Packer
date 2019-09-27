import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PackerTest {

     @Test
     public void testPacker(){
        assertEquals("", Packer.pack(""));
    }
}
