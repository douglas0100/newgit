import Map.Map;
import Map.MapPosition;
import Characters.Character;
import Characters.Player;


public class principal {
    public static void main(String[] args) {
    	
    	Character character = new Player();
        Map map = new Map();
        map.addCharacterOnMap(character);
        imprimeMapa(map.getMapPositions());
    }

    public static void imprimeMapa(MapPosition [][] map){
        for(int i = 0; i < map.length; i = i + 1){
            for(int j = 0; j < map.length; j = j + 1){
                System.out.format("%s", map[i][j]);
            }
            System.out.println();
        }
    }
    
}