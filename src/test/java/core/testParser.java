package core;

import static org.junit.Assert.*;

import org.junit.Test;

import syntax.node.*;
import syntax.lexer.*;
import syntax.parser.*;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;
import java.io.Reader;

import org.junit.Test;

import syntax.lexer.Lexer;
import syntax.node.EOF;
import syntax.node.Token;

public class testParser {

	@Test
	public void test() throws IOException {
		
		try {
            Reader in = new FileReader("test2.html");
            Lexer lexer = new Lexer(new PushbackReader(in, 1024));
            Parser parser = new Parser(lexer);
            Start tree = parser.parse();

        }
        catch (LexerException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        catch (ParserException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }


	}

}
