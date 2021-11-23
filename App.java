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
        String sourceCity=sc.nextLine();
        System.out.println();
        rl.showDirectFlights(sourceCity);
        System.out.println();
        //rl.sortDirectFlights();
        //String destCity=sc.nextLine();
        //rl.showAllFlights(sourceCity,destCity);
    }
}