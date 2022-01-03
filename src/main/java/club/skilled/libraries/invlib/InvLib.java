package club.skilled.libraries.invlib;

import club.skilled.libraries.invlib.listeners.InvLibHandlerListeners;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Mansitoh
 * Project: InvLib Date: 02/17/2022 @ 17:20
 * Twitter: @Mansitoh_PY Github: https://github.com/Mansitoh
 * Discord: https://discord.link/Skilled
 * CEO: Skilled | Development
 */
public class InvLib {

    public InvLib(JavaPlugin plugin){
        Bukkit.getPluginManager().registerEvents(new InvLibHandlerListeners(),plugin);
    }

}
