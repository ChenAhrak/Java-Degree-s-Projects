package Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Model.Client;
import Model.IClient;
import Model.IServer;
import Model.Message;
import Model.Server;
import utils.Constants;
import utils.E_MessageStatus;
/**
 * This Communication object ~ represents the class system
 * 
 * @author Moayad
 */
public class Communication {

	// -------------------------------Class Members------------------------------
	//<IP,Client>
	private Map<String, IClient> clients;
	//<IP, <PORT,SERVER>
	//dns.get("10.0.0.4").get(50) -> Server at port 10.0.0.4:50
	private Map<String,Map<Integer,IServer>> dns;
	
	private Map<Integer, Message> messages;

	// -------------------------------Constructor------------------------------
	public Communication() {
		//TODO
	}
	// -----------------------------------------Getters--------------------------------------

	public Map<String, IClient> getClients() {
		return clients;
	}
	
	public Map<String, Map<Integer, IServer>> getDns() {
		return dns;
	}
	public Map<Integer, Message> getMessages() {
		return messages;
	}
	

	
	// -------------------------------Add && Remove Methods------------------------------
	/**
	 * this method adds new IP to map DNS,
	 * only if all the parameters are valid and the ip doesn't already exist. 
	 * @param ip
	 * @return return true if added successfully . false otherwise.
	 */
	public boolean addIP(String ip) {
		//TODO
	}
	/**
	 * this method adds new server to IP, 
	 * only if all the parameters are valid and IP exist in map DNS and the server doesn't already exist in IP.
	 * @param ip
	 * @param port
	 * @return return true if added successfully . false otherwise.
	 */
	public boolean addServerToIP(String ip,int port) {
		//TODO
	}
	/**
	 * this method adds new client, if is not already exist.
	 * only if all the parameters are valid and the client doesn't already exist.
	 * @param ip
	 * @return return true if added successfully . false otherwise.
	 */
	public boolean addClient(String ip) {
		//TODO
	}

	/**
	 * this method connect client to server, 
	 * only if all the parameters are valid and the client already exist in the system
	 * use suggestServer function to get relevant server.
	 * @param ipClient
	 * @return return IServer if connected successfully . false otherwise.
	 */
	
	public IServer connectClientToServer(String ipClient) {
		//TODO
	}
	
		
	/**
	 * This method finds and returns the server with minimum clients connected with it,
	 * if there are more than one server the method returns the first server. 
	 * @return return IServer if found, null otherwise 
	 */
	private IServer suggestServer() {
		//TODO
	}
	
	/**
	 * This method adds a new message sender by client (to server) to the system,
	 * only if all the parameters are valid, the message doesn't already exist and 
	 * both client & server already exist in the system.
	 * message must be added to all the relevant arrays.
	 * 				
	 * @param number
	 * @param clientIp
	 * @param serverIP
	 * @param serverPort
	 * @param data
	 * @return true if the message was added successfully,false otherwise
	 */
	
	public <T> boolean sendMessageByClient(int number,String clientIp,String serverIP,int serverPort,T data) {
		//TODO
	}
	
	/**
	 * This method adds a new reply message sender by server (to client) to the system,
	 * only if :
	 * 			all the parameters are valid, 
	 * 			the message doesn't already exist,
	 * 			the message number respondForNumMessage is already exist, 
	 * 			both client & server already exist in the system.
	 *          The request message for this message is already exist in the system,
	 *          and sent to client who sent request message
	 * ** Do not forget to update the status of the message according to the instructions in the document and
	 * 					message must be added to all the relevant arrays.
	 * 
	 * After successfully adding a response message from the server to the client, 
	 * the connection should be disconnected by using the method disconnectAConnectionClientToServer().
	 * 
	 * @param number
	 * @param serverIP
	 * @param serverPort
	 * @param clientIp
	 * @param respondForNumMessage
	 * @param data
	 * @return true if the message was added successfully,false otherwise
	 */
	public <T> boolean sendMessageByServer(int number,String serverIP,int serverPort,String clientIp,int respondForNumMessage,T data) {
		//TODO
	}
	/**
	 * Disconnect a connection between the client and the server
	 * @param serverIP
	 * @param serverPort
	 * @param clientIp
	 */
	private void disconnectAConnectionClientToServer(String serverIP,int serverPort,String clientIp) {
		//TODO
	
	}
	
	// -------------------------------Queries------------------------------
	
	/**
	 * This query returns an array list of a messages that gets from server with status FAILURE  
	 * @return team array if found, null otherwise
	 */
	public ArrayList<Message> getAllFailureMessageFromServer() {
		//TODO
	}
	
	/**
	 * This query returns an array list of a servers that is Online.  
	 * @return servers array if found, null otherwise
	 */
	public ArrayList<IServer> getAllOnlineServer() {
		//TODO
	}
	
}
