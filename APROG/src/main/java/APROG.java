import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class APROG {

    static final int MAX_PAISES = 32;
    static final int MAX_DADOS = 9;
    static final int MAX_ID = 2;

    public static void main(String[] args) throws FileNotFoundException, IOException {
        String[][] id = new String[MAX_PAISES][MAX_ID];
        int[][] dados = new int[MAX_PAISES][MAX_DADOS]; // a info dos dados estao da seguinte forma 0 -> J; 1 -> V; 2 -> E; 3 -> D; 4 -> GM; 5 -> GS; 6 -> GD (GM - GS); 7 -> Posicao; (8 -> Pontos)
        int qnt = 0, verificacao = 0;
        String resposta;

        Scanner ler = new Scanner(System.in);
        String comando = "";
        System.out.printf("\n\n%-75s\n\n%-75s%s\n%-75s%s\n%-75s%s\n%-75s%s\n%-75s%s\n%-75s%s\n%-75s%s\n%-75s%s\n%-75s%s\n%-75s%s\n%-75s%s\n%-75s%s\n%-75s%s\n%-75s%s\n%-75s%s\n%-75s%s\n\n\n", "ESCOLHA UM COMANDO:", "Lista de Comandos:", "(comandos)", "Terminar o programa:", "(fim)", "Preencher as equipas com os dados do ficheiro PracticalWork.csv", "(1)", "Calcular a quantidade de equipas que existe em memoria", "(2)", "Calcular a pontacao de cada equipa em memoria", "(3)", "Classificar e organizar todas as equipas em memoria", "(4)", "Acrescentar Informacao:", "(5)", "Listar Classificacoes por Grupo:", "(6)", "Listar Equipas com max Golos Marcados:", "(7)", "Listar Equipas com n Golos Sofridos:", "(8)", "Listar Equipas com mais Golos Sofridos do que Golos Marcados:", "(9)", "Listar Primeiro Classificado por Grupo:", "(10)", "Indicar a informacao de uma equipa especifica", "(11)", "Criar um ficheiro de texto com as estatisticas dos jogos", "(12)", "Criar um ficheiro com as equipas que vao disputar a Fase Final", "(13)", "Criar um ficheiro de texto com os jogos da Fase Final", "(14)");

        while (!comando.equals("fim")) {
            System.out.printf("\n\n%s", "Digite o comando que deseja: ");
            comando = ler.next();
            switch (comando) {

                case ("comandos"):

                    System.out.printf("\n\n%-75s\n\n%-75s%s\n%-75s%s\n%-75s%s\n%-75s%s\n%-75s%s\n%-75s%s\n%-75s%s\n%-75s%s\n%-75s%s\n%-75s%s\n%-75s%s\n%-75s%s\n%-75s%s\n%-75s%s\n%-75s%s\n%-75s%s\n\n\n", "ESCOLHA UM COMANDO:", "Lista de Comandos:", "(comandos)", "Terminar o programa:", "(fim)", "Preencher as equipas com os dados do ficheiro PracticalWork.csv", "(1)", "Calcular a quantidade de equipas que existe em memoria", "(2)", "Calcular a pontacao de cada equipa em memoria", "(3)", "Classificar e organizar todas as equipas em memoria", "(4)", "Acrescentar Informacao:", "(5)", "Listar Classificacoes por Grupo:", "(6)", "Listar Equipas com max Golos Marcados:", "(7)", "Listar Equipas com n Golos Sofridos:", "(8)", "Listar Equipas com mais Golos Sofridos do que Golos Marcados:", "(9)", "Listar Primeiro Classificado por Grupo:", "(10)", "Indicar a informacao de uma equipa especifica", "(11)", "Criar um ficheiro de texto com as estatisticas dos jogos", "(12)", "Criar um ficheiro com as equipas que vao disputar a Fase Final", "(13)", "Criar um ficheiro de texto com os jogos da Fase Final", "(14)");
                    break;

                case ("fim"):
                    System.out.println("Muito obrigada por usar o nosso programa!");
                    break;

                case ("1"): //Preencher as equipas com os dados do ficheiro "PracticalWork.csv"
                    preencher(id, dados);
                    verificacao++;
                    break;

                case ("2"): // Calcular a quantidade de equipas que existe em memoria
                    quantidadeEquipas(dados);
                    diferencaGolos(dados, qnt);
                    verificacao++;
                    break;

                case ("3"): //Calcular a pontacao de cada equipa em memoria
                    pontuacao(dados);
                    verificacao++;
                    break;

                case ("4"): //Classificar e organizar todas as equipas em memoria
                    classificacoes(id, dados);
                    verificacao++;
                    break;

                case ("5"):  //acrescentar info
                    acrescentar(id, dados);
                    qnt = quantidadeEquipas(dados);
                    diferencaGolos(dados, qnt);
                    pontuacao(dados);
                    classificacoes(id, dados);
                    verificacao = 4;
                    break;

                case ("6"):  //listar classificaoes por grupo
                    if (dados[0][0] != 0 && verificacao == 4) {
                        listarClassificacoes(id, dados, qnt);
                        break;
                    } else {
                        System.out.println("Nao tem quaisquer dados em memoria");
                        System.out.println("Deseja executar os comandos 1, 2, 3 e 4? (Sim/Nao)");
                        resposta = ler.next();
                        if (resposta.equalsIgnoreCase("sim")) {
                            preencher(id, dados);
                            qnt = quantidadeEquipas(dados);
                            diferencaGolos(dados, qnt);
                            pontuacao(dados);
                            classificacoes(id, dados);
                            verificacao = 4;
                            break;
                        }
                        break;
                    }

                case ("7"):  //Listar Equipas com max Golos Marcados
                    if (dados[0][0] != 0 && verificacao == 4) {
                        listarGolosMarcados(id, dados, qnt);
                        break;
                    } else {
                        System.out.println("Nao tem quaisquer dados em memoria");
                        System.out.println("Deseja executar os comandos 1, 2, 3 e 4? (Sim/Nao)");
                        resposta = ler.next();
                        if (resposta.equalsIgnoreCase("sim")) {
                            preencher(id, dados);
                            qnt = quantidadeEquipas(dados);
                            diferencaGolos(dados, qnt);
                            pontuacao(dados);
                            classificacoes(id, dados);
                            verificacao = 4;
                            break;
                        }
                        break;
                    }
                case ("8"):  //Listar Equipas com n Golos Sofridos
                    if (dados[0][0] != 0 && verificacao == 4) {
                        listarGolosSofridos(id, dados, qnt);
                        break;
                    } else {
                        System.out.println("Nao tem quaisquer dados em memoria");
                        System.out.println("Deseja executar os comandos 1, 2, 3 e 4? (Sim/Nao)");
                        resposta = ler.next();
                        if (resposta.equalsIgnoreCase("sim")) {
                            preencher(id, dados);
                            qnt = quantidadeEquipas(dados);
                            diferencaGolos(dados, qnt);
                            pontuacao(dados);
                            classificacoes(id, dados);
                            verificacao = 4;
                            break;
                        }
                        break;
                    }
                case ("9"):  //Listar Equipas com mais Golos Sofridos do que Golos Marcados
                    if (dados[0][0] != 0 && verificacao == 4) {
                        maisSofridos_Marcados(id, dados, qnt);
                        break;
                    } else {
                        System.out.println("Nao tem quaisquer dados em memoria");
                        System.out.println("Deseja executar os comandos 1, 2, 3 e 4? (Sim/Nao)");
                        resposta = ler.next();
                        if (resposta.equalsIgnoreCase("sim")) {
                            preencher(id, dados);
                            qnt = quantidadeEquipas(dados);
                            diferencaGolos(dados, qnt);
                            pontuacao(dados);
                            classificacoes(id, dados);
                            verificacao = 4;
                            break;
                        }
                        break;
                    }

                case ("10"):  //Listar Primeiro Classificado por Grupo
                    if (dados[0][0] != 0 && verificacao == 4) {
                        listarPrimeiro(id, dados, qnt);
                        break;
                    } else {
                        System.out.println("Nao tem quaisquer dados em memoria");
                        System.out.println("Deseja executar os comandos 1, 2, 3 e 4? (Sim/Nao)");
                        resposta = ler.next();
                        if (resposta.equalsIgnoreCase("sim")) {
                            preencher(id, dados);
                            qnt = quantidadeEquipas(dados);
                            diferencaGolos(dados, qnt);
                            pontuacao(dados);
                            classificacoes(id, dados);
                            verificacao = 4;
                            break;
                        }
                        break;
                    }

                case ("11"): //Indicar a informacao de uma equipa especifica
                    if (dados[0][0] != 0 && verificacao == 4) {
                        infoEquipa(id, dados, qnt);
                        break;
                    } else {
                        System.out.println("Nao tem quaisquer dados em memoria");
                        System.out.println("Deseja executar os comandos 1, 2, 3 e 4? (Sim/Nao)");
                        resposta = ler.next();
                        if (resposta.equalsIgnoreCase("sim")) {
                            preencher(id, dados);
                            qnt = quantidadeEquipas(dados);
                            diferencaGolos(dados, qnt);
                            pontuacao(dados);
                            classificacoes(id, dados);
                            verificacao = 4;
                            break;
                        }
                        break;
                    }

                case ("12"): //Criar um ficheiro de texto com as estatisticas dos jogos
                    if (dados[0][0] != 0 && verificacao == 4) {
                        estatisticaJogos(id, dados, qnt);
                        break;
                    } else {
                        System.out.println("Nao tem quaisquer dados em memoria");
                        System.out.println("Deseja executar os comandos 1, 2, 3 e 4? (Sim/Nao)");
                        resposta = ler.next();
                        if (resposta.equalsIgnoreCase("sim")) {
                            preencher(id, dados);
                            qnt = quantidadeEquipas(dados);
                            diferencaGolos(dados, qnt);
                            pontuacao(dados);
                            classificacoes(id, dados);
                            verificacao = 4;
                            break;
                        }
                        break;
                    }

                case ("13"): //Criar um ficheiro com as equipas que vao disputar a Fase Final
                    if (dados[0][0] != 0 && verificacao == 4) {
                        System.out.printf("\n%s\n%s\n", "Ao executar este comando vai eliminar todos os 3º e 4º de cada grupo da memoria!", "Deseja continuar? (Sim/Nao)");
                        resposta = ler.next();
                        if (resposta.equalsIgnoreCase("sim")) {
                            remover_3_4(id, dados, qnt); //Remove todas as equipas que nao vao passar a fase final, ou seja, as 3 e 4 lugar
                            faseFinal(id, dados, qnt);
                        }
                        break;
                    } else {
                        System.out.println("Nao tem quaisquer dados em memoria");
                        System.out.println("Deseja executar os comandos 1, 2, 3 e 4? (Sim/Nao)");
                        resposta = ler.next();
                        if (resposta.equalsIgnoreCase("sim")) {
                            preencher(id, dados);
                            qnt = quantidadeEquipas(dados);
                            diferencaGolos(dados, qnt);
                            pontuacao(dados);
                            classificacoes(id, dados);
                            verificacao = 4;
                            break;
                        }
                        break;
                    }

                case ("14"): //Criar um ficheiro de texto com os jogos da Fase Final
                    if (dados[0][0] != 0 && verificacao == 4) {
                        jogosFaseFinal(id, dados, qnt);
                        break;
                    } else {
                        System.out.println("Nao tem quaisquer dados em memoria");
                        System.out.println("Deseja executar os comandos 1, 2, 3 e 4? (Sim/Nao)");
                        resposta = ler.next();
                        if (resposta.equalsIgnoreCase("sim")) {
                            preencher(id, dados);
                            qnt = quantidadeEquipas(dados);
                            diferencaGolos(dados, qnt);
                            pontuacao(dados);
                            classificacoes(id, dados);
                            verificacao = 4;
                        }
                        break;
                    }

                default:
                    System.out.println("ERRO: comando nao identificado.");
            }
        }
    }

//==================================================================================================================================================================
    public static void preencher(String[][] id, int[][] dados) throws FileNotFoundException {

        Scanner in = new Scanner(new File("PracticalWork.csv"));

        //a primeira linha do documento esta so o indice para o resto do doc por isso tenhos que a "eliminar" fazendo:
        String line = in.nextLine();
        int qnt = 0;
        while (in.hasNext()) {
            line = in.nextLine();
            String[] itens = line.split(",");
            id[qnt][0] = itens[0];
            id[qnt][1] = itens[1];

            for (int i = 0, item = 2; item < itens.length; i++, item++) {
                dados[qnt][i] = Integer.parseInt(itens[item]);
            }
            qnt++;
        }

        if (dados[qnt][0] != 0) {
            for (int x = qnt; x < MAX_PAISES; x++) {
                id[x][0] = "null";
                id[x][1] = "null";
                for (int t = 0; t < MAX_DADOS; t++) {
                    dados[x][t] = 0;
                }
            }
        }
        in.close();
    }

//========================================================================================================================================================== 
    public static int quantidadeEquipas(int[][] dados) {
        int qnt = 0;
        while (dados[qnt][0] != 0) {
            qnt++;
        }
        return qnt;
    }

//=============================================================================================================================================================
    public static int[][] diferencaGolos(int[][] dados, int qnt) {
        for (int i = 0; i < qnt; i++) {
            dados[i][6] = dados[i][4] - dados[i][5];
        }
        return dados;
    }

//===============================================================================================================================
    public static int[][] pontuacao(int[][] dados) {

        int qnt = quantidadeEquipas(dados);
        for (int i = 0; i < qnt; i++) {
            dados[i][7] = ((dados[i][1] * 3) + (dados[i][2] * 1));  //vai acrescentar a matriz dados a pontuacao de cada equipa
        }
        return dados;
    }

//===============================================================================================================================================================
    public static void acrescentar(String[][] id, int[][] dados) throws FileNotFoundException, IOException {

        System.out.printf("\n%s\n", "Escreva os dados a acrescentar neste formato: Grupo[A-Z],Equipa,Jogos,Vitorias,Empates,Derrotas,GolosMarcados,GolosSofridos");
        Scanner ler = new Scanner(System.in);
        String line = ler.nextLine(); //vai ler a linha que queremos acrestar
        String[] itens = line.split(",");

        if (itens.length == 8) {
            int qnt = quantidadeEquipas(dados);
            boolean flag = true, check = false;

            for (int i = 0; i < qnt; i++) {
                if (id[i][1].equals(itens[1])) {
                    flag = false;
                }
                //if (d)
            }

            if (flag == true) {

                //vai gravar em memoria (arrays) os novos dados, tanto no id como no pont
                id[qnt][0] = itens[0];
                id[qnt][1] = itens[1];
                for (int i = 0, x = 2; x < itens.length; i++, x++) {
                    dados[qnt][i] = Integer.parseInt(itens[x]);
                }

                System.out.println("Acescentado a memoria com sucesso!");

            } else {
                System.out.println("ERRO: A equipa ja existe");
            }

        } else {
            System.out.println("ERRO: Estrutura não respeitada");
        }
    }
    //================================================================================================================================
    //vai tornar as matrizes id e dados ordenadas por classificacoes

    public static void classificacoes(String[][] id, int[][] dados) throws FileNotFoundException {

        int qnt = quantidadeEquipas(dados);

        //vai organizar todas as matrizes por calssificacao conforme o numero de pontos que elas tem
        for (int x = 0; x < qnt; x++) {
            for (int y = x + 1; y < qnt; y++) {
                if (dados[x][7] < dados[y][7]) {
                    int aux1[] = dados[x];
                    dados[x] = dados[y];
                    dados[y] = aux1;

                    //vai trocar os grupos e selecoes conforme as posicoes
                    String[] aux2 = id[x];
                    id[x] = id[y];
                    id[y] = aux2;

                }
            }
        }

        //caso os pontos sejam iguais vai ordenar pelas outras categorias confome a prioridade
        for (int x = 0; x < qnt; x++) {
            for (int y = x + 1; y < qnt; y++) {
                if (dados[x][7] == dados[y][7]) {
                    if (dados[x][4] < dados[y][4]) {

                        //vai trocar os grupos e selecoes conforme as os golos marcados (caso a pontuacao seja igual)
                        String[] aux2 = id[x];
                        id[x] = id[y];
                        id[y] = aux2;

                        //vai trocar os dados conforme os golos marcados (caso a pontuacao seja igual)
                        int[] aux3 = dados[x];
                        dados[x] = dados[y];
                        dados[y] = aux3;

                    } else if (dados[x][4] == dados[y][4] && dados[x][5] > dados[y][5]) {
                        //vai trocar os grupos e selecoes conforme golos sofridos(menos golos melhor) (caso a pontuacao e os golos marcados seja igual)
                        String[] aux2 = id[x];
                        id[x] = id[y];
                        id[y] = aux2;

                        //vai trocar os dados conforme os golos sofridos(menos golos melhor) (caso a pontuacao e os golos marcados seja igual)
                        int[] aux3 = dados[x];
                        dados[x] = dados[y];
                        dados[y] = aux3;
                    } else if (dados[x][4] == dados[y][4] && dados[x][5] == dados[y][5] && id[x][1].compareTo(id[y][1]) > 0) { //NAO SEI SE E < OU >
                        //vai trocar os grupos e selecoes por ordem alfabetica (caso a pontuacao, os golos marcados e os golos sofridos seja igual)
                        String[] aux2 = id[x];
                        id[x] = id[y];
                        id[y] = aux2;

                        //vai trocar os dados por ordem alfabetica (caso a pontuacao, os golos marcados e os golos sofridos seja igual)
                        int[] aux3 = dados[x];
                        dados[x] = dados[y];
                        dados[y] = aux3;
                    }
                }
            }
        }

        //depois das equipas estarem corretamente ordenadas por pontos, vai ordenar pelos grupos e atribuir a posicao a cada uma delas
        String[][] aux1 = new String[qnt][MAX_ID];
        int[][] aux2 = new int[qnt][MAX_DADOS];
        int[] posicao = new int[qnt];
        int t = 0, check = 0;
        String[] grupos = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        for (int grupo = 0; grupo < grupos.length; grupo++) {
            int posicao1 = 1;
            for (int i = 0; i < qnt; i++) {
                if (id[i][0].equalsIgnoreCase(grupos[grupo])) {
                    aux1[t] = id[i];
                    aux2[t] = dados[i];
                    posicao[t] = posicao1;                // vai acrescentar a posicao de cada equipa no seu grupo aos dados na coluna 7
                    posicao1++;
                    t++;
                    check++;
                }
            }
            if (check == qnt) {
                break;
            }

        }

        for (int i = 0; i < qnt; i++) { //precissas de passar linha a linha para que o valor final passe bem....... eu antes estava simplesmente a igual as matrizes, tip aux1 = id;
            id[i] = aux1[i];
            dados[i] = aux2[i];
            for (int x = 0; x < qnt; x++) {
                dados[x][8] = posicao[x];
            }
        }
    }

//=====================================================================================================================================================================
    public static void listarClassificacoes(String[][] id, int[][] dados, int qnt) {

        System.out.printf("\n|%-5s|%5s|%-17s|%4s|%4s|%4s|%4s|%4s|%4s|%4s|%4s|\n", "Grp", "Pos", "Equipa", "Pts", "J", "V", "E", "D", "GM", "GS", "GD");
        System.out.println("|=====|=====|=================|====|====|====|====|====|====|====|====|");
        System.out.printf("|%-5s|%5d|%-17s|%4d|%4d|%4d|%4d|%4d|%4d|%4d|%4d|\n", id[0][0], dados[0][8], id[0][1], dados[0][7], dados[0][0], dados[0][1], dados[0][2], dados[0][3], dados[0][4], dados[0][5], dados[0][6]);
        for (int i = 1; i < qnt; i++) {
            if (!id[i][0].equalsIgnoreCase(id[i - 1][0])) {
                System.out.println("|=====|=====|=================|====|====|====|====|====|====|====|====|");
            }
            System.out.printf("|%-5s|%5d|%-17s|%4d|%4d|%4d|%4d|%4d|%4d|%4d|%4d|\n", id[i][0], dados[i][8], id[i][1], dados[i][7], dados[i][0], dados[i][1], dados[i][2], dados[i][3], dados[i][4], dados[i][5], dados[i][6]);
        }
        System.out.println("|=====|=====|=================|====|====|====|====|====|====|====|====|");
    }

//===================================================================================================================================================================
    public static void listarGolosMarcados(String[][] id, int[][] dados, int qnt) {
        int maior = 0, x = 0;
        for (int i = 0; i < qnt; i++) {
            if (dados[i][4] > maior) {
                maior = dados[i][4];
            }
        }
        System.out.printf("\n|%-5s|%5s|%-17s|%4s|%4s|%4s|%4s|%4s|%4s|%4s|%4s|\n", "Grp", "Pos", "Equipa", "Pts", "J", "V", "E", "D", "GM", "GS", "GD");
        System.out.println("|=====|=====|=================|====|====|====|====|====|====|====|====|");
        for (int i = 0; i < qnt; i++) {
            if (dados[i][4] == maior) {
                System.out.printf("|%-5s|%5d|%-17s|%4d|%4d|%4d|%4d|%4d|%4d|%4d|%4d|\n", id[i][0], dados[i][8], id[i][1], dados[i][7], dados[i][0], dados[i][1], dados[i][2], dados[i][3], dados[i][4], dados[i][5], dados[i][6]);
                System.out.println("|=====|=====|=================|====|====|====|====|====|====|====|====|");
                x++;
            }
        }

        if (x != 1) {
            System.out.println("|=====|=====|=================|====|====|====|====|====|====|====|====|");
        }
    }

//================================================================================================================================================
    public static void listarGolosSofridos(String[][] id, int[][] dados, int qnt) {
        Scanner ler = new Scanner(System.in);
        System.out.println("Que quantidade de golos sofridos deseja procurar?");
        int goloSofridos = ler.nextInt();
        boolean flag = false;

        for (int i = 0; i < qnt; i++) {
            if (dados[i][5] == goloSofridos) {
                if (flag == false) {
                    System.out.printf("\n|%-5s|%5s|%-17s|%4s|%4s|%4s|%4s|%4s|%4s|%4s|%4s|\n", "Grp", "Pos", "Equipa", "Pts", "J", "V", "E", "D", "GM", "GS", "GD");
                    System.out.println("|=====|=====|=================|====|====|====|====|====|====|====|====|");
                }
                System.out.printf("|%-5s|%5d|%-17s|%4d|%4d|%4d|%4d|%4d|%4d|%4d|%4d|\n", id[i][0], dados[i][8], id[i][1], dados[i][7], dados[i][0], dados[i][1], dados[i][2], dados[i][3], dados[i][4], dados[i][5], dados[i][6]);
                flag = true;
                System.out.println("|=====|=====|=================|====|====|====|====|====|====|====|====|");
            }
        }

        if (flag == false) {
            System.out.println("Nao ha nenhuma equipa com essa quantidade de golos sofridos.");
        }
    }

//======================================================================================================================================================
    public static void maisSofridos_Marcados(String[][] id, int[][] dados, int qnt) {
        String[][] arrID = new String[qnt][MAX_ID];
        int[][] arrDADOS = new int[qnt][MAX_DADOS];
        int n = 0;
        for (int i = 0; i < qnt; i++) {
            if (dados[i][5] > dados[i][4]) {
                arrID[n] = id[i];
                arrDADOS[n] = dados[i];
                n++;
            }
        }
        for (int x = 0; x < n; x++) {
            for (int y = x + 1; y < n; y++) {
                if (arrID[x][1].compareTo(arrID[y][1]) > 0) {
                    String[] aux1 = arrID[x];
                    arrID[x] = arrID[y];
                    arrID[y] = aux1;

                    int[] aux2 = arrDADOS[x];
                    arrDADOS[x] = arrDADOS[y];
                    arrDADOS[y] = aux2;
                }
            }
        }
        System.out.printf("\n|%-5s|%5s|%-17s|%4s|%4s|%4s|%4s|%4s|%4s|%4s|%4s|\n", "Grp", "Pos", "Equipa", "Pts", "J", "V", "E", "D", "GM", "GS", "GD");
        System.out.println("|=====|=====|=================|====|====|====|====|====|====|====|====|");
        for (int i = 0; i < n; i++) {
            System.out.printf("|%-5s|%5d|%-17s|%4d|%4d|%4d|%4d|%4d|%4d|%4d|%4d|\n", arrID[i][0], arrDADOS[i][8], arrID[i][1], arrDADOS[i][7], arrDADOS[i][0], arrDADOS[i][1], arrDADOS[i][2], arrDADOS[i][3], arrDADOS[i][4], arrDADOS[i][5], arrDADOS[i][6]);
            System.out.println("|=====|=====|=================|====|====|====|====|====|====|====|====|");
        }
    }

//===================================================================================================================================
    public static void listarPrimeiro(String[][] id, int[][] dados, int qnt) {

        System.out.printf("\n|%-5s|%5s|%-17s|%4s|%4s|%4s|%4s|%4s|%4s|%4s|%4s|\n", "Grp", "Pos", "Equipa", "Pts", "J", "V", "E", "D", "GM", "GS", "GD");
        System.out.println("|=====|=====|=================|====|====|====|====|====|====|====|====|");
        System.out.printf("|%-5s|%5d|%-17s|%4d|%4d|%4d|%4d|%4d|%4d|%4d|%4d|\n", id[0][0], dados[0][8], id[0][1], dados[0][7], dados[0][0], dados[0][1], dados[0][2], dados[0][3], dados[0][4], dados[0][5], dados[0][6]);
        System.out.println("|=====|=====|=================|====|====|====|====|====|====|====|====|");
        for (int i = 1; i < qnt; i++) {
            if (!id[i][0].equalsIgnoreCase(id[i - 1][0])) {
                System.out.printf("|%-5s|%5d|%-17s|%4d|%4d|%4d|%4d|%4d|%4d|%4d|%4d|\n", id[i][0], dados[i][8], id[i][1], dados[i][7], dados[i][0], dados[i][1], dados[i][2], dados[i][3], dados[i][4], dados[i][5], dados[i][6]);
                System.out.println("|=====|=====|=================|====|====|====|====|====|====|====|====|");
            }
        }
    }

//===============================================================================================================================
    public static void infoEquipa(String[][] id, int[][] dados, int qnt) {
        System.out.println("Escreva o nome da equipa de que pretende obter a informacao completa.");
        Scanner ler = new Scanner(System.in);
        String equipa = ler.next();

        boolean flag = false;
        for (int i = 0; i < qnt; i++) {       //Vai percorrer cada equipa
            if (equipa.equalsIgnoreCase(id[i][1])) {  //Se o nome da equipa escrito pelo utilizador for igual a  equipa dita por "i", entÃ£o serÃ¡ listada info da equipa
                System.out.printf("\n|%-5s|%5s|%-17s|%4s|%4s|%4s|%4s|%4s|%4s|%4s|%4s|\n", "Grp", "Pos", "Equipa", "Pts", "J", "V", "E", "D", "GM", "GS", "GD");
                System.out.println("|=====|=====|=================|====|====|====|====|====|====|====|====|");
                System.out.printf("|%-5s|%5d|%-17s|%4d|%4d|%4d|%4d|%4d|%4d|%4d|%4d|\n", id[i][0], dados[i][8], id[i][1], dados[i][7], dados[i][0], dados[i][1], dados[i][2], dados[i][3], dados[i][4], dados[i][5], dados[i][6]);
                System.out.println("|=====|=====|=================|====|====|====|====|====|====|====|====|");
                flag = true;
                break;
            }
        }
        if (flag == false) {
            System.out.println("Nao ha nenhuma equipa com esse nome");
        }
    }

//========================================================================================================================================================================
    public static void estatisticaJogos(String[][] id, int[][] dados, int qnt) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(new File("Statistics.txt"));
        int totalVitorias = 0, totalEmpates = 0, totalDerrotas = 0;
        double totalJogos = 0, totalGM = 0, totalGS = 0;

        for (int i = 0; i < qnt; i++) {
            totalJogos = totalJogos + dados[i][0];
            totalVitorias = totalVitorias + dados[i][1];
            totalEmpates = totalEmpates + dados[i][2];
            totalDerrotas = totalDerrotas + dados[i][3];
            totalGM = totalGM + dados[i][4];
            totalGS = totalGS + dados[i][5];
        }

        double mediaGM = totalGM / totalJogos;
        double mediaGS = totalGS / totalJogos;

        out.println("Total de jogos= " + (int) totalJogos);
        out.println("Total de vitorias= " + totalVitorias);
        out.println("Total de empates= " + totalEmpates);
        out.println("Total de derrotas= " + totalDerrotas);
        out.println("Total de golos marcados= " + (int) totalGM);
        out.println("Total de golos sofridos= " + (int) totalGS);
        out.printf("Media de golos marcados por jogo= %.1f%n", mediaGM);
        out.printf("Media de golos sofridos por jogo= %.1f%n", mediaGS);

        System.out.printf("\n%s\n", "Ficheiro criado com sucesso!");

        out.close();
    }

