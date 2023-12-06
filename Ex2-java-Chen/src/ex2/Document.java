package ex2;

/**
 * Abstract class that represents a Document file.
 * @author chena
 *
 */
abstract class Document {
	
	protected int wordsInLine;
	private String fileName;
	private String text;

	/**
	 * Counstructor that builds a Document type object
	 * @param fileName
	 * @param text
	 */
	protected Document(String fileName, String text) {	
		super();
		this.fileName = fileName;
		this.text = text;
	}

	/**
	 * getter of file name
	 * @return the file name
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * set the file name
	 * @param fileName
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	

/**
 * getter of text
 * @return the text that in the document
 */
	public String getText() {
		return text;
	}

	/**
	 * setter of text
	 * @param text
	 */
	public void setText(String text) {
	this.text = text;
}

	/**
	 * Function that adds text to the one that already exists in the Document
	 * @param s
	 */
	public void addTextToEnd(String s) {

		this.text +=" "+ s;
	}
	
	/**
	 * Function that deletes the text from the Document object.
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

	/** overrides toString function
	 * @return info of the object (string)
	 */
	@Override
	public String toString() {
		return "FileName=" + fileName + ", WordsInLine=" + wordsInLine + ", Text=" + text + "]";
	}
		
	/**
	 * Abstract Function that must be inherited and used differently in the inheriting class due to the difference between printing formats
	 */
	public abstract void printFile();
	
	
}

