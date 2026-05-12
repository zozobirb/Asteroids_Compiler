import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class Engine {
private final String apiKey;
     
protected Engine(){

    //changing use of key
    this.apiKey = System.getenv("API_KEY");
//     System.out.println("New Engine created!");
  
}
//WE WNAT RESULTS ONLY NO EXTRA STUFF VISITORS DEAL WITH THAT!!!
//API CALLS there are three
//We have, Feed, Browse, Lookup

//used for when parameter is an id
public String getAsteroidID(int id){
try {
           
  //http request here if we have an id use NEOWS: Look-up
//parameter asteroid_id, 
//Query: https://api.nasa.gov/neo/rest/v1/neo/ID?api_key=DEMO_KEY 
//
String url = "https://api.nasa.gov/neo/rest/v1/neo/"+id+"?api_key="+apiKey;

 HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            //for debugging below:
            //System.out.println("Raw JSON response:");
            //System.out.println(response.body());

            //debugging above:

            //here's the output: what's returned:
            //

            return response.body();


} catch (Exception e) {
            e.printStackTrace();
            return null; //throw exceptions
        }
}


//will get all asteroids, given no limit, or no date parameters!

public String getAsteroidALL(){
try {
           
  //http request here if we have an id use NEOWS: Look-up
//parameter asteroid_id, 
//Query: https://api.nasa.gov/neo/rest/v1/neo/browse?api_key=DEMO_KEY 

String url = "https://api.nasa.gov/neo/rest/v1/neo/browse?api_key="+apiKey;

 HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            //for debugging below:
            //System.out.println("Raw JSON response:");
            //System.out.println(response.body());

            //debugging above:

            //here's the output: what's returned:
            //

            return response.body();


} catch (Exception e) {
            e.printStackTrace();
            return null; //throw exceptions
        }
}



public String getAsteroidDate(String start, String end){
try {
           
  //http request here if we have an id use NEOWS: Look-up
//parameter asteroid_id, 
//Query:GET https://api.nasa.gov/neo/rest/v1/feed?start_date=START_DATE&end_date=END_DATE&api_key=API_KEY  
//used for when we recieved the start and end date of a parameter

String url = "https://api.nasa.gov/neo/rest/v1/feed?start_date="+start+"&end_date="+end+"&api_key="+apiKey;

 HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            //for debugging below:
            //System.out.println("Raw JSON response:");
            //System.out.println(response.body());

            //debugging above:

            //here's the output: what's returned:
            //

            return response.body();


} catch (Exception e) {
            e.printStackTrace();
            return null; //throw exceptions
        }
}





}


