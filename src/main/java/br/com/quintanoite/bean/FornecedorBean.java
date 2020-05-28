package br.com.quintanoite.bean;

import br.com.quintanoite.dao.FornecedorDao;
import br.com.quintanoite.domain.Fornecedor;
import org.omnifaces.util.Messages;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class FornecedorBean implements Serializable {

    private Fornecedor fornecedor;

    public Fornecedor getFornecedor() {
        if(fornecedor == null){
            fornecedor = new Fornecedor();
        }
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    private List<Fornecedor> fornecedores;

    public List<Fornecedor> getFornecedores() {
        return fornecedores;
    }

    public void setFornecedores(List<Fornecedor> fornecedores) {
        this.fornecedores = fornecedores;
    }

    @PostConstruct
    public void listar() {
        try {
            FornecedorDao dao = new FornecedorDao();
            fornecedores = dao.listar();
        }
        catch (RuntimeException e){
            Messages.addGlobalError("Ocorreu um erro ao listar Fornecedor");
            e.printStackTrace();
        }
    }

    public void novo() {
        fornecedor = new Fornecedor();
    }

    public void salvar() {
        try {
            FornecedorDao dao = new FornecedorDao();
            dao.salvar(fornecedor);
            novo();
            Messages.addGlobalError("Fornecedor salvo com sucesso");
        }
        catch (RuntimeException e){
            Messages.addGlobalError("Ocorreu um erro ao salvar Fornecedor");
            e.printStackTrace();
        }
    }
}
