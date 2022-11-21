package br.unicap.luis_00000845392.p3.projeto.healthSaude.dados.listas;

import br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.pessoas.funcionario.abstrato.Funcionario;

import java.util.ArrayList;

public class ListaDeFuncionario {
    ArrayList<Funcionario> funcionarios;

    public ListaDeFuncionario() {
        this.funcionarios = new ArrayList<>();
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

}
