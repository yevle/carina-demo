package ylevchenko.gfit.mobile.gui.perfomance;

import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import com.influxdb.client.WriteApiBlocking;
import com.influxdb.client.write.Point;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class InfluxDBService {
    enum Credentials {
        URL("http://localhost:8086"),
        TOKEN("7y03OntLARLN7Atald_mWjb_SLlnBZxDIZRaPbq3lZC6BmOSXWoG6kavGWQrJQX5trQWBH4tT82y714uYoUcvg=="),
        ORG("Solvd"),
        BUCKET("Carina");

        final String value;

        Credentials(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    }

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final InfluxDBClient client = InfluxDBClientFactory.create(Credentials.URL.getValue(), Credentials.TOKEN.getValue().toCharArray());

    public void writePoint(Point point) {
        WriteApiBlocking writeApi = client.getWriteApiBlocking();
        writeApi.writePoint(Credentials.BUCKET.getValue(), Credentials.ORG.getValue(), point);
        LOGGER.info("WRITE InfluxDB point");
    }

}
