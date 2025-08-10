package testCases;

public class testForTestingOnlyClass {
	public static void main(String[] testOnly)
	{
		String getUser = System.getProperty("user.name");
		System.out.println("user.name returns: " + getUser);
	}
}
