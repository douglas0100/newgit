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
        CharacterManager characterManager = new CharacterManager();
        characterManager.criateCharacters(map);

        while (true) {

            System.out.println("===========================================");
            System.out.println("Hero HP: 25 || Hero Damage: 1 || Score: 25");
            System.out.println("===========================================");
            imprimeMapa(map.getMapPositions());
            System.out.println("===========================================");

            System.out.println(" [A] - to move left.  [D] - to move right.");
            System.out.println(" [W] - to move up.    [S] - to move down.");
            System.out.println(" [SPACE] - to attack. [X] - to exit.");

            comand = input.next().charAt(0);
            if (comand == 'd') {
                characterManager.setPlayerPositionD(map);
            } else if (comand == 's') {
                characterManager.setPlayerPositionS(map);
            } else if (comand == 'a') {
                characterManager.setPlayerPositionA(map);
            } else if (comand == 'w') {
                characterManager.setPlayerPositionW(map);
            }
        }

    }
    // Movimentação

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