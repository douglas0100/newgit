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

    public List<Character> monsters;
    public List<Character> potions;
    public List<Character> bosses;
    public List<Character> weapons;

    public Map map;
    public Character player;

    public CharacterManager(Map map) {
        this.player = new Player();
        this.map = map;
        this.map.addCharacterOnMap(player);
    }

    public void createMonsters(int monstersNumber) {
        this.monsters = new LinkedList<>();
        createMonstersAndAddOnMap(monstersNumber);
    }

    public void createPotions(int potionsNumber){
        this.potions = new LinkedList<>();
        createPotionsAndAddOnMap(potionsNumber);
    }

    public void createBosses(int bossesNumber){
        this.bosses = new LinkedList<>();
        createBossesAndAddOnMap(bossesNumber);
    }

    public void createWeapons(int weaponsNumber){
        this.weapons = new LinkedList<>();
        createWeaponsAndAddOnMap(weaponsNumber);
    }

    public void setPlayerPosition(char comand) {
        int newPositionX = this.player.getCharacterPositionX();
        int newPositionY = this.player.getCharacterPositionY();
        switch(comand){
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
            if(theresPotionOnNextPosition(newPositionX, newPositionY)){
                this.player.setLifePlusOrLass(6);
            }
            
            this.player.setLifePlusOrLass(-1);
            this.player.setCharacterPosition(newPositionX, newPositionY);
            this.map.setCharacterPositionOnMap(player);
            
        }
        setEnemysPosition();
    }

    public void setEnemysPosition() {
        setBossesPosition();
        setMonstersPosition();
    }


    public boolean theresPotionOnNextPosition(int positionX, int positionY){
        return this.map.theresCharacter(positionX, positionY) &&
        this.map.getCharacterOnMapPosition(positionX, positionY) instanceof Potion;
    }

    public boolean theresEnemyOnNextPosition(int positionX, int positionY){
        return this.map.theresCharacter(positionX, positionY) &&
        this.map.getCharacterOnMapPosition(positionX, positionY) instanceof Enemy;
    }

    public void createMonstersAndAddOnMap(int enemysNumber){
        for(int i = 0; i < enemysNumber; i++) {
            Character character = new Monster();
            int positionX = character.getCharacterPositionX();
            int positionY = character.getCharacterPositionY();
            while(this.map.theresCharacter(positionX, positionY)){
                positionX = creatNewAleatoryPosition();
                positionY = creatNewAleatoryPosition();
                character.setCharacterPosition(positionX, positionY);
            }
            this.monsters.add(character);
            this.map.addCharacterOnMap(character);
        }
    }

    public void createPotionsAndAddOnMap(int potionsNumber) {
        for(int i = 0; i < potionsNumber; i++) {
            Character character = new Potion();
            int positionX = character.getCharacterPositionX();
            int positionY = character.getCharacterPositionY();
            while(this.map.theresCharacter(positionX, positionY)){
                positionX = creatNewAleatoryPosition();
                positionY = creatNewAleatoryPosition();
                character.setCharacterPosition(positionX, positionY);
            }
            this.potions.add(character);
            this.map.addCharacterOnMap(character);
        }
    }

    public void createBossesAndAddOnMap(int bossesNumber) {
        for(int i = 0; i < bossesNumber; i++) {
            Character character = new Boss();
            int positionX = character.getCharacterPositionX();
            int positionY = character.getCharacterPositionY();
            while(this.map.theresCharacter(positionX, positionY)){
                positionX = creatNewAleatoryPosition();
                positionY = creatNewAleatoryPosition();
                character.setCharacterPosition(positionX, positionY);
            }
            this.bosses.add(character);
            this.map.addCharacterOnMap(character);
        }
    }

    public void createWeaponsAndAddOnMap(int weaponsNumber) {
        for(int i = 0; i < weaponsNumber; i++) {
            Character character = new Weapon();
            int positionX = character.getCharacterPositionX();
            int positionY = character.getCharacterPositionY();
            while(this.map.theresCharacter(positionX, positionY)){
                positionX = creatNewAleatoryPosition();
                positionY = creatNewAleatoryPosition();
                character.setCharacterPosition(positionX, positionY);
            }
            this.weapons.add(character);
            this.map.addCharacterOnMap(character);
        }
    }

    public int getPlayerLife(){
        return this.player.getLife();
    }

    public int getPlayerAttack(){
        return this.player.getAttackPower();
    }

    public boolean isValidatedPosition(int positionX, int positionY) {
        return positionX >= 0 && positionX < 20 && positionY >= 0 && positionY < 20;
    }

    public MapPosition[][] getMapPosition(){
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
   
    public void setMonstersPosition(){
        for(int i = 0; i < this.monsters.size(); i++) {
            int positionX = this.monsters.get(i).getCharacterPositionX();
            int positionY = this.monsters.get(i).getCharacterPositionY();
            while(this.map.theresCharacter(positionX, positionY) && isValidatedPosition(positionX, positionY)){
                positionX = this.monsters.get(i).getCharacterPositionX();
                positionY = this.monsters.get(i).getCharacterPositionY();
                positionX = creatNewAditionalPosition(positionX);
                positionY = creatNewAditionalPosition(positionY);
            }
            if(isValidatedPosition(positionX, positionY)){
                this.monsters.get(i).setCharacterPosition(positionX, positionY);
                this.map.setCharacterPositionOnMap(this.monsters.get(i));
            }
        }
    }

    public void setBossesPosition(){
        for(int i = 0; i < this.bosses.size(); i++) {
            int positionX = this.bosses.get(i).getCharacterPositionX();
            int positionY = this.bosses.get(i).getCharacterPositionY();
            while(this.map.theresCharacter(positionX, positionY) && isValidatedPosition(positionX, positionY)){
                positionX = this.bosses.get(i).getCharacterPositionX();
                positionY = this.bosses.get(i).getCharacterPositionY();
                positionX = creatNewAditionalPosition(positionX);
                positionY = creatNewAditionalPosition(positionY);
            }
            if(isValidatedPosition(positionX, positionY)){
                this.bosses.get(i).setCharacterPosition(positionX, positionY);
                this.map.setCharacterPositionOnMap(this.bosses.get(i));
            }
           
        }
    }

}