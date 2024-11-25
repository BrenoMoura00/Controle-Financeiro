package Servicos.impl;

import Servicos.IServicoRelatorio;

import java.util.ArrayList;
import java.util.List;

public class ServicoRelatorio implements IServicoRelatorio {
    List<String> listaGastos = new ArrayList<>();
    @Override
    public double calcularTotalEntradas() {

    }

    @Override
    public double calcularTotalSaidas() {
        return 0;
    }

    @Override
    public List<String> listarDescricoesGastos() {
        return
    }

    @Override
    public double calcularSaldoTotal() {
        return 0;
    }
}
