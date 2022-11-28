package main.br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.exceptions;

public class CredencialRecepcionistaException extends Exception{
    public CredencialRecepcionistaException() {
        super("ERRO - Não exite credencial para Recepcionista");
    }
}
