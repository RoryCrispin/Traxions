package teckwiz.traxions.faxions;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import com.nijiko.permissions.PermissionHandler;
import com.nijikokun.bukkit.Permissions.Permissions;
import org.bukkit.plugin.Plugin;
//This class is fucking messy! Enjor reading it :F
public class Faxions extends JavaPlugin {
	private static final Logger log = Logger.getLogger("Minecraft");
	private final FaxBlockListener blockListener = new FaxBlockListener(this);
	private final FaxPlayerListener playerListener = new FaxPlayerListener(this);
   public final HashMap<Player, ArrayList<Block>> tdUsers = new HashMap<Player, ArrayList<Block>>();
   public final HashMap<Player, ArrayList<Block>> FactionEMPIRE = new HashMap<Player, ArrayList<Block>>();
   public final HashMap<Player, ArrayList<Block>> FactionBARBARIAN = new HashMap<Player, ArrayList<Block>>();
   public final HashMap<Player, ArrayList<Block>> FactionNULL = new HashMap<Player, ArrayList<Block>>();
   public final HashMap<Player, ArrayList<Block>> FactionGOD = new HashMap<Player, ArrayList<Block>>();
    	// <permissions>
    public boolean usePermissions;
    public static boolean hashedlogin = false;
	public static PermissionHandler perms;
		//  </permissions>
	public void onEnable() {
        
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvent(Event.Type.BLOCK_BREAK, blockListener,
				Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.BLOCK_DAMAGE, blockListener,
				Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.BLOCK_PLACE, blockListener,
				Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.BLOCK_IGNITE, blockListener,
				Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.PLAYER_JOIN, playerListener,
				Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.PLAYER_QUIT, playerListener,
				Event.Priority.Normal, this);
		log.info("**** -Traxions *OBJECTING* TEST BUILD 1.6 ****");
		//permissions
		Plugin permissions = this.getServer().getPluginManager().getPlugin("Permissions");
		if (permissions == null) {
			log.info("[Traxions] Permissions not found! Defaulting to OP only!");
			usePermissions = false; 
		} else {
			log.info("[Traxions] Permissions detected!");
			usePermissions = true;
			perms = ((Permissions)permissions).getHandler();
		}
		
	}

	public void onDisable() {
		log.info("Traxions DISABLED");
	}
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		if(commandLabel.equalsIgnoreCase("Trax")){
			toggleTD((Player) sender);
			return true;
		}
		return false;
	}
	public void toggleTD(Player player){
		if(enabled(player)){
			this.tdUsers.remove(player);
			player.sendMessage("Turrit Disabled");
		}else{
			this.tdUsers.put(player, null);
			player.sendMessage("Turrit Enabled");
		}
	}
	public boolean ifFactionGod(Player player){
		return this.FactionGOD.containsKey(player);
	}
	public boolean enabled(Player player){
		return this.tdUsers.containsKey(player);
	}
	public boolean ifFactionNULL(Player player){
		return this.FactionNULL.containsKey(player);
	}
	public boolean ifFactionEMPIRE(Player player){
		return this.FactionEMPIRE.containsKey(player);
	}
	public boolean ifFactionBARBARIAN(Player player){
		return this.FactionBARBARIAN.containsKey(player);
	}

	// **Empire = True, Barbarian = False!**
	public boolean islandempire(int bz) {
		if(bz > -840) {
			return true;
		} else {
			return false;
		} }
	// **Empire = True, Barbarian = False!**
	
	 //FACTION HASHMAP ASSIGN <LOGIN>
	public void loginhash(Player player){
		String playername = player.getName();
		hashedlogin = true;
		if(player.isOp()) {
			boolean playerop = true;
		}
		if (Faxions.perms.has((player), "traxions.faxions.god")){
			this.FactionGOD.put(player, null);
			log.info(playername + "Added to hashmap [FactionGOD]");
			player.sendMessage("Added to Empire Hashmap!");
			 player.sendMessage(ChatColor.GREEN +"Welcome, Overlord! " + ChatColor.RED + "[GOD]");		
			} else {
				if (player.isOp()){
					this.FactionGOD.put(player, null);
					log.info(playername + "Added to hashmap [FactionGOD]");
					player.sendMessage("Added to Empire Hashmap!");
					 player.sendMessage(ChatColor.GREEN +"Welcome, Overlord! " + ChatColor.RED + "[GOD]");
				} else {
			if (Faxions.perms.has((player), "traxions.faxions.null")){
				this.FactionNULL.put(player, null);
				log.info(playername + " Loaded into hashmap [FactionNULL]");
				player.sendMessage(ChatColor.BLUE +"You are not in a faction, type /faction for more info!");
												log.info("FactionNULL Contents:" + FactionNULL);
			} else {
				if (Faxions.perms.has((player), "traxions.faxions.empire")){
					this.FactionEMPIRE.put(player, null);
					log.info(playername + "Added to hashmap [FactionEMPIRE]");
					player.sendMessage("Added to Empire Hashmap!");
					 player.sendMessage(ChatColor.GREEN +"Welcome, Crafter! " + ChatColor.BLUE + "[EMPIRE]");
					
			} else {
					if (Faxions.perms.has((player), "traxions.faxions.barb")){
					this.FactionBARBARIAN.put(player, null);
					log.info(playername + "Added to hashmap [FactionBARBARIAN]");
					player.sendMessage("Added to Empire Hashmap!");
					 player.sendMessage(ChatColor.GREEN +"Welcome, Soldier! " + ChatColor.RED + "[BARBARIAN]"); 
					}	
			} } } } }
			
	// </LOGIN>
	// <LOGOUT>
	public void logouthash(Player player){
		String playernamel = player.getName();
		if (Faxions.perms.has((player), "traxions.faxions.god")){
			this.FactionGOD.remove(player);
			log.info(playernamel + " Was removed from hashmap [FactionGOD]");
		} else {
			if (player.isOp()){
				this.FactionGOD.remove(player);
				log.info(playernamel + " Was removed from hashmap [FactionGOD]");
			} else {
			if (Faxions.perms.has((player), "traxions.faxions.null")){
				this.FactionNULL.remove(player);
				log.info(playernamel + " Was removed from hashmap [FactionNULL]");
			} else {
				if (Faxions.perms.has((player), "traxions.faxions.empire")){
					this.FactionEMPIRE.remove(player);
					log.info(playernamel + " Was removed from Hashmap [FactionEMPIRE]");
			} else {
				if (Faxions.perms.has((player), "traxions.faxions.barb")){
					this.FactionBARBARIAN.remove(player);
					log.info(playernamel + " Was removed from hashmap [FactionBARBARIAN]");
			} else {	
			}} }} }}  
	// </LOGOUT>

}

