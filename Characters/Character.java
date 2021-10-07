package Characters;
import java.util.Random;

public abstract class Character {
	
	public Random aleat;
	
    public int life;
    public int attackPower;
    public int positionX;
    public int positionY;
    public int oldPositionX;
    public int oldPositionY;

    public abstract int getCharacterPositionX();

    public abstract int getCharacterPositionY();

    public abstract int getOldCharacterPositionX();

    public abstract int getOldCharacterPositionY();

    public abstract int getLife();

    public abstract int getAttackPower();

    public abstract void setLifePlusOrLass(int life);

    public abstract void setAttackPlusOrLass(int attackPower);
    
    public abstract void setCharacterPosition(int positionX, int positionY);

    public abstract String toString();

}
