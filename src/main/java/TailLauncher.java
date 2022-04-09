import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

public class TailLauncher {

    @Option (name = "-с",  usage = "Input last num of symbols")
    private Integer symbols;

    @Option (name = "-n",  usage = "Input last num of lines")
    private Integer bars;

    @Option (name = "-o",  usage = "Input fileOut Name")
    private String Out;

    @Argument( metaVar = "InputName", usage = "Input file name")
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
        Tail tail = new Tail(Out, symbols, bars);
        try {
            Tail.TailFound(tail, fileN);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}