package br.unicap.luis_00000845392.p3.projeto.HealthSaude.Exceptions;

public class CredencialAdmException extends Exception{
    public CredencialAdmException() {
    }

    @Override
    public String toString() {
        return "Não exite credencial para ADM";
    }
}
