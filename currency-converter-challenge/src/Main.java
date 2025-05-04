import model.PairConversion;
import services.ExchangeRateClient;

public class Main {
    public static void main(String[] args) {
        ExchangeRateClient client = new ExchangeRateClient();

        try {
            PairConversion result = client.convert("USD", "ARS", 100);
            System.out.printf("100 USD = $" + result.conversion_result() + " ARS\n");
        } catch (RuntimeException e) {
            System.out.println("Error al consultar la API: " + e.getMessage());
        }
    }
}
