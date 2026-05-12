import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.IOException;
import java.util.HashMap;

import org.antlr.v4.runtime.*;

import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

public class Driver  {

    public static void main(String[] args) throws IOException  {
       // final int SIZE =1 args.length == 0 ? 700 : Integer.parseInt(args[0]) ; 
        CharStream input = CharStreams.fromStream(System.in);
        Glib_GloobLexer lexer = new Glib_GloobLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        Glib_GloobParser parser = new Glib_GloobParser(tokens);
        ParseTree tree = parser.expr();

        // AST
        AstBuilder astBuilder = new AstBuilder();
        Expr ast = astBuilder.visit(tree);
        RequestBuilder req = new RequestBuilder();

        // AST implementation test
        if (ast instanceof Expr e){
            System.out.println("Expression has been read, beginning AST traversal.");
            req.generate(ast);
        }

        // ---- Example of how code will be run: ----
        // HashMap<String> parameters = req.generate(ast);
        // Service service = req.generateService()
        // <List>String output = service.getOutput();
        // for(String line : output)
        // System.out.println(line);
        // -----
        
        //OurEngine OurEngine = new OurEngine();
        //Visitor visitor = new Visitor(OurEngine);

        //IGNORE WONT NEEDlogoEngine.open() ; 

        // while (parser.getCurrentToken().getType() != Token.EOF) {
        //    //ignore for now visitor.visit(parser.command());
        // }
        //WONT NEEDlogoEngine.close() ; 
    
    //**********Debug stage:


//       Engine engine = new Engine();
// ///hard coding the services function!! Down below:
//         String json = engine.getAsteroidID(3542519);
//     //ystem.out.println(json);
       
//         //get the token tokenize
// //Debug for string parsing
// JsonObject root = JsonParser.parseString(json).getAsJsonObject();
// JsonArray closeApproaches = root.getAsJsonArray("close_approach_data");
// //System.out.println(root);
// JsonObject EarthData = closeApproaches.get(2).getAsJsonObject();
// JsonObject miss_distance = EarthData.get("miss_distance").getAsJsonObject();
// double dist = miss_distance.get("kilometers").getAsDouble();//no index, not array, obj, use name!

// //debug checking for other engine query!
// String jsonDate = engine.getAsteroidDate("2015-09-07", "2015-09-08");
// JsonObject rootDate = JsonParser.parseString(jsonDate).getAsJsonObject();
// JsonObject near_earth = rootDate.getAsJsonObject("near_earth_objects");
// //System.out.println(root);
// JsonArray dateArray = near_earth.getAsJsonArray("2015-09-07");
// JsonObject ObjectIndex = dateArray.get(2).getAsJsonObject();
// String asteroidName =  ObjectIndex.get("name").getAsString();

// //debug for browsing all asteroids limit tho!
// String jsonAll = engine.getAsteroidALL();
// JsonObject rootAll = JsonParser.parseString(jsonAll).getAsJsonObject();
// JsonArray near_earthAll = rootAll.getAsJsonArray("near_earth_objects");
// //System.out.println(root);
// JsonObject ObjectAllIndex = near_earthAll.get(2).getAsJsonObject();

// String isHazardous = ObjectAllIndex.get("is_sentry_object").getAsString();

//New testing, services
AsteroidServices testS = new AsteroidServices();
testS.testing();




    
//     //keys are the attributes, needs a key, whereas indexes are elements of a key
//     System.out.println("distance for id search "+dist);
//     System.out.println("name of asteroid date search: "+asteroidName);
//     System.out.println("Is the object #2 selected from all asteroid, is active? "+isHazardous);

//     System.out.println("Updated driver!!");
//     //End of debug stage
    
    












    }



}