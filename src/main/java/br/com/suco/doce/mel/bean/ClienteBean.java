package br.com.suco.doce.mel.bean;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.suco.doce.mel.dao.ClienteDao;
import br.com.suco.doce.mel.model.Cliente;
import br.com.suco.doce.mel.tx.Transactional;
import br.com.suco.doce.mel.util.CepValidatorUtil;
import br.com.suco.doce.mel.util.CpfValidatorUtil;

@Named
@ViewScoped
public class ClienteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ClienteDao dao;

	private Cliente cliente = new Cliente();
	private CpfValidatorUtil validatorCpf;
	private CepValidatorUtil validatorCep;
	private List<Cliente> clientes;

	public void calcularIdade() {

		int anoNascimento = this.cliente.getDataNascimento().get(Calendar.YEAR);

		if (anoNascimentoValido(anoNascimento)) {
			int idade = Calendar.getInstance().get(Calendar.YEAR) - anoNascimento;
			this.cliente.setIdade(idade);
		}
	}

	private boolean anoNascimentoValido(int ano) {
		return String.valueOf(ano).length() == 4;
	}

	@Transactional
	public void salvar() {

		removeMaskFormatterFormAll();

		if (clienteExiste(this.cliente.getCpf())) {
			this.dao.atualiza(this.cliente);
			this.clientes = this.dao.listaTodos();			
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Cliente Alterado"));
		} else {
			this.dao.adiciona(this.cliente);
			this.cliente = new Cliente();
			this.clientes = this.dao.listaTodos();
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Cliente Cadastrado"));
		}

	}

	public void carregar(Cliente cliente) {
		this.cliente = this.dao.buscaPorCpf(cliente.getCpf());		
		this.cliente.getDataNascimento().set(this.cliente.getDataNascimento().get(Calendar.YEAR),
											 this.cliente.getDataNascimento().get(Calendar.MONTH),
											 this.cliente.getDataNascimento().get(Calendar.DAY_OF_MONTH) + 1);
	}

	private boolean clienteExiste(String cpf) {
		Cliente cliente = this.dao.buscaPorCpf(cpf);
		if (cliente != null) {
			return true;
		} else {
			return false;
		}
	}

	private void removeMaskCpfCliente() {
		this.validatorCpf = new CpfValidatorUtil(this.cliente.getCpf());
		this.validatorCpf.removerMaskFormatter();
		this.cliente.setCpf(this.validatorCpf.getCpfFormatado());
	}

	private void removeMaskCepCliente() {
		this.validatorCep = new CepValidatorUtil(this.cliente.getCep());
		this.validatorCep.removerMaskFormatter();
		this.cliente.setCep(this.validatorCep.getCepFormatado());
	}

	private void removeMaskFormatterFormAll() {
		removeMaskCepCliente();
		removeMaskCpfCliente();
	}

	@Transactional
	public void remover(Cliente cliente) {
		this.dao.remove(cliente);
		this.clientes = this.dao.listaTodos();
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Cliente Removido"));
	}

	public void limparForm() {
		this.cliente.setBairro("");
		this.cliente.setCep("");
		this.cliente.setCidade("");
		this.cliente.setCpf("");
		this.cliente.setDataNascimento(null);
		this.cliente.setEndereco1("");
		this.cliente.setEndereco2("");
		this.cliente.setEstado("");
		this.cliente.setIdade(0);
		this.cliente.setLimiteCredito(0f);
		this.cliente.setNome("");
		this.cliente.setPrimeiraCompra(Byte.parseByte("0"));
		this.cliente.setSexo("");
		this.cliente.setVolumeCompra(0f);
	}

	/* Get And Set */
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {

		if (this.clientes == null) {
			this.clientes = dao.listaTodos();
		}

		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

}
