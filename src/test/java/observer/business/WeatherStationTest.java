package observer.business;

import org.junit.Before;
import org.junit.Test;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

public class WeatherStationTest {

    Logger logger;
    WeatherStation weatherStation;

    @Before
    public void before() {
        logger = Logger.getLogger(WeatherStationTest.class.getName());
        weatherStation= new WeatherStation("ESTACION FISI", 0);
    }

    @Test
    public void AddObserver() {
        weatherStation = new WeatherStation("ESTACION FISI", 23);
        WeatherCustomer wc = new WeatherCustomer("Asther", weatherStation);
        assertNotNull(weatherStation);

        logger.info("OBJETO NULO -> Info Subscripción: "+weatherStation.showInfos());
    }

}