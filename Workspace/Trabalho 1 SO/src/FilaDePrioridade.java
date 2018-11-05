import java.util.ArrayList;

public class FilaDePrioridade{
	private ArrayList<Pedido> list;
	private float tempoGasto;

//	private ArrayList<?> lp[] = new ArrayList<>[5];
	
	private ArrayList<Pedido> l1 = new ArrayList<Pedido>();
	private ArrayList<Pedido> l2 = new ArrayList<Pedido>();
	private ArrayList<Pedido> l3 = new ArrayList<Pedido>();
	private ArrayList<Pedido> l4 = new ArrayList<Pedido>();
	private ArrayList<Pedido> l5 = new ArrayList<Pedido>();



	public FilaDePrioridade(ArrayList<Pedido> list){
		setList(list);
		executaRoundRobin();
	}
	
	public FilaDePrioridade(ArrayList<Pedido> list,int quantum){
		setList(list);
		executaRoundRobin(quantum);
	}
	
	public void executaRoundRobin() {
		RoundRobin rr[] = new RoundRobin[5];
		for(int i=0;i<rr.length;i++)
			rr[i] = new RoundRobin();

		for(int i=0;i<rr.length;i++)
			rr[i].setList(getPriority(i+1,list));

		tempoGasto=0;
		for(int i=0;i<rr.length;i++)
			tempoGasto +=rr[i].executa();		
	}
	
	public void executaRoundRobin(int quantum) {
		RoundRobin rr[] = new RoundRobin[5];
		tempoGasto=0;
		for(int i=0;i<rr.length;i++) {
			rr[i] = new RoundRobin(getPriority(i+1,list),quantum);
			tempoGasto +=rr[i].executa();	
		}

//		for(int i=0;i<rr.length;i++)
//			rr[i].setList(getPriority(i+1,list));

//		for(int i=0;i<rr.length;i++)
//			tempoGasto +=rr[i].executa();		
	}

	public void executaFila() {
		Fila f[] = new Fila[5];
		for(int i=0;i<f.length;i++)
			f[i] = new Fila();

		for(int i=0;i<f.length;i++)
			f[i].setLista(getPriority(i+1,list));

		tempoGasto=0;
		for(int i=0;i<f.length;i++)
			tempoGasto+=f[i].executa();	
	}
	
	public int getComEntrega() {
		int comEntrega = 0;
		for(int i=0;i<list.size();i++)
			if(list.get(i).hasDelivery())
				comEntrega++;
		return comEntrega;
	}
	
	public int getEntreguesNoPrazo() {
		int entregues=0;
		for(int i=0;i<list.size();i++)
			if(list.get(i).getDeliveryTime() != 0 && list.get(i).getTimeDelivered() < list.get(i).getDeliveryTime())
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
		definePriority();
	}

	private ArrayList<Pedido> getPriority(int priority, ArrayList<Pedido> list){

		ArrayList<Pedido> listP = new ArrayList<Pedido>(); 
		if(priority == 5) {
			for(int i=0;i<list.size();i++) 
				if(list.get(i).getDeliveryTime()==0)
					listP.add(list.get(i));
		}else
			for(int i=0;i<list.size();i++)
				if((getBiggerLeftTime()/4)*(priority-1) <= list.get(i).getTimeLeft() && list.get(i).getTimeLeft() <= (getBiggerLeftTime()/4)*priority) 
					listP.add(list.get(i));

		return listP;
	}

	private void definePriority() {

		for(int i=0;i<list.size();i++) {
			if(list.get(i).getDeliveryTime()==0)
				l5.add(list.get(i));
			else {
				if((getBiggerLeftTime()/4)*0 <= list.get(i).getTimeLeft() && list.get(i).getTimeLeft() <= (getBiggerLeftTime()/4)*1) 
					l1.add(list.get(i));
				else
					if((getBiggerLeftTime()/4)*1 < list.get(i).getTimeLeft() && list.get(i).getTimeLeft() <= (getBiggerLeftTime()/4)*2)
						l2.add(list.get(i));
					else
						if((getBiggerLeftTime()/4)*2 < list.get(i).getTimeLeft() && list.get(i).getTimeLeft() <= (getBiggerLeftTime()/4)*3)
							l3.add(list.get(i));
						else
							if((getBiggerLeftTime()/4)*3 < list.get(i).getTimeLeft() && list.get(i).getTimeLeft() <= getBiggerLeftTime())
								l4.add(list.get(i));
			}
		}
	}

	public float getTempoGasto() {
		return tempoGasto;
	}

	public int getBiggerLeftTime() {
		int bigger=0;
		for(int i=0;i<list.size();i++)
			if(0 < list.get(i).getDeliveryTime()-list.get(i).getDuration())
				bigger = (int) (list.get(i).getDeliveryTime() - list.get(i).getDuration());
		return bigger;
	}

	public void setTempoGasto(float tempoGasto) {
		this.tempoGasto = tempoGasto;
	}


}