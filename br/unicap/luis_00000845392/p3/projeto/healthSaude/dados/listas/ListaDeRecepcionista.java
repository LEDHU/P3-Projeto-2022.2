package br.unicap.luis_00000845392.p3.projeto.healthSaude.dados.listas;

import br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.pessoas.funcionario.abstrato.Funcionario;

import java.util.ArrayList;

public class ListaDeRecepcionista {
    private ArrayList<Funcionario> recepcionistas;

    public ListaDeRecepcionista() {
        this.recepcionistas  = new ArrayList<>();;
    }

    public ArrayList<Funcionario> getRecepcionistas() {
        return recepcionistas;
    }

    public void setRecepcionistas(ArrayList<Funcionario> recepcionistas) {
        this.recepcionistas = recepcionistas;
    }

}
