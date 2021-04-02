package observer.business;

public interface WeatherObserver{
    void update();
    String getName();
    int getCurrentTemp();
    String showInfo();
}
