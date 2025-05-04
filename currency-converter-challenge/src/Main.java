import model.PairConversion;
import services.ExchangeRateClient;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ExchangeRateClient client = new ExchangeRateClient();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n******** CONVERSOR DE MONEDAS ********");
            System.out.println("1) USD => ARS");
            System.out.println("2) ARS => USD");
            System.out.println("3) USD => BRL");
            System.out.println("4) BRL => USD");
            System.out.println("5) USD => COP");
            System.out.println("6) COP => USD");
            System.out.println("7) Salir");
            System.out.print("\nElija la opción: ");

            int opcion;
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Ingrese un número del 1 al 7.");
                continue;
            }

            if (opcion == 7) {
                System.out.println("Gracias por usar el conversor. ¡Hasta luego!");
                break;
            }

            String from = "", to = "";
            switch (opcion) {
                case 1 -> { from = "USD"; to = "ARS"; }
                case 2 -> { from = "ARS"; to = "USD"; }
                case 3 -> { from = "USD"; to = "BRL"; }
                case 4 -> { from = "BRL"; to = "USD"; }
                case 5 -> { from = "USD"; to = "COP"; }
                case 6 -> { from = "COP"; to = "USD"; }
                default -> {
                    System.out.println("Opción inválida.");
                    continue;
                }
            }

            System.out.print("Ingrese el monto a convertir: ");
            double amount;
            try {
                amount = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Monto inválido. Intente nuevamente.");
                continue;
            }

            try {
                PairConversion result = client.convert(from, to, amount);
                if ("success".equalsIgnoreCase(result.result())) {
                    System.out.printf("Resultado: %.2f %s = %.2f %s\n",
                            amount, from, result.conversion_result(), to);
                } else {
                    System.out.println("Error de conversión: " + result.error_type());
                }
            } catch (RuntimeException e) {
                System.out.println("Error al consultar la API: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
