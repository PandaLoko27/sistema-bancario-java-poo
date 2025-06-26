public class Investimento {
    private double valorInvestido;
    private double rendimentoMensal; // ex: 0.01 para 1%

    public Investimento(double valorInvestido, double rendimentoMensal) {
        this.valorInvestido = valorInvestido;
        this.rendimentoMensal = rendimentoMensal;
    }

    public double simularLucro(int meses) {
        return valorInvestido * Math.pow(1 + rendimentoMensal, meses) - valorInvestido;
    }
}
