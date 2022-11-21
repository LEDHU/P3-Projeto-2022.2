package br.unicap.luis_00000845392.p3.projeto.healthSaude.dados.listas;

import br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.pessoas.funcionario.abstrato.Funcionario;

import java.util.ArrayList;

public class ListaDeMedico {
    private ArrayList<Funcionario> medicos;

    public ListaDeMedico(ArrayList<Funcionario> medicos) {
        this.medicos = medicos;
    }

    public ArrayList<Funcionario> getMedicos() {
        return medicos;
    }

    public void setMedicos(ArrayList<Funcionario> medicos) {
        this.medicos = medicos;
    }
}
