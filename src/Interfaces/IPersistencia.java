package Interfaces;

public interface IPersistencia<T> {
    void salvar(T entidade);
    T buscar(int id);
    void remover(int id);
    void listar();
}