package main.br.unicap.luis_00000845392.p3.projeto.healthSaude.dados.listas;

import main.br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.pessoas.funcionario.abstrato.Funcionario;

import java.util.ArrayList;

public class ListaDeADM {
    private ArrayList<Funcionario> adms;

    public ListaDeADM() {
        adms = new ArrayList<>();
    }

    public ListaDeADM(ArrayList<Funcionario> adms) {
        this.adms = adms;
    }

    public ArrayList<Funcionario> getAdms() {
        return adms;
    }

    public void setAdms(ArrayList<Funcionario> adms) {
        this.adms = adms;
    }

}
