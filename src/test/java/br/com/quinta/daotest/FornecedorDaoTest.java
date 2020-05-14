package br.com.quinta.daotest;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.quintanoite.dao.FornecedorDao;
import br.com.quintanoite.domain.Fornecedor;


public class FornecedorDaoTest {
	
	@Test
	@Ignore
	public void salvar() {
		
		Fornecedor fornecedor = new Fornecedor();
		
		fornecedor.setNome("StarVegas");
		
		FornecedorDao fornecedorDao = new FornecedorDao();
		fornecedorDao.salvar(fornecedor);
		
		System.out.print("Fornecedor Salvo com Sucesso");
			
	}
	
	@Test
	//@Ignore
	public void listar() {

		FornecedorDao fornecedorDao = new FornecedorDao();

		List<Fornecedor> resultado = fornecedorDao.listar();

		System.out.println("Total de registros: " + resultado.size());

		for (Fornecedor fornecedor : resultado) {

			System.out.println(fornecedor.getNome());

		}
	}
	@Test
	public void buscar() {

		Long codigo = 2L;

		FornecedorDao fornecedorDao = new FornecedorDao();
		Fornecedor fornecedor = fornecedorDao.buscar(codigo);

		if (fornecedor == null) {

			System.out.println("Nenhum Registro encontrado");

		} else {

			System.out.println("Registro encontrado");
			System.out.println(fornecedor.getNome());

		}

	}
	@Test
	@Ignore
	public void excluir() {

		Long codigo = 2L;

		FornecedorDao fornecedorDao = new FornecedorDao();
		Fornecedor fornecedor = fornecedorDao.buscar(codigo);

		if (fornecedor == null) {

			System.out.println("Nenhum Registro encontrado");

		} else {

			fornecedorDao.excluir(fornecedor);
			System.out.println("Registro encontrado");
			System.out.println(fornecedor.getNome());

		}

	}

	@Test
	@Ignore
	public void editar() {

		Long codigo = 3L;

		FornecedorDao fornecedorDao = new FornecedorDao();
		Fornecedor fornecedor = fornecedorDao.buscar(codigo);

		if (fornecedor == null) {

			System.out.println("Nenhum Registro encontrado");

		} else {

			fornecedor.setNome("NomeNovo");
			fornecedorDao.editar(fornecedor);
			System.out.println("Registro encontrado");
			System.out.println(fornecedor.getNome());
		}
	}
}
