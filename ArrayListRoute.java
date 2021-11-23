import java.util.List;
import java.util.function.*;
import java.util.stream.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.ParseException;
import java.io.IOException;
import java.lang.Exception;
import java.util.*;

public class ArrayListRoute
{
    List<Route> routeInfo = new ArrayList<Route>();
    Optional<Route> directFlightInfo = new ArrayList<Route>();

    public List<Route> readFromFile(String filename)
    {
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String sentence="";

            while((sentence=br.readLine())!=null)
            {
                String split[]=sentence.split(",");
                routeInfo.add(new Route(split[0],split[1],Integer.parseInt(split[2]),Integer.parseInt(split[3]),split[4]));
            }
        }
        catch(IOException ip)
        {
            System.out.println(ip.toString());
        }
        catch(ParseException pe)
        {
            System.out.println(pe.toString());
        }
    }

    public void displayList()
    {
       Consumer<Route> disp = routeInfo.stream().forEach(d->System.out.println(d)); 
    }

    public void showDirectFlights(ArrayList<Route> routeInfo,String source)
    {
        Optional<String> directFlightInfo = routeInfo.stream().filter(p->p.getSource().equalsIgnoreCase(source)).findAny();
        directFlightInfo.forEach(d->System.out.println(d));

        if(directFlightInfo.isPresent())
        {
            System.out.println(directFlightInfo.get());
        }
        else
        {
            System.out.println("No Flights....");
        }
    }

}