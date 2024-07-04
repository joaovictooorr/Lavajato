package controller;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class IndexController implements Serializable {

    private static final long serialVersionUID = -3176307559028924604L;

    public String goToClientPage() {
        return "/carro/list.xhtml";
    }
}