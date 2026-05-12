import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


public class AsteroidServices{


    
    private final Engine engine = new Engine();
    private List<String> out = new ArrayList<>();
    private String jsonGloob;
    private int typeRequest;



    //constructor for asteroidServices, might not need the engine param..?
  

    //functions actual implementation for the the AsteroidServices interface here:

    
    public void serviceID(int id){

        this.jsonGloob = engine.getAsteroidID(id);
        this.typeRequest = 0;
    }

    public void serviceDate(String start_date, String end_date){
        this.jsonGloob = engine.getAsteroidDate(start_date, end_date);
        this.typeRequest= 1;

    }

    public void serviceAll(){
        this.jsonGloob = engine.getAsteroidALL();
        this.typeRequest = 2;
    }

//HashMap<String, String> map = new HashMap<>();
    public void parseFields(HashMap<String, String> fields){
        //create a case, that will govern how fields are treated
         switch (this.typeRequest) {
                case 0:
                    this.parseById(fields);
                    break;
    
                case 1:
                    this.parseByDate(fields);
                    break;
                
                case 2:
                    this.parseByAll(fields);
                    break;
              
                default: System.out.println("Unknown request!");
            }



       
    }



    public void parseById(HashMap<String, String> fields){

        JsonObject root = JsonParser.parseString(this.jsonGloob).getAsJsonObject();
        JsonArray closeApproaches = root.getAsJsonArray("close_approach_data");
        JsonObject EarthData = closeApproaches.get(2).getAsJsonObject();
         //need to check for each fields and parse correctly accordingly:
        //For size:
        if(fields.containsKey("size")){
            JsonObject est_diam = root.getAsJsonObject("estimated_diameter");
            JsonObject meters = est_diam.getAsJsonObject("meters");
            double size = meters.get("estimated_diameter_max").getAsDouble();
            out.add("Size in meter: "+size+"m");
        }
        //For brightness:
        if(fields.containsKey("brightness")){
            String abs_mag = root.get("absolute_magnitude_h").getAsString();
            out.add("Brightness of asteroid: "+abs_mag);
        }
        //For distance:
        if(fields.containsKey("distance")){
            JsonObject miss_distance = EarthData.get("miss_distance").getAsJsonObject();
            String dist = miss_distance.get("kilometers").getAsString();
            out.add("Distance in kilometers: "+dist+"km");


        }
        //For hazardous:
        if(fields.containsKey("hazardous")){
            boolean hazardous = root.get("is_potentially_hazardous_asteroid").getAsBoolean();;
              if(!hazardous){
                out.add("Asteroid is NOT hazardous");
             } 
             else{
                out.add("Asteroid is hazardous");
             }
        }
        //For active
        if(fields.containsKey("active")){
             boolean active = root.get("is_sentry_object").getAsBoolean();;
             if(!active){
                out.add("Asteroid is NOT active");
             } 
             else{
                out.add("Asteroid is active");
             }
              

        }





    }

    public void parseByDate(HashMap<String, String> fields){

         //need to check for each fields and parse correctly accordingly:
        //For size:
        if(fields.containsKey("size")){

        }
        //For brightness:
        if(fields.containsKey("brightness")){

        }
        //For distance:
        if(fields.containsKey("distance")){

        }
        //For hazardous:
        if(fields.containsKey("hazardous")){

        }
        //For active
        if(fields.containsKey("active")){

        }


    }

    public void parseByAll(HashMap<String, String> fields){

        //create holders for ast fields:
        double obj_size;
        boolean hazardous;
        boolean active;
        String obj_dist;
        String obj_mag;
        JsonObject curr_obj;
        String obj_name;
        String obj_id;
        //gsonObjs for all
        JsonObject root = JsonParser.parseString(this.jsonGloob).getAsJsonObject();
        JsonArray near_earth_arr = root.getAsJsonArray("near_earth_objects");
        //loop through the first 10 objects!
        for(int i = 0; i < 10; i++){//need to have I be the index of near_earth_obj!
            curr_obj = near_earth_arr.get(i).getAsJsonObject();
            //record ID and Name:
            obj_id = curr_obj.get("id").getAsString();
            obj_name = curr_obj.get("name").getAsString();
            
        

         //need to check for each fields and parse correctly accordingly:
        //For size:
        if(fields.containsKey("size")){
            JsonObject est_diam = root.getAsJsonObject("estimated_diameter");
            JsonObject meters = est_diam.getAsJsonObject("meters");
            Double size_obj = meters.get("estimated_diameter_max").getAsDouble();
        }
        //For brightness:
        if(fields.containsKey("brightness")){

        }
        //For distance:
        if(fields.containsKey("distance")){

        }
        //For hazardous:
        if(fields.containsKey("hazardous")){

        }
        //For active
        if(fields.containsKey("active")){

        }
        }

    }










public void testing(){
    this.serviceID(2000887);
    HashMap<String, String> testF = new HashMap<>();
    testF.put("active", ""); 
    testF.put("size", "");
    testF.put("distance", "");
    testF.put("hazardous", "");
    testF.put("brightness", "");
    
    this.parseFields(testF);
    for (String line : out) {
            System.out.println(line);
        
}





}


}




