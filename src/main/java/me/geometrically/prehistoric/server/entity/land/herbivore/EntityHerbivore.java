package me.geometrically.prehistoric.server.entity.land.herbivore;

import me.geometrically.prehistoric.server.entity.ai.EntityAIDinoEatGrass;
import me.geometrically.prehistoric.server.entity.land.EntityDinosaur;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.world.World;

public class EntityHerbivore extends EntityDinosaur{

    public EntityHerbivore(World world){
        super(world);
    }

    @Override
    protected void initEntityAI()
    {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIWanderAvoidWater(this, 1.0D));
        this.tasks.addTask(3, new EntityAILookIdle(this));
        this.tasks.addTask(4, new EntityAIDinoEatGrass(this));
    }
}