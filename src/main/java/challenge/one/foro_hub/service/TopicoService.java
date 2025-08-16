package challenge.one.foro_hub.service;

import challenge.one.foro_hub.dto.ConsultaTopicoDto;
import challenge.one.foro_hub.dto.RegistroTopicoDto;
import challenge.one.foro_hub.entity.Topico;
import challenge.one.foro_hub.repository.TopicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoService {

    @Autowired
    TopicoRepository repository;

    @Transactional
    public void registrar(RegistroTopicoDto registroTopicoDto) {
        Topico topicoExistente = repository.findByTitulo(registroTopicoDto.titulo());
        if (topicoExistente != null
                && topicoExistente.getTitulo().equals(registroTopicoDto.titulo())) {
            throw new RuntimeException("El topico ya existe");
        }
        repository.save(new Topico(registroTopicoDto));
    }

    public List<ConsultaTopicoDto> listar() {
        List<Topico> topicos = repository.findAll();
        return topicos.stream()
                .map(t -> new ConsultaTopicoDto(
                        t.getTitulo(),
                        t.getMensaje(),
                        t.getFechaCreacion(),
                        t.getAutor(),
                        t.getEstado(),
                        t.getCurso()
                        )
                )
                .toList();
    }

    @Transactional
    public void actualizar(Long id, RegistroTopicoDto registroTopicoDto) {
        Topico topicoExistente = repository.getReferenceById(id);
        // actualizar datos
        if (topicoExistente != null) {
            topicoExistente.setTitulo(registroTopicoDto.titulo());
            topicoExistente.setMensaje(registroTopicoDto.mensaje());
            topicoExistente.setCurso(registroTopicoDto.curso());
            topicoExistente.setAutor(registroTopicoDto.autor());
        }
    }

    public ConsultaTopicoDto detalle(Long id) {
        Topico topico = repository.getReferenceById(id);
        return new ConsultaTopicoDto(topico);
    }

    @Transactional
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
