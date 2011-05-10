package teckwiz.traxions.faxions;

import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockPlaceEvent;

public class FaxBlockListener extends BlockListener {
	public static Faxions plugin;

	public FaxBlockListener(Faxions instance) {
		plugin = instance;
	}
	@SuppressWarnings("unused")

	public void onBlockDamage(BlockDamageEvent event){
		Block block = event.getBlock();
		Player player = event.getPlayer();
		int bx = block.getX();	
		int by = block.getY();
		int bz = block.getZ();		
		int bid = block.getTypeId();
		
		// islandempire **Empire = True, Barbarian = False!**

		
		//No Faction [DISALLOW]
		boolean isgod = plugin.ifFactionGod(player); 
		if(plugin.ifFactionGod(player) && isgod == false){
			event.setCancelled(false); 	
		} else {
		if(plugin.ifFactionNULL(player) && isgod == false){
			player.sendMessage(ChatColor.RED + "Oops! You need a Faction to do that!");
			event.setCancelled(true); 	
		} else { 
			if(plugin.ifFactionEMPIRE(player) && plugin.islandempire(bz) == false && isgod == false){
				player.sendMessage(ChatColor.RED + "Oops! Thats Barbarian land!");
				event.setCancelled(true);
			} else {
				if(plugin.ifFactionBARBARIAN(player) && plugin.islandempire(bz) && isgod == false) {
					player.sendMessage(ChatColor.RED + "Oops! Thats Empire land!");
					event.setCancelled(true);
				}
			}
			
		}
		}
					
					
			}
			//Break
	
	public void onBlockPlace(BlockPlaceEvent event){
		Block block = event.getBlock();
		Player player = event.getPlayer();
		int bz = block.getZ();	
		boolean isgod = plugin.ifFactionGod(player);  
			if(plugin.ifFactionNULL(player) && isgod == false){
			player.sendMessage(ChatColor.RED + "Oops! You need a Faction to do that!");
			event.setCancelled(true); 	
		} else { 
			if(plugin.ifFactionEMPIRE(player) && plugin.islandempire(bz) == false && isgod == false){
				player.sendMessage(ChatColor.RED + "Oops! Thats Barbarian land!");
				event.setCancelled(true);
			} else {
				if(plugin.ifFactionBARBARIAN(player) && plugin.islandempire(bz) && isgod == false) {
					player.sendMessage(ChatColor.RED + "Oops! Thats Empire land!");
					event.setCancelled(true);
				}
			}
		}
		}
		//break	
	public void onBlockIgnite(BlockIgniteEvent event){
		Block block = event.getBlock();
		Player player = event.getPlayer();
		int bz = block.getZ();		
		
		// islandempire **Empire = True, Barbarian = False!**

		
		//No Faction [DISALLOW]
		boolean isgod = plugin.ifFactionGod(player); 
		if(plugin.ifFactionGod(player)){
			event.setCancelled(false); 	
		} else { 
		if(plugin.ifFactionNULL(player) && isgod == false){
			player.sendMessage(ChatColor.RED + "Oops! You need a Faction to do that!");
			event.setCancelled(true); 	
		} else { 
			if(plugin.ifFactionEMPIRE(player) && plugin.islandempire(bz) == false && isgod == false){
				player.sendMessage(ChatColor.RED + "Oops! Thats Barbarian land!");
				event.setCancelled(true);
			} else {
				if(plugin.ifFactionBARBARIAN(player) && plugin.islandempire(bz) && isgod == false) {
					player.sendMessage(ChatColor.RED + "Oops! Thats Empire land!");
					event.setCancelled(true);
				}

				
			}
		}
		}
					
					
			}
		}
	

