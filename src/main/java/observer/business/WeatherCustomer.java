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
        System.out.println(this.showInfo());
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getCurrentTemp() {
        return currentTemp;
    }

    @Override
    public String showInfo() {
        currentTemp = station.getTemp();
        return "Cliente, " + name + ", recibe notificacion. " +
                "La temperatura actual es " + currentTemp + " grados celcius.";
    }
}
