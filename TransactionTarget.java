import java.util.Scanner;

public class TransactionTarget {

	
	public static void main(String[] args) {
		TransactionTarget driverObject = new TransactionTarget();
		driverObject.acceptUserInput();

	}
	
	private void acceptUserInput()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of transactions : ");
		int noOfTx = sc.nextInt();
		int[] txArray = new int[noOfTx];
		for(int i=0; i<noOfTx; i++)
		{
			System.out.printf("Enter Tx %d : \n", (i+1));
			txArray[i] = sc.nextInt();
			
		}
		
		System.out.println("Enter total targets to be achieved : ");
		int totalTargets = sc.nextInt();
		
		for(int i=0; i<totalTargets; i++)
		{
			System.out.println("Enter target : ");
			int target = sc.nextInt();
			
			boolean status = checkTargetAchieved(txArray, target);
			if(!status)
				System.out.println("Target can't be achieved");
		}
		
		sc.close();
		
	}

	/**
	 * @param txArray
	 * @param target
	 * @return
	 */
	private boolean checkTargetAchieved(int[] txArray, int target) {
		int sum = 0;
		boolean status = false;
		for(int i=0; i< txArray.length; i++)
		{
			sum+=txArray[i];
			if(sum >= target)
			{
				status = true;
				System.out.println("Target achieved after "+(i+1)+ " transactions");
				break;
			}
		}
		return status;
	}

}
