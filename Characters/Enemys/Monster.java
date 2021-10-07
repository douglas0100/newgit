package Characters.Enemys;
import java.util.Random;

public class Monster extends Enemy {
	
	public Monster () {
		this.aleat = new Random();
		this.life = 5;
		this.attackPower = 1;
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
		return String.format("M");
	}

	@Override
	public int getLife() {
		return this.life;
	}

	@Override
	public int getAttackPower() {
		return this.attackPower;
	}

	@Override
	public void setDiferentePosition() {
		this.aleat = new Random();
		this.positionX = aleat.nextInt(16) + 2;
		this.positionY = aleat.nextInt(16) + 2;
	}

}
