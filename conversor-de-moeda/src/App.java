import br.com.models.ConvertJson;
import br.com.models.Moedas;
import br.com.models.ConectAPI;

import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String exchange = "USD";
        while (true) {

            System.out.print("**************************************************\n" +
                    "Seja Bem-vindo ao Conversor de Moeda\n\n" +
                    "1) Dólar             =>>    Peso Argentino\n" +
                    "2) Dólar             =>>    Real Brasileiro\n" +
                    "3) Dólar             =>>    Peso Colombiano\n" +
                    "4) Peso Argentino    =>>    Dólar\n" +
                    "5) Real Brasileiro   =>>    Dólar\n" +
                    "6) Peso Colombiano   =>>    Dólar\n" +
                    "7) Sair\n" +
                    "**************************************************\n");
            System.out.print("Qual conversão deseja realizar? ");
            int option = sc.nextInt();
            if (option == 7) {break;}
            System.out.print("Qual o valor você pretende converte? ");
            double valor = sc.nextDouble();
            ConectAPI conection = new ConectAPI(exchange);
            String json = conection.ReturnJson();
            ConvertJson convertJson = new ConvertJson();
            Moedas exchangeData = convertJson.Convert(json);

            if (option == 1) {
                double resultado = valor * exchangeData.getConversion_rates().get("ARS");
                System.out.printf("o Valor de $%.2f Dollar em Peso Argentino é de %.2f\n", valor, resultado);
            }else if (option == 2) {
                double resultado = valor * exchangeData.getConversion_rates().get("BRL");
                System.out.printf("o Valor de $%.2f Dollar em REAL é de R$%.2f\n", valor, resultado);
            }else if (option == 3) {
                double resultado = valor * exchangeData.getConversion_rates().get("COP");
                System.out.printf("o Valor de $%.2f Dollar em Peso Colombiano é de %.2f\n", valor, resultado);
            }else if (option == 4) {
                double resultado = valor / exchangeData.getConversion_rates().get("ARS");
                System.out.printf("o Valor de %.2f Peso Argentino em Dollar é de $%.2f\n", valor, resultado);
            }else if (option == 5) {
                double resultado = valor / exchangeData.getConversion_rates().get("BRL");
                System.out.printf("o Valor de R$%.2f Real em Dollar é de $%.2f\n", valor, resultado);
            }else if (option == 6) {
                double resultado = valor / exchangeData.getConversion_rates().get("COP");
                System.out.printf("O Valor de %.2f Peso Colombiano em Dollar é de $%.2f\n", valor, resultado);
            }

        }
    }
}
