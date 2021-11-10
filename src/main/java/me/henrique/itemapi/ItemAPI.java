package me.henrique.itemapi;

import me.henrique.itemapi.itembuilder.ItemBuilder;
import me.henrique.itemapi.skullbuilder.SkullBuilder;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class ItemAPI extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("item").setExecutor(this);
    }

    /*
    * Demonstração do ItemBuilder
    * E SkullBuilder
     */
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(args.length == 0){
                //GIVANDO UMA CABEÇA PERSONALIZADA
                ItemStack skull = new SkullBuilder("http://textures.minecraft.net/texture/e2b35bda5ebdf135f4e71ce49726fbec5739f0adedf01c519e2aea7f51951ea2", true).setDisplayName("&aCabeça Personalizada").setLore("§aLore 1", "§bLore 2.").toItemStack();
                player.getInventory().setItem(1, skull);
                //GIVANDO UM ITEM UTILIZANDO A CLASS ItemBuilder
                ItemStack itemBuilder = new ItemBuilder(Material.DIAMOND_SWORD).setDisplayName("§aEspada Legal").setLore("§aLore 1.", "§bLore 2.").addEnchant(Enchantment.DAMAGE_ALL, 2).setUnbreaking(true).toItemStack();
                player.getInventory().setItem(2, itemBuilder);
                player.sendMessage("§aItem givado com sucesso.");
                return true;
            }
        }
        return false;
    }
}
