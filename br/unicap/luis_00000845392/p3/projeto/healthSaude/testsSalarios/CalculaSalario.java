package br.unicap.luis_00000845392.p3.projeto.healthSaude.testsSalarios;

import br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.pessoas.funcionario.tipos.ADM;
import br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.pessoas.funcionario.tipos.Medico;
import br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.pessoas.funcionario.tipos.Recepcionista;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class CalculaSalario {

    @Test
    public void calculaSalarioAdm(){
        //Fixture
        String matricula = "M000";
        ADM adm = new ADM(matricula);

        //Metodo Alvo
        double x = adm.calcularSalario(100);

        //Assert
        Assertions.assertEquals(14000, x, 0.0);
    }

    @Test
    public void calculaSalarioMedico(){
        String matricula = "M000";
        Medico medico = new Medico(matricula);

        //Metodo Alvo
        double x = medico.calcularSalario(100);

        //Assert
        Assertions.assertEquals(15000, x, 0.0);
    }

    @Test
    public void calculaSalarioRecepcionista(){
        String matricula = "M000";
        Recepcionista recepcionista = new Recepcionista(matricula);

        //Metodo Alvo
        double x = recepcionista.calcularSalario(100);

        //Assert
        Assertions.assertEquals(13000, x, 0.0);
    }
}
