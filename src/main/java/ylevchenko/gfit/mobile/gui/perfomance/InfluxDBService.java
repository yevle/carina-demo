package ylevchenko.gfit.mobile.gui.perfomance;

import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import com.influxdb.client.WriteApiBlocking;
import com.influxdb.client.write.Point;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ylevchenko.gfit.mobile.gui.service.IPerformanceCredits;

import java.lang.invoke.MethodHandles;

public class InfluxDBService implements IPerformanceCredits {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final InfluxDBClient client = InfluxDBClientFactory.create(URL, TOKEN.toCharArray());

    public void writePoint(Point point) {
        WriteApiBlocking writeApi = client.getWriteApiBlocking();
        writeApi.writePoint(BUCKET, ORG, point);
        LOGGER.info("WRITE InfluxDB point");
    }

}
