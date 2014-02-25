package com.norcode.bukkit.uhc;

import org.bukkit.Achievement;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.EntityEffect;
import org.bukkit.GameMode;
import org.bukkit.Instrument;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Note;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.Statistic;
import org.bukkit.WeatherType;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.conversations.Conversation;
import org.bukkit.conversations.ConversationAbandonedEvent;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.map.MapView;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.util.Vector;

import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FakePlayer implements Player {
	public static final String FILL_COMPLETE = "Complete";
	public static final String FILL_WORKING = "Working";
	public static final String FILL_PAUSED = "Paused";

	private WorldSetup setup;
	private int fillPercentage;
	private String fillStatus = "unknown";
	//[Fill] 108 more chunks processed (108 total, ~8.6%) (free mem: 727 MB)
	Pattern fillPercentagePattern = Pattern.compile("^\\d+\\s+more\\s+chunks\\s+processed\\s+\\(\\d+\\s+total,\\s+~([^%]+)%\\)$");
	//[Fill] task successfully completed! (free mem: 675 MB)
	private Pattern fillCompletePattern = Pattern.compile("^task successfully completed!$");
	private Pattern fillPausedPattern = Pattern.compile("^Available memory is very low, task is pausing.*$");

	public FakePlayer(WorldSetup setup) {
		this.setup  = setup;
	}

	private static final String name = "FakePlayer";

	@Override
	public String getDisplayName() {
		return name;  
	}

	@Override
	public void setDisplayName(String s) {}

	@Override
	public String getPlayerListName() {
		return name;
	}

	@Override
	public void setPlayerListName(String s) {}

	@Override
	public void setCompassTarget(Location location) {}

	@Override
	public Location getCompassTarget() {
		return null; 
	}

	@Override
	public InetSocketAddress getAddress() {
		return null;
	}

	@Override
	public boolean isConversing() {
		return false;
	}

	@Override
	public void acceptConversationInput(String s) {}

	@Override
	public boolean beginConversation(Conversation conversation) {
		return false;
	}

	@Override
	public void abandonConversation(Conversation conversation) {}

	@Override
	public void abandonConversation(Conversation conversation, ConversationAbandonedEvent conversationAbandonedEvent) {}

	@Override
	public void sendRawMessage(String s) {}

	@Override
	public void kickPlayer(String s) {}

	@Override
	public void chat(String s) {}

	@Override
	public boolean performCommand(String s) {
		return false;
	}

	@Override
	public boolean isSneaking() {
		return false;
	}

	@Override
	public void setSneaking(boolean b) {}

	@Override
	public boolean isSprinting() {
		return false; 
	}

	@Override
	public void setSprinting(boolean b) {}

	@Override
	public void saveData() {}

	@Override
	public void loadData() {}

	@Override
	public void setSleepingIgnored(boolean b) {}

	@Override
	public boolean isSleepingIgnored() {
		return false;
	}

	@Override
	public void playNote(Location location, byte b, byte b2) {}

	@Override
	public void playNote(Location location, Instrument instrument, Note note) {}

	@Override
	public void playSound(Location location, Sound sound, float v, float v2) {}

	@Override
	public void playSound(Location location, String s, float v, float v2) {}

	@Override
	public void playEffect(Location location, Effect effect, int i) {}

	@Override
	public <T> void playEffect(Location location, Effect effect, T t) {}

	@Override
	public void sendBlockChange(Location location, Material material, byte b) {}

	@Override
	public boolean sendChunkChange(Location location, int i, int i2, int i3, byte[] bytes) {
		return false;
	}

	@Override
	public void sendBlockChange(Location location, int i, byte b) {}

	@Override
	public void sendMap(MapView mapView) {}

	@Override
	public void updateInventory() {}

	@Override
	public void awardAchievement(Achievement achievement) {}

	@Override
	public void removeAchievement(Achievement achievement) {}

	@Override
	public boolean hasAchievement(Achievement achievement) {
		return false;
	}

	@Override
	public void incrementStatistic(Statistic statistic) throws IllegalArgumentException {}

	@Override
	public void decrementStatistic(Statistic statistic) throws IllegalArgumentException {}

	@Override
	public void incrementStatistic(Statistic statistic, int i) throws IllegalArgumentException {}

	@Override
	public void decrementStatistic(Statistic statistic, int i) throws IllegalArgumentException {}

	@Override
	public void setStatistic(Statistic statistic, int i) throws IllegalArgumentException {}

	@Override
	public int getStatistic(Statistic statistic) throws IllegalArgumentException {
		return 0;
	}

	@Override
	public void incrementStatistic(Statistic statistic, Material material) throws IllegalArgumentException {}

	@Override
	public void decrementStatistic(Statistic statistic, Material material) throws IllegalArgumentException {}

	@Override
	public int getStatistic(Statistic statistic, Material material) throws IllegalArgumentException {
		return 0;
	}

	@Override
	public void incrementStatistic(Statistic statistic, Material material, int i) throws IllegalArgumentException {}

	@Override
	public void decrementStatistic(Statistic statistic, Material material, int i) throws IllegalArgumentException {}

	@Override
	public void setStatistic(Statistic statistic, Material material, int i) throws IllegalArgumentException {}
	
	@Override
	public void incrementStatistic(Statistic statistic, EntityType entityType) throws IllegalArgumentException {}

	@Override
	public void decrementStatistic(Statistic statistic, EntityType entityType) throws IllegalArgumentException {}

	@Override
	public int getStatistic(Statistic statistic, EntityType entityType) throws IllegalArgumentException {
		return 0;
	}

	@Override
	public void incrementStatistic(Statistic statistic, EntityType entityType, int i) throws IllegalArgumentException {}

	@Override
	public void decrementStatistic(Statistic statistic, EntityType entityType, int i) {}

	@Override
	public void setStatistic(Statistic statistic, EntityType entityType, int i) {}

	@Override
	public void setPlayerTime(long l, boolean b) {}

	@Override
	public long getPlayerTime() {
		return 0;
	}

	@Override
	public long getPlayerTimeOffset() {
		return 0;
	}

	@Override
	public boolean isPlayerTimeRelative() {
		return false;
	}

	@Override
	public void resetPlayerTime() {}

	@Override
	public void setPlayerWeather(WeatherType weatherType) {}

	@Override
	public WeatherType getPlayerWeather() {
		return null;
	}

	@Override
	public void resetPlayerWeather() {}

	@Override
	public void giveExp(int i) {}

	@Override
	public void giveExpLevels(int i) {}

	@Override
	public float getExp() {
		return 0;
	}

	@Override
	public void setExp(float v) {}

	@Override
	public int getLevel() {
		return 0;
	}

	@Override
	public void setLevel(int i) {}

	@Override
	public int getTotalExperience() {
		return 0;
	}

	@Override
	public void setTotalExperience(int i) {}

	@Override
	public float getExhaustion() {
		return 0;
	}

	@Override
	public void setExhaustion(float v) {}

	@Override
	public float getSaturation() {
		return 0;
	}

	@Override
	public void setSaturation(float v) {}

	@Override
	public int getFoodLevel() {
		return 0;
	}

	@Override
	public void setFoodLevel(int i) {}

	@Override
	public Location getBedSpawnLocation() {
		return null;
	}

	@Override
	public void setBedSpawnLocation(Location location) {}

	@Override
	public void setBedSpawnLocation(Location location, boolean b) {}

	@Override
	public boolean getAllowFlight() {
		return false;
	}

	@Override
	public void setAllowFlight(boolean b) {}

	@Override
	public void hidePlayer(Player player) {}

	@Override
	public void showPlayer(Player player) {}

	@Override
	public boolean canSee(Player player) {
		return false;
	}

	@Override
	public Location getLocation() {
		return null;
	}

	@Override
	public Location getLocation(Location location) {
		return null;
	}

	@Override
	public void setVelocity(Vector vector) {}

	@Override
	public Vector getVelocity() {
		return null;
	}

	@Override
	public boolean isOnGround() {
		return false;
	}

	@Override
	public World getWorld() {
		return null;
	}

	@Override
	public boolean teleport(Location location) {
		return false;
	}

	@Override
	public boolean teleport(Location location, PlayerTeleportEvent.TeleportCause teleportCause) {
		return false;
	}

	@Override
	public boolean teleport(Entity entity) {
		return false;
	}

	@Override
	public boolean teleport(Entity entity, PlayerTeleportEvent.TeleportCause teleportCause) {
		return false;
	}

	@Override
	public List<Entity> getNearbyEntities(double v, double v2, double v3) {
		return null;
	}

	@Override
	public int getEntityId() {
		return 0;
	}

	@Override
	public int getFireTicks() {
		return 0;
	}

	@Override
	public int getMaxFireTicks() {
		return 0;
	}

	@Override
	public void setFireTicks(int i) {}

	@Override
	public void remove() {}

	@Override
	public boolean isDead() {
		return false;
	}

	@Override
	public boolean isValid() {
		return false;
	}

	@Override
	public Server getServer() {
		return null;
	}

	@Override
	public Entity getPassenger() {
		return null;
	}

	@Override
	public boolean setPassenger(Entity entity) {
		return false;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public boolean eject() {
		return false;
	}

	@Override
	public float getFallDistance() {
		return 0;
	}

	@Override
	public void setFallDistance(float v) {}

	@Override
	public void setLastDamageCause(EntityDamageEvent entityDamageEvent) {}

	@Override
	public EntityDamageEvent getLastDamageCause() {
		return null;
	}

	@Override
	public UUID getUniqueId() {
		return null;
	}

	@Override
	public int getTicksLived() {
		return 0;
	}

	@Override
	public void setTicksLived(int i) {}

	@Override
	public void playEffect(EntityEffect entityEffect) {}

	@Override
	public EntityType getType() {
		return null;
	}

	@Override
	public boolean isInsideVehicle() {
		return false;
	}

	@Override
	public boolean leaveVehicle() {
		return false;
	}

	@Override
	public Entity getVehicle() {
		return null;
	}

	@Override
	public boolean isFlying() {
		return false;
	}

	@Override
	public void setFlying(boolean b) {}

	@Override
	public void setFlySpeed(float v) throws IllegalArgumentException {}

	@Override
	public void setWalkSpeed(float v) throws IllegalArgumentException {}

	@Override
	public float getFlySpeed() {
		return 0;
	}

	@Override
	public float getWalkSpeed() {
		return 0;
	}

	@Override
	public void setTexturePack(String s) {}

	@Override
	public void setResourcePack(String s) {}

	@Override
	public Scoreboard getScoreboard() {
		return null;
	}

	@Override
	public void setScoreboard(Scoreboard scoreboard) throws IllegalArgumentException, IllegalStateException {}

	@Override
	public boolean isHealthScaled() {
		return false;
	}

	@Override
	public void setHealthScaled(boolean b) {}

	@Override
	public void setHealthScale(double v) throws IllegalArgumentException {}

	@Override
	public double getHealthScale() {
		return 0;
	}

	@Override
	public void sendMessage(String s) {

		if (s.startsWith("[Fill] ")) {
			s = s.substring(7).trim();
			Matcher matcher = fillPercentagePattern.matcher(s);
			if (matcher.matches()) {
				fillPercentage = (int) Math.round(Double.parseDouble(matcher.group(1)));
				fillStatus = fillStatus.equals(FILL_COMPLETE) ? FILL_COMPLETE : FILL_WORKING;
				return;
			} else {
				matcher = fillCompletePattern.matcher(s);
				if (matcher.matches()) {
					fillStatus = FILL_COMPLETE;
					Bukkit.getLogger().info("Fill Complete!");
					return;
				} else {
					matcher = fillPausedPattern.matcher(s);
					if (matcher.matches()) {
						fillStatus = FILL_PAUSED;
						Bukkit.getLogger().info("Fill Paused!");
						return;
					}
				}
			}
		}
	}

	@Override
	public void sendMessage(String[] strings) {
		for (String s: strings) {
			this.sendMessage(s);
		}
	}

	@Override
	public Map<String, Object> serialize() {
		return null;
	}

	@Override
	public boolean isOnline() {
		return false;
	}

	@Override
	public String getName() {
		return null;
	}

	@Override
	public boolean isBanned() {
		return false;
	}

	@Override
	public void setBanned(boolean b) {}

	@Override
	public boolean isWhitelisted() {
		return false;
	}

	@Override
	public void setWhitelisted(boolean b) {}

	@Override
	public Player getPlayer() {
		return null;
	}

	@Override
	public long getFirstPlayed() {
		return 0;
	}

	@Override
	public long getLastPlayed() {
		return 0;
	}

	@Override
	public boolean hasPlayedBefore() {
		return false;
	}

	@Override
	public PlayerInventory getInventory() {
		return null;
	}

	@Override
	public Inventory getEnderChest() {
		return null;
	}

	@Override
	public boolean setWindowProperty(InventoryView.Property property, int i) {
		return false;
	}

	@Override
	public InventoryView getOpenInventory() {
		return null;
	}

	@Override
	public InventoryView openInventory(Inventory itemStacks) {
		return null;
	}

	@Override
	public InventoryView openWorkbench(Location location, boolean b) {
		return null;
	}

	@Override
	public InventoryView openEnchanting(Location location, boolean b) {
		return null;
	}

	@Override
	public void openInventory(InventoryView inventoryView) {}

	@Override
	public void closeInventory() {}

	@Override
	public ItemStack getItemInHand() {
		return null;
	}

	@Override
	public void setItemInHand(ItemStack itemStack) {}

	@Override
	public ItemStack getItemOnCursor() {
		return null;
	}

	@Override
	public void setItemOnCursor(ItemStack itemStack) {}

	@Override
	public boolean isSleeping() {
		return false;
	}

	@Override
	public int getSleepTicks() {
		return 0;
	}

	@Override
	public GameMode getGameMode() {
		return null;
	}

	@Override
	public void setGameMode(GameMode gameMode) {}

	@Override
	public boolean isBlocking() {
		return false;
	}

	@Override
	public int getExpToLevel() {
		return 0;
	}

	@Override
	public double getEyeHeight() {
		return 0;
	}

	@Override
	public double getEyeHeight(boolean b) {
		return 0;
	}

	@Override
	public Location getEyeLocation() {
		return null;
	}

	@Override
	public List<Block> getLineOfSight(HashSet<Byte> bytes, int i) {
		return null;
	}

	@Override
	public Block getTargetBlock(HashSet<Byte> bytes, int i) {
		return null;
	}

	@Override
	public List<Block> getLastTwoTargetBlocks(HashSet<Byte> bytes, int i) {
		return null;
	}

	@Override
	public Egg throwEgg() {
		return null;
	}

	@Override
	public Snowball throwSnowball() {
		return null;
	}

	@Override
	public Arrow shootArrow() {
		return null;
	}

	@Override
	public int getRemainingAir() {
		return 0;
	}

	@Override
	public void setRemainingAir(int i) {}

	@Override
	public int getMaximumAir() {
		return 0;
	}

	@Override
	public void setMaximumAir(int i) {}

	@Override
	public int getMaximumNoDamageTicks() {
		return 0;
	}

	@Override
	public void setMaximumNoDamageTicks(int i) {}

	@Override
	public double getLastDamage() {
		return 0;
	}

	@Override
	public int _INVALID_getLastDamage() {
		return 0;
	}

	@Override
	public void setLastDamage(double v) {}

	@Override
	public void _INVALID_setLastDamage(int i) {}

	@Override
	public int getNoDamageTicks() {
		return 0;
	}

	@Override
	public void setNoDamageTicks(int i) {}

	@Override
	public Player getKiller() {
		return null;
	}

	@Override
	public boolean addPotionEffect(PotionEffect potionEffect) {
		return false;
	}

	@Override
	public boolean addPotionEffect(PotionEffect potionEffect, boolean b) {
		return false;
	}

	@Override
	public boolean addPotionEffects(Collection<PotionEffect> potionEffects) {
		return false;
	}

	@Override
	public boolean hasPotionEffect(PotionEffectType potionEffectType) {
		return false;
	}

	@Override
	public void removePotionEffect(PotionEffectType potionEffectType) {}

	@Override
	public Collection<PotionEffect> getActivePotionEffects() {
		return null;
	}

	@Override
	public boolean hasLineOfSight(Entity entity) {
		return false;
	}

	@Override
	public boolean getRemoveWhenFarAway() {
		return false;
	}

	@Override
	public void setRemoveWhenFarAway(boolean b) {}

	@Override
	public EntityEquipment getEquipment() {
		return null;
	}

	@Override
	public void setCanPickupItems(boolean b) {}

	@Override
	public boolean getCanPickupItems() {
		return false;
	}

	@Override
	public void setCustomName(String s) {}

	@Override
	public String getCustomName() {
		return null;
	}

	@Override
	public void setCustomNameVisible(boolean b) {}

	@Override
	public boolean isCustomNameVisible() {
		return false;
	}

	@Override
	public boolean isLeashed() {
		return false;
	}

	@Override
	public Entity getLeashHolder() throws IllegalStateException {
		return null;
	}

	@Override
	public boolean setLeashHolder(Entity entity) {
		return false;
	}

	@Override
	public void damage(double v) {}

	@Override
	public void _INVALID_damage(int i) {}

	@Override
	public void damage(double v, Entity entity) {}

	@Override
	public void _INVALID_damage(int i, Entity entity) {}

	@Override
	public double getHealth() {
		return 0;
	}

	@Override
	public int _INVALID_getHealth() {
		return 0;
	}

	@Override
	public void setHealth(double v) {}

	@Override
	public void _INVALID_setHealth(int i) {}

	@Override
	public double getMaxHealth() {
		return 0;
	}

	@Override
	public int _INVALID_getMaxHealth() {
		return 0;
	}

	@Override
	public void setMaxHealth(double v) {}

	@Override
	public void _INVALID_setMaxHealth(int i) {}

	@Override
	public void resetMaxHealth() {}

	@Override
	public void setMetadata(String s, MetadataValue metadataValue) {}

	@Override
	public List<MetadataValue> getMetadata(String s) {
		return null;
	}

	@Override
	public boolean hasMetadata(String s) {
		return false;
	}

	@Override
	public void removeMetadata(String s, Plugin plugin) {}

	@Override
	public boolean isPermissionSet(String s) {
		return false;
	}

	@Override
	public boolean isPermissionSet(Permission permission) {
		return false;
	}

	@Override
	public boolean hasPermission(String s) {
		return false;
	}

	@Override
	public boolean hasPermission(Permission permission) {
		return false;
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin, String s, boolean b) {
		return null;
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin) {
		return null;
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin, String s, boolean b, int i) {
		return null;
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin, int i) {
		return null;
	}

	@Override
	public void removeAttachment(PermissionAttachment permissionAttachment) {}

	@Override
	public void recalculatePermissions() {}

	@Override
	public Set<PermissionAttachmentInfo> getEffectivePermissions() {
		return null;
	}

	@Override
	public void sendPluginMessage(Plugin plugin, String s, byte[] bytes) {}

	@Override
	public Set<String> getListeningPluginChannels() {
		return null;
	}

	@Override
	public <T extends Projectile> T launchProjectile(Class<? extends T> aClass) {
		return null;
	}

	@Override
	public <T extends Projectile> T launchProjectile(Class<? extends T> aClass, Vector vector) {
		return null;
	}

	@Override
	public boolean isOp() {
		return false;
	}

	@Override
	public void setOp(boolean b) {}

	public int getFillPercentage() {
		return fillPercentage;
	}

	public String getFillStatus() {
		return fillStatus;
	}
}
