import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.text.DecimalFormat;

public class code {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println("Olá, bem-vindo à Bodega do Isaac! Aqui temos os seguintes produtos: \nSabonete - R$ 2.00 \nShampoo - R$ 10.00 \nPS5 - R$ 5000.00 \nmotorola - R$299.99 \nÓleo - R$ 7.00 \nPão - R$ 6.30 \nValor do frete padrão: 26.00 (Frete Grátis em compras maiores que 200 reais) \nO que deseja comprar?");

        Map<String, Double> lista = new HashMap<>();
        lista.put("Sabonete", 2.00);
        lista.put("sabonete", 2.00);
        lista.put("Shampoo", 10.00);
        lista.put("shampoo", 10.00);
        lista.put("PS5", 5000.00);
        lista.put("pc", 2200.00);
        lista.put("Oleo", 7.00);
        lista.put("oleo", 7.00);
        lista.put("óleo", 7.00);
        lista.put("Óleo", 7.00);
        lista.put("Pao", 6.30);
        lista.put("pao", 6.30);
        lista.put("Pão", 6.30);
        lista.put("pão", 6.30);

        String produto = in.nextLine();

        // preço
        double precoproduto = lista.get(produto);
        // incremento do produto
        double valorproduto = 0.00;
        double Frete = 0.00;
        double valortotal = 0.00;

        if (lista.containsKey(produto)) {
            valorproduto += precoproduto;
            Frete = valorproduto / 1.5;
            valortotal = valorproduto + Frete;

            if (valorproduto >= 200) {
                valortotal = valorproduto;
            }
            if (valorproduto >= 200) {
                Frete = 0;
            } else {
                Frete = valorproduto / 1.5;
            }
            
            System.out.println("Valor total: R$ " + df.format(valortotal) + " (Valor do produto: R$ " + df.format(valorproduto) + " + Valor do frete: R$ " + Frete + ")");
        } else {
            while (!lista.containsKey(produto)) {
                System.out.println("Produto não encontrado:/");
                produto = in.nextLine();
            }

            valorproduto += precoproduto;
            System.out.println("Valor total: R$ " + df.format(valortotal));
        }

        System.out.println("Deseja comprar mais alguma coisa? (S/sim N/não)");
        char resposta = in.next().charAt(0);
        in.nextLine();

        while (resposta != 'N' && resposta != 'S') {
            System.out.println("Apenas S/sim ou N/não, tente novamente:");
            resposta = in.next().charAt(0);
            in.nextLine();
        }

