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
			return "|" + this.tokenType + ": " + this.tokenVal + "|";
		}
	}

	public Token extractToken(StringBuilder stream){
	  //Ignore whitespace
	  while(stream.length() > 0 && isWhitespace(stream.charAt(0)))
    	stream.deleteCharAt(0);
	  
	  //Return null on empty stream
	  if(stream.length() == 0)
		  return null;
	  
	  //Num token
	  if(isDigit(stream.charAt(0))){
			String val =  "" + stream.charAt(0);
			stream.deleteCharAt(0);
			while(stream.length() > 0 && isDigit(stream.charAt(0))) {
				val += stream.charAt(0);
				stream.deleteCharAt(0);
			}
			return new Token(TokenType.NUM, val);
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
		  if (stream.length() > 0 && stream.charAt(0) == '=') {
			  stream.deleteCharAt(0);
			  return new Token(TokenType.LTE, "<=");
		  }
		  return new Token(TokenType.LT, "<");
	  }
	  if(stream.charAt(0) == '>') {
		  stream.deleteCharAt(0);
		  if (stream.length() > 0 && stream.charAt(0) == '=') {
			  stream.deleteCharAt(0);
			  return new Token(TokenType.GTE, ">=");
		  }
		  return new Token(TokenType.GT, ">");
	  }
	
	  //Character exists but is not expected, so report an error and return null
	  System.out.println("Error: Unexpected character in stream: " + stream.charAt(0));
	  stream.deleteCharAt(0);
	  return null;
  }

	//Helper function, returns true if charAt is a digit
	private boolean isDigit(char charAt) {
		if (charAt >= '0' && charAt <= '9')
			return true;
		return false;
	}
	
	//Helper function, returns true if charAt is whitespace
	private boolean isWhitespace(char charAt) {
		if (charAt == ' ' || charAt == '\n' || charAt == '\t')
			return true;
		return false;
	}

	public String extractTokens(String arg) {
		String result = "";
		StringBuilder sb = new StringBuilder(arg);
		while (sb.length() > 0) {
			Token nextToken = extractToken(sb);
			if(nextToken != null)
				result += nextToken.toString();
		}
		return result;
	}

}
