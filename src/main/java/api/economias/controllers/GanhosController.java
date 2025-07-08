package api.economias.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.economias.dtos.GanhosDto;
import api.economias.services.GanhosService;

@RestController
@RequestMapping("/ganhos")
@CrossOrigin(origins = "*")
public class GanhosController {
    @Autowired
    private GanhosService ganhosService;

    @PostMapping("/inserir_ganho")
    public ResponseEntity<String> inserir_ganho(@RequestBody GanhosDto body){
        ganhosService.inserir_movimentacao_ganho(body);
        
        return ResponseEntity.status(HttpStatus.OK).body("Inserido com Sucesso!");
    }

    @GetMapping("/categoria/{id_user}/{id_categoria}")
    public ResponseEntity<List<Object>> pesquisarDesc(@PathVariable Long id_user, @PathVariable String id_categoria){
        List<Object> resultado_pesquisa  = ganhosService.pesquisar_desc_ganho(id_user, id_categoria);

        return ResponseEntity.status(HttpStatus.OK).body(resultado_pesquisa);
    }

    @PostMapping("/alterar/{idUser}")
    public ResponseEntity<String> alterar_dados_movimentacao(@PathVariable Long idUser, @RequestBody GanhosDto body){
        ganhosService.alterar_dado_movimentacao(idUser, body);

        return ResponseEntity.status(HttpStatus.OK).body("Alterado com Sucesso!");
    }

    @GetMapping("/entrada_mensal/{id_user}")
    public ResponseEntity<List<GanhosDto.EntradaMesAtual>> ver_entradas_mes_atual(@PathVariable Long id_user){
        return ResponseEntity.status(HttpStatus.OK).body(ganhosService.ver_entradas_mes_atual(id_user));
    }
}
