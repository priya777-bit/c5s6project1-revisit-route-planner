import java.util.Scanner;

public class App
{
    public static void main(String args[])
    {
        ArrayListRoute rl = new ArrayListRoute();
        Scanner sc = new Scanner(System.in);
        String filename="routes.csv";
        rl.readFromFile(filename);
        rl.displayList();
        List<Route> flightlist = new ArrayList<Route>();
        String sourceCity=sc.nextLine();
        flightlist=rl.showDirectFlights(flightlist,sourceCity);
    }
}