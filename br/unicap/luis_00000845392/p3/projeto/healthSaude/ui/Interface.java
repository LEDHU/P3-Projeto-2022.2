package br.unicap.luis_00000845392.p3.projeto.healthSaude.ui;

import br.unicap.luis_00000845392.p3.projeto.healthSaude.dados.FacadeDados;
import br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.FacadeNegocio;
import br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.exceptions.CredencialAdmException;
import br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.exceptions.CredencialMedicoException;
import br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.exceptions.CredencialRecepcionistaException;
import br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.exceptions.PacienteNoFoundException;
import br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.pessoas.funcionario.enums.Cargos;
import br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.pessoas.funcionario.enums.Exames;
import br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.pessoas.funcionario.tipos.*;
import br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.pessoas.paciente.Paciente;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Interface {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {

        Paciente paciente;
        ADM adm;
        Medico medico;
        Recepcionista recepcionista;

        int opcao0 = 1;
        int opcao1;

        String matricula;
        String matriAux;
        String nome;
        String cpf;
        String telefone;
        String endereco;
        String nasc;
        Date nascimento;

        SimpleDateFormat formatter;


        //criacao de uma credencial funcionario principal
        //inical para adicionar os outros funcionarios
        matricula = "M000";
        adm = new ADM(matricula);
        FacadeDados.getInstance().getListaDeFuncionario().getFuncionarios().add(adm);
        FacadeDados.getInstance().getListaDeADM().getAdms().add(adm);

        //intencao de limpar a tela
        for(int i = 0; i < 50; i++){
            System.out.println();
        }
        System.out.println("Welcome to HealthSaude");

        while (opcao0 != 0) {
            try {
                opcao0 = menuGeral();

                switch (opcao0) {
                    //ADMINISTRADOR
                    case 1 -> {
                        opcao1 = 1;
                        matricula = menuMatri();
                        matriAux = matricula;
                        adm = new ADM(matricula);
                        if (FacadeNegocio.getInstance().getGerenciadorADM().buscar(adm) == null) {
                            throw new CredencialAdmException();
                        } else {
                            while (opcao1 != 0) {
                                try {
                                    opcao1 = menuADM();
                                    switch (opcao1) {
                                        case 1 -> {
                                            System.out.println("Cargo: ");
                                            try {
                                                opcao1 = menuCargo();
                                                System.out.println("Nome: ");
                                                nome = in.nextLine();
                                                System.out.println("CPF: ");
                                                cpf = in.nextLine();
                                                System.out.println("Telefone: ");
                                                telefone = in.nextLine();
                                                matricula = menuMatri();
                                                if (opcao1 == Cargos.ADM.Cargo) {

                                                    adm = new ADM(nome, cpf, telefone, matricula);

                                                    if (FacadeNegocio.getInstance().getGerenciadorFuncionario().buscar(adm) == null) {
                                                        FacadeDados.getInstance().getListaDeFuncionario().getFuncionarios().add(adm);
                                                        FacadeDados.getInstance().getListaDeADM().getAdms().add(adm);
                                                    } else
                                                        System.out.println("Funcionario ja cadastrado");

                                                } else if (opcao1 == Cargos.Medico.Cargo) {

                                                    medico = Medico.getInstance(nome, cpf, telefone, matricula);

                                                    if (FacadeNegocio.getInstance().getGerenciadorFuncionario().buscar(medico) == null) {
                                                        FacadeDados.getInstance().getListaDeFuncionario().getFuncionarios().add(medico);
                                                        FacadeDados.getInstance().getListaDeMedico().getMedicos().add(medico);
                                                    } else
                                                        System.out.println("Funcionario ja cadastrado");

                                                } else if (opcao1 == Cargos.Recepcionista.Cargo) {

                                                    recepcionista = new Recepcionista(nome, cpf, telefone, matricula);

                                                    if (FacadeNegocio.getInstance().getGerenciadorFuncionario().buscar(recepcionista) == null) {
                                                        FacadeDados.getInstance().getListaDeFuncionario().getFuncionarios().add(recepcionista);
                                                        FacadeDados.getInstance().getListaDeRecepcionista().getRecepcionistas().add(recepcionista);
                                                    } else
                                                        System.out.println("Funcionario ja cadastrado");
                                                }
                                            } catch (InputMismatchException inputMismatchException) {
                                                System.out.println("ERRO - Valor incorreto");
                                            }
                                        }
                                        case 2 -> {
                                            System.out.println("Cargo: ");
                                            opcao1 = menuCargo();
                                            matricula = menuMatri();

                                            if (opcao1 == Cargos.ADM.Cargo) {
                                                adm = new ADM(matricula);

                                                int x = FacadeNegocio.getInstance().getGerenciadorADM().buscarInt(adm);

                                                if (x != -1) {
                                                    FacadeNegocio.getInstance().getGerenciadorADM().deleteFuncionario(adm, x);
                                                    x = FacadeNegocio.getInstance().getGerenciadorFuncionario().buscarInt(adm);
                                                    FacadeNegocio.getInstance().getGerenciadorFuncionario().deleteFuncionario(adm, x);
                                                } else
                                                    throw new CredencialAdmException();

                                            } else if (opcao1 == Cargos.Medico.Cargo) {
                                                medico = Medico.getInstance(matricula);

                                                int x = FacadeNegocio.getInstance().getGerenciadorMedico().buscarInt(medico);

                                                if (x != -1) {
                                                    FacadeNegocio.getInstance().getGerenciadorMedico().deleteFuncionario(medico, x);
                                                    x = FacadeNegocio.getInstance().getGerenciadorFuncionario().buscarInt(medico);
                                                    FacadeNegocio.getInstance().getGerenciadorFuncionario().deleteFuncionario(medico, x);
                                                } else
                                                    throw new CredencialMedicoException();

                                            } else if (opcao1 == Cargos.Recepcionista.Cargo) {
                                                recepcionista = new Recepcionista(matricula);

                                                int x = FacadeNegocio.getInstance().getGerenciadorRecepcionista().buscarInt(recepcionista);

                                                if (x != -1) {
                                                    FacadeNegocio.getInstance().getGerenciadorRecepcionista().deleteFuncionario(recepcionista, x);
                                                    x = FacadeNegocio.getInstance().getGerenciadorFuncionario().buscarInt(recepcionista);
                                                    FacadeNegocio.getInstance().getGerenciadorFuncionario().deleteFuncionario(recepcionista, x);
                                                } else
                                                    throw new CredencialRecepcionistaException();
                                            }
                                        }
                                        case 3 -> {
                                            double hora, valor;
                                            if (!FacadeDados.getInstance().getListaDeADM().getAdms().isEmpty()) {
                                                adm = new ADM(matriAux);
                                                int x = FacadeNegocio.getInstance().getGerenciadorADM().buscarInt(adm);
                                                if (x != -1) {
                                                    System.out.println("Hora extra: ");
                                                    hora = in.nextDouble();
                                                    valor = adm.calcularSalario(hora);
                                                    FacadeNegocio.getInstance().getGerenciadorADM().getAdms().getAdms().get(x).setSalario(valor);
                                                    System.out.println("O salario de " + FacadeNegocio.getInstance().getGerenciadorADM().getAdms().getAdms().get(x).getNome() + " é: " + valor);
                                                } else
                                                    throw new CredencialAdmException();
                                            } else
                                                System.out.println("Lista de administraçao esta vazia para calcular o salario");

                                        }
                                        case 4 -> {
                                            System.out.println("Cargo: ");
                                            opcao1 = menuCargo();
                                            matricula = menuMatri();

                                            if (opcao1 == Cargos.ADM.Cargo) {
                                                adm = new ADM(matricula);

                                                int x = FacadeNegocio.getInstance().getGerenciadorADM().buscarInt(adm);

                                                if (x != -1) {
                                                    System.out.println("Nome: ");
                                                    nome = in.nextLine();
                                                    System.out.println("CPF: ");
                                                    cpf = in.nextLine();
                                                    System.out.println("Telefone: ");
                                                    telefone = in.nextLine();

                                                    FacadeNegocio.getInstance().getGerenciadorADM().getAdms().getAdms().get(x).setNome(nome);
                                                    FacadeNegocio.getInstance().getGerenciadorADM().getAdms().getAdms().get(x).setCpf(cpf);
                                                    FacadeNegocio.getInstance().getGerenciadorADM().getAdms().getAdms().get(x).setTelefone(telefone);

                                                    x = FacadeNegocio.getInstance().getGerenciadorFuncionario().buscarInt(adm);

                                                    FacadeNegocio.getInstance().getGerenciadorFuncionario().getFuncionarios().getFuncionarios().get(x).setNome(nome);
                                                    FacadeNegocio.getInstance().getGerenciadorFuncionario().getFuncionarios().getFuncionarios().get(x).setCpf(cpf);
                                                    FacadeNegocio.getInstance().getGerenciadorFuncionario().getFuncionarios().getFuncionarios().get(x).setTelefone(telefone);
                                                    System.out.println("Atualizado");
                                                }
                                                else
                                                    throw new CredencialAdmException();

                                            } else if (opcao1 == Cargos.Medico.Cargo) {
                                                medico = Medico.getInstance(matricula);
                                                int x = FacadeNegocio.getInstance().getGerenciadorMedico().buscarInt(medico);

                                                if (x != -1) {
                                                    System.out.println("Nome: ");
                                                    nome = in.nextLine();
                                                    System.out.println("CPF: ");
                                                    cpf = in.nextLine();
                                                    System.out.println("Telefone: ");
                                                    telefone = in.nextLine();

                                                    FacadeNegocio.getInstance().getGerenciadorMedico().getMedicos().getMedicos().get(x).setNome(nome);
                                                    FacadeNegocio.getInstance().getGerenciadorMedico().getMedicos().getMedicos().get(x).setCpf(cpf);
                                                    FacadeNegocio.getInstance().getGerenciadorMedico().getMedicos().getMedicos().get(x).setTelefone(telefone);

                                                    x = FacadeNegocio.getInstance().getGerenciadorFuncionario().buscarInt(medico);

                                                    FacadeNegocio.getInstance().getGerenciadorFuncionario().getFuncionarios().getFuncionarios().get(x).setNome(nome);
                                                    FacadeNegocio.getInstance().getGerenciadorFuncionario().getFuncionarios().getFuncionarios().get(x).setCpf(cpf);
                                                    FacadeNegocio.getInstance().getGerenciadorFuncionario().getFuncionarios().getFuncionarios().get(x).setTelefone(telefone);
                                                    System.out.println("Atualizado");

                                                }
                                                else
                                                    throw new CredencialMedicoException();

                                            } else if (opcao1 == Cargos.Recepcionista.Cargo) {
                                                recepcionista = new Recepcionista(matricula);
                                                int x = FacadeNegocio.getInstance().getGerenciadorRecepcionista().buscarInt(recepcionista);

                                                if (x != -1) {
                                                    System.out.println("Nome: ");
                                                    nome = in.nextLine();
                                                    System.out.println("CPF: ");
                                                    cpf = in.nextLine();
                                                    System.out.println("Telefone: ");
                                                    telefone = in.nextLine();

                                                    FacadeNegocio.getInstance().getGerenciadorRecepcionista().getRecepcionistas().getRecepcionistas().get(x).setNome(nome);
                                                    FacadeNegocio.getInstance().getGerenciadorRecepcionista().getRecepcionistas().getRecepcionistas().get(x).setCpf(cpf);
                                                    FacadeNegocio.getInstance().getGerenciadorRecepcionista().getRecepcionistas().getRecepcionistas().get(x).setTelefone(telefone);

                                                    x = FacadeNegocio.getInstance().getGerenciadorFuncionario().buscarInt(recepcionista);

                                                    FacadeNegocio.getInstance().getGerenciadorFuncionario().getFuncionarios().getFuncionarios().get(x).setNome(nome);
                                                    FacadeNegocio.getInstance().getGerenciadorFuncionario().getFuncionarios().getFuncionarios().get(x).setCpf(cpf);
                                                    FacadeNegocio.getInstance().getGerenciadorFuncionario().getFuncionarios().getFuncionarios().get(x).setTelefone(telefone);
                                                    System.out.println("Atualizado");

                                                } else
                                                    throw new CredencialRecepcionistaException();
                                            }

                                        }

                                        case 5 -> {
                                            matricula = menuMatri();
                                            FacadeNegocio.getInstance().getGerenciadorFuncionario().exibirFuncionario(matricula);
                                        }

                                        case 6 ->
                                            FacadeNegocio.getInstance().getGerenciadorFuncionario().exibirLista();

                                        case 0 ->{}
                                        default -> menuInvalido();

                                    }
                                }
                                catch (InputMismatchException inputMismatchException){
                                    System.out.println("ERRO - Valor incorreto");
                                }
                                catch (CredencialMedicoException credencialMedicoException) {
                                    System.out.println("ERRO - Não exite credencial para Medico");
                                }
                                catch (CredencialAdmException credencialAdmException) {
                                    System.out.println("ERRO - Não exite credencial para ADM");
                                }
                                catch (CredencialRecepcionistaException credencialRecepcionistaException){
                                    System.out.println("ERRO - Não exite credencial para Recepcionista");
                                }
                            }
                        }
                    }
                    //MEDICO
                    case 2 -> {
                        opcao0 = 1;
                        opcao1 = 1;
                        matricula = menuMatri();
                        medico = Medico.getInstance(matricula);

                        if (FacadeNegocio.getInstance().getGerenciadorMedico().buscar(medico) == null) {
                           throw new CredencialMedicoException();
                        } else {
                            while (opcao1 != 0) {
                                try {
                                    opcao1 = menuMedico();
                                    switch (opcao1) {
                                        case 1 -> {
                                            FacadeNegocio.getInstance().getGerenciadorConsulta().deleteConsulta();
                                            System.out.println("O paciente foi atendido");
                                        }
                                        case 2 -> {
                                            FacadeNegocio.getInstance().getGerenciadorExame().deleteExame();
                                            System.out.println("O paciente foi atendido");

                                        }
                                        case 3 ->
                                            System.out.println(FacadeDados.getInstance().getFilaDeConsulta().getFilaConsulta().getFirst());

                                        case 4 ->
                                            System.out.println(FacadeDados.getInstance().getFilaDeExame().getFilaExames().getFirst());
                                        case 5 ->{
                                            double hora, valor;
                                            if (!FacadeDados.getInstance().getListaDeMedico().getMedicos().isEmpty()) {
                                                medico = Medico.getInstance(matricula);
                                                int x = FacadeNegocio.getInstance().getGerenciadorMedico().buscarInt(medico);
                                                if (x != -1) {
                                                    System.out.println("Hora extra: ");
                                                    hora = in.nextDouble();
                                                    valor = medico.calcularSalario(hora);
                                                    FacadeNegocio.getInstance().getGerenciadorMedico().getMedicos().getMedicos().get(x).setSalario(valor);
                                                    System.out.println("O salario de " + FacadeNegocio.getInstance().getGerenciadorMedico().getMedicos().getMedicos().get(x).getNome() + " é: " + valor);
                                                } else
                                                    throw new CredencialMedicoException();
                                            } else
                                                System.out.println("Lista de medico esta vazia para calcular o salario");
                                        }
                                        case 0 ->{}
                                        default -> menuInvalido();

                                    }
                                }
                                catch (InputMismatchException inputMismatchException){
                                    System.out.println("ERRO - Valor incorreto");
                                }
                                catch (NoSuchElementException noSuchElementException){
                                    System.out.println("ERRO - Sem paciente na fila");
                                }
                            }
                        }
                    }
                    //RECEPCIONISTA
                    case 3 -> {
                        opcao0 = 1;
                        opcao1 = 1;
                        matricula = menuMatri();
                        recepcionista = new Recepcionista(matricula);
                        if (FacadeNegocio.getInstance().getGerenciadorRecepcionista().buscar(recepcionista) == null) {
                            throw new CredencialRecepcionistaException();
                        }
                        else {
                            while (opcao1 != 0) {
                                try {
                                    opcao1 = menuRecepcionista();
                                    switch (opcao1) {
                                        case 1 -> {
                                            System.out.println("Nome: ");
                                            nome = in.nextLine();
                                            System.out.println("CPF: ");
                                            cpf = in.nextLine();
                                            System.out.println("Endereço: ");
                                            endereco = in.nextLine();
                                            System.out.println("Telefone: ");
                                            telefone = in.nextLine();
                                            System.out.println("Data de nascimento: (dd/MM/yyyy)");
                                            nasc = in.nextLine();
                                            formatter = new SimpleDateFormat("dd/MM/yyyy");
                                            nascimento = formatter.parse(nasc);

                                            paciente = new Paciente(nome, cpf, endereco, telefone, nascimento);

                                            if (FacadeNegocio.getInstance().getGerenciadorPaciente().buscar(paciente) == null) {
                                                FacadeDados.getInstance().getListaDePaciente().getPacientes().add(paciente);
                                            }
                                        }
                                        case 2 -> {
                                            System.out.println("Não é recomentado excluir paciente do banco de dados");
                                            System.out.println("Deseja excluir? s/n");
                                            char c = in.next().charAt(0);
                                            if (c == 's') {
                                                System.out.println("CPF: ");
                                                cpf = in.nextLine();
                                                paciente = new Paciente(cpf);
                                                int x = FacadeNegocio.getInstance().getGerenciadorPaciente().buscarInt(paciente);
                                                if (x == -1)
                                                    System.out.println("Paciente não incluido no sistema");
                                                else
                                                    FacadeNegocio.getInstance().getGerenciadorPaciente().deletePaciente(paciente, x);
                                            }
                                        }
                                        case 3 ->{
                                            System.out.println("CPF: ");
                                            cpf = in.nextLine();
                                            paciente = new Paciente(cpf);
                                            int x = FacadeNegocio.getInstance().getGerenciadorPaciente().buscarInt(paciente);
                                            if(x != -1){
                                                System.out.println("Nome: ");
                                                nome = in.nextLine();
                                                System.out.println("CPF: ");
                                                cpf = in.nextLine();
                                                System.out.println("Endereço: ");
                                                endereco = in.nextLine();
                                                System.out.println("Telefone: ");
                                                telefone = in.nextLine();
                                                System.out.println("Data de nascimento: (dd/MM/yyyy)");
                                                nasc = in.nextLine();
                                                formatter = new SimpleDateFormat("dd/MM/yyyy");
                                                nascimento = formatter.parse(nasc);

                                                FacadeNegocio.getInstance().getGerenciadorPaciente().getPacientes().getPacientes().get(x).setNome(nome);
                                                FacadeNegocio.getInstance().getGerenciadorPaciente().getPacientes().getPacientes().get(x).setCpf(cpf);
                                                FacadeNegocio.getInstance().getGerenciadorPaciente().getPacientes().getPacientes().get(x).setEndereco(endereco);
                                                FacadeNegocio.getInstance().getGerenciadorPaciente().getPacientes().getPacientes().get(x).setTelefone(telefone);
                                                FacadeNegocio.getInstance().getGerenciadorPaciente().getPacientes().getPacientes().get(x).setNasc(nascimento);
                                            }
                                            else
                                                throw new PacienteNoFoundException();

                                        }
                                        case 4 -> {
                                            System.out.println("CPF do paciente: ");
                                            cpf = in.nextLine();
                                            paciente = new Paciente(cpf);

                                            if (FacadeNegocio.getInstance().getGerenciadorPaciente().buscar(paciente) == null)
                                                System.out.println("Adicione o paciente antes de marcar uma consulta");
                                            else {
                                                FacadeDados.getInstance().getFilaDeConsulta().getFilaConsulta().add(paciente);
                                                System.out.println("Adicionado na fila para consulta");
                                            }
                                        }
                                        case 5 -> {
                                            System.out.println("CPF do paciente: ");
                                            cpf = in.nextLine();

                                            paciente = new Paciente(cpf);
                                            paciente = FacadeNegocio.getInstance().getGerenciadorPaciente().buscar(paciente);
                                            Exame exame;

                                            if (paciente != null){
                                                menuExame();
                                                try {
                                                    opcao0 = in.nextInt();
                                                    if (opcao0 == Exames.RaioX.exame) {
                                                        exame = new Exame("Raio-X", paciente.getNome(), paciente.getCpf(), paciente.getTelefone(), paciente.getEndereco(), paciente.getNasc());
                                                        FacadeDados.getInstance().getFilaDeExame().getFilaExames().add(exame);
                                                        System.out.println("Adicionado na fila para exames");
                                                    } else if (opcao0 == Exames.Sangue.exame) {
                                                        exame = new Exame("de sangue", paciente.getNome(), paciente.getCpf(), paciente.getTelefone(), paciente.getEndereco(), paciente.getNasc());
                                                        FacadeDados.getInstance().getFilaDeExame().getFilaExames().add(exame);
                                                        System.out.println("Adicionado na fila para exames");
                                                    } else if (opcao0 == Exames.tomografia.exame) {
                                                        exame = new Exame("Tomografia", paciente.getNome(), paciente.getCpf(), paciente.getTelefone(), paciente.getEndereco(), paciente.getNasc());
                                                        FacadeDados.getInstance().getFilaDeExame().getFilaExames().add(exame);
                                                        System.out.println("Adicionado na fila para exames");
                                                    }
                                                }
                                                catch (InputMismatchException inputMismatchException){
                                                    System.out.println("ERRO - Valor incorreto");
                                                }
                                                catch (NumberFormatException numberFormatException){
                                                    System.out.println("ERRO - O número não foi selecionado de forma correta");
                                                }
                                            }
                                            else
                                                System.out.println("Adicione o paciente antes de marcar um exame");
                                        }
                                        case 6 -> {
                                            if (!FacadeDados.getInstance().getFilaDeConsulta().getFilaConsulta().isEmpty())
                                                System.out.println(FacadeDados.getInstance().getFilaDeConsulta().getFilaConsulta().getFirst().getNome()+ " " +
                                                        FacadeDados.getInstance().getFilaDeConsulta().getFilaConsulta().getFirst().getNasc());
                                            else
                                                System.out.println("Lista de paciente para consulta esta vazia");
                                        }
                                        case 7 -> {
                                            if (!FacadeDados.getInstance().getFilaDeExame().getFilaExames().isEmpty())
                                                System.out.println(FacadeDados.getInstance().getFilaDeExame().getFilaExames().getFirst().getNome() + " " +
                                                        FacadeDados.getInstance().getFilaDeExame().getFilaExames().getFirst().getNasc() + " " +
                                                        FacadeDados.getInstance().getFilaDeExame().getFilaExames().getFirst().getTipo());
                                            else
                                                System.out.println("Lista de paciente para exame esta vazia");
                                        }
                                        case 8 ->
                                            FacadeNegocio.getInstance().getGerenciadorPaciente().exibirLista();
                                        case 9 ->{
                                            double hora, valor;
                                            if (!FacadeDados.getInstance().getListaDeRecepcionista().getRecepcionistas().isEmpty()) {
                                                recepcionista = new Recepcionista(matricula);
                                                int x = FacadeNegocio.getInstance().getGerenciadorRecepcionista().buscarInt(recepcionista);
                                                if (x != -1) {
                                                    System.out.println("Hora extra: ");
                                                    hora = in.nextDouble();
                                                    valor = recepcionista.calcularSalario(hora);
                                                    FacadeNegocio.getInstance().getGerenciadorRecepcionista().getRecepcionistas().getRecepcionistas().get(x).setSalario(valor);
                                                    System.out.println("O salario de " + FacadeNegocio.getInstance().getGerenciadorRecepcionista().getRecepcionistas().getRecepcionistas().get(x).getNome() + " é: " + valor);
                                                }
                                            } else
                                                throw new CredencialRecepcionistaException();
                                        }
                                        case 0 ->{}
                                        default -> menuInvalido();
                                    }
                                }
                                catch (InputMismatchException inputMismatchException){
                                    System.out.println("ERRO - Valor incorreto");
                                }
                                catch (NoSuchElementException noSuchElementException){
                                    System.out.println("ERRO - Sem paciente na fila");
                                }
                                catch (ParseException parseException) {
                                    System.out.println("ERRO - Data inserida incorretamente");
                                } catch (PacienteNoFoundException e) {
                                    System.out.println("ERRO - Paciente não encontrado");
                                }
                            }
                        }
                    }
                    case 0 ->
                        System.out.println("Bye");

                    default ->
                        menuInvalido();

                }
            }
            catch (NumberFormatException numberFormatException){
                System.out.println("ERRO - O número não foi selecionado de forma correta");
            }
            catch (CredencialMedicoException credencialMedicoException) {
                System.out.println("ERRO - Não existe credencial para Medico");
            }
            catch (CredencialAdmException credencialAdmException) {
                System.out.println("ERRO - Não existe credencial para Administrador");
            }
            catch (CredencialRecepcionistaException credencialRecepcionistaException){
                System.out.println("ERRO - Não existe credencial para Recepcionista");
            }
            catch (InputMismatchException inputMismatchException){
                System.out.println("ERRO - Valor incorreto");
            }
            catch (NoSuchElementException noSuchElementException){
                System.out.println("ERRO - Sem paciente na fila");
            }
        }
    }

    //menu inicial
    public static int menuGeral(){
        int aux = 1;
        int result = 10;

        while(aux != 0) {
            System.out.println("\n=============================");
            System.out.println("||  1 - Administrador      ||");
            System.out.println("||  2 - Medico             ||");
            System.out.println("||  3 - Recepcionista      ||");
            System.out.println("||  0 - Sair do sistema    ||");
            System.out.println("=============================");
            try{
                result = in.nextInt();
                aux = 0;
            }
            catch (NumberFormatException numberFormatException){
                System.out.println("Numero invalido");
            }
        }
        return result;
    }

    //Administraçao
    public static int menuADM(){

        int aux = 1;
        int result = 10;

        while(aux != 0){
            System.out.println("\n=============================================");
            System.out.println("||  1 - Adimitir funcionario               ||");
            System.out.println("||  2 - Demitir funcionario                ||");
            System.out.println("||  3 - Calcular salario                   ||");
            System.out.println("||  4 - Editar funcionario                 ||");
            System.out.println("||  5 - Visualizar um funcionario          ||");
            System.out.println("||  6 - Visualizar lista de funcionarios   ||");
            System.out.println("||  0 - Voltar                             ||");
            System.out.println("=============================================");
            try{
                result = in.nextInt();
                aux = 0;
            }
            catch (NumberFormatException numberFormatException){
                System.out.println("Numero invalido");
            }
        }
        return result;
    }

    public static int menuCargo(){
        int aux = 1;
        int result = 10;

        while(aux != 0) {
            System.out.println("\n==============================");
            System.out.println("||    1 - Administrador    ||");
            System.out.println("||    2 - Medico            ||");
            System.out.println("||    3 - Recepcionista     ||");
            System.out.println("==============================");
            try{
                result = in.nextInt();
                aux = 0;
            }
            catch (NumberFormatException numberFormatException){
                System.out.println("Numero invalido");
            }
        }

        return result;
    }

    //Medico
    public static int menuMedico(){

        int aux = 1;
        int result = 10;

        while(aux != 0){
            System.out.println("\n======================================================");
            System.out.println("||  1 - Consulta finalizado                         ||");
            System.out.println("||  2 - Exame finalizado                            ||");
            System.out.println("||  3 - Visualizar o proximo paciente para consulta ||");
            System.out.println("||  4 - Visualizar o proximo paciente para exame    ||");
            System.out.println("||  5 - Calcular salario                            ||");
            System.out.println("||  0 - Voltar                                      ||");
            System.out.println("======================================================");
            try{
                result = in.nextInt();
                aux = 0;
            }
            catch (NumberFormatException numberFormatException){
                System.out.println("Numero invalido");
            }
        }
        return result;
    }

    //recepcionista
    public static int menuRecepcionista(){
        int aux = 1;
        int result = 10;

        while(aux != 0) {
            System.out.println("\n======================================================");
            System.out.println("||  1 - Adicionar paciente                          ||");
            System.out.println("||  2 - Excluir paciente                            ||");
            System.out.println("||  3 - Editar paciente                             ||");
            System.out.println("||  4 - Marcar consulta                             ||");
            System.out.println("||  5 - Marcar exame                                ||");
            System.out.println("||  6 - Visualizar o proximo paciente para consulta ||");
            System.out.println("||  7 - Visualizar o proximo paciente para exame    ||");
            System.out.println("||  8 - Visualizar lista de paciente ja cadastrado  ||");
            System.out.println("||  9 - Calcular salario                            ||");
            System.out.println("||  0 - Voltar                                      ||");
            System.out.println("======================================================");
            try{
                result = in.nextInt();
                aux = 0;
            }
            catch (NumberFormatException numberFormatException){
                System.out.println("Numero invalido");
            }
        }
        return result;
    }

    // auxiliares
    public static String menuMatri(){

        System.out.println("Matricula: ");

        return in.nextLine();
    }

    public static void menuInvalido(){
        System.out.println("Opcao invalida");
    }

    public static void menuExame(){
        System.out.println("\n=============================");
        System.out.println("||    1 - Raio-X            ||");
        System.out.println("||    2 - Exame de sangue   ||");
        System.out.println("||    3 - Tomografia        ||");
        System.out.println("==============================");
    }
}
