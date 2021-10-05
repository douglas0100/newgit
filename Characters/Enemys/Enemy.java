package Characters.Enemys;

import Characters.Character;

public abstract class Enemy extends Character {
	
	@Override
	public int getCharacterPositionX() {
		return this.positionX;
	}
	
	@Override
    public int getCharacterPositionY(){
        return this.positionY;
    }
    
	@Override
    public void setCharacterPosition(int positionX, int positionY) {
    	this.positionX = positionX;
    	this.positionY = positionY;
    }

}
