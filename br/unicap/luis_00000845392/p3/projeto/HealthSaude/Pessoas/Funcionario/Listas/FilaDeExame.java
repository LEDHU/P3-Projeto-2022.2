package br.unicap.luis_00000845392.p3.projeto.HealthSaude.Pessoas.Funcionario.Listas;

import br.unicap.luis_00000845392.p3.projeto.HealthSaude.Pessoas.Funcionario.Tipos.Exame;

import java.util.ArrayDeque;

public class FilaDeExame {
    private ArrayDeque<Exame> listaDeExames;

    public FilaDeExame() {
        this.listaDeExames = new ArrayDeque<>();
    }

    public ArrayDeque<Exame> getListaDeExames() {
        return listaDeExames;
    }

    public void setListaDeExames(ArrayDeque<Exame> listaDeExames) {
        this.listaDeExames = listaDeExames;
    }

    public void addExame(Exame e){
        listaDeExames.add(e);
    }

    public void deleteExame(){
        listaDeExames.removeFirst();
    }



}
