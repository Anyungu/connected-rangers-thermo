package com.liquid.connected;

import com.liquid.connected.decoder.ConnectedThermoDecoder;
import com.liquid.connected.responses.ConnectedThermoResponse;

public class ConnectedThermo {

	public Float temp;

	public Float humidity;

	public Float sysVolt;

	public ConnectedThermo(String message) throws Exception {

		ConnectedThermoResponse decodeWithoutProbe = ConnectedThermoDecoder.decode(message);

		this.temp = decodeWithoutProbe.getTemp();
		this.humidity = decodeWithoutProbe.getHumidity();
		this.sysVolt = decodeWithoutProbe.getSysVolt();

	}

}
