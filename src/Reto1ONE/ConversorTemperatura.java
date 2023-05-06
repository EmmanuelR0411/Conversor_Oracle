package Reto1ONE;

import javax.swing.JOptionPane;

public class ConversorTemperatura {
	
	double cantidadNumero;
	final Object[] opcionesTemperatura = { "Grados Celcius a Farenheit", "Grados Celcius a Kelvin", "Grados Farenheit a Celcius", "Kelvin a grados Celcius",
			"Kelvin a grados Farenheit"};
	
	String tempOrigen;
	String tempConversion;
	double valorTempConversion;
	
	public double parseCantidad(String numero) {
		return Double.parseDouble(numero);
	}

	public void ingreseCantidad() {

		boolean continuar = false;

		do {
			String cantidad = JOptionPane.showInputDialog(null, "Ingrese el valor de la temperatura que desea convertir",
					"Input", 3);
			try {

				cantidadNumero = parseCantidad(cantidad);
				continuar = true;

			} catch (NumberFormatException exception) {
				JOptionPane.showMessageDialog(null, "Por favor ingrese un número valido");
			}

		} while (!continuar);

	}
	

	public void eleccionConversion(double cantidadIngresada) {
		Object conversion = JOptionPane.showInputDialog(null, "Elije la moneda a la que deseas convertir tu dinero", "Monedas",
				3, null, opcionesTemperatura, opcionesTemperatura[0]);

		if (conversion == "Grados Celcius a Farenheit") {

			tempOrigen = "Celcius";
			tempConversion = "Farenheit";
			valorTempConversion = (cantidadIngresada * 9/5) + 32;
			resultado();
			
		} else if (conversion == "Grados Celcius a Kelvin") {

			tempOrigen = "Celcius";
			tempConversion = "Kelvin";
			valorTempConversion = cantidadIngresada + 273.15;
			resultado();

		} else if (conversion == "Grados Farenheit a Celcius") {

			tempOrigen = "Farenheit";
			tempConversion = "Celcius";
			valorTempConversion = (cantidadIngresada - 32) * 5/9;
			resultado();
			
		} else if (conversion == "Kelvin a grados Celcius") {

			tempOrigen = "Kelvin";
			tempConversion = "Celcius";
			valorTempConversion = cantidadIngresada - 273.15;
			resultado();

		} else if (conversion == "Kelvin a grados Farenheit") {

			tempOrigen = "Kelvin";
			tempConversion = "Farenheit";
			valorTempConversion = (cantidadIngresada - 273.15) * 9/5 + 32;
			resultado();

		} else {
			tempOrigen = "Celcius";
			tempConversion = "Farenheit";
			valorTempConversion = (cantidadIngresada * 9/5) + 32;
			resultado();
		}
	}
	
	public void resultado() {
		JOptionPane.showMessageDialog(null, cantidadNumero + " Grados " + tempOrigen + " son " + Math.round(valorTempConversion)  + " Grados " + tempConversion);
	}
	
}
