import java.util.ArrayList;

public class Fila {

	private ArrayList<Pedido> lista;
	private int tempoGasto;
	public int getTempoGasto() {
		return tempoGasto;
	}

	public Fila(ArrayList<Pedido> lista) {
		this.lista = lista;
	}

	public int comparaTempos (){
		int entreguesNoPrazo = 0;
		for (int i=0; i<144; i++) { 
			tempoGasto += lista.get(i).getPapersAmmount()/80;
			lista.get(i).setTimeDelivered(tempoGasto);
			if (tempoGasto < lista.get(i).getDeliveryTime()) {
				entreguesNoPrazo ++;
			}
		}
		return entreguesNoPrazo;
	}		


	public int Media () {
		int media = 0;
		for(int i=0;i<144;i++)
			media+=lista.get(i).getTimeDelivered();
		media = media/144;	
		return media;
	}
}