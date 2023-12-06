package ex2;
/**
 * 
 * @author chena
 *
 */
public class MainClass {
	
	public static void main(String[] args) {
		
		
		
		Folder java_course=new Folder("java_course");
		PlainTextDocument encapsulation=new PlainTextDocument("encapsulation","Are you someone who loves finding and discovering new words? Are you a board game enthusiast? If you are, then this Word Finder is a tool you can't afford not");
		WordDocument inheritance=new WordDocument("inheritance","to have. Whether you are into playing Scrabble, Words with Friends or any other word game, Word Finder will prove to be useful It ");
		PlainTextDocument polymorphism=new PlainTextDocument("polymorphism","men man i tree chen the who to cat too dog there three");
		WordDocument interFace=new WordDocument("interFace","chen dog cat i tree the who to too them there");
		
		
		java_course.addDoc(encapsulation);
		java_course.addDoc(inheritance);
		java_course.addDoc(polymorphism);
		java_course.addDoc(interFace);
				
		System.out.println("-----------------------Files-----------------");
		java_course.printAllFiles();

		System.out.println("-----------------------Content-----------------");

		java_course.contentFile("encapsulation");
		System.out.println("\n");
		java_course.contentFile("inheritance");
		System.out.println("\n");

		java_course.contentFile("polymorphism");
		System.out.println("\n");

		java_course.contentFile("interFace");
		System.out.println("\n");

		java_course.deleteDoc(encapsulation);
		java_course.deleteDoc(inheritance);
		java_course.deleteDoc(polymorphism);
		java_course.deleteDoc(interFace);
		
		System.out.println("-----------------------Files-----------------");
		java_course.printAllFiles();
		java_course.deleteDoc(encapsulation);


	}

}
