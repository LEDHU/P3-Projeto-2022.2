package main.br.unicap.luis_00000845392.p3.projeto.healthSaude.dados.listas;

import main.br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.pessoas.funcionario.abstrato.Funcionario;

import java.util.ArrayList;

public class ListaDeFuncionario {
    ArrayList<Funcionario> funcionarios;

    public ListaDeFuncionario(ArrayList<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public ListaDeFuncionario() {
        funcionarios = new ArrayList<>();
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public void add(Funcionario f){
        funcionarios.add(f);
    }

}
