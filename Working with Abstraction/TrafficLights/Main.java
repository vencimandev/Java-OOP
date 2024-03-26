package TrafficLights;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the initial signals from the console
        String inputSignals = scanner.nextLine();

        // Read the number of updates
        int n = scanner.nextInt();

        // Split the input signals and initialize traffic lights
        String[] signals = inputSignals.split(" ");
        List<TrafficLight> trafficLights = new ArrayList<>();
        for (String signal : signals) {
            trafficLights.add(new TrafficLight(Signal.valueOf(signal)));
        }

        // Update and print the state of each traffic light n times
        for (int i = 0; i < n; i++) {
            for (TrafficLight light : trafficLights) {
                light.updateSignal();
                System.out.print(light.getSignal() + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
