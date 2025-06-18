package api.economias.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.economias.dtos.GanhosDto;
import api.economias.services.GanhosService;

@RestController
@RequestMapping("/ganhos")
public class GanhosController {
    @Autowired
    private GanhosService ganhosService;

    @PostMapping("/inserir_ganho")
    public ResponseEntity<String> inserir_ganho(@RequestBody GanhosDto body){
        ganhosService.inserir_movimentacao_ganho(body.getId_user(), body.getDesc_ganho(), body.getValor(), body.getId_categoria(), body.getAuto_guardar(), body.getId_cofre());

        return ResponseEntity.status(HttpStatus.OK).body("Inserido com Sucesso!");
    }
}
