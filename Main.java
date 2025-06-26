import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SistemaBancario sistema = new SistemaBancario();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Bem-vindo ao Sistema Bancário ===");

        boolean rodando = true;
        while (rodando) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Criar conta");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Transferência PIX");
            System.out.println("5 - Investir");
            System.out.println("6 - Mostrar histórico");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            int opcao;
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Tente novamente.");
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.print("Nome do cliente: ");
                    String nome = scanner.nextLine();
                    System.out.print("CPF do cliente: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Número da conta: ");
                    String numeroConta = scanner.nextLine();

                    sistema.criarConta(nome, cpf, numeroConta);
                    System.out.println("Conta criada com sucesso!");
                    break;

                case 2:
                    System.out.print("Número da conta para depósito: ");
                    String contaDeposito = scanner.nextLine();
                    Conta contaDep = sistema.buscarConta(contaDeposito);
                    if (contaDep != null) {
                        System.out.print("Valor para depositar: ");
                        try {
                            double valorDep = Double.parseDouble(scanner.nextLine());
                            contaDep.depositar(valorDep);
                            System.out.println("Depósito realizado com sucesso!");
                        } catch (NumberFormatException e) {
                            System.out.println("Valor inválido.");
                        }
                    } else {
                        System.out.println("Conta não encontrada!");
                    }
                    break;

                case 3:
                    System.out.print("Número da conta para saque: ");
                    String contaSaque = scanner.nextLine();
                    Conta contaSaq = sistema.buscarConta(contaSaque);
                    if (contaSaq != null) {
                        System.out.print("Valor para sacar: ");
                        try {
                            double valorSaq = Double.parseDouble(scanner.nextLine());
                            contaSaq.sacar(valorSaq);
                        } catch (NumberFormatException e) {
                            System.out.println("Valor inválido.");
                        }
                    } else {
                        System.out.println("Conta não encontrada!");
                    }
                    break;

                case 4:
                    System.out.print("Número da conta origem: ");
                    String contaOrigem = scanner.nextLine();
                    System.out.print("Número da conta destino: ");
                    String contaDestino = scanner.nextLine();
                    System.out.print("Valor para transferir: ");
                    try {
                        double valorPix = Double.parseDouble(scanner.nextLine());
                        sistema.realizarPIX(contaOrigem, contaDestino, valorPix);
                        System.out.println("Transferência realizada (se saldo suficiente e contas válidas).");
                    } catch (NumberFormatException e) {
                        System.out.println("Valor inválido.");
                    }
                    break;

                case 5:
                    System.out.print("Número da conta para investimento: ");
                    String contaInv = scanner.nextLine();
                    Conta contaInvest = sistema.buscarConta(contaInv);
                    if (contaInvest != null) {
                        System.out.print("Valor para investir: ");
                        try {
                            double valorInvest = Double.parseDouble(scanner.nextLine());
                            System.out.print("Rendimento mensal (ex: 0.02 para 2%): ");
                            double rendimento = Double.parseDouble(scanner.nextLine());
                            System.out.print("Meses para simular: ");
                            int meses = Integer.parseInt(scanner.nextLine());

                            sistema.investir(contaInv, valorInvest, rendimento, meses);
                            System.out.println("Investimento realizado e lucro aplicado.");
                        } catch (NumberFormatException e) {
                            System.out.println("Valor ou meses inválidos.");
                        }
                    } else {
                        System.out.println("Conta não encontrada!");
                    }
                    break;

                case 6:
                    System.out.print("Número da conta para mostrar histórico: ");
                    String contaHist = scanner.nextLine();
                    Conta contaHistEx = sistema.buscarConta(contaHist);
                    if (contaHistEx != null) {
                        contaHistEx.exibirHistorico();
                    } else {
                        System.out.println("Conta não encontrada!");
                    }
                    break;

                case 0:
                    rodando = false;
                    System.out.println("Obrigado por usar o sistema. Até mais!");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }

        scanner.close();
    }
}
