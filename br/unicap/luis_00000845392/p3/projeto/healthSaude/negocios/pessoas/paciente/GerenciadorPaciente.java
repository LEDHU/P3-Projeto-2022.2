package br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.pessoas.paciente;

import br.unicap.luis_00000845392.p3.projeto.healthSaude.dados.listas.ListaDePaciente;

import java.util.ArrayList;

public class GerenciadorPaciente {
    private ListaDePaciente pacientes;

    public GerenciadorPaciente() {
        pacientes = new ListaDePaciente();
    }

    public GerenciadorPaciente(ListaDePaciente pacientes) {
        this.pacientes = pacientes;
    }

    public ListaDePaciente getPacientes() {
        return pacientes;
    }

    public void setPacientes(ListaDePaciente pacientes) {
        this.pacientes = pacientes;
    }

    public void addPaciente(Paciente p){
        if(buscar(p) == null){
            pacientes.getPacientes().add(p);
            System.out.println("Paciente adicionado ao sistema");
        }
        else
            System.out.println("Paciente ja cadastrado no sistema");
    }

    public Paciente buscar(Paciente p){
        if(!pacientes.getPacientes().isEmpty()){
            int aux = 0;
            while(aux < pacientes.getPacientes().size()){
                if(p.compareTo(pacientes.getPacientes().get(aux)) == 0) {
                    p = new Paciente(pacientes.getPacientes().get(aux).getNome(), pacientes.getPacientes().get(aux).getCpf(), pacientes.getPacientes().get(aux).getEndereco(), pacientes.getPacientes().get(aux).getTelefone(), pacientes.getPacientes().get(aux).getNasc());
                    return p;
                }
                aux++;
            }
        }
        return null;
    }

    public void deletePaciente(Paciente p, int x){
        if(buscar(p) != null){
            pacientes.getPacientes().remove(x);
            System.out.println("Paciente removido do sistema");
        }
        else
            System.out.println("Paciente nao encontrado no sistema");
    }
    public void exibirLista(){
        if(pacientes.getPacientes().isEmpty())
            System.out.println("Lista de paciente vazia");
        else {
            for(int i = 0; i < pacientes.getPacientes().size(); i++){
                System.out.println(i + " - Nome: '" + pacientes.getPacientes().get(i).getNome() + "'. CPF: '" +
                        pacientes.getPacientes().get(i).getCpf() + "'. Telefone: '" + pacientes.getPacientes().get(i).getTelefone()
                        + "'. Endereço: '" + pacientes.getPacientes().get(i).getEndereco() + "'. Data de nascimento: '"
                        + pacientes.getPacientes().get(i).getNasc() + "'");
            }
        }
    }
    public int buscarInt(Paciente p){
        if(!pacientes.getPacientes().isEmpty()){
            int aux = 0;
            while(aux < pacientes.getPacientes().size()){
                if(p.compareTo(pacientes.getPacientes().get(aux)) == 0)
                    return aux;
                aux++;
            }
        }
        return -1;
    }
}
