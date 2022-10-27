package br.unicap.luis_00000845392.p3.projeto.HealthSaude.Pessoas.Funcionario.Abstrato;

import br.unicap.luis_00000845392.p3.projeto.HealthSaude.Pessoas.Abstrato.Pessoa;

public abstract class Funcionario extends Pessoa implements Comparable <Funcionario> {

    protected String matricula;
    protected double salario;

    public Funcionario(String matricula) {
        this.matricula = matricula;
    }

    public Funcionario(double salario){
        this.salario = salario;
    }

    public Funcionario(String nome, String cpf, String telefone, String matricula) {
        super(nome, cpf, telefone);
        this.matricula = matricula;
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
