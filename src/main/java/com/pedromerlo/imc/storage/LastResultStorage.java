package com.pedromerlo.imc.storage;

import com.pedromerlo.imc.dto.ImcResponse;
import org.springframework.stereotype.Component;

@Component
public class LastResultStorage {

    private ImcResponse lastResult;

    public void salvarResult(ImcResponse response){
        this.lastResult = response;
    }

    public ImcResponse obterUltimoImc(){
        return lastResult;
    }
}
