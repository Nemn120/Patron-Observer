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
        return "Estacion TV, " + name + ", recibe notificacion. " +
                "Temperatura actual es " + currentTemp + " centigrados";
    }
}
