package com.pedromerlo.imc.service;

import com.pedromerlo.imc.dto.ImcRequest;
import com.pedromerlo.imc.dto.ImcResponse;
import com.pedromerlo.imc.storage.LastResultStorage;
import com.pedromerlo.imc.utils.ImcCalculator;
import org.springframework.stereotype.Service;

@Service
public class ImcService {

    private final LastResultStorage lastResultStorage;

    public ImcService(LastResultStorage lastResultStorage){
        this.lastResultStorage = lastResultStorage;
    }

    public ImcResponse calcularImc(ImcRequest request){
        double alturaCm = ImcCalculator.calcularAlturaCm(request.altura());
        double pesoIdeal = ImcCalculator.calcularPesoIdeal(alturaCm,request.peso());
        double imc = ImcCalculator.calcularImc(request.altura(), request.peso());
        String interpretacao = ImcCalculator.interpretarImc(imc);

        ImcResponse response = new ImcResponse(imc, interpretacao, pesoIdeal, alturaCm);
        lastResultStorage.salvarResult(response);

        return response;
    }

    public ImcResponse obterUltimoResultado(){
        return lastResultStorage.obterUltimoImc();
    }
}
