package br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.pessoas.funcionario.tipos;

import br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.pessoas.funcionario.abstrato.Funcionario;
import br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.pessoas.funcionario.salario.ISalario;

public class Recepcionista extends Funcionario implements ISalario {

    public Recepcionista(String matricula) {
        super(matricula);
    }

    public Recepcionista(String nome, String cpf, String telefone, String matricula) {
        super(nome, cpf, telefone, matricula);
    }

    @Override
    public double calcularSalario(double extra) {
        return extra * 100 + 3000 ;
    }
}
