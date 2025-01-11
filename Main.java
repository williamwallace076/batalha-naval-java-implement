import java.util.Random;
import java.util.Scanner;

public class Main {

	// Constantes para representar os elementos do tabuleiro
	private static final char AGUA = '~';
	private static final char NAVIO = 'N';
	private static final char ACERTO = 'X';
	private static final char ERRO = 'O';
	public static final int MAX_BOARD = 10;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("--------------------------------------------------------------------");
		System.out.println("                    BEM VINDO À BATALHA NAVAL");
		System.out.println("--------------------------------------------------------------------\n");

		System.out.println(" Escolha o modo de jogo:");
		System.out.println(" 1. Solo (Jogador vs máquina)");
		System.out.println(" 2. Dois Jogadores");
		System.out.println(" 3. máquina vs máquina");
		System.out.print(" \n opção: ");
		int modo = scanner.nextInt();

		switch (modo) {
		case 1:
			jogarSolo(scanner);
			break;
		case 2:
			jogarDoisJogadores(scanner);
			break;
		case 3:
			jogarComputadorVsComputador();
			break;
		default:
			System.out.println("opção inváida. Saindo do jogo.");
		}

		scanner.close();
	}

	///////////////////////////////////////////////////////////////////////////////1 jogador///////////////////////////////////////////////////////////////////////////////

    public static void jogarSolo(Scanner scanner) {
		char[][] cenarioJogador = gerarCenarioAleatorio();
		char[][] cenarioComputador = gerarCenarioAleatorio();

		boolean[][] ataquesJogador = new boolean[MAX_BOARD][MAX_BOARD];
		boolean[][] ataquesComputador = new boolean[MAX_BOARD][MAX_BOARD];

		boolean jogadorVenceu = false;
		boolean ComputadorVenceu = false;
		int turno = 1;
		
		System.out.println("\n Tabuleiro do computador \n");
		exibirCenario(cenarioComputador, true);

		while (!jogadorVenceu && !ComputadorVenceu) {
			System.out.println("\n=== TURNO " + turno + " ===");

			// Turno do jogador 
			
			System.out.println("\n Tabuleiro do Jogador : ");
			exibirCenario(cenarioJogador, true);

            System.out.println("\n ----------------------------------------------- ");
			System.out.println("\n Ataque do Jogador !");

			realizarJogada(scanner, cenarioComputador, ataquesJogador);

			jogadorVenceu = verificarVitoria(cenarioComputador);
			
			if (jogadorVenceu) break;

			// Turno do computador

			System.out.println("\n ----------------------------------------------- ");
			System.out.println("\n Tabuleiro do computador : ");
			exibirCenario(cenarioComputador, true);

			System.out.println("\n ----------------------------------------------- ");
			System.out.println("\n Ataque do computador !");

			realizarJogadaComputador( cenarioJogador, ataquesComputador);

			System.out.println("\n ----------Fim do Turno-----------------------");

			ComputadorVenceu = verificarVitoria(cenarioJogador);

			// Atualiza a contagem de embarcações afundadas apóss a jogada do computador

			int numAfundadasJ1 = contarEmbarcacoesAfundadas(cenarioJogador);
			int numAfundadasC2 = contarEmbarcacoesAfundadas(cenarioComputador);
			System.out.printf("\n O Jogador 1 possui %d embarcações afundadas\n", numAfundadasJ1);
			System.out.printf(" O computador possui %d embarcações afundadas\n\n", numAfundadasC2);
			System.out.println("-----------------------------------------------\n");

			if (ComputadorVenceu) break;
			turno++;
		}
        
        int numAfundadasJ1 = contarEmbarcacoesAfundadas(cenarioJogador);
		int numAfundadasC2 = contarEmbarcacoesAfundadas(cenarioComputador);
		
		if (jogadorVenceu) {
			System.out.println("\n Tabuleiro do computador: ");
			exibirCenario(cenarioComputador, true);
			System.out.println("\n ======== FIM DE JOGO ==========");
			System.out.println("    Você venceu!");
			System.out.println("\n ------------------------------------");
			System.out.printf(" Turnos totais: %d \n", turno);
			System.out.printf(" Computador afundou "+ numAfundadasJ1 + " embarcações do adversario \n");
			System.out.printf(" jogador afundou %d embarcações do adversario\n ", numAfundadasC2);
			System.out.print("------------------------------------");
		} else {
			System.out.println("\n Tabuleiro Computador: ");
			exibirCenario(cenarioJogador, true);
			System.out.println("\n ======== FIM DE JOGO ==========");
			System.out.println("        Computador venceu!");
			System.out.println("\n ------------------------------------");
			System.out.printf(" Turnos totais: %d \n", turno);
			System.out.printf(" Computador  afundou "+ numAfundadasJ1 + " embarcações do adversario \n");
			System.out.printf(" jogador afundou %d embarcações do adversario\n ", numAfundadasJ1);
			System.out.print("------------------------------------");
		}
	}
