# batalha-naval-java-implement

BY: 

William wallace da costa pereira - 202204940051
leticia costa da silva - 202104940017

# Implementação do Jogo Batalha Naval 
## Introdução 
O objetivo deste documento é fornecer uma descrição detalhada do código desenvolvido em Java. A documentação é essencial para garantir que outros desenvolvedores possam compreender e manter o código de forma eficiente. Neste documento, serão abordadas as bibliotecas, funções e métodos implementados, incluindo a lógica por trás do funcionamento do programa. Portanto, cada componente do código será explicado minuciosamente para garantir uma compreensão clara e abrangente. 
## Objetivo 
O objetivo principal deste projeto é desenvolver um jogo de Batalha Naval em Java, proporcionando uma experiência interativa e divertida para os jogadores. Este projeto busca não apenas implementar a funcionalidade básica do jogo, mas também explorar conceitos avançados de programação, como a utilização de estruturas de dados eficientes e a aplicação de princípios de design de software. 

Adicionalmente, o código visa servir como um recurso educacional, demonstrando boas práticas de desenvolvimento e fornecendo uma base sólida para que outros desenvolvedores possam expandir e aprimorar o jogo. Desta forma, o projeto contribuirá para a melhoria das habilidades de programação dos envolvidos e para a disseminação de conhecimento no campo do desenvolvimento de jogos. 
### 1\.Bibliotecas Utilizadas 
***import java.util.Random; import java.util.Scanner;*** 

1. **java.util.Random**: Esse comando vai importar a classe Random da biblioteca java.util para gerar números aleatórios. Isso vai ser útil em diversas situações como simulações ou jogos, onde vai ser necessário a aleatoriedade. 
1. **java.util.Scanner**: Esse comando vai importar a classe Scanner da biblioteca java.util para ler a entrada do usuário a partir do console. Isso vai permitir que o programa faça interações com o usuário, recebendo dados que podem ser utilizados posteriormente. 
### 2\. Definição da Classe Principal 
***public class Main {*** 

***}*** 

**Public Class Main:** Esse comando irá definir a classe principal do programa. **Public** é a palavra-chave que pode ser acessada por outras classes. 

Essa classe é o ponto de partida do programa e contém o método principal, chamado ***main***, que será executado quando o programa for iniciado.  
#### 2\.1 Constantes para a Representação dos Elementos do Tabuleiro 
***private static final char AGUA = '~'; private static final char NAVIO = 'N'; private static final char ACERTO = 'X'; private static final char ERRO = 'O'; public static final int MAX\_BOARD = 10;*** 

O bloco de código acima define algumas constantes para o jogo. Essas constantes são caracteres que irão representar os diferentes no elementos presente no jogo da batalha naval, onde: 

1. **ÁGUA:** Constante que representa “~” no jogo. 
1. **NAVIO:** Constante que representa “N no jogo”. 
1. **ACERTO:** Constante que representa “X” no jogo. 
1. **ERRO:** Constante que representa “O” no jogo. 
1. **MAX\_BOARD:** Constante que possui o valor “10”, esse valor estabelece os limites máximo das bordas do tabuleiro do jogo, ficando assim um tabuleiro 10x10. 
### 3\. Método Principal 
***public static void main(String[] args) {*** 

***Scanner scanner = new Scanner(System.in); }*** 

O bloco de código acima define o método público principal ***main***. Este método será o ponto de partida para execução do programa. O objeto ***Scanner*** será criado pelo ***main*** e será usado para ler a entrada do usuário. 

1. Escolha do Modo de Jogo 

***System.out.println("Escolha o modo de jogo:"); System.out.println("1. Solo (Jogador vs Máquina)"); System.out.println("2. Dois Jogadores"); System.out.println("3. Máquina vs Máquina"); System.out.print("Opção: ");*** 

***int modo = scanner.nextInt();*** 

O código acima exibe as opções de modos de jogo que o usuário pode escolher. O comando ***System.out.println*** imprime as três opções:  

1. **Solo** 
1. **Dois Jogadores** 
1. **Máquina vs Máquina** 

***System.out.print** é responsável por imprimir uma mensagem na tela, da qual* irá solicitar ao usuário que escolha uma dessas opções. A escolha que o usuário fizer, será armazenada na variável ***modo*** usando o comando ***scanner.nextInt().*** 

2. Estrutura de Controle para Modo de Jogo 

***switch (modo) {*** 

`    `***case 1:*** 

`        `***jogarSolo(scanner);*** 

`        `***break;*** 

`    `***case 2:*** 

`        `***jogarDoisJogadores(scanner);*** 

`        `***break;*** 

`    `***case 3:*** 

`        `***jogarComputadorVsComputador();*** 

`        `***break;*** 

`    `***default:*** 

`          `***System.out.println("Opção inválida. Saindo do jogo.");*** 

***}*** 

***scanner.close();*** 

***}*** 

Aqui, o código utiliza uma estrutura de código chamada ***switch*** que irá determinar qual modo de jogo será executado com base na opção que o usuário escolher e que foi armazenada na variável ***modo***.  

1. **Case 1:** Chamará o método ***jogadorSolo(scanner)*** para iniciar o modo de jogo do Solo (Jogador vs Máquina). 
1. **Case 2:** Chamará o método ***jogarDoisJogadores(scanner)*** para iniciar o modo Dois Jogadores. 
1. **Case 3:** Chamará o método ***jogarComputadorvsComputador(scanner)*** para iniciar o modo de jogo Máquina vs Máquina. 
1. **Default:** Irá exibir a mensagem ***“Opção inválida. Saindo do Jogo.”***, caso a opção escolhida não corresponda a nenhuma das opções. 

Assim que o ***switch*** for executado, o scanner será fechado com o comando, desalocando a variável da memória do sistema ***scanner.close()***. 
### 4\. Método Jogador Solo 
***public static void jogarSolo(Scanner scanner) {*** 

`    `***char[][] cenarioJogador = gerarCenarioAleatorio();*** 

`    `***char[][] cenarioComputador = gerarCenarioAleatorio(); }*** 

Aqui será definido o método público ***jogarSolo***, que irá executar o modo Jogo Solo(Jogador vs Máquina).  

1. **char[][] cenarioJogador:** Este comando irá criar um tabuleiro de jogo para o jogador. Será gerado aleatoriamente pelo método ***gerarCenarioAleatorio()*.** 
1. **char[][] cenarioComputador:** Este comando irá criar um tabuleiro de jogo para o computador. Será gerado aleatoriamente pelo método ***gerarCenarioAleatorio().*** 
1. Inicialização das Variáveis e Matrizes de Ataques 

***boolean[][] ataquesJogador = new boolean[MAX\_BOARD][MAX\_BOARD]; boolean[][] ataquesComputador = new boolean[MAX\_BOARD][MAX\_BOARD];*** 

***boolean jogadorVenceu = false; boolean computadorVenceu = false; int turno = 1;*** 

Este bloco de código inicializará algumas variáveis para o modo de Jogo Solo. Essas variáveis gerenciam o estado do jogo enquanto ele é jogado. 

1. **boolean[][] ataquesJogador:** Matriz booleana que irá rastrear os ataques realizados pelo jogador. De início, todos os valores serão ***false***. 
1. **boolean[][] ataquesComputador:** Matriz booleana que irá rastrear os ataques realizados pelo computador. Todos os valores iniciais serão ***false***. 
1. **boolean jogadorVenceu:** Indicador booleano que verificará se o jogador venceu o jogo. Valor inicial será ***false***. 
1. **boolena computadorVenceu:** Indicador booleano que verificará se o computador venceu o jogo. Valor inicial será ***false***. 
1. **int turno:** É a variável que irá rastrear o turno atual do jogo, começando no turno 1. 
2. Exibição do Cenário do Computador 

***System.out.println("\nTabuleiro da maquina:"); exibirCenario(cenarioComputador, true);*** 

O código acima utiliza o ***System.out.println*** para exibir a mensagem *“**Tabuleiro da Máquina**”*, indicando que o tabuleiro do computador será mostrado.  

Já o comando ***exibirCenario*** é usado para mostrar o tabuleiro do computador. Este método irá passar ***cenarioComputador***, a matriz que representa o tabuleiro do computador, e ***true*** como argumentos. O ***true*** indicará que o método irá exibir o tabuleiro de uma maneira específica, mostrando as posições dos navios, uma vez que a função ***exibirCenario*** espera receber como argumento uma variável booleana (true ou false), para a variável ***‘ocultarEmbarcaoes’,*** trazendo a possibilidade de esconder ou não os barcos no tabuleiro. 

3. Controle do Fluxo de Jogo com Estrutura de Repetição 

***while (!jogadorVenceu && !ComputadorVenceu) {*** 

***System.out.println("\n=== TURNO " + turno + " ==="); }*** 

O bloco acima define um laço while que continuará executando enquanto nenhuma das variáveis ***jogadorVenceu*** e ***computadorVenceu*** for verdadeira, ou seja, enquanto nem o jogador nem o computador tiver vencido o jogo. 

O comando definido como ***System.out.println*** vai exibir uma mensagem indicando o início de um novo turno, incluindo o número do turno atual.  

Este trecho do código é fundamental para o controle do fluxo do jogo, o que garantirá que a lógica do jogo se repita continuamente até que haja um vencedor. Cada iteração do laço representará um novo turno do jogo. 

4. Turno do Jogador 

***// Turno do Jogador System.out.println("\nSeu tabuleiro:"); exibirCenario(cenarioJogador, true);*** 

***System.out.println("Seu ataque!");*** 

***realizarJogada(scanner, cenarioComputador, ataquesJogador);  jogadorVenceu = verificarVitoria(cenarioComputador);*** 

Durante o turno do jogador, várias etapas ocorrem para garantir que ele possa fazer sua jogada de maneira organizada. Aqui, o código vai exibir a mensagem “***Seu tabuleiro:***” para informar ao jogador que seu tabuleiro será mostrado. 

Logo após, o método ***exibirCenario*** é chamado com a matriz ***cenarioJogador*** e o argumento ***true***. Esses comandos em conjunto exibirão as posições dos navios no tabuleiro do jogador, permitindo que ele visualize suas peças, se prepare para a jogada e realize ataques contra o computador. 

***‘realizarJogada’*** é a função responsável por inicializar o ataque do jogador ao adversário, como parâmetros dessa função são passados a variável de captura de teclado ***‘scanner’***, o 

tabuleiro a ser atacado ***‘cenarioComputador’*** e por fim a variável que registra as coordenadas dos ataques feitos pelo jogador ***‘ataquesJogador’***.  

Em seguida a variável ***‘jogadorVenceu’*** recebe uma função que retorna verdadeiro ou falso para o status de vitória do jogador, essa função verifica se todos os navios de um determinado tabuleiro foram afundados, determinando assim a vitória do jogador.  

