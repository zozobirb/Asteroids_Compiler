import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class AsteroidServicesImpl implements AsteroidServices{


    //declare apiEngine here
    //AsteroidServices Impl, unlike visitors calling, this class will call 
    //the engine to perform the calls, then this class, will be called from
    //visitor, so visitor isn't becoming too complex
    //we needed an interface for json results -> and what visitor needs
    private final Engine engine;
    //we'll be adding the correct params and fields to list when needed!
    private final  Map<String, String> params = new HashMap<>();
    private final List<String> fields = new ArrayList();
    //constructor for asteroidServicesImpl
    public AsteroidServicesImpl(Engine engine){

        this.engine = engine;

    }

    //functions actual implementation for the the AsteroidServices interface here:

    public String serviceID(int id){

        String json = engine.getAsteroidID(id);
        return json;
    }


    public String serviceDate(String start, String end){

        String json = engine.getAsteroidDate(start, end);
        return json;
    }

    public String serviceAll(){
        String json = engine.getAsteroidALL();
        return json;
    }
//so now with service AST tree we will visit the ast, collect params and fields and service them correctly
     private void serviceAST(Expr e) {
        //get all the parameters here
        if (e instanceof ASSIGN a) {
            params.put(a.ID.name, a.value);
            return;
        }

        //will get all the fields here
        if (e instanceof MINOP min) {
            fields.add(min.field);
            return;
        }




    }






}