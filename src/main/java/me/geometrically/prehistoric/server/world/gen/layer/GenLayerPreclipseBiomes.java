package me.geometrically.prehistoric.server.world.gen.layer;

import me.geometrically.prehistoric.server.init.PEBiomes;
import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerPreclipseBiomes extends GenLayer{

    protected Biome[] allowedBiomes = {PEBiomes.DAWN_JUNGLE, PEBiomes.DAWN_FOREST, /*PEBiomes.WETLANDS,*/ Biomes.SWAMPLAND, Biomes.MESA,Biomes.PLAINS, Biomes.DESERT, Biomes.OCEAN, Biomes.DEEP_OCEAN, Biomes.RIVER, PEBiomes.MAGNOLIA_FOREST};

    public GenLayerPreclipseBiomes(long seed, GenLayer genlayer) {
        super(seed);
        parent = genlayer;
    }
    public GenLayerPreclipseBiomes(long seed) {
        super(seed);
    }

    @Override
    public int[] getInts(int x, int z, int width, int depth)
    {
        int[] dest = IntCache.getIntCache(width*depth);

        for (int dz=0; dz<depth; dz++)
            for (int dx=0; dx<width; dx++)
            {
                initChunkSeed(dx+x, dz+z);
                dest[dx+dz*width] = Biome.getIdForBiome(allowedBiomes[nextInt(allowedBiomes.length)]);
            }
        return dest;
    }
}
