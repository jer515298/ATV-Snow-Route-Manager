package model;

/**
 * This class represents a completed snow removal stop.
 *
 * Author: Jeremy McIntyre
 * Course: CIS 153
 * Assignment: Final Project
 */
public class CompletedStop {
    private String customerName;
    private String address;
    private int routePriority;

    /**
     * Creates a completed stop.
     *
     * @param customerName the customer name
     * @param address the service address
     * @param routePriority the route priority (1-3)
     */
    public CompletedStop(String customerName, String address, int routePriority) {
        if (customerName == null || customerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer name cannot be blank.");
        }
        if (address == null || address.trim().isEmpty()) {
            throw new IllegalArgumentException("Address cannot be blank.");
        }
        if (routePriority < 1 || routePriority > 3) {
            throw new IllegalArgumentException("Route priority must be 1, 2, or 3.");
        }

        this.customerName = customerName.trim();
        this.address = address.trim();
        this.routePriority = routePriority;
    }

    /**
     * Returns the customer name.
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Returns the address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Returns the route priority.
     */
    public int getRoutePriority() {
        return routePriority;
    }

    /**
     * Returns this completed stop as a string.
     */
    @Override
    public String toString() {
        return "Completed Stop - Customer: " + customerName
                + ", Address: " + address
                + ", Route Priority: " + routePriority;
    }
}