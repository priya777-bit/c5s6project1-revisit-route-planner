import java.util.List;
import java.util.function.*;
import java.util.stream.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class ArrayListRoute
{
    List<Route> routeList = new ArrayList<Route>();

    public List<Route> readFromFile(String filename)
    {
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String sentence="";

            while((sentence=br.readLine())!=null)
            {
                String split[]=sentence.split(",");
                routeList.add(new Route())
            }
        }
    }
}