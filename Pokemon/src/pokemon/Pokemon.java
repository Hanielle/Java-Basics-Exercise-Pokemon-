/* Name: Chua, Hanielle Jermayn E.
* Section: Gluon
*
* Date Started: 12/07/2020
* Date Finished: 12/07/2020
* */
package pokemon;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Pokemon {

    public static void main(String[] args) throws IOException{
        Monster charmander = new FireType("Charmander", 20, 10);
        Monster squirtle = new WaterType("Squirtle", 20, 10);
        Monster bulbasaur = new GrassType("Bulbasaur", 20, 10);
        int pokeChoice = 10;
        
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        
        while(pokeChoice != 0){
            System.out.println("Choose your pokemon!");
            printPokemon(Monster.getMonsterList());
            pokeChoice = Integer.parseInt(reader.readLine());
            
            if(pokeChoice == 0){
                System.exit(0);
            }
            
            if((pokeChoice > 3)||(pokeChoice < 0)){
                System.out.println("--------------");
                continue;
            }
            
            Monster userPokemon = Monster.getMonsterList().get(pokeChoice - 1);
            System.out.println("You chose " + userPokemon.getName());
            Monster.getMonsterList().remove(pokeChoice - 1);
            System.out.println("--------------");

            System.out.println("Choose you opponent!");
            printPokemon(Monster.getMonsterList());
            pokeChoice = Integer.parseInt(reader.readLine());
            
            if(pokeChoice == 0){
                System.exit(0);
            }
            
            if((pokeChoice > 2)||(pokeChoice < 0)){
                System.out.println("--------------");
                Monster.getMonsterList().add(userPokemon);
                continue;
            }
            
            Monster otherPokemon = Monster.getMonsterList().get(pokeChoice - 1);
            System.out.println("You chose " + otherPokemon.getName());
            System.out.println("--------------");
            Monster.getMonsterList().add(userPokemon);
        
            System.out.println(userPokemon.getName() + " vs " + otherPokemon.getName());
        
            while((userPokemon.getHP() > 0)&&(otherPokemon.getHP() > 0)){
                printActions();
                int action = Integer.parseInt(reader.readLine());
                switch (action){
                    case 1:
                        userPokemon.attack(otherPokemon);
                        break;
                    case 2:
                        userPokemon.guard();
                        break;
                    case 3:
                        userPokemon.charge();
                        break;
                    case 4:
                        userPokemon.rest();
                        break;
                    case 5:
                        userPokemon.special();
                        break;
                }
                System.out.println("--------------");
                if((userPokemon.getHP() > 0)&&(otherPokemon.getHP()) > 0){
                    switch (randomNumber()){
                    case 1:
                        otherPokemon.attack(userPokemon);
                        break;
                    case 2:
                        otherPokemon.guard();
                        break;
                    case 3:
                        otherPokemon.charge();
                        break;
                    case 4:
                        otherPokemon.rest();
                        break;
                    case 5:
                        otherPokemon.special();
                        break;
                    }
                    System.out.println("--------------");
                }
            }
            userPokemon.resetHealth();
            otherPokemon.resetHealth();
        }
        
        /* 
        *sample fight for reference
        System.out.println("Charmander vs Squirtle");
        while((charmander.getHP() > 0)&&(squirtle.getHP() > 0)){
            charmander.attack(squirtle);
            squirtle.attack(charmander);
        }
        charmander.resetHealth();
        squirtle.resetHealth();
        
        System.out.println("Squirtle vs Bulbasaur");
        while((squirtle.getHP() > 0)&&(bulbasaur.getHP() > 0)){
            squirtle.attack(bulbasaur);
            bulbasaur.attack(squirtle);
        }
        squirtle.resetHealth();
        bulbasaur.resetHealth();
        
        System.out.println("Bulbasaur vs Charmander");
        while((bulbasaur.getHP() > 0)&&(charmander.getHP() > 0)){
            bulbasaur.attack(charmander);
            charmander.attack(bulbasaur);
        }               
        bulbasaur.resetHealth();
        charmander.resetHealth();
           */
    }
    
    public static void printActions(){
        System.out.println("[1] Attack");
        System.out.println("[2] Guard");
        System.out.println("[3] Charge");
        System.out.println("[4] Rest");
        System.out.println("[5] Special");
        System.out.print("Choice: ");
    }
    
    public static void printPokemon(ArrayList list){
        for(Monster i : list){
            System.out.println("[" + (list.indexOf(i) + 1) + "] " + i.getName());
        }
        System.out.println("[0] Exit");
        System.out.print("Choice: ");
    }
    
    public static int randomNumber(){
        Random random = new Random();
        int rand = random.nextInt(5) + 1;
        return rand;
    }
    
}
