package Reto1ONE;

import javax.swing.JOptionPane;

import org.json.JSONObject;

public class ConversorMonedas {
	double cantidadNumero;
	String monedaOrigen = "MXN";
	String monedaConversion = "USD";
	double total;

	final Object[] opcionesMonedas = { "De Pesos a Dolar", "De Pesos a Euro", "De Pesos a Yen", "De Pesos a Won Coreano",
			"De Dolar a Pesos", "De Euro a Pesos", "De Yen a Pesos", "De Won Coreano a Pesos" };

	public double parseCantidad(String numero) {
		return Double.parseDouble(numero);
	}

	public void ingreseCantidad() {
		
		boolean continuar = false;

		do {
			String cantidad = JOptionPane.showInputDialog(null, "Ingrese la cantidad de dinero que desea convertir","Input", 3);
			try {

				cantidadNumero = parseCantidad(cantidad);
				continuar = true;

			} catch (NumberFormatException exception) {
				JOptionPane.showMessageDialog(null, "Por favor ingrese un número valido");
			}

		} while (!continuar);

		// return this.cantidadNumero;
	}

	public void eleccionConversion() {
		Object conversion = JOptionPane.showInputDialog(null, "Elije la moneda a la que deseas convertir tu dinero", "Monedas",
				3, null, opcionesMonedas, opcionesMonedas[0]);
		// JOptionPane.showMessageDialog(null, conversion);

		if (conversion == "De Pesos a Dolar") {

			monedaOrigen = "MXN";
			monedaConversion = "USD";
		} else if (conversion == "De Pesos a Euro") {

			monedaOrigen = "MXN";
			monedaConversion = "EUR";

		} else if (conversion == "De Pesos a Yen") {

			monedaOrigen = "MXN";
			monedaConversion = "JPY";

		} else if (conversion == "De Pesos a Won Coreano") {

			monedaOrigen = "MXN";
			monedaConversion = "KRW";

		} else if (conversion == "De Dolar a Pesos") {

			monedaOrigen = "USD";
			monedaConversion = "MXN";

		} else if (conversion == "De Euro a Pesos") {

			monedaOrigen = "EUR";
			monedaConversion = "MXN";

		} else if (conversion == "De Yen a Pesos") {

			monedaOrigen = "JPY";
			monedaConversion = "MXN";

		} else if (conversion == "De Won Coreano a Pesos") {

			monedaOrigen = "KRW";
			monedaConversion = "MXN";

		} else {
			monedaOrigen = "MXN";
			monedaConversion = "USD";
		}
	}
	
	public void calcular(JSONObject objectValoresMonedas) {
		double valorMonedaTransformar = objectValoresMonedas.getDouble(monedaConversion);

		this.total = this.cantidadNumero * valorMonedaTransformar;
		
		JOptionPane.showMessageDialog(null, "Tienes: $" + Math.round(total) + " " + monedaConversion);	
	}
}
