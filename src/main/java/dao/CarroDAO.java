package dao;

import dao.generic.GenericDAO;
import domain.Carro;

public class CarroDAO extends GenericDAO<Carro, Long> implements ICarroDAO{

    public CarroDAO() {
        super(Carro.class);
    }
}
