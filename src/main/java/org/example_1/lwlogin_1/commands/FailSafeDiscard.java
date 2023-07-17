package org.example_1.lwlogin_1.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.example_1.lwlogin_1.LwLogin_1;
import org.bukkit.entity.Player;


/*
 * 实现命令
 * */

public class FailSafeDiscard implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // 检查发送者是否是玩家
        if (!(sender instanceof Player)) {
            sender.sendMessage("只有玩家才能使用这个命令");
            return true;
        }
        /*
        // 检查参数长度是否为1
        if (args.length != 1) {
            sender.sendMessage("请输入正确的参数");
            return false;
        }

        // 检查参数是否是"true"或"false"
        if (!args[0].equalsIgnoreCase("true") && !args[0].equalsIgnoreCase("false")) {
            sender.sendMessage("请输入true或false");
            return false;
        }
         */
        if (args.length == 0) {
            return false;
            //sender.sendMessage(ChatColor.RED+"语法错误");
        }
        else if (args.length == 1) {
            if (args[0].equalsIgnoreCase("true")) {
                int g = -1; // 初始化g为-1，表示没有找到匹配的字符串
                boolean h = false; // 初始化h为false，表示没有找到匹配的字符串
                for (int i = 0; i < LwLogin_1.cPlayer.size(); i++) { // 遍历cPlayer列表
                    for (int k = 0; k < LwLogin_1.cPlayer.get(i).size(); k++) { // 遍历cPlayer列表中每个子列表
                        if (sender.getName().equals(LwLogin_1.cPlayer.get(i).get(0))) { // 如果找到匹配的字符串
                            h = true; // 将h设为true
                            g = i; // 将g设为当前索引
                            break; // 跳出循环
                        }
                    }
                    if (h) {
                        break;
                    }
                }
                LwLogin_1.cPlayer.get(g).set(1, "true");
                sender.sendMessage(ChatColor.GREEN + "防误丢已开启");
                return true;
            } else if (args[0].equalsIgnoreCase("false")) {
                int g = -1; // 初始化g为-1，表示没有找到匹配的字符串
                boolean h = false; // 初始化h为false，表示没有找到匹配的字符串
                for (int i = 0; i < LwLogin_1.cPlayer.size(); i++) { // 遍历cPlayer列表
                    for (int k = 0; k < LwLogin_1.cPlayer.get(i).size(); k++) { // 遍历cPlayer列表中每个子列表
                        if (sender.getName().equals(LwLogin_1.cPlayer.get(i).get(0))) { // 如果找到匹配的字符串
                            h = true; // 将h设为true
                            g = i; // 将g设为当前索引
                            break; // 跳出循环
                        }
                    }
                    if (h) {
                        break;
                    }
                }
                LwLogin_1.cPlayer.get(g).set(1, "false");
                sender.sendMessage(ChatColor.RED + "防误丢已关闭");
                return true;
            } else {
                return false;
            }
        }
        if (args.length == 2) {
            if (args[0].equalsIgnoreCase("message")) {
                if (args[1].equalsIgnoreCase("true")) {
                    int g = -1; // 初始化g为-1，表示没有找到匹配的字符串
                    boolean h = false; // 初始化h为false，表示没有找到匹配的字符串
                    for (int i = 0; i < LwLogin_1.message.size(); i++) { // 遍历massage列表
                        for (int k = 0; k < LwLogin_1.message.get(i).size(); k++) { // 遍历massage列表中每个子列表
                            if (sender.getName().equals(LwLogin_1.message.get(i).get(0))) { // 如果找到匹配的字符串
                                h = true; // 将h设为true
                                g = i; // 将g设为当前索引
                                break; // 跳出循环
                            }
                        }
                        if (h) {
                            break;
                        }
                    }
                    LwLogin_1.message.get(g).set(1, "true");
                    sender.sendMessage(ChatColor.GREEN + "物品丢出提醒开启");
                    return true;
                }
                else if (args[1].equalsIgnoreCase("false")) {
                    int g = -1; // 初始化g为-1，表示没有找到匹配的字符串
                    boolean h = false; // 初始化h为false，表示没有找到匹配的字符串
                    for (int i = 0; i < LwLogin_1.message.size(); i++) { // 遍历massage列表
                        for (int k = 0; k < LwLogin_1.message.get(i).size(); k++) { // 遍历massage列表中每个子列表
                            if (sender.getName().equals(LwLogin_1.message.get(i).get(0))) { // 如果找到匹配的字符串
                                h = true; // 将h设为true
                                g = i; // 将g设为当前索引
                                break; // 跳出循环
                            }
                        }
                        if (h) {
                            break;
                        }
                    }
                    LwLogin_1.message.get(g).set(1, "false");
                    sender.sendMessage(ChatColor.RED + "物品丢出提醒关闭");
                    return true;
                }
                else {
                    sender.sendMessage(ChatColor.RED+"语法错误2");
                    return false;
                }
            }
            else {
                sender.sendMessage(ChatColor.RED+"语法错误1");
                return false;
            }
        }
        else return false;
    }
}
