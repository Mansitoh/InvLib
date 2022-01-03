package club.skilled.libraries.invlib.example;

import club.skilled.libraries.invlib.menu.Button;
import club.skilled.libraries.invlib.menu.InvLibInventory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;
import java.util.function.Predicate;

/**
 * Created by Mansitoh
 * Project: InvLib Date: 03/12/2022 @ 12:30
 * Twitter: @Mansitoh_PY Github: https://github.com/Mansitoh
 * Discord: https://discord.link/Skilled
 * CEO: Skilled | Development
 */
@AllArgsConstructor
public enum InvLibExampleInventorys implements InvLibInventory {

    EXAMPLE_INVENTORY("&b&lExample Inventory!", 3, buttons -> {
        buttons.put(0, InvLibExampleButtons.TEST_BUTTON);
        return true;
    },
            InvLibExampleButtons.FILL_BUTTON);

    private final String displayname;
    private final int rows;
    private final Predicate<HashMap<Integer, Button>> buttons;
    private final Button fill;

    @Override
    public String getDisplayname(Player p) {
        return displayname;
    }

    @Override
    public int getRows(Player p) {
        return rows;
    }

    @Override
    public HashMap<Integer, Button> getButtons(Player p) {
        HashMap<Integer, Button> buttonHashMap = new HashMap<>();
        buttons.test(buttonHashMap);
        return buttonHashMap;
    }

    @Override
    public Button getButtonToFillEmptySlots() {
        return fill;
    }

    @Override
    public Button getButton(int slot, Player p) {
        if(getButtons(p).containsKey(slot)) {
            getButtons(p).get(slot);
        }
        return null;
    }

}

