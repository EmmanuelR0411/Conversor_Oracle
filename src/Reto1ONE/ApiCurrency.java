package Reto1ONE;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import javax.swing.JOptionPane;

import org.json.JSONObject;

public class ApiCurrency {

	double valorMonedaTransformar;
	double total;
	JSONObject objectValoresMonedas;
	
	public void solicitudApi(String monedaO) {
		try {
			// https://v6.exchangerate-api.com/v6/0370e6ee2fd7d120f6a91cd0/latest/USD
			String ur = "https://v6.exchangerate-api.com/v6/0370e6ee2fd7d120f6a91cd0/latest/" + monedaO;
			System.out.println("URL: " + ur);
			URL url = new URL(ur);

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();

			int responseCode = conn.getResponseCode();

			if (responseCode != 200) {
				throw new RuntimeException("Ocurrio un error: " + responseCode);
			} else {
				StringBuilder informationString = new StringBuilder();
				Scanner scannner = new Scanner(url.openStream());

				while (scannner.hasNext()) {

					informationString.append(scannner.nextLine());
				}
				scannner.close();

				JSONObject jsonObj = new JSONObject(informationString.toString());

				 this.objectValoresMonedas = jsonObj.getJSONObject("conversion_rates");
			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Lo sentimos, ocurrio un error. Intentelo mas tarde");
			ex.printStackTrace();
		}
	}
	
}
