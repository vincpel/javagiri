# javagiri
Cette librairie implémente une API coulante pour manipuler un DOM HTML dans le style je jQuery et nokogiri. Elle utilise [SableCC](http://www.sablecc.org) pour générer les outils qui travail sur le document HTML.

## Détails d'implémentation
La classe Interpreter.java implémente le DepthFirstAdapter. Elle traverse la structure générée Tag par Tag munis d'une pile qui contient les attributs css à comparer. En cours de visite, Lors-ce-qu'il voit que les attributs ne concorde pas le visiteur réinitialisera sa pile d'attribut avant de lancer la visite des nœuds enfants.Cela pour trouver les éventuelles enfants du nœud courant qui serait candidat.


## Voici un cas d'utilisation 
avec le document Html suivant:
``` html
<html>
  <body> 
    <div><div class="big"><div><div class="big" ></div></div></div></div>
    texte libre pouvant contenir "ceci" ou cela. Lien: 
    <p id="pargraphe1">un paaragraphe</p>
    <a href="http://sablecc.org">SableCC</a>
    <a href="http://sablecc.org">SableCC</a>
    <div class="big" ><p>embedend p</p></div>
  </body>
</html>
```

on peut executer ce type comportement:
```Java
public class Examples {
	
	private static String tests2 = "<html>\n\u0009<body> \n\u0009\u0009<div><div class=\"big\"><div><div class=\"small\" ></div></div></div></div>\n\u0009\u0009texte libre pouvant contenir \"ceci\" ou cela. Lien: \n\u0009\u0009<p id=\"pargraphe1\">un paaragraphe</p>\n\u0009\u0009<a href=\"http://sablecc.org\">SableCC</a>\n\u0009\u0009\n\u0009\u0009<a href=\"http://sablecc.org\">SableCC</a>\n\u0009\u0009<div class=\"small\" ><p>embedend p</p></div>\n\u0009\u0009\n\u0009</body>\n</html>";
	
	public static void main(String[] args) throws IOException, JavaGiriException {

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


## Cela produira le rendu suivant:
```
=============================================================
example1
< div class= "small" > </ div > 

=============================================================
example2
< div class= "small" > </ div > 
< div class= "small" > < p > embedend p </ p > </ div > 

=============================================================
example3
< div > < div class= "big" > < div > < div class= "small" > </ div > </ div > </ div > </ div > 


		texte libre pouvant contenir "ceci" ou cela. Lien: 
		 

< p id= "pargraphe1" > un paaragraphe </ p > 

=============================================================
example4
< div class= "small" > </ div > 
```
