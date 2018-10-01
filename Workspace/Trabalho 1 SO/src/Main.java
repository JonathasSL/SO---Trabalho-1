import java.io.DataInputStream;	
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		String fileName = "dadosGrafica";

		try {
			//Abrindo leitura do arquivo texto
			FileInputStream fileIn = new FileInputStream(fileName+".txt");
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

				//Gambs - lendo a string e transformando em float
				StringTokenizer priceT = new StringTokenizer(lineT.nextToken(),",");
				float price = Integer.parseInt(priceT.nextToken()) + Float.parseFloat(priceT.nextToken())/100;

				int deliveryTime = Integer.parseInt(lineT.nextToken());

				Pedido pedido = new Pedido(name,papersAmmount,price,deliveryTime);
				pedidosList.add(pedido);
			}
			entry.close();
			fileIn.close();
			
			ArrayList<Pedido> list1 = new ArrayList<Pedido>();
			ArrayList<Pedido> list2 = new ArrayList<Pedido>();
			
			for(int i=0;i<pedidosList.size()/2;i++)
				list1.add(pedidosList.get(i));
			
			for(int i=pedidosList.size()/2;i<pedidosList.size();i++)
				list2.add(pedidosList.get(i));

			Fila fila = new Fila(pedidosList);
			
//			System.out.println("\n======================\n"+
//								"=========FILA=========\n"+
//								"======================\n");
//			System.out.println("Impresoes entregues no prazo= "+fila.impressoesDentroDoPrazo());
//			System.out.println("Tempo Médio de Retorno: "+fila.mediaTempoRetorno());
//			System.out.println("Tempo Médio de Resposta: "+fila.mediaTempoResposta());
//			System.out.println("Tempo Total de Impressão: "+fila.executa());


			FilaDePrioridade fp = new FilaDePrioridade(list1);
			System.out.println("\n\n=======================\n"+
								"==FILA DE PRIORIDADES==\n"+
								"=======================");
			System.out.println("\n\nImpressora 1");
			System.out.println("Impresoes entregues no prazo= "+fp.getEntreguesNoPrazo()+" de "+list1.size());
			System.out.println("Tempo Médio de Retorno: "+fp.getMediaRetorno());
			System.out.println("Tempo Médio de Resposta: "+fp.getMediaResposta());
			System.out.println("Tempo total de impressão: "+fp.getTempoGasto());
			
			FilaDePrioridade fp2 = new FilaDePrioridade(list2);
			System.out.println("\n\nImpressora 2");
			System.out.println("Impresoes entregues no prazo= "+fp2.getEntreguesNoPrazo()+" de "+list2.size());
			System.out.println("Tempo Médio de Retorno: "+fp2.getMediaRetorno());
			System.out.println("Tempo Médio de Resposta: "+fp2.getMediaResposta());
			System.out.println("Tempo total de impressão: "+fp2.getTempoGasto());
			
			

			RoundRobin r1 = new RoundRobin(list1);
			RoundRobin r2 = new RoundRobin(list2);
			float tempot1 = r1.executa();
			float tempot2 = r2.executa();
			
			System.out.println("\n\n=======================\n"+
								"======Round Robin======\n"+
								"=======================");
			System.out.println("\n\nImpressora 1");
			System.out.println("Impresoes entregues no prazo= "+r1.getEntreguesNoPrazo()+" de "+list1.size());
			System.out.println("Tempo Médio de Retorno: "+r1.getMediaRetorno());
			System.out.println("Tempo Médio de Resposta: "+r1.getMediaResposta());
			

			System.out.println("\n\nImpressora 2");
			System.out.println("Impresoes entregues no prazo= "+r2.getEntreguesNoPrazo()+" de "+list2.size());
			System.out.println("Tempo Médio de Retorno: "+r2.getMediaRetorno());
			System.out.println("Tempo Médio de Resposta: "+r2.getMediaResposta());
			
			
			
			




		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

	public static void toString(Pedido []pedidos) {
		for(int i=0;i<144;i++)
			System.out.println(pedidos);
	}
}