5. Contabilização de Embarcações Afundadas e Verificação de Vitória do Jogador 

***int numAfundadasJ1 = contarEmbarcacoesAfundadas(cenarioJogador); System.out.printf("O jogador possui %d embarcacoes Afundadas", numAfundadasJog );*** 

***jogadorVenceu = verificarVitoria(cenarioComputador); if (jogadorVenceu) break;*** 

Neste pequeno trecho do código, são realizadas algumas etapas para rastrear o progresso e determinar a vitória do jogador.  

O método ***contarEmbarcaçõesAfundadas*** é chamado para contar o número de embarcações afundadas no tabuleiro do jogador(***cenarioJogador***). O resultado feito por esta contagem será armazenado na variável ***numAfundadasJ1***. 

O comando ***System.out.printf*** irá exibir uma mensagem informando ao jogador o número de embarcações afundadas. Em seguida, o método ***verificaVitoria*** é chamado pelo código para determinar se o jogador venceu o jogo, verificando o tabuleiro do computador (***cenarioComputador***). O resultado desta operação é armazenado na variável jogadorVenceu. 

Assim, o código verifica se a variável ***jogadorVenceu*** é verdadeira. Se sim, o laço while é interrompido utilizando **break**, o que indica que o jogador venceu e que o jogo deve ser encerrado. 

Em resumo, esse bloco de código será responsável por contabilizar as embarcações afundadas do jogador, informar o número ao jogador e verificar se o jogador venceu o jogo com base no estado do tabuleiro do computador. 

6. Turno do computador 

***// Turno do computador System.out.println("\nTabuleiro do computador:"); exibirCenario(cenarioComputador, true);*** 

***System.out.println("\nAtaque do computador!"); realizarJogadaComputador(cenarioJogador, ataquesComputador);***  

Durante o turno do computador, a mensagem “***Tabuleiro do computador:***” é exibida através do comando ***System.out.println.*** 

O método ***exibirCenário*** é chamado logo em seguida, passando a matriz ***cenarioComputador*** e o argumento **true**. Esta função irá exibir o tabuleiro do computador, 

- que inclui a posição dos navios. 

Logo após, a mensagem “***Ataque do computador***” é impressa, indicando que é a vez do computador realizar o ataque e o método ‘***realizarAtaqueComputador’*** é chamado para realizar a jogada da máquina. Depois disso, o tabuleiro do jogador, denominado como ‘***cenarioJogador’***, e a matriz ‘***ataquesComputador’*** são passados como argumento para realizar o ataque, assim como ocorreu com o jogador anteriormente. O método também vai verificar se algum navio foi afundado durante o ataque. 

7. Contabilização de Embarcações Afundadas e verificação de Vitória da Máquina 

***int numAfundadasC2 = contarEmbarcacoesAfundadas(cenarioComputador  System.out.printf("O Computador possui %d embarcacoes Afundadas", numAfundadasC2 );*** 

***ComputadorVenceu = verificarVitoria(cenarioJogador); turno++;*** 

***}*** 

O método ‘***contarEmbarcaçõesAfundadas’*** vai ser chamado para contar o número de embarcações afundadas no tabuleiro do computador. O resultado desta contagem vai ser armazenado na variável ‘***numAfundadasComp’***. 

A mensagem informando a quantidade de embarcações afundadas pelo computador é exibida através do System.out.printf.  

Em seguida, o método’ ***verificaVitoria’*** é chamado para determinar se a máquina venceu o jogo e verifica o estado atual do tabuleiro (***cenarioJogador***). O resultado da operação vai ser armazenado na variável ‘***computadorVenceu’***. Por fim, o código incrementa a variável ‘***turno’*** para registrar a passagem para o próximo turno caso nenhum dos dois tenha ganhado a rodada. 

8. Verificação de Vitória do Jogador e Exibição de Resultados 

