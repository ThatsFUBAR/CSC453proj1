public class Scanner {
	enum TokenType {
		NUM, PLUS, MINUS, MUL, DIV, LT, LTE, GT, GTE;
	}

	class Token {
		TokenType tokenType;
		String tokenVal;

		public Token(TokenType tokenType, String tokenVal) {
			this.tokenType = tokenType;
			this.tokenVal = tokenVal;
		}

		public String toString() {
			return this.tokenType + ": " + this.tokenVal + " ";
		}
	}

	public Token extractToken(StringBuilder stream){
	  //Ignore whitespace
	  while(isWhitespace(stream.charAt(0)))
    	stream.deleteCharAt(0);
	  
	  //Num token
	  if(isDigit(stream.charAt(0))){
			String val =  "" + stream.charAt(0);
			stream.deleteCharAt(0);
			while(isDigit(stream.charAt(0))) {
				val += stream.charAt(0);
				stream.deleteCharAt(0);
			}
			return new Token(TokenType.NUM, "val");
	  }
	  
	  //Basic operation tokens
	  if(stream.charAt(0) == '+') {
		  stream.deleteCharAt(0);
		  return new Token(TokenType.PLUS, "+");
	  }
	  if(stream.charAt(0) == '-') {
		  stream.deleteCharAt(0);
		  return new Token(TokenType.MINUS, "-");
	  }
	  if(stream.charAt(0) == '*') {
		  stream.deleteCharAt(0);
		  return new Token(TokenType.MUL, "*");
	  }
	  if(stream.charAt(0) == '/') {
		  stream.deleteCharAt(0);
		  return new Token(TokenType.DIV, "/");
	  }
	  
	  //Greater than, greater than or equal to, less than, and less than or equal to tokens
	  if(stream.charAt(0) == '<') {
		  stream.deleteCharAt(0);
		  if (stream.charAt(0) == '=') {
			  stream.deleteCharAt(0);
			  return new Token(TokenType.LTE, "<=");
		  }
		  return new Token(TokenType.LT, "<");
	  }
	  if(stream.charAt(0) == '>') {
		  stream.deleteCharAt(0);
		  if (stream.charAt(0) == '=') {
			  stream.deleteCharAt(0);
			  return new Token(TokenType.GTE, ">=");
		  }
		  return new Token(TokenType.GT, ">");
	  }
	
	  System.out.println("Error: Unexpected character in stream: " + stream.charAt(0));
	  return null;
  }

	private boolean isDigit(char charAt) {
		if (charAt >= '0' || charAt <= '9')
			return true;
		return false;
	}

	private boolean isWhitespace(char charAt) {
		if (charAt == ' ' || charAt == '\n' || charAt == '\t')
			return true;
		return false;
	}

	public String extractTokens(String arg) {
		/*
		 * TODO #1: Finish this function to iterate over all tokens in the input string.
		 * 
		 * Pseudo code: String extractTokens(String arg): String result= while(arg is
		 * not empty) Token nextToken = extractToken(arg) result += nextToken.toString()
		 * return result
		 */

		String result = "";
		while (arg != "" && arg != null) {
			Token nextToken = extractToken(arg);
		}
		return null;
	}

}
