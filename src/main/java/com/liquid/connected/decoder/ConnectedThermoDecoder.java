package com.liquid.connected.decoder;

import java.util.ArrayList;
import java.util.List;

import com.liquid.connected.responses.ConnectedThermoResponse;

public class ConnectedThermoDecoder {

	public static ConnectedThermoResponse decode(String message) {

		List<Float> splitParts = SplitParts(message, 4);

		ConnectedThermoResponse connectedThermoResponse = new ConnectedThermoResponse();

		connectedThermoResponse.setTemp((splitParts.get(0) / 10) - 40);
		connectedThermoResponse.setHumidity(splitParts.get(1));
		connectedThermoResponse.setSysVolt((float) 0);

		return connectedThermoResponse;

	}

	private static List<Float> SplitParts(String string, int partitionSize) {
		List<Float> parts = new ArrayList<Float>();
		int len = string.length();
		for (int i = 0; i < len; i += partitionSize) {

			System.out.println(string.substring(i, Math.min(len, i + partitionSize)));

			parts.add(convertToDecimal(string.substring(i, Math.min(len, i + partitionSize))));
		}
		return parts;
	}

	private static Float convertToDecimal(String string) {

		Float parseFloat = (float) Integer.parseInt(string, 16);

		return parseFloat;
	}

}
