package BoxingGame;

public class Match {

	Fighter f1;
	Fighter f2;
	
	int minHeight;
	int maxHeight;

	
	Match(Fighter f1,Fighter f2,int minHeight,int maxHeight){
		this.f1=f1;
		this.f2=f2;
		this.maxHeight=maxHeight;
		this.minHeight=minHeight;
				
	}
	
	
	void run() {
		if(isCheck()) {
			while(this.f1.health>0&&this.f2.health>0) {
				System.out.println("----YENİ ROUND-----");
				if(isFirst()) {
					this.f2.health =this.f1.hit(this.f2);
					if(isWin()) {
						break;
					}
					this.f1.health=this.f2.hit(this.f1);
					if(isWin()) {
						break;
					}
					printScore();
				}else {
					this.f1.health =this.f2.hit(this.f1);
					if(isWin()) {
						break;
					}
					this.f2.health=this.f1.hit(this.f2);
					if(isWin()) {
						break;
					}
					printScore();
				}
				
			}
		}else {
			System.out.println("Sporcuların sikletleri uymuyor.");
		}
	}
	
	
	boolean isCheck() {
		return (this.f1.weight>=minHeight && this.f1.weight<=maxHeight) && 
				(this.f2.weight>=minHeight && this.f2.weight<=maxHeight);
				} //hepsi ok ise true döndürcek.
	
	
	boolean isWin() {
		
		if(this.f1.health==0) {
			System.out.println(this.f2.name + " kazandı! ");
			return true;
		}
		
		if(this.f2.health==0) {
			System.out.println(this.f1.name + " kazandı! ");
			return true;
		}
		
		return false;
	}
	
	public void printScore() {
		System.out.println("---------------");
		System.out.println(this.f1.name + " Health: " + this.f1.health);
		System.out.println(this.f2.name + " Health: " + this.f2.health);
	}
	
	boolean isFirst(){
		double randomNumber = Math.random()*100;
		return (randomNumber<=50);
	}
}
