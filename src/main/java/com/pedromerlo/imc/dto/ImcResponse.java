package com.pedromerlo.imc.dto;

public record ImcResponse(
        double imc,
        String interpretacao,
        double pesoIdeal,
        double alturaCm
) {
}