/////////////////////////////////////////////////////////////////jogadorxjogador/////////////////////////////////////////////////////////////////////////

    public static void jogarDoisJogadores(Scanner scanner) {
		char[][] cenarioJogador1 = gerarCenarioAleatorio();
		char[][] cenarioJogador2 = gerarCenarioAleatorio();

		boolean[][] ataquesJogador1 = new boolean[MAX_BOARD][MAX_BOARD];
		boolean[][] ataquesJogador2 = new boolean[MAX_BOARD][MAX_BOARD];

		boolean Jogador1Venceu = false;
		boolean Jogador2Venceu = false;
		int turno = 1;
		
		System.out.println("\n Tabuleiro do Jogador 2 \n");
		exibirCenario(cenarioJogador2, true);

		while (!Jogador1Venceu && !Jogador2Venceu) {
			System.out.println("\n=== TURNO " + turno + " ===");

			// Turno da Jogador 1

			System.out.println("\n Tabuleiro Jogador 1: ");
			exibirCenario(cenarioJogador1, true);

            System.out.println("\n ----------------------------------------------- ");
			System.out.println("\n Ataque da Jogador 1!");

			realizarJogada(scanner, cenarioJogador2, ataquesJogador1);

			Jogador1Venceu = verificarVitoria(cenarioJogador2);
			if (Jogador1Venceu) break;

			// Turno da Jogador 2

			System.out.println("\n ----------------------------------------------- ");
			System.out.println("\n Tabuleiro Jogador 2: ");
			exibirCenario(cenarioJogador2, true);

			System.out.println("\n ----------------------------------------------- ");
			System.out.println("\n Ataque da Jogador 2!");

			realizarJogada(scanner, cenarioJogador1, ataquesJogador2);

			System.out.println("\n ----------Fim do Turno-----------------------");

		    Jogador2Venceu = verificarVitoria(cenarioJogador1);

			// Atualiza a contagem de embarcações afundadas após a jogada do jogador 2

			int numAfundadasJ1 = contarEmbarcacoesAfundadas(cenarioJogador1);
			int numAfundadasJ2 = contarEmbarcacoesAfundadas(cenarioJogador2);
			System.out.printf("\n O Jogador 1 possui %d embarcações afundadas\n", numAfundadasJ1);
			System.out.printf(" O Jogador 2 possui %d embarcações afundadas\n\n", numAfundadasJ2);
			System.out.println("-----------------------------------------------\n");

			if (Jogador2Venceu) break;
			turno++;
		}
        
      	    int numAfundadasJ1 = contarEmbarcacoesAfundadas(cenarioJogador1);
			int numAfundadasJ2 = contarEmbarcacoesAfundadas(cenarioJogador2);
		
		if (Jogador1Venceu) {
			System.out.println("\n Tabuleiro Jogador 2: ");
			exibirCenario(cenarioJogador2, true);
			System.out.println("\n ======== FIM DE JOGO ==========");
			System.out.println("     Jogador 1 venceu!");
			System.out.println("\n ------------------------------------");
			System.out.printf(" Turnos totais: %d \n", turno);
			System.out.printf(" Jogador 1 afundou "+ numAfundadasJ2 + " embarcações do adversario \n");
			System.out.printf(" Jogador 2 afundou %d embarcações do adversario\n ", numAfundadasJ1);
			System.out.print("------------------------------------");
		} else {
			System.out.println("\n Tabuleiro Jogador 1: ");
			exibirCenario(cenarioJogador1, true);
			System.out.println("\n ======== FIM DE JOGO ==========");
			System.out.println("        Jogador 2 venceu!");
			System.out.println("\n ------------------------------------");
			System.out.printf(" Turnos totoais: %d \n", turno);
			System.out.printf(" Jogador 1 afundou "+ numAfundadasJ2 + " embarcações do adversario \n");
			System.out.printf(" Jogador 2 afundou %d embarcações do adversario\n ", numAfundadasJ1);
			System.out.print("------------------------------------");
		}
	}


	///////////////////////////////////////////////////////////////////////////////Maquina x maquina///////////////////////////////////////////////////////////////////////////////
	
	public static void jogarComputadorVsComputador() {
		char[][] cenarioComputador1 = gerarCenarioAleatorio();
		char[][] cenarioComputador2 = gerarCenarioAleatorio();

		boolean[][] ataquesComputador1 = new boolean[MAX_BOARD][MAX_BOARD];
		boolean[][] ataquesComputador2 = new boolean[MAX_BOARD][MAX_BOARD];

		boolean Computador1Venceu = false;
		boolean Computador2Venceu = false;
		int turno = 1;
		
		System.out.println("\n Tabuleiro da máquina 2 \n");
		exibirCenario(cenarioComputador2, true);

		while (!Computador1Venceu && !Computador2Venceu) {
			System.out.println("\n=== TURNO " + turno + " ===");

			// Turno da máquina 1

			System.out.println("\n Tabuleiro maquina 1: ");
			exibirCenario(cenarioComputador1, true);

            System.out.println("\n ----------------------------------------------- ");
			System.out.println("\n Ataque da Máquina 1!");

			realizarJogadaComputador(cenarioComputador2, ataquesComputador1);

			Computador1Venceu = verificarVitoria(cenarioComputador2);
			if (Computador1Venceu) break;

			// Turno da máquina 2

			System.out.println("\n ----------------------------------------------- ");
			System.out.println("\n Tabuleiro máquina 2: ");
			exibirCenario(cenarioComputador2, true);

			System.out.println("\n ----------------------------------------------- ");
			System.out.println("\n Ataque da máquina 2!");

			realizarJogadaComputador(cenarioComputador1, ataquesComputador2);

			System.out.println("\n ----------Fim do Turno-----------------------");

			Computador2Venceu = verificarVitoria(cenarioComputador1);

			// Atualiza a contagem de embarcações afundadas apóss a jogada da maquina 2

			int numAfundadasC1 = contarEmbarcacoesAfundadas(cenarioComputador1);
			int numAfundadasC2 = contarEmbarcacoesAfundadas(cenarioComputador2);
			System.out.printf("\n A maquina 1 possui %d embarcações afundadas\n", numAfundadasC1);
			System.out.printf(" A maquina 2 possui %d embarcações afundadas\n\n", numAfundadasC2);
			System.out.println("-----------------------------------------------\n");

			if (Computador2Venceu) break;
			turno++;
		}
        
        int numAfundadasC1 = contarEmbarcacoesAfundadas(cenarioComputador1);
		int numAfundadasC2 = contarEmbarcacoesAfundadas(cenarioComputador2);
		
		if (Computador1Venceu) {
			System.out.println("\n Tabuleiro máquina 2: ");
			exibirCenario(cenarioComputador2, true);
			System.out.println("\n ======== FIM DE JOGO ==========");
			System.out.println("     máquina 1 venceu!");
			System.out.println("\n ------------------------------------");
			System.out.printf(" Turnos totais: %d \n", turno);
			System.out.printf(" máquina 1 afundou "+ numAfundadasC2 + " embarcações do adversario \n");
			System.out.printf(" Maquina 2 afundou %d embarcações do adversario\n ", numAfundadasC1);
			System.out.print("------------------------------------");
		} else {
			System.out.println("\n Tabuleiro máquina 1: ");
			exibirCenario(cenarioComputador1, true);
			System.out.println("\n ======== FIM DE JOGO ==========");
			System.out.println("        máquina 2 venceu!");
			System.out.println("\n ------------------------------------");
			System.out.printf(" Turnos totoais: %d \n", turno);
			System.out.printf(" máquina 1 afundou "+ numAfundadasC2 + " embarcações do adversario \n");
			System.out.printf(" Maquina 2 afundou %d embarcações do adversario\n ", numAfundadasC1);
			System.out.print("------------------------------------");
		}
	}

	///////////////////////////////////////////////////////////////////////////////classes ///////////////////////////////////////////////////////////////////////////////


	public static class Coordenada {
		int i, j;

		Coordenada(int i, int j) {
			this.i = i;
			this.j = j;
		}

		@Override
		public String toString() {
			return "(" + i + ", " + j + ")";
		}
	}

	public static	Coordenada[] barco1;
	public static	Coordenada[] barco2;
	public static	Coordenada[] barco3;
	public static	Coordenada[] barco4;
	public static	Coordenada[] barco5;

	////////////////////////////////////////////////////////////// metodos ///////////////////

	public static char[][] gerarCenarioAleatorio() { // gera um tabuleiro com ~ nas cC)lulas
		char[][] cenario = new char[MAX_BOARD][MAX_BOARD];
		for (int i = 0; i < MAX_BOARD; i++) {
			for (int j = 0; j < MAX_BOARD; j++) {
				cenario[i][j] = AGUA;
			}
		}

		int[] tamanhos = {5,4,3, 2, 1}; // Tamanhos de navios para caber no tabuleiro 5x5
		Random random = new Random();


		////////////////////////////////////////

		barco1 = new Coordenada[1];
		barco2 = new Coordenada[2];
		barco3 = new Coordenada[3];
		barco4 = new Coordenada[4];
		barco5 = new Coordenada[5];

		int index1 = 0, index2 = 0, index3 = 0, index4 = 0, index5 = 0;

		////////////////////////////////////////////


		for (int tamanho : tamanhos) {
			boolean posicionado = false;

			while (!posicionado) {
				int linha = random.nextInt(MAX_BOARD);
				int coluna = random.nextInt(MAX_BOARD);
				boolean horizontal = random.nextBoolean();


				if (podePosicionar(cenario, linha, coluna, tamanho, horizontal)) {
					for (int i = 0; i < tamanho; i++) {
						if (horizontal) {
							cenario[linha][coluna + i] = NAVIO; /// posiciona horizontalmente

							/////////////////////////////////////////////////////////////////////
							if (tamanho == 1) {
								barco1[index1++] = new Coordenada(linha, coluna+i);
							} else if (tamanho == 2) {
								barco2[index2++] = new Coordenada(linha, coluna+i);
							} else if (tamanho == 3) {
								barco3[index3++] = new Coordenada(linha, coluna+i);
							}else if (tamanho == 4) {
								barco4[index4++] = new Coordenada(linha, coluna+i);
							}else {
								barco5[index5++] = new Coordenada(linha, coluna+i);
							}
							////////////////////////////////////////////////////////////////////

						} else {
							cenario[linha + i][coluna] = NAVIO; /// posiciona verticalmente
							if (tamanho == 1) {
								barco1[index1++] = new Coordenada(linha + i, coluna);
							} else if (tamanho == 2) {
								barco2[index2++] = new Coordenada(linha + i, coluna);
							} else if (tamanho == 3) {
								barco3[index3++] = new Coordenada(linha + i, coluna);
							} else if (tamanho == 4) {
								barco4[index4++] = new Coordenada(linha + i, coluna);
							} else {
								barco5[index5++] = new Coordenada(linha + i, coluna);
							}
						}
					}
					posicionado = true;
				}
			}
		}

		return cenario;
	}



	private static boolean podePosicionar(char[][] cenario, int linha, int coluna, int tamanho, boolean horizontal) { // verifica a possibilidade de posicionar um barco verificando se ja esta
		if (horizontal) {                                                                                             // na borda ou se ja tem um barco na linha ou  coluna
			if (coluna + tamanho > MAX_BOARD) return false;
			for (int i = 0; i < tamanho; i++) {
				if (cenario[linha][coluna + i] != AGUA) return false;  // verifica se tem um barco na coluna
			}
		} else {
			if (linha + tamanho > MAX_BOARD) return false;
			for (int i = 0; i < tamanho; i++) {
				if (cenario[linha + i][coluna] != AGUA) return false; // verifica se tem um barco na linha
			}
		}
		return true; /// se nC#o encontrou nenhum problema retorna podePosicionar como verdadeiro
	}

	public static void exibirCenario(char[][] cenario, boolean ocultarEmbarcacoes) { // imprime o cenario/tabuleiro do jogador
		System.out.print("   ");
		for (int i = 0; i < MAX_BOARD; i++) { // legenda superior
			System.out.print(i + " ");
		}
		System.out.println();

		for (int i = 0; i < MAX_BOARD; i++) { // legenda lateral
			System.out.print(" " + i + " ");
			for (int j = 0; j < MAX_BOARD; j++) { // impressao das celulas
				if (ocultarEmbarcacoes && cenario[i][j] == NAVIO) {
					System.out.print(AGUA + " ");
				} else {
					System.out.print(cenario[i][j] + " ");
				}
			}
			System.out.println();
		}
	}

	public static void realizarJogada(Scanner scanner, char[][] cenarioAdversario, boolean[][] ataques) {
		int linha, coluna;

		while (true) {
			System.out.print(" Digite a linha (0-" + (MAX_BOARD - 1) + "): ");
			linha = scanner.nextInt();
			System.out.print(" Digite a coluna (0-" + (MAX_BOARD - 1) + "): ");
			coluna = scanner.nextInt();
			System.out.println("");

			if (linha < 0 || linha >= MAX_BOARD || coluna < 0 || coluna >= MAX_BOARD) {
				System.out.println(" Coordenadas inválidas. Tente novamente.\n");
			} else if (verificarAtaqueRepetido(ataques, linha, coluna)) {
				System.out.println(" PosiC'C#o já atacada. Tente novamente.\n");
			} else {
				break;
			}
		}

		boolean acerto = realizarAtaque(cenarioAdversario, linha, coluna);

		atualizarCenario(cenarioAdversario, linha, coluna, acerto);
        ataques[linha][coluna] = true;
        
        if (acerto) {
			System.out.println("\n Acertou um navio!");
		} else {
			System.out.println("\n Errou o ataque.");
			System.out.println("\n -----------------------------------\n");
		}
        
		boolean b1AfundadoJog = verificarEmbarcacaoAfundada(cenarioAdversario, barco1, 1);
		boolean b2AfundadoJog = verificarEmbarcacaoAfundada(cenarioAdversario, barco2, 2);
		boolean b3AfundadoJog = verificarEmbarcacaoAfundada(cenarioAdversario, barco3, 3);
		boolean b4AfundadoJog = verificarEmbarcacaoAfundada(cenarioAdversario, barco4, 4);
		boolean b5AfundadoJog = verificarEmbarcacaoAfundada(cenarioAdversario, barco5, 5);
		

		if (b1AfundadoJog) {
			System.out.println("\n Barco 1 do adversário afundado!");
		}
		if (b2AfundadoJog) {
			System.out.println(" Barco 2 do adversário afundado!");
		}
		if (b3AfundadoJog) {
			System.out.println(" Barco 3 do adversário afundado!");
		}
		if (b4AfundadoJog) {
			System.out.println(" Barco 4 do adversário afundado!");
		}
		if (b5AfundadoJog) {
			System.out.println(" Barco 5 do adversário afundado!");
		}

	}

	public static void realizarJogadaComputador(char[][] cenarioAdversario, boolean[][] ataques) {
		Random random = new Random();
		int linha, coluna;

		while (true) {
			linha = random.nextInt(MAX_BOARD);
			coluna = random.nextInt(MAX_BOARD);
			if (!verificarAtaqueRepetido(ataques, linha, coluna)) {
				break;
			}
		}

		boolean acerto = realizarAtaque(cenarioAdversario, linha, coluna);

		atualizarCenario(cenarioAdversario, linha, coluna, acerto);

		ataques[linha][coluna] = true;

		System.out.println(" Computador atacou em (" + linha + ", " + coluna + ") e " + (acerto ? "acertou!" : "errou."));

		/////////////////////////////////////////////////////////////////////////

		boolean b1AfundadoJog = verificarEmbarcacaoAfundada(cenarioAdversario, barco1, 1);
		boolean b2AfundadoJog = verificarEmbarcacaoAfundada(cenarioAdversario, barco2, 2);
		boolean b3AfundadoJog = verificarEmbarcacaoAfundada(cenarioAdversario, barco3, 3);
		boolean b4AfundadoJog = verificarEmbarcacaoAfundada(cenarioAdversario, barco4, 4);
		boolean b5AfundadoJog = verificarEmbarcacaoAfundada(cenarioAdversario, barco5, 5);

		System.out.printf("\n Estado Atual do Tabuleiro do Adversário apóss o ataque:\n\n");
		exibirCenario(cenarioAdversario, false);

		if (b1AfundadoJog) {
			System.out.println("\n Barco 1 do adversario afundado!");
		}
		if (b2AfundadoJog) {
			System.out.println(" Barco 2 do adversario afundado!");
		}
		if (b3AfundadoJog) {
			System.out.println(" Barco 3 do adversario afundado!");
		}
		if (b4AfundadoJog) {
			System.out.println(" Barco 4 do adversario afundado!");
		}
		if (b5AfundadoJog) {
			System.out.println(" Barco 5 do adversario afundado!");
		}

	}

	public static boolean realizarAtaque(char[][] cenarioAdversario, int linha, int coluna) {
		boolean ataqueRealizado = cenarioAdversario[linha][coluna] == NAVIO; /// se encontrar N retornar true

		return ataqueRealizado;
	}


	public static boolean verificarEmbarcacaoAfundada(char[][] cenario, Coordenada[] barco, int tamanhoEmbarcacao) {
		int acertos = 0;

		for (Coordenada c : barco) {
			if (cenario[c.i][c.j] == ACERTO) {
				acertos++;
			}
		}

		return acertos == tamanhoEmbarcacao;
	}



	public static boolean verificarAtaqueRepetido(boolean[][] ataques, int linha, int coluna) {
		return ataques[linha][coluna]; // se o vetor de ataque nessas cordenadas já existir entao retorna true
	}

	public static void atualizarCenario(char[][] cenario, int linha, int coluna, boolean acerto) {
		cenario[linha][coluna] = acerto ? ACERTO : ERRO;  //// se acerto = true, entC#o marca um acerto no tabuleiro, caso contrario marca um erro
	}

	public static int contarEmbarcacoesAfundadas(char[][] cenario) {
		int embarcacoesAfundadas = 0;

		// Verifica cada barco (barco1, barco2, barco3, barco 4, barco 5)
		if (verificarEmbarcacaoAfundada(cenario, barco1, 1)) {
			embarcacoesAfundadas++;
		}
		if (verificarEmbarcacaoAfundada(cenario, barco2, 2)) {
			embarcacoesAfundadas++;
		}
		if (verificarEmbarcacaoAfundada(cenario, barco3, 3)) {
			embarcacoesAfundadas++;
		}
		if (verificarEmbarcacaoAfundada(cenario, barco4, 4)) {
			embarcacoesAfundadas++;
		}
		if (verificarEmbarcacaoAfundada(cenario, barco5, 5)) {
			embarcacoesAfundadas++;
		}

		return embarcacoesAfundadas;
	}

	public static boolean verificarVitoria(char[][] cenario) {  // verifica se todos as celulas NAVIO (N) agora sC#o inexistentes no tabuleiro
		for (int i = 0; i < MAX_BOARD; i++) {
			for (int j = 0; j < MAX_BOARD; j++) {
				if (cenario[i][j] == NAVIO) {
					return false;
				}
			}
		}
		return true;
	}
}
