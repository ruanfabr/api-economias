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

    public void inserir_movimento_gasto(GastosDto body){
        gastosRepository.inserir_movimento_gasto(body.getIdUser(), body.getDescGasto(), body.getValor(), body.getIdCategoria());
    }

    public List<Object> pesquisar_categoria(Long idUser, Long idCategoria){
        return gastosRepository.procurarPorCategoria(idUser, idCategoria);
    }
}