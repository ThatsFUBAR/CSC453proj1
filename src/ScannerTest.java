public class ScannerTest {

	/* Quick test of token extraction */
	public static void testTokenExtraction() {
		System.out.println("*******************************************");
		System.out.println("Testing Token Extraction");
		Scanner test = new Scanner();

		String result = test.extractTokens("123");
		String expected = "|NUM: 123|";
		assert (result.equals(expected));

		result = test.extractTokens("+ 3 3");
		expected = "|PLUS: +||NUM: 3||NUM: 3|";
		assert (result.equals(expected));

		result = test.extractTokens("+ - * / < >");
		expected = "|PLUS: +||MINUS: -||MUL: *||DIV: /||LT: <||GT: >|";
		assert (result.equals(expected));

		result = test.extractTokens("<= - >=");
		expected = "|LTE: <=||MINUS: -||GTE: >=|";
		assert (result.equals(expected));

		System.out.println("Congrats: preliminary token extraction tests passed! Now make your own test cases "
				+ "(this is only a subset of what we will test your code on)");
		System.out.println("*******************************************");
		System.out.println();
		
		
		//Custom test cases
		result = test.extractTokens("123 456   ");
		expected = "|NUM: 123||NUM: 456|";
		assert (result.equals(expected));
		
		result = test.extractTokens("@");
		
		result = test.extractTokens("123<456");
		expected = "|NUM: 123||LT: <||NUM: 456|";
		assert (result.equals(expected));
		
		result = test.extractTokens("<=->=");
		expected = "|LTE: <=||MINUS: -||GTE: >=|";
		assert (result.equals(expected));
		
		result = test.extractTokens("			<=             -  \n >=");
		expected = "|LTE: <=||MINUS: -||GTE: >=|";
		assert (result.equals(expected));
		
		result = test.extractTokens("1234!5678");
		
		result = test.extractTokens(">>>>h");
		
		result = test.extractTokens("$<= + 23");
	}

	public static void main(String[] args) {
		testTokenExtraction();
	}

}
