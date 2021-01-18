package com.eric0210.sac.events;

import java.util.ArrayDeque;
import java.util.Queue;

import com.eric0210.sac.checks.Check;

import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.entity.*;
import org.bukkit.event.inventory.*;
import org.bukkit.event.player.*;
import org.spigotmc.event.entity.EntityMountEvent;

@SuppressWarnings(
{
		"WeakerAccess", "CollectionWithoutInitialCapacity", "PublicStaticCollectionField"
})
public class GlobalEventListener
{
	public static final Queue<EventHandlerData> onEntityDamage = new ArrayDeque<>();
	public static final Queue<EventHandlerData> onEntityDamageByEntity = new ArrayDeque<>();
	public static final Queue<EventHandlerData> onEntityDamageByBlock = new ArrayDeque<>();

	@EventHandler
	public final void onEntityDamage(final EntityDamageEvent e)
	{
		execute(onEntityDamage, e);

		// if (e.getEntity() instanceof Player)
		// CombatUtils.lastHitByEntity.put(e.getEntity().getUniqueId(), System.currentTimeMillis());
		// if (((EntityDamageByEntityEvent) e).getDamager() instanceof Player)
		// CombatUtils.lastHitEntity.put(((EntityDamageByEntityEvent) e).getDamager().getUniqueId(), System.currentTimeMillis());
		if (e instanceof EntityDamageByEntityEvent)
			execute(onEntityDamageByEntity, e);

		if (e instanceof EntityDamageByBlockEvent)
			execute(onEntityDamageByBlock, e);
	}

	public static final Queue<EventHandlerData> onPlayerAnimation = new ArrayDeque<>();

	@EventHandler
	public final void onPlayerAnimation(final PlayerAnimationEvent e)
	{
		execute(onPlayerAnimation, e);
	}

	public static final Queue<EventHandlerData> onEntityDeath = new ArrayDeque<>();
	public static final Queue<EventHandlerData> onPlayerDeath = new ArrayDeque<>();

	@EventHandler
	public final void onEntityDeath(final EntityDeathEvent e)
	{
//		Reverter.resetAllPositions();
		execute(onEntityDeath, e);

		if (e instanceof PlayerDeathEvent)
		{
			final PlayerDeathEvent e2 = (PlayerDeathEvent) e;
//			final Player p = (Player) e.getEntity();
//			Cache.set(p.getUniqueId(), "__cached_fallDistance", 0.0F);
//			Cache.set(p.getUniqueId(), "fallDistance", 0.0F);
			execute(onPlayerDeath, e2);
		}
	}

	public static final Queue<EventHandlerData> onEntityTarget = new ArrayDeque<>();

	@EventHandler
	public final void onEntityTarget(final EntityTargetEvent e)
	{
		execute(onEntityTarget, e);
	}

	public static final Queue<EventHandlerData> onFoodLevelChange = new ArrayDeque<>();

	@EventHandler
	public final void onFoodLevelChangeEvent(final FoodLevelChangeEvent e)
	{
		execute(onFoodLevelChange, e);
	}

	public static final Queue<EventHandlerData> onPlayerTeleport = new ArrayDeque<>();

	@EventHandler
	public final void onPlayerTeleport(final PlayerTeleportEvent e)
	{
//		if (!e.isCancelled())
//		{
//			if (e.getCause() == TeleportCause.ENDER_PEARL || e.getCause() == TeleportCause.COMMAND)
//				Reverter.setAllPositions(e.getPlayer().getUniqueId(), e.getTo());
//			Counter.increment1AndGetCount(e.getPlayer().getUniqueId(), "teleport", -1);
//		}
		execute(onPlayerTeleport, e);
	}

	public static final Queue<EventHandlerData> onEntityRegainHealth = new ArrayDeque<>();

	@EventHandler
	public final void onEntityRegainHealth(final EntityRegainHealthEvent e)
	{
		execute(onEntityRegainHealth, e);
	}

	public static final Queue<EventHandlerData> onPlayerDropItem = new ArrayDeque<>();

	@EventHandler
	public final void onPlayerDropItem(final PlayerDropItemEvent e)
	{
		execute(onPlayerDropItem, e);
	}

	public static final Queue<EventHandlerData> onPlayerRespawn = new ArrayDeque<>();

	@EventHandler
	public final void onPlayerRespawnEvent(final PlayerRespawnEvent e)
	{
//		Reverter.resetAllPositions();
//		Cache.set(e.getPlayer().getUniqueId(), "__cached_fallDistance", 0.0F);
//		Cache.set(e.getPlayer().getUniqueId(), "fallDistance", 0.0F);
		execute(onPlayerRespawn, e);
	}

