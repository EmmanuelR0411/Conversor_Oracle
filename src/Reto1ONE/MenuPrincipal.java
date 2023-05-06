package Reto1ONE;

import javax.swing.JOptionPane;


public class MenuPrincipal {
	public static void main(String[] args) {
		
		boolean repetirPrograma = false;
		
		do {
			final Object[] selectFuncion = { "Conversor de moneda", "Conversor de Temperatura" };
			
			Object seleccion = JOptionPane.showInputDialog(null, "Seleccione una opción de conversión", "Menú", 1, null,
					selectFuncion, selectFuncion[0]);

			if (seleccion == "Conversor de moneda") {
				ConversorMonedas conversor = new ConversorMonedas();
				conversor.ingreseCantidad();
				conversor.eleccionConversion();
				
				ApiCurrency api = new ApiCurrency();
				api.solicitudApi(conversor.monedaOrigen);
				
				conversor.calcular(api.objectValoresMonedas);
			} else {
				//CODIGO PARA CONVERTIR TEMPERATURA
				ConversorTemperatura conversorTemperatura = new ConversorTemperatura();
				
				conversorTemperatura.ingreseCantidad();
				conversorTemperatura.eleccionConversion(conversorTemperatura.cantidadNumero);
			}
			
			int rep = JOptionPane.showConfirmDialog(null, "¿Desea Continuar?");
			
			if (rep == 1 || rep == 2) {
				repetirPrograma = true;
				JOptionPane.showMessageDialog(null, "Programa Terminado");
			}
			
		} while (!repetirPrograma);

	}

}
