package br.unicap.luis_00000845392.p3.projeto.HealthSaude.Pessoas.Funcionario.Listas;

import br.unicap.luis_00000845392.p3.projeto.HealthSaude.Pessoas.Funcionario.Abstrato.Funcionario;

import java.util.ArrayList;

public class ListaDeRecepcionista {
    private ArrayList<Funcionario> recepcionistas;

    public ListaDeRecepcionista() {
        this.recepcionistas = new ArrayList<>();
    }

    public ArrayList<Funcionario> getRecepcionistas() {
        return recepcionistas;
    }

    public void setRecepcionistas(ArrayList<Funcionario> recepcionistas) {
        this.recepcionistas = recepcionistas;
    }

    public void addFuncionario(Funcionario f){
        if (buscar(f) == null)
            recepcionistas.add(f);
    }
    public Funcionario buscar(Funcionario f){
        if(!getRecepcionistas().isEmpty()){
            int aux = 0;
            while(aux < recepcionistas.size()){
                if(f.compareTo(recepcionistas.get(aux)) == 0)
                    return f;
                aux++;
            }
        }
        return null;
    }

    public void deleteFuncionario(Funcionario f, int x){
        if(buscar(f) != null)
            recepcionistas.remove(x);
    }

    public void exibirLista() {
        if (recepcionistas.isEmpty())
            System.out.println("Lista de recepcionistas esta vazia");
        else{
            for(int i = 0; i < recepcionistas.size(); i++){
                System.out.println(i + " - Nome: '" + getRecepcionistas().get(i).getNome() + "'. CPF: '" +
                        getRecepcionistas().get(i).getCpf() + "'. Telefone: '" + getRecepcionistas().get(i).getTelefone()
                        + "'. Matricula: '" + getRecepcionistas().get(i).getMatricula() + "'");
            }
        }
    }

    public int buscarInt(Funcionario f){
        if(!getRecepcionistas().isEmpty()){
            int aux = 0;
            while(aux < recepcionistas.size()){
                if(f.compareTo(recepcionistas.get(aux)) == 0)
                    return aux;
                aux++;
            }
        }
        return -1;
    }

}
