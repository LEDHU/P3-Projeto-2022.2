package br.unicap.luis_00000845392.p3.projeto.HealthSaude.Pessoas.Paciente;

import java.util.ArrayList;

public class ListaDePaciente {
    private ArrayList<Paciente> pacientes;

    public ListaDePaciente() {
        this.pacientes = new ArrayList<>();
    }

    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(ArrayList<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public void addPaciente(Paciente p){
        if(buscar(p) == null){
            pacientes.add(p);
            System.out.println("Paciente adicionado ao sistema");
        }
        else
            System.out.println("Paciente ja cadastrado no sistema");
    }

    public Paciente buscar(Paciente p){
        if(!getPacientes().isEmpty()){
            int aux = 0;
            while(aux < pacientes.size()){
                if(p.compareTo(pacientes.get(aux)) == 0) {
                    p = new Paciente(pacientes.get(aux).getNome(), pacientes.get(aux).getCpf(), pacientes.get(aux).getEndereco(), pacientes.get(aux).getTelefone(), pacientes.get(aux).getNasc());
                    return p;
                }
                aux++;
            }
        }
        return null;
    }

    public void deletePaciente(Paciente p, int x){
        if(buscar(p) != null){
            pacientes.remove(x);
            System.out.println("Paciente removido do sistema");
        }
        else
            System.out.println("Paciente nao encontrado no sistema");
    }
    public void exibirLista(){
        if(pacientes.isEmpty())
            System.out.println("Lista de paciente vazia");
        else {
            for(int i = 0; i < pacientes.size(); i++){
                System.out.println(i + " - Nome: '" + getPacientes().get(i).getNome() + "'. CPF: '" +
                        getPacientes().get(i).getCpf() + "'. Telefone: '" + getPacientes().get(i).getTelefone()
                        + "'. Endereço: '" + getPacientes().get(i).getEndereco() + "'. Data de nascimento: '"
                        + getPacientes().get(i).getNasc() + "'");
            }
        }
    }
    public int buscarInt(Paciente p){
        if(!getPacientes().isEmpty()){
            int aux = 0;
            while(aux < pacientes.size()){
                if(p.compareTo(pacientes.get(aux)) == 0)
                    return aux;
                aux++;
            }
        }
        return -1;
    }
}
