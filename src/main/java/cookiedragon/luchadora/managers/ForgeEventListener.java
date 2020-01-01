package cookiedragon.luchadora.managers;

import cookiedragon.luchadora.guis.CustomGuiGameOver;
import net.minecraft.client.gui.GuiGameOver;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * @author cookiedragon234 22/Dec/2019
 */
public class ForgeEventListener
{
	public static void init()
	{
		MinecraftForge.EVENT_BUS.register(ForgeEventListener.class);
	}
	
	public static String lastChat = null;
	
	@SubscribeEvent
	public static void onChat(ClientChatReceivedEvent event)
	{
		lastChat = event.getMessage().getUnformattedText();
	}
	
	@SubscribeEvent
	public static void onGuiOpened(GuiOpenEvent event)
	{
		if(event.getGui() instanceof GuiGameOver)
		{
			event.setGui(new CustomGuiGameOver((GuiGameOver) event.getGui()));
		}
	}
}