package challenge.one.foro_hub.dto;

import challenge.one.foro_hub.entity.Topico;
import com.fasterxml.jackson.annotation.JsonAlias;
import java.time.LocalDateTime;

public record ConsultaTopicoDto(
        String titulo,
        String mensaje,
        @JsonAlias("fecha_creacion")
        LocalDateTime fechaCreacion,
        String autor,
        Boolean estado,
        String curso
) {
    public ConsultaTopicoDto(Topico topico) {
        this(topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(), topico.getAutor(), topico.getEstado(), topico.getCurso());
    }
}
