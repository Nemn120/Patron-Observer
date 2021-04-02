package observer.business;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WeatherStation implements WeatherSubject{
    private List<WeatherObserver> setOfWeatherObservers;
    private int temp;
    String name;

    public WeatherStation(String name, int temperature) {
        setOfWeatherObservers = new ArrayList<>();
        this.temp = temperature;
        this.name = name;
    }

    @Override
    public void addObserver(WeatherObserver weatherObserver) {
        System.out.println("Se agrego observador"+weatherObserver.getName());
        setOfWeatherObservers.add(weatherObserver);
    }

    @Override
    public void removeObserver(WeatherObserver weatherObserver) {
        System.out.println("Se elimino observador :"+weatherObserver.getName());
        setOfWeatherObservers.remove(weatherObserver);
    }


    @Override
    public void sendNotification() {
        for(WeatherObserver observer : setOfWeatherObservers) {
            observer.update();
        }
    }

    @Override
    public void removeObserverByIndex(int index) {
        System.out.println("Se elimino observador: "+index);
        setOfWeatherObservers.remove(index);
    }

    @Override
    public String showInfos() {
        String infoList="";
        for(WeatherObserver observer : setOfWeatherObservers) {
            infoList += "\n"+observer.showInfo();
        }
        return infoList;
    }

    public void setTemp(int newTemperature) {
        System.out.println("\nEstacion de temperatura: " + name + " temperatura actual:  " + newTemperature + ".");
        temp = newTemperature;
        sendNotification();
    }

    public int getTemp() {
        return temp;
    }

    public List<WeatherObserver> getSetOfWeatherObservers() {
        return setOfWeatherObservers;
    }

    public void setSetOfWeatherObservers(List<WeatherObserver> setOfWeatherObservers) {
        this.setOfWeatherObservers = setOfWeatherObservers;
    }
}
