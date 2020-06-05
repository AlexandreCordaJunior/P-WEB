package br.com.quintanoite.bean;

import br.com.quintanoite.dao.FornecedorDao;
import br.com.quintanoite.dao.FuncionarioDao;
import br.com.quintanoite.dao.ProdutoDao;
import br.com.quintanoite.domain.Fornecedor;
import br.com.quintanoite.domain.Funcionario;
import br.com.quintanoite.domain.Produto;
import br.com.quintanoite.util.JSFUtil;
import org.omnifaces.util.Messages;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class ProdutoBean implements Serializable {

    private List<Produto> produtos;

    public List<Produto> getProdutos() {
        return produtos;
    }

    private Produto produto;

    private String acao;

    private List<Fornecedor> fornecedores;

    public List<Fornecedor> getFornecedores() {
        return fornecedores;
    }

    public void setFornecedores(List<Fornecedor> fornecedores) {
        this.fornecedores = fornecedores;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public Produto getProduto() {
        if(produto == null) produto = new Produto();
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    @PostConstruct
    public void listar() {
        try {
            ProdutoDao dao = new ProdutoDao();
            produtos = dao.listar();
        }
        catch (RuntimeException e){
            Messages.addGlobalError("Ocorreu um erro ao listar Produto");
            e.printStackTrace();
        }
    }

    public void salvar() {
        try {
            ProdutoDao dao = new ProdutoDao();
            dao.salvar(produto);
            novo();
            Messages.addGlobalInfo("Produto salvo com sucesso");
        }
        catch (RuntimeException e){
            Messages.addGlobalError("Ocorreu um erro ao salvar Produto");
            e.printStackTrace();
        }
    }

    public void novo() {
        produto = new Produto();
    }


    public void editar() {
        try {
            ProdutoDao dao = new ProdutoDao();
            dao.editar(produto);
            novo();
            Messages.addGlobalInfo("Produto editado com sucesso");
        }
        catch (RuntimeException e){
            Messages.addGlobalError("Ocorreu um erro ao editar Produto");
            e.printStackTrace();
        }
    }

    public void excluir() {
        try {
            ProdutoDao dao = new ProdutoDao();
            dao.excluir(produto);
            novo();
            Messages.addGlobalInfo("Produto excluido com sucesso");
        }
        catch (RuntimeException e){
            Messages.addGlobalError("Ocorreu um erro ao excluir Produto");
            e.printStackTrace();
        }
    }

    public void carregarCadastro() {
        try {
            acao = JSFUtil.getParam("proacao");
            String valor = JSFUtil.getParam("procod");
            System.out.println(acao);
            if(valor != null) {
                Long codigo = Long.parseLong(valor);
                ProdutoDao dao = new ProdutoDao();
                produto = dao.buscar(codigo);
            }
            else{
                novo();
            }
            FornecedorDao fornecedorDao = new FornecedorDao();
            fornecedores = fornecedorDao.listar();
        }
        catch (RuntimeException e){
            Messages.addGlobalError("Ocorreu um erro ao listar Funcionario");
            e.printStackTrace();
        }
    }
}
