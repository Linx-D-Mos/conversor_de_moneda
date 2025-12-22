package Principal;

import Calculos.Calculo;
import Calculos.ExchangeRateApi;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Calculo calculo = new Calculo();
        ExchangeRateApi servicio = new ExchangeRateApi();
        int opcion = 0;
        double cantidad = 0.0;
        double resultado = 0.0;
        String monedaBase = "", monedaFinal = "";

        String menu = """
                Sea bienvenido al conversor de Moneda = 
                
                1) Dólar =>> Peso argentino.
                2) Peso argentino =>> Dólar.
                3) Real brasileño =>> Dólar.
                4) Dólar =>> Real brasileño.
                5) Peso colombiano =>> Dólar.
                6) Dólar =>> Peso colombiano.
                7) Salir.""";
        String txtCantidad = """ 
                Ingresa el valor que deseas convertir:
                """;
        String txtResultado = """
                El valor %s [%s] corresponde al valor final de =>>> %s [%s]
                """;
        //System.out.println(calculo.calcular(servicio.obtenerTasaConversion("USD","COP"),3 ));
        while (opcion != 7) {
            System.out.println(menu);
            opcion = in.nextInt();
            if (opcion != 7) {
                System.out.println(txtCantidad);
                cantidad = in.nextDouble();
                switch (opcion) {
                    case 1:
                        resultado = calculo.calcular(servicio.obtenerTasaConversion("USD", "ARS"), cantidad);
                        monedaBase = "USD";
                        monedaFinal = "ARS";
                        break;
                    case 2:
                        resultado = calculo.calcular(servicio.obtenerTasaConversion("ARS", "USD"), cantidad);
                        monedaBase = "ARS";
                        monedaFinal = "USD";
                        break;
                    case 3:
                        resultado = calculo.calcular(servicio.obtenerTasaConversion("BRL", "USD"), cantidad);
                        monedaBase = "BRL";
                        monedaFinal = "USD";
                        break;
                    case 4:
                        resultado = calculo.calcular(servicio.obtenerTasaConversion("USD", "BRL"), cantidad);
                        monedaBase = "USD";
                        monedaFinal = "BRL";
                        break;
                    case 5:
                        resultado = calculo.calcular(servicio.obtenerTasaConversion("COP", "USD"), cantidad);
                        monedaBase = "COP";
                        monedaFinal = "USD";
                        break;
                    case 6:
                        resultado = calculo.calcular(servicio.obtenerTasaConversion("USD", "COP"), cantidad);
                        monedaBase = "USD";
                        monedaFinal = "COP";
                        break;
                }
                System.out.println(String.format(txtResultado, cantidad, monedaBase, resultado, monedaFinal));
            }
            System.out.println("Gracias por usar nuestro servicio.");
        }
    }
}
