package utilities;

import java.util.Random;

public class RandomStringUtils {
	
	public static String generateRandomAlphabetic(int length)
	{	
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<length; i++)
		{
			int index = random.nextInt(chars.length());
			sb.append(chars.charAt(index));
		}
		return sb.toString();
	}
	
	public static String generateRandomNumeric(int length)
	{
		String numericChars = "0123456789";
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<length; i++)
		{
			int index = random.nextInt(numericChars.length());
			sb.append(numericChars.charAt(index));
		}
			
		return sb.toString();
	}
	
	public static String generateRandomAlphaNumeric(int length)
	{
		String alphaNumericChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<length; i++)
		{
			int index = random.nextInt(alphaNumericChars.length());
			sb.append(alphaNumericChars.charAt(index));
		}
		return sb.toString();
	}
	
}
