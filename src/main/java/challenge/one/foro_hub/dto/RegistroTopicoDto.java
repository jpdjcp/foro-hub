package challenge.one.foro_hub.dto;

import jakarta.validation.constraints.NotNull;

public record RegistroTopicoDto(
        @NotNull String titulo,
        @NotNull String mensaje,
        @NotNull String curso,
        @NotNull String autor
) {
}
