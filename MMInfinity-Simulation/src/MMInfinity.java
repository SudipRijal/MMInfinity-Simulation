import java.util.Random;
import java.util.Scanner;


public class MMInfinity {

	static Scanner input = new Scanner(System.in);
	static int busyServers;
	static int countZero = 0;
	static int countOne = 0;
	static int countTwo = 0;
	static int countThree = 0;
	static int countFour = 0;


	final static float lambda = 90;
	final static float  mu = 100;


	//creating linked list for arrivals, departure and event
	static LinkedList  objarrival = new LinkedList();
	static LinkedList  objdepart = new LinkedList();
	static LinkedList  objactive = new LinkedList();



	static Random randomNumber = new Random();

	public static  float getNext( float number) {
		return (float)  (Math.log(1-randomNumber.nextFloat())/(-number));
	}

	public static  void arrival() {
		//creating all the arrivals  
		//inserting the arrivals to the linked list





		float arrival = getNext(lambda);
		objarrival.insert(arrival);	

		System.out.print( arrival+"   ");


	}



	//creating all the departure  
	//inserting the departure to the linked list

	public static void depart() {

		float depart = getNext(mu);
		objdepart.insert(depart);


		System.out.print(depart);

	}

	public static void count() {
		if(busyServers ==0  ) {

			countZero++;

		}
		if(busyServers ==1  ) {

			countOne++;

		}
		if(busyServers ==2  ) {

			countTwo++;

		}
		if(busyServers ==3  ) {

			countThree++;

		}if(busyServers ==4  ) {

			countFour++;

		}
		
		

	}
	public static void counts() {
		if(busyServers <0) {
			busyServers++;
		}
		
	}
	public static float sum (float[] array) {

		float sum = 0;
		for ( int i = 0; i<array.length;i++) {
			sum += array[i];
		}
		return sum;

	}


	public static void main(String[] args) {


		System.out.println("For How many customers do you want to run the Simulations ?");
		float numofCust = input.nextFloat();

		//creating arrivals and departure 
		System.out.println("Arrivals :        Departure :    ");
		System.out.println("   ");
		for ( int i = 0; i<numofCust; i++) {
			arrival();
			depart();	
			System.out.println("\n");

		}

		System.out.println("   ");


		busyServers = 0;
		count();
		counts();

		System.out.println("busyServers : "+busyServers);
		System.out.println("Arrival [ "+ 0 +" ] =  "+ objarrival.GetNth(0) );
		busyServers++;
		count();
		counts();
		System.out.println("busyServers : "+busyServers);
		System.out.println("  ");

		int p = 1;
		for ( int i = 0; i < numofCust; i++ ) {

			int ac =  objactive.getCount();




			//departure generates 
			float newdeparts = objdepart.GetNth(i);
			//			System.out.println("Depart  [ "+ i +" ] =  "+newdeparts);
			//			System.out.println(" ");

			float newapppart =  objarrival.GetNth(p);
			//busyServers++;



			if(ac> 0) {

				for(int j = 0; j<ac; j++) {

					if(newapppart >   objactive.GetNth(j)) {
						busyServers--;
						count();
						counts();
						objactive.deleteFirst();

						break;


					}
				}	 

			}



			if(newdeparts > newapppart) {

				System.out.println("Arrival [ "+i+" ] do not departure ");
				busyServers++;
				count();
				counts();
				System.out.println("busyServers : "+busyServers);
				System.out.println(" ");



				objactive.insert(newdeparts);

				p++;




			}


			else if(newapppart > newdeparts) {

				if(busyServers < 0) {
					busyServers++;
					count();
					counts();
					System.out.println("busyServers : "+busyServers);

					System.out.println( "Arrival [ "+i+" ]  takes a departure");



					p++;

				}

				else {
					busyServers--;
					count();
					counts();
					System.out.println("busyServers : "+busyServers);

					System.out.println("Depart  [ "+ i +" ] =  "+newdeparts);
					System.out.println( "Arrival [ "+i+" ]  takes a departure");



					p++;
				}


			}


		}
		System.out.println("Number of times Zero Servers were Busy : "+countZero);
		System.out.println("Number of times One Servers were Busy : "+countOne);
		System.out.println("Number of times Two Servers were Busy : "+countTwo);
		System.out.println("Number of times Three Servers were Busy : "+countThree);
		System.out.println("Number of times Four Servers were Busy : "+countFour);
		float result=0;
		float newarray []= new float [(int) numofCust];
		for( int i = 0; i< numofCust; i++ ) {
			 result= objdepart.GetNth(i)- objarrival.GetNth(i);
			if(result >0) {
				newarray[i]= result;
			}
			else if(result <0) {
				result = result *(-1);
				newarray[i]= result;

			}


		}

		System.out.println("  ");
		
		System.out.println("Average time Number of Busy Servers is: "+(result/numofCust));

	}


}


