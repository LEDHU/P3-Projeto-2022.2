package main.br.unicap.luis_00000845392.p3.projeto.healthSaude.dados.listas;

import main.br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.pessoas.funcionario.abstrato.Funcionario;
import main.br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.pessoas.paciente.Paciente;

import java.util.ArrayList;

public class ListaDePaciente {
    private ArrayList<Paciente> pacientes;

    public ListaDePaciente(ArrayList<Paciente> pacientes) {
        this.pacientes  = pacientes;
    }

    public ListaDePaciente() {
        pacientes = new ArrayList<>();
    }

    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(ArrayList<Paciente> pacientes) {
        this.pacientes = pacientes;
    }
}
