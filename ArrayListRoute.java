import java.util.List;
import java.util.ArrayList;
import java.util.function.*;
import java.util.stream.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.ParseException;
import java.io.*;
import java.lang.Exception;
import java.util.*;

public class ArrayListRoute
{
    List<Route> routeInfo = new ArrayList<Route>();
    Optional<String> directFlightInfo = Optional.empty();
    Optional<String> sortDirectFlightsInfo = Optional.empty();

    public List<Route> readFromFile(String filename)
    {
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String sentence="";
            String split[];

            while((sentence=br.readLine())!=null)
            {
                split=sentence.split(",").trim();
                Route rp = new Route(split[0],split[1],Integer.parseInt(split[2]),Integer.parseInt(split[3]),split[4]);
                routeInfo.add(rp);
            }
        }
        catch(FileNotFoundException fp)
        {
            System.out.println(fp.toString());
        }
        catch(IOException ip)
        {
            System.out.println(ip.toString());
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
        return routeInfo;
    }

    public void displayList()
    {
       routeInfo.stream().forEach(d->System.out.println(d)); 
    }

    /*public void showDirectFlights(ArrayList<Route> routeInfo,String source)
    {
        directFlightInfo = routeInfo.stream().filter(p->p.getSource().equalsIgnoreCase(source)).findAny().collect(Collectors.toList());

        if(directFlightInfo.isPresent())
        {
            System.out.println(directFlightInfo.get().getSource());
        }
        else
        {
            System.out.println("No Flights....");
        }
    }

    public void sortDirectFlights(Optional<String> directFlightInfo)
    {
       // directFlightInfo = sortDirectFlightsInfo.stream().sorted()
    }*/

}