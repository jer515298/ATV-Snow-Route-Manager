package driver;

import manager.RouteManager;
import model.RouteStop;

import javax.swing.*;
import java.awt.*;

public class GUI {

    private RouteManager manager;
    private JTextArea outputArea;

    public GUI() {
        manager = new RouteManager();

        JFrame frame = new JFrame("ATV Snow Route Manager");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        JButton loadButton = new JButton("Load Stops");
        JButton serveButton = new JButton("Serve Next Stop");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(loadButton);
        buttonPanel.add(serveButton);

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Load sample stops
        loadButton.addActionListener(e -> {
            manager = new RouteManager();

            manager.addStop(new RouteStop("Smith Family", "210 S Story St, Boone, IA", 2));
            manager.addStop(new RouteStop("Johnson Family", "824 W 7th St, Boone, IA", 3));
            manager.addStop(new RouteStop("Davis Family", "1112 Carroll St, Boone, IA", 1));
            manager.addStop(new RouteStop("Miller Family", "915 8th St, Boone, IA", 1));
            manager.addStop(new RouteStop("Wilson Family", "1320 Boone St, Boone, IA", 2));

            outputArea.setText("Sample stops loaded.\n\n");
            displayStops();
        });

        // Serve next stop
        serveButton.addActionListener(e -> {
            if (manager.isEmpty()) {
                outputArea.append("No stops to serve.\n\n");
            } else {
                outputArea.append("Serving next stop:\n");
                outputArea.append(manager.serveNextByAddress() + "\n\n");
                displayStops();
            }
        });

        frame.setVisible(true);
    }

    private void displayStops() {
        outputArea.append("Current Stops:\n");

        // Make a copy so the real queue does not get changed
        java.util.Queue<RouteStop> tempQueue = new java.util.LinkedList<>(manager.getQueue());

        while (!tempQueue.isEmpty()) {
            outputArea.append(tempQueue.poll().toString() + "\n");
        }

        outputArea.append("\nCompleted Stops:\n");

        java.util.Stack<?> tempStack = (java.util.Stack<?>) manager.getCompletedStack().clone();

        while (!tempStack.isEmpty()) {
            outputArea.append(tempStack.pop().toString() + "\n");
        }

        outputArea.append("\nStops left: " + manager.getStopCount() + "\n");
        outputArea.append("Completed: " + manager.getCompletedCount() + "\n\n");
    }

    public static void main(String[] args) {
        new GUI();
    }
}
