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

				Pedido pedido = new Pedido();
				pedido.setName(lineT.nextToken());
				pedido.setPapersAmmount(Integer.parseInt(lineT.nextToken()));

				//Gambs
				StringTokenizer priceT = new StringTokenizer(lineT.nextToken(),",");
				float price = Integer.parseInt(priceT.nextToken()) + Float.parseFloat(priceT.nextToken())/100;
				pedido.setPrice(price);

				pedido.setDeliveryTime(Integer.parseInt(lineT.nextToken()));
				pedidosList.add(pedido);
			}
			System.out.println(pedidosList); 
			System.out.println(pedidosList.get(134).getName());
			System.out.println("<3 :3 Seduction XD :P Linda S2 :* >.< ");

			//System.out.println(pedidosList.get(134).getName());
			entry.close();
			fileIn.close();
			
			
			int c=0,total=0;
			Pedido menor = null, maior = pedidosList.get(0);
			for(int i=0;i<pedidosList.size();i++)
				if(pedidosList.get(i).getDeliveryTime()!=0)
					menor = pedidosList.get(i);
			
			for(int i=0;i<pedidosList.size();i++) {
				
				if(pedidosList.get(i).getDeliveryTime()<menor.getDeliveryTime() && pedidosList.get(i).getDeliveryTime()!=0)
					menor=pedidosList.get(i);
				else
					if(pedidosList.get(i).getDeliveryTime()>maior.getDeliveryTime())
						maior=pedidosList.get(i);
				
				if(pedidosList.get(i).getDeliveryTime()!=0) {
					total+=pedidosList.get(i).getDeliveryTime();
					c++;
				}
			}
		

			System.out.println("total: "+total+" c: "+c+" media:"+total/c+"\nMenor: "+menor.getDeliveryTime()+" Maior: "+maior.getDeliveryTime());


//			for(int i=0;i<pedidosList.size();i++) {
//				if(pedidosList.get(i).getDeliveryTime()==2)
//					System.out.println(pedidosList.get(i));
//			}
			//				if(pedidosList.get(i).getDeliveryTime()!=0)
			//					System.out.println(pedidosList.get(i).getDeliveryTime());


//			System.out.println(pedidosList.get(134).getName());
			FilaDePrioridade fp = new FilaDePrioridade(pedidosList);
			
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
