package com.aurgiyalgo.SlimefunNukes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;

public class SFNukesUtils {
	
	public static List<Location> getSphereBlocks(Location explosionBlock, int radius) {		
		List<Location> sphereBlocks = new ArrayList<>();
		int bX = explosionBlock.getBlockX();
		int bY = explosionBlock.getBlockY();
		int bZ = explosionBlock.getBlockZ();
//		boolean usingTowny = SlimefunNukes.getInstance().isUsingTowny();
//		boolean usingWG = SlimefunNukes.getInstance().isUsingWG();
		Location tempLoc = new Location(explosionBlock.getWorld(), 0, 0, 0);
		Random random = new Random(System.currentTimeMillis());
		for (int y = bY + radius; y >= bY - radius; y--) {
			for (int x = bX - radius; x <= bX + radius; x++) {
				for (int z = bZ - radius; z <= bZ + radius; z++) {
					double distance = ((bX - x) * (bX - x) + ((bZ - z) * (bZ - z)) + ((bY - y) * (bY - y)));
					if (distance + random.nextInt(64) > radius * radius) continue;
					tempLoc = new Location(explosionBlock.getWorld(), x, y, z);
//					tempLoc.setX(x);
//					tempLoc.setY(y);
//					tempLoc.setZ(z);
					if (tempLoc.getBlock().getType().equals(Material.AIR)) continue;
					if (tempLoc.getBlock().getType().equals(Material.BEDROCK)) continue;
					sphereBlocks.add(tempLoc);
				}
			}
		}
		return sphereBlocks;
	}

}
