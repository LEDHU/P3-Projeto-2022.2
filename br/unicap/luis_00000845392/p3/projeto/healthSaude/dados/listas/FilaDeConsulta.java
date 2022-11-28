package br.unicap.luis_00000845392.p3.projeto.healthSaude.dados.listas;

import br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.pessoas.paciente.Paciente;

import java.util.ArrayDeque;

public class FilaDeConsulta {
    private ArrayDeque<Paciente> filaConsulta;

    public FilaDeConsulta(ArrayDeque<Paciente> filaConsulta) {
        this.filaConsulta = filaConsulta;
    }

    public FilaDeConsulta() {
        filaConsulta = new ArrayDeque<>();
    }

    public ArrayDeque<Paciente> getFilaConsulta() {
        return filaConsulta;
    }

    public void setFilaConsulta(ArrayDeque<Paciente> filaConsulta) {
        this.filaConsulta = filaConsulta;
    }
}
