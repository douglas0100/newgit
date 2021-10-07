package Characters.Friends;

import Characters.Character;
import java.util.Random;

public abstract class Friend extends Character {
	
	public Friend() {
		this.aleat = new Random();
		this.life = 1;
		this.attackPower = 0;
		this.positionX = aleat.nextInt(20);
		this.positionY = aleat.nextInt(20);
	}
	
	@Override
	public int getCharacterPositionX() {
		return this.positionX;
	}
	
	@Override
    public int getCharacterPositionY(){
        return this.positionY;
    }

	@Override
	public int getOldCharacterPositionX() {
		return this.oldPositionX;
	}

	@Override
	public int getOldCharacterPositionY() {
		return this.oldPositionY;
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
    public void setCharacterPosition(int positionX, int positionY) {
    	this.positionX = positionX;
    	this.positionY = positionY;
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
