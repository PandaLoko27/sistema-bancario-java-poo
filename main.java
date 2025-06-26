public class Main {
    public static void main(String[] args) {
        SistemaBancario sistema = new SistemaBancario();

        sistema.criarConta("Otávio", "12345678900", "001");
        sistema.criarConta("Pedro", "98765432100", "002");

        Conta conta1 = sistema.buscarConta("001");
        Conta conta2 = sistema.buscarConta("002");

        conta1.depositar(1000);
        conta1.sacar(200);
        sistema.realizarPIX("001", "002", 300);
        sistema.investir("001", 200, 0.02, 3);

        conta1.exibirHistorico();
        conta2.exibirHistorico();
    }
}
