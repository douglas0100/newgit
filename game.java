import java.util.Scanner;
import Map.Map;
import Map.MapPosition;
import Characters.Friends.Potion;
import Characters.Friends.Weapon;
import Characters.Enemys.Boss;
import Characters.Enemys.Monster;
import Characters.Character;
import Characters.CharacterManager;
import Characters.Player;

public class game {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        char comand;

        Map map = new Map();
        CharacterManager characterManager = new CharacterManager(map);
        characterManager.createMonsters(8);
        characterManager.createPotions(8);
        characterManager.createBosses(1);
        characterManager.createWeapons(1);

        while (characterManager.getPlayerLife() >= 0) {

            System.out.println("===========================================");
            System.out.format("Hero HP: %d || Hero Damage: %d || Score: 25 \n",
            characterManager.getPlayerLife(), characterManager.getPlayerAttack());
            System.out.println("===========================================");
            imprimeMapa(map.getMapPositions());
            System.out.println("===========================================");

            System.out.println(" [A] - to move left.  [D] - to move right.");
            System.out.println(" [W] - to move up.    [S] - to move down.");
            System.out.println(" [SPACE] - to attack. [X] - to exit.");
            System.out.println("===========================================");

            comand = input.next().charAt(0);
            characterManager.setPlayerPosition(comand);
        } 

    }

    public static void imprimeMapa(MapPosition[][] map) {
        for (int i = 0; i < map.length; i = i + 1) {
            System.out.print("  ");
            for (int j = 0; j < map.length; j = j + 1) {
                System.out.format("%s", map[i][j]);
            }
            System.out.println();
        }
    }

}