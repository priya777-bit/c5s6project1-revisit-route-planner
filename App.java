import java.text.ParseException;

public class App
{
    public static void main(String args[]) throws ParseException
    {
        ArrayListRoute rl = new ArrayListRoute();
        String filename="routes.csv";
        rl.readFromFile(filename);
        rl.displayList();
    }
}