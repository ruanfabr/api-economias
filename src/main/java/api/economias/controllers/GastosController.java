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

import api.economias.dtos.GastosDto;
import api.economias.services.GastosService;


@RestController
@RequestMapping("/gastos")
@CrossOrigin(origins = "*")
public class GastosController {
    
    @Autowired
    private GastosService gastosService;
    
    @PostMapping("/inserir_gasto")
    public ResponseEntity<String> inserirGasto(@RequestBody GastosDto body){
        gastosService.inserir_movimento_gasto(body);

        return ResponseEntity.status(HttpStatus.CREATED).body("Gasto inserido com Sucesso!");
    }
    
    @GetMapping("/categoria/{id_user}")
    public ResponseEntity<List<Object>> pesquisarPorCategoria(@PathVariable Long id_user, @RequestBody String desc_gasto ){
        List<Object> resultado_pesquisa = gastosService.pesquisarDesc(id_user, desc_gasto);

        return ResponseEntity.status(HttpStatus.FOUND).body(resultado_pesquisa);
    }

    @PostMapping("/alterarMovimentacao/{idUser}")
    public ResponseEntity<String> alterar_dados_movimentacao(@PathVariable Long idUser, @RequestBody GastosDto body){
        gastosService.alterar_dado_movimentacao(idUser, body);

        return ResponseEntity.status(HttpStatus.OK).body("Alterado com Sucesso!");
    }

    @GetMapping("/saidas_mensal/{id_user}")
    public ResponseEntity<List<GastosDto.SaidaMesAtual>> ver_saidas_mes_atual(@PathVariable Long id_user){
        return ResponseEntity.status(HttpStatus.OK).body(gastosService.ver_saidas_mes_atual(id_user));
    }
}