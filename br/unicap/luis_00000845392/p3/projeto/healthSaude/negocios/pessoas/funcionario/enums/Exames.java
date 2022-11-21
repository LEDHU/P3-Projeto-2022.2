package br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.pessoas.funcionario.enums;

public enum Exames {
    RaioX(1), Sangue(2), tomografia(3);

    public final int exame;

    Exames(int exame) {
        this.exame = exame;
    }

    public int getExame() {
        return exame;
    }
}
