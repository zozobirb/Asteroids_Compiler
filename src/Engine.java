import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class Engine {
private final String apiKey;
//API REQUESTS HERE
     

protected Engine(){
    //does nothing.. 
    //this.apiKey = System.getenv("NASA_API_KEY");
    this.apiKey = "DEMO_KEY";
    System.out.println("New Engine created!");
}
//WE WNAT RESULTS ONLY NO EXTRA STUFF VISITORS DEAL WITH THAT!!!
//API CALLS there are three
//We have, Feed, Browse, Lookup

//get distance can be refrence either name or id!!
public String getAsteroid(int id){
try {
           
  //http request here if we have an id use NEOWS: Look-up
//parameter asteroid_id, 
//Query: https://api.nasa.gov/neo/rest/v1/neo/ID?api_key=DEMO_KEY 
//
//for now hard coding the id
id = 3542519;
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
}


