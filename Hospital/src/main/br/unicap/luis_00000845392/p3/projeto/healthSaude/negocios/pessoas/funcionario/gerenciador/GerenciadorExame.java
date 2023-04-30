package main.br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.pessoas.funcionario.gerenciador;

import main.br.unicap.luis_00000845392.p3.projeto.healthSaude.dados.listas.FilaDeExame;
import main.br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.pessoas.funcionario.tipos.Exame;

public class GerenciadorExame {
    private FilaDeExame filaDeExames;

    public GerenciadorExame(FilaDeExame filaDeExames) {
        this.filaDeExames = filaDeExames;
    }

    public GerenciadorExame() {
        filaDeExames = new FilaDeExame();
    }

    public FilaDeExame getFilaDeExames() {
        return filaDeExames;
    }

    public void setFilaDeExames(FilaDeExame filaDeExames) {
        this.filaDeExames = filaDeExames;
    }

    public void addExame(Exame e){
        filaDeExames.getFilaExames().add(e);
    }

    public void deleteExame(){
        filaDeExames.getFilaExames().removeFirst();
    }



}
