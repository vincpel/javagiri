# javagiri



this library attemps to emulate some of the features of the popular ruby libray nokogiri. Its uses [SableCC](http://www.sablecc.org) to genenerate the tools needed to cross down and parse the Html document.


## Her are some  Use Cases.

```Java
public class Examples {
	
	//<html>
	//  <body> 
	//	  <div><div class="big"><div><div class="big" ></div></div></div></div>
	//	  texte libre pouvant contenir "ceci" ou cela. Lien: 
	//	  <p id="pargraphe1">un paaragraphe</p>
	//	  <a href="http://sablecc.org">SableCC</a>
	//	  <a href="http://sablecc.org">SableCC</a>
	//	  <div class="big" ><p>embedend p</p></div>
	//  </body>
	//</html>
	private static String tests2 = "<html>\n\u0009<body> \n\u0009\u0009<div><div class=\"big\"><div><div class=\"small\" ></div></div></div></div>\n\u0009\u0009texte libre pouvant contenir \"ceci\" ou cela. Lien: \n\u0009\u0009<p id=\"pargraphe1\">un paaragraphe</p>\n\u0009\u0009<a href=\"http://sablecc.org\">SableCC</a>\n\u0009\u0009\n\u0009\u0009<a href=\"http://sablecc.org\">SableCC</a>\n\u0009\u0009<div class=\"small\" ><p>embedend p</p></div>\n\u0009\u0009\n\u0009</body>\n</html>";
	
	
	public static void main(String[] args) throws IOException, JavaGiriException {
		// TODO Auto-generated method stub

		System.out.println("=============================================================");
		System.out.println("example1");
		Javagiri jg = Javagiri.parse(tests2);
		jg.css("div.big").css("div.small");
		System.out.println(jg.toString());

		System.out.println("=============================================================");
		System.out.println("example2");
		jg = Javagiri.parse(tests2);
		jg.css("div.small");
		System.out.println(jg.toString());

		System.out.println("=============================================================");
		System.out.println("example3");
		jg = Javagiri.parse(tests2);
		jg.css("body");
		System.out.println(jg.getChildren(1));
		System.out.println(jg.getChildren(2));
		System.out.println(jg.getChildren(3));
		
		System.out.println("=============================================================");
		System.out.println("example4");
		jg = Javagiri.parse(tests2);
		jg.css("body");
		System.out.println(jg.getChildren(1).css(".small"));

	}
}
```


##this will produce the following output

```
=============================================================
example1
bp
< div class= "small" > </ div > 

=============================================================
example2
bp
< div class= "small" > </ div > 
< div class= "small" > < p > embedend p </ p > </ div > 

=============================================================
example3
bp
< div > < div class= "big" > < div > < div class= "small" > </ div > </ div > </ div > </ div > 


		texte libre pouvant contenir "ceci" ou cela. Lien: 
		 

< p id= "pargraphe1" > un paaragraphe </ p > 

=============================================================
example4
bp
< div class= "small" > </ div > 
```


