import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.io.FileUtils;
import java.io.*;

class TailTest {

    String outFile = "files/OutFile.txt";

    @org.junit.jupiter.api.Test

    void EmptyOut() {

        TailLauncher.TailFound(outFile, null, null, "files/InFile2.txt");
        try {
            assertTrue(FileUtils.contentEquals(new File(outFile), new File("files/test1.txt")),
                    "The files differ!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        new File(outFile).delete();
    }

    @org.junit.jupiter.api.Test

    void SymbolsOut() {

        TailLauncher.TailFound(outFile, 12, null, "files/InFile1.txt");
        try {
            assertTrue(FileUtils.contentEquals(new File(outFile), new File("files/test2.txt")),
                    "The files differ!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        new File(outFile).delete();

    }

    @org.junit.jupiter.api.Test

    void LinesOut(){

        TailLauncher.TailFound(outFile, null, 4, "files/InFile2.txt");
        try {
            assertTrue(FileUtils.contentEquals(new File(outFile), new File("files/test3.txt")),
                    "The files differ!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        new File(outFile).delete();
    }

}