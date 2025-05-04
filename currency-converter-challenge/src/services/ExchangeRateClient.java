package services;

import com.google.gson.Gson;
import io.github.cdimascio.dotenv.Dotenv;
import model.PairConversion;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRateClient {
    private static final Dotenv dotenv = Dotenv.load();
    private static final String API_KEY = dotenv.get("EXCHANGE_RATE_API_KEY"); //YOUR API KEY!!!
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/";

    private final Gson gson = new Gson();
    private final HttpClient client = HttpClient.newHttpClient();

    public PairConversion convert(String from, String to, double amount) {
        URI uri = URI.create(BASE_URL + from + "/" + to + "/" + amount);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            //System.out.println("JSON recibido:\n" + response.body());
            return gson.fromJson(response.body(), PairConversion.class);
        } catch (Exception e) {
            throw new RuntimeException("Error al consultar la API: " + e.getMessage(), e);
        }
    }
}