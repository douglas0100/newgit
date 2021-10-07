package Characters.Enemys;
import java.util.Random;

public class Boss extends Enemy {
	
	public Boss() {
		this.aleat = new Random();
		this.life = 10;
		this.attackPower = 2;
		this.positionX = aleat.nextInt(16) + 2;
		this.positionY = aleat.nextInt(16) + 2;
		
	}

	@Override
	public void setLifePlusOrLass(int life) {
		this.life = this.life + life;
	}

	@Override
	public void setAttackPlusOrLass(int attackPower) {
		this.attackPower = this.attackPower + attackPower;
	}

	@Override
	public String toString() {
		return String.format("B");
	}

	@Override
	public int getLife() {
		return this.life;
	}

	@Override
	public int getAttackPower() {
		return this.attackPower;
	}

}
