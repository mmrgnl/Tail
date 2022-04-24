import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TailLauncher {

    @Option(name = "-с", usage = "Input last num of symbols")
    private Integer symbols;

    @Option(name = "-n", usage = "Input last num of lines")
    private Integer lines;

    @Option(name = "-o", usage = "Input fileOut Name")
    private String outfileN;

    @Argument(metaVar = "InputName", usage = "Input file name")
    private String fileN;

    public static void main(String[] args) {
        new TailLauncher().launch(args);
    }

    private void launch(String[] args) {

        CmdLineParser parser = new CmdLineParser(this);
        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            System.err.println("Command line: tail [-c num|-n num] [-o ofile] file");
            parser.printUsage(System.err);
            return;
        }

        try {
            TailFound(outfileN, symbols, lines, fileN);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

         static void TailFound(String outName, Integer lastSymbol, Integer lasting, String fileN) {

           if (lasting == null && lastSymbol == null) LinesOut(fileN, outName, 10); //EmptyOut
            if (lasting == null && lastSymbol != null) SymbolsOut(fileN, outName, lastSymbol);
            if (lasting != null && lastSymbol == null) LinesOut(fileN, outName, lasting);

        }

        private  static void SymbolsOut(String inName, String outName, int count) {

            String content;
            Path filePath = Paths.get(inName);
            try(FileWriter writer = new FileWriter(outName, StandardCharsets.UTF_8)) {
                content = Files.readString(filePath);
                StringBuilder res = new StringBuilder();
                res.append(content);
                res.delete(0, content.length()- count);
                writer.write(res.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private  static void LinesOut(String inName, String outName, int lines ) {

            Path path = Path.of(inName);
            try ( BufferedWriter writer = new BufferedWriter(new FileWriter(outName, StandardCharsets.UTF_8))) {
                List<String> list = Files.readAllLines(path);
                for (int i = lines ; i != 0; i--) {
                    if (i != lines) writer.newLine();
                    writer.write(list.get(list.size()-i));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
