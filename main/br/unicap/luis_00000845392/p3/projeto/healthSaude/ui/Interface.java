package main.br.unicap.luis_00000845392.p3.projeto.healthSaude.ui;

import main.br.unicap.luis_00000845392.p3.projeto.healthSaude.dados.FacadeDados;
import main.br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.FacadeNegocio;
import main.br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.pessoas.funcionario.gerenciador.*;
import main.br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.exceptions.CredencialAdmException;
import main.br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.exceptions.CredencialMedicoException;
import main.br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.exceptions.CredencialRecepcionistaException;
import main.br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.exceptions.PacienteNoFoundException;
import main.br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.pessoas.funcionario.enums.Cargos;
import main.br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.pessoas.funcionario.enums.Exames;
import main.br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.pessoas.funcionario.tipos.*;
import main.br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.pessoas.paciente.GerenciadorPaciente;
import main.br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.pessoas.paciente.Paciente;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Interface {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Paciente paciente;
        ADM adm;
        Medico medico;
        Recepcionista recepcionista;

        GerenciadorConsulta gerenciadorConsulta = new GerenciadorConsulta();
        GerenciadorExame gerenciadorExame = new GerenciadorExame();
        GerenciadorFuncionario gerenciadorFuncionario = new GerenciadorFuncionario();
        GerenciadorRecepcionista gerenciadorRecepcionista = new GerenciadorRecepcionista();
        GerenciadorADM gerenciadorADM = new GerenciadorADM();
        GerenciadorMedico gerenciadorMedico = new GerenciadorMedico();
        GerenciadorPaciente gerenciadorPaciente = new GerenciadorPaciente();

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

        FacadeNegocio facadeNegocio = new FacadeNegocio(gerenciadorADM, gerenciadorConsulta, gerenciadorExame, gerenciadorFuncionario, gerenciadorMedico,gerenciadorRecepcionista,gerenciadorPaciente);
        FacadeDados facadeDados = new FacadeDados(gerenciadorConsulta, gerenciadorExame, gerenciadorADM ,gerenciadorFuncionario, gerenciadorMedico, gerenciadorPaciente, gerenciadorRecepcionista);
        //criacao de uma credencial funcionario principal
        //inical para adicionar os outros funcionarios
        matricula = "M000";
        adm = new ADM(matricula);
        facadeDados.addFuncionario(adm);
        facadeDados.addAdm(adm);

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
                        if (facadeNegocio.getGerenciadorADM().buscar(adm) == null) {
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

                                                    if (facadeNegocio.buscar(adm) == null) {
                                                        facadeDados.addFuncionario(adm);
                                                        facadeDados.addAdm(adm);
                                                    } else
                                                        System.out.println("Funcionario ja cadastrado");

                                                } else if (opcao1 == Cargos.Medico.Cargo) {

                                                    medico = Medico.getInstance(nome, cpf, telefone, matricula);

                                                    if (facadeNegocio.getGerenciadorFuncionario().buscar(medico) == null) {
                                                        //gerenciadorFuncionario.addFuncionario(medico);
                                                        //gerenciadorMedico.addFuncionario(medico);
                                                        facadeDados.addFuncionario(medico);
                                                        facadeDados.addMedico(medico);
                                                    } else
                                                        System.out.println("Funcionario ja cadastrado");

                                                } else if (opcao1 == Cargos.Recepcionista.Cargo) {

                                                    recepcionista = new Recepcionista(nome, cpf, telefone, matricula);

                                                    if (facadeNegocio.getGerenciadorFuncionario().buscar(recepcionista) == null) {
                                                        //gerenciadorFuncionario.addFuncionario(recepcionista);
                                                        //gerenciadorRecepcionista.addFuncionario(recepcionista);
                                                        facadeDados.addFuncionario(recepcionista);
                                                        facadeDados.addRecepcionista(recepcionista);
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

                                                int x = facadeNegocio.getGerenciadorADM().buscarInt(adm);

                                                if (x != -1) {
                                                    facadeNegocio.getGerenciadorADM().deleteFuncionario(adm, x);
                                                    x = facadeNegocio.getGerenciadorFuncionario().buscarInt(adm);
                                                    facadeNegocio.getGerenciadorFuncionario().deleteFuncionario(adm, x);
                                                } else
                                                    throw new CredencialAdmException();

                                            } else if (opcao1 == Cargos.Medico.Cargo) {
                                                medico = Medico.getInstance(matricula);

                                                int x = facadeNegocio.getGerenciadorMedico().buscarInt(medico);

                                                if (x != -1) {
                                                    facadeNegocio.getGerenciadorMedico().deleteFuncionario(medico, x);
                                                    x = facadeNegocio.getGerenciadorFuncionario().buscarInt(medico);
                                                    facadeNegocio.getGerenciadorFuncionario().deleteFuncionario(medico, x);
                                                } else
                                                    throw new CredencialMedicoException();

                                            } else if (opcao1 == Cargos.Recepcionista.Cargo) {
                                                recepcionista = new Recepcionista(matricula);

                                                int x = facadeNegocio.getGerenciadorRecepcionista().buscarInt(recepcionista);

                                                if (x != -1) {
                                                    facadeNegocio.getGerenciadorRecepcionista().deleteFuncionario(recepcionista, x);
                                                    x = facadeNegocio.getGerenciadorFuncionario().buscarInt(recepcionista);
                                                    facadeNegocio.getGerenciadorFuncionario().deleteFuncionario(recepcionista, x);
                                                } else
                                                    throw new CredencialRecepcionistaException();
                                            }
                                        }
                                        case 3 -> {
                                            double hora, valor;
                                            if (!facadeDados.getGerenciadorADM().getAdms().getAdms().isEmpty()) {
                                                adm = new ADM(matriAux);
                                                int x = facadeNegocio.getGerenciadorADM().buscarInt(adm);
                                                if (x != -1) {
                                                    System.out.println("Hora extra: ");
                                                    hora = in.nextDouble();
                                                    valor = adm.calcularSalario(hora);
                                                    facadeNegocio.getGerenciadorADM().getAdms().getAdms().get(x).setSalario(valor);
                                                    System.out.println("O salario de " + facadeNegocio.getGerenciadorADM().getAdms().getAdms().get(x).getNome() + " é: " + valor);
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

                                                int x = facadeNegocio.getGerenciadorADM().buscarInt(adm);

                                                if (x != -1) {
                                                    System.out.println("Nome: ");
                                                    nome = in.nextLine();
                                                    System.out.println("CPF: ");
                                                    cpf = in.nextLine();
                                                    System.out.println("Telefone: ");
                                                    telefone = in.nextLine();

                                                    facadeNegocio.getGerenciadorADM().getAdms().getAdms().get(x).setNome(nome);
                                                    facadeNegocio.getGerenciadorADM().getAdms().getAdms().get(x).setCpf(cpf);
                                                    facadeNegocio.getGerenciadorADM().getAdms().getAdms().get(x).setTelefone(telefone);

                                                    x = facadeNegocio.getGerenciadorFuncionario().buscarInt(adm);

                                                    facadeNegocio.getGerenciadorFuncionario().getFuncionarios().getFuncionarios().get(x).setNome(nome);
                                                    facadeNegocio.getGerenciadorFuncionario().getFuncionarios().getFuncionarios().get(x).setCpf(cpf);
                                                    facadeNegocio.getGerenciadorFuncionario().getFuncionarios().getFuncionarios().get(x).setTelefone(telefone);
                                                    System.out.println("Atualizado");
                                                }
                                                else
                                                    throw new CredencialAdmException();

                                            } else if (opcao1 == Cargos.Medico.Cargo) {
                                                medico = Medico.getInstance(matricula);
                                                int x = facadeNegocio.getGerenciadorMedico().buscarInt(medico);

                                                if (x != -1) {
                                                    System.out.println("Nome: ");
                                                    nome = in.nextLine();
                                                    System.out.println("CPF: ");
                                                    cpf = in.nextLine();
                                                    System.out.println("Telefone: ");
                                                    telefone = in.nextLine();

                                                    facadeNegocio.getGerenciadorMedico().getMedicos().getMedicos().get(x).setNome(nome);
                                                    facadeNegocio.getGerenciadorMedico().getMedicos().getMedicos().get(x).setCpf(cpf);
                                                    facadeNegocio.getGerenciadorMedico().getMedicos().getMedicos().get(x).setTelefone(telefone);

                                                    x = facadeNegocio.getGerenciadorFuncionario().buscarInt(medico);

                                                    facadeNegocio.getGerenciadorFuncionario().getFuncionarios().getFuncionarios().get(x).setNome(nome);
                                                    facadeNegocio.getGerenciadorFuncionario().getFuncionarios().getFuncionarios().get(x).setCpf(cpf);
                                                    facadeNegocio.getGerenciadorFuncionario().getFuncionarios().getFuncionarios().get(x).setTelefone(telefone);
                                                    System.out.println("Atualizado");

                                                }
                                                else
                                                    throw new CredencialMedicoException();

                                            } else if (opcao1 == Cargos.Recepcionista.Cargo) {
                                                recepcionista = new Recepcionista(matricula);
                                                int x = facadeNegocio.getGerenciadorRecepcionista().buscarInt(recepcionista);

                                                if (x != -1) {
                                                    System.out.println("Nome: ");
                                                    nome = in.nextLine();
                                                    System.out.println("CPF: ");
                                                    cpf = in.nextLine();
                                                    System.out.println("Telefone: ");
                                                    telefone = in.nextLine();

                                                    facadeNegocio.getGerenciadorRecepcionista().getRecepcionistas().getRecepcionistas().get(x).setNome(nome);
                                                    facadeNegocio.getGerenciadorRecepcionista().getRecepcionistas().getRecepcionistas().get(x).setCpf(cpf);
                                                    facadeNegocio.getGerenciadorRecepcionista().getRecepcionistas().getRecepcionistas().get(x).setTelefone(telefone);

                                                    x = facadeNegocio.getGerenciadorFuncionario().buscarInt(recepcionista);

                                                    facadeNegocio.getGerenciadorFuncionario().getFuncionarios().getFuncionarios().get(x).setNome(nome);
                                                    facadeNegocio.getGerenciadorFuncionario().getFuncionarios().getFuncionarios().get(x).setCpf(cpf);
                                                    facadeNegocio.getGerenciadorFuncionario().getFuncionarios().getFuncionarios().get(x).setTelefone(telefone);
                                                    System.out.println("Atualizado");

                                                } else
                                                    throw new CredencialRecepcionistaException();
                                            }

                                        }

                                        case 5 -> {
                                            matricula = menuMatri();
                                            facadeNegocio.getGerenciadorFuncionario().exibirFuncionario(matricula);
                                        }

                                        case 6 ->
                                            facadeNegocio.getGerenciadorFuncionario().exibirLista();

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

                        if (facadeNegocio.getGerenciadorMedico().buscar(medico) == null) {
                           throw new CredencialMedicoException();
                        } else {
                            while (opcao1 != 0) {
                                try {
                                    opcao1 = menuMedico();
                                    switch (opcao1) {
                                        case 1 -> {
                                            facadeNegocio.getGerenciadorConsulta().deleteConsulta();
                                            System.out.println("O paciente foi atendido");
                                        }
                                        case 2 -> {
                                            facadeNegocio.getGerenciadorExame().deleteExame();
                                            System.out.println("O paciente foi atendido");

                                        }
                                        case 3 ->
                                            System.out.println(facadeDados.getGerenciadorConsulta().getFilaDeConsultas().getFilaConsulta().getFirst());

                                        case 4 ->
                                            System.out.println(facadeDados.getGerenciadorExame().getFilaDeExames().getFilaExames().getFirst());
                                        case 5 ->{
                                            double hora, valor;
                                            if (!facadeDados.getGerenciadorMedico().getMedicos().getMedicos().isEmpty()) {
                                                medico = Medico.getInstance(matricula);
                                                int x = facadeNegocio.getGerenciadorMedico().buscarInt(medico);
                                                if (x != -1) {
                                                    System.out.println("Hora extra: ");
                                                    hora = in.nextDouble();
                                                    valor = medico.calcularSalario(hora);
                                                    facadeNegocio.getGerenciadorMedico().getMedicos().getMedicos().get(x).setSalario(valor);
                                                    System.out.println("O salario de " + facadeNegocio.getGerenciadorMedico().getMedicos().getMedicos().get(x).getNome() + " é: " + valor);
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
                        if (facadeNegocio.getGerenciadorRecepcionista().buscar(recepcionista) == null) {
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

                                            if (facadeNegocio.getGerenciadorPaciente().buscar(paciente) == null) {
                                                facadeNegocio.getGerenciadorPaciente().addPaciente(paciente);
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
                                                int x = facadeNegocio.getGerenciadorPaciente().buscarInt(paciente);
                                                if (x == -1)
                                                    System.out.println("Paciente não incluido no sistema");
                                                else
                                                    facadeNegocio.getGerenciadorPaciente().deletePaciente(paciente, x);
                                            }
                                        }
                                        case 3 ->{
                                            System.out.println("CPF: ");
                                            cpf = in.nextLine();
                                            paciente = new Paciente(cpf);
                                            int x = facadeNegocio.getGerenciadorPaciente().buscarInt(paciente);
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

                                                facadeNegocio.getGerenciadorPaciente().getPacientes().getPacientes().get(x).setNome(nome);
                                                facadeNegocio.getGerenciadorPaciente().getPacientes().getPacientes().get(x).setCpf(cpf);
                                                facadeNegocio.getGerenciadorPaciente().getPacientes().getPacientes().get(x).setEndereco(endereco);
                                                facadeNegocio.getGerenciadorPaciente().getPacientes().getPacientes().get(x).setTelefone(telefone);
                                                facadeNegocio.getGerenciadorPaciente().getPacientes().getPacientes().get(x).setNasc(nascimento);
                                            }
                                            else
                                                throw new PacienteNoFoundException();

                                        }
                                        case 4 -> {
                                            System.out.println("CPF do paciente: ");
                                            cpf = in.nextLine();
                                            paciente = new Paciente(cpf);
                                            paciente = facadeNegocio.getGerenciadorPaciente().buscar(paciente);

                                            if (facadeNegocio.getGerenciadorPaciente().buscar(paciente) == null)
                                                System.out.println("Adicione o paciente antes de marcar uma consulta");
                                            else {
                                                facadeDados.addConsulta(paciente);
                                                System.out.println("Adicionado na fila para consulta");
                                            }
                                        }
                                        case 5 -> {
                                            System.out.println("CPF do paciente: ");
                                            cpf = in.nextLine();

                                            paciente = new Paciente(cpf);
                                            paciente = facadeNegocio.getGerenciadorPaciente().buscar(paciente);
                                            Exame exame;

                                            if (paciente != null){
                                                menuExame();
                                                try {
                                                    opcao0 = in.nextInt();
                                                    if (opcao0 == Exames.RaioX.exame) {
                                                        exame = new Exame("Raio-X", paciente.getNome(), paciente.getCpf(), paciente.getTelefone(), paciente.getEndereco(), paciente.getNasc());
                                                        facadeDados.addExame(exame);
                                                        System.out.println("Adicionado na fila para exames");
                                                    } else if (opcao0 == Exames.Sangue.exame) {
                                                        exame = new Exame("de sangue", paciente.getNome(), paciente.getCpf(), paciente.getTelefone(), paciente.getEndereco(), paciente.getNasc());
                                                        facadeDados.addExame(exame);
                                                        System.out.println("Adicionado na fila para exames");
                                                    } else if (opcao0 == Exames.tomografia.exame) {
                                                        exame = new Exame("Tomografia", paciente.getNome(), paciente.getCpf(), paciente.getTelefone(), paciente.getEndereco(), paciente.getNasc());
                                                        facadeDados.addExame(exame);
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
                                            if (!facadeDados.getGerenciadorConsulta().getFilaDeConsultas().getFilaConsulta().isEmpty())
                                                System.out.println(facadeDados.getGerenciadorConsulta().getFilaDeConsultas().getFilaConsulta().getFirst().getNome()+ " " +
                                                        facadeDados.getGerenciadorConsulta().getFilaDeConsultas().getFilaConsulta().getFirst().getNome());
                                            else
                                                System.out.println("Lista de paciente para consulta esta vazia");
                                        }
                                        case 7 -> {
                                            if (!facadeDados.getGerenciadorExame().getFilaDeExames().getFilaExames().isEmpty())
                                                System.out.println(facadeDados.getGerenciadorExame().getFilaDeExames().getFilaExames().getFirst().getNome() + " " +
                                                        facadeDados.getGerenciadorExame().getFilaDeExames().getFilaExames().getFirst().getNasc() + " " +
                                                        facadeDados.getGerenciadorExame().getFilaDeExames().getFilaExames().getFirst().getTipo());
                                            else
                                                System.out.println("Lista de paciente para exame esta vazia");
                                        }
                                        case 8 ->
                                            facadeNegocio.getGerenciadorPaciente().exibirLista();
                                        case 9 ->{
                                            double hora, valor;
                                            if (!facadeDados.getGerenciadorRecepcionista().getRecepcionistas().getRecepcionistas().isEmpty()) {
                                                recepcionista = new Recepcionista(matricula);
                                                int x = facadeNegocio.getGerenciadorRecepcionista().buscarInt(recepcionista);
                                                if (x != -1) {
                                                    System.out.println("Hora extra: ");
                                                    hora = in.nextDouble();
                                                    valor = recepcionista.calcularSalario(hora);
                                                    facadeNegocio.getGerenciadorRecepcionista().getRecepcionistas().getRecepcionistas().get(x).setSalario(valor);
                                                    System.out.println("O salario de " + facadeNegocio.getGerenciadorRecepcionista().getRecepcionistas().getRecepcionistas().get(x).getNome() + " é: " + valor);
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
                System.out.println("ERRO - Não exite credencial para Medico");
            }
            catch (CredencialAdmException credencialAdmException) {
                System.out.println("ERRO - Não exite credencial para Administrador");
            }
            catch (CredencialRecepcionistaException credencialRecepcionistaException){
                System.out.println("ERRO - Não exite credencial para Recepcionista");
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
        Scanner in = new Scanner(System.in);
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
        Scanner in = new Scanner(System.in);

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
        Scanner in = new Scanner(System.in);
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
        Scanner in = new Scanner(System.in);

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
        Scanner in = new Scanner(System.in);
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
        Scanner in = new Scanner(System.in);

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