	public static final Queue<EventHandlerData> onPlayerInteract = new ArrayDeque<>();

	@EventHandler
	public final void onPlayerInteract(final PlayerInteractEvent e)
	{
		execute(onPlayerInteract, e);
	}

	public static final Queue<EventHandlerData> onPlayerMove = new ArrayDeque<>();

	@EventHandler(priority = EventPriority.HIGH)
	public final void onPlayerMoveEvent(final PlayerMoveEvent e)
	{
//		Player p = e.getPlayer();
//		UUID uid = p.getUniqueId();
//		if (Counter.getCount(uid, "teleport") > 0)
//		{
//			Cache.set(uid, "teleported", true);
//			System.out.println("marked teleported movement");
//			Counter.decrement1AndGetCount(uid, "teleport", -1);
//		}
//		else
//			Cache.set(uid, "teleported", false);
//
//		double speed = MathUtils.getHorizontalDistance(e.getFrom(), e.getTo());
//		double y_speed = MathUtils.getVerticalDistance(e.getFrom(), e.getTo());
//		TimeUtils.putCurrentTime(uid, "lastMove");
//		if (p.isSneaking())
//			Cooldowns.set(uid, "sneak", 8);
//		Cooldowns.set(uid, "movement", -1);
//		if (speed > .26D && y_speed > .164D && (Counter.getCount(uid, "ticksUp") > 0 || Counter.getCount(uid, "ticksDown") < 3))
//			if (speed > .34)
//				Cooldowns.set(p.getUniqueId(), "sprint-jump", 5);
//			else
//				Cooldowns.set(p.getUniqueId(), "jump", 6);
//		if (BlockUtils.getBlocksInRadius2D(p.getLocation(), .4, 0, true).isEmpty())
//		{
//			Cache.set(uid, "nearBlocks", false);
//			Counter.remove(uid, "nearBlocks");
//		}
//		else
//		{
//			Cache.set(uid, "nearBlocks", true);
//			Counter.increment1AndGetCount(uid, "nearBlocks", -1);
//		}
//		if (Cache.get(uid, "nearBlocks", false) && Counter.getCount(uid, "nearIce") > 10)
//			if (!BlockUtils.isIceNearby(p.getLocation()))
//				Cache.set(uid, "nearIce", false);
//			else
//				Counter.increment1AndGetCount(uid, "nearIce", -1);
//		if (BlockUtils.isIceNearby(p.getLocation()))
//			if (Counter.getCount(uid, "nearIce") < 60)
//				Counter.increment1AndGetCount(uid, "nearIce", -1);
//			else if (Counter.getCount(uid, "nearIce") > 0)
//				Counter.increment1AndGetCount(uid, "nearIce", -1);
//		if (BlockUtils.isIceNearby(p.getLocation()) && !Cache.get(uid, "nearIce", false))
//		{
//			Cache.set(uid, "nearIce", true);
//			Counter.increment1AndGetCount(uid, "nearIce", -1);
//		}
//		else if (BlockUtils.isIceNearby(p.getLocation()))
//		{
//			Counter.increment1AndGetCount(uid, "nearIce", -1);
//		}
//		float distance = (float) MathUtils.getVerticalDistance(e.getFrom(), e.getTo());
//		boolean onGround = GroundChecks.isOnGround(p);
//		if (!onGround && e.getFrom().getY() > e.getTo().getY())
//		{
//			Cache.set(uid, "fallDistance", Cache.get(uid, "__cached_fallDistance", 0.0F));
//			Cache.set(uid, "__cached_fallDistance", Cache.get(uid, "__cached_fallDistance", 0.0F) + distance);
//		}
//		else if (onGround)
//		{
//			Cache.set(uid, "__cached_fallDistance", 0.0F);
//			Cache.set(uid, "fallDistance", 0.0F);
//		}
//		if (onGround)
//		{
//			Counter.increment1AndGetCount(uid, "groundTicks", -1);
//			Counter.remove(uid, "airTicks");
//		}
//		else
//		{
//			Counter.increment1AndGetCount(uid, "airTicks", -1);
//			Counter.remove(uid, "groundTicks");
//		}
//		if (BlockUtils.isLiquidNearby(p.getLocation()) || BlockUtils.isLiquidNearby(p.getLocation().add(0.0, 1.0, 0.0)))
//			Counter.increment1AndGetCount(uid, "waterTicks", -1);
//		else if (Counter.getCount(uid, "waterTicks") > 0)
//			Counter.increment1AndGetCount(uid, "waterTicks", -1);
//		Cache.set(uid, "moveSpeed", speed);
//		InventoryUtils.handleMove(e);
		execute(onPlayerMove, e);
	}

