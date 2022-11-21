package br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.pessoas.funcionario.gerenciador;

import br.unicap.luis_00000845392.p3.projeto.healthSaude.dados.listas.FilaDeExame;
import br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.pessoas.funcionario.tipos.Exame;

public class GerenciadorExame {
    private FilaDeExame filaDeExames;

    public GerenciadorExame(FilaDeExame listaDeExames) {
        this.filaDeExames = listaDeExames;
    }

    public FilaDeExame getListaDeExames() {
        return filaDeExames;
    }

    public void setListaDeExames(FilaDeExame listaDeExames) {
        this.filaDeExames = listaDeExames;
    }

    public void addExame(Exame e){
        filaDeExames.getFilaExames().add(e);
    }

    public void deleteExame(){
        filaDeExames.getFilaExames().removeFirst();
    }



}
