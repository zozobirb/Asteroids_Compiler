

import java.io.IOException;

import org.antlr.v4.runtime.*;

import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

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
           //ignore for now visitor.visit(parser.command());
        }
        //WONT NEEDlogoEngine.close() ; 
    
    //**********Debug stage:


      Engine engine = new Engine();

        String json = engine.getDistance(3542519);

       
        //get the token tokenize
//Debug for string parsing
JsonObject root = JsonParser.parseString(json).getAsJsonObject();
JsonArray closeApproaches = root.getAsJsonArray("close_approach_data");
JsonObject EarthData = closeApproaches.get(2).getAsJsonObject();
JsonObject miss_distance = EarthData.get("miss_distance").getAsJsonObject();
double dist = miss_distance.get("kilometers").getAsDouble();//no index, not array, obj, use name!
System.out.println("distance is of asteriod id is: "+dist);
    //End of debug stage
    //keys are the attributes, needs a key, whereas indexes are elements of a key
    
    
    
    }



}

