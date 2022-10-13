package br.unicap.luis_00000845392.p3.projeto.HealthSaude.Exceptions;

public class CredencialRecepcionistaException extends Exception{
    public CredencialRecepcionistaException() {
    }

    @Override
    public String toString() {
        return "Não exite credencial para Recepcionista";
    }
}
