package dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public record ServicoDtos
        (@NotBlank String titulo,
        String descricao,
        BigDecimal proposta,
        String status_servico,
        @NotNull UUID id_cliente,
        UUID id_dev){
    public UUID id_erro() {
        return null;
    }
}