        if (resposta == 'S') {
            System.out.print("Quantos itens você gostaria de comprar a mais? (Informe em números): ");
            int Qitens = in.nextInt();

            in.nextLine();
            for (int i = 0; i < Qitens; i++) {
            	System.out.print("---------- \nProduto " + (i + 1) + ": ");
            	produto = in.nextLine();
            	if (lista.containsKey(produto)) {
            	precoproduto = lista.get(produto);
            	valorproduto += precoproduto;
                if (valorproduto >= 200) {
                    valortotal = valorproduto - Frete;
                }
                if (valorproduto >= 200) {
                    Frete = 0;
                } else {
                    Frete = valorproduto / 1.5;
                }
                valortotal = valorproduto + Frete;

                System.out.println("Total: R$ " + df.format(valortotal) + " (Valor produto: R$ " + df.format(precoproduto) + " + Valor frete: R$ " + df.format(Frete) + " + Valor pedido anterior: R$ " + df.format(valorproduto - precoproduto) + ") + ");
                
            } else {
                while (!lista.containsKey(produto)) {
                    System.out.println("Produto não encontrado:/");
                    produto = in.nextLine();
                }
            }
        }
            System.out.println("Digite F para finalizar a compra");
        char resposta2 = in.next().charAt(0);
        in.nextLine();

        while (resposta2 != 'F') {
            System.out.println("Apenas F é permitido, tente novamente:");
            resposta2 = in.next().charAt(0);
            in.nextLine();
        }
        if (resposta2 == 'F') {
            System.out.println("\n-------------------------------- \nValor total da conta: R$ " + df.format(valorproduto) + "\nEscolha o Método de pagamento (digite o numero): \n~1 Pix (10% de desconto) \n~2 Boleto (5% de desconto) \n~3 Cartão (3x sem juros)");
        }
        char resposta3 = in.next().charAt(0);
        in.nextLine();
        
        switch (resposta3) {
        case '1':
            double porcentagemReducao = 10.0;
            double valorreduzido = valorproduto - (porcentagemReducao / 100.0) * valorproduto;
            System.out.println("\n-------------------------------- \nMetodo de pagamento selecionado: Pix \nParabens! você gangou 10% off! \nvalor a pagar: R$ " + valorreduzido);
            break;
        case '2': 
        	double porcentagemReducao2 = 5.0;
            double valorreduzido2 = valorproduto - (porcentagemReducao2 / 100.0) * valorproduto;
            System.out.println("-------------------------------- \nMetodo de pagamento selecionado: Boleto \nParabens! você gangou 5% off! \nvalor a pagar: R$ " + valorreduzido2);
            break;
        }
        if (resposta3 == '3') {
        	System.out.println("-------------------------------- \nMetodo de pagamento selecionado: Cartão \nEm quantas vezes? (de 1 a 12)");
        	int resposta4 = in.nextInt();
            in.nextLine();
            switch (resposta4) {
            case 1:
            	System.out.println("Valor a pagar: R$" + valorproduto);
            	break;
            case 2:
            	System.out.println("Valor a pagar durante 2 meses: R$" + (valorproduto / 2));
            	break;
            case 3:
            	System.out.println("Valor a pagar por mes durante 3 meses: R$" + (valorproduto / 3));
            	break;
            case 4:
            	double porcentagemJuros = 2.5;
            	double parcelasemjuros = (valorproduto / 4);
                double valorgerado = parcelasemjuros + (porcentagemJuros / 100.0) * valorproduto;
                double valorparcela = valorgerado;
                System.out.println("Valor a pagar por mes durante 4: R$" + df.format(valorparcela) + "\nVALOR TOTAL A SER PAGO: R$" + df.format(valorgerado * 4));
            	break;
            case 5:
            	double porcentagemJuros2 = 2.5;
            	double parcelasemjuros2 = (valorproduto / 5);
                double valorgerado2 = parcelasemjuros2 + (porcentagemJuros2 / 100.0) * valorproduto;
                double valorparcela2 = valorgerado2;
                System.out.println("Valor a pagar por mes durante 5: R$" + df.format(valorparcela2) + "\nVALOR TOTAL A SER PAGO: R$" + df.format(valorgerado2 * 5));
            	break;
            case 6:
            	double porcentagemJuros3 = 2.5;
            	double parcelasemjuros3 = (valorproduto / 6);
                double valorgerado3 = parcelasemjuros3 + (porcentagemJuros3 / 100.0) * valorproduto;
                double valorparcela3 = valorgerado3;
                System.out.println("Valor a pagar por mes durante 6: R$" + df.format(valorparcela3) + "\nVALOR TOTAL A SER PAGO: R$" + df.format(valorgerado3 * 6));
            	break;
            case 7:
            	double porcentagemJuros4 = 2.5;
            	double parcelasemjuros4 = (valorproduto / 7);
                double valorgerado4 = parcelasemjuros4 + (porcentagemJuros4 / 100.0) * valorproduto;
                double valorparcela4 = valorgerado4;
                System.out.println("Valor a pagar por mes durante 7 meses: R$" + df.format(valorparcela4) + "\nVALOR TOTAL A SER PAGO: R$" + df.format(valorgerado4 * 7));
            	break;
            case 8:
            	double porcentagemJuros5 = 2.5;
            	double parcelasemjuros5 = (valorproduto / 8);
                double valorgerado5 = parcelasemjuros5 + (porcentagemJuros5 / 100.0) * valorproduto;
                double valorparcela5 = valorgerado5;
                System.out.println("Valor a pagar por mes durante 8 meses: R$" + df.format(valorparcela5) + "\nVALOR TOTAL A SER PAGO: R$" + df.format(valorgerado5 * 8));
            	break;
            case 9:
            	double porcentagemJuros6 = 2.5;
            	double parcelasemjuros6 = (valorproduto / 9);
                double valorgerado6 = parcelasemjuros6 + (porcentagemJuros6 / 100.0) * valorproduto;
                double valorparcela6 = valorgerado6;
                System.out.println("Valor a pagar por mes durante 9 meses: R$" + df.format(valorparcela6) + "\nVALOR TOTAL A SER PAGO: R$" + df.format(valorgerado6 * 9));
            	break;
            case 10:
            	double porcentagemJuros7 = 2.5;
            	double parcelasemjuros7 = (valorproduto / 10);
                double valorgerado7 = parcelasemjuros7 + (porcentagemJuros7 / 100.0) * valorproduto;
                double valorparcela7 = valorgerado7;
                System.out.println("Valor a pagar por mes durante 10 meses: R$" + df.format(valorparcela7) + "\nVALOR TOTAL A SER PAGO: R$" + df.format(valorgerado7 * 10));
            	break;
            case 11:
            	double porcentagemJuros8 = 2.5;
            	double parcelasemjuros8 = (valorproduto / 11);
                double valorgerado8 = parcelasemjuros8 + (porcentagemJuros8 / 100.0) * valorproduto;
                double valorparcela8 = valorgerado8;
                System.out.println("Valor a pagar por mes durante 11 meses: R$" + df.format(valorparcela8) + "\nVALOR TOTAL A SER PAGO: R$" + df.format(valorgerado8 * 11));
            	break;
            case 12:
            	double porcentagemJuros9 = 2.5;
            	double parcelasemjuros9 = (valorproduto / 12);
                double valorgerado9 = parcelasemjuros9 + (porcentagemJuros9 / 100.0) * valorproduto;
                double valorparcela9 = valorgerado9;
                System.out.println("Valor a pagar por mes durante 12 meses: R$" + df.format(valorparcela9) + "\nVALOR TOTAL A SER PAGO: R$" + df.format(valorgerado9 * 12));
            	break;
            }
        }
        
    } else {
        System.out.println("-------------------------------- \nValor total da conta: R$ " + df.format(valorproduto) + "\nEscolha o Método de pagamento (digite o numero): \n~1 Pix (10% de desconto) \n~2 Boleto (5% de desconto) \n~3 Cartão (3x sem juros)");
    }
        char resposta3 = in.next().charAt(0);
        in.nextLine();
        