***if (jogadorVenceu) {*** 

***System.out.println("\n Tabuleiro do computador: "); exibirCenario(cenarioComputador, true); System.out.println("\n ======== FIM DE JOGO =========="); System.out.println("     Jogador venceu!"); System.out.println("\n ------------------------------------"); System.out.printf(" Turnos totais: %d \n", turno);*** 

***System.out.printf(" Computador afundou "+ numAfundadasJ1 + "*** 

***embarcações do adversario \n");*** 

***System.out.printf(" jogador afundou %d embarcações do adversario\n ", numAfundadasC2);*** 

***System.out.print("------------------------------------");*** 

***}***  

Neste trecho do código, é verificado se a variável com a estrutura condicional se ***jogadorVenceu*** é verdadeira. Se sim, o jogo irá exibir a mensagem “***Tabuleiro do Computador:***”, indicando que o tabuleiro do computador será mostrado.  

O comando ***exibirCenario*** é chamado em seguida, passando a matriz ***cenarioComputador*** e o argumento ***true***, que vai exibir o tabuleiro do computador , incluindo as posições dos navios, mostrando que todas as embarcações foram afundadas, garantindo a vitória do jogador. 

Após isso, a mensagem “***======== FIM DE JOGO ==========***” é exibida seguida da mensagem “***Você Venceu!***” para informar ao jogador que ele ganhou. 

O método ***contarEmbarcacoesAfundadas*** é chamado pelo programa duas vezes para contar o número de embarcações afundadas no tabuleiro do computador e no tabuleiro do jogador. Os resultados serão armazenados nas variáveis ***numAfundadasC2*** e ***numAfundadasJ1***, respectivamente. 

1. **System.out.printf("Turnos totais: %d \n", turno);**: Este comando vai exibir 
   1. número total de turnos jogados. O ***%d*** é um marcador de posição que será substituído pelo valor da variável ***turno***. 
1. **System.out.printf("Computador afundou %d embarcações do adversário\n", numAfundadasJ1);**: Irá informar quantas embarcações do adversário foram afundadas pelo Computador.  O ***%d*** será substituído pelo valor da variável ***numAfundadasJ1***.  
1. **System.out.printf("Jogador 1 afundou %d embarcações do adversário\n", numAfundadasC2);**: Vai informar quantas embarcações do adversário foram afundadas pelo jogador.  ***O %d*** será substituído pelo valor da variável ***numAfundadasC2***. 
9. Verificação de Vitória da Máquina e Exibição de Resultados ***else {*** 

***System.out.println("\n Tabuleiro Computador: "); exibirCenario(cenarioJogador, true);*** 

***System.out.println("\n ======== FIM DE JOGO =========="); System.out.println("        Computador venceu!"); System.out.println("\n ------------------------------------"); System.out.printf(" Turnos totais: %d \n", turno);*** 

***System.out.printf(" Computador  afundou "+ numAfundadasJ1 +*** 

***" embarcações do adversario \n");*** 

***System.out.printf(" jogador afundou %d embarcações do adversario\n ", numAfundadasJ1);*** 

***System.out.print("------------------------------------");*** 

***}*** 

A verificação do jogo ocorre em duas etapas: 

1. O código verificará se a condição ***else*** é verdadeira, o que significa que o computador venceu. Se sim, o código exibirá a mensagem “***Seu Tabuleiro:*** “ para indicar que o tabuleiro do jogador será mostrado . 
1. O método ***exibirCenario*** será chamado logo em seguida, passando a matriz ***cenarioJogador*** e o argumento true. Esta função exibirá o tabuleiro do jogador e os navios afundados. 

A mensagem “***===FIM DE JOGO===***” é exibida junto com a mensagem “***A máquina venceu***” para informar ao jogador que a máquina venceu o jogo. 
### 5\. Método Jogar Dois Jogadores 
***public static void jogarDoisJogadores(Scanner scanner) {     char[][] cenarioJogador1 = gerarCenarioAleatorio();*** 

`    `***char[][] cenarioJogador2 = gerarCenarioAleatorio();*** 

***}*** 

O bloco de código acima, define o método ***jogarDoisJogadores*** (jogador vs jogador). 

São utilizadas duas matrizes de caracteres, ***cenarioJogador1*** e ***cenarioJogador2***, para representar os tabuleiros dos dois jogadores. Cada um desses tabuleiros é gerado automaticamente utilizando o método ***gerarCenarioAleatorio***. 

1. Inicialização das Variáveis e Matrizes de Ataques para Dois Jogadores 

***boolean[][] ataquesJogador1 = new boolean[MAX\_BOARD][MAX\_BOARD]; boolean[][] ataquesJogador2 = new boolean[MAX\_BOARD][MAX\_BOARD];*** 

***boolean jogador1Venceu = false; boolean jogador2Venceu = false; int turno = 1;*** 

- bloco acima vai inicializar algumas variáveis para o modo Dois Jogadores:  
1. **boolean[][] ataquesJogador1 = new boolean[MAX\_BOARD][MAX\_BOARD];**: Criará uma matriz booleana para 


rastrear os ataques realizados pelo jogador 1. Irá inicializar com todos os valores ***false***. 

2. **boolean[][] ataquesJogador2 = new boolean[MAX\_BOARD][MAX\_BOARD];**: Criará uma matriz booleana para rastrear os ataques realizados pelo jogador 2. Inicializará com todos os valores ***false***. 
2. **boolean jogador1Venceu = false;**: Indicador booleano que mostrará se o jogador 1 venceu o jogo. Inicia com ***false***. 
2. **boolean jogador2Venceu = false;**: Indicador booleano que mostrará se o jogador 2 venceu. Inicia com ***false***. 
2. **int turno = 1;**: Variável que irá rastrear o turno atual do jogo, começando pelo turno 1. 
2. Controle do Fluxo de Jogo com Estrutura de Repetição para Dois Jogadores 

***while (!jogador1Venceu && !jogador2Venceu) {*** 

`    `***System.out.println("\n=== TURNO " + turno + " ==="); }*** 

Neste trecho do código, vamos ter uma estrutura de laço para dois jogadores. O ***While*** é usado aqui para alternar o turno entre dois jogadores enquanto nenhum deles tiver vencido.  

1. O while continua a execução enquanto as variáveis ***jogadorVenceu***  e ***jogador2Venceu*** forem ***false***. 
1. O comando ***System.out.printf*** vai imprimir o número do turno atual. 
2. Turno Jogador 1 

***System.out.println("\n Tabuleiro Jogador 1: "); exibirCenario(cenarioJogador1, true);*** 

`            `***System.out.println("\n ----------------------------------------------- ");*** 

***System.out.println("\n Ataque do Jogador 1!");*** 

***realizarJogada(scanner, cenarioJogador2, ataquesJogador1);*** 

***Jogador1Venceu = verificarVitoria(cenarioJogador2); if (Jogador1Venceu) break;*** 

Este bloco de código nos mostra que durante o turno do jogador 1 são executadas as seguintes etapas: 

A exibição do tabuleiro do jogador 1, onde o código imprime a mensagem “***Tabuleiro Jogador 1:***”. 

A chamada do método ***exibirCenario*** para mostrar o tabuleiro do jogador 1. O argumento **true** vai indicar que as posições dos navios devem ser exibidas. 

O código irá imprimir “Ataque do jogador 1”, informando que é a vez do jogador 1 realizar um ataque. Em seguida, o método ***realizarJogada*** é chamado e utiliza o ***scanner*** para ler a entrada do jogador e atualizar o tabuleiro do jogador 2, registrando os ataques feitos pelo jogador 1. 

Após essa jogada, o método ***verificaVitoria*** é chamado para verificar se o jogador 1 venceu 

- jogo, verificando o estado do tabuleiro do jogador 2. O resultado é armazenado na variável ***jogador1Venceu***. 

  Caso o jogador 1 vença, ou seja, o ***jogador1Venceu*** seja verdadeiro, o laço ***while*** é interrompido com o comando ***break***, indicando que o jogo acabou. 

3. Turno Jogador 2 

***System.out.println("\n ----------------------------------------------- "); System.out.println("\n Tabuleiro Jogador 2: "); exibirCenario(cenarioJogador2, true);*** 

***System.out.println("\n ----------------------------------------------- "); System.out.println("\n Ataque da Jogador 2!");*** 

***realizarJogada(scanner, cenarioJogador1, ataquesJogador2); System.out.println("\n ----------Fim do Turno-----------------------");   Jogador2Venceu = verificarVitoria(cenarioJogador1);*** 

Neste bloco de código, que indica o turno do jogador 2, o código irá imprimir a mensagem ***“Tabuleiro Jogador 2:”*** Depois disso, o método **exibirCenario** é chamado para mostrar o tabuleiro do jogador 2. O argumento **true** vai indicar que a posição dos navios devem ser exibidas. 

Logo após, o código imprime “Ataque jogador 2”, informando que é a vez do jogador 2 realizar o ataque. O método ***realizarJogada*** é chamado e utiliza o scanner para ler a entrada do jogador, atualiza o tabuleiro do jogador 1, registrando os ataques feitos pelo jogador 2. 

É chamado, então, o método ***verificaVitoria*** para verificar se o jogador 2 venceu o jogo, analisando o estado do tabuleiro do jogador 1. O resultado é armazenado na variável ***jogador2Venceu***. 

***int numAfundadasJ1 =contarEmbarcacoesAfundadas(cenarioJogador1); int numAfundadasJ2 = contarEmbarcacoesAfundadas(cenarioJogador2);*** 

***System.out.printf("\n O Jogador 1 possui %d embarcações afundadas\n", numAfundadasJ1);*** 

***System.out.printf(" O Jogador 2 possui %d embarcações afundadas\n\n", numAfundadasJ2); System.out.println("-----------------------------------------------\n");*** 

***if (Jogador2Venceu) break; turno++;*** 

Por fim é gerada a impressão atualizando o número de embarcações afundadas para cada jogador, é chamada a função ***contarEmbarcacoesAfundadas,** guardando seu resultado nas variáveis e as imprimindo.* 

A variável ***turno*** é incrementada em 1 para registrar a passagem para o próximo turno. 

Este trecho de código gerencia a exibição do tabuleiro do Jogador 2, a interação durante o turno do Jogador 2, e a verificação de vitória. Ele garante que o jogo continue até que um dos jogadores tenha afundado todas as embarcações do adversário. 

4. Verificação de Vitória e Exibição de Resultados no Modo de dois Jogadores  

***if (Jogador1Venceu) {*** 

***System.out.println("\n Tabuleiro Jogador 2: "); exibirCenario(cenarioJogador2, true);*** 

***System.out.println("\n ======== FIM DE JOGO =========="); System.out.println("     Jogador 1 venceu!");*** 

***System.out.println("\n ------------------------------------");*** 

***System.out.printf(" Turnos totais: %d \n", turno);*** 

***System.out.printf(" Jogador 1 afundou "+ numAfundadasJ2 + " embarcações do adversário \n");*** 

***System.out.printf(" Jogador 2 afundou %d embarcações do adversario\n ", numAfundadasJ1);*** 

***System.out.print("------------------------------------");*** 

***} else {*** 

***System.out.println("\n Tabuleiro Jogador 1: ");*** 

***exibirCenario(cenarioJogador1, true); System.out.println("\n ======== FIM DE JOGO =========="); System.out.println("        Jogador 2 venceu!");*** 

***System.out.println("\n ------------------------------------");*** 

***System.out.printf(" Turnos totoais: %d \n", turno);*** 

***System.out.printf(" Jogador 1 afundou "+ numAfundadasJ2 + " embarcações do adversário \n");*** 

***System.out.printf(" Jogador 2 afundou %d embarcações do adversário\n ", numAfundadasJ1);*** 

***System.out.print("------------------------------------");*** 

***}*** 

Aqui, vamos verificar a vitória de um dos jogadores e exibir uma mensagem com base nos resultados. 

1. Verificação da vitória do jogador 1: 

Se a variável ***jogador1Venceu*** for verdadeira, o código irá imprimir a mensagem “ ***Tabuleiro Jogador 2:***”  e chamar o método ***exibirCenario*** para mostrar o tabuleiro do jogador 2 com as posições dos navios. Logo em seguida, será exibida a mensagem “***===FIM DE JOGO===***”  e “***Jogador 1 Venceu!***” para anunciar a vitória do jogador 1. Ainda, também é mostrado um relatório geral das ações dos jogadores ao final. 

2. Verificação da vitória do jogador 2: 

Se a variável ***jogador1Venceu*** for falsa, significa que o jogador 2 venceu. O código irá imprimir a mensagem “***Tabuleiro Jogador 1:***”  e chamará o método ***exibirCenario*** para mostrar o tabuleiro do jogador 1 e as posições dos navios. Em seguida, o código imprimirá “***===FIM DE JOGO===***” e “***Jogador 2 venceu!***” para anunciar a vitória do jogador. Ainda, também é mostrado um relatório geral das ações dos jogadores ao final.*** 
### 6\.Método Computador vs Computador 
***public static void jogarComputadorVsComputador() {*** 

`    `***char[][] cenarioComputador1 = gerarCenarioAleatorio();     char[][] cenarioComputador2 = gerarCenarioAleatorio();*** 

***}*** 

O método ***jogarComputadorvsComputador*** é definido neste bloco de código. Vai ser utilizado para simular uma partida entre duas máquinas. 

1. **char[][] cenarioComputador1 = gerarCenarioAleatorio()**;: Irá criar e inicializar o tabuleiro do computador 1 gerando um cenário aleatória utilizando o método ***gerarCenarioAleatorio()***. 
1. **char[][] cenarioComputador2 = gerarCenarioAleatorio()**;: Irá criar e inicializar o tabuleiro do computador 2  gerando um cenário aleatório utilizando o mesmo método do computador 1. 
1. Inicialização das Variáveis e Matrizes de Ataques para Máquina contra Máquina 

***boolean[][] ataquesComputador1 = new boolean[MAX\_BOARD][MAX\_BOARD]; boolean[][] ataquesComputador2 = new boolean[MAX\_BOARD][MAX\_BOARD];*** 

***boolean Computador1Venceu = false; boolean Computador2Venceu = false;*** 

***int turno = 1;*** 

O bloco de código acima irá inicializar as variáveis necessárias para o modo de jogo Máquina vs Máquina. 

1. **boolean[][] ataquesComputador1 = new boolean[MAX\_BOARD][MAX\_BOARD];**: Será criada uma matriz booleana para rastrear os ataques realizados pelo computador 1. Os valores iniciais são ***false***. 
1. **boolean[][] ataquesComputador2 = new boolean[MAX\_BOARD][MAX\_BOARD];**: Será criada uma matriz booleana para rastrear os ataques realizados pelo computador 2. Os valores iniciais também serão ***false***. 
1. **boolean Computador1Venceu = false;**: Indicador booleano que irá verificar se o computador 1 venceu o jogo. O valor inicial é ***false***. 
1. **boolean Computador1Venceu = false;**: Indicador booleano que verifica se o computador 2 venceu o jogo. Inicialmente, é ***false***. 
1. **int turno = 1;**: A variável que irá rastrear o turno atual do jogo, começando no turno 1. 
2. Controle de Fluxo do Jogo com Estrutura de Repetição para Máquina contra Máquina 

***while (!Computador1Venceu && !Computador2Venceu) {     System.out.println("\n=== TURNO " + turno + " ===");    }*** 

Para controlar o fluxo do jogo entre as duas máquinas  é necessário usarmos um while que continuará executando enquanto nenhum dos dois computadores tiver vencido o jogo. 

Aqui, o laço ***while*** continua executando enquanto as variáveis ***Computador1Venceu*** e ***computador2Venceu*** forem ***false***. 

- comando ***System.out.println*** irá imprimir o número do turno atual na tela.  
3. Turno da Máquina 1 

***// Turno da Máquina 1*** 

***System.out.println("\n Tabuleiro maquina 1: "); exibirCenario(cenarioComputador1, true);*** 

` `***System.out.println("\n ----------------------------------------------- "); System.out.println("\n Ataque da Máquina 1!");*** 

***realizarJogadaComputador(cenarioComputador2, ataquesComputador1);*** 

***Computador1Venceu = verificarVitoria(cenarioComputador2); if (Computador1Venceu) break;*** 

Durante o turno da máquina um serão realizadas os seguintes processos: 

1. O código vai imprimir a mensagem “***Tabuleiro máquina 1:***”. Depois o método ***exibirCenario*** será chamado para mostrar o tabuleiro da máquina 1. O ***true*** indica que as posições dos navios devem ser inseridas. 
1. O código vai imprimir a mensagem “**Ataque máquina 1!**”, indicando que é a vez da máquina 1 realizar o ataque. O método ***realizarJogadaComputador*** é chamado para executar a jogada da máquina 1, utilizando o tabuleiro da máquina 2 e registrando os ataques feitos pela máquina 1. 
1. Após a jogada, o método ***verificaVitoria*** é chamado para verificar se a máquina 1 venceu o jogo, analisando o tabuleiro da máquina 2. O resultado é armazenado na variável ***computador1Venceu***. 

   Se a máquina 1 venceu, ou seja ***computador1Venceu*** for verdadeira, o laço ***while*** é interrompido como comando ***break***, indicando que o jogo acabou. 

2. Turno da Máquina 2 

***// Turno da Máquina 2*** 

***System.out.println("\n ----------------------------------------------- "); System.out.println("\n Tabuleiro máquina 2: "); exibirCenario(cenarioComputador2, true);*** 

***System.out.println("\n ----------------------------------------------- "); System.out.println("\n Ataque da máquina 2!");*** 

***realizarJogadaComputador(cenarioComputador1, ataquesComputador2); System.out.println("\n ----------Fim do Turno-----------------------"); Computador2Venceu = verificarVitoria(cenarioComputador1);*** 

Durante o turno da máquina 2 são feitos os seguintes procedimentos:  

1. O código irá imprimir a mensagem “***Tabuleiro máquina 2:***”. Em seguida, o método ***exibirCenario*** é chamado para mostrar o tabuleiro da máquina 2. O argumento ***True*** irá indicar que as posições dos navios devem ser exibidas. 
1. O código irá imprimir a mensagem “***Ataque máquina 2!***”, indicando que a máquina 2 deve realizar o ataque. O método ***realizarJogadaComputador*** é chamado para executar a jogada da máquina 2, utilizando o tabuleiro da máquina 1 e registrando os ataques feitos pela máquina 2. 
3. Após a jogada, o método **verificaVitoria** é chamado para verificar se a máquina venceu o jogo, analisando a situação atual do tabuleiro da máquina 1. O resultado é registrado na variável ***computador2Venceu***. 

A variável **turno** é incrementada em 1 para o registro da passagem para o próximo turno. 

3. Verificação de Vitória da Máquina e Exibição de Resultados 

***if (Computador1Venceu) {*** 

***System.out.println("\n Tabuleiro máquina 2: "); exibirCenario(cenarioComputador2, true);*** 

***System.out.println("\n ======== FIM DE JOGO =========="); System.out.println("     máquina 1 venceu!");*** 

***System.out.println("\n ------------------------------------");*** 

***System.out.printf(" Turnos totais: %d \n", turno);*** 

***System.out.printf(" máquina 1 afundou "+ numAfundadasC2 + " embarcações do adversario \n");*** 

***System.out.printf(" Maquina 2 afundou %d embarcações do adversario\n ", numAfundadasC1);*** 

***System.out.print("------------------------------------");*** 

***}*** 

***else {*** 

***System.out.println("\n Tabuleiro máquina 1: ");*** 

***exibirCenario(cenarioComputador1, true); System.out.println("\n ======== FIM DE JOGO =========="); System.out.println("        máquina 2 venceu!");*** 

***System.out.println("\n ------------------------------------");*** 

***System.out.printf(" Turnos totoais: %d \n", turno);*** 

***System.out.printf(" máquina 1 afundou "+ numAfundadasC2 + " embarcações do adversario \n");*** 

***System.out.printf(" Maquina 2 afundou %d embarcações do adversario\n ", numAfundadasC1);*** 

***System.out.print("------------------------------------");*** 

***}*** 

***}*** 

