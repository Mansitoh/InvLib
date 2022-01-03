package club.skilled.libraries.invlib.example;

import club.skilled.libraries.invlib.events.ButtonClickEvent;
import club.skilled.libraries.invlib.events.PlayerClickInventoryEvent;
import club.skilled.libraries.invlib.menu.Button;
import lombok.RequiredArgsConstructor;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Mansitoh
 * Project: InvLib Date: 03/12/2022 @ 12:31
 * Twitter: @Mansitoh_PY Github: https://github.com/Mansitoh
 * Discord: https://discord.link/Skilled
 * CEO: Skilled | Development
 */
@RequiredArgsConstructor
public enum InvLibExampleButtons implements Button {


    TEST_BUTTON("&b&lTest Button", 1, 0, 0, "", Material.PAPER, Arrays.asList("&7This is the lore", "&7Join to %where%"),
            replacer -> {
                replacer.put("%where%", "%skilled%");
                return true;
            },
            event -> {
                event.getPlayer().sendMessage("a");
                return true;
            }
    ),
    FILL_BUTTON("&B&LFill", 1, 0, 0, "", Material.BLACK_STAINED_GLASS_PANE, new ArrayList<>(),
            replacer -> {
                return true;
            },
            event -> {
                return true;
            });


    private final String displayname;
    private final int amount;
    private final int dataValue;
    private final int damageValue;
    private final String owner;
    private final Material material;
    private final List<String> lore;
    private final Predicate<HashMap<String, String>> replacer;
    private final Predicate<ButtonClickEvent> event;


    @Override
    public String getDisplayname(Player p) {
        return displayname;
    }

    @Override
    public Material getMaterial(Player p) {
        return material;
    }


    @Override
    public int getDamageValue(Player p) {
        return damageValue;
    }

    @Override
    public int getDataValue(Player p) {
        return dataValue;
    }

    @Override
    public String getOwner(Player p) {
        return owner;
    }

    @Override
    public HashMap<String, String> getReplacer(Player p) {
        HashMap<String, String> replace = new HashMap<>();
        replacer.test(replace);
        return replace;
    }

    @Override
    public List<String> getLore(Player p) {
        return lore;
    }

    @Override
    public void execute(ButtonClickEvent e) {
        event.test(e);
    }
}
