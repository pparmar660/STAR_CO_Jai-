package starco.tech.com.starcase.Interfaces;

/**
 * Created by Noah on 5/19/2016.
 */
public interface CommunicationInterface
{
    public void close();

    public boolean isConnected();

    public void sendString(String s, byte code);

}
