package Characters.Enemys;

public class Monster extends Enemy {
	
	public Monster () {
		this.life = 5;
		this.attackPower = 1;
		this.positionX = aleat.nextInt(16) + 2;
		this.positionY = aleat.nextInt(16) + 2;
	}

	@Override
	public String toString() {
		return String.format("M");
	}

}
