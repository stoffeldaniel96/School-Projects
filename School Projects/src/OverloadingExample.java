/**
 * 
 */

/**
 * @author Daniel
 *
 */
public class OverloadingExample 
{
	static int x = 0;
	public static void scopeCheck ()
	{
		int x = 4;
		System.out.println(x);
	}
	public static void main(String[] args)
	{
		scopeCheck();
		System.out.println(x);
	}
}

