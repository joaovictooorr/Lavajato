package service;

import domain.Carro;
import exceptions.DAOException;
import service.generic.IGenericService;

public interface ICarroService extends IGenericService<Carro, Long> {
    Carro buscarPorPlaca(String placa) throws DAOException;
}
