package core;



public class JavaGiriException extends Exception {
public JavaGiriException(String emessage) {
		super();
		this.emessage = emessage;
	}

private String emessage;

public String getEmessage() {
	return emessage;
}

public void setEmessage(String emessage) {
	this.emessage = emessage;
}

}
