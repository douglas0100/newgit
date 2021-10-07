package Map;
import Characters.Character;

public class MapPosition {
    private Character character;

    public MapPosition(){
        
    }

    public void addCharacter(Character character){
        this.character = character;   
    }

    public void removeCharacter() {
        this.character = null;
    }

    public boolean theresCharacter(){
        return this.character != null;
    }

    public Character getCharacter(){
        return this.character;
    }

    
    @Override
    public String toString(){
        if(theresCharacter()){
            return String.format("%s ", character);
        } else {
            return String.format("%s ", 'o');
        }
        
    }

    
    
}