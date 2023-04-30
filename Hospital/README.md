# ProjetoP3

O projeto contem a ideia da dinâmica do sistema de um hospital

Objetos:

Medico, Recepcionista, Administração e Paciente

Funcionalidades do objeto:

Medico: pode realizar consulta e exames, visualiza o proximo a ser atendido da fila do exame e da consulta.

Recepcionista: adiciona, excluir e alterar paciente, marca consulta e exame, visualiza a lista de pacientes e o proximo a ser atendido da fila do exame e da consulta.

Administracao: adicionar, excluir e alterar funcionarios (Há um funcionario master(Matricula M000), que não pode ser excluido(bloqueado por codigo)); calcula salario de cada um funcionario com sua hora extra; visualiza um funcionarios especifico; visualiza a lista de funcionarios.

Paciente: é atendido para consulta e exame (classe sem funcionalidade).

Funcionamento do sistema:

Primeiro menu, você escolhe quem você é: ADM, Medico, Recepcionista.

Caso seja ADM, consegues adicionar funcionario (todos os tipos de funcionarios), excluir funcionarios, alterar dados de funcionarios, atribuir e calcular salario de funcionario, visualizar um funcionario pela sua matricula e a lista de funcionarios.

Caso seja Medico, consegues realizar consulta e exames (tira da fila os pacientes), visualiza o proximo a ser atendido tanto em uma fila quanto na outra.

Caso seja Recepcionista, consegues adicionar, excluir e alterar dados do paciente da lista, adiciona paciente para fila de consulta e exame, visualiza a lista de paciente e quais serao os proximos a serem atendidos na consulta e exame.
