package core;

import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import css.syntax.node.EOF;
import css.syntax.node.Token;
import syntax.lexer.Lexer;
import syntax.lexer.LexerException;
import syntax.node.AOpenmarker;
import syntax.node.ATagTags;
import syntax.node.Node;
import syntax.node.Start;
import syntax.parser.Parser;
import syntax.parser.ParserException;

public class Main {

	public  void main(String[] args) throws IOException {

		Selectors selecs1 = new Selectors();

		//selecs1.push(new TagSelector("li"));
		//selecs1.push(new TagSelector("div"));
		//selecs1.push(new SeparatorSelector());

		selecs1.push(new TagSelector("div"));
		selecs1.push(new ClassSelector("big"));
		


		List<Node> candidates = new ArrayList<Node>();


		Selectors sl1 = selecs1.getNextSelector();
		System.out.println("bp");
		
		Selectors sl2 = selecs1.getNextSelector();



		try {
			Reader in = new FileReader("test.html");
			Lexer lexer = new Lexer(new PushbackReader(in, 1024));
			Parser parser = new Parser(lexer);
			
			
			Start tree = parser.parse();

			Interpreter interpreter = new Interpreter(selecs1);
			interpreter.verify(tree, sl1);


			ArrayList<Node> can = interpreter.getCandidates();
			//ATagTags vat  =  (ATagTags)can.get(0).parent();


			//InterpreterUp interpreterUp = new InterpreterUp(sl1);

			

		}
		catch (LexerException e) {
			System.err.println(e.getMessage());
			//System.out.println(e.getToken());
			System.exit(1);
		}
		catch (ParserException e) {
			System.err.println(e.getMessage());
			System.exit(1);
		}

	}

}
