package Repositorios.impl;

import Entidades.Saidas;
import Repositorios.IRepositorios;

import java.util.ArrayList;
import java.util.List;

public class RepositorioSaidas implements IRepositorios<Saidas> {
    private List<Saidas> listaSaidas = new ArrayList<>();

    @Override
    public void salvar(Saidas entidade) {
        this.listaSaidas.add(entidade);
    }

    @Override
    public void alterar(Saidas entidade) {
        Saidas existente = buscarPorId(entidade.getId());
        if (existente != null) {
            this.listaSaidas.remove(existente);
            this.listaSaidas.add(entidade);
        }
    }

    @Override
    public void deletar(int id) {
        this.listaSaidas.removeIf(entidade -> entidade.getId() == id);
    }

    @Override
    public List<Saidas> listar() {
        return new ArrayList<>(this.listaSaidas);
    }

    @Override
    public Saidas buscarPorId(int id) {
        for (Saidas saida : this.listaSaidas) {
            if (saida.getId() == id) {
                return saida;
            }
        }
        throw new RuntimeException("Saida não encontrada");
    }
}
