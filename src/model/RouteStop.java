package model;

/**
 * This class represents a snow removal stop waiting to be done.
 *
 * Author: Jeremy McIntyre
 * Course: CIS 153
 * Assignment: Final Project
 */
public class RouteStop {
    private String customerName;
    private String address;
    private int routePriority;

    /**
     * Creates a route stop.
     *
     * @param customerName the customer name
     * @param address the service address
     * @param routePriority the route priority (1-3)
     */
    public RouteStop(String customerName, String address, int routePriority) {
        setCustomerName(customerName);
        setAddress(address);
        setRoutePriority(routePriority);
    }

    /**
     * Returns the customer name.
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Sets the customer name.
     */
    public void setCustomerName(String customerName) {
        if (customerName == null || customerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer name cannot be blank.");
        }
        this.customerName = customerName.trim();
    }

    /**
     * Returns the address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address.
     */
    public void setAddress(String address) {
        if (address == null || address.trim().isEmpty()) {
            throw new IllegalArgumentException("Address cannot be blank.");
        }
        this.address = address.trim();
    }

    /**
     * Returns the route priority.
     */
    public int getRoutePriority() {
        return routePriority;
    }

    /**
     * Sets the route priority.
     */
    public void setRoutePriority(int routePriority) {
        if (routePriority < 1 || routePriority > 3) {
            throw new IllegalArgumentException("Route priority must be 1, 2, or 3.");
        }
        this.routePriority = routePriority;
    }

    /**
     * Returns this stop as a string.
     */
    @Override
    public String toString() {
        return "Customer: " + customerName
                + ", Address: " + address
                + ", Route Priority: " + routePriority;
    }
}