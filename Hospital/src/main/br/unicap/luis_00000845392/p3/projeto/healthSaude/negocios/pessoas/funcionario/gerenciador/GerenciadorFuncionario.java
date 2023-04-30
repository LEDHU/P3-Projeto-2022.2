package main.br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.pessoas.funcionario.gerenciador;

import main.br.unicap.luis_00000845392.p3.projeto.healthSaude.dados.listas.ListaDeFuncionario;
import main.br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.pessoas.funcionario.abstrato.Funcionario;

import java.util.Objects;

public class GerenciadorFuncionario {
    private ListaDeFuncionario funcionarios;

    public GerenciadorFuncionario(ListaDeFuncionario funcionarios) {
        this.funcionarios = funcionarios;
    }

    public GerenciadorFuncionario() {
        funcionarios = new ListaDeFuncionario();
    }

    public ListaDeFuncionario getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(ListaDeFuncionario funcionarios) {
        this.funcionarios = funcionarios;
    }

    public void addFuncionario(Funcionario f){
        //if (buscar(f) == null) {
            funcionarios.add(f);
            System.out.println("Funcionario adicionado ao sistema");
        //} else
            //System.out.println("Funcionario ja cadastrado no sistema");

    }
    public Funcionario buscar(Funcionario f){
        if(!funcionarios.getFuncionarios().isEmpty()){
            int aux = 0;
            while(aux < funcionarios.getFuncionarios().size()){
                if(f.compareTo(funcionarios.getFuncionarios().get(aux)) == 0)
                    return f;
                aux++;
            }
        }
        return null;
    }

    public void deleteFuncionario(Funcionario f, int x){

        if(!Objects.equals(f.getMatricula(), "M000")) {
            if (buscar(f) != null) {
                funcionarios.getFuncionarios().remove(x);
                System.out.println("Funcionario removido do sistema");
            } else
                System.out.println("Funcionario nao encontrado no sistema");
        }
        else
            System.out.println("Funcionario principal, não pode ser deletado");
    }

    public void exibirLista(){
        if(funcionarios.getFuncionarios().isEmpty())
            System.out.println("Lista de funcionarios esta vazia");
        else {
            for(int i = 0; i < funcionarios.getFuncionarios().size(); i++){
                System.out.println(i + " - Nome: '" + funcionarios.getFuncionarios().get(i).getNome() + "'. CPF: '" +
                        funcionarios.getFuncionarios().get(i).getCpf() + "'. Telefone: '" + funcionarios.getFuncionarios().get(i).getTelefone()
                        + "'. Matricula: '" + funcionarios.getFuncionarios().get(i).getMatricula() + "'. Salario: " + funcionarios.getFuncionarios().get(i).getSalario() + "'");
            }
        }
    }

    public int buscarInt(Funcionario f){
        if(!funcionarios.getFuncionarios().isEmpty()){
            int aux = 0;
            while(aux < funcionarios.getFuncionarios().size()){
                if(f.compareTo(funcionarios.getFuncionarios().get(aux)) == 0)
                    return aux;
                aux++;
            }
        }
        return -1;
    }

    public void exibirFuncionario(String matri){
        if(!funcionarios.getFuncionarios().isEmpty()){
            int x = funcionarios.getFuncionarios().size();
            int aux = 0;
            while(aux < x){
                if(matri.compareTo(funcionarios.getFuncionarios().get(aux).getMatricula()) == 0){
                    System.out.println("Nome: '" + funcionarios.getFuncionarios().get(aux).getNome() + "'. CPF: '" +
                            funcionarios.getFuncionarios().get(aux).getCpf() + "'. Telefone: '" + funcionarios.getFuncionarios().get(aux).getTelefone()
                            + "'. Matricula: '" + funcionarios.getFuncionarios().get(aux).getMatricula() + "'. Salario: " +
                            funcionarios.getFuncionarios().get(aux).getSalario() + "'");
                    return;
                }
                aux++;
            }
            System.out.println("Funcionario não encontrado");
        }
    }
}
