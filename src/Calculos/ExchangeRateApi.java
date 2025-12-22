package Calculos;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRateApi {

    public double obtenerTasaConversion(String monedaBase, String monedaDestino){
        String direccion = "https://v6.exchangerate-api.com/v6/5723e2b5983f4bc6752aebf3/pair/" + monedaBase + "/" + monedaDestino;
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            Gson gson = new Gson();
            MonedaRecord miMoneda = gson.fromJson(response.body(), MonedaRecord.class);
            return miMoneda.conversion_rate();
        }catch (Exception e){
            System.out.println("Ocurrio un error al conectar con la api");
            return -1;
        }
    }
}
