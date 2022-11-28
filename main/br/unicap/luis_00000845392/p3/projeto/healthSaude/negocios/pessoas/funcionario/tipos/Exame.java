package main.br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.pessoas.funcionario.tipos;

import main.br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.pessoas.paciente.Paciente;

import java.util.Date;

public class Exame extends Paciente {
    private String tipo;

    public Exame (String tip, String nome, String cpf, String telefone, String endereco, Date nasc){
        super(nome, cpf, telefone, endereco, nasc);
        this.tipo = tip;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\n" +
                "CPF: " + cpf + "\n" +
                "Telefone: " + telefone + "\n" +
                "Exame: " + tipo + '\'' +
                "Endereco: " + endereco + "\n" +
                "Nascimento: " + nasc + "\n";
    }
}
