package Controller;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

import Model.IServer;
import Model.Message;
import Model.Server;
import utils.MyFileLogWriter;

/**

 * @author Moayad
 */
public class MainClass {
	
	/**
	 * The main object for the program
	 */
	private static Communication comm;
	
	/**
	 * Scanner for input
	 */
	private static Scanner input;
	
	/**
	 * The command read from the input file
	 */
	private static String command;



	static Map<String,FileAppender> fileWriters = new HashMap<>();
	static Map<String,Command> commands = new HashMap<>();

	static {
		// ADD IP
		commands.put("addIP",(writer,args)->{
			String ip = args[0];
			boolean isUpdated = comm.addIP(ip);
			if (isUpdated) {
				// if adding successfully, then true returned,
				// the following message is written to the output file
				writer.write("Successfully added IP: " + ip );
			} else {
				writer.write("Failed to add new IP");
			}
		});

		//ADD SERVER TO IP
		commands.put("addServerToIP",(writer,args)->{
			String ip = args[0];
			int port = Integer.parseInt(args[1]);

			boolean isUpdated = comm.addServerToIP(ip, port);
			if (isUpdated) { // if adding successfully, then true returned,
				// the following message is written to the output file
				writer.write("Successfully added server: IP:" + ip + " | Port:" + port);
			} else {
				writer.write("Failed to add new server");
			}
		});

		//ADD CLIENT
		commands.put("addClient",(writer,args)->{
			String ip = args[0];

			boolean isUpdated = comm.addClient(ip);
			if (isUpdated) { // if adding successfully, then true returned,
				// the following message is written to the output file
				writer.write("Successfully added client: " + ip );
			} else {
				writer.write("Failed to add new client");
			}
		});

		//CONNECT CLIENT TO SERVER
		commands.put("connectClientToServer",(writer,args)->{
			String ipClient = args[0];

			IServer suggestServer = comm.connectClientToServer(ipClient);

			if (suggestServer!= null) { // if connect successfully, then true returned,
				// the following message is written to the output file
				writer.write("Successfully added client: " + ipClient +" to server: IP: "
						+((Server)suggestServer).getIP()+" Port: "+((Server)suggestServer).getPort() );
			} else {
				writer.write("Failed to add client to suggested server");
			}
		});

		//SEND MESSAGE
		commands.put("sendMessageByClient",(writer,args)->{
			int numMessage = Integer.parseInt(args[0]);
			String ipClient = args[1];
			String ipServer = args[2];
			int portServer = Integer.parseInt(args[3]);

			boolean isUpdated;
			try {
				isUpdated = comm.sendMessageByClient(numMessage,ipClient, ipServer, portServer,Integer.parseInt(args[4]));
			} catch (NumberFormatException e){
				isUpdated = comm.sendMessageByClient(numMessage,ipClient, ipServer, portServer,args[4]);
			}

			if (isUpdated) { // if adding successfully, then true returned,
				// the following message is written to the output file
				writer.write("Send message for " +ipServer+":"+portServer+" from client "+ipClient +" successfully.");
			} else {
				writer.write("Failed to send message");
			}
		});

		commands.put("sendMessageByServer",(writer,args)->{
			// create and add new message to Java
			int numMessage = Integer.parseInt(args[0]);
			String ipServer = args[1];
			int portServer = Integer.parseInt(args[2]);
			String ipClient = args[3];
			int respondNumMessage = Integer.parseInt(args[4]);

			boolean isUpdated;
			try {
				isUpdated = comm.sendMessageByServer(numMessage, ipServer, portServer, ipClient, respondNumMessage, Integer.parseInt(args[5]));
			} catch (NumberFormatException e){
				isUpdated = comm.sendMessageByServer(numMessage, ipServer, portServer, ipClient, respondNumMessage, args[5]);
			}

			if (isUpdated) { // if adding successfully, then true returned,
				// the following message is written to the output file
				writer.write("Send message for client "+ipClient +" from server "+ ipServer+":"+portServer +" successfully.");
			} else {
				writer.write("Failed to send message");
			}
		});

		commands.put("getAllFailureMessageFromServer",(writer,args)->{
			// create and add new message to Java
			writer.write("getAllFailureMessageFromServer returns:");
			ArrayList<Message<?, ?, ?>> allFAILUREMessage = comm.getAllFailureMessageFromServer();
			if (allFAILUREMessage != null) {
				int i = 1;
				for (Message<?,?,?> m : allFAILUREMessage)
					if (m != null)
						writer.write((i++) + "\t" + m);
			} else
				writer.write("No \"Message Failure\" ");
		});

		commands.put("getAllOnlineServer",(writer,args)->{
			// create and add new message to Java
			writer.write("getAllOnlineServer returns:");
			ArrayList<IServer> allOnlineServer = comm.getAllOnlineServer();
			if (allOnlineServer != null) {
				int i = 1;
				for (IServer s : allOnlineServer)
					if (s != null)
						writer.write((i++) + "\t" + s);
			} else
				writer.write("No \"Message Failure\" ");
		});
	}

	static void func(String command,String[] args){
		Command c = commands.get(command);
		if (c != null){
			FileAppender appender = fileWriters.get(command);
			if (appender == null) {
				appender = new FileAppender();
				fileWriters.put(command,appender);
			}
			c.execute(appender,args);
		}
	}
	
    public static void main(String[] args)  throws IOException, ParseException, ClassNotFoundException {
    	// Create Scanner for the text file named "input.txt"
		input = new Scanner(new File("input.txt"));
		// Writer buffer creation used after update
		MyFileLogWriter.initializeMyFileWriter();
		// if the file has next - not empty
		if (input.hasNext()) {
			comm = new Communication();
		}
    	
		/*
		 * read the commands. loop while input file [input.hasnext()] and the
		 * SysData is not null
		 */
		while (input.hasNext() && comm != null) {
			/*
			 * read the command, must be first at line because command value
			 * determine which method will be activated in SysData object.
			 */
			String line = input.nextLine().trim().replaceAll("[ ]{2,}", " ");
			String[] values = line.split(" ");
			command = values[0];
			String[] params = Arrays.copyOfRange(values,1,values.length);
			func(command,params);

		} // ~ end of clause - while input has next

		List<FileAppender> list = new ArrayList<>(fileWriters.values());
		list.sort(Comparator.comparingInt(o -> o.id));

		for (FileAppender f : list){
			if (f.isUsed) {
				MyFileLogWriter.writeToFileInSeparateLine("@BEGIN::COMMAND_" + f.id);
				f.flush();
				MyFileLogWriter.writeToFileInSeparateLine("@END::COMMAND_" + f.id);
			}
		}

		MyFileLogWriter.saveLogFile(); // save the output file
		input.close(); // close connection to input file
		System.out.println("[End Of process]");
		System.out.println("\n NOTICE:\n\t\"End of process\" " + "does NOT mean that all your methods are correct.\n"+ "\n==>\t You NEED to check the \"output.txt\" file");
    }


	/**
	 * UTIL CLASS
	 */
	private static class FileAppender{

		private static int arc = 0;
		final int id = ++arc;
		private boolean isUsed = false;

		private StringBuilder builder = new StringBuilder();

		void write(String str){
			builder.append(str).append("\n");
			isUsed = true;
		}

		void flush(){
			MyFileLogWriter.writeToFile(builder.toString());
		}
	}

	/**
	 * UTIL INTERFACE
	 */

	@FunctionalInterface
	interface Command {
		void execute(FileAppender appender,String... args);
	}
}