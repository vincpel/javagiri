package core;
import java.io.*;

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

public class testletokenTest {

	@Test
	public void test() throws LexerException, IOException {
        Reader in = new FileReader("test2.html");
        Lexer lexer = new Lexer(new PushbackReader(in, 1024));
        
        Token token;
        while(!((token = lexer.next()) instanceof EOF)) {
            System.out.print(token.getClass().getSimpleName());
            System.out.println(": " + token.getText());
        }
	}

}
