package Repositorios;

import java.util.List;

public interface IRepositorios<T> {
    void salvar(T entidade);
    void alterar(T entidade);
    void deletar(int id);
    List<T> listar();
    T buscarPorId(int id);
}
