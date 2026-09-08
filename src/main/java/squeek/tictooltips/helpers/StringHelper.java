package squeek.tictooltips.helpers;

import java.util.HashMap;

import net.minecraft.util.StatCollector;

import tconstruct.library.util.HarvestLevels;

import static com.gtnewhorizon.gtnhlib.util.numberformatting.NumberFormatUtil.formatNumber;

public class StringHelper {

    // Taken from tconstruct.client.gui.ToolStationGui
    public static String getHarvestLevelName(int num) {
        return HarvestLevels.getHarvestLevelName(num);
    }

    // Taken from tconstruct.library.tools.ToolCore
    public static String getReinforcedString(int reinforced) {
        if (reinforced > 9) return StringHelper.getLocalizedString("tool.unbreakable");
        else return StringHelper.getLocalizedString("tool.reinforced") + " " + RomanNumeralHelper.toRoman(reinforced);
    }

    // Taken from tconstruct.library.tools.ToolCore
    public static String getDamageString(int attack) {
        String damageNum = getDamageNumberString(attack);
        String heart = Math.abs(attack) == 2 ? StringHelper.getLocalizedString("gui.partcrafter8")
                : StringHelper.getLocalizedString("gui.partcrafter9");
        return damageNum + heart;
    }

    public static String getDamageString(float attack) {
        return getDamageString((int) attack);
    }

    public static String getDamageNumberString(int attack) {
        return formatNumber(attack / 2f);
    }

    public static String getDamageNumberString(float attack) {
        return getDamageNumberString((int) attack);
    }

    public static String getShoddinessTypeCode(float shoddiness) {
        return shoddiness > 0 ? "stonebound" : (shoddiness < 0 ? "jagged" : "");
    }

    public static String getShoddinessTypeString(float shoddiness) {
        return shoddiness > 0 ? StringHelper.getLocalizedString("material.stone.ability")
                : (shoddiness < 0 ? StringHelper.getLocalizedString("material.cactus.ability") : "");
    }

    public static String getShoddinessString(float shoddiness) {
        return formatNumber(Math.abs(shoddiness));
    }

    public static String getModifierString(float modifier) {
        return formatNumber(modifier) + "x";
    }

    public static String getSpeedString(int speed) {
        return formatNumber(speed / 100f);
    }

    public static String getArrowSpeedString(int speed) {
        return formatNumber(speed);
    }

    public static String getAccuracyString(float accuracy) {
        return formatNumber(accuracy) + "%";
    }

    public static String getDrawSpeedString(int drawSpeed) {
        return formatNumber(drawSpeed / 20f) + "s";
    }

    public static String getDurabilityString(int durability) {
        return durability != ToolHelper.INFINITE_DURABILITY ? formatNumber(durability)
                : StatCollector.translateToLocal("tictooltips.infinite");
    }

    public static String getWeightString(float weight) {
        return formatNumber(weight);
    }

    public static String getArrowSpeedString(float arrowSpeed) {
        return formatNumber(arrowSpeed);
    }

    public static String getAmmoDamageRangeString(int attack) {
        int minAttack = attack;
        int maxAttack = attack * 2;

        String heart = StringHelper.getLocalizedString("gui.partcrafter9");
        return formatNumber(minAttack / 2f) + "-" + formatNumber(maxAttack / 2f) + heart;
    }

    public static String getDurationString(double duration) {
        return formatNumber(duration) + "s";
    }

    public static String getPercentageString(double percent) {
        return formatNumber(percent * 100f) + "%";
    }

    public static String getBreakChanceString(float breakChance) {
        return getPercentageString(breakChance);
    }

    public static String getAmmoCountString(int ammo) {
        return getDurabilityString(ammo);
    }

    public static String getKnockbackString(float knockback) {
        return formatNumber(knockback);
    }

    public static HashMap<String, String> localizationAlternatives = new HashMap<String, String>();
    static {
        // localizationAlternatives.put("tic.string.name", "tictooltips.string.name");
        localizationAlternatives.put("tool.unbreakable", "tictooltips.unbreakable");

        // modifier.tool.reinforced got renamed to tool.reinforced; this enables a fallback for versions before that
        // happened
        localizationAlternatives.put("tool.reinforced", "modifier.tool.reinforced");
    }

    public static String getAlternativeLocalizedString(String unlocalized) {
        String unlocalizedAlternative = localizationAlternatives.get(unlocalized);
        return unlocalizedAlternative != null ? StatCollector.translateToLocal(unlocalizedAlternative) : unlocalized;
    }

    public static String getLocalizedString(String unlocalized) {
        String localized = StatCollector.translateToLocal(unlocalized);
        if (localized.equals(unlocalized)) return getAlternativeLocalizedString(unlocalized);
        else return localized;
    }
}
