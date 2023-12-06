package ex2;

/**
 * 
 * @author chena
 *
 */
abstract class Document {
	
	protected int wordsInLine;
	private String fileName;
	private String text;

	/**
	 * 
	 * @param fileName
	 * @param text
	 */
	public Document(String fileName, String text) {	
		super();
		this.fileName = fileName;
		this.text = text;
	}

	/**
	 * 
	 * @return
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * 
	 * @param fileName
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	

/**
 * 
 * @return
 */
	public String getText() {
		return text;
	}

	/**
	 * 
	 * @param text
	 */
	public void setText(String text) {
	this.text = text;
}

	public void addTextToEnd(String s) {

		this.text +=" "+ s;
	}
	
	/**
	 * 
	 */
	public void deleteText() {
		
		this.text = "" ;
	}
	
	
	/**
	 * 
	 * @param fileName
	 * @return
	 */
	public boolean evenFileName(String fileName) {
		
		if(this.fileName==fileName)
			return true;
		return false;
		
	}

	/**
	 * Document equals function, returns true or false based on comparsion of 2 document names.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Document other = (Document) obj;
		if(this.fileName ==other.getFileName())
			return true;
		return false;
	}

@Override
public String toString() {
	return "FileName=" + fileName + ", WordsInLine=" + wordsInLine + ", Text=" + text + "]";
}
	
/**
 * 
 */

public abstract void printFile();
	
	
}

