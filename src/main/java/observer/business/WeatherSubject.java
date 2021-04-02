package observer.business;

public interface WeatherSubject {

    void addObserver(WeatherObserver weatherObserver);

    void removeObserver(WeatherObserver weatherObserver);

    void sendNotification();
}
