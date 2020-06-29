package br.com.suco.doce.mel.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tabela_de_clientes")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CPF", length = 11, nullable = false, unique = true)
	private String cpf;

	@Column(name = "NOME", length = 100)
	private String nome;

	@Column(name = "ENDERECO_1", length = 150)
	private String endereco1;

	@Column(name = "ENDERECO_2", length = 150)
	private String endereco2;

	@Column(name = "BAIRRO", length = 50)
	private String bairro;

	@Column(name = "CIDADE", length = 50)
	private String cidade;

	@Column(name = "ESTADO", length = 2)
	private String estado;

	@Column(name = "CEP", length = 8)
	private String cep;

	@Column(name = "DATA_DE_NASCIMENTO")
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento = Calendar.getInstance();

	@Column(name = "IDADE", length = 6)
	private Integer idade;

	@Column(name = "SEXO", length = 1)
	private String sexo;

	@Column(name = "LIMITE_DE_CREDITO")
	private Float limiteCredito;

	@Column(name = "VOLUME_DE_COMPRA")
	private Float volumeCompra;

	@Column(name = "PRIMEIRA_COMPRA", length = 1)
	private Byte primeiraCompra;

	@OneToMany(mappedBy = "cliente")
	List<NotaFiscal> notasFiscais = new ArrayList<>();

	public Cliente() {

	}

	public String getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public String getEndereco1() {
		return endereco1;
	}

	public String getEndereco2() {
		return endereco2;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}

	public String getCep() {
		return cep;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public Integer getIdade() {
		return idade;
	}

	public String getSexo() {
		return sexo;
	}

	public Float getLimiteCredito() {
		return limiteCredito;
	}

	public Float getVolumeCompra() {
		return volumeCompra;
	}

	public List<NotaFiscal> getNotasFiscais() {
		return Collections.unmodifiableList(notasFiscais);
	}

	public Byte getPrimeiraCompra() {
		return primeiraCompra;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEndereco1(String endereco1) {
		this.endereco1 = endereco1;
	}

	public void setEndereco2(String endereco2) {
		this.endereco2 = endereco2;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public void setLimiteCredito(Float limiteCredito) {
		this.limiteCredito = limiteCredito;
	}

	public void setVolumeCompra(Float volumeCompra) {
		this.volumeCompra = volumeCompra;
	}

	public void setPrimeiraCompra(Byte primeiraCompra) {
		this.primeiraCompra = primeiraCompra;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cliente [cpf=");
		builder.append(cpf);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", endereco1=");
		builder.append(endereco1);
		builder.append(", endereco2=");
		builder.append(endereco2);
		builder.append(", bairro=");
		builder.append(bairro);
		builder.append(", cidade=");
		builder.append(cidade);
		builder.append(", estado=");
		builder.append(estado);
		builder.append(", cep=");
		builder.append(cep);
		builder.append(", dataNascimento=");
		builder.append(dataNascimento);
		builder.append(", idade=");
		builder.append(idade);
		builder.append(", sexo=");
		builder.append(sexo);
		builder.append(", limiteCredito=");
		builder.append(limiteCredito);
		builder.append(", volumeCompra=");
		builder.append(volumeCompra);
		builder.append(", isPrimeiraCompra=");
		builder.append(primeiraCompra);
		builder.append("]");
		return builder.toString();
	}

}
