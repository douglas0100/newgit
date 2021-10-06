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
    
    @Override
    public String toString(){
        if(theresCharacter()){
            return String.format("%s ", character);
        } else {
            return String.format("%s ", 'o');
        }
        
    }
    //Método para garantir que os Characters não spawnem no mesmo lugar

    
    
}