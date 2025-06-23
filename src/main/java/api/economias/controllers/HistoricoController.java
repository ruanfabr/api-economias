package api.economias.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.economias.dtos.HistoricoDto;
import api.economias.services.HistoricoService;

@RestController
@RequestMapping("/historico")
public class HistoricoController {
    
    @Autowired
    private HistoricoService historicoService;

    @GetMapping
    public ResponseEntity<List<HistoricoDto>> retornarHistorico(){
        List<HistoricoDto> resultado_lista = historicoService.retornarHistorico();

        return ResponseEntity.status(HttpStatus.OK).body(resultado_lista);
    }

}
