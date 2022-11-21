package br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.pessoas.funcionario.gerenciador;

import br.unicap.luis_00000845392.p3.projeto.healthSaude.dados.listas.ListaDeADM;
import br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.pessoas.funcionario.abstrato.Funcionario;

import java.util.Objects;

public class GerenciadorADM {
    private ListaDeADM adms;

    public GerenciadorADM(ListaDeADM adms) {
        this.adms = adms;
    }

    public ListaDeADM getAdms() {
        return adms;
    }

    public void setAdms(ListaDeADM adms) {
        this.adms = adms;
    }

    public void addFuncionario(Funcionario f){
        if (buscar(f) == null) {
            adms.getAdms().add(f);
        }
    }

    public Funcionario buscar(Funcionario f){
        if(!adms.getAdms().isEmpty()){
            int aux = 0;
            while(aux < adms.getAdms().size()){
                if(f.compareTo(adms.getAdms().get(aux)) == 0)
                    return f;
                aux++;
            }
        }
        return null;
    }

    public int buscarInt(Funcionario f){
        if(!adms.getAdms().isEmpty()){
            int aux = 0;
            while(aux < adms.getAdms().size()){
                if(f.compareTo(adms.getAdms().get(aux)) == 0)
                    return aux;
                aux++;
            }
        }
        return -1;
    }

    public void deleteFuncionario(Funcionario f, int i){
        if(!Objects.equals(f.getMatricula(), "M000")) {
            if (buscar(f) != null)
                adms.getAdms().remove(i);
        }
    }

    public void exibirLista(){
        if(adms.getAdms().isEmpty())
            System.out.println("Lista de administração vazia");
        else {
            for(int i = 0; i < adms.getAdms().size(); i++){
                System.out.println(i + " - Nome: '" + adms.getAdms().get(i).getNome() + "'. CPF: '" +
                        adms.getAdms().get(i).getCpf() + "'. Telefone: '" + adms.getAdms().get(i).getTelefone()
                        + "'. Matricula: '" + adms.getAdms().get(i).getMatricula() + "'");
            }
        }
    }

}
