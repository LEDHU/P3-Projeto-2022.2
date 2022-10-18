package br.unicap.luis_00000845392.p3.projeto.HealthSaude.Funcionario;

public abstract class Funcionario implements Comparable <Funcionario> {

    protected String nome;
    protected String cpf;
    protected String telefone;
    protected String matricula;
    protected double salario;

    public Funcionario(String matricula) {
        this.matricula = matricula;
    }

    public Funcionario(double salario){
        this.salario = salario;
    }

    public Funcionario(String nome, String cpf, String telefone, String matricula) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getMatricula() {
        return matricula;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public int compareTo(Funcionario f) {
        int result;
        result = this.getMatricula().compareTo(f.getMatricula());
        return result;
    }
}
