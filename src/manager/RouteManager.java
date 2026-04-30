package manager;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import model.CompletedStop;
import model.RouteStop;

/**
 * This class manages the snow removal stops for the ATV project.
 * It uses a queue to store stops that still need to be done,
 * and a stack to store stops that are completed.
 *
 * Author: Jeremy McIntyre
 * Course: CIS 153
 * Assignment: Final Project
 */
public class RouteManager {
    private Queue<RouteStop> stopQueue;
    private Stack<CompletedStop> completedStack;

    public RouteManager() {
        stopQueue = new LinkedList<>();
        completedStack = new Stack<>();
    }
    /**
     * Adds a stop to the queue.
     * Throws an error if the stop is null.
     */
    public void addStop(RouteStop stop) {
        if (stop == null) {
            throw new IllegalArgumentException("Stop cannot be null.");
        }
        stopQueue.offer(stop);
    }

    /**
     * Checks if there are any stops left.
     */
    public boolean isEmpty() {
        return stopQueue.isEmpty();
    }

    /**
     * Returns how many stops are still waiting.
     */
    public int getStopCount() {
        return stopQueue.size();
    }

    /**
     * Returns how many stops have been completed.
     */
    public int getCompletedCount() {
        return completedStack.size();
    }

    /**
     * Prints out all the stops currently in the queue.
     */
    public void displayStops() {
        if (stopQueue.isEmpty()) {
            System.out.println("No stops waiting in the queue.");
        } else {
            System.out.println("Current Snow Route Stops:");
            for (RouteStop stop : stopQueue) {
                System.out.println(stop);
            }
        }
    }

    /**
     * Prints out all completed stops from the stack.
     */
    public void displayCompletedStops() {
        if (completedStack.isEmpty()) {
            System.out.println("No completed stops yet.");
        } else {
            System.out.println("Completed Stops:");
            for (CompletedStop stop : completedStack) {
                System.out.println(stop);
            }
        }
    }
    
    /**
     * Sorts the stops in the queue by address using insertion sort.
     * This helps keep the route more organized.
     */
    public void sortStopsByAddress() {
        RouteStop[] stops = stopQueue.toArray(new RouteStop[0]);

        for (int i = 1; i < stops.length; i++) {
            RouteStop key = stops[i];
            int j = i - 1;

            while (j >= 0 && stops[j].getAddress().compareToIgnoreCase(key.getAddress()) > 0) {
                stops[j + 1] = stops[j];
                j--;
            }

            stops[j + 1] = key;
        }

        stopQueue.clear();

        for (RouteStop stop : stops) {
            stopQueue.offer(stop);
        }
    }

    /**
     * Looks at the next stop by address without removing it.
     */
    public RouteStop peekNextByAddress() {
        if (stopQueue.isEmpty()) {
            return null;
        }

        sortStopsByAddress();
        return stopQueue.peek();
    }

    /**
     * Serves the next stop based on address order.
     * Removes it from the queue and adds it to the completed stack.
     */
    public RouteStop serveNextByAddress() {
        if (stopQueue.isEmpty()) {
            return null;
        }

        sortStopsByAddress();

        RouteStop nextStop = stopQueue.poll();

        CompletedStop completed = new CompletedStop(
                nextStop.getCustomerName(),
                nextStop.getAddress(),
                nextStop.getRoutePriority()
        );

        completedStack.push(completed);

        return nextStop;
    }
}