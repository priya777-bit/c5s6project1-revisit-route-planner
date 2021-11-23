public class Route
{
    private String source;
    private String destination;
    private int distance;
    private int time;
    private String cost;

    //constructor
    public Route()
    {

    }
    //parameterised constructor
    public Route(String source,String destination,int distance,int time,String cost)
    {
        this.source=source;
        this.destination=destination;
        this.distance=distance;
        this.time=time;
        this.cost=cost;
    }

    //getters and setters
    public String getSource()
    {
        return source;
    }
    public void setSource(String source)
    {
        this.source=source;
    }
    public String getDestination()
    {
        return destination;
    }
}