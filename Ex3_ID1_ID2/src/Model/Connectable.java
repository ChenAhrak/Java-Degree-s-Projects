package Model;
/**
 * @author Moayad
 */
public interface Connectable {

	/**
	 * Add a message sent from a client or server to the relevant array 
	 * Please verify if the client and server are connected
	 * @param message
	 * @return return true if added successfully, false otherwise
	 */
    boolean messageSent(Message message);
	/**
	 * Add a message received from client or server to the relevant array
	 * Please verify if the client and server are connected
	 * @param message
	 * @return return true if added successfully, false otherwise
	 */
    boolean onMessageReceived(Message message);
}
