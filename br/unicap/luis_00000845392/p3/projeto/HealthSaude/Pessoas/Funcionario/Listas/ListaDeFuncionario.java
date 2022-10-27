package br.unicap.luis_00000845392.p3.projeto.HealthSaude.Pessoas.Funcionario.Listas;

import br.unicap.luis_00000845392.p3.projeto.HealthSaude.Pessoas.Funcionario.Abstrato.Funcionario;

import java.util.ArrayList;
import java.util.Objects;

public class ListaDeFuncionario {
    private ArrayList<Funcionario> funcionarios;

    public ListaDeFuncionario() {
        this.funcionarios = new ArrayList<>();
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public void addFuncionario(Funcionario f){
        if (buscar(f) == null) {
            funcionarios.add(f);
            System.out.println("Funcionario adicionado ao sistema");
        } else
            System.out.println("Funcionario ja cadastrado no sistema");

    }
    public Funcionario buscar(Funcionario f){
        if(!getFuncionarios().isEmpty()){
            int aux = 0;
            while(aux < funcionarios.size()){
                if(f.compareTo(funcionarios.get(aux)) == 0)
                    return f;
                aux++;
            }
        }
        return null;
    }

    public void deleteFuncionario(Funcionario f, int x){

        if(!Objects.equals(f.getMatricula(), "M000")) {
            if (buscar(f) != null) {
                funcionarios.remove(x);
                System.out.println("Funcionario removido do sistema");
            } else
                System.out.println("Funcionario nao encontrado no sistema");
        }
        else
            System.out.println("Funcionario principal, não pode ser deletado");
    }

    public void exibirLista(){
        if(funcionarios.isEmpty())
            System.out.println("Lista de funcionarios esta vazia");
        else {
            for(int i = 0; i < funcionarios.size(); i++){
                System.out.println(i + " - Nome: '" + getFuncionarios().get(i).getNome() + "'. CPF: '" +
                        getFuncionarios().get(i).getCpf() + "'. Telefone: '" + getFuncionarios().get(i).getTelefone()
                        + "'. Matricula: '" + getFuncionarios().get(i).getMatricula() + "'. Salario: " + getFuncionarios().get(i).getSalario() + "'");
            }
        }
    }

    public int buscarInt(Funcionario f){
        if(!getFuncionarios().isEmpty()){
            int aux = 0;
            while(aux < funcionarios.size()){
                if(f.compareTo(funcionarios.get(aux)) == 0)
                    return aux;
                aux++;
            }
        }
        return -1;
    }

    public void exibirFuncionario(String matri){
        if(!funcionarios.isEmpty()){
            int x = funcionarios.size();
            int aux = 0;
            while(aux < x){
                if(matri.compareTo(funcionarios.get(aux).getMatricula()) == 0){
                    System.out.println("Nome: '" + getFuncionarios().get(aux).getNome() + "'. CPF: '" +
                            getFuncionarios().get(aux).getCpf() + "'. Telefone: '" + getFuncionarios().get(aux).getTelefone()
                            + "'. Matricula: '" + getFuncionarios().get(aux).getMatricula() + "'. Salario: " +
                            getFuncionarios().get(aux).getSalario() + "'");
                    return;
                }
                aux++;
            }
            System.out.println("Funcionario não encontrado");
        }
    }
}
