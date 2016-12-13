import java.lang.*;
    class ChristmasGreeting extends Thread
    {
        public static void main(String[] args)
        {
			try
			{
            int iterator, bark, stars,floor;  
            //System.out.print("How many rows do you want?");
            //iterator = int.Parse(Console.ReadLine());
            iterator = 10;
            bark = iterator;
            floor = iterator;
            while(iterator>=0)
            {
                drawMargin(20);
                for (stars = 1; stars <= iterator; stars++) System.out.print(" ");
                Thread.currentThread().sleep(100);
                for (stars = 1; stars <= (bark - iterator); stars++)
                {
                    System.out.print("* ");
                    Thread.currentThread().sleep(150);
                }
                System.out.println();
                iterator--;
            }
            stars = bark/2-1;
            iterator = stars;
            while (iterator > 0)
            {
                drawMargin(20);
                for (bark = 1; bark <= stars; bark++) System.out.print("  ");
                System.out.print("| |");
                Thread.currentThread().sleep(300);
                iterator--;
                System.out.println();
            }
            drawMargin(20);
            for (iterator = 1; iterator <= floor * 2; iterator++)
            { 
                System.out.print("-"); 
                Thread.currentThread().sleep(300); 
            }
            System.out.println();
            drawMargin(8);
            String greetingEn = "Wish you a merry christmas and a happy new year!";
            String greetingDe = "Herzlichen Gluckwünsche zum Weinachten und neues Jahr!";
            drawGreeting(greetingEn);
            drawGreeting(greetingDe);
			}
			catch(Exception e)
			{
				//If this thread was intrrupted by nother thread 
			}				
        }

        static void drawMargin(int length)
        {
            while (length-- > 0) System.out.print(" ");
        }
		
		static void drawGreeting(String greeting)
        {
			try
			{
            drawMargin(8);
            for (int index = 0; index < greeting.length(); index++)
            {
                System.out.print("" + greeting.charAt(index));
                Thread.currentThread().sleep(300);
            }
            System.out.println("");
			}
			catch(Exception e)
			{
				
			}
        }
    }

