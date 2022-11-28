package tests;

import main.br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.pessoas.funcionario.tipos.ADM;
import main.br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.pessoas.funcionario.tipos.Medico;
import main.br.unicap.luis_00000845392.p3.projeto.healthSaude.negocios.pessoas.funcionario.tipos.Recepcionista;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class CalculaSalarioTest {

    @Test
    public void calculaSalarioAdmTest(){
        //Fixture
        String matricula = "M000";
        ADM adm = new ADM(matricula);

        //Metodo Alvo
        double x = adm.calcularSalario(100);

        //Assert
        Assertions.assertEquals(14000, x, 0.0);
    }

    @Test
    public void calculaSalarioMedicoTest(){
        //Fixture
        String matricula = "M000";
        Medico medico = Medico.getInstance(matricula);


        //Metodo Alvo
        double x = medico.calcularSalario(100);

        //Assert
        Assertions.assertEquals(15000, x, 0.0);
    }

    @Test
    public void calculaSalarioRecepcionistaTest(){
        //Fixture
        String matricula = "M000";
        Recepcionista recepcionista = new Recepcionista(matricula);

        //Metodo Alvo
        double x = recepcionista.calcularSalario(100);

        //Assert
        Assertions.assertEquals(13000, x, 0.0);
    }
}
