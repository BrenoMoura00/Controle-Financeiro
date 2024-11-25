package Repositorios.impl;

import Entidades.Entradas;
import Repositorios.IRepositorios;

import java.util.ArrayList;
import java.util.List;

public class RepositorioEntradas implements IRepositorios<Entradas> {
    private List<Entradas> listaEntradas = new ArrayList<>();

    @Override
    public void salvar(Entradas entidade) {
        this.listaEntradas.add(entidade);
    }

    @Override
    public void alterar(Entradas entidade) {
        Entradas existente = buscarPorId(entidade.getId());
        if (existente != null) {
            this.listaEntradas.remove(existente);
            this.listaEntradas.add(entidade);
        }
    }

    @Override
    public void deletar(int id) {
        this.listaEntradas.removeIf(entidade -> entidade.getId() == id);
    }

    @Override
    public List<Entradas> listar() {
        return new ArrayList<>(this.listaEntradas);
    }

    @Override
    public Entradas buscarPorId(int id) {
        for (Entradas entrada : this.listaEntradas) {
            if (entrada.getId() == id) {
                return entrada;
            }
        }
        throw new RuntimeException("Entrada não encontrada");
    }
}