No bloco acima, verificamos a vitória de uma das máquinas e exibimos uma mensagem apropriada com base no resultado. O processo é feito da seguinte forma: 

1. O código verifica se a variável ***Computador1Venceu*** é verdadeira. Se sim, a mensagem “***Tabuleiro máquina 2:***” é exibida na tela e o método ***exibirCenario*** é chamado para mostrar o tabuleiro da máquina 2 junto com as posições dos navios. Em seguida, o código imprime a mensagem “===FIM DE JOGO===” e “Máquina 1 venceu!” para anunciar a vitória da máquina 1. 
1. Se a variável ***Computador1Venceu*** for falsa, significa que a máquina 2 venceu. O código exibirá uma mensagem na tela “***Tabuleiro máquina 1:***” com as posições dos 

   navios. Em seguida, o código imprime “***===FIM DE JOGO===***” e “***Máquina 2 venceu!***” para anunciar a vitória da máquina 2. 
### 7\. Classe Coordenada 
***public static class Coordenada {     int i, j;*** 

`    `***Coordenada(int i, int j) {         this.i = i;*** 

`        `***this.j = j;*** 

`    `***}*** 

`    `***@Override*** 

`    `***public String toString() {*** 

`        `***return "(" + i + ", " + j + ")";     }*** 

***}*** 

O bloco de códigos acima se trata de uma Classe Coordenada. Ela vai definir um objeto que contém duas variáveis inteiras, ***i*** e ***j***, que representam as coordenadas em um tabuleiro  ou matriz. 

1. **Variáveis de instância**: **int i, j**; 

   Irão armazenar as coordenadas ***i*** e ***j***. 

2. **Construtor: *coordenadas(int i, j):*** 

   Construtor da classe, que irá inicializar os valores das coordenadas ***i*** e ***j*** quando um novo objeto Coordenada é criado. 

3. **Método toString**: 

   ***@Override:*** Indica que o método ***toString*** está sobrescrevendo o método ***toString*** da ***Classe Object***. 

   **public String to String():** 

   Irá retornar uma representação em string do objeto ***Coordenada***, formatada como  ***“(i e j)”***. 
### 8\. Declaração de Arrays e Objetos 
***public static Coordenada[] barco1; public static Coordenada[] barco2;*** 

***public static Coordenada[] barco3;*** 

Aqui vamos declarar três arrays estáticos de objetos Coordenada, representando a posição de diferentes barcos no jogo.  

1. **Array barco1:**  
- ***public static Coordenada[] barco1;***: Irá declarar um array estático de objetos Coordenadas chamado barco1. Ele será utilizado para armazenar as coordenadas do primeiro barco. 
2. **Array barco2:** 
- ***public static Coordenada[] barco2;***: Irá declarar um array estático de objetos Coordenadas chamado barco2. Ele será utilizado para armazenar as coordenadas do segundo barco. 
3. **Array barco3:** 
- ***public static Coordenada[] barco3;***: Irá declarar um array de objetos Coordenadas chamado barco3. Ele será utilizado para armazenar as coordenadas do terceiro barco. 

Os arrays acima permitirão que as posições dos barcos sejam armazenadas e manipuladas ao longo do jogo, facilitando a verificação de ataques e a atualização de cenários. 
### 9\. Método Gerar Cenário Aleatório 
***public static char[][] gerarCenarioAleatorio() { // gera um tabuleiro com ~ nas*** 

***células*** 

`    `***char[][] cenario = new char[MAX\_BOARD][MAX\_BOARD];     for (int i = 0; i < MAX\_BOARD; i++) {*** 

`        `***for (int j = 0; j < MAX\_BOARD; j++) {*** 

`            `***cenario[i][j] = AGUA;*** 

`        `***}*** 

`    `***}*** 

` `***}*** 

O método ***gerarCenarioAleatorio*** cria um tabuleiro de jogo. É responsável por criar e preencher o tabuleiro do jogo com células de água, representadas pelo caractere ***AGUA(~)***, criando assim um cenário inicial para o jogo. 

1. **public static char[][] gerarCenarioAleatorio()**: Irá definir um método estático público que retorna uma matriz bidimensional de caracteres (cha[][]). 
1. **char[][] cenario = new char[MAX\_BOARD][MAX\_BOARD];**: Irá criar uma nova matriz bidimensional de caracteres (cenário) com o tamanho definido por ***MAX\_BOARD.*** 

Dois laços for percorrem por todas as linhas da matriz: 

3. **for (int i = 0; i < MAX\_BOARD; i++)**: Itera sobre as linhas do tabuleiro. 
4. **for (int j = 0; j < MAX\_BOARD; j++)**: Itera sobre as colunas do tabuleiro. 
4. **cenario[i][j] = AGUA;**: Irá inicializar cada célula do tabuleiro com o caractere ***AGUA*** (representado por ~), indicando que a célula contém água. 
### 10\. Inicialização dos Tamanhos dos Navios e do Objeto Random 
***int[] tamanhos = {5,4,3, 2, 1}; // Tamanhos de navios para caber no tabuleiro 5x5*** 

***Random random = new Random();*** 

No código acima, vamos inicializar os tamanhos dos navios que serão colocados aleatoriamente no tabuleiro e criam um objeto ***Random*** para gerar números aleatórios. 

1. **int[] tamanhos = {5,4,3, 2, 1};**: Irá criar um array de inteiros que define os tamanhos dos navios. Neste caso, os tamanhos serão 1, 2, 3, 4 e 5. Isso significa que haverá um navio de tamanho 5, 4, 3, um de tamanho 2 e um de tamanho 1, adequados para um tabuleiro 10x10.. 
1. **Random random = new Random();**: Irá criar um objeto ***Random***  que será usado para gerar números aleatórios. Este objeto será útil para colocar os navios em posições aleatórias no tabuleiro. 
### 11\. Inicialização dos Array de Coordenadas para os Barcos 
***barco1 = new Coordenada[1]; barco2 = new Coordenada[2]; barco3 = new Coordenada[3]; barco4 = new Coordenada[4];*** 

***barco5 = new Coordenada[5];*** 

***int index1 = 0, index2 = 0, index3 = 0,  index4 = 0,  index5 = 0;*** 

Estas inicializações preparam os arrays para armazenar as coordenadas dos barcos de diferentes tamanhos, facilitando o posicionamento e a manipulação dos barcos no jogo, assim como fizemos anteriormente com os navios. 

1. **barco1 = new Coordenada[1];**: Irá criar um array de objetos Coordenada com uma posição, representando o barco de tamanho 1. 
1. **barco2 = new Coordenada[2];**: Irá criar um array de objetos Coordenadas com duas posições, representando o barco de tamanho 2. 
1. **barco3 = new Coordenada[3];**: irá criar um array de objetos Coordenadas com três posições, representando o barco de tamanho 3.  
1. **barco4 = new Coordenada[4];**: irá criar um array de objetos Coordenadas com três posições, representando o barco de tamanho 3.  
5. **barco5 = new Coordenada[5];**: irá criar um array de objetos Coordenadas com três posições, representando o barco de tamanho 3.  
5. **int index1 = 0, index2 = 0, index3 = 0*, index4 = 0,  index5 = 0*;**: Irá inicializar os índices de controle das posições dos barcos nos respectivos arrays. Esses índices serão usados para adicionar coordenadas às posições dos barcos durante o posicionamento no tabuleiro. 
### 12\. Posicionamento Aleatório dos Navios  
***for (int tamanho : tamanhos) {     boolean posicionado = false;*** 

`    `***while (!posicionado) {*** 

`        `***int linha = random.nextInt(MAX\_BOARD);*** 

`        `***int coluna = random.nextInt(MAX\_BOARD);         boolean horizontal = random.nextBoolean();     }*** 

***}*** 

Aqui, vamos adicionar mais códigos dentro do laço ***while***, o que garante que os navios sejam posicionados de forma válida. 

O laço ***for*** vai percorrer o array ***tamanhos*** para cada tamanho de navio. 

1. **boolean posicionado = false;**: Irá inicializar a variável booleana para indicar se o navio foi posicionado com sucesso. 

