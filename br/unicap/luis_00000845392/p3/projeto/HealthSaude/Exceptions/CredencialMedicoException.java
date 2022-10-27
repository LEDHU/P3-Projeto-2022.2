package br.unicap.luis_00000845392.p3.projeto.HealthSaude.Exceptions;

public class CredencialMedicoException extends Exception{

    public CredencialMedicoException() {
        super("ERRO - Não exite credencial para Medico");
    }
}
