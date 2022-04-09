import java.io.*;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.io.FileUtils;

class TailTest {

    @org.junit.jupiter.api.Test

    void TailFound(){

        Tail tail = new Tail("files/text2.txt", null, null);
        String in = "files/text1.txt";
        Tail.TailFound(tail, in);
        try {
            assertTrue(FileUtils.contentEquals(new File(tail.OutName), new File("files/test1.txt")),
                    "The files differ!");
       } catch (IOException e) {
            e.printStackTrace();
      }
        tail =  new Tail("files/text2.txt", 12, null);
        Tail.TailFound(tail, in);
        try {
            assertTrue(FileUtils.contentEquals(new File(tail.OutName), new File("files/test2.txt")),
                    "The files differ!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        tail = new Tail("files/text2.txt", null, 4);
        in = "files/text3.txt";
        Tail.TailFound(tail, in);
        try {
            assertTrue(FileUtils.contentEquals(new File(tail.OutName), new File("files/test3.txt")),
                    "The files differ!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        new File(tail.OutName).delete();
    }

}