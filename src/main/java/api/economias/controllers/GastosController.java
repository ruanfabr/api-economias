package api.economias.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.economias.dtos.GastosDto;
import api.economias.services.GastosService;


@RestController
@RequestMapping("/gastos")
public class GastosController {
    
    @Autowired
    private GastosService gastosService;
    
    @PostMapping("inserir_gasto")
    public ResponseEntity<String> inserirGasto(@RequestBody GastosDto body){
        gastosService.inserir_movimento_gasto(body);

        return ResponseEntity.status(HttpStatus.CREATED).body("Gasto inserido com Sucesso!");
    }
    
}
