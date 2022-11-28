package br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.pessoas.funcionario.gerenciador;

import br.unicap.luis_00000845392.p3.projeto.healthSaude.dados.listas.FilaDeConsulta;
import br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.pessoas.paciente.Paciente;

import java.util.ArrayDeque;

public class GerenciadorConsulta {
    private FilaDeConsulta filaDeConsultas;

    public GerenciadorConsulta(FilaDeConsulta filaDeConsultas) {
        this.filaDeConsultas = filaDeConsultas;
    }

    public GerenciadorConsulta() {
        filaDeConsultas = new FilaDeConsulta();
    }

    public FilaDeConsulta getFilaDeConsultas() {
        return filaDeConsultas;
    }

    public void setFilaDeConsultas(FilaDeConsulta filaDeConsultas) {
        this.filaDeConsultas = filaDeConsultas;
    }

    public void addConsulta(Paciente p){
        filaDeConsultas.getFilaConsulta().add(p);
    }

    public void deleteConsulta(){
        filaDeConsultas.getFilaConsulta().removeFirst();
    }

}
