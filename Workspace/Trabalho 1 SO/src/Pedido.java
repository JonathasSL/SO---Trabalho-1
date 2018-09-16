public class Pedido {
	private String name;
	private int papersAmmount;
	private float price;
	private int deliveryTime;
	
	public Pedido(String name, int papersAmmount, float price, int deliveryTime) {
		this.name=name;
		this.papersAmmount=papersAmmount;
		this.price=price;
		this.deliveryTime=deliveryTime;
	}
	public Pedido() {
		
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getPapersAmmount() {
		return papersAmmount;
	}
	public void setPapersAmmount(int papersAmmount) {
		this.papersAmmount = papersAmmount;
	}

	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

	public int getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(int deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	
	public String toString() {
		return "Nome: "+name+"\nPapers Ammount: "+papersAmmount+"\nPrice per paper: "+price+"\nDelivery Time: "+deliveryTime+"\n\n";
	}
}
