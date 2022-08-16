package versaoDefinitiva;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Banco {

	public static void main(String[] args) {

		List<Conta> contas = Arrays.asList(new Conta("01252568090", "Claudio", "Banco do Brasil", 0630, 128596, 1200.0),
				new Conta("06089676888", "Jurema", "Caixa Economica Federal", 0530, 898998, 530.0),
				new Conta("12965055520", "Cleiton", "Itau", 1222, 456328, -250.0),
				new Conta("56589812010", "Ana", "Banrisul", 0620, 630580, 5000.0));

		try {
			buscaContaPorCpf(contas, "01252568090").forEach(System.out::println);
		} catch (ContaNaoEncontradaException e) {
			e.printStackTrace();
		}
		try {
			System.out.println("Saldo: " + retornaSaldo(contas, "01252568090") + "\n ------------------");
		} catch (SaldoNegativadoException e) {
			e.printStackTrace();
		}
		try {
			System.out.println("Saldo: " + saqueConta(contas, "Caixa Economica Federal", 0530, 898998, 530.0)
					+ "\n ------------------");
		} catch (SaldoInsuficienteException e) {
			e.printStackTrace();
		}
	}

	private static List<Conta> buscaContaPorCpf(List<Conta> contas, String cpf) throws ContaNaoEncontradaException {
		List<Conta> contasFiltradas = contas.stream().filter(conta -> conta.getCpfTitular().equals(cpf))
				.collect(Collectors.toList());
		if (contasFiltradas.isEmpty()) {
			throw new ContaNaoEncontradaException("Conta não encontrada.");
		} else {
			return contasFiltradas;
		}
	}

	private static Double retornaSaldo(List<Conta> contas, String cpf) throws SaldoNegativadoException {
		List<Conta> contasFiltradas = contas.stream().filter(conta -> conta.getCpfTitular().equals(cpf))
				.collect(Collectors.toList());
		if (contasFiltradas.get(0).getSaldo() < 0) {
			throw new SaldoNegativadoException("Saldo negativo!");
		} else {
			return contasFiltradas.get(0).getSaldo();
		}
	}

	private static Double saqueConta(List<Conta> contas, String banco, Integer agencia, Integer numeroConta,
			Double valorSaque) throws SaldoInsuficienteException {
		List<Conta> contasFiltradas = contas.stream().filter(conta -> conta.getBanco().equals(banco))
				.filter(conta -> conta.getAgencia().equals(agencia))
				.filter(conta -> conta.getNumeroConta().equals(numeroConta)).collect(Collectors.toList());
		if ((contasFiltradas.get(0).getSaldo() - valorSaque) < 0) {
			throw new SaldoInsuficienteException("Saldo insuficiente para saque!");
		} else {
			contasFiltradas.get(0).setSaldo(contasFiltradas.get(0).getSaldo() - valorSaque);
			return contasFiltradas.get(0).getSaldo();
		}

	}

}
