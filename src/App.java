import pruebas.Varias;

public class App {

	/**
	 * 
	 * @param num
	 * @return
	 */
	public static boolean esCapicua(long num) {
		return num == voltea(num);
	}

	/**
	 * 
	 * @param num
	 * @return
	 */
	public static boolean esCapicua(int num) {
		return esCapicua ((long) num);
	}

	/**
	 * 
	 */
	public static boolean esPrimo(long num) {
		if (num < 2)
			return false;
		for (long i = num / 2; i >= 2; i--) {
			if (num % i == 0)
				return (false);
			i++;
		}
		return true;
	}

	public static boolean esPrimo(int num) {
		return esPrimo((long) num);
	}

	public static int siguientePrimo(int num) {
		while (!esPrimo(++num)) {}
		return num;
	}

	// VAMOS POR AQUI!!
	public static int potencia(int base, int exp) {
		if (exp == 0)
			return 1;
		if (exp < 0)
			return 1 / potencia(base, -exp);
		int res = 1;
		for (int i = 0; i < Math.abs(exp); i++)
			res *= base;
		return res;
	}

	public static int digitos(long num) {
		if (num < 0)
			num = -num;
		if (num == 0)
			return 1;
		else {
			int dig = 0;
			while (num > 0) {
				num /= 10;
				dig++;
			}
			return dig;
		}
	}

	public static int digitos(int num) {
		return digitos((long) num);
	}

	public static long voltea(long num) {
		long volteado = 0;
		int signo = 1;
		if (num < 0)
			signo = -signo;
		num *= signo;
		while (num > 0) {
			volteado = volteado * 10 + num % 10;
			num /= 10;
		}
		return volteado * signo;
	}

	public static int voltea(int num) {
		return (int) voltea((long) num);
	}

	public static int digitoN(long num, int pos) {
		if (pos < 0) {
			return -1;
		}
		if (num < 0) {
			num = -num;
		}
		long aux = voltea(num);
		for (int i = 0; i < pos; i++) {
			aux /= 10;
		}
		return (int)(aux % 10);
	}

	public static int posicionDeDigito(long num, int dig) {
		long aux = voltea(num);
		int pos = 0;
		while (aux > 0) {
			if (aux % 10 == dig)
				return pos;
			aux /= 10;
			pos++;
		}
		return -1;
	}

	public static long quitaPorDetras(long num, int n) {
		return (long)(num / potencia(10, n));
	}

	public static long quitaPorDelante(long num, int n) {
		num = num * 10 + 1;
		long aux = voltea(num);
		long res = quitaPorDetras(aux, n);
		num = voltea(res) / 10;
		return num;
	}

	public static long pegaPorDetras(long num, int dig) {
		return num * 10 + dig;
	}

	public static long pegaPorDelante(long num, int dig) {
		num = num * 10 + 1;
		long aux = voltea(num);
		aux = aux * 10 + dig;
		num = voltea(aux) / 10;
		return  num;
	}
	
	public static long trozoDeNumero(long num, int posInicial, int posFinal) { // terminar
		num = num * 10 + 1;
		long aux = voltea(num);
		aux = aux / potencia(10, posInicial);
		long res = 0;
		for (int i = 0; i <= posFinal - posInicial; i++) {
			res = res * 10 + aux % 10;
			aux /= 10;
		}
		return res;
	}

	public static long juntaNumeros(int num1, int num2) {
		num1 *= potencia(10, digitos(num2));
		return num1 += num2;
	}

    
}
