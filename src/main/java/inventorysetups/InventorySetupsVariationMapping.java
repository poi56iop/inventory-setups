package inventorysetups;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static net.runelite.api.ItemID.*;

import com.google.common.collect.ImmutableMap;
import net.runelite.client.game.ItemVariationMapping;

public class InventorySetupsVariationMapping
{
	private static final Map<Integer, Integer> mappings;

	// Worn items with weight reducing property have a different worn and inventory ItemID
	// Copy of ItemManger::WORN_ITEMS. Use that instead if it becomes a publicly usable member.
	public static final ImmutableMap<Integer, Integer> WORN_ITEMS = ImmutableMap.<Integer, Integer>builder().
			put(BOOTS_OF_LIGHTNESS_89, BOOTS_OF_LIGHTNESS).
			put(PENANCE_GLOVES_10554, PENANCE_GLOVES).

			put(GRACEFUL_HOOD_11851, GRACEFUL_HOOD).
			put(GRACEFUL_CAPE_11853, GRACEFUL_CAPE).
			put(GRACEFUL_TOP_11855, GRACEFUL_TOP).
			put(GRACEFUL_LEGS_11857, GRACEFUL_LEGS).
			put(GRACEFUL_GLOVES_11859, GRACEFUL_GLOVES).
			put(GRACEFUL_BOOTS_11861, GRACEFUL_BOOTS).
			put(GRACEFUL_HOOD_13580, GRACEFUL_HOOD_13579).
			put(GRACEFUL_CAPE_13582, GRACEFUL_CAPE_13581).
			put(GRACEFUL_TOP_13584, GRACEFUL_TOP_13583).
			put(GRACEFUL_LEGS_13586, GRACEFUL_LEGS_13585).
			put(GRACEFUL_GLOVES_13588, GRACEFUL_GLOVES_13587).
			put(GRACEFUL_BOOTS_13590, GRACEFUL_BOOTS_13589).
			put(GRACEFUL_HOOD_13592, GRACEFUL_HOOD_13591).
			put(GRACEFUL_CAPE_13594, GRACEFUL_CAPE_13593).
			put(GRACEFUL_TOP_13596, GRACEFUL_TOP_13595).
			put(GRACEFUL_LEGS_13598, GRACEFUL_LEGS_13597).
			put(GRACEFUL_GLOVES_13600, GRACEFUL_GLOVES_13599).
			put(GRACEFUL_BOOTS_13602, GRACEFUL_BOOTS_13601).
			put(GRACEFUL_HOOD_13604, GRACEFUL_HOOD_13603).
			put(GRACEFUL_CAPE_13606, GRACEFUL_CAPE_13605).
			put(GRACEFUL_TOP_13608, GRACEFUL_TOP_13607).
			put(GRACEFUL_LEGS_13610, GRACEFUL_LEGS_13609).
			put(GRACEFUL_GLOVES_13612, GRACEFUL_GLOVES_13611).
			put(GRACEFUL_BOOTS_13614, GRACEFUL_BOOTS_13613).
			put(GRACEFUL_HOOD_13616, GRACEFUL_HOOD_13615).
			put(GRACEFUL_CAPE_13618, GRACEFUL_CAPE_13617).
			put(GRACEFUL_TOP_13620, GRACEFUL_TOP_13619).
			put(GRACEFUL_LEGS_13622, GRACEFUL_LEGS_13621).
			put(GRACEFUL_GLOVES_13624, GRACEFUL_GLOVES_13623).
			put(GRACEFUL_BOOTS_13626, GRACEFUL_BOOTS_13625).
			put(GRACEFUL_HOOD_13628, GRACEFUL_HOOD_13627).
			put(GRACEFUL_CAPE_13630, GRACEFUL_CAPE_13629).
			put(GRACEFUL_TOP_13632, GRACEFUL_TOP_13631).
			put(GRACEFUL_LEGS_13634, GRACEFUL_LEGS_13633).
			put(GRACEFUL_GLOVES_13636, GRACEFUL_GLOVES_13635).
			put(GRACEFUL_BOOTS_13638, GRACEFUL_BOOTS_13637).
			put(GRACEFUL_HOOD_13668, GRACEFUL_HOOD_13667).
			put(GRACEFUL_CAPE_13670, GRACEFUL_CAPE_13669).
			put(GRACEFUL_TOP_13672, GRACEFUL_TOP_13671).
			put(GRACEFUL_LEGS_13674, GRACEFUL_LEGS_13673).
			put(GRACEFUL_GLOVES_13676, GRACEFUL_GLOVES_13675).
			put(GRACEFUL_BOOTS_13678, GRACEFUL_BOOTS_13677).
			put(GRACEFUL_HOOD_21063, GRACEFUL_HOOD_21061).
			put(GRACEFUL_CAPE_21066, GRACEFUL_CAPE_21064).
			put(GRACEFUL_TOP_21069, GRACEFUL_TOP_21067).
			put(GRACEFUL_LEGS_21072, GRACEFUL_LEGS_21070).
			put(GRACEFUL_GLOVES_21075, GRACEFUL_GLOVES_21073).
			put(GRACEFUL_BOOTS_21078, GRACEFUL_BOOTS_21076).
			put(GRACEFUL_HOOD_24745, GRACEFUL_HOOD_24743).
			put(GRACEFUL_CAPE_24748, GRACEFUL_CAPE_24746).
			put(GRACEFUL_TOP_24751, GRACEFUL_TOP_24749).
			put(GRACEFUL_LEGS_24754, GRACEFUL_LEGS_24752).
			put(GRACEFUL_GLOVES_24757, GRACEFUL_GLOVES_24755).
			put(GRACEFUL_BOOTS_24760, GRACEFUL_BOOTS_24758).
			put(GRACEFUL_HOOD_25071, GRACEFUL_HOOD_25069).
			put(GRACEFUL_CAPE_25074, GRACEFUL_CAPE_25072).
			put(GRACEFUL_TOP_25077, GRACEFUL_TOP_25075).
			put(GRACEFUL_LEGS_25080, GRACEFUL_LEGS_25078).
			put(GRACEFUL_GLOVES_25083, GRACEFUL_GLOVES_25081).
			put(GRACEFUL_BOOTS_25086, GRACEFUL_BOOTS_25084).
			put(GRACEFUL_HOOD_27446, GRACEFUL_HOOD_27444).
			put(GRACEFUL_CAPE_27449, GRACEFUL_CAPE_27447).
			put(GRACEFUL_TOP_27452, GRACEFUL_TOP_27450).
			put(GRACEFUL_LEGS_27455, GRACEFUL_LEGS_27453).
			put(GRACEFUL_GLOVES_27458, GRACEFUL_GLOVES_27456).
			put(GRACEFUL_BOOTS_27461, GRACEFUL_BOOTS_27459).

