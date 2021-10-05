package Characters;

public class Player extends Character {
	
	public Player() {
		this.life = 25;
		this.attackPower = 1;
	    this.positionX = 0;
	    this.positionY = 0;
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
    public void setCharacterPosition(int positionX, int positionY) {
    	this.positionX = positionX;
    	this.positionY = positionY;
    }

    @Override
    public String toString(){
        return String.format("H");
    }

}
