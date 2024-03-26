package TrafficLights;

public class TrafficLight {
    private Signal signal;

    public TrafficLight(Signal signal) {
        this.signal = signal;
    }

    public void updateSignal() {
        switch (signal) {
            case RED:
                signal = Signal.GREEN;
                break;
            case GREEN:
                signal = Signal.YELLOW;
                break;
            case YELLOW:
                signal = Signal.RED;
                break;
        }
    }

    public String getSignal() {
        return signal.name();
    }
}

