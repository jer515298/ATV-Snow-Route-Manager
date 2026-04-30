package driver;

import manager.RouteManager;
import model.RouteStop;

/**
 * Tests the ATV Snow Route Manager final project features.
 *
 * Author: Jeremy McIntyre
 * Course: CIS 153
 * Assignment: Final Project
 */
public class MainTest {

    /**
     * Runs the test program.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        RouteManager manager = new RouteManager();

        try {
            RouteStop stop1 = new RouteStop("Smith Family", "210 S Story St, Boone, IA", 2);
            RouteStop stop2 = new RouteStop("Johnson Family", "824 W 7th St, Boone, IA", 3);
            RouteStop stop3 = new RouteStop("Davis Family", "1112 Carroll St, Boone, IA", 1);
            RouteStop stop4 = new RouteStop("Miller Family", "915 8th St, Boone, IA", 1);
            RouteStop stop5 = new RouteStop("Wilson Family", "1320 Boone St, Boone, IA", 2);

            manager.addStop(stop1);
            manager.addStop(stop2);
            manager.addStop(stop3);
            manager.addStop(stop4);
            manager.addStop(stop5);

            System.out.println("After adding sample stops:");
            manager.displayStops();

            System.out.println();
            System.out.println("Stops sorted by address (for better route):");
            manager.sortStopsByAddress();
            manager.displayStops();

            System.out.println();
            System.out.println("Next stop by address:");
            System.out.println(manager.peekNextByAddress());

            System.out.println();
            System.out.println("Serving next stop by address:");
            System.out.println(manager.serveNextByAddress());

            System.out.println();
            System.out.println("Queue after serving one stop:");
            manager.displayStops();

            System.out.println();
            manager.displayCompletedStops();

            System.out.println();
            System.out.println("Total stops left: " + manager.getStopCount());
            System.out.println("Total completed stops: " + manager.getCompletedCount());

        } catch (IllegalArgumentException e) {
            System.out.println("Input error: " + e.getMessage());
        }
    }
}