package main.br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.pessoas.funcionario.tipos;

import main.br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.pessoas.funcionario.abstrato.Funcionario;
import main.br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.pessoas.funcionario.salario.ISalario;

public class ADM extends Funcionario implements ISalario {

    public ADM (String matricula){
        super(matricula);
    }

    public ADM(String nome, String cpf, String telefone, String matricula) {
        super(nome, cpf, telefone, matricula);
    }

    @Override
    public double calcularSalario(double extra) {
        return extra * 100 + 4000;
    }
}
