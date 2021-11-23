public class App
{
    public static void main(String args[])
    {
        ArrayListRoute rl = new ArrayListRoute();
        String filename="routes.csv";
        rl.readFromFile()
        rl.displayList();
    }
}