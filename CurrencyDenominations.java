import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CurrencyDenominations {

	List<Integer> denominationList;
	int amountToPay =0;
	
	public static void main(String[] args) {
		CurrencyDenominations driverObject = new CurrencyDenominations();
		driverObject.acceptUserInput();
		driverObject.findMinimumDenominations();
	}
	
	private void acceptUserInput()
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the size of currency denominations : ");
		int noOfDenominations = sc.nextInt();
		
		denominationList = new ArrayList<Integer>();
		System.out.printf("Enter Currency Denominations : ");
		
		for(int i=0; i<noOfDenominations; i++)
			denominationList.add(sc.nextInt());
		
		System.out.println("Enter the amount you want to pay : ");
		amountToPay = sc.nextInt();
		
		sc.close();
	}

	private void findMinimumDenominations()
	{
		Collections.sort(denominationList);
		Collections.reverse(denominationList);
		
		for(int i=0; i< denominationList.size(); i++)
		{
			int currency = denominationList.get(i);
			while(amountToPay % currency>= 0 && amountToPay/currency !=0 )
			{
				int denominationQty = amountToPay/currency;
				if( denominationQty != 0)
				{
					System.out.println(currency + ":" + denominationQty);
					amountToPay = amountToPay % currency;
				}
			}
		}
		if(amountToPay > 0)
			System.out.print("Not possible");
		
		
	}
}
