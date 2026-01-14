package api.economias.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.economias.dtos.GastosDto;
import api.economias.repositories.GastosRepository;


@Service
public class GastosService{

    @Autowired
    private GastosRepository repositorio;
    private final char tipoMovimentacao = 'S';

    public void inserir_movimento_gasto(GastosDto body){
        repositorio.inserir_movimento_gasto(body.getIdUser(), body.getDescGasto(), body.getValor(), body.getPago(),
                body.getIdCategoria(), body.getAutoGuardar());
    }

    public List<Object> pesquisarDesc(Long idUser, String descGasto){
        return repositorio.procurarPorCategoria(idUser, descGasto);
    }

    public void alterar_dado_movimentacao(Long idUser, GastosDto body){
        repositorio.alterar_dado_movimentacao(body.getId(), idUser, tipoMovimentacao, body.getValor(), body.getDescGasto());
    }

    public List<GastosDto.SaidaMesAtual> ver_saidas_mes_atual(Long idUser){
        return repositorio.ver_saidas_mes_atual(idUser);
    }

    public void remover_movimento_gasto(GastosDto body){
        repositorio.remover_movimento_gasto(body.getId(), body.getIdUser(), tipoMovimentacao);
    }
}