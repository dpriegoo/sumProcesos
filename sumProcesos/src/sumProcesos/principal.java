package sumProcesos;

public class principal {

	public static void main(String[] args) {

		int n1 = Integer.parseInt(args[0]);
		int n2 = Integer.parseInt(args[1]);
		int resultado = sumar(n1, n2);
		System.out.println(resultado);
	}

	public static int sumar(int n1, int n2) {
		int resultado = 0;
		for (int i = n1; i <= n2; i++) {
			resultado = resultado + i;
		}
		return resultado;
	}
}