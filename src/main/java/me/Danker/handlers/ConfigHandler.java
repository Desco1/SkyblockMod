package me.Danker.handlers;

import java.io.File;

import me.Danker.commands.DisplayCommand;
import me.Danker.commands.LootCommand;
import me.Danker.commands.MoveCommand;
import me.Danker.commands.ScaleCommand;
import me.Danker.commands.ToggleCommand;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.config.Configuration;

public class ConfigHandler {
	public static Configuration config;
	private static String file = "config/Danker's Skyblock Mod.cfg";
	
	public static void init() {
		config = new Configuration(new File(file));
		try {
			config.load();
		} catch (Exception ex) {
			System.err.println(ex);
		} finally {
			config.save();
		}
	}
	
	public static int getInt(String category, String key) {
		config = new Configuration(new File(file));
		try {
			config.load();
			if (config.getCategory(category).containsKey(key)) {
				return config.get(category, key, 0).getInt();
			}
		} catch (Exception ex) {
			System.err.println(ex);
		} finally {
			config.save();
		}
		return 0;
	}
	
	public static double getDouble(String category, String key) {
		config = new Configuration(new File(file));
		try {
			config.load();
			if (config.getCategory(category).containsKey(key)) {
				return config.get(category, key, 0D).getDouble();
			}
		} catch (Exception ex) {
			System.err.println(ex);
		} finally {
			config.save();
		}
		return 0D;
	}
	
	public static String getString(String category, String key) {
		config = new Configuration(new File(file));
		try {
			config.load();
			if (config.getCategory(category).containsKey(key)) {
				return config.get(category, key, "").getString();
			}
		} catch (Exception ex) {
			System.err.println(ex);
		} finally {
			config.save();
		}
		return "";
	}
	
	public static boolean getBoolean(String category, String key) {
		config = new Configuration(new File(file));
		try {
			config.load();
			if (config.getCategory(category).containsKey(key)) {
				return config.get(category, key, false).getBoolean();
			}
		} catch (Exception ex) {
			System.err.println(ex);
		} finally {
			config.save();
		}
		return true;
	}
	
	public static void writeIntConfig(String category, String key, int value) {
		config = new Configuration(new File(file));
		try {
			config.load();
			int set = config.get(category, key, value).getInt();
			config.getCategory(category).get(key).set(value);
		} catch (Exception ex) {
			System.err.println(ex);
		} finally {
			config.save();
		}
	}
	
	public static void writeDoubleConfig(String category, String key, double value) {
		config = new Configuration(new File(file));
		try {
			config.load();
			double set = config.get(category, key, value).getDouble();
			config.getCategory(category).get(key).set(value);
		} catch (Exception ex) {
			System.err.println(ex);
		} finally {
			config.save();
		}
	}
	
	public static void writeStringConfig(String category, String key, String value) {
		config = new Configuration(new File(file));
		try {
			config.load();
			String set = config.get(category, key, value).getString();
			config.getCategory(category).get(key).set(value);
		} catch (Exception ex) {
			System.err.println(ex);
		} finally {
			config.save();
		}
	}
	
	public static void writeBooleanConfig(String category, String key, boolean value) {
		config = new Configuration(new File(file));
		try {
			config.load();
			boolean set = config.get(category, key, value).getBoolean();
			config.getCategory(category).get(key).set(value);
		} catch (Exception ex) {
			System.err.println(ex);
		} finally {
			config.save();
		}
	}
	
	public static boolean hasKey(String category, String key) {
		config = new Configuration(new File(file));
		try {
			config.load();
			if (!config.hasCategory(category)) return false;
			return config.getCategory(category).containsKey(key);
		} catch (Exception ex) {
			System.err.println(ex);
		} finally {
			config.save();
		}
		return false;
	}
	
	public static void deleteCategory(String category) {
		config = new Configuration(new File(file));
		try {
			config.load();
			if (config.hasCategory(category)) {
				config.removeCategory(new ConfigCategory(category));
			}
		} catch (Exception ex) {
			System.err.println(ex);
		} finally {
			config.save();
		}
	}
	
