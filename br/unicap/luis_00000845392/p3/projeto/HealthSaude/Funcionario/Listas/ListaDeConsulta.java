package br.unicap.luis_00000845392.p3.projeto.HealthSaude.Funcionario.Listas;

import br.unicap.luis_00000845392.p3.projeto.HealthSaude.Paciente.Paciente;

import java.util.ArrayDeque;

public class ListaDeConsulta {
    private ArrayDeque<Paciente> listaDeConsultas;

    public ListaDeConsulta(){
        this.listaDeConsultas = new ArrayDeque<>();
    }

    public ArrayDeque<Paciente> getListaDeConsultas() {
        return listaDeConsultas;
    }

    public void setListaDeConsultas(ArrayDeque<Paciente> listaDeConsultas) {
        this.listaDeConsultas = listaDeConsultas;
    }

    public void addConsulta(Paciente p){
        listaDeConsultas.add(p);
    }

    public void deleteConsulta(){
        listaDeConsultas.removeFirst();
    }

}
