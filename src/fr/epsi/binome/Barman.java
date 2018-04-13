package fr.epsi.binome;

public class Barman extends Thread {
	
	private String name;
	
	private Backlog orders;

	public Barman(String name, Backlog orders) {
		super();
		this.name = name;
		this.orders = orders;
	}



	@Override
	public void run() {		
		Cocktail cCocktail;
        do {

            cCocktail= orders.dequeue();
            
            if(cCocktail!=null) {
            	String message = String.format("%s as prepared  %s", this.name, cCocktail);
                System.out.println(this.name + " "+ cCocktail);
                
            }
           
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("ERR --> "+e.getMessage());
            }
            
        } while (!orders.isEmpty());

	}

}
