package br.unicap.luis_00000845392.p3.projeto.HealthSaude.Pessoas.Funcionario.Enums;

public enum Cargos {
    ADM(1), Medico(2), Recepcionista(3);

    public final int Cargo;
    Cargos(int valor) {
        Cargo = valor;
    }
    public int getValor() {
        return Cargo;
    }
}
