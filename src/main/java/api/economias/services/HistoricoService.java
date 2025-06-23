package api.economias.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.economias.dtos.HistoricoDto;
import api.economias.repositories.HistoricoRepository;

@Service
public class HistoricoService {
    
    @Autowired
    private HistoricoRepository historicoRepository;

    public List<HistoricoDto> retornarHistorico(){
        List<HistoricoDto> result_query = historicoRepository.findAll();

        return result_query;
    }
}