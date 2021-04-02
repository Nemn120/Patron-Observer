package observer.business;

public class ClientStation implements WeatherObserver {

    private final String name;
    private final WeatherStation station;
    private int currentTemp;

    public ClientStation(String name, WeatherStation station) {
        this.name = name;
        this.station = station;
        this.currentTemp = station.getTemp();
    }

    @Override
    public void update() {
        currentTemp = station.getTemp();
        System.out.println("TV Station, " + name + ", received a notification. " +
                "The current temperature is " + currentTemp + " degrees Fahrenheit.");
    }
}
