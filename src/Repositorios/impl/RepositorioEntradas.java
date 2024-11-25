package Repositorios.impl;

import Entidades.Entradas;
import Repositorios.IRepositorios;

import java.util.ArrayList;
import java.util.List;

public class RepositorioEntradas implements IRepositorios<Entradas> {
    private List<Entradas> listaEntradas = new ArrayList<>();

    @Override
    public void salvar(Entradas entidade) {
        listaEntradas.add(entidade);
    }

    @Override
    public void alterar(Entradas entidade) {
        Entradas existente = buscarPorId(entidade.getId());
        if (existente != null) {
            listaEntradas.remove(existente);
            listaEntradas.add(entidade);
        }
    }

    @Override
    public void deletar(int id) {
        listaEntradas.removeIf(entidade -> entidade.getId() == id);
    }

    @Override
    public List<Entradas> listar() {
        return new ArrayList<>(listaEntradas);
    }

    @Override
    public Entradas buscarPorId(int id) {
        for (Entradas entrada : listaEntradas) {
            if (entrada.getId() == id) {
                return entrada;
            }
        }
        throw new RuntimeException("Entrada não encontrada");
    }
}