        switch (resposta3) {
        case '1':
            double porcentagemReducao = 10.0;
            double valorreduzido = valorproduto - (porcentagemReducao / 100.0) * valorproduto;
            System.out.println("\n-------------------------------- \nMetodo de pagamento selecionado: Pix \nParabens! você gangou 10% off! \nvalor a pagar: R$ " + valorreduzido);
            break;
        case '2': 
        	double porcentagemReducao2 = 5.0;
            double valorreduzido2 = valorproduto - (porcentagemReducao2 / 100.0) * valorproduto;
            System.out.println("-------------------------------- \nMetodo de pagamento selecionado: Boleto \nParabens! você gangou 5% off! \nvalor a pagar: R$ " + valorreduzido2);
            break;
        }
        if (resposta3 == '3') {
        	System.out.println("-------------------------------- \nMetodo de pagamento selecionado: Cartão \nEm quantas vezes? (de 1 a 12)");
        	int resposta4 = in.nextInt();
            in.nextLine();
            switch (resposta4) {
            case 1:
            	System.out.println("Valor a pagar: R$" + valorproduto);
            	break;
            case 2:
            	System.out.println("Valor a pagar durante 2 meses: R$" + (valorproduto / 2));
            	break;
            case 3:
            	System.out.println("Valor a pagar por mes durante 3 meses: R$" + (valorproduto / 3));
            	break;
            case 4:
            	double porcentagemJuros = 2.5;
            	double parcelasemjuros = (valorproduto / 4);
                double valorgerado = parcelasemjuros + (porcentagemJuros / 100.0) * valorproduto;
                double valorparcela = valorgerado;
                System.out.println("Valor a pagar por mes durante 4: R$" + df.format(valorparcela) + "\nVALOR TOTAL A SER PAGO: R$" + df.format(valorgerado * 4));
            	break;
            case 5:
            	double porcentagemJuros2 = 2.5;
            	double parcelasemjuros2 = (valorproduto / 5);
                double valorgerado2 = parcelasemjuros2 + (porcentagemJuros2 / 100.0) * valorproduto;
                double valorparcela2 = valorgerado2;
                System.out.println("Valor a pagar por mes durante 5: R$" + df.format(valorparcela2) + "\nVALOR TOTAL A SER PAGO: R$" + df.format(valorgerado2 * 5));
            	break;
            case 6:
            	double porcentagemJuros3 = 2.5;
            	double parcelasemjuros3 = (valorproduto / 6);
                double valorgerado3 = parcelasemjuros3 + (porcentagemJuros3 / 100.0) * valorproduto;
                double valorparcela3 = valorgerado3;
                System.out.println("Valor a pagar por mes durante 6: R$" + df.format(valorparcela3) + "\nVALOR TOTAL A SER PAGO: R$" + df.format(valorgerado3 * 6));
            	break;
            case 7:
            	double porcentagemJuros4 = 2.5;
            	double parcelasemjuros4 = (valorproduto / 7);
                double valorgerado4 = parcelasemjuros4 + (porcentagemJuros4 / 100.0) * valorproduto;
                double valorparcela4 = valorgerado4;
                System.out.println("Valor a pagar por mes durante 7 meses: R$" + df.format(valorparcela4) + "\nVALOR TOTAL A SER PAGO: R$" + df.format(valorgerado4 * 7));
            	break;
            case 8:
            	double porcentagemJuros5 = 2.5;
            	double parcelasemjuros5 = (valorproduto / 8);
                double valorgerado5 = parcelasemjuros5 + (porcentagemJuros5 / 100.0) * valorproduto;
                double valorparcela5 = valorgerado5;
                System.out.println("Valor a pagar por mes durante 8 meses: R$" + df.format(valorparcela5) + "\nVALOR TOTAL A SER PAGO: R$" + df.format(valorgerado5 * 8));
            	break;
            case 9:
            	double porcentagemJuros6 = 2.5;
            	double parcelasemjuros6 = (valorproduto / 9);
                double valorgerado6 = parcelasemjuros6 + (porcentagemJuros6 / 100.0) * valorproduto;
                double valorparcela6 = valorgerado6;
                System.out.println("Valor a pagar por mes durante 9 meses: R$" + df.format(valorparcela6) + "\nVALOR TOTAL A SER PAGO: R$" + df.format(valorgerado6 * 9));
            	break;
            case 10:
            	double porcentagemJuros7 = 2.5;
            	double parcelasemjuros7 = (valorproduto / 10);
                double valorgerado7 = parcelasemjuros7 + (porcentagemJuros7 / 100.0) * valorproduto;
                double valorparcela7 = valorgerado7;
                System.out.println("Valor a pagar por mes durante 10 meses: R$" + df.format(valorparcela7) + "\nVALOR TOTAL A SER PAGO: R$" + df.format(valorgerado7 * 10));
            	break;
            case 11:
            	double porcentagemJuros8 = 2.5;
            	double parcelasemjuros8 = (valorproduto / 11);
                double valorgerado8 = parcelasemjuros8 + (porcentagemJuros8 / 100.0) * valorproduto;
                double valorparcela8 = valorgerado8;
                System.out.println("Valor a pagar por mes durante 11 meses: R$" + df.format(valorparcela8) + "\nVALOR TOTAL A SER PAGO: R$" + df.format(valorgerado8 * 11));
            	break;
            case 12:
            	double porcentagemJuros9 = 2.5;
            	double parcelasemjuros9 = (valorproduto / 12);
                double valorgerado9 = parcelasemjuros9 + (porcentagemJuros9 / 100.0) * valorproduto;
                double valorparcela9 = valorgerado9;
                System.out.println("Valor a pagar por mes durante 12 meses: R$" + df.format(valorparcela9) + "\nVALOR TOTAL A SER PAGO: R$" + df.format(valorgerado9 * 12));
            	break;
            }
        }
}
}