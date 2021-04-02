package observer.business;

public class MainObserver {

    public static void main(String[] args) {

        System.out.println("****** Creating new Weather Station Alpha with current " +
                "temperature of 70 degrees Fahrenheit. ******");
        WeatherStation weatherStation = new WeatherStation("Alpha", 70);

        WeatherCustomer wc1 = new WeatherCustomer("John", weatherStation);
        WeatherCustomer wc2 = new WeatherCustomer("Natalie", weatherStation);

        System.out.println("****** New customers, John and Natalie, have just subscribed " +
                "to Weather Station Alpha. ******");
        weatherStation.addObserver(wc1);
        weatherStation.addObserver(wc2);

        weatherStation.setTemp(77);
        //wc1.update();
        //wc2.update();
        System.out.println("\n****** Weather Station Alpha customer John has unsubscribed " +
                "from the weather station. ******");
        weatherStation.removeObserver(wc1);

        weatherStation.setTemp(68);

        ClientStation tv = new ClientStation("NBC", weatherStation);
        System.out.println("\n****** The NBC TV Station has just subscribed " +
                "to Weather Station Alpha. ******");
        weatherStation.addObserver(tv);

        weatherStation.setTemp(73);
    }
}
