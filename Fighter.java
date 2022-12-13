package BoxingGame;

public class Fighter {
	
	String name;
	int damage;
	int health;
	int weight;
	int dodge;//bloklama şansını hesaplayacağız.
	
	public Fighter(String name,int damage,int health,int weight,int dodge){
		this.name=name;
		this.damage=damage;
		this.health=health;
		this.weight=weight;
		if(dodge>=0 && dodge<=100) {
			this.dodge=dodge;
		}else {
			this.dodge=0;
		}
	}

	int hit(Fighter foe) {
		System.out.println("------------------");
		System.out.println(this.name + " => " + foe.name + " " + this.damage + " hasar vurdu.");
		
		if(foe.isDodge()) {
			System.out.println(foe.name + " gelen hasarı engelledi.");
			return foe.health;
		}
		
		if(foe.health-this.damage<0) {
			return 0;
		}
		
		return foe.health-this.damage;
	}
	
	
	
	boolean isDodge() {
		double randomNumber = Math.random()*100; //random şans alıyoruz.
		return randomNumber<=this.dodge;
	}
}
