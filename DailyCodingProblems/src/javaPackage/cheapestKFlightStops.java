package javaPackage;

import java.util.ArrayList;

class flight{
    String source;
    String dest;
    int price;

    flight(String source_, String dest_, int price_)
    {
        source = source_;
        dest = dest_;
        price = price_;
    }
}

public class cheapestKFlightStops {

    static ArrayList<flight> findCheapestRoute(int n, flight[] flights, String source, String dest)
    {
        ArrayList<flight> bestRoute = new ArrayList<flight>();
        
        // Solution is complex Djikstra's algorithm using priority queue
        // Study algorithm before attempting

        return bestRoute;
    }
    


    public static void main(String args[])
    {
        
        flight[] flights = new flight[7];

        flights[0] = new flight("JFK", "ATL", 150);
        flights[1] = new flight("ATL", "SFO", 400);
        flights[2] = new flight("ORD", "LAX", 200);
        flights[3] = new flight("LAX", "DFW", 80);
        flights[4] = new flight("JFK", "HKG", 800);
        flights[5] = new flight("ATL", "ORD", 90);
        flights[6] = new flight("JFK", "LAX", 500);

        System.out.println(findCheapestRoute(3, flights, "JFK", "LAX"));

    }
}
