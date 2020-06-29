package br.com.suco.doce.mel.bean;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.suco.doce.mel.dao.VendedorDao;
import br.com.suco.doce.mel.model.Vendedor;
import br.com.suco.doce.mel.tx.Transactional;

@Named
@ViewScoped
public class VendedorBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private VendedorDao dao;

	@Inject
	private FacesContext context;

	private Vendedor vendedor = new Vendedor();
	private List<Vendedor> vendedores;

	@Transactional
	public void salvar() {

		if (vendedorExiste(this.vendedor.getMatricula())) {
			this.dao.atualiza(this.vendedor);
			this.vendedores = this.dao.listaTodos();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Vendedor Alterado"));
		} else {
			this.dao.adiciona(this.vendedor);
			this.vendedor = new Vendedor();
			this.vendedores = this.dao.listaTodos();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Vendedor Cadastrado"));
			this.vendedor = new Vendedor();
		}

	}

	private boolean vendedorExiste(String matricula) {
		Vendedor vendedor = this.dao.buscaPorMatricula(matricula);
		if (vendedor != null) {
			return true;
		} else {
			return false;
		}
	}

	public void carregar(Vendedor vendedor) {
		this.vendedor = this.dao.buscaPorMatricula(vendedor.getMatricula());
		this.vendedor.getDataAdmissao().set(this.vendedor.getDataAdmissao().get(Calendar.YEAR),
				 this.vendedor.getDataAdmissao().get(Calendar.MONTH),
				 this.vendedor.getDataAdmissao().get(Calendar.DAY_OF_MONTH) + 1);
	}

	@Transactional
	public void remover(Vendedor vendedor) {
		this.dao.remove(vendedor);
		this.vendedores = this.dao.listaTodos();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Vendedor Removido"));
	}

	/* Get And Set */

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public List<Vendedor> getVendedores() {
		if (this.vendedores == null) {
			this.vendedores = dao.listaTodos();
		}

		return vendedores;
	}

	public void setVendedores(List<Vendedor> vendedores) {
		this.vendedores = vendedores;
	}

}
