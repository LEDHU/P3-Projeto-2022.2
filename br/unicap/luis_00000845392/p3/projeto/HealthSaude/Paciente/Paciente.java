package br.unicap.luis_00000845392.p3.projeto.HealthSaude.Paciente;

import java.util.Date;

public class Paciente implements Comparable <Paciente>{
    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;
    private Date nasc;

    public Paciente(String cpf) {
        this.cpf = cpf;
    }

    public Paciente(String nome, String cpf){
        this.cpf = cpf;
        this.nome = nome;
    }

    public Paciente(String nome, String cpf, String endereco, String telefone, Date nasc) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.nasc = nasc;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getNasc() {
        return nasc;
    }

    public void setNasc(Date nasc) {
        this.nasc = nasc;
    }

    @Override
    public String toString() {

        return new String("Nome: " + nome +
                "\nCPF: " + cpf +
                "\nEndereco: '" + endereco +
                "\nTelefone: " + telefone +
                "\nData de nascimento: " + nasc );
    }


    @Override
    public int compareTo(Paciente p) {
        int result;
        result = this.getCpf().compareTo(p.getCpf());
        return result;
    }
}
