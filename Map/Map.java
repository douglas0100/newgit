package Map;

import Characters.Character;

public class Map {
    private MapPosition[][] positions;

    public Map() {
        this.positions = new MapPosition[20][20];
        startMapPositions();
    }

    public void startMapPositions() {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                this.positions[i][j] = new MapPosition();
            }
        }
    }

    public void addCharacterOnMap(Character character) {
        this.positions[character.getCharacterPositionY()][character.getCharacterPositionX()]
        .addCharacter(character);
    }

    public void removeCharacterOnMap(Character character) {
        this.positions[character.getOldCharacterPositionY()][character.getOldCharacterPositionX()]
        .removeCharacter();
    }

    public void setCharacterPosition(Character character) {
        removeCharacterOnMap(character);
        addCharacterOnMap(character);
    }

    public MapPosition[][] getMapPositions() {
        return this.positions;
    }

}
