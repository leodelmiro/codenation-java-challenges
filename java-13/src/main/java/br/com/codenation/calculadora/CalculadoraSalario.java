package br.com.codenation.calculadora;


public class CalculadoraSalario {

    final double SALARIO_MINIMO = 1039.0;
    final double TRIBUTO_INSS_NIVEL1 = 1500.0;
    final double TRIBUTO_INSS_NIVEL2 = 4000.0;
    final double DESCONTO_INSS_NIVEL1 = 0.92;
    final double DESCONTO_INSS_NIVEL2 = 0.91;
    final double DESCONTO_INSS_NIVEL3 = 0.89;
    final double TRIBUTO_IRRF_NIVEL1 = 3000.0;
    final double TRIBUTO_IRRF_NIVEL2 = 6000.0;
    final double DESCONTO_IRRF_NIVEL2 = 0.925;
    final double DESCONTO_IRRF_NIVEL3 = 0.85;

    public int calcularSalarioLiquido(double salarioBase) {
        if (salarioBase < SALARIO_MINIMO) {
            return 0;
        }
        double salarioLiquido = calcularInss(salarioBase);
        if (salarioLiquido > TRIBUTO_IRRF_NIVEL1) {
            salarioLiquido = calcularIrrf(salarioLiquido);
        }
        return Math.toIntExact(Math.round(salarioLiquido));
    }

    private double calcularInss(double salarioBase) {
        if (salarioBase <= TRIBUTO_INSS_NIVEL1) {
            return salarioBase * DESCONTO_INSS_NIVEL1;
        } else if ((salarioBase > TRIBUTO_INSS_NIVEL1) && (salarioBase <= TRIBUTO_INSS_NIVEL2)) {
            return salarioBase * DESCONTO_INSS_NIVEL2;
        } else {
            return salarioBase * DESCONTO_INSS_NIVEL3;
        }
    }

    private double calcularIrrf(double salarioBaseDescontadoInss) {
        if (salarioBaseDescontadoInss <= TRIBUTO_IRRF_NIVEL2) {
            return salarioBaseDescontadoInss * DESCONTO_IRRF_NIVEL2;
        } else {
            return salarioBaseDescontadoInss * DESCONTO_IRRF_NIVEL3;
        }
    }
}
