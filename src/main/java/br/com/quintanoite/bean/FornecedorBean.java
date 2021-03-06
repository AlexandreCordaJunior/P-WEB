package br.com.quintanoite.bean;

import br.com.quintanoite.dao.FornecedorDao;
import br.com.quintanoite.domain.Fornecedor;
import br.com.quintanoite.util.JSFUtil;
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

    private String acao;

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
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

    public void carregarCadastro() {
        try {
            acao = JSFUtil.getParam("foracao");
            String valor = JSFUtil.getParam("forcad");
            if(valor != null) {
                Long codigo = Long.parseLong(valor);
                FornecedorDao dao = new FornecedorDao();
                fornecedor = dao.buscar(codigo);
            }
            else{
                novo();
            }
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
            Messages.addGlobalInfo("Fornecedor salvo com sucesso");
        }
        catch (RuntimeException e){
            Messages.addGlobalError("Ocorreu um erro ao salvar Fornecedor");
            e.printStackTrace();
        }
    }

    public void excluir() {
        try {
            FornecedorDao dao = new FornecedorDao();
            dao.excluir(fornecedor);
            novo();
            Messages.addGlobalInfo("Fornecedor excluido com sucesso");
        }
        catch (RuntimeException e){
            Messages.addGlobalError("Ocorreu um erro ao excluir Fornecedor");
            e.printStackTrace();
        }
    }

    public void editar() {
        try {
            FornecedorDao dao = new FornecedorDao();
            dao.editar(fornecedor);
            novo();
            Messages.addGlobalInfo("Fornecedor editado com sucesso");
        }
        catch (RuntimeException e){
            Messages.addGlobalError("Ocorreu um erro ao editar Fornecedor");
            e.printStackTrace();
        }
    }
}
