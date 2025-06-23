package api.economias.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import api.economias.dtos.HistoricoDto;


public interface HistoricoRepository extends JpaRepository<HistoricoDto, Long>{
    
}