package br.unicap.luis_00000845392.p3.projeto.HealthSaude.Aplicação;

import br.unicap.luis_00000845392.p3.projeto.HealthSaude.Exceptions.CredencialAdmException;
import br.unicap.luis_00000845392.p3.projeto.HealthSaude.Exceptions.CredencialMedicoException;
import br.unicap.luis_00000845392.p3.projeto.HealthSaude.Exceptions.CredencialRecepcionistaException;
import br.unicap.luis_00000845392.p3.projeto.HealthSaude.Funcionario.Listas.*;
import br.unicap.luis_00000845392.p3.projeto.HealthSaude.Funcionario.Salario.ISADM;
import br.unicap.luis_00000845392.p3.projeto.HealthSaude.Funcionario.Salario.ISMedico;
import br.unicap.luis_00000845392.p3.projeto.HealthSaude.Funcionario.Salario.ISRecepcionista;
import br.unicap.luis_00000845392.p3.projeto.HealthSaude.Funcionario.Tipos.*;
import br.unicap.luis_00000845392.p3.projeto.HealthSaude.Paciente.ListaDePaciente;
import br.unicap.luis_00000845392.p3.projeto.HealthSaude.Paciente.Paciente;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Interface {
    public static void main(String[] args) throws ParseException {
        Scanner in = new Scanner(System.in);

        Paciente paciente;
        ADM adm;
        Medico medico;
        Recepcionista recepcionista;

        ISADM isadm = new ISADM();
        ISMedico isMedico = new ISMedico();
        ISRecepcionista isRecepcionista = new ISRecepcionista();

        ListaDePaciente listaDePaciente = new ListaDePaciente();
        ListaDeFuncionario listaDeFuncionario = new ListaDeFuncionario();
        ListaDeADM listaDeADM = new ListaDeADM();
        ListaDeMedico listaDeMedico = new ListaDeMedico();
        ListaDeRecepcionista listaDeRecepcionista = new ListaDeRecepcionista();
        ListaDeConsulta listaDeConsulta = new ListaDeConsulta();
        ListaDeExame listaDeExame = new ListaDeExame();

        int opcao0 = 1;
        int opcao1;
        int opcao2;

        String matricula;
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
        listaDeFuncionario.addFuncionario(adm);
        listaDeADM.addFuncionario(adm);

        //intencao de limpar a tela
        for(int i = 0; i < 50; i++){
            System.out.println();
        }
        System.out.println("Welcome to HealthSaude");

        while (opcao0 != 0) {
            try {
                opcao0 = menuGeral();

                switch (opcao0) {
                    case 1 -> {
                        opcao1 = 1;
                        opcao2 = 1;
                        matricula = menuMatri();
                        adm = new ADM(matricula);
                        if (listaDeADM.buscar(adm) == null) {
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

                                                    if (listaDeFuncionario.buscar(adm) == null) {
                                                        listaDeFuncionario.addFuncionario(adm);
                                                        listaDeADM.addFuncionario(adm);
                                                    } else
                                                        System.out.println("Funcionario ja cadastrado");

                                                } else if (opcao1 == Cargos.Medico.Cargo) {

                                                    medico = new Medico(nome, cpf, telefone, matricula);

                                                    if (listaDeFuncionario.buscar(medico) == null) {
                                                        listaDeFuncionario.addFuncionario(medico);
                                                        listaDeMedico.addFuncionario(medico);
                                                    } else
                                                        System.out.println("Funcionario ja cadastrado");

                                                } else if (opcao1 == Cargos.Recepcionista.Cargo) {

                                                    recepcionista = new Recepcionista(nome, cpf, telefone, matricula);

                                                    if (listaDeFuncionario.buscar(recepcionista) == null) {
                                                        listaDeFuncionario.addFuncionario(recepcionista);
                                                        listaDeRecepcionista.addFuncionario(recepcionista);
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

                                                int x = listaDeADM.buscarInt(adm);

                                                if (x != -1) {
                                                    listaDeFuncionario.deleteFuncionario(adm, x);
                                                    listaDeADM.deleteFuncionario(adm, x);
                                                } else
                                                    throw new CredencialAdmException();

                                            } else if (opcao1 == Cargos.Medico.Cargo) {
                                                medico = new Medico(matricula);
                                                int x = listaDeMedico.buscarInt(medico);

                                                if (x != -1) {
                                                    listaDeFuncionario.deleteFuncionario(medico, x);
                                                    listaDeMedico.deleteFuncionario(medico, x);

                                                } else
                                                    throw new CredencialMedicoException();

                                            } else if (opcao1 == Cargos.Recepcionista.Cargo) {
                                                recepcionista = new Recepcionista(matricula);
                                                int x = listaDeRecepcionista.buscarInt(recepcionista);

                                                if (x != -1) {
                                                    listaDeFuncionario.deleteFuncionario(recepcionista, x);
                                                    listaDeRecepcionista.deleteFuncionario(recepcionista, x);
                                                } else
                                                    throw new CredencialRecepcionistaException();
                                            }
                                        }
                                        case 3 -> {
                                            while (opcao2 != 0) {
                                                double hora, valor;
                                                try {
                                                    opcao2 = menuSalario();
                                                    if (opcao2 == 0)
                                                        break;
                                                    matricula = menuMatri();
                                                    switch (opcao2) {
                                                        case 1 -> {
                                                            if (!listaDeADM.getAdms().isEmpty()) {
                                                                adm = new ADM(matricula);
                                                                int x = listaDeADM.buscarInt(adm);
                                                                if (x != -1) {
                                                                    System.out.println("Hora extra: ");
                                                                    hora = in.nextDouble();
                                                                    valor = isadm.calcularSalario(hora);
                                                                    listaDeADM.getAdms().get(x).setSalario(valor);
                                                                    System.out.println("O salario de " + listaDeADM.getAdms().get(x).getNome() + " é: " + valor);
                                                                } else
                                                                    throw new CredencialAdmException();
                                                            } else
                                                                System.out.println("Lista de administraçao esta vazia para calcular o salario");
                                                        }
                                                        case 2 -> {
                                                            if (!listaDeMedico.getMedicos().isEmpty()) {
                                                                medico = new Medico(matricula);
                                                                int x = listaDeMedico.buscarInt(medico);
                                                                if (x != -1) {
                                                                    System.out.println("Hora extra: ");
                                                                    hora = in.nextDouble();
                                                                    valor = isMedico.calcularSalario(hora);
                                                                    listaDeMedico.getMedicos().get(x).setSalario(valor);
                                                                    System.out.println("O salario de " + listaDeMedico.getMedicos().get(x).getNome() + " é: " + valor);
                                                                } else
                                                                    throw new CredencialMedicoException();
                                                            } else
                                                                System.out.println("Lista de medico esta vazia para calcular o salario");
                                                        }
                                                        case 3 -> {
                                                            if (!listaDeRecepcionista.getRecepcionistas().isEmpty()) {
                                                                recepcionista = new Recepcionista(matricula);
                                                                int x = listaDeRecepcionista.buscarInt(recepcionista);
                                                                if (x != -1) {
                                                                    System.out.println("Hora extra: ");
                                                                    hora = in.nextDouble();
                                                                    valor = isRecepcionista.calcularSalario(hora);
                                                                    listaDeRecepcionista.getRecepcionistas().get(x).setSalario(valor);
                                                                    System.out.println("O salario de " + listaDeRecepcionista.getRecepcionistas().get(x).getNome() + " é: " + valor);
                                                                }
                                                            } else
                                                                throw new CredencialRecepcionistaException();
                                                        }
                                                    }
                                                } catch (CredencialMedicoException credencialMedicoException) {
                                                    System.out.println("ERRO - Não exite credencial para Medico");
                                                } catch (CredencialAdmException credencialAdmException) {
                                                    System.out.println("ERRO - Não exite credencial para Adm");
                                                } catch (CredencialRecepcionistaException credencialRecepcionistaException) {
                                                    System.out.println("ERRO - Não exite credencial para Recepcionista");
                                                }
                                            }
                                        }
                                        case 4 -> {
                                            System.out.println("Cargo: ");
                                            opcao1 = menuCargo();
                                            matricula = menuMatri();

                                            if (opcao1 == Cargos.ADM.Cargo) {
                                                adm = new ADM(matricula);

                                                int x = listaDeADM.buscarInt(adm);

                                                if (x != -1) {
                                                    System.out.println("Nome: ");
                                                    nome = in.nextLine();
                                                    System.out.println("CPF: ");
                                                    cpf = in.nextLine();
                                                    System.out.println("Telefone: ");
                                                    telefone = in.nextLine();

                                                    listaDeADM.getAdms().get(x).setNome(nome);
                                                    listaDeADM.getAdms().get(x).setCpf(cpf);
                                                    listaDeADM.getAdms().get(x).setTelefone(telefone);

                                                    x = listaDeFuncionario.buscarInt(adm);

                                                    listaDeFuncionario.getFuncionarios().get(x).setNome(nome);
                                                    listaDeFuncionario.getFuncionarios().get(x).setCpf(cpf);
                                                    listaDeFuncionario.getFuncionarios().get(x).setTelefone(telefone);
                                                    System.out.println("Atualizado");
                                                }
                                                else
                                                    throw new CredencialAdmException();

                                            } else if (opcao1 == Cargos.Medico.Cargo) {
                                                medico = new Medico(matricula);
                                                int x = listaDeMedico.buscarInt(medico);

                                                if (x != -1) {
                                                    System.out.println("Nome: ");
                                                    nome = in.nextLine();
                                                    System.out.println("CPF: ");
                                                    cpf = in.nextLine();
                                                    System.out.println("Telefone: ");
                                                    telefone = in.nextLine();

                                                    listaDeMedico.getMedicos().get(x).setNome(nome);
                                                    listaDeMedico.getMedicos().get(x).setCpf(cpf);
                                                    listaDeMedico.getMedicos().get(x).setTelefone(telefone);

                                                    x = listaDeFuncionario.buscarInt(medico);

                                                    listaDeFuncionario.getFuncionarios().get(x).setNome(nome);
                                                    listaDeFuncionario.getFuncionarios().get(x).setCpf(cpf);
                                                    listaDeFuncionario.getFuncionarios().get(x).setTelefone(telefone);
                                                    System.out.println("Atualizado");

                                                }
                                                else
                                                    throw new CredencialMedicoException();

                                            } else if (opcao1 == Cargos.Recepcionista.Cargo) {
                                                recepcionista = new Recepcionista(matricula);
                                                int x = listaDeRecepcionista.buscarInt(recepcionista);

                                                if (x != -1) {
                                                    System.out.println("Nome: ");
                                                    nome = in.nextLine();
                                                    System.out.println("CPF: ");
                                                    cpf = in.nextLine();
                                                    System.out.println("Telefone: ");
                                                    telefone = in.nextLine();
                                                    listaDeRecepcionista.getRecepcionistas().get(x).setNome(nome);
                                                    listaDeRecepcionista.getRecepcionistas().get(x).setCpf(cpf);
                                                    listaDeRecepcionista.getRecepcionistas().get(x).setTelefone(telefone);

                                                    x = listaDeFuncionario.buscarInt(recepcionista);

                                                    listaDeFuncionario.getFuncionarios().get(x).setNome(nome);
                                                    listaDeFuncionario.getFuncionarios().get(x).setCpf(cpf);
                                                    listaDeFuncionario.getFuncionarios().get(x).setTelefone(telefone);
                                                    System.out.println("Atualizado");

                                                } else
                                                    throw new CredencialRecepcionistaException();
                                            }

                                        }

                                        case 5 -> {
                                            matricula = menuMatri();
                                            listaDeFuncionario.exibirFuncionario(matricula);
                                        }

                                        case 6 ->
                                            listaDeFuncionario.exibirLista();

                                    }
                                }
                                catch (InputMismatchException inputMismatchException){
                                    System.out.println("ERRO - Valor incorreto");
                                }
                            }
                        }
                    }
                    case 2 -> {
                        opcao0 = 1;
                        opcao1 = 1;
                        matricula = menuMatri();
                        medico = new Medico(matricula);
                        if (listaDeMedico.buscar(medico) == null) {
                           throw new CredencialMedicoException();
                        } else {
                            while (opcao1 != 0) {
                                try {
                                    opcao1 = menuMedico();
                                    switch (opcao1) {
                                        case 1 -> {
                                            listaDeConsulta.deleteConsulta();
                                            System.out.println("O paciente foi atendido");
                                        }
                                        case 2 -> {
                                            listaDeExame.deleteExame();
                                            System.out.println("O paciente foi atendido");

                                        }
                                        case 3 ->
                                            System.out.println(listaDeConsulta.getListaDeConsultas().getFirst());

                                        case 4 ->
                                            System.out.println(listaDeExame.getListaDeExames().getFirst());

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
                    case 3 -> {
                        opcao0 = 1;
                        opcao1 = 1;
                        matricula = menuMatri();
                        recepcionista = new Recepcionista(matricula);
                        if (listaDeRecepcionista.buscar(recepcionista) == null) {
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

                                            if (listaDePaciente.buscar(paciente) == null) {
                                                listaDePaciente.addPaciente(paciente);
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
                                                int x = listaDePaciente.buscarInt(paciente);
                                                if (x != -1) {
                                                    System.out.println("Paciente não incluido no sistema");
                                                } else {
                                                    listaDePaciente.deletePaciente(paciente, x);
                                                }
                                            }
                                        }
                                        case 3 ->{
                                            System.out.println("CPF: ");
                                            cpf = in.nextLine();
                                            paciente = new Paciente(cpf);
                                            paciente = listaDePaciente.buscar(paciente);
                                            if(paciente != null){
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

                                                paciente.setNome(nome);
                                                paciente.setCpf(cpf);
                                                paciente.setEndereco(endereco);
                                                paciente.setTelefone(telefone);
                                                paciente.setNasc(nascimento);
                                            }

                                        }
                                        case 4 -> {
                                            System.out.println("Nome do paciente: ");
                                            nome = in.nextLine();
                                            System.out.println("CPF do paciente: ");
                                            cpf = in.nextLine();
                                            paciente = new Paciente(nome, cpf);

                                            if (listaDePaciente.buscar(paciente) == null) {
                                                System.out.println("Adicione o paciente antes de marcar uma consulta");
                                            } else {
                                                listaDeConsulta.addConsulta(paciente);
                                                System.out.println("Adicionado na fila para consulta");
                                            }
                                        }
                                        case 5 -> {
                                            System.out.println("Nome do paciente: ");
                                            nome = in.nextLine();
                                            System.out.println("CPF do paciente: ");
                                            cpf = in.nextLine();
                                            paciente = new Paciente(nome, cpf);

                                            if (listaDePaciente.buscar(paciente) == null) {
                                                System.out.println("Adicione o paciente antes de marcar um exame");
                                            } else {
                                                listaDeExame.addExame(paciente);
                                                System.out.println("Adicionado na fila para exames");
                                            }
                                        }
                                        case 6 -> {
                                            if (!listaDeConsulta.getListaDeConsultas().isEmpty())
                                                System.out.println(listaDeConsulta.getListaDeConsultas().getFirst());
                                            else
                                                System.out.println("Lista de paciente para consulta esta vazia");
                                        }
                                        case 7 -> {
                                            if (!listaDeExame.getListaDeExames().isEmpty())
                                                System.out.println(listaDeExame.getListaDeExames().getFirst());
                                            else
                                                System.out.println("Lista de paciente para exame esta vazia");
                                        }
                                        case 8 ->
                                            listaDePaciente.exibirLista();

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
                System.out.println("ERRO - Não exite credencial para Adm");
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
            System.out.println("||  1 - Administração      ||");
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

    public static int menuSalario(){
        Scanner in = new Scanner(System.in);

        int aux = 1;
        int result = 10;

        while(aux != 0){
            System.out.println("\n====================================");
            System.out.println("||  1 - Salario de Administração  ||");
            System.out.println("||  2 - Salario de Medico         ||");
            System.out.println("||  3 - Salario de Recepcionista  ||");
            System.out.println("||  0 - Voltar                    ||");
            System.out.println("====================================");
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
            System.out.println("||    1 - Administração     ||");
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
}
