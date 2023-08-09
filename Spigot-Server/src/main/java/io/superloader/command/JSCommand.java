package io.superloader.command;

import io.superloader.plugin.js.JSPlugin;
import io.superloader.plugin.js.JSPluginManager;
import io.superloader.plugin.lua.LuaPlugin;
import io.superloader.plugin.lua.LuaPluginManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class JSCommand extends Command {
    public JSCommand(String name) {
        super(name);
        this.description = "JS script plugin manage command.";
        this.usageMessage = "/js [load|disable|list]";
        this.setPermission( "superloader.command.js" );
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        try {
            if (!testPermission(sender)) return true;
            if (args.length == 0) {
                sender.sendMessage("Scripts " + getPluginList());
            } else {
                switch (args[0]) {
                    case "load":
                        if (args.length < 2) {
                            sender.sendMessage(ChatColor.RED + "Usage: " + usageMessage);
                            return false;
                        }
                        JSPlugin plugin = JSPluginManager.getPlugin(args[1]);
                        if (plugin == null) {
                            sender.sendMessage(ChatColor.RED + "Not found script.");
                            break;
                        }
                        if (plugin.isEnabled()) {
                            sender.sendMessage(ChatColor.GOLD + "This script is enabled!");
                            break;
                        }
                        plugin.onEnable();
                        break;
                    case "disable":
                        if (args.length < 2) {
                            sender.sendMessage(ChatColor.RED + "Usage: " + usageMessage);
                            return false;
                        }
                        LuaPlugin plugin_d = LuaPluginManager.getPlugin(args[1]);
                        if (plugin_d == null) {
                            sender.sendMessage(ChatColor.RED + "Not found script.");
                            break;
                        }
                        if (!plugin_d.isEnabled()) {
                            sender.sendMessage(ChatColor.GOLD + "This script is disabled!");
                            break;
                        }
                        plugin_d.onDisable();
                        break;
                    case "list":
                        sender.sendMessage("Scripts " + getPluginList());
                        break;
                    default:
                        sender.sendMessage("Usage: ");
                        break;
                }
            }
        }catch (Exception e){
            Bukkit.getLogger().warning(e.getLocalizedMessage());
            e.printStackTrace();
        }
        return false;
    }
    private String getPluginList() {
        StringBuilder pluginList = new StringBuilder();

        for (JSPlugin plugin : JSPluginManager.getPlugins()) {
            if (pluginList.length() > 0) {
                pluginList.append(ChatColor.WHITE);
                pluginList.append(", ");
            }

            pluginList.append(plugin.isEnabled() ? ChatColor.GREEN : ChatColor.RED);
            pluginList.append(plugin.getName());
        }

        return "(" + JSPluginManager.getPlugins().size() + "): " + pluginList.toString();
    }
}
