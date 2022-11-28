package main.br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.exceptions;

public class PacienteNoFoundException extends Exception{
    public PacienteNoFoundException(){
        super("ERRO - Paciente não encontrado");
    }
}
