package br.unicap.luis_00000845392.p3.projeto.HealthSaude.Funcionario.Tipos;

import br.unicap.luis_00000845392.p3.projeto.HealthSaude.Funcionario.Funcionario;
import br.unicap.luis_00000845392.p3.projeto.HealthSaude.Funcionario.Salario.ISalario;

public class ADM extends Funcionario implements ISalario {

    public ADM (String matricula){
        super(matricula);
    }

    public ADM(String nome, String cpf, String telefone, String matricula) {
        super(nome, cpf, telefone, matricula);
    }

    @Override
    public double calcularSalario(double extra) {
        return 0;
    }
}
