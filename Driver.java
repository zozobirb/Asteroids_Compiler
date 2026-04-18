

import java.io.IOException;

import org.antlr.v4.runtime.*;

public class Driver  {
    public static void main(String[] args) throws IOException  {
        final int SIZE = args.length == 0 ? 700 : Integer.parseInt(args[0]) ; 
        CharStream input = CharStreams.fromStream(System.in);
        Glib_GloobLexer lexer = new Glib_GloobLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        Glib_GloobParser parser = new Glib_GloobParser(tokens);

        //OurEngine OurEngine = new OurEngine();
        //Visitor visitor = new Visitor(OurEngine);

        //IGNORE WONT NEEDlogoEngine.open() ; 

        while (parser.getCurrentToken().getType() != Token.EOF) {
            visitor.visit(parser.command());
        }
        //WONT NEEDlogoEngine.close() ; 
    }
}

