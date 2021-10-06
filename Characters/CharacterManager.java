package Characters;

import Characters.Enemys.Boss;
import Characters.Enemys.Monster;
import Characters.Friends.Potion;
import Characters.Friends.Weapon;
import Map.Map;

public class CharacterManager {
    public Character player;
    public Character monster1;
    public Character monster2;
    public Character monster3;
    public Character monster4;
    public Character monster5;
    public Character monster6;
    public Character boss;
    public Character potion;
    public Character potion1;
    public Character potion2;
    public Character potion3;
    public Character potion4;
    public Character potion5;
    public Character potion6;
    public Character potion7;
    public Character potion8;
    public Character weapon;

    public CharacterManager() {

    }

    
    public void criateCharacters(Map map){
        
        this.player = new Player();     
        map.addCharacterOnMap(player);

        this.monster1 = new Monster();
        map.addCharacterOnMap(monster1); 
        this.monster2 = new Monster();
        map.addCharacterOnMap(monster2); 
        this.monster3 = new Monster();
        map.addCharacterOnMap(monster3); 
        this.monster4 = new Monster();
        map.addCharacterOnMap(monster4); 
        this.monster5 = new Monster();
        map.addCharacterOnMap(monster5); 
        this.monster6 = new Monster();
        map.addCharacterOnMap(monster6);            

        Character boss = new Boss();
        map.addCharacterOnMap(boss);

        this.potion1 = new Potion();
        map.addCharacterOnMap(potion1);
        this.potion2 = new Potion();
        map.addCharacterOnMap(potion2);
        this.potion3 = new Potion();
        map.addCharacterOnMap(potion3);
        this.potion4 = new Potion();
        map.addCharacterOnMap(potion4);
        this.potion5 = new Potion();
        map.addCharacterOnMap(potion5);
        this.potion6 = new Potion();
        map.addCharacterOnMap(potion6);
        this.potion7 = new Potion();
        map.addCharacterOnMap(potion7);
        this.potion8 = new Potion();
        map.addCharacterOnMap(potion8);

        this.weapon = new Weapon();
        map.addCharacterOnMap(weapon);
    }

    public void setPlayerPositionA(Map map){
        int newPositionX = this.player.getCharacterPositionX() - 1;
        int newPositionY = this.player.getCharacterPositionY();
        if(isCharacterOnMap(newPositionX, newPositionY)){
            this.player.setCharacterPosition(newPositionX, newPositionY);
            map.setCharacterPosition(player);
        }
    }

    public void setPlayerPositionD(Map map){
        int newPositionX = this.player.getCharacterPositionX() + 1;
        int newPositionY = this.player.getCharacterPositionY();
        if(isCharacterOnMap(newPositionX, newPositionY)){
            this.player.setCharacterPosition(newPositionX, newPositionY);
            map.setCharacterPosition(player);
        }
    }

    public void setPlayerPositionW(Map map){
        int newPositionX = this.player.getCharacterPositionX();
        int newPositionY = this.player.getCharacterPositionY() - 1;
        if(isCharacterOnMap(newPositionX, newPositionY)){
            this.player.setCharacterPosition(newPositionX, newPositionY);
            map.setCharacterPosition(player);
        }
    }

    public void setPlayerPositionS(Map map){
        int newPositionX = this.player.getCharacterPositionX();
        int newPositionY = this.player.getCharacterPositionY() + 1;
        if(isCharacterOnMap(newPositionX, newPositionY)){
            this.player.setCharacterPosition(newPositionX, newPositionY);
            map.setCharacterPosition(player);
        }
    }

    public boolean isCharacterOnMap(int positionX, int positionY){
        return positionX >= 0 && positionX < 20 && positionY >= 0 && positionY < 20;
    }

    //public boolean theresEnemyOnNextPosition(){

    //}


}


