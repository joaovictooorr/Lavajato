package service.generic;

import domain.Persistente;
import exceptions.DAOException;
import exceptions.TableException;
import exceptions.TipoChaveNaoEncontradaException;
import exceptions.MaisDeUmRegistroException;

import java.io.Serializable;
import java.util.Collection;

public interface IGenericService  <T extends Persistente, E extends Serializable>{
    public T cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException;
    public void excluir(T entity) throws DAOException;
    public T alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException;
    public T consultar(E valor) throws MaisDeUmRegistroException, TableException, DAOException;
    public Collection<T> buscarTodos() throws DAOException;

}
