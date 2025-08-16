package challenge.one.foro_hub.entity;

import challenge.one.foro_hub.dto.RegistroTopicoDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name = "Topico")
@Table(name = "topicos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    private String autor;
    private Boolean estado;
    private String curso;

    public Topico(RegistroTopicoDto topicoDto) {
        this.titulo = topicoDto.titulo();
        this.mensaje = topicoDto.mensaje();
        this.fechaCreacion = LocalDateTime.now();
        this.autor = topicoDto.autor();
        this.estado = true;
        this.curso = topicoDto.curso();
    }
}
