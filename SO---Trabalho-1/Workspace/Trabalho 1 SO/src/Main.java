import java.io.DataInputStream;	
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.LineNumberInputStream;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {


		ArrayList<Pedido> pedidosList = retornaArquivo("dadosGrafica.txt");


		ArrayList<Pedido> list1 = new ArrayList<Pedido>();
		ArrayList<Pedido> list2 = new ArrayList<Pedido>();

//		
//		
//		
//		Fila
//		
//		
//		
		
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
		int comEntrega = comEntrega(list1);

		System.out.println("Impressora 1\n");
		resultadoImpressora(impressora1,comEntrega);
		//		System.out.println("Impressoes entregues no prazo: "+impressora1.impressoesDentroDoPrazo()+" de "+comEntrega);
		//		System.out.println("Tempo medio de Retorno: "+impressora1.mediaTempoRetorno());
		//		System.out.println("Tempo medio de Resposta: "+impressora1.mediaTempoResposta());
		//		System.out.println("Tempo total de Impressão: "+impressora1.executa());

		System.out.println("\nImpressora 2\n");
		comEntrega = comEntrega(list2);
		resultadoImpressora(impressora2,comEntrega);
		//		System.out.println("Impressoes entregues no prazo: "+impressora2.impressoesDentroDoPrazo()+" de "+comEntrega);
		//		System.out.println("Tempo medio de Retorno: "+impressora2.mediaTempoRetorno());
		//		System.out.println("Tempo medio de Resposta: "+impressora2.mediaTempoResposta());
		//		System.out.println("Tempo total de Impressao: "+impressora2.executa());
		
		
		
		// Fila , Fila de Prioridade e Round Robbin com 3 impressoras
		pedidosList = retornaArquivo("dadosGrafica.txt");
		list1 = new ArrayList<Pedido>();
		list2 = new ArrayList<Pedido>();
		ArrayList<Pedido> list3 = new ArrayList<Pedido>();
		
		
		for(int i=0;i<pedidosList.size()/3;i++)
			list1.add(pedidosList.get(i));

		for(int i=pedidosList.size()/3;i<2*pedidosList.size()/3;i++)
			list2.add(pedidosList.get(i));

		for(int i=2*pedidosList.size()/3;i<pedidosList.size();i++)
			list3.add(pedidosList.get(i));

		Fila impressora3 = new Fila (list3);

		System.out.println("\n-----3 impressoras-----\n"+
							 "=======================");
		System.out.println("Impressora 1\n");
		comEntrega = comEntrega(list1);
		resultadoImpressora(impressora1,comEntrega);
//		System.out.println("Impressões entregues no prazo: "+impressora1.impressoesDentroDoPrazo());
//		System.out.println("Tempo Médio de Retorno: "+impressora1.mediaTempoRetorno());
//		System.out.println("Tempo Médio de Resposta: "+impressora1.mediaTempoResposta());
//		System.out.println("Tempo Total de Impressão: "+impressora1.executa());

		System.out.println("\nImpressora 2\n");
		comEntrega = comEntrega(list2);
		resultadoImpressora(impressora2,comEntrega);
//		System.out.println("Impressões entregues no prazo: "+impressora2.impressoesDentroDoPrazo());
//		System.out.println("Tempo Médio de Retorno: "+impressora2.mediaTempoRetorno());
//		System.out.println("Tempo Médio de Resposta: "+impressora2.mediaTempoResposta());
//		System.out.println("Tempo Total de Impressão: "+impressora2.executa());


		System.out.println("\nImpressora 3\n");
		comEntrega = comEntrega(list3);
		resultadoImpressora(impressora3,comEntrega);
//		System.out.println("Impressões entregues no prazo: "+impressora3.impressoesDentroDoPrazo());
//		System.out.println("Tempo Médio de Retorno: "+impressora3.mediaTempoRetorno());
//		System.out.println("Tempo Médio de Resposta: "+impressora3.mediaTempoResposta());
//		System.out.println("Tempo Total de Impressão: "+impressora3.executa());
		

		//reset das listas - com 2 listas
		pedidosList = retornaArquivo("dadosGrafica.txt");
		list1 = new ArrayList<Pedido>();
		list2 = new ArrayList<Pedido>();

		for(int i=0;i<pedidosList.size()/2;i++)
			list1.add(pedidosList.get(i));

		for(int i=pedidosList.size()/2;i<pedidosList.size();i++)
			list2.add(pedidosList.get(i));
		
//		
//		
//		
//		
//		Fila de Prioridade
//		
//		
//
//

		System.out.println("\n\n=======================\n"+
				"==FILA DE PRIORIDADES==\n"+
				"=======================");

		System.out.println("\n-----2 impressoras-----\n"+
				"=======================");

		FilaDePrioridade fp = new FilaDePrioridade(list1);
		comEntrega = 0;
		for(int i=0;i<list1.size();i++)
			if(list1.get(i).getDeliveryTime()!=0)
				comEntrega++;

		fp.executaRoundRobin();
		System.out.println("\n\nImpressora 1");
		resultadoImpressora(fp,comEntrega);
		//		System.out.println("Impressoes entregues no prazo= "+fp.getEntreguesNoPrazo()+" de "+comEntrega);
		//		System.out.println("Tempo medio de Retorno: "+fp.getMediaRetorno());
		//		System.out.println("Tempo medio de Resposta: "+fp.getMediaResposta());
		//		System.out.println("Tempo total de impressao: "+fp.getTempoGasto());


		FilaDePrioridade fp2 = new FilaDePrioridade(list2);
		comEntrega = 0;
		for(int i=0;i<list2.size();i++)
			if(list2.get(i).getDeliveryTime()!=0)
				comEntrega++;

		fp2.executaRoundRobin();
		System.out.println("\n\nImpressora 2");
		resultadoImpressora(fp2,comEntrega);
		//		System.out.println("Impresoes entregues no prazo= "+fp2.getEntreguesNoPrazo()+" de "+comEntrega);
		//		System.out.println("Tempo medio de Retorno: "+fp2.getMediaRetorno());
		//		System.out.println("Tempo medio de Resposta: "+fp2.getMediaResposta());
		//		System.out.println("Tempo total de impressao: "+fp2.getTempoGasto());

		int totalNoPrazo = fp.getEntreguesNoPrazo() +fp2.getEntreguesNoPrazo();
		float mRetorno = (fp.getMediaRetorno()+fp2.getMediaRetorno())/2;
		float mResposta = (fp.getMediaResposta()+fp2.getMediaResposta())/2;
		System.out.println("\n"+totalNoPrazo+"\t"+mRetorno+"\t"+mResposta);

		System.out.println("\n-----3 impressoras-----\n"+
				"=======================");

		//reset das listas - com 3 listas
		pedidosList = retornaArquivo("dadosGrafica.txt");
		list1 = new ArrayList<Pedido>();
		list2 = new ArrayList<Pedido>();
		list3 = new ArrayList<Pedido>();

		for(int i=0;i<pedidosList.size()/3;i++)
			list1.add(pedidosList.get(i));

		for(int i=pedidosList.size()/3;i<(pedidosList.size()/3)*2;i++)
			list2.add(pedidosList.get(i));

		for(int i=(pedidosList.size()/3)*2;i<pedidosList.size();i++)
			list3.add(pedidosList.get(i));

//primeira impressora
		FilaDePrioridade fp1 = new FilaDePrioridade(list1);
		comEntrega = comEntrega(list1);
		fp1.executaRoundRobin();
		System.out.println("\n\nImpressora 1");
		resultadoImpressora(fp1,comEntrega);


//segunda impressora
		fp2 = new FilaDePrioridade(list2);
		comEntrega = comEntrega(list2);
		fp2.executaRoundRobin();
		System.out.println("\n\nImpressora 2");
		resultadoImpressora(fp2,comEntrega);


//terceira impressora
		FilaDePrioridade fp3 = new FilaDePrioridade(list3);
		comEntrega = comEntrega(list3);
		fp3.executaRoundRobin();
		System.out.println("\n\nImpressora 3");
		resultadoImpressora(fp3,comEntrega);

		mediaImpressoras(fp1,fp2,fp3);


//		
//		
//		
//		ROUND ROBIN
//		
//		
//		
//		

		//reset das listas - com 2 listas
		pedidosList = retornaArquivo("dadosGrafica.txt");
		list1 = new ArrayList<Pedido>();
		list2 = new ArrayList<Pedido>();

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
		comEntrega = comEntrega(list1);
		System.out.println("\nImpressora 1");
		resultadoImpressora(r1,comEntrega);

//segunda impressora
		RoundRobin r2 = new RoundRobin(list2);
		float tempot2 = r2.executa();
		comEntrega = comEntrega(list2);
		System.out.println("\n\nImpressora 2");
		resultadoImpressora(r2,comEntrega);

		mediaImpressoras(r1,r2);


		//reset das listas - com 3 listas
		pedidosList = retornaArquivo("dadosGrafica.txt");
		list1 = new ArrayList<Pedido>();
		list2 = new ArrayList<Pedido>();
		list3 = new ArrayList<Pedido>();

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
		comEntrega = comEntrega(list1);
		System.out.println("\nImpressora 1");
		resultadoImpressora(r1,comEntrega);
		
//segunda impressora 
		r2 = new RoundRobin(list2);
		tempot2 = r2.executa();
		comEntrega = comEntrega(list2);
		System.out.println("\n\nImpressora 2");
		resultadoImpressora(r2,comEntrega);

//terceira impressora
		RoundRobin r3 = new RoundRobin(list3);
		float tempot3 = r3.executa();
		comEntrega = comEntrega(list3);
		System.out.println("\n\nImpressora 3");
		resultadoImpressora(r3,comEntrega);
		
		mediaImpressoras(r1,r2,r3);

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
	
	public static int comEntrega(ArrayList<Pedido> list) {
		int comEntrega = 0;
		for(int i=0;i<list.size();i++)
			if(list.get(i).getDeliveryTime()!=0)
				comEntrega++;
		return comEntrega;
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
}