			put(MAX_CAPE_13342, MAX_CAPE).

			put(SPOTTED_CAPE_10073, SPOTTED_CAPE).
			put(SPOTTIER_CAPE_10074, SPOTTIER_CAPE).

			put(AGILITY_CAPET_13341, AGILITY_CAPET).
			put(AGILITY_CAPE_13340, AGILITY_CAPE).
			build();

	public static final Map<Integer, Integer> INVERTED_WORN_ITEMS;

	public InventorySetupsVariationMapping()
	{
	}

	public static int map(final Integer id)
	{
		int mappedId = ItemVariationMapping.map(id);

		// if the mapped ID is equal to the original id
		// this means there was no mapping for this id. Try the extra custom mappings
		if (mappedId == id)
		{
			mappedId = mappings.getOrDefault(id, id);
		}

		return mappedId;
	}

	static
	{
		mappings = new HashMap<>();

		// Granite Cannonball -> Cannonball
		mappings.put(GRANITE_CANNONBALL, CANNONBALL);

		// Smith Gloves (i) act as ice gloves
		mappings.put(SMITHS_GLOVES_I, ICE_GLOVES);

		// Divine rune pouch -> Rune Pouch
		mappings.put(DIVINE_RUNE_POUCH, RUNE_POUCH);

		// Make god capes the same
		final int itemIDGodCape = 1000000001;
		mappings.put(SARADOMIN_CAPE, itemIDGodCape);
		mappings.put(GUTHIX_CAPE, itemIDGodCape);
		mappings.put(ZAMORAK_CAPE, itemIDGodCape);
		final int itemIDImbuedGodCape = 1000000002;
		mappings.put(IMBUED_SARADOMIN_CAPE, itemIDImbuedGodCape);
		mappings.put(IMBUED_GUTHIX_CAPE, itemIDImbuedGodCape);
		mappings.put(IMBUED_ZAMORAK_CAPE, itemIDImbuedGodCape);
		final int itemIDGodMaxCape = 1000000003;
		mappings.put(SARADOMIN_MAX_CAPE, itemIDGodMaxCape);
		mappings.put(GUTHIX_MAX_CAPE, itemIDGodMaxCape);
		mappings.put(ZAMORAK_MAX_CAPE, itemIDGodMaxCape);
		final int itemIDImbuedGodMaxCape = 1000000004;
		mappings.put(IMBUED_SARADOMIN_MAX_CAPE, itemIDImbuedGodMaxCape);
		mappings.put(IMBUED_GUTHIX_MAX_CAPE, itemIDImbuedGodMaxCape);
		mappings.put(IMBUED_ZAMORAK_MAX_CAPE, itemIDImbuedGodMaxCape);

		// Make god d'hides the same
		final int itemIDGodCoif = 1000000005;
		mappings.put(ANCIENT_COIF, itemIDGodCoif);
		mappings.put(ARMADYL_COIF, itemIDGodCoif);
		mappings.put(BANDOS_COIF, itemIDGodCoif);
		mappings.put(GUTHIX_COIF, itemIDGodCoif);
		mappings.put(SARADOMIN_COIF, itemIDGodCoif);
		mappings.put(ZAMORAK_COIF, itemIDGodCoif);

		final int itemIDGodDhideBody = 1000000006;
		mappings.put(ANCIENT_DHIDE_BODY, itemIDGodDhideBody);
		mappings.put(ARMADYL_DHIDE_BODY, itemIDGodDhideBody);
		mappings.put(BANDOS_DHIDE_BODY, itemIDGodDhideBody);
		mappings.put(GUTHIX_DHIDE_BODY, itemIDGodDhideBody);
		mappings.put(SARADOMIN_DHIDE_BODY, itemIDGodDhideBody);
		mappings.put(ZAMORAK_DHIDE_BODY, itemIDGodDhideBody);

		final int itemIDGodChaps = 1000000007;
		mappings.put(ANCIENT_CHAPS, itemIDGodChaps);
		mappings.put(ARMADYL_CHAPS, itemIDGodChaps);
		mappings.put(BANDOS_CHAPS, itemIDGodChaps);
		mappings.put(GUTHIX_CHAPS, itemIDGodChaps);
		mappings.put(SARADOMIN_CHAPS, itemIDGodChaps);
		mappings.put(ZAMORAK_CHAPS, itemIDGodChaps);

		final int itemIDGodBracers = 1000000008;
		mappings.put(ANCIENT_BRACERS, itemIDGodBracers);
		mappings.put(ARMADYL_BRACERS, itemIDGodBracers);
		mappings.put(BANDOS_BRACERS, itemIDGodBracers);
		mappings.put(GUTHIX_BRACERS, itemIDGodBracers);
		mappings.put(SARADOMIN_BRACERS, itemIDGodBracers);
		mappings.put(ZAMORAK_BRACERS, itemIDGodBracers);

		final int itemIDGodDhideBoots = 1000000009;
		mappings.put(ANCIENT_DHIDE_BOOTS, itemIDGodDhideBoots);
		mappings.put(ARMADYL_DHIDE_BOOTS, itemIDGodDhideBoots);
		mappings.put(BANDOS_DHIDE_BOOTS, itemIDGodDhideBoots);
		mappings.put(GUTHIX_DHIDE_BOOTS, itemIDGodDhideBoots);
		mappings.put(SARADOMIN_DHIDE_BOOTS, itemIDGodDhideBoots);
		mappings.put(ZAMORAK_DHIDE_BOOTS, itemIDGodDhideBoots);

		final int itemIDGodDhideShield = 1000000010;
		mappings.put(ANCIENT_DHIDE_SHIELD, itemIDGodDhideShield);
		mappings.put(ARMADYL_DHIDE_SHIELD, itemIDGodDhideShield);
		mappings.put(BANDOS_DHIDE_SHIELD, itemIDGodDhideShield);
		mappings.put(GUTHIX_DHIDE_SHIELD, itemIDGodDhideShield);
		mappings.put(SARADOMIN_DHIDE_SHIELD, itemIDGodDhideShield);
		mappings.put(ZAMORAK_DHIDE_SHIELD, itemIDGodDhideShield);

		// Twisted Ancestral -> Regular Ancestral
		mappings.put(TWISTED_ANCESTRAL_HAT, ANCESTRAL_HAT);
		mappings.put(TWISTED_ANCESTRAL_ROBE_BOTTOM, ANCESTRAL_ROBE_BOTTOM);
		mappings.put(TWISTED_ANCESTRAL_ROBE_TOP, ANCESTRAL_ROBE_TOP);

		// Golden Prospectors -> Regular Prospectors
		mappings.put(GOLDEN_PROSPECTOR_BOOTS, PROSPECTOR_BOOTS);
		mappings.put(GOLDEN_PROSPECTOR_HELMET, PROSPECTOR_HELMET);
		mappings.put(GOLDEN_PROSPECTOR_JACKET, PROSPECTOR_JACKET);
		mappings.put(GOLDEN_PROSPECTOR_LEGS, PROSPECTOR_LEGS);

		// Spirit Anglers -> Regular Anglers
		mappings.put(SPIRIT_ANGLER_BOOTS, ANGLER_BOOTS);
		mappings.put(SPIRIT_ANGLER_HEADBAND, ANGLER_HAT);
		mappings.put(SPIRIT_ANGLER_TOP, ANGLER_TOP);
		mappings.put(SPIRIT_ANGLER_WADERS, ANGLER_WADERS);
		
		// ToB ornament kits -> base version
		mappings.put(SANGUINE_SCYTHE_OF_VITUR, SCYTHE_OF_VITUR);
		mappings.put(HOLY_SCYTHE_OF_VITUR, SCYTHE_OF_VITUR);
		mappings.put(HOLY_SANGUINESTI_STAFF, SANGUINESTI_STAFF);
		mappings.put(HOLY_GHRAZI_RAPIER, GHRAZI_RAPIER);

		mappings.put(GHOMMALS_AVERNIC_DEFENDER_5, AVERNIC_DEFENDER);
		mappings.put(GHOMMALS_AVERNIC_DEFENDER_5_L, AVERNIC_DEFENDER);
		mappings.put(GHOMMALS_AVERNIC_DEFENDER_6, AVERNIC_DEFENDER);
		mappings.put(GHOMMALS_AVERNIC_DEFENDER_6_L, AVERNIC_DEFENDER);

		// INVERTED_WORN_ITEMS mapping
		INVERTED_WORN_ITEMS = WORN_ITEMS.entrySet()
										.stream()
										.collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));

	}



}
