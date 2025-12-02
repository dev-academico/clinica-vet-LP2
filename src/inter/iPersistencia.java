package inter;

public interface IPersistencia<T> {
    void salvar(T entidade);
    T buscar(int id);
    void remover(int id);
    List<T> listar();
}

// adaptável a quaisquer classe/tipo
// possível usar para impl. repositórios
