package api.economias.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.economias.dtos.GanhosDto;
import api.economias.repositories.GanhosRepository;


@Service
public class GanhosService {
    
    @Autowired
    private GanhosRepository ganhoRepository;
    private char tipoMovimentacao = 'E';


    public void inserir_movimentacao_ganho(GanhosDto body){
        ganhoRepository.inserir_movimento_ganho(body.getIdUser(), body.getDescGanho(), body.getValor(), body.getAutoGuardar(), body.getIdCofre());
    }
    
    public List<Object> pesquisar_desc_ganho(Long idUser, String descGanho){
        return ganhoRepository.procurarPorDescGanho(idUser, descGanho);
    }

    public void alterar_dado_movimentacao(Long idUser, GanhosDto body){
        ganhoRepository.alterar_dado_movimentacao(body.getId(), idUser, tipoMovimentacao, body.getValor(), body.getDescGanho());
    }

    public void remover_movimento_entrada(Long idUser, GanhosDto body){
        ganhoRepository.remover_movimento_ganho(body.getId(), idUser, tipoMovimentacao);
    }
}