	public static final Queue<EventHandlerData> onProjectileHit = new ArrayDeque<>();

	@EventHandler
	public final void onProjectileHit(final ProjectileHitEvent e)
	{
		execute(onProjectileHit, e);
	}

	public static final Queue<EventHandlerData> onProjectileLaunch = new ArrayDeque<>();

	@EventHandler
	public final void onProjectileLaunch(final ProjectileLaunchEvent e)
	{
		execute(onProjectileLaunch, e);
	}

	public static final Queue<EventHandlerData> onBlockPlace = new ArrayDeque<>();

	@EventHandler
	public final void onBlockPlace(final BlockPlaceEvent e)
	{
		execute(onBlockPlace, e);
	}

	public static final Queue<EventHandlerData> onSignChange = new ArrayDeque<>();

	@EventHandler
	public final void onSignChange(final SignChangeEvent e)
	{
		execute(onSignChange, e);
	}

	public static final Queue<EventHandlerData> onBlockBreak = new ArrayDeque<>();

	@EventHandler
	public final void onBlockBreak(final BlockBreakEvent e)
	{
		execute(onBlockBreak, e);
	}

	public static final Queue<EventHandlerData> onBlockDamage = new ArrayDeque<>();

	@EventHandler
	public final void onBlockDamage(final BlockDamageEvent e)
	{
		execute(onBlockDamage, e);
	}

	public static final Queue<EventHandlerData> onPlayerItemConsume = new ArrayDeque<>();

	@EventHandler
	public final void onPlayerItemConsume(final PlayerItemConsumeEvent e)
	{
		execute(onPlayerItemConsume, e);
	}

	public static final Queue<EventHandlerData> onPlayerJoin = new ArrayDeque<>();

	@EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
	public final void onPlayerJoin(final PlayerJoinEvent e)
	{
//		Logging.debug("Player " + e.getPlayer().getName() + " joined to this server.");
//		PlayerConnection oldConnection = ((CraftPlayer) e.getPlayer()).getHandle().playerConnection;
//		((CraftPlayer) e.getPlayer()).getHandle().playerConnection = new PlayerConnectionFilter(MinecraftServer.getServer(), oldConnection.networkManager, ((CraftPlayer) e.getPlayer()).getHandle());
//		Logging.debug("Player " + e.getPlayer().getName() + " PlayerConnection has replaced to PlayerConnectionFilter");
//		ViolationMap.reset(e.getPlayer());
//		// Checks.initalizeChecks(e.getPlayer());
//		Reverter.resetAllPositions();
		execute(onPlayerJoin, e);
	}

	public static final Queue<EventHandlerData> onPlayerQuit = new ArrayDeque<>();

	@EventHandler
	public final void onPlayerQuit(final PlayerQuitEvent e)
	{
//		ViolationMap.reset(e.getPlayer());
		execute(onPlayerQuit, e);
	}

	public static final Queue<EventHandlerData> onPlayerInteractEntity = new ArrayDeque<>();

	@EventHandler
	public final void onPlayerInteractEntity(final PlayerInteractEntityEvent e)
	{
		execute(onPlayerInteractEntity, e);
	}

	public static final Queue<EventHandlerData> onAsyncPlayerChat = new ArrayDeque<>();

	@EventHandler
	public final void onAsyncPlayerChat(final AsyncPlayerChatEvent e)
	{
		execute(onAsyncPlayerChat, e);
	}

	public static final Queue<EventHandlerData> onPlayerKick = new ArrayDeque<>();

	@EventHandler
	public final void onPlayerKick(final PlayerKickEvent e)
	{
		execute(onPlayerKick, e);
	}

	public static final Queue<EventHandlerData> onPlayerSneak = new ArrayDeque<>();

	@EventHandler
	public final void onPlayerSneak(final PlayerToggleSneakEvent e)
	{
		execute(onPlayerSneak, e);
	}

	public static final Queue<EventHandlerData> onInventoryClick = new ArrayDeque<>();

	@EventHandler(priority = EventPriority.MONITOR)
	public final void onInventoryClick(final InventoryClickEvent e)
	{
		execute(onInventoryClick, e);
	}

	public static final Queue<EventHandlerData> onInventoryOpen = new ArrayDeque<>();

	@EventHandler(priority = EventPriority.MONITOR)
	public final void onInventoryOpen(final InventoryOpenEvent e)
	{
		execute(onInventoryOpen, e);
	}

