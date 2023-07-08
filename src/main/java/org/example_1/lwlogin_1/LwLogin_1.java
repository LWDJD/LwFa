package org.example_1.lwlogin_1;
import org.bukkit.ChatColor;
import org.bukkit.entity.*;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import org.bukkit.event.*;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.Listener;
import org.example_1.lwlogin_1.commands.FailSafeDiscard;
import org.example_1.lwlogin_1.commands.TabCommand;


import java.util.ArrayList;
import java.util.List;

public final class LwLogin_1 extends JavaPlugin implements Listener {

    public static List<List<String>> cPlayer = new ArrayList<>(); // 使用ArrayList来动态存储字符串
    public static List<List<String>> message = new ArrayList<>(); // 使用ArrayList来动态存储字符串

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this); //这里LwLogin_1类是监听器, 将当前HelloWorld对象注册监听器
        getCommand("failsafediscard").setExecutor(new FailSafeDiscard());//实现命令
        this.getCommand("failsafediscard").setTabCompleter(new TabCommand(this));
        this.getLogger().info("登录插件1.2已装载");
    }

    @Override
    public void onDisable() {
        this.getLogger().info("登录插件1.2已卸载");
    }

    /*玩家加入服务器时将玩家放到防误丢名单
    * */
    @EventHandler
    public void onPlayerJoinEvent_fa_cPlayer(PlayerJoinEvent e){
        int g = -1; // 初始化g为-1，表示没有找到匹配的字符串
        boolean h = false; // 初始化h为false，表示没有找到匹配的字符串
        for (int i = 0; i < cPlayer.size(); i++) { // 遍历cPlayer列表
            for (int k = 0; k < cPlayer.get(i).size(); k++) { // 遍历cPlayer列表中每个子列表
                if (e.getPlayer().getName().equals(cPlayer.get(i).get(0))) { // 如果找到匹配的字符串
                    h = true; // 将h设为true
                    g = i; // 将g设为当前索引
                    break; // 跳出循环
                }
            }
            if (h){
                break;
            }
        }
        if (!h) { // 如果没有找到匹配的字符串
            List<String> row = new ArrayList<>(); // 创建一个新的子列表
            row.add(e.getPlayer().getName()); // 将a添加到子列表中
            row.add("false");
            cPlayer.add(row); // 将子列表添加到cPlayer列表中
            g = cPlayer.size() - 1; // 将g设为新添加的元素的索引
        }
    }
    @EventHandler
    public void onPlayerJoinEvent_fa_massage(PlayerJoinEvent e){
        int g = -1; // 初始化g为-1，表示没有找到匹配的字符串
        boolean h = false; // 初始化h为false，表示没有找到匹配的字符串
        for (int i = 0; i < message.size(); i++) { // 遍历cPlayer列表
            for (int k = 0; k < message.get(i).size(); k++) { // 遍历cPlayer列表中每个子列表
                if (e.getPlayer().getName().equals(message.get(i).get(0))) { // 如果找到匹配的字符串
                    h = true; // 将h设为true
                    g = i; // 将g设为当前索引
                    break; // 跳出循环
                }
            }
            if (h){
                break;
            }
        }
        if (!h) { // 如果没有找到匹配的字符串
            List<String> row = new ArrayList<>(); // 创建一个新的子列表
            row.add(e.getPlayer().getName()); // 将a添加到子列表中
            row.add("false");
            message.add(row); // 将子列表添加到message列表中
            g = message.size() - 1; // 将g设为新添加的元素的索引
        }
    }

    /*
* 物品丢出时提醒
* */
    @EventHandler
    public void onPlayerDropItemEvent(PlayerDropItemEvent e){
        int g = -1; // 初始化g为-1，表示没有找到匹配的字符串
        boolean h = false; // 初始化h为false，表示没有找到匹配的字符串
        for (int i = 0; i < cPlayer.size(); i++) { // 遍历cPlayer列表
            for (int k = 0; k < cPlayer.get(i).size(); k++) { // 遍历cPlayer列表中每个子列表
                if (e.getPlayer().getName().equals(cPlayer.get(i).get(0))) { // 如果找到匹配的字符串
                    h = true; // 将h设为true
                    g = i; // 将g设为当前索引
                    break; // 跳出循环
                }
            }
            if (h){
                break;
            }
        }
        e.setCancelled(Boolean.parseBoolean(cPlayer.get(g).get(1)));
        String world = null;
        Item a = e.getItemDrop();
        if (a.getWorld().getName().equals("world")){
            world = ChatColor.GREEN + "主世界";
        }
        else if (a.getWorld().getName().equals("world_nether")){
            world = ChatColor.RED + "地狱";
        }
        else if (a.getWorld().getName().equals("world_the_end")){
            world = ChatColor.LIGHT_PURPLE + "末地";
        }
        else {
            world = ChatColor.BLUE + a.getWorld().getName();
        };
        if (Boolean.parseBoolean(message.get(g).get(1))) {
            if (e.isCancelled()) { //丢出事件被取消则输出差点丢出否则输出丢出了
                e.getPlayer().sendMessage(e.getPlayer().getName() + "在" + world + ChatColor.WHITE + "差点丢出了" + a.getName());
            } else {
                e.getPlayer().sendMessage(e.getPlayer().getName() + "在" + world + ChatColor.WHITE + "丢出了" + a.getName());
            };
        };
    }
}