Dentro do laço ***while***, serão geradas coordenadas aleatórias e uma orientação aleatória, horizontal ou vertical, para o navio. 

2. **int linha = random.nextInt(MAX\_BOARD);**: Irá gerar uma linha aleatória dentro dos limites do tabuleiro. 
2. **int coluna = random.nextInt(MAX\_BOARD);**: Irá gerar uma coluna aleatória dos limites do tabuleiro.  
2. **boolean horizontal = random.nextBoolean();**: Definirá se o navio será posicionado horizontalmente ou verticalmente. 
### 13\. Lógica de Posicionamento dos Navios 
***if (podePosicionar(cenario, linha, coluna, tamanho, horizontal)) {*** 

`    `***for (int i = 0; i < tamanho; i++) {*** 

`        `***if (horizontal) {*** 

`            `***cenario[linha][coluna + i] = NAVIO; // posiciona horizontalmente         }*** 

`    `***}*** 

***}*** 

Continuando com a lógica de posicionamentos dos navios no tabuleiro, podemos adicionar as seguintes verificações dentro do laço ***for***. O código acima verificará se o navio pode ser posicionado verticalmente ou horizontalmente e então posicionará o navio, atualizando o tabuleiro com os valores apropriados. 

1. O início do bloco de código acima verifica se o navio pode ser posicionado utilizando 
   1. método ***podePosicionar***. Se o navio puder ser posicionado, ele entra no laço ***for*** para preencher as células do tabuleiro com o navio. 
1. Se a orientação do navio for horizontal, o laço ***for*** itera sobre o tamanho do navio e atualiza as células correspondentes no tabuleiro para indicar a presença do navio. 
1. Caso a orientação seja vertical, o código deverá posicionar o navio verticalmente. 
### 14\. Registros das Coordenadas dos Navios 
***if (tamanho == 1){*** 

`    `***barco1[index1++] = new Coordenada(linha, coluna+i); } else if (tamanho == 2){*** 

`    `***barco2[index2++] = new Coordenada(linha, coluna+i); } else {*** 

`    `***barco3[index3++] = new Coordenada(linha, coluna+i); }*** 

Neste trecho de código, vamos adicionar as coordenadas dos navios aos arrays correspondentes, com base no tamanho do navio e na posição determinada. 

1. O código irá verificar o tamanho do navio usando a estrutura condicional ***if-else.***  

Se o tamanho do navio for 1: 

2. **barco1[index1++] = new Coordenada(linha, coluna + i);:** Irá criar uma nova coordenada (linha, coluna + i)  e irá adicioná-la ao array barco1. O índice ***index1*** é incrementado após a adição. 

Se o tamanho do navio for 2: 

3. **barco2[index2++] = new Coordenada(linha, coluna + i);**: Irá criar uma nova coordenada (linha, coluna + i)  e irá adicioná-la ao array ***barco2***. O índice ***index2*** é incrementado após a adição. 

Para navios de tamanho 3: 

4. **barco3[index3++] = new Coordenada(linha, coluna + i);**: Irá criar uma nova coordenada (linha, coluna + i)  e irá adicioná-la ao array ***barco3***. O índice ***index3*** é incrementado após a adição. 

Este bloco de código especificamente assume que os navios estão sendo posicionados horizontalmente.  
### 15\. Lógica de Posicionamento Vertical do Navios e Retorno do Cenário 
***else {*** 

`    `***cenario[linha + i][coluna] = NAVIO; // posiciona verticalmente     if (tamanho == 1) {*** 

`        `***barco1[index1++] = new Coordenada(linha + i, coluna);*** 

`    `***} else if (tamanho == 2) {*** 

`        `***barco2[index2++] = new Coordenada(linha + i, coluna);*** 

`    `***} else {*** 

`        `***barco3[index3++] = new Coordenada(linha + i, coluna);*** 

`    `***}*** 

***}*** 

***posicionado = true;*** 

***}*** 

***}*** 

***}*** 

***return cenario; }*** 

Este trecho do código completa a lógica de posicionamento dos navios, garantindo que todos os navios sejam colocados no tabuleiro de forma aleatória e válida. O cenário gerado é então retornado para o uso do jogo. 

Se a orientação do navio não for horizontal, ele será posicionado preenchendo as células da matriz ***cenario*** na coluna especificada e nas linhas consecutivas a partir da linha inicial. O caractere ***NAVIO(N)*** é utilizado para marcar a presença do navio no tabuleiro. 

Se o navio for de tamanho 1: 

1. Se o tamanho do navio for 1, cria-se  um novo objeto ***Coorenada*** com a posição (linha + i, coluna) e o adiciona ao array ***barco1***.  O índice ***index1*** é incrementado após a inserção. 

Se o navio for de tamanho 2:  

2. Se o tamanho do navio for 2, cria-se um novo objeto ***Coordenada*** com a posição (linha + i, coluna) e o adiciona ao array ***barco2***. O índice ***index2*** é incrementado após a inserção. 

Se o navio for de tamanho 3:  

3. Se o tamanho do navio for diferente de 1 e 2, assume-se que o tamanho é 3. Logo, cria-se um novo objeto ***Coordenada*** com a posição (linha + i, coluna) e o adiciona ao array ***barco3***. O índice ***index3*** é incrementado após a inserção.  

Após todos os navios terem sido posicionados corretamente no tabuleiro, o método retorna 

- cenário completo. 
4. O método retorna a matriz ***cenario***, que representa o tabuleiro com todos os navios posicionados corretamente. 
### 16\. Método Pode Posicionar 
***private static boolean podePosicionar(char[][] cenario, int linha, int coluna, int tamanho, boolean horizontal) {***  

`    `***// verifica a possibilidade de posicionar um barco verificando se já está*** 

`    `***if (horizontal) {***   

`        `***// na borda ou se já tem um barco na linha ou coluna*** 

`        `***if (coluna + tamanho > MAX\_BOARD) return false;*** 

`        `***for (int i = 0; i < tamanho; i++) {*** 

`            `***if (cenario[linha][coluna + i] != AGUA) return false; // verifica se tem um barco na coluna*** 

`        `***}*** 

`    `***} else {*** 

`        `***if (linha + tamanho > MAX\_BOARD) return false;*** 

`        `***for (int i = 0; i < tamanho; i++) {*** 

`            `***if (cenario[linha + i][coluna] != AGUA) return false; // verifica se tem um barco na linha*** 

`        `***}*** 

`    `***}*** 

`    `***return true; // se não encontrou nenhum problema retorna podePosicionar como verdadeiro***   

***}*** 

Neste método, vamos verificar se é possível posicionar um navio no tabuleiro, garantindo que ele não ultrapasse os limites do tabuleiro e que não colida com outros navios. 

1. **private static boolean podePosicionar(char[][] cenario, int linha, int coluna, int tamanho, boolean horizontal):** Irá definir um método estático e privado que retorna um valor booleano. Recebe como parâmetros o tabuleiro (***cenário***), a linha e coluna iniciais (***linha, coluna***), o tamanho do navio (***tamanho***) e a orientação (***horizontal***). 

Se a Orientação do navio for horizontal:  

