package br.unicap.luis_00000845392.p3.projeto.HealthSaude.Funcionario.Tipos;

import br.unicap.luis_00000845392.p3.projeto.HealthSaude.Funcionario.Funcionario;

public class Medico extends Funcionario {

    public Medico(String matricula) {
        super(matricula);
    }

    public Medico(String nome, String cpf, String telefone, String matricula) {
        super(nome, cpf, telefone, matricula);
    }
}
