package Map;
import Characters.Character;

public class MapPosition {
    private Character character;

    public MapPosition(){
        
    }

    public void addCharacter(Character character){
        this.character = character;   
    }

    public boolean theresCharacter(){
        return this.character != null;
    }
    
    @Override
    public String toString(){
        if(theresCharacter()){
            return String.format("%s ", character);
        } else {
            return String.format("%d ", 0);
        }
        
    }

    
    
}