	public static void reloadConfig() {
		// Config init
		if (!hasKey("toggles", "GParty")) writeBooleanConfig("toggles", "GParty", false);
		if (!hasKey("toggles", "Coords")) writeBooleanConfig("toggles", "Coords", false);
		if (!hasKey("toggles", "Golden")) writeBooleanConfig("toggles", "Golden", false);
		if (!hasKey("toggles", "SlayerCount")) writeBooleanConfig("toggles", "SlayerCount", true);
		if (!hasKey("toggles", "RNGesusAlerts")) writeBooleanConfig("toggles", "RNGesusAlerts", true);
		if (!hasKey("toggles", "SplitFishing")) writeBooleanConfig("toggles", "SplitFishing", true);
		if (!hasKey("toggles", "ChatMaddox")) writeBooleanConfig("toggles", "ChatMaddox", true);
		if (!hasKey("toggles", "SpiritBearAlerts")) writeBooleanConfig("toggles", "SpiritBearAlerts", true);
		if (!hasKey("toggles", "AOTD")) writeBooleanConfig("toggles", "AOTD", false);
		if (!hasKey("toggles", "SceptreMessages")) writeBooleanConfig("toggles", "SceptreMessages", true);
		if (!hasKey("toggles", "PetColors")) writeBooleanConfig("toggles", "PetColors", false);
		
		if (!hasKey("api", "APIKey")) writeStringConfig("api", "APIKey", "");
		
		// Wolf Loot
		if (!hasKey("wolf", "svens")) writeIntConfig("wolf", "svens", 0);
		if (!hasKey("wolf", "teeth")) writeIntConfig("wolf", "teeth", 0);
		if (!hasKey("wolf", "wheel")) writeIntConfig("wolf", "wheel", 0);
		if (!hasKey("wolf", "wheelDrops")) writeIntConfig("wolf", "wheelDrops", 0);
		if (!hasKey("wolf", "spirit")) writeIntConfig("wolf", "spirit", 0);
		if (!hasKey("wolf", "book")) writeIntConfig("wolf", "book", 0);
		if (!hasKey("wolf", "egg")) writeIntConfig("wolf", "egg", 0);
		if (!hasKey("wolf", "couture")) writeIntConfig("wolf", "couture", 0);
		if (!hasKey("wolf", "bait")) writeIntConfig("wolf", "bait", 0);
		if (!hasKey("wolf", "flux")) writeIntConfig("wolf", "flux", 0);
		if (!hasKey("wolf", "timeRNG")) writeDoubleConfig("wolf", "timeRNG", -1);
		if (!hasKey("wolf", "bossRNG")) writeIntConfig("wolf", "bossRNG", -1);
		// Spider Loot
		if (!hasKey("spider", "tarantulas")) writeIntConfig("spider", "tarantulas", 0);
		if (!hasKey("spider", "web")) writeIntConfig("spider", "web", 0);
		if (!hasKey("spider", "tap")) writeIntConfig("spider", "tap", 0);
		if (!hasKey("spider", "tapDrops")) writeIntConfig("spider", "tapDrops", 0);
		if (!hasKey("spider", "bite")) writeIntConfig("spider", "bite", 0);
		if (!hasKey("spider", "catalyst")) writeIntConfig("spider", "catalyst", 0);
		if (!hasKey("spider", "book")) writeIntConfig("spider", "book", 0);
		if (!hasKey("spider", "swatter")) writeIntConfig("spider", "swatter", 0);
		if (!hasKey("spider", "talisman")) writeIntConfig("spider", "talisman", 0);
		if (!hasKey("spider", "mosquito")) writeIntConfig("spider", "mosquito", 0);
		if (!hasKey("spider", "timeRNG")) writeDoubleConfig("spider", "timeRNG", -1);
		if (!hasKey("spider", "bossRNG")) writeIntConfig("spider", "bossRNG", -1);
		// Zombie Loot
		if (!hasKey("zombie", "revs")) writeIntConfig("zombie", "revs", 0);
		if (!hasKey("zombie", "revFlesh")) writeIntConfig("zombie", "revFlesh", 0);
		if (!hasKey("zombie", "foulFlesh")) writeIntConfig("zombie", "foulFlesh", 0);
		if (!hasKey("zombie", "foulFleshDrops")) writeIntConfig("zombie", "foulFleshDrops", 0);
		if (!hasKey("zombie", "pestilence")) writeIntConfig("zombie", "pestilence", 0);
		if (!hasKey("zombie", "undeadCatalyst")) writeIntConfig("zombie", "undeadCatalyst", 0);
		if (!hasKey("zombie", "book")) writeIntConfig("zombie", "book", 0);
		if (!hasKey("zombie", "beheaded")) writeIntConfig("zombie", "beheaded", 0);
		if (!hasKey("zombie", "revCatalyst")) writeIntConfig("zombie", "revCatalyst", 0);
		if (!hasKey("zombie", "snake")) writeIntConfig("zombie", "snake", 0);
		if (!hasKey("zombie", "scythe")) writeIntConfig("zombie", "scythe", 0);
		if (!hasKey("zombie", "timeRNG")) writeDoubleConfig("zombie", "timeRNG", -1);
		if (!hasKey("zombie", "bossRNG")) writeIntConfig("zombie", "bossRNG", -1);
		
		// Fishing
		if (!hasKey("fishing", "seaCreature")) writeIntConfig("fishing", "seaCreature", 0);
		if (!hasKey("fishing", "goodCatch")) writeIntConfig("fishing", "goodCatch", 0);
		if (!hasKey("fishing", "greatCatch")) writeIntConfig("fishing", "greatCatch", 0);
		if (!hasKey("fishing", "squid")) writeIntConfig("fishing", "squid", 0);
		if (!hasKey("fishing", "seaWalker")) writeIntConfig("fishing", "seaWalker", 0);
		if (!hasKey("fishing", "nightSquid")) writeIntConfig("fishing", "nightSquid", 0);
		if (!hasKey("fishing", "seaGuardian")) writeIntConfig("fishing", "seaGuardian", 0);
		if (!hasKey("fishing", "seaWitch")) writeIntConfig("fishing", "seaWitch", 0);
		if (!hasKey("fishing", "seaArcher")) writeIntConfig("fishing", "seaArcher", 0);
		if (!hasKey("fishing", "monsterOfDeep")) writeIntConfig("fishing", "monsterOfDeep", 0);
		if (!hasKey("fishing", "catfish")) writeIntConfig("fishing", "catfish", 0);
		if (!hasKey("fishing", "carrotKing")) writeIntConfig("fishing", "carrotKing", 0);
		if (!hasKey("fishing", "seaLeech")) writeIntConfig("fishing", "seaLeech", 0);
		if (!hasKey("fishing", "guardianDefender")) writeIntConfig("fishing", "guardianDefender", 0);
		if (!hasKey("fishing", "deepSeaProtector")) writeIntConfig("fishing", "deepSeaProtector", 0);
		if (!hasKey("fishing", "hydra")) writeIntConfig("fishing", "hydra", 0);
		if (!hasKey("fishing", "seaEmperor")) writeIntConfig("fishing", "seaEmperor", 0);
		if (!hasKey("fishing", "empTime")) writeDoubleConfig("fishing", "empTime", -1);
		if (!hasKey("fishing", "empSC")) writeIntConfig("fishing", "empSC", -1);
		if (!hasKey("fishing", "milestone")) writeIntConfig("fishing", "milestone", 0);
		// Fishing Winter
		if (!hasKey("fishing", "frozenSteve")) writeIntConfig("fishing", "frozenSteve", 0);
		if (!hasKey("fishing", "snowman")) writeIntConfig("fishing", "snowman", 0);
		if (!hasKey("fishing", "grinch")) writeIntConfig("fishing", "grinch", 0);
		if (!hasKey("fishing", "yeti")) writeIntConfig("fishing", "yeti", 0);
		
		// Dungeons
		if (!hasKey("catacombs", "recombobulator")) writeIntConfig("catacombs", "recombobulator", 0);
		if (!hasKey("catacombs", "fumingBooks")) writeIntConfig("catacombs", "fumingBooks", 0);
		// F1
		if (!hasKey("catacombs", "bonzoStaff")) writeIntConfig("catacombs", "bonzoStaff", 0);
		// F2
		if (!hasKey("catacombs", "scarfStudies")) writeIntConfig("catacombs", "scarfStudies", 0);
		// F3
		if (!hasKey("catacombs", "adaptiveHelm")) writeIntConfig("catacombs", "adaptiveHelm", 0);
		if (!hasKey("catacombs", "adaptiveChest")) writeIntConfig("catacombs", "adaptiveChest", 0);
		if (!hasKey("catacombs", "adaptiveLegging")) writeIntConfig("catacombs", "adaptiveLegging", 0);
		if (!hasKey("catacombs", "adaptiveBoot")) writeIntConfig("catacombs", "adaptiveBoot", 0);
		if (!hasKey("catacombs", "adaptiveSword")) writeIntConfig("catacombs", "adaptiveSword", 0);
		// F4
		if (!hasKey("catacombs", "spiritWing")) writeIntConfig("catacombs", "spiritWing", 0);
		if (!hasKey("catacombs", "spiritBone")) writeIntConfig("catacombs", "spiritBone", 0);
		if (!hasKey("catacombs", "spiritBoot")) writeIntConfig("catacombs", "spiritBoot", 0);
		if (!hasKey("catacombs", "spiritSword")) writeIntConfig("catacombs", "spiritSword", 0);
		if (!hasKey("catacombs", "spiritBow")) writeIntConfig("catacombs", "spiritBow", 0);
		if (!hasKey("catacombs", "spiritPetEpic")) writeIntConfig("catacombs", "spiritPetEpic", 0);
		if (!hasKey("catacombs", "spiritPetLeg")) writeIntConfig("catacombs", "spiritPetLeg", 0);
		
		if (!hasKey("misc", "display")) writeStringConfig("misc", "display", "off");
		
		ScaledResolution scaled = new ScaledResolution(Minecraft.getMinecraft());
		int height = scaled.getScaledHeight();
		if (!hasKey("locations", "coordsX")) writeIntConfig("locations", "coordsX", 5);
		if (!hasKey("locations", "coordsY")) writeIntConfig("locations", "coordsY", height - 25);
		if (!hasKey("locations", "displayX")) writeIntConfig("locations", "displayX", 80);
		if (!hasKey("locations", "displayY")) writeIntConfig("locations", "displayY", 5);
		if (!hasKey("scales", "coordsScale")) writeDoubleConfig("scales", "coordsScale", 1);
		if (!hasKey("scales", "displayScale")) writeDoubleConfig("scales", "displayScale", 1);
		
		final ToggleCommand tf = new ToggleCommand();
		tf.gpartyToggled = getBoolean("toggles", "GParty");
		tf.coordsToggled = getBoolean("toggles", "Coords");
		tf.goldenToggled = getBoolean("toggles", "Golden");
		tf.slayerCountTotal = getBoolean("toggles", "SlayerCount");
		tf.rngesusAlerts = getBoolean("toggles", "RNGesusAlerts");
		tf.splitFishing = getBoolean("toggles", "SplitFishing");
		tf.chatMaddoxToggled = getBoolean("toggles", "ChatMaddox");
		tf.spiritBearAlerts = getBoolean("toggles", "SpiritBearAlerts");
		tf.aotdToggled = getBoolean("toggles", "AOTD");
		tf.sceptreMessages = getBoolean("toggles", "SceptreMessages");
		tf.petColoursToggled = getBoolean("toggles", "PetColors");
		
		final LootCommand lc = new LootCommand();
		// Wolf
		lc.wolfSvens = getInt("wolf", "svens");
		lc.wolfTeeth = getInt("wolf", "teeth");
		lc.wolfWheels = getInt("wolf", "wheel");
		lc.wolfWheelsDrops = getInt("wolf", "wheelDrops");
		lc.wolfSpirits = getInt("wolf", "spirit");
		lc.wolfBooks = getInt("wolf", "book");
		lc.wolfEggs = getInt("wolf", "egg");
		lc.wolfCoutures = getInt("wolf", "couture");
		lc.wolfBaits = getInt("wolf", "bait");
		lc.wolfFluxes = getInt("wolf", "flux");
		lc.wolfTime = getDouble("wolf", "timeRNG");
		lc.wolfBosses = getInt("wolf", "bossRNG");
		// Spider
		lc.spiderTarantulas = getInt("spider", "tarantulas");
		lc.spiderWebs = getInt("spider", "web");
		lc.spiderTAP = getInt("spider", "tap");
		lc.spiderTAPDrops = getInt("spider", "tapDrops");
		lc.spiderBites = getInt("spider", "bite");
		lc.spiderCatalysts = getInt("spider", "catalyst");
		lc.spiderBooks = getInt("spider", "book");
		lc.spiderSwatters = getInt("spider", "swatter");
		lc.spiderTalismans = getInt("spider", "talisman");
		lc.spiderMosquitos = getInt("spider", "mosquito");
		lc.spiderTime = getDouble("spider", "timeRNG");
		lc.spiderBosses = getInt("spider", "bossRNG");
		// Zombie
		lc.zombieRevs = getInt("zombie", "revs");
		lc.zombieRevFlesh = getInt("zombie", "revFlesh");
		lc.zombieFoulFlesh = getInt("zombie", "foulFlesh");
		lc.zombieFoulFleshDrops = getInt("zombie", "foulFleshDrops");
		lc.zombiePestilences = getInt("zombie", "pestilence");
		lc.zombieUndeadCatas = getInt("zombie", "undeadCatalyst");
		lc.zombieBooks = getInt("zombie", "book");
		lc.zombieBeheadeds = getInt("zombie", "beheaded");
		lc.zombieRevCatas = getInt("zombie", "revCatalyst");
		lc.zombieSnakes = getInt("zombie", "snake");
		lc.zombieScythes = getInt("zombie", "scythe");
		lc.zombieTime = getDouble("zombie", "timeRNG");
		lc.zombieBosses = getInt("zombie", "bossRNG");
		
		// Fishing
		lc.seaCreatures = getInt("fishing", "seaCreature");
		lc.goodCatches = getInt("fishing", "goodCatch");
		lc.greatCatches = getInt("fishing", "greatCatch");
		lc.squids = getInt("fishing", "squid");
		lc.seaWalkers = getInt("fishing", "seaWalker");
		lc.nightSquids = getInt("fishing", "nightSquid");
		lc.seaGuardians = getInt("fishing", "seaGuardian");
		lc.seaWitches = getInt("fishing", "seaWitch");
		lc.seaArchers = getInt("fishing", "seaArcher");
		lc.monsterOfTheDeeps = getInt("fishing", "monsterOfDeep");
		lc.catfishes = getInt("fishing", "catfish");
		lc.seaLeeches = getInt("fishing", "seaLeech");
		lc.guardianDefenders = getInt("fishing", "guardianDefender");
		lc.deepSeaProtectors = getInt("fishing", "deepSeaProtector");
		lc.hydras = getInt("fishing", "hydra");
		lc.seaEmperors = getInt("fishing", "seaEmperor");
		lc.empTime = getDouble("fishing", "empTime");
		lc.empSCs = getInt("fishing", "empSC");
		lc.fishingMilestone = getInt("fishing", "milestone");
		// Fishing Winter
		lc.frozenSteves = getInt("fishing", "frozenSteve");
		lc.frostyTheSnowmans = getInt("fishing", "snowman");
		lc.grinches = getInt("fishing", "grinch");
		lc.yetis = getInt("fishing", "yeti");
		
		// Dungeons
		lc.recombobulators =  getInt("catacombs", "recombobulator");
		lc.fumingPotatoBooks = getInt("catacombs", "fumingBooks");
		// F1
		lc.bonzoStaffs = getInt("catacombs", "bonzoStaff");
		// F2
		lc.scarfStudies = getInt("catacombs", "scarfStudies");
		// F3
		lc.adaptiveHelms = getInt("catacombs", "adaptiveHelm");
		lc.adaptiveChests = getInt("catacombs", "adaptiveChest");
		lc.adaptiveLegs = getInt("catacombs", "adaptiveLegging");
		lc.adaptiveBoots = getInt("catacombs", "adaptiveBoot");
		lc.adaptiveSwords = getInt("catacombs", "adaptiveSword");
		// F4
		lc.spiritWings = getInt("catacombs", "spiritWing");
		lc.spiritBones = getInt("catacombs", "spiritBone");
		lc.spiritBoots = getInt("catacombs", "spiritBoot");
		lc.spiritSwords = getInt("catacombs", "spiritSword");
		lc.spiritBows = getInt("catacombs", "spiritBow");
		lc.epicSpiritPets = getInt("catacombs", "spiritPetEpic");
		lc.legSpiritPets = getInt("catacombs", "spiritPetLeg");
		
		final DisplayCommand ds = new DisplayCommand();
		ds.display = getString("misc", "display");
		
		final MoveCommand moc = new MoveCommand();
		moc.coordsXY[0] = getInt("locations", "coordsX");
		moc.coordsXY[1] = getInt("locations", "coordsY");
		moc.displayXY[0] = getInt("locations", "displayX");
		moc.displayXY[1] = getInt("locations", "displayY");
		
		final ScaleCommand sc = new ScaleCommand();
		sc.coordsScale = getDouble("scales", "coordsScale");
		sc.displayScale = getDouble("scales", "displayScale");
	}
	
}
