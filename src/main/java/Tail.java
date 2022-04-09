import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@SuppressWarnings("WeakerAccess")
public class Tail {

    String OutName;
    Integer LastSymbol;
    Integer LastLine;

    public Tail(String OutName,Integer  LastSymbol, Integer LastLine) {

        this.OutName = OutName;
        this. LastSymbol = LastSymbol;
        this.LastLine = LastLine;

    }
    public static void TailFound(Tail tail, String fileN) {

        if (tail.LastLine == null && tail.LastSymbol == null) EmptyOut(fileN, tail.OutName);
        if (tail.LastLine == null && tail.LastSymbol != null) SymbolsOut(fileN, tail.OutName, tail.LastSymbol);
        if (tail.LastLine != null && tail.LastSymbol == null) BarsOut(fileN, tail.OutName, tail.LastLine);

    }

    private static void EmptyOut(String inName, String outName) {

        String content;
        Path filePath = Paths.get(inName);
        try {
            content = Files.readString(filePath);
            StringBuilder res = new StringBuilder();
            res.append(content);
            res.delete(0, content.length()-9);
            File file = new File(outName);
            FileWriter writer = new FileWriter(file);
            writer.write(res.toString());
            writer.close();

        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    private  static void SymbolsOut(String inName, String outName, int count) {

        String content;
        Path filePath = Paths.get(inName);
        try {
            content = Files.readString(filePath);
            StringBuilder res = new StringBuilder();
            res.append(content);
            if (count != content.length()) res.delete(0, content.length()- count);
            File file = new File(outName);
            FileWriter writer;
            writer = new FileWriter(file);
            writer.write(res.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private  static void BarsOut(String inName, String outName, int bars) {

        Path path = Path.of(inName);
        try {
            List<String> list = Files.readAllLines(path);
            BufferedWriter writer = new BufferedWriter(new FileWriter(outName));
            for (int i = bars+1; i != 0; i--) {
                writer.write(list.get(list.size()-i));
                if (i != bars-1) writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}