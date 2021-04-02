package observer.business;

public class WeatherCustomer implements WeatherObserver{

    private final String name;
    private final WeatherStation station;
    private int currentTemp;

    public WeatherCustomer(String name, WeatherStation station) {
        this.name = name;
        this.station = station;
        this.currentTemp = station.getTemp();
    }

    @Override
    public void update() {
        currentTemp = station.getTemp();
        System.out.println("Cliente, " + name + ", recibe notificacion. " +
                "La temperatura actual es " + currentTemp + " grados celcius.");
    }
}
