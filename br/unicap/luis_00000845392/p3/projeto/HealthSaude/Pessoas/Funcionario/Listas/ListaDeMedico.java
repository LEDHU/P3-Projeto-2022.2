package br.unicap.luis_00000845392.p3.projeto.HealthSaude.Pessoas.Funcionario.Listas;

import br.unicap.luis_00000845392.p3.projeto.HealthSaude.Pessoas.Funcionario.Abstrato.Funcionario;

import java.util.ArrayList;

public class ListaDeMedico {
    private ArrayList<Funcionario> medicos;

    public ListaDeMedico() {
        this.medicos = new ArrayList<>();
    }

    public ArrayList<Funcionario> getMedicos() {
        return medicos;
    }

    public void setMedicos(ArrayList<Funcionario> medicos) {
        this.medicos = medicos;
    }

    public void addFuncionario(Funcionario f){
        if (buscar(f) == null)
            medicos.add(f);

    }
    public Funcionario buscar(Funcionario f){
        if(!getMedicos().isEmpty()){
            int aux = 0;
            while(aux < medicos.size()){
                if(f.compareTo(medicos.get(aux)) == 0)
                    return f;
                aux++;
            }
        }
        return null;
    }

    public void deleteFuncionario(Funcionario f, int x){
        if(buscar(f) != null)
            medicos.remove(x);
    }
    public void exibirLista(){
        if(medicos.isEmpty())
            System.out.println("Lista de medicos esta vazia");
        else {
            for(int i = 0; i < medicos.size(); i++){
                System.out.println(i + " - Nome: '" + getMedicos().get(i).getNome() + "'. CPF: '" +
                        getMedicos().get(i).getCpf() + "'. Telefone: '" + getMedicos().get(i).getTelefone()
                        + "'. Matricula: '" + getMedicos().get(i).getMatricula() + "'");
            }
        }
    }

    public int buscarInt(Funcionario f){
        if(!getMedicos().isEmpty()){
            int aux = 0;
            while(aux < medicos.size()){
                if(f.compareTo(medicos.get(aux)) == 0)
                    return aux;
                aux++;
            }
        }
        return -1;
    }

}
