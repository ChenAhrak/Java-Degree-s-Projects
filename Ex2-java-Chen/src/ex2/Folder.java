package ex2;
import java.util.ArrayList;

/**
 * 
 * @author chena
 *
 */
public class Folder {
	

	private final int arraySize=100;
	private String folderName;
	private ArrayList<Document> files;

	/**
	 * 
	 * @param folderName
	 */
	public Folder(String folderName) {
		super();
		this.folderName = folderName;
		files=new ArrayList<Document>();
	}
	

	/**
	 * Function that adds a document to the library (list of the documents)
	 * @param doc
	 */
	public void addDoc(Document doc) {
		if(this.files.size() != arraySize)
			this.files.add(doc);
	}
	
	/**
	 * Function that removes a document to the library (list of the documents)
	 * @param doc
	 */
	public void deleteDoc(Document doc)
	{
		if(this.files.size()!=0 && this.files.contains(doc))
			this.files.remove(this.files.indexOf(doc));
		else
			System.out.println("The library is empty!!");

			
	}
	
	
	/**
	 * Function that prints the details of the documents that in the library (in the list of the documents)
	 */
	public void printAllFiles() {
		for(Document doc:this.files) {
			if(doc.wordsInLine==10)
			System.out.println("File Name: "+ doc.getFileName()+" Type:"+" PlainTextDocument");
			else
				System.out.println("File Name: "+ doc.getFileName()+" Type:"+" WordDocument");
		}
		System.out.println("The library is empty!!");

				
	}
	
	
	/**
	 * Function that prints the content of the document
	 * @param doc
	 */
	public void contentFile(String fileName) {
			for(Document content: this.files)
			{
				if(content.evenFileName(fileName))
				{
					System.out.print(fileName +" Content:\n"  );
					content.printFile();
				}
			}
			
			
		}

	/** overrides toString function
	 * @return info of the object (string)
	 */
	@Override
	public String toString() {
		return "folderName=" + folderName + ", files=" + files + "]";
	}


	
			
			
	
	
}
