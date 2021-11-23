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
    Consumer<Route> display = (d)->System.out.println(d);
    Optional<Route> directFlightInfo = Optional.empty();
    List<Route> directFlight = new ArrayList<Route>();
    List<Route> showAll = new ArrayList<Route>();

    public List<Route> readFromFile(String filename)
    {
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String sentence="";
            String split[];

            while((sentence=br.readLine())!=null)
            {
                split=sentence.split(",");
                Route rp = new Route(split[0],split[1],Integer.parseInt(split[2].trim()),split[3],split[4]);
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
       routeInfo.forEach(display);
    }

    public void showDirectFlights(String source)
    {
        directFlightInfo = routeInfo.stream().filter(p->p.getSource().equalsIgnoreCase(source)).findAny();

        if(directFlightInfo.isPresent())
        {
            directFlight=routeInfo.stream().filter(p->p.getSource().equalsIgnoreCase(source)).collect(Collectors.toList());
            directFlight.forEach(display);
            System.out.println();
            sortDirectFlights(directFlight);
        }
        else
        {
            System.out.println("No Flights....");
        }
    }

    public void sortDirectFlights(List<Route> directFlight)
    {
        directFlight.stream().sorted(Comparator.comparing(Route::getDestination)).forEach(display);
    }

    public void showAllFlights(String source,String destination)
    {
        Optional<Route> source1 = routeInfo.stream().filter(p->p.getSource().equalsIgnoreCase(source)).findAny();

        if(source1.isPresent())
        {
            Optional<Route> destination1 = routeInfo.stream().filter(p->(p.getSource().equalsIgnoreCase(source) && p.getDestination().equalsIgnoreCase(destination))).findAny();
        
            if(destination1.isPresent())
            {
                showAll = routeInfo.stream().filter(p->(p.getSource().equalsIgnoreCase(source) && p.getDestination().equalsIgnoreCase(destination))).collect(Collectors.toList());
                showAll.forEach(display);
            }
            else
            {
                String tempdestination="";
                for(Route r:routeInfo)
                {
                    if(source.equalsIgnoreCase(r.getSource()))
                    {
                        tempdestination=r.getSource();

                        for(Route r1:routeInfo)
                        {
                            if(tempdestination.equalsIgnoreCase(destination) && destination.equalsIgnoreCase(r1.getDestination()))
                            {
                                showAllFlights(source,tempdestination);
                                showAllFlights(tempdestination,destination);
                            }
            }           
                
                        }
                    }
                }
            }
                
        }
        else
        {
            System.out.println("No FLights ...");
        }
    }

}