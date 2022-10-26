package br.unicap.luis_00000845392.p3.projeto.HealthSaude.Exceptions;

public class PacienteNoFoundException extends Exception{
    public PacienteNoFoundException(){

    }

    @Override
    public String toString() {
        return "Paciente não encontrado";
    }
}
