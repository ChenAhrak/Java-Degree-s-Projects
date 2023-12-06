package Model;
/**
 * @author Moayad
 */
public interface IServer{

    /**
     * Register the Client to this server
     * @param client
     * @return 
     */
    boolean register(IClient client);

    /**
     * 
     * @return true if there are connected for clients , false otherwise
     */
    boolean isOnline();

    /**
     * this method un-registers the client
     * @return true if the un-registers successfully,false otherwise.
     */
    boolean disconnectClient(IClient client);
    
}
