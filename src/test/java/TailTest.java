

import java.io.*;

import java.nio.charset.Charset;


import static org.junit.jupiter.api.Assertions.*;

import org.apache.commons.io.FileUtils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

class TailTest {






    //private fun

    
    //Tail Empty = new Tail("files/text1.txt", )


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

        new File(tail.OutName).delete();

        tail =  new Tail("files/text2.txt", 12, null);

        Tail.TailFound(tail, in);

        try {
            assertTrue(FileUtils.contentEquals(new File(tail.OutName), new File("files/test2.txt")),
                    "The files differ!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        new File(tail.OutName).delete();

        tail = new Tail("files/text2.txt", null, 4);

        in = "files/text3.txt";

        Tail.TailFound(tail, in);

        try {
            assertTrue(FileUtils.contentEquals(new File(tail.OutName), new File("files/test3.txt")),
                    "The files differ!");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}