	public static final Queue<EventHandlerData> onInventoryClose = new ArrayDeque<>();

	@EventHandler(priority = EventPriority.MONITOR)
	public final void onInventoryClose(final InventoryCloseEvent e)
	{
		execute(onInventoryClose, e);
	}

	public static final Queue<EventHandlerData> onInventoryPickupItem = new ArrayDeque<>();

	@EventHandler
	public final void onInventoryPickupItem(final InventoryPickupItemEvent e)
	{
		execute(onInventoryPickupItem, e);
	}

	public static final Queue<EventHandlerData> onInventoryInteract = new ArrayDeque<>();

	@EventHandler
	public final void onInventoryInteract(final InventoryInteractEvent e)
	{
		execute(onInventoryInteract, e);
	}

	public static final Queue<EventHandlerData> onPlayerLogin = new ArrayDeque<>();

	@EventHandler
	public final void onPlayerLogin(final PlayerLoginEvent e)
	{
		execute(onPlayerLogin, e);
	}

	public static final Queue<EventHandlerData> onPlayerPortal = new ArrayDeque<>();

	@EventHandler
	public final void onPlayerPortal(final PlayerPortalEvent e)
	{
		execute(onPlayerPortal, e);
	}

	public static final Queue<EventHandlerData> onPlayerLevelChange = new ArrayDeque<>();

	@EventHandler
	public final void onPlayerLevelChange(final PlayerLevelChangeEvent e)
	{
		execute(onPlayerLevelChange, e);
	}

	public static final Queue<EventHandlerData> onPlayerExpChange = new ArrayDeque<>();

	@EventHandler
	public final void onPlayerExpChange(final PlayerExpChangeEvent e)
	{
		execute(onPlayerExpChange, e);
	}

	public static final Queue<EventHandlerData> onPlayerEmptyBucket = new ArrayDeque<>();

	@EventHandler
	public final void onPlayerEmptyBucket(final PlayerBucketEmptyEvent e)
	{
		execute(onPlayerEmptyBucket, e);
	}

	public static final Queue<EventHandlerData> onPlayerFillBucket = new ArrayDeque<>();

	@EventHandler
	public final void onPlayerFillBucket(final PlayerBucketFillEvent e)
	{
		execute(onPlayerFillBucket, e);
	}

	public static final Queue<EventHandlerData> onPlayerEditBook = new ArrayDeque<>();

	@EventHandler
	public final void onEditBook(final PlayerEditBookEvent e)
	{
		execute(onPlayerEditBook, e);
	}

	public static final Queue<EventHandlerData> onPlayerFish = new ArrayDeque<>();

	@EventHandler
	public final void onPlayerFish(final PlayerFishEvent e)
	{
		execute(onPlayerFish, e);
	}

	public static final Queue<EventHandlerData> onEntityShootBow = new ArrayDeque<>();

	@EventHandler
	public final void onEntityShootBow(final EntityShootBowEvent e)
	{
		execute(onEntityShootBow, e);
	}

	public static final Queue<EventHandlerData> onEntityExplode = new ArrayDeque<>();

	@EventHandler
	public final void onEntityExplode(final EntityExplodeEvent e)
	{
		execute(onEntityExplode, e);
	}

	public static final Queue<EventHandlerData> onPlayerItemHeld = new ArrayDeque<>();

	@EventHandler
	public final void onPlayerItemHeld(final PlayerItemHeldEvent e)
	{
		execute(onPlayerItemHeld, e);
	}

	public static final Queue<EventHandlerData> onPlayerChangeWorld = new ArrayDeque<>();

	@EventHandler
	public final void onPlayerItemHeld(final PlayerChangedWorldEvent e)
	{
//		Reverter.resetAllPositions();
		execute(onPlayerChangeWorld, e);
	}

	public static final Queue<EventHandlerData> onVelocity = new ArrayDeque<>();

	@EventHandler
	public final void onVelocity(final PlayerVelocityEvent e)
	{
		execute(onVelocity, e);
	}

	public static final Queue<EventHandlerData> onMount = new ArrayDeque<>();

	@EventHandler
	public final void onEntityMount(final EntityMountEvent e)
	{
		execute(onMount, e);
	}

	public final void execute(final Queue<? extends EventHandlerData> queue, final Event e)
	{
		for (final EventHandlerData handler : queue)
			try
			{
				if (handler.getListener() instanceof Check && !((Check) handler.getListener()).isEnabled())
					continue;
				handler.getListener().handleEvent(e, handler.getCondition());
			}
			catch (final Throwable t)
			{
				// TODO: More robust logging
				t.printStackTrace();
			}
	}
}
