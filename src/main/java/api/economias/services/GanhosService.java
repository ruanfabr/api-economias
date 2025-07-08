package api.economias.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.economias.dtos.GanhosDto;
import api.economias.repositories.GanhosRepository;


@Service
public class GanhosService {
    
    @Autowired
    private GanhosRepository repositorio;


    public void inserir_movimentacao_ganho(GanhosDto body){
        repositorio.inserir_movimento_ganho(body.getIdUser(), body.getDescGanho(), body.getValor(), body.getAutoGuardar(), body.getIdCofre(), body.getIdCategoria());
    }
    
    public List<Object> pesquisar_desc_ganho(Long idUser, String descGanho){
        System.out.print("\n" + "saporra ta aqui" + "\n" + idUser + "\n" + descGanho + "\n");
        return repositorio.procurarPorDescGanho(idUser, descGanho);
    }

    public void alterar_dado_movimentacao(Long idUser, GanhosDto body){
        repositorio.alterar_dado_movimentacao(body.getId(), idUser, 'E', body.getValor(), body.getDescGanho());
    }

    public List<GanhosDto.EntradaMesAtual> ver_entradas_mes_atual(Long id_user){
        return repositorio.ver_entradas_mes_atual(id_user);
    }
}
