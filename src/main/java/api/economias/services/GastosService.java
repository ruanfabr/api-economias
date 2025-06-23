package api.economias.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.economias.dtos.GastosDto;
import api.economias.repositories.GastosRepository;


@Service
public class GastosService{

    @Autowired
    private GastosRepository gastosRepository;
    private char tipoMovimentacao = 'S';

    public void inserir_movimento_gasto(GastosDto body){
        gastosRepository.inserir_movimento_gasto(body.getIdUser(), body.getDescGasto(), body.getValor());
    }

    public List<Object> pesquisarDesc(Long idUser, String descGasto){
        return gastosRepository.procurarPorCategoria(idUser, descGasto);
    }

    public void alterar_dado_movimentacao(Long idUser, GastosDto body){
        gastosRepository.alterar_dado_movimentacao(body.getId(), idUser, tipoMovimentacao, body.getValor(), body.getDescGasto());
    }

    public void remover_movimento_gasto(Long idUser, GastosDto body){
        gastosRepository.remover_movimento_gasto(body.getId(), idUser, tipoMovimentacao);
    }
}