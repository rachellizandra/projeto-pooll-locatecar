package classes.locacao;

import java.time.LocalDateTime;

public class Validacao {
    public void validarData(LocalDateTime dataDevolucao, LocalDateTime dataLocacao) {
        if (dataDevolucao.isBefore(dataLocacao)) {
            throw new IllegalArgumentException("A data de devolução deve ser posterior à data de locação");
        }
    }
}
