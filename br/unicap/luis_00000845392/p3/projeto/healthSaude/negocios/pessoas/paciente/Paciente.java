package br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.pessoas.paciente;

import br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.pessoas.abstrato.Pessoa;

import java.util.Date;

public class Paciente extends Pessoa implements Comparable <Paciente>{

    protected String endereco;
    protected Date nasc;

    public Paciente(String cpf) {
        super(cpf);
    }

    public Paciente(String nome, String cpf, String endereco, String telefone, Date nasc) {
        super(nome, cpf, telefone);
        this.endereco = endereco;
        this.nasc = nasc;
    }

    public Paciente() {
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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
