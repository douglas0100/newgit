package Map;

import Characters.Character;

public class Map {
    private MapPosition [][] positions;

    public Map(){
        this.positions = new MapPosition[20][20];
        startMapPositions();
    }
    
    public void startMapPositions() {
    	for(int i = 0; i < 20; i++) {
        	for(int j = 0; j < 20; j++) {
        		this.positions[i][j] = new MapPosition();
        	}
        }
    }

    public void addCharacterOnMap(Character character){
        this.positions[character.getCharacterPositionX()][character.getCharacterPositionY()].addCharacter(character);
    }

    public MapPosition [][] getMapPositions(){
        return this.positions;
    }
}
