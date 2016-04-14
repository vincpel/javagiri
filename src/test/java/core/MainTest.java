package core;

import static org.junit.Assert.*;

import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import syntax.lexer.Lexer;
import syntax.lexer.LexerException;
import syntax.node.Node;
import syntax.node.Start;
import syntax.parser.Parser;
import syntax.parser.ParserException;

public class MainTest {

	
	
	
	
	
	//<html>
	//<body> 
	//	<div><div class="big"><div><div class="big" ></div></div></div></div>
	//	texte libre pouvant contenir "ceci" ou cela. Lien: 
	//	<p id="pargraphe1">un paaragraphe</p>
	//	<a href="http://sablecc.org">SableCC</a>
	//	<a href="http://sablecc.org">SableCC</a>
	//	<div class="big" ><p>embedend p</p></div>
	//</body>
    //</html>
	private static String tests1 = "<html>\n\u0009<body> \n\u0009\u0009<div><div class=\"big\"><div><div class=\"big\" ></div></div></div></div>\n\u0009\u0009texte libre pouvant contenir \"ceci\" ou cela. Lien: \n\u0009\u0009<p id=\"pargraphe1\">un paaragraphe</p>\n\u0009\u0009<a href=\"http://sablecc.org\">SableCC</a>\n\u0009\u0009<a href=\"http://sablecc.org\">SableCC</a>\n\u0009\u0009<div class=\"big\" ><p>embedend p</p></div>\n\u0009</body>\n</html>";
	
	@Test
	public void test1() throws IOException {
		Selectors selecs1 = new Selectors();

		//selecs1.push(new TagSelector("li"));
		//selecs1.push(new TagSelector("div"));
		//selecs1.push(new SeparatorSelector());

		selecs1.push(new TagSelector("div"));
		selecs1.push(new ClassSelector("big"));



		List<Node> candidates = new ArrayList<Node>();


		Selectors sl1 = selecs1.getNextSelector();
		//System.out.println("bp");

		Selectors sl2 = selecs1.getNextSelector();



		try {
			Reader in = new StringReader(tests1);
			//Reader in = new FileReader("test.html");
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
	
	//<html>
		//<body> 
		//	<div><div class="big"><div><div class="big" ></div></div></div></div>
		//	texte libre pouvant contenir "ceci" ou cela. Lien: 
		//	<p id="pargraphe1">un paaragraphe</p>
		//	<a href="http://sablecc.org">SableCC</a>
		//	<a href="http://sablecc.org">SableCC</a>
		//	<div class="big" ><p>embedend p</p></div>
		//</body>
	    //</html>
		private static String tests2 = "<html>\n\u0009<body> \n\u0009\u0009<div><div class=\"big\"><div><div class=\"big\" ></div></div></div></div>\n\u0009\u0009texte libre pouvant contenir \"ceci\" ou cela. Lien: \n\u0009\u0009<p id=\"pargraphe1\">un paaragraphe</p>\n\u0009\u0009<a href=\"http://sablecc.org\">SableCC</a>\n\u0009\u0009<a href=\"http://sablecc.org\">SableCC</a>\n\u0009\u0009<div class=\"big\" ><p>embedend p</p></div>\n\u0009</body>\n</html>";
		
	
	
	@Test
	public void test2() throws IOException {
		System.out.println("test2#############");
		Selectors selecs1 = new Selectors();

		//selecs1.push(new TagSelector("li"));
		selecs1.push(new TagSelector("body"));
		selecs1.push(new SeparatorSelector());

		selecs1.push(new TagSelector("div"));
		selecs1.push(new ClassSelector("big"));



		List<Node> candidates = new ArrayList<Node>();


		Selectors sl1 = selecs1.getNextSelector();
		//System.out.println("bp");

		Selectors sl2 = selecs1.getNextSelector();



		try {
			Reader in = new StringReader(tests2);
			//Reader in = new FileReader("test.html");
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
	@Test
	public void test3() throws IOException {
		System.out.println("test3#############");
		Selectors selecs1 = new Selectors();

		//selecs1.push(new TagSelector("li"));
		//selecs1.push(new TagSelector("body"));
		//selecs1.push(new SeparatorSelector());

		selecs1.push(new TagSelector("div"));
		//.push(new ClassSelector("big"));



		List<Node> candidates = new ArrayList<Node>();


		Selectors sl1 = selecs1.getNextSelector();
		//System.out.println("bp");

		Selectors sl2 = selecs1.getNextSelector();



		try {
			Reader in = new StringReader(tests2);
			//Reader in = new FileReader("test.html");
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
