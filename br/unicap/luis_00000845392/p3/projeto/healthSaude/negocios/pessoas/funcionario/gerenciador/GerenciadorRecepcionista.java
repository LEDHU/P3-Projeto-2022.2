package br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.pessoas.funcionario.gerenciador;

import br.unicap.luis_00000845392.p3.projeto.healthSaude.dados.listas.ListaDeRecepcionista;
import br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.pessoas.funcionario.abstrato.Funcionario;

import java.util.ArrayList;

public class GerenciadorRecepcionista {
    private ListaDeRecepcionista recepcionistas;

    public GerenciadorRecepcionista() {

    }

    public GerenciadorRecepcionista(ListaDeRecepcionista recepcionistas) {
        this.recepcionistas = recepcionistas;
    }

    public ListaDeRecepcionista getRecepcionistas() {
        return recepcionistas;
    }

    public void setRecepcionistas(ListaDeRecepcionista recepcionistas) {
        this.recepcionistas = recepcionistas;
    }

    public void addFuncionario(Funcionario f){
        if (buscar(f) == null)
            recepcionistas.getRecepcionistas().add(f);
    }
    public Funcionario buscar(Funcionario f){
        if(!recepcionistas.getRecepcionistas().isEmpty()){
            int aux = 0;
            while(aux < recepcionistas.getRecepcionistas().size()){
                if(f.compareTo(recepcionistas.getRecepcionistas().get(aux)) == 0)
                    return f;
                aux++;
            }
        }
        return null;
    }

    public void deleteFuncionario(Funcionario f, int x){
        if(buscar(f) != null)
            recepcionistas.getRecepcionistas().remove(x);
    }

    public void exibirLista() {
        if (recepcionistas.getRecepcionistas().isEmpty())
            System.out.println("Lista de recepcionistas esta vazia");
        else{
            for(int i = 0; i < recepcionistas.getRecepcionistas().size(); i++){
                System.out.println(i + " - Nome: '" + getRecepcionistas().getRecepcionistas().get(i).getNome() + "'. CPF: '" +
                        getRecepcionistas().getRecepcionistas().get(i).getCpf() + "'. Telefone: '" + getRecepcionistas().getRecepcionistas().get(i).getTelefone()
                        + "'. Matricula: '" + getRecepcionistas().getRecepcionistas().get(i).getMatricula() + "'");
            }
        }
    }

    public int buscarInt(Funcionario f){
        if(!recepcionistas.getRecepcionistas().isEmpty()){
            int aux = 0;
            while(aux < recepcionistas.getRecepcionistas().size()){
                if(f.compareTo(recepcionistas.getRecepcionistas().get(aux)) == 0)
                    return aux;
                aux++;
            }
        }
        return -1;
    }

}
