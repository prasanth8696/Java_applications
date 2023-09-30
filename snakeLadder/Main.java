import java.util.Scanner;



public class Main{


	public static void main(String[] args){
		Scanner sc = new Scanner();
		SnakeLadder board = new SnakeLadder();



		boolean xchance = true;

		while(true){

			if(xchance == true){

				System.out.print("This is \"X\" turn... ");
				String x = sc.next();

				board.move();

				xchance = false;
			}
			else{
				System.out.print("This is \"Y\" turn... ");
                                String x = sc.next();

                                board.move();

                                xchance = true;
                        }

		}

	}


}
