package br.unicap.luis_00000845392.p3.projeto.healthSaude.dados;

import br.unicap.luis_00000845392.p3.projeto.healthSaude.dados.listas.*;


public class FacadeDados {
    //instanciar apenas uma vez
    private static FacadeDados uniqueInstance;

    public static synchronized FacadeDados getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new FacadeDados();

        return uniqueInstance;
    }

    //Filas
    private FilaDeConsulta filaDeConsulta;
    private FilaDeExame filaDeExame;

    //Listas
    private ListaDeADM listaDeADM;
    private ListaDeFuncionario listaDeFuncionario;
    private ListaDeMedico listaDeMedico;
    private ListaDePaciente listaDePaciente;
    private ListaDeRecepcionista listaDeRecepcionista;

    private FacadeDados() {

    }

    //Getters e Setters
    public FilaDeConsulta getFilaDeConsulta() {
        return filaDeConsulta;
    }

    public void setFilaDeConsulta(FilaDeConsulta filaDeConsulta) {
        this.filaDeConsulta = filaDeConsulta;
    }

    public FilaDeExame getFilaDeExame() {
        return filaDeExame;
    }

    public void setFilaDeExame(FilaDeExame filaDeExame) {
        this.filaDeExame = filaDeExame;
    }

    public ListaDeADM getListaDeADM() {
        return listaDeADM;
    }

    public void setListaDeADM(ListaDeADM listaDeADM) {
        this.listaDeADM = listaDeADM;
    }

    public ListaDeFuncionario getListaDeFuncionario() {
        return listaDeFuncionario;
    }

    public void setListaDeFuncionario(ListaDeFuncionario listaDeFuncionario) {
        this.listaDeFuncionario = listaDeFuncionario;
    }

    public ListaDeMedico getListaDeMedico() {
        return listaDeMedico;
    }

    public void setListaDeMedico(ListaDeMedico listaDeMedico) {
        this.listaDeMedico = listaDeMedico;
    }

    public ListaDePaciente getListaDePaciente() {
        return listaDePaciente;
    }

    public void setListaDePaciente(ListaDePaciente listaDePaciente) {
        this.listaDePaciente = listaDePaciente;
    }

    public ListaDeRecepcionista getListaDeRecepcionista() {
        return listaDeRecepcionista;
    }

    public void setListaDeRecepcionista(ListaDeRecepcionista listaDeRecepcionista) {
        this.listaDeRecepcionista = listaDeRecepcionista;
    }
}