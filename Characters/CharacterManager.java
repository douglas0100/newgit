package Characters;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import Characters.Enemys.Boss;
import Characters.Enemys.Enemy;
import Characters.Enemys.Monster;
import Characters.Friends.Potion;
import Characters.Friends.Weapon;
import Map.Map;
import Map.MapPosition;

public class CharacterManager {

    public static Random aleat;

    public List<Character> characters;

    public Map map;
    public Character player;

    public CharacterManager(Map map) {
        this.player = new Player();
        this.map = map;
        this.map.addCharacterOnMap(player);
        this.characters = new LinkedList<>();
    }

    public void setPlayerPosition(char comand) {
        int newPositionX = this.player.getCharacterPositionX();
        int newPositionY = this.player.getCharacterPositionY();
        switch (comand) {
            case 'a':
                newPositionX = this.player.getCharacterPositionX() - 1;
                break;
            case 'd':
                newPositionX = this.player.getCharacterPositionX() + 1;
                break;
            case 'w':
                newPositionY = this.player.getCharacterPositionY() - 1;
                break;
            case 's':
                newPositionY = this.player.getCharacterPositionY() + 1;
                break;
        }
        if (isValidatedPosition(newPositionX, newPositionY) && !theresEnemyOnNextPosition(newPositionX, newPositionY)) {
            if (theresPotionOnNextPosition(newPositionX, newPositionY)) {
                this.player.setLifePlusOrLass(6);
            }
            if (theresWeaponOnNextPosition(newPositionX, newPositionY)) {
                this.player.setAttackPlusOrLass(1);
            }
            this.player.setLifePlusOrLass(-1);
            this.player.setCharacterPosition(newPositionX, newPositionY);
            this.map.setCharacterPositionOnMap(player);
        }
        setEnemysPosition();
    }

    public boolean theresPotionOnNextPosition(int positionX, int positionY) {
        return this.map.theresCharacter(positionX, positionY)
                && this.map.getCharacterOnMapPosition(positionX, positionY) instanceof Potion;
    }

    public boolean theresWeaponOnNextPosition(int positionX, int positionY) {
        return this.map.theresCharacter(positionX, positionY)
                && this.map.getCharacterOnMapPosition(positionX, positionY) instanceof Weapon;
    }

    public boolean theresEnemyOnNextPosition(int positionX, int positionY) {
        return this.map.theresCharacter(positionX, positionY)
                && this.map.getCharacterOnMapPosition(positionX, positionY) instanceof Enemy;
    }

    public void createMonsters(int enemysNumber) {
        for (int i = 0; i < enemysNumber; i++) {
            Character character = new Monster();
            addCharacterOnMap(character);
        }
    }

    public void createPotions(int potionsNumber) {
        for (int i = 0; i < potionsNumber; i++) {
            Character character = new Potion();
            addCharacterOnMap(character);
        }
    }

    public void createBosses(int bossesNumber) {
        for (int i = 0; i < bossesNumber; i++) {
            Character character = new Boss();
            addCharacterOnMap(character);
        }
    }

    public void createWeapons(int weaponsNumber) {
        for (int i = 0; i < weaponsNumber; i++) {
            Character character = new Weapon();
            addCharacterOnMap(character);
        }
    }

    public int getPlayerLife() {
        return this.player.getLife();
    }

    public int getPlayerAttack() {
        return this.player.getAttackPower();
    }

    public boolean isValidatedPosition(int positionX, int positionY) {
        return positionX >= 0 && positionX < 20 && positionY >= 0 && positionY < 20;
    }

    public MapPosition[][] getMapPosition() {
        return this.map.getMapPositions();
    }

    public int creatNewAleatoryPosition() {
        aleat = new Random();
        int newPosition = aleat.nextInt(16) + 2;
        return newPosition;
    }

    public int creatNewAditionalPosition(int position) {
        aleat = new Random();
        position = position + aleat.nextInt(3) - 1;
        return position;
    }

    public void setEnemysPosition() {
        for (int i = 0; i < this.characters.size(); i++) {
            this.characters.get(i);
            if (this.characters.get(i) instanceof Enemy) {
                setCharacterPosition(this.characters.get(i));
            }
        }
    }

    public void setCharacterPosition(Character character) {
        int positionX = character.getCharacterPositionX();
        int positionY = character.getCharacterPositionY();
        while (isValidatedPosition(positionX, positionY) && this.map.theresCharacter(positionX, positionY)) {
            positionX = character.getCharacterPositionX();
            positionY = character.getCharacterPositionY();
            positionX = creatNewAditionalPosition(positionX);
            positionY = creatNewAditionalPosition(positionY);
        }
        if (isValidatedPosition(positionX, positionY)) {
            character.setCharacterPosition(positionX, positionY);
            this.map.setCharacterPositionOnMap(character);
        }
    }

    public void addCharacterOnMap(Character character) {
        int positionX = character.getCharacterPositionX();
        int positionY = character.getCharacterPositionY();
        while (this.map.theresCharacter(positionX, positionY)) {
            positionX = creatNewAleatoryPosition();
            positionY = creatNewAleatoryPosition();
            character.setCharacterPosition(positionX, positionY);
        }
        this.characters.add(character);
        this.map.addCharacterOnMap(character);
    }

    public boolean heroAreAtTheDoor() {
        return this.player.getCharacterPositionX() == 19 && this.player.getCharacterPositionY() == 19;
    }

}