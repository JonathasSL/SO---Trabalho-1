import java.util.ArrayList;

public class Fila {

	private ArrayList<Pedido> lista;
	private int tempoGasto; 
	private float media;

	public Fila(ArrayList<Pedido> lista) {
		setLista(lista);
		setTempoGasto(0);
		executa();
		setMediaTempoRetorno(mediaTempoRetorno()); 
	}
	public Fila() {
		setTempoGasto(0);
	}
	
 	public void setLista (ArrayList<Pedido> lista) {
		this.lista = lista;
	}

	public float getTempoGasto() {
		return tempoGasto;
	}
	public void setTempoGasto(int tempoGasto) {
		this.tempoGasto = tempoGasto;
	}

	public float getMediaTempoRetorno() {
		return media;
	}

	public void setMediaTempoRetorno(float media) {
		this.media = media;
	}	

	public float executa () {
		for (int i=0; i<lista.size(); i++) {
			lista.get(i).setStartedTime(tempoGasto);
			tempoGasto += lista.get(i).getDuration();
			lista.get(i).setTimeDelivered(tempoGasto);
			tempoGasto += 0.25;	
		} 
		return tempoGasto;
	}

	public int impressoesDentroDoPrazo (){
		int entreguesNoPrazo = 0;
		for (int i=0; i<lista.size(); i++) { 
			if (lista.get(i).getTimeDelivered() < lista.get(i).getDeliveryTime() && lista.get(i).getDeliveryTime()!=0) {
				//System.out.println(lista.get(i).getDeliveryTime()+"\t"+lista.get(i).getTimeDelivered());
				entreguesNoPrazo ++;
			}
		}
		
		return entreguesNoPrazo;
	}

	public int getComEntrega() {
		int comEntrega = 0;
		for(int i=0;i<lista.size();i++)
			if(lista.get(i).hasDelivery())
				comEntrega++;
		return comEntrega;
	}
	
	public float mediaTempoRetorno () {
		for(int i=0;i<lista.size();i++)
			media+=lista.get(i).getTimeDelivered();
		media = media/lista.size();	
		return media;
	}
	public float mediaTempoResposta () {
		float tempoMedioResposta = 0;
		for (int i=0; i<lista.size(); i++) {
			tempoMedioResposta += lista.get(i).getStartedTime();
		}
		return tempoMedioResposta / lista.size();
	}

}

