package br.unicap.luis_00000845392.p3.projeto.HealthSaude.Funcionario.Salario;

public class ISMedico implements ISalario{
    @Override
    public double calcularSalario(double extra) {
        return 5000 + 100*extra;
    }

}
