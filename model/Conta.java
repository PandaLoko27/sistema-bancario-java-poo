import java.util.ArrayList;
import java.util.List;

public abstract class Conta {
    protected double saldo;
    protected Cliente cliente;
    protected String numeroConta;
    protected List<String> historico = new ArrayList<>();

    public Conta(Cliente cliente, String numeroConta) {
        this.cliente = cliente;
        this.numeroConta = numeroConta;
        this.saldo = 0;
    }

    public abstract void sacar(double valor);

    public void depositar(double valor) {
        saldo += valor;
        historico.add("Depósito: R$" + valor);
    }

    public void transferir(Conta destino, double valor) {
        if (valor <= saldo) {
            this.sacar(valor);
            destino.depositar(valor);
            historico.add("Transferência PIX para " + destino.getNumeroConta() + ": R$" + valor);
        } else {
            historico.add("Falha na transferência PIX para " + destino.getNumeroConta() + ": saldo insuficiente");
            System.out.println("Saldo insuficiente para transferência!");
        }
    }

    public String getNumeroConta() { return numeroConta; }
    public double getSaldo() { return saldo; }

    public void exibirHistorico() {
        System.out.println("Histórico da conta " + numeroConta + ":");
        for (String linha : historico) {
            System.out.println(linha);
        }
    }
}
