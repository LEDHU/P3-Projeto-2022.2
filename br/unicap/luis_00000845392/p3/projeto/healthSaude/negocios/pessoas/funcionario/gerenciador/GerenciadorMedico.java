package br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.pessoas.funcionario.gerenciador;

import br.unicap.luis_00000845392.p3.projeto.healthSaude.dados.listas.ListaDeMedico;
import br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.pessoas.funcionario.abstrato.Funcionario;

import java.util.ArrayList;

public class GerenciadorMedico {
    private ListaDeMedico medicos;

    public GerenciadorMedico() {
        medicos = new ListaDeMedico();
    }

    public GerenciadorMedico(ListaDeMedico medicos) {
        this.medicos = medicos;
    }

    public ListaDeMedico getMedicos() {
        return medicos;
    }

    public void setMedicos(ListaDeMedico medicos) {
        this.medicos = medicos;
    }

    public void addFuncionario(Funcionario f){
        if (buscar(f) == null)
            medicos.getMedicos().add(f);

    }
    public Funcionario buscar(Funcionario f){
        if(!medicos.getMedicos().isEmpty()){
            int aux = 0;
            while(aux < medicos.getMedicos().size()){
                if(f.compareTo(medicos.getMedicos().get(aux)) == 0)
                    return f;
                aux++;
            }
        }
        return null;
    }

    public void deleteFuncionario(Funcionario f, int x){
        if(buscar(f) != null)
            medicos.getMedicos().remove(x);
    }
    public void exibirLista(){
        if(medicos.getMedicos().isEmpty())
            System.out.println("Lista de medicos esta vazia");
        else {
            for(int i = 0; i < medicos.getMedicos().size(); i++){
                System.out.println(i + " - Nome: '" + medicos.getMedicos().get(i).getNome() + "'. CPF: '" +
                        medicos.getMedicos().get(i).getCpf() + "'. Telefone: '" + medicos.getMedicos().get(i).getTelefone()
                        + "'. Matricula: '" + medicos.getMedicos().get(i).getMatricula() + "'");
            }
        }
    }

    public int buscarInt(Funcionario f){
        if(!medicos.getMedicos().isEmpty()){
            int aux = 0;
            while(aux < medicos.getMedicos().size()){
                if(f.compareTo(medicos.getMedicos().get(aux)) == 0)
                    return aux;
                aux++;
            }
        }
        return -1;
    }

}
