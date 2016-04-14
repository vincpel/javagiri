package core;



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

public class cssLexer {

	
	public static Selectors pareseSelectors(String selectio ) {
		StringReader in = new StringReader(selectio);
        
        Lexer lexer = new Lexer(new PushbackReader(in, 1024));
        Token token;
        
        Selectors res = new Selectors();
        
        try {
			while(!((token = lexer.next()) instanceof EOF)) {
				
				if(token.getClass().getSimpleName().equalsIgnoreCase("TTag")) {
					res.push(new TagSelector(token.getText()));
				} else if(token.getClass().getSimpleName().equalsIgnoreCase("TClass")) {
					res.push(new ClassSelector(token.getText()));
				} else if(token.getClass().getSimpleName().equalsIgnoreCase("TId")) {
					res.push(new IdSelector(token.getText()));
				} else if(token.getClass().getSimpleName().equalsIgnoreCase("TSeletor")) {
					res.push(new SeparatorSelector());
				} else{
					
				}
				//res.push(sl);
			    //System.out.print(token.getClass().getSimpleName());
			    //System.out.println(": " + token.getText());
			}
		} catch (LexerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
		return res;
	}



}
