package com.pedromerlo.imc.controller;

import com.pedromerlo.imc.dto.ImcRequest;
import com.pedromerlo.imc.dto.ImcResponse;
import com.pedromerlo.imc.service.ImcService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/imc")
public class ImcController {

    private final ImcService imcService;

    public ImcController(ImcService imcService){
        this.imcService = imcService;
    }

    @PostMapping("/calcular")
    public ResponseEntity<ImcResponse> calcular(@RequestBody ImcRequest request){
        return ResponseEntity.ok(imcService.calcularImc(request));
    }

    @GetMapping("/ultimo-resultado")
    public ResponseEntity<ImcResponse> obterUltimoResultado(){
        ImcResponse ultimoResultado = imcService.obterUltimoResultado();
        if(ultimoResultado == null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(imcService.obterUltimoResultado());
    }
}
