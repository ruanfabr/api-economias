package api.economias.services;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.economias.repositories.GanhosRepository;


@Service
public class GanhosService {
    
    @Autowired
    private GanhosRepository ganhoRepository;

    public void inserir_movimentacao_ganho(Long id_user, String desc_ganho, float valor, Integer id_categoria, int auto_guardar, Integer id_cofre){
        BigDecimal valor_formatado = new BigDecimal(Float.toString(valor));
        valor_formatado = valor_formatado.setScale(2, RoundingMode.HALF_UP);


        ganhoRepository.inserir_movimento_ganho(id_user, desc_ganho, valor_formatado.floatValue(), id_categoria, auto_guardar, id_cofre);
    }
}
