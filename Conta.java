package versaoDefinitiva;

public class Conta {

	private String cpfTitular;
	private String nomeTitular;
	private String banco;
	private Integer agencia;
	private Integer numeroConta;
	private Double saldo;

	public Conta(String cpfTitular, String nomeTitular, String banco, Integer agencia, Integer numeroConta,
			Double saldo) {
		super();
		this.cpfTitular = cpfTitular;
		this.nomeTitular = nomeTitular;
		this.banco = banco;
		this.agencia = agencia;
		this.numeroConta = numeroConta;
		this.saldo = saldo;
	}

	public String getCpfTitular() {
		return cpfTitular;
	}

	public void setCpfTitular(String cpfTitular) {
		this.cpfTitular = cpfTitular;
	}

	public String getNomeTitular() {
		return nomeTitular;
	}

	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public Integer getAgencia() {
		return agencia;
	}

	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}

	public Integer getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(Integer numeroConta) {
		this.numeroConta = numeroConta;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public String toString() {
		return "Banco: " + this.banco + "\nAgência: " + this.agencia + "\nConta: " + this.numeroConta + "\nTitular: "
				+ this.nomeTitular + "\nCPF do titular: " + this.cpfTitular + "\nSaldo: " + this.saldo;
	}
}
