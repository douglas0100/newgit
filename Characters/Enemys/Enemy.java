package Characters.Enemys;

import java.util.Random;
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

	
    
	

	

}
