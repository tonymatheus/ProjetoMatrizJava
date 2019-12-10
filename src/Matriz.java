public class Matriz {
	public int matriz[][];
	int linha;
	int coluna;

	public Matriz(int linha, int coluna) {
		matriz = new int[linha][coluna];
		this.linha = linha;
		this.coluna = coluna;
	}

	public void adicionar(int num) {
		if (linha == matriz.length) {
			throw new IllegalArgumentException("Não Há espaço na Matriz");
		}

		matriz[linha][coluna] = num;
		if (coluna == matriz[0].length - 1) {
			coluna = 0;
			linha++;
		} else {
			coluna++;
		}

	}

	// Mátodo Para Verificar Ordem da Matriz
	private boolean verificarOrdem(Matriz matrizNova) {
		if (matriz.length == matrizNova.matriz.length && matriz[0].length == matrizNova.matriz[0].length) {
			return true;
		}
		return false;

	}

	// método Para Somar Matriz
	public void somar(Matriz matrizNova) {
		if (!(verificarOrdem(matrizNova))) {
			throw new IllegalArgumentException("Matriz de Dimensão Diferente");
		}
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				matriz[i][j] += matrizNova.matriz[i][j];
			}
		}

	}

	// Método Para Subtrair
	public void subtrair(Matriz matrizNova) {

		if (!(verificarOrdem(matrizNova))) {
			throw new IllegalArgumentException("Matriz de Dimensão Diferente");
		}
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				matriz[i][j] -= matrizNova.matriz[i][j];
			}
		}
	}

	// comparando matriz com o tamanho de colunas da outra matriz
	// Método para Multiplicar
	public void multiplicar(Matriz matrizNova) {
		if (!(matriz.length == matrizNova.matriz[0].length)) {
			throw new IllegalArgumentException("Não é Possível Multiplicar Por essa Matriz!!!!");
		}
		int[][] matrizResultante = new int[matriz.length][matrizNova.matriz[0].length];

		for (int i = 0; i < matrizResultante.length; i++) {
			for (int j = 0; j < matrizResultante[0].length; j++) {
				int soma = 0;
			for (int k = 0; k < matrizNova.matriz.length; k++) {
					soma += matriz[i][k] * matrizNova.matriz[k][j];
				}
				matrizResultante[i][j] = soma;
			}
		}
		matriz = matrizResultante;
	}

	// Multiplicação Por Escalar
	public void multiplicaPorEscalar(int escalar) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				matriz[i][j] *= escalar;
			}
		}

	}

	// Calculo de Cofator da Matriz
	public int cofatorMatriz(int linha, int coluna) {
		return (int) Math.pow(-1, (linha + coluna)) * matrizMenorComplementar(linha, coluna).determinanteMatriz();
	}

	// Aplicando o Menor Complementar
	public Matriz matrizMenorComplementar(int linha, int coluna) {
		Matriz matrizMenorComplementar = new Matriz(matriz.length - 1, matriz[0].length - 1);
		int linhaAuxiliar = 0;
		int colunaAuxiliar = 0;
		for (int i = 0; i < matriz.length; i++) {
			if (i == linha) {
				continue;
			}
			for (int j = 0; j < matriz[0].length; j++) {
				if (j == coluna) {
					continue;
				}
				matrizMenorComplementar.matriz[linhaAuxiliar][colunaAuxiliar] = matriz[i][j];
				colunaAuxiliar = (colunaAuxiliar + 1) % (matriz.length - 1);
				if (colunaAuxiliar == 0) {
					linhaAuxiliar++;
				}
			}
		}
		return matrizMenorComplementar;
	}

	// Determinante da Matriz
	public int determinanteMatriz() {
		if (!verificaMatrizQuadrada()) {
			throw new IllegalArgumentException("Essa Matriz Não  é  Quadrada");
		}
		if (matriz.length == 1) {
			return matriz[0][0];
		}
		if (matriz.length == 2) {
			return matriz[0][0] * matriz[1][1] - matriz[0][1] * matriz[1][0];
		}
		int determinanteMat = 0;
		for (int i = 0; i <= 0; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				determinanteMat += matriz[i][j] * cofatorMatriz(i, j);
			}
		}
		return determinanteMat;

	}
	
	
//verificar Simetria da Matriz
	public boolean simetriaMatriz() {
		if (!verificaMatrizQuadrada()) {
			throw new IllegalArgumentException("Matriz não é Quadrada");
		}
		int contador = 0;
		Matriz matrizTransposta = matrizTransposta();
		for(int i =0;i<matriz.length;i++) {
			for(int j=0;j<matriz.length;j++) {
				if(matriz[i][j]== matrizTransposta.matriz[i][j]) {
					contador++;
				}
			}
		}
		if (contador == matriz.length* matriz[0].length) {
			return true;
		}
		return false;
		
	}
	//Matriz Transposta 
	public Matriz matrizTransposta() {
		Matriz matrizTransposta = new Matriz(matriz[0].length, matriz.length);
		for (int i = 0; i < matrizTransposta.matriz.length; i++) {
			for (int j = 0; j < matrizTransposta.matriz[0].length; j++) {
				matrizTransposta.matriz[i][j] = matriz[j][i];
			}
		}
		return matrizTransposta;
	}
	//Verifica Se A Matriz  é Quadrada ou  não
	public boolean verificaMatrizQuadrada() {
		return matriz.length == matriz[0].length;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++)
				sb.append(String.format("%-4s ", matriz[i][j]));
			sb.append("\n");
		}
		return sb.toString();
	}

}
