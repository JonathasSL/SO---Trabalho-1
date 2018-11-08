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
	private float startedTime = 0;

	public Pedido(String name, int papersAmmount, float price, int deliveryTime) {
		setName(name);
		setPapersAmmount(papersAmmount);
		setPrice(price);
		setDeliveryTime(deliveryTime);
		setDuration();
		setTimeLeft();
		setTotalPrice();
		this.tempoDecorrido=0;
		setTimeDelivered(0);

	}

	public void restart() {
		this.timeDelivered=0;
		this.tempoDecorrido=0;
		this.startedTime=0;
		setDuration();
		setTimeLeft();
		setTotalPrice();
	}
	
	public boolean isDone() {
		if(tempoDecorrido == duration)
			return true;
		return false;
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

	public float getDeliveryTime() {
		return deliveryTime;
	}
	private Pedido setDeliveryTime(int deliveryTime) {
		this.deliveryTime = deliveryTime;
		return this;
	}
	public boolean hasDelivery() {
		return (deliveryTime == 0)?true:false;
	}
	
	@Override
	public String toString() {
		String string = "Pedido [name=" + name ;
		while(string.length()<40)
			string+=" ";
		string+=", papersAmmount=" + papersAmmount + ", \tprice=" + price + ", \tdeliveryTime="
				+ deliveryTime + ", \ttimeDelivered=" + timeDelivered + ", \ttimeLeft=" + timeLeft + ", \tduration="
				+ duration + ", \ttotalPrice=" + totalPrice + ", \ttempoDecorrido=" + tempoDecorrido + ", \tstartedTime="
				+ startedTime + "]";
		return string;
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
	private Pedido setDuration() {
		this.duration = papersAmmount/80;
		return this;
	}

	public float getTotalPrice() {
		return totalPrice;
	}
	public Pedido setTotalPrice() {
		this.totalPrice = papersAmmount*price;
		return this;
	}

	public float getTempoDecorrido() {
		return tempoDecorrido;
	}
	public Pedido setTempoDecorrido(float tempoDecorrido) {
		this.tempoDecorrido += tempoDecorrido;
		return this;
	}

	public float getStartedTime() {
		return startedTime;
	}
	public Pedido setStartedTime(float startedTime) {
		this.startedTime = startedTime;
		return this;
	}

	public float getDurationLeft() {
		return duration - tempoDecorrido;
	}

	
}
