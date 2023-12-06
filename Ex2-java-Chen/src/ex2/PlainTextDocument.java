package ex2;
/**
 * 
 * @author chena
 *
 */
public class PlainTextDocument extends Document {
	
	private final int plainTextWords=10;

	/**
	 * Counstructor that inherits from Document, receives two arguments and creates a PlainTextDocument type object
	 * @param fileName
	 * @param text
	 */
	public PlainTextDocument(String fileName, String text) {
		super(fileName, text);
		// TODO Auto-generated constructor stub
		wordsInLine=plainTextWords;
	}

	/**
	 * Function that prints the document text according to the required format
	 */
	public void printFile() {
		
		String [] lines=getText().split("[, ?.@]+");
		for(int i=1;i<lines.length+1;i++) {
			if(i%10 == 0)
				System.out.println(lines[i-1] + " ");
			else
				System.out.print(lines[i-1] + " ");
		}
	}
	
	/** overrides toString function
	 * @return info of the object (string)
	 */
	@Override
	public String toString() {
		return "Type: PlainTextDocument "+ super.toString();
	}
		
		
	}

