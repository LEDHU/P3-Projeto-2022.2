package br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios;

import br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.pessoas.funcionario.gerenciador.*;
import br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.pessoas.paciente.GerenciadorPaciente;


public class FacadeNegocio {

    //Gerenciadores
    private GerenciadorADM gerenciadorADM;
    private GerenciadorConsulta gerenciadorConsulta;
    private GerenciadorExame gerenciadorExame;
    private GerenciadorFuncionario gerenciadorFuncionario;
    private GerenciadorMedico gerenciadorMedico;
    private GerenciadorRecepcionista gerenciadorRecepcionista;
    private GerenciadorPaciente gerenciadorPaciente;

    //Construdor
    public FacadeNegocio(GerenciadorADM gerenciadorADM, GerenciadorConsulta gerenciadorConsulta, GerenciadorExame gerenciadorExame, GerenciadorFuncionario gerenciadorFuncionario, GerenciadorMedico gerenciadorMedico, GerenciadorRecepcionista gerenciadorRecepcionista, GerenciadorPaciente gerenciadorPaciente) {
        this.gerenciadorADM = gerenciadorADM;
        this.gerenciadorConsulta = gerenciadorConsulta;
        this.gerenciadorExame = gerenciadorExame;
        this.gerenciadorFuncionario = gerenciadorFuncionario;
        this.gerenciadorMedico = gerenciadorMedico;
        this.gerenciadorRecepcionista = gerenciadorRecepcionista;
        this.gerenciadorPaciente = gerenciadorPaciente;
    }

    //Getters e Setters
    public GerenciadorADM getGerenciadorADM() {
        return gerenciadorADM;
    }

    public void setGerenciadorADM(GerenciadorADM gerenciadorADM) {
        this.gerenciadorADM = gerenciadorADM;
    }

    public GerenciadorConsulta getGerenciadorConsulta() {
        return gerenciadorConsulta;
    }

    public void setGerenciadorConsulta(GerenciadorConsulta gerenciadorConsulta) {
        this.gerenciadorConsulta = gerenciadorConsulta;
    }

    public GerenciadorExame getGerenciadorExame() {
        return gerenciadorExame;
    }

    public void setGerenciadorExame(GerenciadorExame gerenciadorExame) {
        this.gerenciadorExame = gerenciadorExame;
    }

    public GerenciadorFuncionario getGerenciadorFuncionario() {
        return gerenciadorFuncionario;
    }

    public void setGerenciadorFuncionario(GerenciadorFuncionario gerenciadorFuncionario) {
        this.gerenciadorFuncionario = gerenciadorFuncionario;
    }

    public GerenciadorMedico getGerenciadorMedico() {
        return gerenciadorMedico;
    }

    public void setGerenciadorMedico(GerenciadorMedico gerenciadorMedico) {
        this.gerenciadorMedico = gerenciadorMedico;
    }

    public GerenciadorRecepcionista getGerenciadorRecepcionista() {
        return gerenciadorRecepcionista;
    }

    public void setGerenciadorRecepcionista(GerenciadorRecepcionista gerenciadorRecepcionista) {
        this.gerenciadorRecepcionista = gerenciadorRecepcionista;
    }

    public GerenciadorPaciente getGerenciadorPaciente() {
        return gerenciadorPaciente;
    }

    public void setGerenciadorPaciente(GerenciadorPaciente gerenciadorPaciente) {
        this.gerenciadorPaciente = gerenciadorPaciente;
    }

}
