package br.unicap.luis_00000845392.p3.projeto.HealthSaude.Funcionario.Listas;

import br.unicap.luis_00000845392.p3.projeto.HealthSaude.Paciente.Paciente;

import java.util.ArrayDeque;

public class ListaDeExame {
    private ArrayDeque<Paciente> listaDeExames;

    public ListaDeExame() {
        this.listaDeExames = new ArrayDeque<>();
    }

    public ArrayDeque<Paciente> getListaDeExames() {
        return listaDeExames;
    }

    public void setListaDeExames(ArrayDeque<Paciente> listaDeExames) {
        this.listaDeExames = listaDeExames;
    }

    public void addExame(Paciente p){
        listaDeExames.add(p);
    }

    public void deleteExame(){
        listaDeExames.removeFirst();
    }



}
