package challenge.one.foro_hub.repository;

import challenge.one.foro_hub.entity.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

    @Modifying
    @Query("UPDATE Topico t SET t.estado = false WHERE t.id = :id")
    void setEstadoFalseById(Long id);

    Topico findByTitulo(String titulo);
}
