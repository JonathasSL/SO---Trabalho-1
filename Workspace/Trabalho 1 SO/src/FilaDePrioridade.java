import java.util.ArrayList;

public class FilaDePrioridade{
	private ArrayList<Pedido> list;
	private float tempoGasto;

	private ArrayList<Pedido> l1 = new ArrayList<Pedido>();
	private ArrayList<Pedido> l2 = new ArrayList<Pedido>();
	private ArrayList<Pedido> l3 = new ArrayList<Pedido>();
	private ArrayList<Pedido> l4 = new ArrayList<Pedido>();
	private ArrayList<Pedido> l5 = new ArrayList<Pedido>();


	public FilaDePrioridade(ArrayList<Pedido> list){
		this.list=list;
		definePriority();
		RoundRobin r1 = new RoundRobin(l1);
		RoundRobin r2 = new RoundRobin(l2);
		RoundRobin r3 = new RoundRobin(l3);
		RoundRobin r4 = new RoundRobin(l4);
		RoundRobin r5 = new RoundRobin(l5);
		setTempoGasto(r1.executa()+r2.executa()+r3.executa()+r4.executa()+r5.executa());
	}
	
	public int getEntreguesNoPrazo() {
		int entregues=0;
		for(int i=0;i<list.size();i++)
			if(list.get(i).getTimeDelivered()<=list.get(i).getDeliveryTime())
				entregues++;
		return entregues;
	}
	
	public float getMediaRetorno() {
		float tempoRetorno=0;
		for(int i=0;i<list.size();i++) {
			tempoRetorno += list.get(i).getTimeDelivered();
		}
		tempoRetorno /= list.size();
		return tempoRetorno;
	}
	
	public float getMediaResposta() {
		float tempoDeResposta=0;
		for(int i=0;i<list.size();i++) {
			tempoDeResposta += list.get(i).getStartedTime();
		}
		tempoDeResposta /= list.size();
		return tempoDeResposta;
	}
		
	public ArrayList<Pedido> getList() {
		return list;
	}
	public void setList(ArrayList<Pedido> list) {
		this.list = list;
	}

	public void definePriority() {

		for(int i=0;i<list.size();i++) {
			if(list.get(i).getDeliveryTime()==0)
				l5.add(list.get(i));
			else {
				if((260/4)*0 <= list.get(i).getTimeLeft() && list.get(i).getTimeLeft() <= (260/4)*1) 
					l1.add(list.get(i));
				else
					if((260/4)*1 < list.get(i).getTimeLeft() && list.get(i).getTimeLeft() <= (260/4)*2)
						l2.add(list.get(i));
					else
						if((260/4)*2 < list.get(i).getTimeLeft() && list.get(i).getTimeLeft() <= (260/4)*3)
							l3.add(list.get(i));
						else
							if((260/4)*3 < list.get(i).getTimeLeft() && list.get(i).getTimeLeft() <= 260)
								l4.add(list.get(i));
			}
		}
	}


	public float getTempoGasto() {
		return tempoGasto;
    
	public Pedido getBiggerLeftTime() {
		return p;
	}

	public void setTempoGasto(float tempoGasto) {
		this.tempoGasto = tempoGasto;
	}

	
}