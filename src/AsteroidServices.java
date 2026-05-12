import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;


public class AsteroidServices{


    
    private final Engine engine = new Engine();
    private List<String> out = new ArrayList<>();
    private String jsonGloob;
    private int typeRequest;
    private String s_date;
    private String e_date;
    private HashMap<String, Double> size = new HashMap<>();
    private HashMap<String, String> distance = new HashMap<>();
    private int min_check;
    private int max_check;




    //constructor for asteroidServices, might not need the engine param..?
  

    public List<String> getOutput(){return this.out;}

    //functions actual implementation for the the AsteroidServices interface here:

    
    public void serviceID(int id){

        this.jsonGloob = engine.getAsteroidID(id);
        this.typeRequest = 0;
    }

    public void serviceDate(String start_date, String end_date){
        this.jsonGloob = engine.getAsteroidDate(start_date, end_date);
        this.typeRequest= 1;
        this.s_date = start_date;
        this.e_date = end_date;
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

         //create holders for ast fields:
        Double obj_size;
        boolean hazardous;
        boolean active;
        String obj_dist;
        String obj_mag;
        JsonObject curr_obj;
        String obj_name;
        String obj_id;
        //gsonObjs for all
        JsonObject root = JsonParser.parseString(this.jsonGloob).getAsJsonObject();
        JsonObject near_earth_obj = root.getAsJsonObject("near_earth_objects");
        JsonArray date = near_earth_obj.getAsJsonArray("2015-09-07");////////////?HARDCODEEEEEEEEEEEEEEEEEEE change to this.s_date
        //ADD THIS:out.add("Asteroid from Start: "+this.s_date);
        //loop through the first 10 objects!
        for(int i = 0; i < 5; i++){//need to have I be the index of near_earth_obj!
            curr_obj = date.get(i).getAsJsonObject();
            //record ID and Name:
            obj_id = curr_obj.get("id").getAsString();
            obj_name = curr_obj.get("name").getAsString();
            out.add("Asteroid i: "+i+" id#"+obj_id+"\nAsteroid name: "+obj_name);
            
        //I need to add a check to see if any keys is MIN or MAX, then loop through, and store them in a list, 
        //a hash perhaps for name and distance and output that!

         //need to check for each fields and parse correctly accordingly:
        //For size:
        if(fields.containsKey("size") && !"MIN".equals(fields.get("size")) && !"MAX".equals(fields.get("size")) ){
            JsonObject est_diam = curr_obj.getAsJsonObject("estimated_diameter");
            JsonObject meters = est_diam.getAsJsonObject("meters");
            obj_size = meters.get("estimated_diameter_max").getAsDouble();
            out.add("Size in meters: "+obj_size+"m");
        }
        //For brightness:
        if(fields.containsKey("brightness")){
            obj_mag = curr_obj.get("absolute_magnitude_h").getAsString();
            out.add("Brightness: "+obj_mag);
        }
        //For distance:
        if(fields.containsKey("distance") && !"MIN".equals(fields.get("distance")) && !"MAX".equals(fields.get("distance"))){
            JsonArray close_approach = curr_obj.getAsJsonArray("close_approach_data");
            JsonObject index = close_approach.get(0).getAsJsonObject();
            JsonObject miss_distance = index.get("miss_distance").getAsJsonObject();
            obj_dist = miss_distance.get("kilometers").getAsString();
            out.add("Distance in kilometers: "+obj_dist+"km");
        }
        //For hazardous:
        if(fields.containsKey("hazardous")){
            hazardous = curr_obj.get("is_potentially_hazardous_asteroid").getAsBoolean();;
              if(!hazardous){
                out.add("Asteroid is NOT hazardous");
             } 
             else{
                out.add("Asteroid is hazardous");
             }
        }
        //For active
        if(fields.containsKey("active")){
            if(fields.containsKey("active")){
             active = curr_obj.get("is_sentry_object").getAsBoolean();;
             if(!active){
                out.add("Asteroid is NOT active");
             } 
             else{
                out.add("Asteroid is active");
             }



        }

        }


        //OPERATION:
         if(fields.containsKey("size") && "MIN".equals(fields.get("size"))){
             JsonObject est_diam = curr_obj.getAsJsonObject("estimated_diameter");
            JsonObject meters = est_diam.getAsJsonObject("meters");
            obj_size = meters.get("estimated_diameter_max").getAsDouble();
            System.out.println("SIZE TRIGGER: " + fields.containsValue("size"));
System.out.println("ADDING SIZE FOR: " + obj_name);
            size.put(obj_name, obj_size);
            min_check = 1;
         }
         if(fields.containsKey("distance") && "MIN".equals(fields.get("distance"))){
            JsonArray close_approach = curr_obj.getAsJsonArray("close_approach_data");
            JsonObject index = close_approach.get(0).getAsJsonObject();
            JsonObject miss_distance = index.get("miss_distance").getAsJsonObject();
            obj_dist = miss_distance.get("kilometers").getAsString();
            distance.put(obj_name, obj_dist);

        }

       

        if(fields.containsKey("size") && "MAX".equals(fields.get("size"))){
            max_check=1;
             JsonObject est_diam = curr_obj.getAsJsonObject("estimated_diameter");
            JsonObject meters = est_diam.getAsJsonObject("meters");
            obj_size = meters.get("estimated_diameter_max").getAsDouble();
            System.out.println("SIZE TRIGGER: " + fields.containsValue("size"));
System.out.println("ADDING SIZE FOR: " + obj_name);
            size.put(obj_name, obj_size);
        }
         
         if(fields.containsKey("distance") && "MAX".equals(fields.get("distance"))){
            max_check = 1;
            JsonArray close_approach = curr_obj.getAsJsonArray("close_approach_data");
            JsonObject index = close_approach.get(0).getAsJsonObject();
            JsonObject miss_distance = index.get("miss_distance").getAsJsonObject();
            obj_dist = miss_distance.get("kilometers").getAsString();
            distance.put(obj_name, obj_dist);

        }
           






        if(i < 4){
        out.add("\n\n-----------\nNext Asteroid\n-----------\n");
        }
        }

    
     if(min_check > 0){
            this.returnMIN(distance, size);
         }
         if(max_check > 0){
            this.returnMAX(distance, size);
         }
         min_check = 0;
         max_check = 0;

/////////////////////////For the second date:
        out.add("\n\n");
        date = near_earth_obj.getAsJsonArray("2015-09-08");////////////?HARDCODEEEEEEEEEEEEEEEEEEE change to this.e_date
        //ADD THIS out.add("Asteroid from Start: "+this.s_date);
        //loop through the first 10 objects!
        for(int i = 0; i < 5; i++){//need to have I be the index of near_earth_obj!
            curr_obj = date.get(i).getAsJsonObject();
            //record ID and Name:
            obj_id = curr_obj.get("id").getAsString();
            obj_name = curr_obj.get("name").getAsString();
            out.add("Asteroid i: "+i+" id#"+obj_id+"\nAsteroid name: "+obj_name);
            
        //I need to add a check to see if any keys is MIN or MAX, then loop through, and store them in a list, 
        //a hash perhaps for name and distance and output that!

         //need to check for each fields and parse correctly accordingly:
        //For size:
         if(fields.containsKey("size") && !"MIN".equals(fields.get("size")) && !"MAX".equals(fields.get("size"))){
            JsonObject est_diam = curr_obj.getAsJsonObject("estimated_diameter");
            JsonObject meters = est_diam.getAsJsonObject("meters");
            obj_size = meters.get("estimated_diameter_max").getAsDouble();
            out.add("Size in meters: "+obj_size+"m");
        }
        //For brightness:
        if(fields.containsKey("brightness")){
            obj_mag = curr_obj.get("absolute_magnitude_h").getAsString();
            out.add("Brightness: "+obj_mag);
        }
        //For distance:
         if(fields.containsKey("distance") && !"MIN".equals(fields.get("distance")) && !"MAX".equals(fields.get("distance"))){
            JsonArray close_approach = curr_obj.getAsJsonArray("close_approach_data");
            JsonObject index = close_approach.get(0).getAsJsonObject();
            JsonObject miss_distance = index.get("miss_distance").getAsJsonObject();
            obj_dist = miss_distance.get("kilometers").getAsString();
            out.add("Distance in kilometers: "+obj_dist+"km");
        }
        //For hazardous:
        if(fields.containsKey("hazardous")){
            hazardous = curr_obj.get("is_potentially_hazardous_asteroid").getAsBoolean();;
              if(!hazardous){
                out.add("Asteroid is NOT hazardous");
             } 
             else{
                out.add("Asteroid is hazardous");
             }
        }
        //For active
        if(fields.containsKey("active")){
            if(fields.containsKey("active")){
             active = curr_obj.get("is_sentry_object").getAsBoolean();;
             if(!active){
                out.add("Asteroid is NOT active");
             } 
             else{
                out.add("Asteroid is active");
             }
       


        }

        }
 //OPERATION:
         if(fields.containsKey("size") && "MIN".equals(fields.get("size"))){
             JsonObject est_diam = curr_obj.getAsJsonObject("estimated_diameter");
            JsonObject meters = est_diam.getAsJsonObject("meters");
            obj_size = meters.get("estimated_diameter_max").getAsDouble();
            System.out.println("SIZE TRIGGER: " + fields.containsValue("size"));
System.out.println("ADDING SIZE FOR: " + obj_name);
            size.put(obj_name, obj_size);
            min_check = 1;
         }
         if(fields.containsKey("distance") && "MIN".equals(fields.get("distance"))){
            JsonArray close_approach = curr_obj.getAsJsonArray("close_approach_data");
            JsonObject index = close_approach.get(0).getAsJsonObject();
            JsonObject miss_distance = index.get("miss_distance").getAsJsonObject();
            obj_dist = miss_distance.get("kilometers").getAsString();
            distance.put(obj_name, obj_dist);

        }

       

        if(fields.containsKey("size") && "MAX".equals(fields.get("size"))){
            max_check=1;
             JsonObject est_diam = curr_obj.getAsJsonObject("estimated_diameter");
            JsonObject meters = est_diam.getAsJsonObject("meters");
            obj_size = meters.get("estimated_diameter_max").getAsDouble();
            System.out.println("SIZE TRIGGER: " + fields.containsValue("size"));
System.out.println("ADDING SIZE FOR: " + obj_name);
            size.put(obj_name, obj_size);
        }
         
         if(fields.containsKey("distance") && "MAX".equals(fields.get("distance"))){
            max_check = 1;
            JsonArray close_approach = curr_obj.getAsJsonArray("close_approach_data");
            JsonObject index = close_approach.get(0).getAsJsonObject();
            JsonObject miss_distance = index.get("miss_distance").getAsJsonObject();
            obj_dist = miss_distance.get("kilometers").getAsString();
            distance.put(obj_name, obj_dist);

        }
           

       





        if(i < 4){
        out.add("\n\n-----------\nNext Asteroid\n-----------");
        }

    }

          if(min_check > 0){
            this.returnMIN(distance, size);
         }
         if(max_check > 0){
            this.returnMAX(distance, size);
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
            out.add("Asteroid i: "+i+" id#"+obj_id+"\nAsteroid name: "+obj_name);
            
        //I need to add a check to see if any keys is MIN or MAX, then loop through, and store them in a list, 
        //a hash perhaps for name and distance and output that!

         //need to check for each fields and parse correctly accordingly:
        //For size:
        if(fields.containsKey("size")){
            JsonObject est_diam = curr_obj.getAsJsonObject("estimated_diameter");
            JsonObject meters = est_diam.getAsJsonObject("meters");
            obj_size = meters.get("estimated_diameter_max").getAsDouble();
            out.add("Size in meters: "+obj_size+"m");
        }
        //For brightness:
        if(fields.containsKey("brightness")){
            obj_mag = curr_obj.get("absolute_magnitude_h").getAsString();
            out.add("Brightness: "+obj_mag);
        }
        //For distance:
        if(fields.containsKey("distance")){
            JsonArray close_approach = curr_obj.getAsJsonArray("close_approach_data");
            JsonObject index = close_approach.get(2).getAsJsonObject();
            JsonObject miss_distance = index.get("miss_distance").getAsJsonObject();
            obj_dist = miss_distance.get("kilometers").getAsString();
            out.add("Distance in kilometers: "+obj_dist+"km");
        }
        //For hazardous:
        if(fields.containsKey("hazardous")){
            hazardous = curr_obj.get("is_potentially_hazardous_asteroid").getAsBoolean();;
              if(!hazardous){
                out.add("Asteroid is NOT hazardous");
             } 
             else{
                out.add("Asteroid is hazardous");
             }
        }
        //For active
        if(fields.containsKey("active")){
            if(fields.containsKey("active")){
             active = curr_obj.get("is_sentry_object").getAsBoolean();;
             if(!active){
                out.add("Asteroid is NOT active");
             } 
             else{
                out.add("Asteroid is active");
             }



        }

        }




  if(fields.containsKey("size") && "MIN".equals(fields.get("size"))){
             JsonObject est_diam = curr_obj.getAsJsonObject("estimated_diameter");
            JsonObject meters = est_diam.getAsJsonObject("meters");
            obj_size = meters.get("estimated_diameter_max").getAsDouble();
            System.out.println("SIZE TRIGGER: " + fields.containsValue("size"));
System.out.println("ADDING SIZE FOR: " + obj_name);
            size.put(obj_name, obj_size);
            min_check = 1;
         }
         if(fields.containsKey("distance") && "MIN".equals(fields.get("distance"))){
            JsonArray close_approach = curr_obj.getAsJsonArray("close_approach_data");
            JsonObject index = close_approach.get(0).getAsJsonObject();
            JsonObject miss_distance = index.get("miss_distance").getAsJsonObject();
            obj_dist = miss_distance.get("kilometers").getAsString();
            distance.put(obj_name, obj_dist);

        }

       

        if(fields.containsKey("size") && "MAX".equals(fields.get("size"))){
            max_check=1;
             JsonObject est_diam = curr_obj.getAsJsonObject("estimated_diameter");
            JsonObject meters = est_diam.getAsJsonObject("meters");
            obj_size = meters.get("estimated_diameter_max").getAsDouble();
            System.out.println("SIZE TRIGGER: " + fields.containsValue("size"));
System.out.println("ADDING SIZE FOR: " + obj_name);
            size.put(obj_name, obj_size);
        }
         
         if(fields.containsKey("distance") && "MAX".equals(fields.get("distance"))){
            max_check = 1;
            JsonArray close_approach = curr_obj.getAsJsonArray("close_approach_data");
            JsonObject index = close_approach.get(0).getAsJsonObject();
            JsonObject miss_distance = index.get("miss_distance").getAsJsonObject();
            obj_dist = miss_distance.get("kilometers").getAsString();
            distance.put(obj_name, obj_dist);

        }
           




        if(i < 9){
        out.add("\n\n-----------\nNext Asteroid\n-----------");
        }





    }

     if(min_check > 0){
            this.returnMIN(distance, size);
         }
         if(max_check > 0){
            this.returnMAX(distance, size);
         }

    max_check = 0;
    min_check = 0;

    }


public void returnMIN(HashMap<String, String> distance,
                      HashMap<String, Double> size){

    if(!size.isEmpty()) {

        Map.Entry<String, Double> minEntry = null;

        for(Map.Entry<String, Double> e : size.entrySet()) {

            if(minEntry == null ||
               e.getValue() < minEntry.getValue()) {

                minEntry = e;
            }
        }

        out.add(
            "Asteroid with minimum size is: "
            + minEntry.getKey()
            + " with size of: "
            + minEntry.getValue()
        );
    }

   if(!distance.isEmpty()) {

    Map.Entry<String, String> maxDist = null;

    for(Map.Entry<String, String> e : distance.entrySet()) {

        if(maxDist == null ||
           Double.parseDouble(e.getValue()) <
           Double.parseDouble(maxDist.getValue())) {

            maxDist = e;
        }
    }

    out.add(
        "Asteroid with minimum distance is: "
        + maxDist.getKey()
        + " with distance of: "
        + maxDist.getValue()
    );
}
}








public void returnMAX(HashMap<String, String> distance,
                      HashMap<String, Double> size){

    if(!size.isEmpty()) {

        Map.Entry<String, Double> maxEntry = null;

        for(Map.Entry<String, Double> e : size.entrySet()) {

            if(maxEntry == null ||
               e.getValue() < maxEntry.getValue()) {

                maxEntry = e;
            }
        }

        out.add(
            "Asteroid with maximum size is: "
            + maxEntry.getKey()
            + " with size of: "
            + maxEntry.getValue()
        );
    }
if(!distance.isEmpty()) {

    Map.Entry<String, String> maxDist = null;

    for(Map.Entry<String, String> e : distance.entrySet()) {

        if(maxDist == null ||
           Double.parseDouble(e.getValue()) >
           Double.parseDouble(maxDist.getValue())) {

            maxDist = e;
        }
    }

    out.add(
        "Asteroid with maximum distance is: "
        + maxDist.getKey()
        + " with distance of: "
        + maxDist.getValue()
    );
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
 






this.serviceAll();
    HashMap<String, String> testFALL = new HashMap<>();
    testFALL.put("active", ""); 
    testFALL.put("size", "MIN");
    testFALL.put("distance", "MIN");
    testFALL.put("hazardous", "");
    testFALL.put("brightness", "");
    
    this.parseFields(testFALL);
    for (String line : out) {
            System.out.println(line);
        
}





this.serviceDate("2015-09-07", "2015-09-08");
    HashMap<String, String> testFDATE = new HashMap<>();
    testFDATE.put("active", ""); 
    testFDATE.put("size", "MAX");
    testFDATE.put("distance", "MAX");
    testFDATE.put("hazardous", "");
    testFDATE.put("brightness", "");
    
    this.parseFields(testFDATE);
    for (String line : out) {
            System.out.println(line);
        
}
}


}