2. **if (horizontal) {** 

   Verifica se o navio cabe no tabuleiro sem ultrapassar os limites na horizontal. 

   **if (coluna + tamanho > MAX\_BOARD) return false;** 

   Se a soma da coluna inicial com o tamanho do navio for maior que o tamanho máximo do tabuleiro (***MAX\_BOARD***), retorna ***false***. 

   **for (int i = 0; i < tamanho; i++) {** Itera sobre o tamanho do navio. 

   **if (cenario[linha][coluna + i] != AGUA) return false;** 

   Se alguma célula na linha especificada e colunas consecutivas já contiver um navio, retorna ***false***. 

Se a orientação do navio for na vertical: 

3. **} else {** 

   Verifica se o navio cabe no tabuleiro sem ultrapassar os limites na vertical 

   **if (linha + tamanho > MAX\_BOARD) return false;** 

   Se a soma da linha vertical com o tamanho do navio for maior que o tamanho máximo do tabuleiro (***MAX\_BOARD***), retorne false. 

   **for (int i = 0; i < tamanho; i++) {** Itera sobre o tamanho do navio. 

   ***if (cenario[linha + i][coluna] != AGUA) return false;*** 

   Se alguma célula na coluna especificada e linhas consecutivas já contiver um navio, retorna ***false***. 

4. Retorno Verdadeiro 

   **return true;** 

   Se todos as verificações forem concluídas sem encontrar problemas, retorna ***true***, indicando que é possível posicionar o navio na posição especificada. 
   ### 17\. Método Exibir Cenário 
***public static void exibirCenario(char[][] cenario, boolean ocultarEmbarcacoes) {***  

`    `***System.out.print("  ");*** 

`    `***for (int i = 0; i < MAX\_BOARD; i++) {***  

`        `***System.out.print(i + " ");*** 

`    `***}*** 

`    `***System.out.println();*** 

***}*** 

O método ***exibirCenario*** é responsável por imprimir o tabuleiro do Jogo. O método também tem a opção de ocultar as embarcações se necessário.] 

1. **public static void exibirCenario(char[][] cenario, boolean ocultarEmbarcacoes)**: Definirá um método estático público que não retorna nenhum valor (***void***). Recebe como parâmetros o tabuleiro (***cenario***) e um valor booleano 

   (***ocultarEmbarcacoes***) que indica se as embarcações devem ser ocultadas na exibição. 

2. **System.out.print(" ");:** 

   Imprimirá dois espaços para alinhar a legenda superior com o tabuleiro. 

3. **for (int i = 0; i < MAX\_BOARD; i++) {:** 

   Itera sobre o tamanho máximo do tabuleiro (***MAX\_BOARD***). 

4. **System.out.print(i + " ");:** 

   Imprimirá os números das colunas (0, 1, 2, ...) seguidos de um espaço, formando a legenda superior. 

5. **System.out.println();:** 

   Adiciona uma nova linha após a impressão da legenda superior. 

Para cada linha do tabuleiro, imprime o número da linha seguido pelos caracteres que representam o conteúdo das células (água, navio, etc.): 
### 18\. Impressão do Tabuleiro do Jogo 
***for (int i = 0; i < MAX\_BOARD; i++) { // legenda lateral*** 

`    `***System.out.print(i + " ");*** 

`    `***for (int j = 0; j < MAX\_BOARD; j++) {***  

`        `***if (ocultarEmbarcacoes && cenario[i][j] == NAVIO) {             System.out.print(AGUA + " ");*** 

`        `***} else {*** 

`            `***System.out.print(cenario[i][j] + " ");*** 

`        `***}*** 

`    `***}*** 

`    `***System.out.println();*** 

***}*** 

***}*** 

Neste trecho do código, o laço ***for*** vai percorrer todas as linhas do tabuleiro. Ele será responsável por imprimir o tabuleiro completo do jogo, incluindo a legenda lateral e as células do tabuleiro. Ele também considera a opção de ocultar os navios, imprimindo água no lugar dos navios, se necessário. 

1. **System.out.print(i + " ");:** 

   Este comando irá imprimir o número da linha, seguido de um espaço, formando a legenda lateral. 

O laço aninhado irá percorrer todas as colunas de cada linha do tabuleiro. 

2. Se a opção de ocultar embarcações (***ocultarEmbarcacoes***) for verdadeira e a célula atual contiver um navio (***cenario[i][j] == NAVIO***), será imprimido o caractere ***AGUA(~)*** no lugar do navio para ocultar sua presença. 
2. Caso contrário, imprimirá o conteúdo real da célula (***cenário[i][j]***). 
2. **System.out.println();** 

   Adicionará uma nova linha após a impressão de todas as células de uma linha. 

5. O laço interno é fechado e o método ***exibirCenario*** também é finalizado. 
### 19\. Método Realizar Jogada 
***public static void realizarJogada(Scanner scanner, char[][] cenarioAdversario, boolean[][] ataques) {***   

`    `***int linha, coluna;*** 

***}*** 

Este método permite que o jogador realize uma jogada, escolhendo uma célula no tabuleiro do adversário para atacar. Ele é fundamental para processar a jogada de um jogador, coletando as coordenadas de ataque e atualizando o tabuleiro do adversário conforme necessário. 

1. **public static void realizarJogada(Scanner scanner, char[][] cenarioAdversario, boolean[][] ataques)** 

   Definirá um método estático público que não retorna nenhum valor (**void**). Recebe como parâmetros um objeto **Scanner (scanner)** para leitura da entrada do jogador, 

- tabuleiro do adversário (cenarioAdversario) e uma matriz booleana (***ataques***) para registrar os ataques realizados. 
2. **int linha, coluna;** 

   Declara as variáveis ***linha*** e ***coluna*** que serão usadas para armazenar as coordenadas da jogada escolhida pelo jogador. 
### 20\. Coleta e Validação de coordenadas da Jogada 
***while (true) {*** 

`    `***System.out.print("Digite a linha (0-" + (MAX\_BOARD - 1) + "): ");*** 

`    `***linha = scanner.nextInt();*** 

`    `***System.out.print("Digite a coluna (0-" + (MAX\_BOARD - 1) + "): ");     coluna = scanner.nextInt();*** 

`    `***if (linha < 0 || linha >= MAX\_BOARD || coluna < 0 || coluna >= MAX\_BOARD) {         System.out.println("Coordenadas inválidas. Tente novamente.");*** 

`    `***} else if (verificarAtaqueRepetido(ataques, linha, coluna)) {*** 

`        `***System.out.println("Posição já atacada. Tente novamente.");*** 

`    `***} else {*** 

`        `***break;*** 

`    `***}*** 

***}*** 

Aqui, vamos solicitar ao jogador que insira as coordenadas da linha e coluna onde deseja realizar um ataque, verificando se as coordenadas são válidas e se a posição já foi atacada anteriormente. 

1. **while (true) {**  

   Iniciará um laço infinito que continuará executando até que uma condição de saída seja satisfeita. 

2. **System.out.print("Digite a linha (0-" + (MAX\_BOARD - 1) + "): ");** Solicitará ao jogador que insira o número da linha, indicando o intervalo válido (0 a ***MAX\_BOARD*** 
   1. ***1***). 
2. **linha = scanner.nextInt();** 

   Lê a entrada do jogador e armazena o valor na variável ***linha***. 

4. **System.out.print("Digite a coluna (0-" + (MAX\_BOARD - 1) + "): ");** 

   Solicitará ao jogador que insira o número da coluna, indicando o intervalo válido (0 a 

   ***MAX\_BOARD - 1***). 

5. **coluna = scanner.nextInt();** 

   Lê a entrada do jogador e armazena o valor na variável ***coluna***. 

6. **if (linha < 0 || linha >= MAX\_BOARD || coluna < 0 || coluna >= MAX\_BOARD) {** 

   Verificará se as coordenadas da linha ou da coluna estão fora dos limites válidos do tabuleiro. 

7. **System.out.println("Coordenadas inválidas. Tente novamente.");** 

   Se as coordenadas forem inválidas, exibirá uma mensagem de erro e solicitará que 

- jogador tente novamente. 
8. **else if (verificarAtaqueRepetido(ataques, linha, coluna)) {** 

   Verificará se a posição especificada pela linha e coluna já foi atacada anteriormente. 

9. **System.out.println("Posição já atacada". Tente novamente.");** 

   Se a posição já foi atacada, exibirá uma mensagem de erro e solicitará que o jogador tente novamente. 

10. **else {** 

    **break;** 

    Se as coordenadas forem válidas e a posição não tiver sido atacada anteriormente, 

- laço será interrompido e sairá do laço infinito. 
### 21\. Realização do Ataque e Atualização do Cenário 
***boolean acerto = realizarAtaque(cenário Adversário, linha, coluna); atualizarCenario(cenario Adversário, linha, coluna, acerto);*** 

Este bloco de código garante que o ataque seja realizado no tabuleiro do adversário e que o tabuleiro seja atualizado com o resultado do ataque. 

1. **boolean acerto = realizarAtaque(cenarioAdversario, linha, coluna);** Chamará o método ***realizarAtaque*** passando como parâmetros o tabuleiro do adversário (***cenarioAdversario***), a linha e a coluna onde o ataque foi realizado. 

   O método ***realizarAtaque*** retornará um valor booleano (***true*** ou ***false***) que indicará se o ataque foi um acerto ou não, e esse valor será armazenado na variável ***acerto***. 

2. **atualizarCenario(cenarioAdversario, linha, coluna, acerto);** 

   Chamará o método ***atualizarCenario*** passando como parâmetros o tabuleiro do adversário (***cenarioAdversario***), a linha e a coluna onde o ataque foi realizado, e 

- resultado do ataque (***acerto***). 

O método ***atualizarCenario*** atualizará o tabuleiro do adversário com o resultado do ataque, marcando a célula correspondente como um acerto ou um erro. 
### 22\. Verificação das Embarcações Afundadas e Mensagens 
***boolean b1 Afundado = verificarEm barcacaoAfundada(cenarioAdversario, barco1, 1); if (b1 Afundado) {*** 

`    `***System.out.println("\Barco 1 do jogador afundado!");*** 

***}***  

***boolean b2Afundado = verificarEmbarcacaoAfundada(cenarioAdversario, barco2, 2); if (b2Afundado) {*** 

`    `***System.out.println("Barco 2 do jogador afundado!");*** 

***}***  

***boolean b3Afundado = verificarEmbarcacaoAfundada(cenarioAdversario, barco3, 3); if (b3Afundado) {*** 

`    `***System.out.println("Barco 3 do jogador afundado!");*** 

***}*** 

Este trecho de código garante que cada embarcação seja verificada individualmente para determinar se foi afundada, e exibe mensagens apropriadas para informar o jogador sobre o estado de suas embarcações. 

1. **boolean b1Afundado = verificarEmbarcacaoAfundada(cenarioAdversario, barco1, 1);** 

   Chamará o método ***verificarEmbarcacaoAfundada*** passando como parâmetros o tabuleiro do adversário (***cenarioAdversario***), as coordenadas do barco 1 (***barco1***) e 

- tamanho do barco (1). 

O método retornará um valor booleano (***true*** ou ***false***) indicando se o barco 1 foi afundado, e esse valor será armazenado na variável ***b1Afundado.*** 

2. **if (b1Afundado) {** 

   **System.out.println("\nBarco 1 do jogador afundado!");** 

   Verificará se o barco 1 foi afundado. Se o barco 1 foi afundado, exibirá uma mensagem informando que o barco 1 do jogador foi afundado. 

3. **boolean b2Afundado = verificarEmbarcacaoAfundada(cenarioAdversario, barco2, 2);** 

   Chamará o método ***verificarEmbarcacaoAfundada*** passando como parâmetros o tabuleiro do adversário (***cenarioAdversario***), as coordenadas do barco 2 (***barco2***) e 

- tamanho do barco (2). 

O método retornará um valor booleano (**true** ou **false**) indicando se o barco 2 foi afundado, e esse valor será armazenado na variável ***b2Afundado***. 

4. **if (b2Afundado) {** 

   **System.out.println("Barco 2 do jogador afundado!");** 

   Verificará se o barco 2 foi afundado. Se o barco 2 foi afundado, exibirá uma mensagem informando que o barco 2 do jogador foi afundado. 

5. **boolean b3Afundado = verificarEmbarcacaoAfundada(cenarioAdversario, barco3, 3);** 

   Chamará o método ***verificarEmbarcacaoAfundada*** passando como parâmetros o tabuleiro do adversário (***cenarioAdversario***), as coordenadas do barco 3 (barco3) e 

- tamanho do barco (3). 

O método retornará um valor booleano (***true*** ou ***false***) indicando se o barco 3 foi afundado, e esse valor será armazenado na variável ***b3Afundado***. 

6. **if (b3Afundado) {** 

   **System.out.println("Barco 3 do jogador afundado!");** 

   Verificará se o barco 3 foi afundado. Se o barco 3 foi afundado, exibirá uma mensagem informando que o barco 3 do jogador foi afundado. 
### 23\. Atualização da Matriz de Ataque e Mensagens de Resultado 
***ataques[linha][coluna] = true;*** 

***if (acerto) {*** 

`    `***System.out.println("Acertou um navio!"); } else {*** 

`    `***System.out.println("Errou o ataque.");*** 

***}*** 

***}*** 

Neste bloco, o código é responsável por marcar a posição atacada na matriz de ataques e fornecer feedback ao jogador sobre o resultado de sua jogada, informando se ele acertou ou errou o alvo. 

1. **ataques[linha][coluna] = true;** 

   Atualizará a matriz ataques na posição especificada (linha, coluna) para ***true***, indicando que essa posição foi atacada. 

2. **if (acerto) {** 

   Se o ataque foi um acerto, exibirá a mensagem "Acertou um navio!". 

3. **else {** 

   Se o ataque foi um erro, exibirá a mensagem "Errou o ataque.". 
### 24\. Método Realizar Jogada Computador 
***public static void realizarJogadaComputador(char[][] cenarioAdversario, boolean[][] ataques) {*** 

`    `***Random random = new Random();*** 

`    `***int linha, coluna;*** 

***}*** 

Este método permite que o computador realize uma jogada, escolhendo aleatoriamente uma célula no tabuleiro do adversário para atacar. 

1. **public static void realizarJogadaComputador(char[][] cenarioAdversario, boolean[][] ataques)** 

   Definirá um método estático público que não retornará nenhum valor (***void***). Receberá como parâmetros o tabuleiro do adversário (***cenarioAdversario***) e uma matriz booleana (***ataques***) para registrar os ataques realizados. 

2. **Random random = new Random();** 

   Criará um novo objeto ***Random*** que será usado para gerar números aleatórios. Esse objeto ajudará o computador a escolher aleatoriamente as coordenadas da jogada. 

3. **int linha, coluna;** 

   Declarará as variáveis ***linha*** e ***coluna*** que serão usadas para armazenar as coordenadas da jogada escolhida pelo computador. 
### 25\. Geração de Coordenadas Aleatórias e verificação de Ataques Repetidos 
***while (true) {*** 

`    `***linha = random.nextInt(MAX\_BOARD);*** 

`    `***coluna = random.nextInt(MAX\_BOARD);*** 

`    `***if (!verificarAtaqueRepetido(ataques, linha, coluna)) {         break;*** 

`    `***}*** 

***}*** 

` `Este pedaço do código permitirá que o computador escolha aleatoriamente coordenadas para um ataque que ainda não tenham sido atacadas anteriormente. 

1. **while (true) {** 

   Iniciará um laço infinito que continuará executando até que uma condição de saída seja satisfeita. 

2. **linha = random.nextInt(MAX\_BOARD);** 

   Gerará um número aleatório para a linha dentro dos limites do tabuleiro (***MAX\_BOARD***). 

3. **coluna = random.nextInt(MAX\_BOARD);** 

   Gerará um número aleatório para a coluna dentro dos limites do tabuleiro 

   (***MAX\_BOARD***). 

4. **if (!verificarAtaqueRepetido(ataques, linha, coluna)) {** 

   **break;** 

   **}** 

   Chamará o método ***verificarAtaqueRepetido*** passando a matriz de ataques (ataques) e as coordenadas (linha, coluna). 
### 26\. Execução do Ataque e Atualizações do Cenário para a Jogada do Computador 
***boolean acerto = realizarAtaque(cenarioAdversario, linha, coluna); atualizarCenario(cenarioAdversario, linha, coluna, acerto);*** 

Este trecho do código vai garantir que o ataque seja realizado no tabuleiro do adversário e que o tabuleiro seja atualizado com o resultado do ataque. 

1. **boolean acerto = realizarAtaque(cenarioAdversario, linha, coluna);** Chamará o método ***realizarAtaque*** passando como parâmetros o tabuleiro do adversário (cenarioAdversario), a linha e a coluna onde o ataque foi realizado. 

   O método ***realizarAtaque*** retornará um valor booleano (***true*** ou ***false***) indicando se 

- ataque foi um acerto ou não, e esse valor será armazenado na variável acerto. 
2. **atualizarCenario(cenarioAdversario, linha, coluna, acerto);** 

   Chamará o método ***atualizarCenario*** passando como parâmetros o tabuleiro do adversário (cenarioAdversario), a linha e a coluna onde o ataque foi realizado, e o resultado do ataque (acerto). 

   O método ***atualizarCenario*** atualizará o tabuleiro do adversário com o resultado do ataque, marcando a célula correspondente como um acerto ou um erro. 
### 27\. Verificação da Embarcações Afundadas pelo Computador e Mensagens 
***boolean b1Afundado = verificarEmbarcacaoAfundada(cenarioAdversario,*** 

***barco1, 1);*** 

***if (b1Afundado) {*** 

`    `***System.out.println("\nBarco 1 da máquina afundado!");*** 

***}*** 

***boolean b2Afundado = verificarEmbarcacaoAfundada(cenarioAdversario, barco2, 2);*** 

***if (b2Afundado) {*** 

`    `***System.out.println("Barco 2 da máquina afundado!");*** 

***}*** 

***boolean b3Afundado = verificarEmbarcacaoAfundada(cenarioAdversario, barco3, 3);*** 

***if (b3Afundado) {*** 

`    `***System.out.println("Barco 3 da máquina afundado!");*** 

***}*** 

Este trecho do código garante que cada embarcação da máquina seja verificada individualmente para determinar se foi afundada, e exibe mensagens apropriadas para informar sobre o estado das embarcações da máquina. 

1. **boolean b1Afundado = verificarEmbarcacaoAfundada(cenarioAdversario, barco1, 1);** 

   Chamará o método ***verificarEmbarcacaoAfundada*** passando como parâmetros o tabuleiro do adversário (***cenarioAdversario***), as coordenadas do barco 1 (barco1) e 

- tamanho do barco (1). 

O método retornará um valor booleano (true ou false) indicando se o barco 1 foi afundado, e esse valor será armazenado na variável ***b1Afundado***. 

2. **if (b1Afundado) {** 

   **System.out.println("\nBarco 1 da máquina afundado!");** 

   Verificará se o barco 1 foi afundado. Se o barco 1 foi afundado, exibirá uma mensagem informando que o barco 1 da máquina foi afundado. 

3. **boolean b2Afundado = verificarEmbarcacaoAfundada(cenarioAdversario, barco2, 2);** 

   Chamará o método ***verificarEmbarcacaoAfundada*** passando como parâmetros o tabuleiro do adversário (***cenarioAdversario***), as coordenadas do barco 2 (barco2) e 

- tamanho do barco (2). 

O método retornará um valor booleano (***true*** ou ***false***) indicando se o barco 2 foi afundado, e esse valor será armazenado na variável ***b2Afundado***. 

4. **if (b2Afundado) {** 

   **System.out.println("Barco 2 da máquina afundado!");** 

   Verificará se o barco 2 foi afundado. Se o barco 2 foi afundado, exibirá uma mensagem informando que o barco 2 da máquina foi afundado. 

5. **boolean b3Afundado = verificarEmbarcacaoAfundada(cenarioAdversario, barco3, 3);** 

   Chamará o método ***verificarEmbarcacaoAfundada*** passando como parâmetros o tabuleiro do adversário (***cenarioAdversario***), as coordenadas do barco 3 (***barco3***) e 

- tamanho do barco (3). 

O método retornará um valor booleano (***true*** ou ***false***) indicando se o barco 3 foi afundado, e esse valor será armazenado na variável ***b3Afundado***. 

6. **if (b3Afundado) {** 

   **System.out.println("Barco 3 da máquina afundado!");** 

   Verificará se o barco 3 foi afundado. Se o barco 3 foi afundado, exibirá uma mensagem informando que o barco 3 da máquina foi afundado. 
### 28\. Atualização da Matriz de Ataques e Mensagens de Resultado para o Computador 
***ataques[linha][coluna] = true;*** 

***System.out.println("Computador atacou em (" + linha + ", " + coluna + ") e " + (acerto ? "acertou!" : "errou."));*** 

***}*** 

1. **ataques[linha][coluna] = true;**  

   Atualizará a matriz ataques na posição especificada (linha, coluna) para ***true***, indicando que essa posição foi atacada pelo computador. 

2. **System.out.println("Computador atacou em (" + linha + ", " + coluna + ") e " + (acerto ? "acertou!" : "errou."));** 

   Exibirá uma mensagem no console informando a posição do ataque realizado pelo computador e o resultado do ataque. 

   Utilizará uma expressão condicional ***(acerto ? "acertou!" : "errou.")*** para determinar se o ataque foi um acerto ou um erro. 

   A mensagem terá o seguinte formato: 

   ***"Computador atacou em (linha, coluna) e acertou!"*** se o ataque foi um acerto. ***"Computador atacou em (linha, coluna) e errou."*** se o ataque foi um erro. 
### 29\. Método Realizar Ataque 
***public static boolean realizarAtaque(char[][] cenarioAdversario, int linha, int coluna) {     boolean ataqueRealizado = cenarioAdversario[linha][coluna] == NAVIO;***      

`    `***return ataqueRealizado;*** 

***}*** 

Este método verificará se um ataque realizado em uma determinada posição do tabuleiro do adversário foi um acerto ou não. 

1. **public static boolean realizarAtaque(char[][] cenarioAdversario, int linha, int coluna)** 

   Definir um método estático público que retornará um valor booleano (***true*** ou ***false***). Receberá como parâmetros o tabuleiro do adversário (***cenarioAdversario***), a linha e a coluna onde o ataque foi realizado. 

2. **boolean ataqueRealizado = cenarioAdversario[linha][coluna] == NAVIO;** Verificará se a célula na posição especificada (linha, coluna) contém um navio (NAVIO). 

   Se a célula contiver um navio, a variável ***ataqueRealizado*** será **true**. 

   Caso contrário, ***ataqueRealizado*** será ***false***. 

3. **return ataqueRealizado;** 

   Retornará o valor da variável ***ataqueRealizado***, indicando se o ataque foi um acerto (***true***) ou não (***false***). 
### 30\. Método Verificar Embarcação Afundada 
***public static boolean verificarEmbarcacaoAfundada(char[][] cenario, Coordenada[] barco, int tamanhoEmbarcacao) {*** 

`    `***int acertos = 0;*** 

***}*** 

1. **public static boolean verificarEmbarcacaoAfundada(char[][] cenario, Coordenada[] barco, int tamanhoEmbarcacao)** 

   Definirá um método estático público que retorna um valor booleano (***true*** ou ***false***).  Receberá como parâmetros o tabuleiro (***cenario***), as coordenadas da embarcação (barco) e o tamanho da embarcação (***tamanhoEmbarcacao***). 

2. **int acertos = 0;** 

   Declarará e inicializará a variável ***acertos*** que será usada para contar quantas partes da embarcação foram acertadas. 
### 31\. Verificação das Posições Atingidas em um Embarcação 
***for (Coordenada c : barco) {*** 

`    `***if (cenario[c.i][c.j] == ACERTO) {*** 

`        `***acertos++;*** 

`    `***}*** 

***}*** 

***return acertos == tamanhoEmbarcacao;  }*** 

Este bloco de código faz parte do método ***verificarEmbarcacaoAfundada*** e itera sobre as coordenadas de uma embarcação, verificando se cada parte dela foi acertada. 

1. **public static boolean verificarEmbarcacaoAfundada(char[][] cenario, Coordenada[] barco, int tamanhoEmbarcacao)** 

   Definirá um método estático público que retornará um valor booleano (***true*** ou ***false***). Receberá como parâmetros o tabuleiro (***cenario***), as coordenadas da embarcação (barco) e o tamanho da embarcação (***tamanhoEmbarcacao***). 

2. **int acertos = 0;** 

   Irá declarar e inicializará a variável acertos que será usada para contar quantas partes da embarcação foram acertadas. 

3. **for (Coordenada c : barco) {** 

   Utilizará um laço ***for-each*** para iterar sobre cada coordenada no array ***barco***. 

4. **if (cenario[c.i][c.j] == ACERTO) {** 

   **acertos++;** 

   Verificará se a célula na posição especificada pela coordenada **(c.i, c.j)** contém o valor ***ACERTO***, indicando que foi atingida por um ataque. 

5. r**eturn acertos == tamanhoEmbarcacao;** 

   Retornará ***true*** se o número de acertos for igual ao tamanho da embarcação, indicando que todas as partes da embarcação foram acertadas e ela foi afundada. 

   Caso contrário, retorna ***false***. 
### 32\. Método Verificar Ataque Repetido 
` `***public static boolean verificarAtaqueRepetido(boolean[][] ataques, int linha, int coluna) {*** 

`    `***return ataques[linha][coluna]; // se o vetor de ataque nessas coordenadas já existir então retorna true*** 

***}*** 

Este método é utilizado para verificar se uma posição no tabuleiro já foi atacada antes, ajudando a evitar ataques repetidos na mesma posição. 

1. **public static boolean verificarAtaqueRepetido(boolean[][] ataques, int linha, int coluna)** 

   Definirá um método estático público que retorna um valor booleano (***true*** ou ***false***). Receberá como parâmetros a matriz de ataques (***ataques***), a linha (***linha***) e a coluna (***coluna***) da posição a ser verificada. 

2. **return ataques[linha][coluna];** 

   Retornará o valor da posição especificada na matriz ***ataques***. 

   Se a posição (***linha***, ***coluna***) já foi atacada anteriormente, o valor retornado será ***true***. 

   Caso contrário, o valor retornado será ***false***. 
### 33\. Método Atualizar Cenário 
***public static void atualizarCenario(char[][] cenario, int linha, int coluna, boolean acerto) {*** 

` `***cenario[linha][coluna] = acerto ? ACERTO : ERRO; // se acerto = true, então marca um acerto no tabuleiro, caso contrário marca um erro*** 

***}*** 

Este método é responsável por atualizar o tabuleiro do jogo para refletir o resultado de um ataque, garantindo que a célula atacada seja marcada corretamente como um acerto ou um erro.  

1. **public static void atualizarCenario(char[][] cenario, int linha, int coluna, boolean acerto)** 

   Definirá um método estático público que não retorna nenhum valor (***void***). Receberá como parâmetros o tabuleiro (***cenario***), a linha (linha) e a coluna (coluna) da posição a ser atualizada, além de um valor booleano (***acerto***) indicando se o ataque foi um acerto ou um erro. 

2. **cenario[linha][coluna] = acerto ? ACERTO : ERRO;** 

   Utilizará uma expressão condicional (***acerto ? ACERTO : ERRO***) para determinar o valor a ser atribuído à célula atacada. 

   Se o ataque foi um acerto (***acerto for true***), a célula na posição especificada (linha, coluna) será marcada com o valor ***ACERTO***. 

   Se o ataque foi um erro (***acerto for false***), a célula na posição especificada (linha, coluna) será marcada com o valor ***ERRO***. 
### 34\. Método Contar Embarcações Afundadas 
***public static int contarEmbarcacoesAfundadas(char[][] cenario) {     int embarcacoesAfundadas = 0;*** 

***}*** 

Este método será responsável por percorrer o tabuleiro do jogo e contar quantas embarcações foram totalmente afundadas, atualizando a variável ***embarcacoesAfundadas*** conforme necessário. 

1. **public static int contarEmbarcacoesAfundadas(char[][] cenario)**:  Declarará um método público e estático chamado ***contarEmbarcacoesAfundadas***. O método receberá uma matriz bidimensional de caracteres (***cenario***) que representará o tabuleiro do jogo. O método retornará um inteiro que indica o número de embarcações afundadas. 
1. **int embarcacoesAfundadas = 0**:  

   Declarará e inicializará uma variável inteira chamada ***embarcacoesAfundadas*** com 

- valor 0. Esta variável será utilizada para contar o número de embarcações que foram completamente afundadas no tabuleiro. 
### 35\. Verificação e Contagem das Embarcações Afundadas 
***// Verifica cada barco (barco1, barco2, barco3)*** 

***if (verificarEmbarcacaoAfundada(cenario, barco1, 1)) {     embarcacoesAfundadas++;*** 

***}*** 

***if (verificarEmbarcacaoAfundada(cenario, barco2, 2)) {     embarcacoesAfundadas++;*** 

***}*** 

***if (verificarEmbarcacaoAfundada(cenario, barco3, 3)) {     embarcacoesAfundadas++;*** 

***}*** 

***return embarcacoesAfundadas; }*** 

Este trecho de código verificará se cada barco foi afundado e incrementa a contagem de embarcações afundadas de acordo. 

1. **if (verificarEmbarcacaoAfundada(cenario, barco1, 1)) {** 

   Chamará o método ***verificarEmbarcacaoAfundada*** passando como parâmetros o tabuleiro (***cenario***), as coordenadas do barco 1 (barco1) e o tamanho do barco (1). 

   Se o método retornar ***true***, indicando que o barco 1 foi afundado, a contagem ***embarcacoesAfundadas*** será incrementada. 

2. **if (verificarEmbarcacaoAfundada(cenario, barco2, 2)) {** 

   Chamará o método ***verificarEmbarcacaoAfundada*** passando como parâmetros o tabuleiro (***cenario***), as coordenadas do barco 2 (***barco2***) e o tamanho do barco (2). 

   Se o método retornar ***true***, indicando que o barco 2 foi afundado, a contagem ***embarcacoesAfundadas*** será incrementada. 

3. **if (verificarEmbarcacaoAfundada(cenario, barco3, 3)) {** 

   Chamará o método ***verificarEmbarcacaoAfundada*** passando como parâmetros o tabuleiro (***cenario***), as coordenadas do barco 3 (***barco3***) e o tamanho do barco (3). 

   Se o método retornar ***true***, indicando que o barco 3 foi afundado, a contagem ***embarcacoesAfundadas*** será incrementada. 

4. **return embarcacoesAfundadas;** 

   Retornará o valor da variável ***embarcacoesAfundadas***, indicando o número total de embarcações afundadas no tabuleiro. 
### 36\. Método Verificar Vitória 
***public static boolean verificarVitoria(char[][] cenario) {   }*** 

Este método verificará se todas as células que continham navios (***NAVIO***) no tabuleiro foram atingidas, indicando que o jogador venceu o jogo. 

**1.  public static boolean verificarVitoria(char[][] cenario)** 

Definirá um método estático público que retorna um valor booleano (***true*** ou ***false***). O método receberá uma matriz bidimensional de caracteres (***cenario***) que representa o tabuleiro do jogo. O método retornará um valor booleano indicando se a condição de vitória foi alcançada. 
### 37\. Verificação da Condição de Vitória 
***for (int i = 0; i < MAX\_BOARD; i++) {*** 

`    `***for (int j = 0; j < MAX\_BOARD; j++) {*** 

`        `***if (cenario[i][j] == NAVIO) {             return false;*** 

`        `***}*** 

`    `***}*** 

***}*** 

***return true;*** 

***}*** 

Este método percorrerá todo o tabuleiro para verificar se todas as células contendo navios foram acertadas, determinando se o jogador venceu o jogo. 

1. **for (int i = 0; i < MAX\_BOARD; i++) {** 

   O laço ***for*** percorrerá todas as linhas do tabuleiro. 

2. **for (int j = 0; j < MAX\_BOARD; j++) {** 

   O laço aninhado ***for*** percorrerá todas as colunas de cada linha do tabuleiro. 

3. **if (cenario[i][j] == NAVIO) {** 

   Verificará se a célula na posição especificada ***(i, j)*** contém um navio ***(NAVIO)***. 

4. **return false;** 

   Se encontrar qualquer célula contendo um navio, retornará ***false***, indicando que a vitória não foi alcançada. 

5. **return true;** 

   Se o laço iterar por todas as células do tabuleiro sem encontrar um navio (***NAVIO***), retornará ***true***, indicando que todos os navios foram afundados e a vitória foi alcançada. 

# 38. Tratamento De Erros 

O programa conta com tratamento de erros incluso dentro de suas funções onde é prevenida por exemplo, a não repetição de coordenadas por parte do usuário, assim como também a prevenção contra coordenadas de fora da área de tabuleiro  

***if (linha < 0 || linha >= MAX\_BOARD || coluna < 0 || coluna >= MAX\_BOARD) { System.out.println(" Coordenadas inválidas. Tente novamente.\n");*** 

***} else if (verificarAtaqueRepetido(ataques, linha, coluna)) { System.out.println(" PosiC'C#o já atacada. Tente novamente.\n");*** 

***} else {*** 

***break;*** 

***}*** 

# 39. Conclusão 

Este documento forneceu uma explicação detalhada das funcionalidades e lógicas implementadas para um jogo de tabuleiro baseado em batalha naval. Aqui está um resumo das principais seções abordadas: 

1. **Registro das Coordenadas dos Navios**: Explicação da lógica para registrar as posições dos navios no tabuleiro, garantindo que cada posição ocupada seja corretamente armazenada para rastreamento durante o jogo. 
1. **Posicionamento Vertical dos Navios e Retorno do Cenário**: Detalhamento da lógica para posicionar navios verticalmente e como retornar o tabuleiro atualizado após o posicionamento. 
1. **Verificação da Possibilidade de Posicionar Navios**: Processo de verificação para garantir que um navio pode ser posicionado em determinadas coordenadas sem ultrapassar os limites do tabuleiro ou colidir com outros navios. 
1. **Exibição do Tabuleiro do Jogo**: Métodos para imprimir o tabuleiro no console, incluindo a configuração das legendas superiores e laterais, e a exibição das células do tabuleiro com a opção de ocultar embarcações. 
1. **Realização de Jogadas**: Implementação da lógica para processar as jogadas dos jogadores, incluindo a coleta e validação das coordenadas de ataque, realização do ataque, atualização do tabuleiro e verificação de embarcações afundadas. 
1. **Jogada do Computador**: Procedimentos para a jogada do computador, incluindo a geração de coordenadas aleatórias, verificação de ataques repetidos, realização do ataque e atualização do tabuleiro. 
1. **Verificação e Atualização do Cenário**: Métodos para verificar se um ataque atingiu um navio e atualizar o tabuleiro conforme o resultado do ataque. 
1. **Contagem de Embarcações Afundadas**: Lógica para contar o número de embarcações completamente afundadas no tabuleiro, ajudando a monitorar o progresso do jogo. 
1. **Verificação da Condição de Vitória**: Procedimento para verificar se todas as embarcações foram afundadas, indicando a vitória de um jogador. 

Com essas documentações e explicações detalhadas, fica claro como cada parte do código contribui para a funcionalidade e a mecânica do jogo. Essas anotações são essenciais para entender a lógica por trás das operações, facilitando a manutenção, atualização e possível extensão do código no futuro.*** 


