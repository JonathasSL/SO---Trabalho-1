import java.io.DataInputStream;	
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.LineNumberInputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		final String nomeArquivo = "dadosGrafica.txt";

		do {
			ArrayList<Pedido> pedidosList = retornaArquivo(nomeArquivo);
			switch(menu()) {
			case 1:
				switch(menuImpressao()) {
				case 1:
					//			
					//		
					//		
					//		Fila
					//		
					//		
					//
					switch(getNImpressoras()) {
					case 2:
						ArrayList<Pedido> list1 = new ArrayList<Pedido>();
						ArrayList<Pedido> list2 = new ArrayList<Pedido>();


						//dividindo lista para 2 impressoras
						for(int i=0;i<pedidosList.size()/2;i++)
							list1.add(pedidosList.get(i));

						for(int i=pedidosList.size()/2;i<pedidosList.size();i++)
							list2.add(pedidosList.get(i));

						Fila impressora1 = new Fila (list1);
						Fila impressora2 = new Fila (list2);

						System.out.println("\n========================\n"+
								"=======FILA COM 2=======\n"+
								"========================\n");

						System.out.println("Impressora 1\n");
						resultadoImpressora(impressora1,comEntrega(list1));//metodo com os prints inbutidos
						//		System.out.println("Impressoes entregues no prazo: "+impressora1.impressoesDentroDoPrazo()+" de "+comEntrega);
						//		System.out.println("Tempo medio de Retorno: "+impressora1.mediaTempoRetorno());
						//		System.out.println("Tempo medio de Resposta: "+impressora1.mediaTempoResposta());
						//		System.out.println("Tempo total de Impressão: "+impressora1.executa());

						System.out.println("\nImpressora 2\n");
						resultadoImpressora(impressora2,comEntrega(list2));
						//		System.out.println("Impressoes entregues no prazo: "+impressora2.impressoesDentroDoPrazo()+" de "+comEntrega);
						//		System.out.println("Tempo medio de Retorno: "+impressora2.mediaTempoRetorno());
						//		System.out.println("Tempo medio de Resposta: "+impressora2.mediaTempoResposta());
						//		System.out.println("Tempo total de Impressao: "+impressora2.executa());
						break;

					case 3:

						System.out.println("\n========================\n"+
								"=======FILA COM 3=======\n"+
								"========================\n");
						pedidosList = retornaArquivo(nomeArquivo);
						list1 = new ArrayList<Pedido>();
						list2 = new ArrayList<Pedido>();
						ArrayList<Pedido> list3 = new ArrayList<Pedido>();


						for(int i=0;i<pedidosList.size()/3;i++)
							list1.add(pedidosList.get(i));

						for(int i=pedidosList.size()/3;i<2*pedidosList.size()/3;i++)
							list2.add(pedidosList.get(i));

						for(int i=2*pedidosList.size()/3;i<pedidosList.size();i++)
							list3.add(pedidosList.get(i));

						impressora1 = new Fila (list1);
						impressora2 = new Fila (list2);
						Fila impressora3 = new Fila (list3);

						System.out.println("\n-----3 impressoras-----\n"+
								"=======================");
						System.out.println("Impressora 1\n");
						resultadoImpressora(impressora1,comEntrega(list1));
						//		System.out.println("Impressões entregues no prazo: "+impressora1.impressoesDentroDoPrazo());
						//		System.out.println("Tempo Médio de Retorno: "+impressora1.mediaTempoRetorno());
						//		System.out.println("Tempo Médio de Resposta: "+impressora1.mediaTempoResposta());
						//		System.out.println("Tempo Total de Impressão: "+impressora1.executa());

						System.out.println("\nImpressora 2\n");
						resultadoImpressora(impressora2,comEntrega(list2));
						//		System.out.println("Impressões entregues no prazo: "+impressora2.impressoesDentroDoPrazo());
						//		System.out.println("Tempo Médio de Retorno: "+impressora2.mediaTempoRetorno());
						//		System.out.println("Tempo Médio de Resposta: "+impressora2.mediaTempoResposta());
						//		System.out.println("Tempo Total de Impressão: "+impressora2.executa());


						System.out.println("\nImpressora 3\n");
						resultadoImpressora(impressora3,comEntrega(list3));
						//		System.out.println("Impressões entregues no prazo: "+impressora3.impressoesDentroDoPrazo());
						//		System.out.println("Tempo Médio de Retorno: "+impressora3.mediaTempoRetorno());
						//		System.out.println("Tempo Médio de Resposta: "+impressora3.mediaTempoResposta());
						//		System.out.println("Tempo Total de Impressão: "+impressora3.executa());
						break;
					default:
						break;
					}
					break;
				case 2:
					//		
					//		
					//		
					//		
					//		Fila de Prioridade
					//		
					//		
					//
					//
					switch(getNImpressoras()) {
					case 2:
						System.out.println("\n\n=======================\n"+
								"==FILA DE PRIORIDADES==\n"+
								"=======================");
						System.out.println("\n-----2 impressoras-----\n"+
								"=======================");


						pedidosList = retornaArquivo(nomeArquivo);
						ArrayList<Pedido> list1 = new ArrayList<Pedido>();
						ArrayList<Pedido> list2 = new ArrayList<Pedido>();

						for(int i=0;i<pedidosList.size()/2;i++)
							list1.add(pedidosList.get(i));

						for(int i=pedidosList.size()/2;i<pedidosList.size();i++)
							list2.add(pedidosList.get(i));


						FilaDePrioridade fp = new FilaDePrioridade(list1);
						fp.executaRoundRobin();
						System.out.println("\n\nImpressora 1");
						resultadoImpressora(fp,comEntrega(list1));

						FilaDePrioridade fp2 = new FilaDePrioridade(list2);
						fp2.executaRoundRobin();
						System.out.println("\n\nImpressora 2");
						resultadoImpressora(fp2,comEntrega(list2));

						mediaImpressoras(fp,fp2);
						break;

					case 3:
						System.out.println("\n\n=======================\n"+
								"==FILA DE PRIORIDADES==\n"+
								"=======================");
						System.out.println("\n-----3 impressoras-----\n"+
								"=======================");

						//reset das listas - com 3 listas
						pedidosList = retornaArquivo(nomeArquivo);
						list1 = new ArrayList<Pedido>();
						list2 = new ArrayList<Pedido>();
						ArrayList<Pedido> list3 = new ArrayList<Pedido>();

						for(int i=0;i<pedidosList.size()/3;i++)
							list1.add(pedidosList.get(i));

						for(int i=pedidosList.size()/3;i<(pedidosList.size()/3)*2;i++)
							list2.add(pedidosList.get(i));

						for(int i=(pedidosList.size()/3)*2;i<pedidosList.size();i++)
							list3.add(pedidosList.get(i));

						//primeira impressora
						FilaDePrioridade fp1 = new FilaDePrioridade(list1);
						fp1.executaRoundRobin();
						System.out.println("\n\nImpressora 1");
						resultadoImpressora(fp1,comEntrega(list1));


						//segunda impressora
						fp2 = new FilaDePrioridade(list2);
						fp2.executaRoundRobin();
						System.out.println("\n\nImpressora 2");
						resultadoImpressora(fp2,comEntrega(list2));


						//terceira impressora
						FilaDePrioridade fp3 = new FilaDePrioridade(list3);
						fp3.executaRoundRobin();
						System.out.println("\n\nImpressora 3");
						resultadoImpressora(fp3,comEntrega(list3));

						mediaImpressoras(fp1,fp2,fp3);
						break;
					default:
						break;
					}
					break;



				case 3:
					//		
					//		
					//		
					//		ROUND ROBIN
					//		
					//		
					//		
					//	
					switch(getNImpressoras()) {
					case 2:
						//reset das listas - com 2 listas
						pedidosList = retornaArquivo(nomeArquivo);
						ArrayList<Pedido> list1 = new ArrayList<Pedido>();
						ArrayList<Pedido> list2 = new ArrayList<Pedido>();

						//dividindo o arquivo em 2 listas
						for(int i=0;i<pedidosList.size()/2;i++)
							list1.add(pedidosList.get(i));

						for(int i=pedidosList.size()/2;i<pedidosList.size();i++)
							list2.add(pedidosList.get(i));


						System.out.println("\n=======================\n"+
								"======Round Robin======\n"+
								"=======================");
						System.out.println("\n-----2 impressoras-----\n"+
								"=======================");

						//primeira impressora
						RoundRobin r1 = new RoundRobin(list1);
						float tempot1 = r1.executa();
						System.out.println("\nImpressora 1");
						resultadoImpressora(r1,comEntrega(list1));

						//segunda impressora
						RoundRobin r2 = new RoundRobin(list2);
						float tempot2 = r2.executa();
						System.out.println("\n\nImpressora 2");
						resultadoImpressora(r2,comEntrega(list2));

						mediaImpressoras(r1,r2);

						break;
					case 3:
						//reset das listas - com 3 listas
						pedidosList = retornaArquivo(nomeArquivo);
						list1 = new ArrayList<Pedido>();
						list2 = new ArrayList<Pedido>();
						ArrayList<Pedido> list3 = new ArrayList<Pedido>();

						//dividindo o arquivo em 3 listas
						for(int i=0;i<pedidosList.size()/3;i++)
							list1.add(pedidosList.get(i));

						for(int i=pedidosList.size()/3;i<(pedidosList.size()/3)*2;i++)
							list2.add(pedidosList.get(i));

						for(int i=(pedidosList.size()/3)*2;i<pedidosList.size();i++)
							list3.add(pedidosList.get(i));


						System.out.println("\n-----3 impressoras-----\n"+
								"=======================");
						//primeira impressora
						r1 = new RoundRobin(list1);
						tempot1 = r1.executa();
						System.out.println("\nImpressora 1");
						resultadoImpressora(r1,comEntrega(list1));

						//segunda impressora 
						r2 = new RoundRobin(list2);
						tempot2 = r2.executa();
						System.out.println("\n\nImpressora 2");
						resultadoImpressora(r2,comEntrega(list2));

						//terceira impressora
						RoundRobin r3 = new RoundRobin(list3);
						float tempot3 = r3.executa();
						System.out.println("\n\nImpressora 3");
						resultadoImpressora(r3,comEntrega(list3));

						mediaImpressoras(r1,r2,r3);
						break;
					default:
						break;	
					}
				}
			case 2:
				switch(getNImpressoras()) {
				case 2:
					System.out.println("Impressora 1 Fila\n"
									 + "Impressora 2 Fila de Prioridade");
					//reset das listas - com 2 listas
					pedidosList = retornaArquivo(nomeArquivo);
					ArrayList<Pedido> list1 = new ArrayList<Pedido>();
					ArrayList<Pedido> list2 = new ArrayList<Pedido>();

					//dividindo o arquivo em 2 listas
					for(int i=0;i<pedidosList.size()/2;i++)
						list1.add(pedidosList.get(i));

					for(int i=pedidosList.size()/2;i<pedidosList.size();i++)
						list2.add(pedidosList.get(i));
					
					Fila fila1 = new Fila(list1);
					FilaDePrioridade fp1 = new FilaDePrioridade(list2);
					
					float tempoFila = fila1.executa();
					fp1.executaRoundRobin();
					break;
				case 3:
					break;
				}
				break;
			}
		}while(!encerrar());

	}

	public static void mediaImpressoras(Fila f1,Fila f2) {
		int totalNoPrazo = f1.impressoesDentroDoPrazo() + f2.impressoesDentroDoPrazo();
		//		float mRetorno = (f1.() + f2.())/2;
		//		float mResposta = (f1.() + f2.())/2;
		//		System.out.println("\n"+totalNoPrazo+"\t"+mRetorno+"\t"+mResposta);
	}
	public static void mediaImpressoras(Fila f1,Fila f2,Fila f3) {
		int totalNoPrazo = f1.impressoesDentroDoPrazo() + f2.impressoesDentroDoPrazo() + f3.impressoesDentroDoPrazo();
		float mRetorno = 0;
		float mResposta = 0;
		System.out.println("\n"+totalNoPrazo+"\t"+mRetorno+"\t"+mResposta);
	}
	public static void mediaImpressoras(FilaDePrioridade fp1,FilaDePrioridade fp2) {
		int totalNoPrazo = fp1.getEntreguesNoPrazo() + fp2.getEntreguesNoPrazo();
		float mRetorno = (fp1.getMediaRetorno() + fp2.getMediaRetorno())/2;
		float mResposta = (fp1.getMediaResposta() + fp2.getMediaResposta())/2;
		System.out.println("\n"+totalNoPrazo+"\t"+mRetorno+"\t"+mResposta);
	}
	public static void mediaImpressoras(FilaDePrioridade fp1,FilaDePrioridade fp2,FilaDePrioridade fp3) {
		int totalNoPrazo = fp1.getEntreguesNoPrazo() + fp2.getEntreguesNoPrazo() + fp3.getEntreguesNoPrazo();
		float mRetorno = (fp1.getMediaRetorno() + fp2.getMediaRetorno() + fp3.getMediaRetorno())/3;
		float mResposta = (fp1.getMediaResposta() + fp2.getMediaResposta() + fp3.getMediaResposta())/3;
		System.out.println("\n"+totalNoPrazo+"\t"+mRetorno+"\t"+mResposta);

	}
	public static void mediaImpressoras(RoundRobin r1,RoundRobin r2) {
		int totalNoPrazo = r1.getEntreguesNoPrazo() + r2.getEntreguesNoPrazo();
		float mRetorno = (r1.getMediaRetorno() + r2.getMediaRetorno())/2;
		float mResposta = (r1.getMediaResposta()+r2.getMediaResposta())/2;
		System.out.println("\n"+totalNoPrazo+"\t"+mRetorno+"\t"+mResposta);
	}
	public static void mediaImpressoras(RoundRobin r1,RoundRobin r2,RoundRobin r3) {
		int totalNoPrazo = r1.getEntreguesNoPrazo() + r2.getEntreguesNoPrazo() + r3.getEntreguesNoPrazo();
		float mRetorno = (r1.getMediaRetorno() + r2.getMediaRetorno() + r3.getMediaRetorno())/3;
		float mResposta = (r1.getMediaResposta()+r2.getMediaResposta() + r3.getMediaResposta())/3;
		System.out.println("\n"+totalNoPrazo+"\t"+mRetorno+"\t"+mResposta);
	}



	public static void resultadoImpressora(Fila f, int comEntrega) {
		System.out.println("Impressoes entregues no prazo: "+f.impressoesDentroDoPrazo()+" de "+comEntrega);
		System.out.println("Tempo medio de Retorno: "+f.mediaTempoRetorno());
		System.out.println("Tempo medio de Resposta: "+f.mediaTempoResposta());
		System.out.println("Tempo total de Impressão: "+f.executa());
	}
	public static void resultadoImpressora(FilaDePrioridade f, int comEntrega) {
		System.out.println("Impresoes entregues no prazo= "+f.getEntreguesNoPrazo()+" de "+comEntrega);
		System.out.println("Tempo medio de Retorno: "+f.getMediaRetorno());
		System.out.println("Tempo medio de Resposta: "+f.getMediaResposta());
		System.out.println("Tempo total de impressao: "+f.getTempoGasto());

	}
	public static void resultadoImpressora(RoundRobin r, int comEntrega) {
		System.out.println("Impresoes entregues no prazo= "+r.getEntreguesNoPrazo()+" de "+comEntrega);
		System.out.println("Tempo medio de Retorno: "+r.getMediaRetorno());
		System.out.println("Tempo medio de Resposta: "+r.getMediaResposta());

	}


	public static ArrayList<Pedido> retornaArquivo(String fileName) {

		try {
			//Abrindo leitura do arquivo texto
			FileInputStream fileIn = new FileInputStream(fileName);
			DataInputStream entry = new DataInputStream(fileIn);

			int nPedidos = Integer.parseInt(entry.readLine());

			//Lista de pedidos
			ArrayList<Pedido> pedidosList = new ArrayList<>();


			//Salvando arquivo texto na memoria primaria
			for(int i=0;i<nPedidos;i++) {
				String line = entry.readLine();
				StringTokenizer lineT = new StringTokenizer(line,";");

				String name = lineT.nextToken();
				int papersAmmount = Integer.parseInt(lineT.nextToken());

				//lendo a string e transformando em float
				StringTokenizer priceT = new StringTokenizer(lineT.nextToken(),",");
				float price = Integer.parseInt(priceT.nextToken()) + Float.parseFloat(priceT.nextToken())/100;

				int deliveryTime = Integer.parseInt(lineT.nextToken());

				Pedido pedido = new Pedido(name,papersAmmount,price,deliveryTime);
				pedidosList.add(pedido);
			}
			entry.close();
			fileIn.close();

			return pedidosList;

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;		

	}


	public static void toString(Pedido []pedidos) {
		for(int i=0;i<144;i++)
			System.out.println(pedidos);
	}


	public static int comEntrega(ArrayList<Pedido> list) {
		int comEntrega = 0;
		for(int i=0;i<list.size();i++)
			if(list.get(i).getDeliveryTime()!=0)
				comEntrega++;
		return comEntrega;
	}

	public static int menu() {
		int opcao;
		do{
			System.out.println("Deseja imprimir(1) ou analizar(2)?");
			Scanner scan = new Scanner(System.in);
			opcao = scan.nextInt();
			if(opcao != 1 && opcao !=2)
				System.out.println("  -Opcao Invalida-\n");
		}while(opcao != 1 && opcao !=2);
		return opcao;
	}
	public static int menuImpressao() {
		int opcao;
		do {
			System.out.println("       -Grafica-\n"
					+ "        -Menu-\n"
					+ "Escolha qual metodo de impressao deseja:\n"
					+ " 1- Fila\n"
					+ " 2- Fila de Prioridades\n"
					+ " 3- Round Robin");
			Scanner scan = new Scanner(System.in);
			opcao = scan.nextInt();
			if(opcao !=1 && opcao != 2 && opcao != 3)
				System.out.println("  -Opcao invalida-\n");
		}while(opcao !=1 && opcao != 2 && opcao != 3);
		return opcao;
	}

	public static int getNImpressoras() {
		int opcao = 0;
		do {
			System.out.print("Deseja imprimir com 2 ou 3 impressoras? ");
			Scanner scan = new Scanner(System.in);
			opcao = scan.nextInt();
			if(opcao != 2 && opcao != 3)
				System.out.println("  -Opcao invalida-\n");
		}while(opcao != 2 && opcao != 3);
		return opcao;
	}

	public static boolean encerrar() {
		boolean encerrar = true;
		Scanner scan = new Scanner(System.in);
		int opcao;
		do {
			System.out.println("Deseja encerrar?"
					+ " 1- Sim"
					+ " 2- Nao");
			opcao = scan.nextInt();
			if(opcao != 1 && opcao != 2)
				System.out.println("  -Opcao invalida");
			else
				encerrar = opcao == 1;
		}while(opcao != 1 && opcao != 2);
		return encerrar;
	}
}
