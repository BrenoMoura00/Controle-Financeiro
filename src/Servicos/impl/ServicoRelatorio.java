package Servicos.impl;

import Entidades.Entradas;
import Entidades.Saidas;
import Repositorios.impl.RepositorioEntradas;
import Repositorios.impl.RepositorioSaidas;
import Servicos.IServicoRelatorio;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ServicoRelatorio implements IServicoRelatorio {

    private RepositorioEntradas repositorioEntradas;
    private RepositorioSaidas repositorioSaidas;

    List<Saidas> listaGastos = new ArrayList<>();
    List<Entradas> listaEntradas = new ArrayList<>();

    public ServicoRelatorio(RepositorioEntradas repositorioEntradas, RepositorioSaidas repositorioSaidas) {
        this.repositorioEntradas = repositorioEntradas;
        this.repositorioSaidas = repositorioSaidas;
    }

    @Override
    public double calcularTotalEntradas() {
        return repositorioEntradas.listar().stream().mapToDouble(Entradas::getValor).sum();

    }

    @Override
    public double calcularTotalSaidas() {
        return repositorioSaidas.listar().stream().mapToDouble(Saidas::getValor).sum();
    }

    @Override
    public List<String> listarDescricoesGastos() {
        return repositorioSaidas.listar().stream().map(saida -> " (" + saida.getId() + ") " + saida.getDescricao())
                .collect(Collectors.toList());
    }

    @Override
    public List<String> listarDescricoesEntradas() {
        return repositorioEntradas.listar().stream().map(entrada -> " (" + entrada.getId() + ") " + entrada.getDescricao())
                .collect(Collectors.toList());
    }

    @Override
    public double calcularSaldoTotal() {
        return calcularTotalEntradas() - calcularTotalSaidas();
    }
}
