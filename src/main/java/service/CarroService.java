package service;

import dao.ICarroDAO;
import domain.Carro;
import exceptions.DAOException;
import exceptions.MaisDeUmRegistroException;
import exceptions.TableException;
import service.generic.GenericService;

import javax.inject.Inject;

public class CarroService extends GenericService<Carro, Long> implements ICarroService {
    @Inject
    public CarroService(ICarroDAO carroDAO) {
        super(carroDAO);
    }

    @Override
    public Carro buscarPorPlaca(String placa) throws DAOException {
        try {
            return this.dao.consultar(placa);
        } catch (MaisDeUmRegistroException | TableException e) {
            e.printStackTrace();
        }
        return null;
    }

}
