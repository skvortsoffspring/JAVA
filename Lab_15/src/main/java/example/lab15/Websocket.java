package example.lab15;

import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@ServerEndpoint("/websocket")
public class Websocket  {

    @OnOpen
    public void onOpen(Session session)
    {
        try
        {
            while (true)
            {
                String message = new SimpleDateFormat("HH:mm:ss").format(new Date());
                session.getBasicRemote().sendText(message);
                Thread.sleep(1000);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}