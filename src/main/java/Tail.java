import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("WeakerAccess")
public class Tail {

    //String InputName;
    String OutName;
    Integer LastSymbol;
    Integer LastLine;

    public Tail(String OutName,Integer  LastSymbol, Integer LastLine) {

      //  this.InputName = InputName;
        this.OutName = OutName;
        this. LastSymbol = LastSymbol;
        this.LastLine = LastLine;


    }

    public void TailFound(Tail tail, String fileN) {

        if (tail.LastLine == null && tail.LastSymbol == null) EmptyOut(fileN, tail.OutName);

        if (tail.LastLine == null && tail.LastSymbol != null) SymbolsOut(fileN, tail.OutName, tail.LastSymbol);

        if (tail.LastLine != null && tail.LastSymbol == null) BarsOut(fileN, tail.OutName, tail.LastLine);

    }




    private void EmptyOut(String inName, String outName) {

        String content = "";
        Path filePath = Paths.get(inName);
        try {
            content = Files.readString(filePath);

        } catch (IOException e) {

            e.printStackTrace();
        }

        StringBuilder res = new StringBuilder();
        res.append(content);
        res.delete(0, content.length()-9);

        File file = new File(outName);
        FileWriter writer = null;
        try {
            writer = new FileWriter(file);
            writer.write(res.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void SymbolsOut(String inName, String outName, int count) {


        String content = "";
        Path filePath = Paths.get(inName);
        try {
            content = Files.readString(filePath);


        } catch (IOException e) {

            e.printStackTrace();
        }

        StringBuilder res = new StringBuilder();
        res.append(content);

        if (count != content.length()) res.delete(0, content.length()- count);

        File file = new File(outName);
        FileWriter writer = null;
        try {
            writer = new FileWriter(file);
            writer.write(res.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    private void BarsOut(String inName, String outName, int bars) {


        List FileList = new ArrayList();

        try {
            File file = new File(inName);

            FileReader fr = new FileReader(file);

            BufferedReader reader = new BufferedReader(fr);

            String line = reader.readLine();

            while (line != null) {

                line = reader.readLine();

                FileList.add(line);
            }

            reader.close();
        } catch (FileNotFoundException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();
        }

        File file = new File(outName);
        FileWriter writer = null;
        try {
            writer = new FileWriter(file);


            for (int i = bars; i > 0; i--) {

                writer.write(FileList.get(FileList.size()-bars).toString());

            }

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}




