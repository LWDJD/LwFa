package org.example_1.lwlogin_1.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args){
    if (args.length == 1){
        List<String> result = new ArrayList<>(Arrays.asList("true","false","massage"));
        result.removeIf(s -> !s.startsWith(args[0].toLowerCase()));
        return result;
    }
    else {
        return null;
    }
}
}
*/
public class TabCommand implements TabCompleter {
    private JavaPlugin plugin;

    public TabCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }
    /*
     * 实现Tab补全命令
     * */
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {// 如果玩家没有输入任何参数，返回一个包含三个选项的列表：true，false和message
            List<String> result = new ArrayList<>(Arrays.asList("true", "false", "message"));
            plugin.getLogger().info(result.toString());
            return result;
        }
        else {// 如果玩家输入了一个或多个参数，返回null表示没有更多的选项
            return null;
        }
    }
}
