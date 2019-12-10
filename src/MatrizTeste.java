
public class MatrizTeste {

	public static void main(String[] args) {

		Matriz matriz = new Matriz(4, 4);

		Matriz matrizNova = new Matriz(4, 4);
		int linha = 0, coluna = 0;
		int escalar = 1;
		for (int i = 0; i < 9; i++) {
			matriz.adicionar(i);

		}

		for (int j = 0; j < 9; j++) {
			matrizNova.adicionar(j);
		}

		System.out.println("Matriz:");
		System.out.println(matriz);
		System.out.println("Nova Matriz");
		System.out.println(matrizNova);
		System.out.println("-----Somando Matriz e Nova Matriz----");
		matriz.somar(matrizNova);
		System.out.println(matriz);
		System.out.println("-----Subtraindo Matriz pela Nova Matriz-----");
		System.out.println("Matriz");
		System.out.println(matriz);
		System.out.println("Matriz Nova");
		System.out.println(matrizNova);
		System.out.println("Matriz subtraída");
		matriz.subtrair(matrizNova);
		System.out.println(matriz);
		System.out.println("Multiplicando Matriz pela Matriz Nova ");
		System.out.println("Matriz:");
		System.out.println(matriz);
		System.out.println("Matriz nova");
		System.out.println(matrizNova);
		System.out.println("Matriz Multiplicada");
		matriz.multiplicar(matrizNova);
		System.out.println(matriz);
		System.out.println("Multiplicando Matriz pela Matriz Novar Por Escalar:");
		System.out.println("Matriz:");
		System.out.println(matriz);
		System.out.println("Matriz nova");
		System.out.println(matrizNova);
		System.out.println("Matriz Multiplicada por Escalar");
		matriz.multiplicaPorEscalar(escalar);
		System.out.println(matriz);
		System.out.println("Determinante Da Matriz ");
		matriz.matrizMenorComplementar(linha, coluna);
		matriz.cofatorMatriz(linha, coluna);
		matriz.determinanteMatriz();
		System.out.println(matriz);

	}

}
