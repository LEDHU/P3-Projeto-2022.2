package br.unicap.luis_00000845392.p3.projeto.HealthSaude.Funcionario.Tipos;

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
