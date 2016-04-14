package core;

import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

import css.syntax.node.EOF;
import css.syntax.node.Token;
import syntax.lexer.Lexer;
import syntax.lexer.LexerException;
import syntax.node.ATagTags;
import syntax.node.Node;
import syntax.node.Start;
import syntax.parser.Parser;
import syntax.parser.ParserException;




public class Javagiri {

	List<Node> candidates;

	private Javagiri(){
		candidates = new ArrayList<Node>();
	}

	public Javagiri css(String selectors){
		
		
		Selectors selecs1 = cssLexer.pareseSelectors(selectors);
	
		List<Node> newcandidates = new ArrayList<Node>();


		for (Node node : candidates) {

			Interpreter interpreter = new Interpreter(selecs1);
			interpreter.caseATagTags((ATagTags) node);

			ArrayList<Node> can = interpreter.getCandidates();
			for (Node foundnode : can) {
				newcandidates.add(foundnode);
			}

			candidates = newcandidates;

		}
		return this;

	}

	public static Javagiri parse(String htmlDoc) throws IOException, JavaGiriException{
		Javagiri instance = new Javagiri();



		Selectors selecs1 = new Selectors();
		selecs1.push(new TagSelector("html"));

		List<Node> candidates = new ArrayList<Node>();

		Selectors sl1 = selecs1.getNextSelector();
		System.out.println("bp");

		Selectors sl2 = selecs1.getNextSelector();

		try {
			Reader in = new StringReader(htmlDoc);
			//Reader in = new FileReader("test.html");
			Lexer lexer = new Lexer(new PushbackReader(in, 1024));
			Parser parser = new Parser(lexer);


			Start tree = parser.parse();

			Interpreter interpreter = new Interpreter(selecs1);
			interpreter.verify(tree, sl1);


			ArrayList<Node> can = interpreter.getCandidates();
			for (Node node : can) {
				instance.candidates.add(node);
			}
			if(instance.candidates.size() == 0){
				throw new JavaGiriException("document html not valid");
			}
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
		return instance;


	}
	public Javagiri get(int i){
		Javagiri instance = new Javagiri();
		instance.candidates.add(this.candidates.get(i));
		
		return instance;
		
	}
	
	public Javagiri getChildren(int i){
		Javagiri instance = new Javagiri();
		Node n = ((ATagTags) this.candidates.get(0)).getTags().get(i);
		
		instance.candidates.add(n);
		
		return instance;
		
	}
	
	
	
	@Override
	public String toString(){
		String res = "";
		for (Node can : candidates) {
			res += can + "\n";
			
		}
		
		return res;
		
	}
	
}