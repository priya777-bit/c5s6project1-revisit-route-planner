import java.util.Scanner;

public class App
{
    public static void main(String args[])
    {
        ArrayListRoute rl = new ArrayListRoute();
        String filename="routes.csv";
        rl.readFromFile(filename);
        rl.displayList();
        List<Route> flightlist = new ArrayList<Route>();
        String sourceCity=
        flightlist=rl.showDirectFlights(flightlist);
    }
}