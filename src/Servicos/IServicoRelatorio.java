package Servicos;

import java.util.List;

public interface IServicoRelatorio {
    double calcularTotalEntradas();
    double calcularTotalSaidas();
    List<String> listarDescricoesGastos();
    List<String> listarDescricoesEntradas();
    double calcularSaldoTotal();
}
