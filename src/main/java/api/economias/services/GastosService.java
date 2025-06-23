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
        gastosRepository.inserir_movimento_gasto(body.getIdUser(), body.getDescGasto(), body.getValor());
    }

    public List<Object> pesquisarDesc(Long idUser, String descGasto){
        return gastosRepository.procurarPorCategoria(idUser, descGasto);
    }

    public void alterar_dado_movimentacao(Long idUser, GastosDto body){
        System.out.printf("\n" + body.getId() + "\n" + idUser + "\n" + 'S' + "\n" + body.getValor() + "\n" + body.getDescGasto());

        try {
            
            gastosRepository.alterar_dado_movimentacao(body.getId(), idUser, 'S', body.getValor(), body.getDescGasto());

        } catch (Exception e) {
            System.out.printf("deu 2\n" + e);
            
        }
    }
}