package teckwiz.traxions.faxions;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerQuitEvent;

public class FaxPlayerListener extends PlayerListener {
	public static Faxions plugin;

	public FaxPlayerListener(Faxions instance) {
		plugin = instance;
	}
	
	
	public void onPlayerJoin(PlayerJoinEvent event){
		Player player = event.getPlayer();	
		Faxions loginevent = new Faxions();
		loginevent.loginhash(player); 
	} 
	public void onPlayerQuit(PlayerQuitEvent event){
		Player player = event.getPlayer();	
		Faxions loginevent = new Faxions();
		loginevent.logouthash(player); 
	} 
	
	}



		


		
	 
		
		  



