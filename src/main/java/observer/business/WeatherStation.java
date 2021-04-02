package observer.business;

import java.util.HashSet;
import java.util.Set;

public class WeatherStation implements WeatherSubject{
    private Set<WeatherObserver> setOfWeatherObservers;
    private int temp;
    String name;

    public WeatherStation(String name, int temperature) {
        setOfWeatherObservers = new HashSet<>();
        this.temp = temperature;
        this.name = name;
    }

    @Override
    public void addObserver(WeatherObserver weatherObserver) {
        System.out.println("Se agrego observador");
        setOfWeatherObservers.add(weatherObserver);
    }

    @Override
    public void removeObserver(WeatherObserver weatherObserver) {
        System.out.println("Se elimino observador");
        setOfWeatherObservers.remove(weatherObserver);
    }

    @Override
    public void sendNotification() {
        for(WeatherObserver observer : setOfWeatherObservers) {
            observer.update();
        }
    }

    public void setTemp(int newTemperature) {
        System.out.println("\nWeather Station " + name + " is setting the temperature to " + newTemperature + ".");
        temp = newTemperature;
        sendNotification();
    }

    public int getTemp() {
        return temp;
    }

    public Set<WeatherObserver> getSetOfWeatherObservers() {
        return setOfWeatherObservers;
    }
}
