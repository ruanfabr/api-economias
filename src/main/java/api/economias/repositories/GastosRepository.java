package api.economias.repositories;

public interface GastosRepository extends JpaRepository<GastosDto, Long> {

    void inserir_movimento_gasto(){
        // @Param("")
    }
}