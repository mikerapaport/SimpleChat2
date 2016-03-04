package common;

import java.io.IOException;

import server.EchoServer1;

public class ServerChannelHandler extends ServerMessageHandler{

	private String channelName;
	
	public ServerChannelHandler(String str) {
		channelName = str;
	}
	
	@Override
	public void handleMessage() {
		EchoServer1 server = getServer();
		server.createChannel(channelName);
		try {
			getClient().sendToClient("You have created channel " + channelName);
		} catch (IOException e) {}
		server.serverUI().display("Channel " + channelName + " created");
	}
}