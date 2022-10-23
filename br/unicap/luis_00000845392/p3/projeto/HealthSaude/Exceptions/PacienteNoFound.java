package br.unicap.luis_00000845392.p3.projeto.HealthSaude.Exceptions;

public class PacienteNoFound extends Exception{
    public PacienteNoFound(){

    }

    @Override
    public String toString() {
        return "Paciente não encontrado";
    }
}
