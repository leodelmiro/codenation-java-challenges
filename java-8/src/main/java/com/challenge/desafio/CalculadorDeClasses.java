package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

import java.lang.reflect.Field;
import java.math.BigDecimal;

public class CalculadorDeClasses implements Calculavel {

    @Override
    public BigDecimal somar(Object obj) {
        return somarTodosAtributosAnotados(obj, Somar.class);
    }

    @Override
    public BigDecimal subtrair(Object obj) {
        return somarTodosAtributosAnotados(obj, Subtrair.class);
    }

    @Override
    public BigDecimal totalizar(Object obj) {
        BigDecimal total = BigDecimal.ZERO;
        return total.add(somar(obj)).subtract(subtrair(obj));
    }


    private BigDecimal somarTodosAtributosAnotados(Object obj, Class annotation) {
        BigDecimal sum = BigDecimal.ZERO;

        Class c = obj.getClass();
        for (Field f : c.getDeclaredFields()) {
            f.setAccessible(true);
            if (f.isAnnotationPresent(annotation) && f.getType().equals(BigDecimal.class)) {
                try {
                    BigDecimal valorCampo = new BigDecimal(String.valueOf(f.get(obj)));
                    sum = valorCampo.add(sum);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return sum;
    }
}
