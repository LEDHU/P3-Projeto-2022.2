package br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.pessoas.funcionario.tipos;

import br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.pessoas.funcionario.abstrato.Funcionario;
import br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.pessoas.funcionario.salario.ISalario;

public class Medico extends Funcionario implements ISalario {

    private static Medico instance;

    private Medico(String matricula) {
        super(matricula);
    }

    private Medico(String nome, String cpf, String telefone, String matricula) {
        super(nome, cpf, telefone, matricula);
    }

    public static Medico getInstance(String matricula){
        if(instance == null){
            instance = new Medico(matricula);
        }
        return instance;
    }

    public static Medico getInstance(String nome, String cpf, String telefone, String matricula){
        if(instance == null){
            instance = new Medico(nome, cpf, telefone, matricula);
        }
        return instance;
    }

    @Override
    public double calcularSalario(double extra) {
        return extra * 100 + 5000;
    }


}
