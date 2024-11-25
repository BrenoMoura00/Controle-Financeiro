package Repositorios.impl;

import Entidades.Entradas;
import Entidades.Saidas;
import Repositorios.IRepositorios;

import java.util.ArrayList;
import java.util.List;

public class RepositorioSaidas implements IRepositorios<Saidas> {
    private List<Saidas> listaSaidas = new ArrayList<>();

    @Override
    public void salvar(Saidas entidade) {
        listaSaidas.add(entidade);
    }

    @Override
    public void alterar(Saidas entidade) {
        Saidas existente = buscarPorId(entidade.getId());
        if (existente != null) {
            listaSaidas.remove(existente);
            listaSaidas.add(entidade);
        }
    }

    @Override
    public void deletar(int id) {
        listaSaidas.removeIf(entidade -> entidade.getId() == id);
    }

    @Override
    public List<Saidas> listar() {
        return new ArrayList<>(listaSaidas);
    }

    @Override
    public Saidas buscarPorId(int id) {
        for (Saidas saida : listaSaidas) {
            if (saida.getId() == id) {
                return saida;
            }
        }
        throw new RuntimeException("Saida não encontrada");
    }
}
