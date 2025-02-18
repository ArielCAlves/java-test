import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import net.jqwik.api.*;
import static org.assertj.core.api.Assertions.assertThat;


class CalculoIMCTest {

    @Test
    void testClassificacaoMagrezaGrave() {
        assertEquals("Magreza grave", CalculoIMC.classificarIMC(15.9));
    }

    @Test
    void testClassificacaoMagrezaModerada() {
        assertEquals("Magreza moderada", CalculoIMC.classificarIMC(16.5));
    }

    @Test
    void testClassificacaoMagrezaLeve() {
        assertEquals("Magreza leve", CalculoIMC.classificarIMC(17.5));
    }

    @Test
    void testClassificacaoSaudavel() {
        assertEquals("Saudável", CalculoIMC.classificarIMC(22.0));
    }

    @Test
    void testClassificacaoSobrepeso() {
        assertEquals("Sobrepeso", CalculoIMC.classificarIMC(27.5));
    }

    @Test
    void testClassificacaoObesidadeGrauI() {
        assertEquals("Obesidade Grau I", CalculoIMC.classificarIMC(32.0));
    }

    @Test
    void testClassificacaoObesidadeGrauII() {
        assertEquals("Obesidade Grau II", CalculoIMC.classificarIMC(37.0));
    }

    @Test
    void testClassificacaoObesidadeGrauIII() {
        assertEquals("Obesidade Grau III", CalculoIMC.classificarIMC(42.0));
    }

    @Test
    void testCalculoIMC() {
        assertEquals(22.86, CalculoIMC.calcularPeso(70, 1.75), 0.01);
    }

    @Test
    void testCalculoIMCComValoresExtremos() {
        assertEquals(53.33, CalculoIMC.calcularPeso(120, 1.50), 0.01);
    }

    @Test
    void testCalculoIMCComAlturaZero() {
        assertThrows(ArithmeticException.class, () -> CalculoIMC.calcularPeso(70, 0));
    }

    @Property
    void imcNuncaDeveSerNegativo(@ForAll @Positive double peso, @ForAll @Positive double altura) {
        double imc = peso / (altura * altura);
        assertThat(imc).isGreaterThanOrEqualTo(0);
    }
}
