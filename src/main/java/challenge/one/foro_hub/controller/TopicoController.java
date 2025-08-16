package challenge.one.foro_hub.controller;

import challenge.one.foro_hub.dto.ConsultaTopicoDto;
import challenge.one.foro_hub.dto.RegistroTopicoDto;
import challenge.one.foro_hub.entity.Topico;
import challenge.one.foro_hub.service.TopicoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService service;

    @PostMapping
    public ResponseEntity registrar(@RequestBody @Valid RegistroTopicoDto registroTopicoDto) {
        service.registrar(registroTopicoDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<ConsultaTopicoDto>> listar() {
        List<ConsultaTopicoDto> topicos = service.listar();
        return ResponseEntity.ok(topicos);
    }

    @PutMapping("/{id}")
    public ResponseEntity actualizar(@PathVariable @NotNull Long id,
                                     @RequestBody @Valid RegistroTopicoDto registroTopicoDto) {
        service.actualizar(id, registroTopicoDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultaTopicoDto> detalle(@PathVariable @NotNull Long id) {
        ConsultaTopicoDto consultaTopicoDto = service.detalle(id);
        return ResponseEntity.ok(consultaTopicoDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable @NotNull Long id) {
        service.eliminar(id);
        return ResponseEntity.ok().build();
    }
}
