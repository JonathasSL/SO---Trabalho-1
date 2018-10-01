public class Pedido {
	//Do arquivo
	private String name;
	private int papersAmmount;
	private float price;
	private int deliveryTime;
	//Do programa
	private float timeDelivered;
	private float timeLeft;
	private float duration;
	private float totalPrice;
	private float tempoDecorrido;
	private float startedTime;

	public Pedido(String name, int papersAmmount, float price, int deliveryTime) {
		setName(name);
		setPapersAmmount(papersAmmount);
		setPrice(price);
		setDeliveryTime(deliveryTime);
		setDuration();
		setTimeLeft();
		setTotalPrice();
		setTempoDecorrido(0);
	}

	public String getName() {
		return name;
	}
	private Pedido setName(String name) {
		this.name = name;
		return this;
	}

	public int getPapersAmmount() {
		return papersAmmount;
	}
	private Pedido setPapersAmmount(int papersAmmount) {
		this.papersAmmount = papersAmmount;
		return this;
	}

	public float getPrice() {
		return price;
	}
	private Pedido setPrice(float price) {
		this.price = price;
		return this;
	}

	public int getDeliveryTime() {
		return deliveryTime;
	}
	private Pedido setDeliveryTime(int deliveryTime) {
		this.deliveryTime = deliveryTime;
		return this;
	}

	public String toString() {
		return "Nome: "+name+"\tPapers Ammount: "+papersAmmount+"\tPrice per paper: "+price+"\tDelivery Time: "+deliveryTime;
	}

	public float getTimeDelivered() {
		return timeDelivered;
	}
	public Pedido setTimeDelivered(float timeDelivered) {
		this.timeDelivered = timeDelivered;
		return this;
	}

	public float getTimeLeft() {
		return timeLeft;
	}
	public Pedido setTimeLeft() {
		if(deliveryTime!=0)
			this.timeLeft = deliveryTime-getDuration();
		return this;
	}

	public float getDuration() {
		return duration;
	}
	private void setDuration() {
		this.duration = papersAmmount/80;
	}

	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice() {
		this.totalPrice = papersAmmount*price;
	}


	public float getTempoDecorrido() {
		return tempoDecorrido;
	}

	public void setTempoDecorrido(float tempoDecorrido) {
		this.tempoDecorrido += tempoDecorrido;
	}

	public float getStartedTime() {
		return startedTime;
	}
	public void setStartedTime(float startedTime) {
		this.startedTime = startedTime;
	}
	
}
