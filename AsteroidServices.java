public class AsteroidServicesImpl implements AsteroidServices{


    //declare apiEngine here
    //AsteroidServices Impl, unlike visitors calling, this class will call 
    //the engine to perform the calls, then this class, will be called from
    //visitor, so visitor isn't becoming too complex
    //we needed an interface for json results -> and what visitor needs
    private final Engine engine;

    //constructor for asteroidServicesImpl
    public AsteriodServices(Engine engine){

        this.engine = engine

    }

    //functions actual implementation for the the AsteroidServices interface here:

    //Example:

    public double getDistance(int id){

        String json = engine.getDistance(id);//id parameter sent as apart of function call
        //tokenize json, then grab field, we'll have to figure out what field holds the distance
        double token[] = {0.1111}
        
        return token[0];
    }

}