package j07_반복;

import java.util.Random;
import java.util.Scanner;

public class BaskinRobbins {
	static Scanner scanner = new Scanner(System.in);
    static int meWin = 0;
    static int comWin = 0;
    
   static Random random = new Random();
    
    public static void main(String[] args) {
        boolean flag = true;
        
        while(flag){
            System.out.println("==== Baskin Robbins31 Game ====");
            System.out.println();
            System.out.println("1. Game Start");
            System.out.println("2. Game Score");
            System.out.println("3. End Game");
            System.out.print("\n> ");
            
            int menuSelect = scanner.nextInt();
            
            if(menuSelect == 1) {
              game();
            } else if(menuSelect == 2) {
                System.out.println("\n=== SCORE ====\n");    
                System.out.println("Me Win: " + meWin);
                System.out.println("Com Win: " + comWin);
                if (meWin == 0 && comWin == 0) {
                	System.out.println("아직 게임을 시작하지 않으셨군요? 게임을 먼저 해보세요!");
                }
                
                System.out.println();
                
            } else if(menuSelect == 3) {
                System.out.println("\nThank you for playing!");
                flag = false;
            }
            else {
                System.out.println("Enter correct number please! (1~3)\n");
            }                        
        }
    }
    public static void game() {
        System.out.println();
        System.out.println("<< Game Start >>");
        
        int lastNum = 0;        
        boolean loopFalg1 = true;
        while(loopFalg1) {    
            
            // =======사용자 턴=========
            int userNum = 1;
            boolean loopFlag2 = true;
            
            while(loopFlag2) {
                
                System.out.print("Input Number(1~3) >> ");
                userNum = scanner.nextInt();
                
                if (0 < userNum && userNum < 4) {
                	loopFlag2 = false;
                }
                else {
                	System.out.println("숫자를 제대로 입력하세요. ( 1 ~ 3 )\n");
                }
            }                
            
            // 숫자 외치기(사람)
            for(int i = (lastNum + 1); i <= lastNum + userNum; i++) {
                
                if ( i > 31 ) {
                    break;
                }
                System.out.println(i + " " + "!");                 
            }
            
            lastNum += userNum;

            if (lastNum >= 31) {
                //System.out.println(lastNum);
                System.out.println("\n너의 패배입니다. 컴퓨터의 승리입니다.\n");
                comWin++;
                break;
            }
                
            System.out.println();
                
            // =======컴퓨터 턴=========           
            System.out.println("컴퓨터 턴!");
            
            int comNum = 0;
            
            if ( lastNum == 27 ) {
            	comNum = 3;					// lasNum이 27일때 무조건 3(28, 29, 30)
            }else if ( lastNum == 28 ) {    // lasNum이 28일때 무조건 2(29, 30)
                comNum = 2;
            }else if ( lastNum == 29 ) {    // lasNum이 29일때 무조건 1(30)
                comNum = 1;
            }else {
                comNum = random.nextInt(3) + 1;    // 1~3
            }
            // 숫자 외치기(컴)
            for(int i = (lastNum + 1); i <= lastNum + comNum; i++) {
                        
                if ( i > 31 ) {
                	loopFalg1 = false;
                }
                System.out.println(i + " " + "!");      
            }
            
            lastNum += comNum;
            
            if (lastNum >= 31) {
                System.out.println("\n컴퓨터의 패배입니다. 너의 승리입니다.\n");
                meWin++;
                loopFalg1 = false;
            }
                
            System.out.println();
        }
    }
}