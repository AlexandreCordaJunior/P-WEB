package br.com.quintanoite.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.quintanoite.util.HibernateUtil;

public class GenericDao<Entidade> {

	private Class<Entidade> classe;

	public GenericDao() {
		this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	public void salvar(Entidade entidade) {

		Session session = HibernateUtil.getFabricaDeSessoes().openSession();

		Transaction transacao = null;

		try {

			transacao = session.beginTransaction();

			session.save(entidade);

			transacao.commit();

		} catch (RuntimeException erro) {

			if (transacao != null) {

				transacao.rollback();
			}
			throw erro;

		} finally {

			session.close();
		}
	}

	public List<Entidade> listar() {

		Session session = HibernateUtil.getFabricaDeSessoes().openSession();

		try {

			Criteria consulta = session.createCriteria(classe);

			List<Entidade> resultado = consulta.list();

			return resultado;

		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			session.close();
		}

	}

	public Entidade buscar(long codigo) {

		Session session = HibernateUtil.getFabricaDeSessoes().openSession();

		try {

			Criteria consulta = session.createCriteria(classe);

			consulta.add(Restrictions.idEq(codigo));

			Entidade resultado = (Entidade) consulta.uniqueResult();

			return resultado;

		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			session.close();
		}
	}

	public void excluir(Entidade entidade) {

		Session session = HibernateUtil.getFabricaDeSessoes().openSession();

		Transaction transacao = null;

		try {

			transacao = session.beginTransaction();

			session.delete(entidade);

			transacao.commit();

		} catch (RuntimeException erro) {

			if (transacao != null) {

				transacao.rollback();
			}
			throw erro;

		} finally {

			session.close();
		}
	}
public void editar(Entidade entidade) {
		
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		
		Transaction transacao = null;
		
		try {
		
			transacao = session.beginTransaction();
			
			session.update(entidade);
			
			transacao.commit();
			
		}catch (RuntimeException erro) {
			
		
			if(transacao != null) {
				
			
				transacao.rollback();
			}throw erro;

		} finally {

			session.close();
		}
	}
}
