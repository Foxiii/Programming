import java.io.*;

import org.antlr.runtime.*;

public class Trs {

    /*
     * Checks whether the string representation of expected (which should be a term
     * or the string representation of a term) is equal (modulo whitespace) to the string
     * representation of actual (which, again, should be a term or the string representation
     * of a term). For testing only.
     */
    public static void assertToStringEquals(String testDescription, Object expected, Object actual) {
        System.out.println(testDescription);
        if ((actual == null && expected == null) ||
                (actual != null &&
                 expected != null &&
                 actual.toString().replaceAll(",[ ]*", ",").equals(expected.toString().replaceAll(",[ ]*", ",")))) {
            System.out.println("Test passed!");
        } else {
            System.out.println("Test failed! Expected " + expected + ", got " + actual + ".");
        }
    }

    /**
     * Parses the TRS from the file whose name is the only argument,
     * prompts for a term to evaluate and shows the result of the evaluation.
     * @param args a singleton array containing the name of a file describing TRS
     */
    public static void main(String[] args) {
        checkArgs(args);
        Trs trs = readTrs(args[0]);
        SimpleIO.output(trs.toString(), "Parsed TRS");
        String input = SimpleIO.getString("Term to evaluate");
        Term t = toTerm(input);
        SimpleIO.output(t.toString(), "Parsed term");
        Term res = trs.normalize(t);
        SimpleIO.output(res.toString(), "Evaluated term");
        System.exit(0); // we have to fix this in SimpleIO...
    }

    /**
     * Checks whether the arguments fit our requirements.
     * @param args the argument array
     */
    private static void checkArgs(String[] args) {
        if (args.length != 1) {
            terminateWithError("The only argument has to be the file name of the TRS.");
        }
    }

    /**
     * @param fileName the name of a file describing a TRS
     * @return the TRS described by the file with the given name
     */
    private static Trs readTrs(String fileName) {
        Reader fr = getFileReader(fileName);
        TrsParser parser = getParser(fr);
        Trs trs = parseTrs(parser);
        return trs;
    }

    private static Trs parseTrs(TrsParser parser) {
        try {
            return parser.trs();
        } catch (RecognitionException e) {
            terminateWithError("Given TRS could not be parsed.");
            return null;
        }
    }

    /**
     * @param string the string representation of a term
     * @return the term represented by the string
     */
    public static Term toTerm(String string) {
        Reader sr = new StringReader(string);
        TrsParser parser = getParser(sr);
        Term t = parseTerm(parser);
        return t;
    }

    private static Term parseTerm(TrsParser parser) {
        try {
            return parser.term();
        } catch (RecognitionException e) {
            terminateWithError("Term could not be parsed.");
            return null;
        }
    }

    private static TrsParser getParser(Reader reader) {
        TrsLexer lex = getLexer(reader);
        CommonTokenStream tokens = new CommonTokenStream(lex);
        return new TrsParser(tokens);
    }

    private static Reader getFileReader(String fileName) {
        try {
            return new FileReader(fileName);
        } catch (FileNotFoundException e) {
            terminateWithError("File not found.");
            return null;
        }
    }

    private static TrsLexer getLexer(Reader r) {
        try {
            return new TrsLexer(new ANTLRReaderStream(r));
        } catch (IOException e) {
            terminateWithError(e.getMessage());
            return null;
        }
    }

    /**
     * Prints an error message and terminates the program.
     * @param message the error message to print
     */
    private static void terminateWithError(String message) {
        System.err.println(message);
        SimpleIO.output(message, "Error");
        System.exit(1);
    }

    private final Rule[] rules;

    public Trs(Rule[] rules) {
        this.rules = rules;
    }

    /**
     * @param t a term
     * @return the result of evaluating t
     */
    public Term normalize(Term t) {
        for (Rule r : this.rules) {
            Term newT = r.rewrite(t);
            if (newT != null) {
                return normalize(newT);
            }
        }
        return t;
    }

    public String toString() {
        String res = "";
        for (Rule r: rules) {
            res += r.toString() + '\n';
        }
        return res;
    }
}
