package br.com.suco.doce.mel.bean;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.suco.doce.mel.model.Cliente;
import br.com.suco.doce.mel.repositoy.Repository;
import br.com.suco.doce.mel.util.CepValidatorUtil;
import br.com.suco.doce.mel.util.CpfValidatorUtil;

@ManagedBean
@ViewScoped
public class ClienteBean {

	private Cliente cliente = new Cliente();
	private Date dataNascimentoCliente;
	private CpfValidatorUtil validatorCpf;
	private CepValidatorUtil validatorCep;
	private List<Cliente> clientes;

	public void calcularIdade() {
		Calendar cal = parseDateCalendar(dataNascimentoCliente);
		int anoNascimento = cal.get(Calendar.YEAR);

		if (anoNascimentoValido(anoNascimento)) {
			int idade = Calendar.getInstance().get(Calendar.YEAR) - anoNascimento;
			this.cliente.setDataNascimento(cal);
			this.cliente.setIdade(idade);
		}
	}

	private boolean anoNascimentoValido(int ano) {
		return String.valueOf(ano).length() == 4;
	}

	private Calendar parseDateCalendar(Date data) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		return cal;
	}

	public void salvar() {
		//this.cliente.setDataNascimento(parseDateCalendar(dataNascimentoCliente));
		removeMaskFormatterFormAll();

		Repository<Cliente> repository = new Repository<Cliente>(Cliente.class);

		if (clienteExiste(this.cliente.getCpf())) {
			repository.atualiza(this.cliente);
			this.clientes = repository.listaTodos();
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Cliente Alterado"));
		} else {
			repository.adiciona(this.cliente);
			this.cliente = new Cliente();
			this.clientes = repository.listaTodos();
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Cliente Cadastrado"));
		}

	}

	public void carregar(Cliente cliente) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.set(GregorianCalendar.YEAR, cliente.getDataNascimento().get(Calendar.YEAR));
		gc.set(GregorianCalendar.MONTH, cliente.getDataNascimento().get(Calendar.MONTH));
		gc.set(GregorianCalendar.DAY_OF_MONTH, cliente.getDataNascimento().get(Calendar.DAY_OF_MONTH) + 1);

		this.dataNascimentoCliente = gc.getTime();
		this.cliente = cliente;
	}

	private boolean clienteExiste(String cpf) {
		Repository<Cliente> repository = new Repository<>(Cliente.class);
		Cliente cliente = repository.buscaPorCpf(cpf);
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

	public void remover(Cliente cliente) {
		Repository<Cliente> repository = new Repository<Cliente>(Cliente.class);
		repository.remove(cliente);
		this.clientes = repository.listaTodos();
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

	public Date getDataNascimentoCliente() {
		return dataNascimentoCliente;
	}

	public void setDataNascimentoCliente(Date dataNascimentoCliente) {
		this.dataNascimentoCliente = dataNascimentoCliente;
	}

	public List<Cliente> getClientes() {
		Repository<Cliente> repository = new Repository<Cliente>(Cliente.class);

		if (this.clientes == null) {
			this.clientes = repository.listaTodos();
		}

		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

}
