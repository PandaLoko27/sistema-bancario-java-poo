public class ContaCorrente extends Conta {
    public ContaCorrente(Cliente cliente, String numeroConta) {
        super(cliente, numeroConta);
    }

    @Override
    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            historico.add("Saque: R$" + valor);
        } else {
            System.out.println("Saldo insuficiente!");
            historico.add("Falha no saque: saldo insuficiente");
        }
    }
}
