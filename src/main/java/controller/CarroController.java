package controller;

import domain.Carro;
import service.ICarroService;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.Collection;

public class CarroController {
    private static final long serialVersionUID = 8030245985235567808L;

    private Carro carro;

    private Collection<Carro> carros;

    @Inject
    private ICarroService carroService;

    private Boolean isUpdate;

    @PostConstruct
    public void init() {
        try {
            this.isUpdate = false;
            this.carro = new Carro();
            this.carros = carroService.buscarTodos();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar listar os veiculos"));
        }
    }

    public void cancel() {
        try {
            this.isUpdate = false;
            this.carro = new Carro();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar cancelar ação"));
        }

    }

    public void edit(Carro carro) {
        try {
            this.isUpdate = true;
            this.carro = carro;
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar excluir o veiculo"));
        }

    }

    public void delete(Carro carro) {
        try {
            carroService.excluir(carro);
            carros.remove(carro);
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar excluir o cliente"));
        }

    }

    public void add() {
        try {
            carroService.cadastrar(carro);
            this.carros = carroService.buscarTodos();
            this.carro = new Carro();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar criar o cliente"));
        }


    }

    public void update() {
        try {
            carroService.alterar(this.carro);
            cancel();
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Cliente Atualiado com sucesso"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar atualizar o cliente"));
        }

    }

    public Collection<Carro> getClientes() {
        return carros;
    }

    public void setClientes(Collection<Carro> carros) {
        this.carros = carros;
    }

    public Carro getCliente() {
        return carro;
    }

    public void setCliente(Carro cliente) {
        this.carro = carro;
    }

    public Boolean getIsUpdate() {
        return isUpdate;
    }

    public void setIsUpdate(Boolean isUpdate) {
        this.isUpdate = isUpdate;
    }




}
