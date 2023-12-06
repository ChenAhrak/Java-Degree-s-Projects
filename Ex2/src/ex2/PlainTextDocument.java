package ex2;
/**
 * 
 * @author chena
 *
 */
public class PlainTextDocument extends Document {
	
	private final int plainTextWords=10;

/**
 */
	
	public PlainTextDocument(String fileName, String text) {
		super(fileName, text);
		// TODO Auto-generated constructor stub
		wordsInLine=plainTextWords;
	}

	/**
	 * 
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
	
	/**
	 * 
	 */
	@Override
	public String toString() {
		return "Type: PlainTextDocument "+ super.toString();
	}
		
		
	}

