package me.henrique.itemapi.itembuilder;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

/**
 * @Author: DaddyHenrique
 * @Repository: https://github.com/uDaddyHenrique/ItemAPI
 */

/*
* Como usar?
* para criar um item basta utilizar
* ItemStack item = new ItemBuilder(Material.DIAMOND_SWORD).toItemStack(); OBS: O Material pode ser qualquer um, para ver os disponíveis acesse https://hub.spigotmc.org/javadocs/bukkit/org/bukkit/Material.html
* como posso adicionar um nome ao item?
* ItemStack item = new ItemBuilder(Material.DIAMOND_SWORD).setDisplayName("§aNome do item").toItemStack();
* como posso adicionar uma lore ao item?
* ItemStack item = new ItemBuilder(Material.DIAMOND_SWORD).setLore("§aLore 1", "§bLore 2").toItemStack();
* como posso adicionar um encantamento ao item?
* ItemStack item = new ItemBuilder(Material.DIAMOND_SWORD).addEnchant(Enchantment.DAMAGE_ALL, 2).toItemStack(); Obs: LEMBRANDO QUE PODE UTILIZAR QUALQUER ENCANTAMENTO BASTA VER OS DISPONÍVEIS EM https://helpch.at/docs/1.8.8/index.html?org/bukkit/enchantments/Enchantment.html
* como posso deixar o item inquebravél?
* ItemStack item = new ItemBuilder(Material.DIAMOND_SWORD).setUnbreaking(true).toItemStack();
 */

public class ItemBuilder {

    private static ItemStack itemStack;

    public ItemBuilder(Material material){
        itemStack = new ItemStack(material);
    }

    public ItemBuilder(ItemStack item){
        itemStack = new ItemStack(item);
    }

    public ItemBuilder(Material material, int amount, short data){
        itemStack = new ItemStack(material, amount, data);
    }

    public ItemBuilder setDisplayName(String name){
        ItemMeta meta = itemStack.getItemMeta();
        meta.setDisplayName(name);
        itemStack.setItemMeta(meta);
        return this;
    }

    public ItemBuilder setLore(String... lore){
        ItemMeta meta = itemStack.getItemMeta();
        meta.setLore(Arrays.asList(lore));
        itemStack.setItemMeta(meta);
        return this;
    }

    public ItemBuilder addEnchant(Enchantment enchant, int level){
        ItemMeta meta = itemStack.getItemMeta();
        meta.addEnchant(enchant, level, true);
        itemStack.setItemMeta(meta);
        return this;
    }

    public ItemBuilder setUnbreaking(boolean unbreaking){
        ItemMeta meta = itemStack.getItemMeta();
        meta.spigot().setUnbreakable(unbreaking);
        itemStack.setItemMeta(meta);
        return this;
    }

    public ItemStack toItemStack(){
        ItemMeta meta = itemStack.getItemMeta();
        itemStack.setItemMeta(meta);
        return itemStack;
    }
}
