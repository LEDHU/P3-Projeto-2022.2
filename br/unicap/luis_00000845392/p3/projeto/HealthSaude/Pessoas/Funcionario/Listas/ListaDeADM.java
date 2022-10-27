package br.unicap.luis_00000845392.p3.projeto.HealthSaude.Pessoas.Funcionario.Listas;

import br.unicap.luis_00000845392.p3.projeto.HealthSaude.Pessoas.Funcionario.Abstrato.Funcionario;

import java.util.ArrayList;
import java.util.Objects;

public class ListaDeADM {
    private ArrayList<Funcionario> adms;
    public ListaDeADM() {
        this.adms = new ArrayList<>();
    }

    public ArrayList<Funcionario> getAdms() {
        return adms;
    }

    public void setAdms(ArrayList<Funcionario> adms) {
        this.adms = adms;
    }

    public void addFuncionario(Funcionario f){
        if (buscar(f) == null) {
            adms.add(f);

        }
    }
    public Funcionario buscar(Funcionario f){
        if(!getAdms().isEmpty()){
            int aux = 0;
            while(aux < adms.size()){
                if(f.compareTo(adms.get(aux)) == 0)
                    return f;
                aux++;
            }
        }
        return null;
    }

    public int buscarInt(Funcionario f){
        if(!getAdms().isEmpty()){
            int aux = 0;
            while(aux < adms.size()){
                if(f.compareTo(adms.get(aux)) == 0)
                    return aux;
                aux++;
            }
        }
        return -1;
    }

    public void deleteFuncionario(Funcionario f, int i){
        if(!Objects.equals(f.getMatricula(), "M000")) {
            if (buscar(f) != null)
                adms.remove(i);
        }
    }

    public void exibirLista(){
        if(adms.isEmpty())
            System.out.println("Lista de administração vazia");
        else {
            for(int i = 0; i < adms.size(); i++){
                System.out.println(i + " - Nome: '" + getAdms().get(i).getNome() + "'. CPF: '" +
                        getAdms().get(i).getCpf() + "'. Telefone: '" + getAdms().get(i).getTelefone()
                        + "'. Matricula: '" + getAdms().get(i).getMatricula() + "'");
            }
        }
    }

}
