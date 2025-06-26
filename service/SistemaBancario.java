import java.util.HashMap;
import java.util.Map;

public class SistemaBancario {
    private Map<String, Conta> contas = new HashMap<>();

    public void criarConta(String nome, String cpf, String numeroConta) {
        Cliente cliente = new Cliente(nome, cpf);
        Conta conta = new ContaCorrente(cliente, numeroConta);
        contas.put(numeroConta, conta);
    }

    public Conta buscarConta(String numero) {
        return contas.get(numero);
    }

    public void realizarPIX(String origem, String destino, double valor) {
        Conta contaOrigem = buscarConta(origem);
        Conta contaDestino = buscarConta(destino);
        if (contaOrigem != null && contaDestino != null) {
            contaOrigem.transferir(contaDestino, valor);
        }
    }

    public void investir(String numeroConta, double valor, double rendimento, int meses) {
        Conta conta = buscarConta(numeroConta);
        if (conta != null && conta.getSaldo() >= valor) {
            conta.sacar(valor);
            Investimento investimento = new Investimento(valor, rendimento);
            double lucro = investimento.simularLucro(meses);
            conta.depositar(valor + lucro);
            conta.historico.add("Investimento: lucro de R$" + lucro);
        }
    }
}
