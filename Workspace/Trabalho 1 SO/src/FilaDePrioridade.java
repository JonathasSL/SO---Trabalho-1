import java.util.ArrayList;

public class FilaDePrioridade{
	private Pedido p;
	private ArrayList<Pedido> list;

	public FilaDePrioridade(ArrayList<Pedido> list){
		this.list=list;
		p=getSmallerLeftTime();
	}

	public Pedido getP() {
		return p;
	}

	public void setP(Pedido p) {
		this.p = p;
	}

	public ArrayList<Pedido> getList() {
		return list;
	}

	public void setList(ArrayList<Pedido> list) {
		this.list = list;
	}



	public Pedido getSmallerLeftTime() {
		int duration=(list.get(1).getDeliveryTime())-(list.get(1).getPapersAmmount()/8);
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getDeliveryTime()!=0)
				if((list.get(i).getDeliveryTime()) - (list.get(i).getPapersAmmount()/80)<duration) {
					p=list.get(i);
				}
		}
		return p;
	}

	public Pedido getBiggerLeftTime() {

	}

	public void definePriority() {
		ArrayList<Pedido> l1 = new ArrayList();
		ArrayList<Pedido> l2 = new ArrayList();
		ArrayList<Pedido> l3 = new ArrayList();
		ArrayList<Pedido> l4 = new ArrayList();
		ArrayList<Pedido> l5 = new ArrayList();
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getDeliveryTime()==0)
				l5.add(list.get(i));
		}
		
		for(int d=0;d<5;d++)
			for(int i=0;i<list.size();i++) {
				if(list.get(i).getDeliveryTime()<(260/4)*d);
					
			}
	}

}