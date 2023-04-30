package main.br.unicap.luis_00000845392.p3.projeto.healthSaude.dados;

import main.br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.pessoas.funcionario.abstrato.Funcionario;
import main.br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.pessoas.funcionario.gerenciador.*;
import main.br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.pessoas.funcionario.tipos.Exame;
import main.br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.pessoas.paciente.GerenciadorPaciente;
import main.br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.pessoas.paciente.Paciente;

public class FacadeDados {
    //Filas
    private GerenciadorConsulta gerenciadorConsulta;
    private GerenciadorExame gerenciadorExame;

    //Listas
    private GerenciadorADM gerenciadorADM;
    private GerenciadorFuncionario gerenciadorFuncionario;
    private GerenciadorMedico gerenciadorMedico;
    private GerenciadorPaciente gerenciadorPaciente;
    private GerenciadorRecepcionista gerenciadorRecepcionista;

    //Construdores
    public FacadeDados(GerenciadorConsulta gerenciadorConsulta, GerenciadorExame gerenciadorExame, GerenciadorADM gerenciadorADM, GerenciadorFuncionario gerenciadorFuncionario, GerenciadorMedico gerenciadorMedico, GerenciadorPaciente gerenciadorPaciente, GerenciadorRecepcionista gerenciadorRecepcionista) {
        this.gerenciadorConsulta = gerenciadorConsulta;
        this.gerenciadorExame = gerenciadorExame;
        this.gerenciadorADM = gerenciadorADM;
        this.gerenciadorFuncionario = gerenciadorFuncionario;
        this.gerenciadorMedico = gerenciadorMedico;
        this.gerenciadorPaciente = gerenciadorPaciente;
        this.gerenciadorRecepcionista = gerenciadorRecepcionista;
    }

    //Getters e Setters
    public GerenciadorFuncionario getGerenciadorFuncionario() {
        return gerenciadorFuncionario;
    }

    public void setGerenciadorFuncionario(GerenciadorFuncionario gerenciadorFuncionario) {
        this.gerenciadorFuncionario = gerenciadorFuncionario;
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

    public GerenciadorADM getGerenciadorADM() {
        return gerenciadorADM;
    }

    public void setGerenciadorADM(GerenciadorADM gerenciadorADM) {
        this.gerenciadorADM = gerenciadorADM;
    }

    public GerenciadorMedico getGerenciadorMedico() {
        return gerenciadorMedico;
    }

    public void setGerenciadorMedico(GerenciadorMedico gerenciadorMedico) {
        this.gerenciadorMedico = gerenciadorMedico;
    }

    public GerenciadorPaciente getGerenciadorPaciente() {
        return gerenciadorPaciente;
    }

    public void setGerenciadorPaciente(GerenciadorPaciente gerenciadorPaciente) {
        this.gerenciadorPaciente = gerenciadorPaciente;
    }

    public GerenciadorRecepcionista getGerenciadorRecepcionista() {
        return gerenciadorRecepcionista;
    }

    public void setGerenciadorRecepcionista(GerenciadorRecepcionista gerenciadorRecepcionista) {
        this.gerenciadorRecepcionista = gerenciadorRecepcionista;
    }

    //os metodos dos gerenciadores
    //Gerenciador de consulta
    public void addConsulta(Paciente p){
        gerenciadorConsulta.addConsulta(p);
    }
    public void deleteConsulta(){
        gerenciadorConsulta.deleteConsulta();
    }

    //Gerenciador de Exame
    public void addExame(Exame e){
        gerenciadorExame.addExame(e);
    }
    public void deleteExame(){
        gerenciadorExame.deleteExame();
    }

    //Gerenciador de ADM
    public void addAdm(Funcionario f){
        gerenciadorADM.addFuncionario(f);
    }
    public Funcionario buscar(Funcionario f){
        return gerenciadorADM.buscar(f);
    }
    public void deleteAdm(Funcionario f, int x){
        gerenciadorADM.deleteFuncionario(f, x);
    }
    public void exibirListaAdm(){
        gerenciadorADM.exibirLista();
    }
    public int buscarIntAdm(Funcionario f){
        return gerenciadorADM.buscarInt(f);
    }

    //Gerenciador de Medico
    public void addMedico(Funcionario f){
        gerenciadorMedico.addFuncionario(f);
    }
    public void deleteMedico(Funcionario f, int x){
        gerenciadorMedico.deleteFuncionario(f, x);
    }
    public Funcionario buscarMedico(Funcionario f){
        return gerenciadorMedico.buscar(f);
    }
    public int buscarIntMedico(Funcionario f){
        return gerenciadorMedico.buscarInt(f);
    }

    //Gerenciador de Recepcionista
    public void addRecepcionista(Funcionario f){
        gerenciadorRecepcionista.addFuncionario(f);
    }
    public void deleteRecepcionista(Funcionario f, int x){
        gerenciadorRecepcionista.deleteFuncionario(f, x);
    }
    public int buscarIntRecepcionista(Funcionario f){
        return gerenciadorRecepcionista.buscarInt(f);
    }
    public Funcionario buscarRecepcionista(Funcionario f){
        return gerenciadorRecepcionista.buscar(f);
    }

    //Gerenciador de funcionario
    public void addFuncionario(Funcionario f){
        gerenciadorFuncionario.addFuncionario(f);
    }
    public void deleteFuncionario(Funcionario f, int x){
        gerenciadorFuncionario.deleteFuncionario(f, x);
    }
    public Funcionario buscarFuncionario(Funcionario f){
        return getGerenciadorFuncionario().buscar(f);
    }
    public void exibirListaFuncionario(){
        gerenciadorFuncionario.exibirLista();
    }
    public int buscarIntFuncionario(Funcionario f){
        return gerenciadorFuncionario.buscarInt(f);
    }
    public void exibirFuncionario(String matri){
        gerenciadorFuncionario.exibirFuncionario(matri);
    }

    //Gerenciador de Paciente
    public void addPaciente(Paciente p) {
        gerenciadorPaciente.addPaciente(p);
    }
    public void deletePaciente(Paciente p, int i){
        gerenciadorPaciente.deletePaciente(p, i);
    }
    public Paciente buscar(Paciente p){
        return gerenciadorPaciente.buscar(p);
    }
    public void exibirListaPaciente(){
        gerenciadorPaciente.exibirLista();
    }
    public int buscarIntPaciente(Paciente p){
        return gerenciadorPaciente.buscarInt(p);
    }
}