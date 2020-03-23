package com.liquid.connected;

public class App {

	public static void main(String[] args) throws Exception {

		String message = args[0];

		ConnectedThermo vs = new ConnectedThermo(message);
		vs.toString();

	}
}
