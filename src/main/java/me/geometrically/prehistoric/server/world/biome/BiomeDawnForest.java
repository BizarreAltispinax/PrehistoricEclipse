package me.geometrically.prehistoric.server.world.biome;

import me.geometrically.prehistoric.server.entity.land.carnivore.EntityDakotaraptor;
import me.geometrically.prehistoric.server.entity.land.carnivore.EntityMonolophosaurus;
import me.geometrically.prehistoric.server.entity.land.herbivore.EntityArthropleura;
import me.geometrically.prehistoric.server.entity.land.herbivore.EntityPlateosaurus;
import net.minecraft.block.BlockDirt;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenMegaPineTree;

import java.util.Random;

public class BiomeDawnForest extends BiomePrehistoric{

    private static final WorldGenMegaPineTree TREE = new WorldGenMegaPineTree(false, false);

    public BiomeDawnForest(){
        super(new BiomeProperties("Dawn Forest").setBaseHeight(0.3F).setHeightVariation(0.2F).setTemperature(0.1F));

        this.decorator.treesPerChunk = 8;
        this.decorator.grassPerChunk = 2;
        this.decorator.reedsPerChunk = 20;
        this.decorator.grassPerChunk = 3;
        this.setColors(2054144);

        this.spawnableCreatureList.add(new SpawnListEntry(EntityDakotaraptor.class, 90, 3, 5));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityPlateosaurus.class, 100, 3, 6));
        //TODO Add rex here once it actually gets added
    }
    @Override
    public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal)
    {
        this.topBlock = Blocks.GRASS.getDefaultState();

        if (noiseVal > 1.75D) {
            this.topBlock = Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.COARSE_DIRT);
        }
        else if (noiseVal > -0.95D) {
            this.topBlock = Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.PODZOL);
        }
        this.generateBiomeTerrain(worldIn, rand, chunkPrimerIn, x, z, noiseVal);
    }
    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand)
    {
        return TREE;
    }
}