package br.unicap.luis_00000845392.p3.projeto.healthSaude.dados.listas;

import br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.pessoas.funcionario.abstrato.Funcionario;

import java.util.ArrayList;

public class ListaDeADM {
    private ArrayList<Funcionario> adms;

    public ListaDeADM() {
        this.adms = new ArrayList<>();
    }

    public ArrayList<Funcionario> getAdms() {
        return adms;
    }

    public void setAdms(ArrayList<Funcionario> adms) {
        this.adms = adms;
    }

}
