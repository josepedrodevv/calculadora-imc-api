package com.pedromerlo.imc.utils;

public class ImcCalculator {

    public static double calcularAlturaCm(double alturaM){
        return alturaM * 100;
    }

    public static double calcularPesoIdeal(double alturaCm, double pesoKg){
        double pesoIdeal = (alturaCm - 100) - ((alturaCm - pesoKg) / 4 ) * ( 5.0 / 100);
        return pesoIdeal;
    }

    public static double calcularImc(double alturaM, double pesoKg){
        double imc = pesoKg / Math.pow(alturaM, 2);
        return imc;
    }

    public static String interpretarImc(double imc){
        if(imc < 20 ){
          return "Baixo peso";
        }
        if(imc < 25 ){
         return "Normal";
        }
        if(imc <= 30){
         return "Acima do peso";
        }

        return "Obeso";

    }

}
