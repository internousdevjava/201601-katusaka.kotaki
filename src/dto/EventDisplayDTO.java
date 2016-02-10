package dto;

public class EventDisplayDTO {


	private String id;
	private String name;
	private double price;
	private double ticket;

	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id = id;
		System.out.println(id);
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
		System.out.println(name);
	}
	public double getPrice(){
		return price;
	}
	public void setPrice(double price){
		this.price =price;
		System.out.println(price);
	}
	public double getTicket(){
		return ticket;
	}
	public void setTicket(double ticket){
		this.ticket = ticket;
		System.out.println(ticket);
	}



}