//==========================================================================================================================================================================
    public static void remover_3_4(String[][] id, int[][] dados, int qnt) {
        for (int i = 0; i < qnt; i++) {
            if (dados[i][8] == 3 || dados[i][8] == 4) {
                id[i][0] = "";
                id[i][1] = "ELIMINADO";
                for (int x = 0; x < MAX_DADOS; x++) {
                    dados[i][x] = 0;
                }
            }
        }
    }

    //==========================================================================================================================================================
    public static void faseFinal(String[][] id, int[][] dados, int qnt) throws FileNotFoundException {

        PrintWriter out = new PrintWriter(new File("FinalStage.csv"));

        for (int i = 0; i < qnt; i++) {
            if (!id[i][0].equals("")) {
                out.printf("%s,%d,%s,%d\n", id[i][0], dados[i][8], id[i][1], dados[i][7]);
            }
        }

        System.out.printf("\n%s\n", "Ficheiro criado com sucesso!");

        out.close();
    }

    //=======================================================================================================================================================
    public static void jogosFaseFinal(String id[][], int dados[][], int qnt) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(new File("FinalStageGames.txt"));

        String[][] jogos = new String[50][3];
        int t = 0;

        for (int i = 0; i < qnt; i++) {
            if (dados[i][8] == 1 || dados[i][8] == 2) {
                jogos[t][0] = id[i][0];
                jogos[t][1] = Integer.toString(dados[i][8]);
                jogos[t][2] = id[i][1];
                t++;
            }
        }

        int x = 0;
        while (x < t) {

            out.printf( "%s,%s,%s-%s,%s,%s\n", jogos[x][0], jogos[x][1], jogos[x][2], jogos[x + 3][0], jogos[x + 3][1], jogos[x + 3][2]);
            out.printf("%s,%s,%s-%s,%s,%s\n", jogos[x + 1][0], jogos[x + 1][1], jogos[x + 1][2], jogos[x + 2][0], jogos[x + 2][1], jogos[x + 2][2]);

            x = x + 4;
        }

        System.out.printf("\n%s\n", "Ficheiro criado com sucesso!");
        
        out.close();
    }
}

