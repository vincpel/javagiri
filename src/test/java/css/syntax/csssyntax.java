package css.syntax;

import static org.junit.Assert.*;

import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;
import java.io.Reader;
import java.io.StringReader;

import org.junit.Test;

import css.syntax.lexer.Lexer;
import css.syntax.lexer.LexerException;
import css.syntax.node.EOF;
import css.syntax.node.Token;

public class csssyntax {

	@Test
	public void test() throws LexerException, IOException {
		StringReader in = new StringReader("html > body > div");
        
        Lexer lexer = new Lexer(new PushbackReader(in, 1024));
        
        Token token;
        while(!((token = lexer.next()) instanceof EOF)) {
            System.out.print(token.getClass().getSimpleName());
            System.out.println(": " + token.getText());
        }
	}
	
	@Test
	public void test2() throws LexerException, IOException {
		StringReader in = new StringReader("div#big> div > table[1] > tr");
        
        Lexer lexer = new Lexer(new PushbackReader(in, 1024));
        
        Token token;
        while(!((token = lexer.next()) instanceof EOF)) {
            System.out.print(token.getClass().getSimpleName());
            System.out.println(": " + token.getText());
        }
	}
	
	
	@Test
	public void test3() throws LexerException, IOException {
		StringReader in = new StringReader("span");
        
        Lexer lexer = new Lexer(new PushbackReader(in, 1024));
        
        Token token;
        while(!((token = lexer.next()) instanceof EOF)) {
            System.out.print(token.getClass().getSimpleName());
            System.out.println(": " + token.getText());
        }
	}

}
