package br.unicap.luis_00000845392.p3.projeto.HealthSaude.Exceptions;

public class CredencialMedicoException extends Exception{

    public CredencialMedicoException() {
    }

    @Override
    public String toString() {
        return "Não exite credencial para Medico";
    }
}
