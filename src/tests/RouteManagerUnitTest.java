package tests;

import manager.RouteManager;
import model.RouteStop;

/**
 * Simple tests for the ATV Snow Route Manager.
 *
 * Author: Jeremy McIntyre
 * Course: CIS 153
 * Assignment: Final Project
 */
public class RouteManagerUnitTest {

    public static void main(String[] args) {
        testAddStop();
        testServeNextByAddress();
        testInputValidation();
    }

    public static void testAddStop() {
        RouteManager manager = new RouteManager();

        manager.addStop(new RouteStop("Test One", "100 Main St", 2));
        manager.addStop(new RouteStop("Test Two", "200 Main St", 1));

        if (manager.getStopCount() == 2) {
            System.out.println("testAddStop PASSED");
        } else {
            System.out.println("testAddStop FAILED");
        }
    }

    public static void testServeNextByAddress() {
        RouteManager manager = new RouteManager();

        manager.addStop(new RouteStop("Customer A", "300 Main St", 3));
        manager.addStop(new RouteStop("Customer B", "100 Main St", 1));
        manager.addStop(new RouteStop("Customer C", "200 Main St", 2));

        RouteStop served = manager.serveNextByAddress();

        if (served != null
                && served.getCustomerName().equals("Customer B")
                && manager.getStopCount() == 2
                && manager.getCompletedCount() == 1) {
            System.out.println("testServeNextByAddress PASSED");
        } else {
            System.out.println("testServeNextByAddress FAILED");
        }
    }

    public static void testInputValidation() {
        try {
            new RouteStop("Bad Stop", "400 Main St", 5);
            System.out.println("testInputValidation FAILED");
        } catch (IllegalArgumentException e) {
            System.out.println("testInputValidation PASSED");
        }
    }
}