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


    public void inserir_movimentacao_ganho(GanhosDto body){
        ganhoRepository.inserir_movimento_ganho(body.getIdUser(), body.getDescGanho(), body.getValor(), body.getIdCategoria(), body.getAutoGuardar(), body.getIdCofre());
    }
    
    public List<Object> pesquisar_categoria(Long idUser, Long idCategoria){
        return ganhoRepository.procurarPorCategorias(idUser, idCategoria);
    }
}
