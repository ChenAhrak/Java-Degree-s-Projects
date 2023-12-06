package ex2;

/**
 * 
 * @author chena
 *
 */
public class WordDocument extends Document {

	/**
	 * Counstructor that inherits from Document abstract class, receives two arguments and creates a WordDocument type object
	 */
	private final int wordWords=8;
	public WordDocument(String fileName, String text) {
		super(fileName, text);
		// TODO Auto-generated constructor stub
		wordsInLine=wordWords;
	}

	/**
	 * Function that prints the document text according to the required format
	 */
	public void printFile() {
		
		String [] lines=getText().split("[, ?.@]+");
		for(int i=1;i<lines.length+1;i++) {
			if(i%8 == 1) {
				System.out.print("*"+lines[i-1]+ " " );
			}
			else
			{
				if(i%8 == 0)
					System.out.println(lines[i-1] + "*");
				else
					System.out.print(lines[i-1] + " ");
			}
		}
		if(lines.length % 8!= 0)
			System.out.print("*");
	}	

	/** overrides toString function
	 * @return info of the object (string)
	 */
	@Override
	public String toString() {
		return "Type: PlainTextDocument " + super.toString();
	}
	

}
