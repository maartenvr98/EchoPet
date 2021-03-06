package com.dsh105.echopet.compat.nms.v1_13_R1.entity.type;

import com.dsh105.echopet.compat.api.entity.*;
import com.dsh105.echopet.compat.api.entity.type.nms.IEntityDolphinPet;

import net.minecraft.server.v1_13_R1.*;

/**
 * @author Arnah
 * @since Aug 2, 2018
*/
@EntitySize(width = 0.9F, height = 0.6F)
@EntityPetType(petType = PetType.COD)
public class EntityDolphinPet extends EntityWaterAnimalPet implements IEntityDolphinPet{

	private static final DataWatcherObject<BlockPosition> b = DataWatcher.a(EntityDolphinPet.class, DataWatcherRegistry.l);
	private static final DataWatcherObject<Boolean> c = DataWatcher.a(EntityDolphinPet.class, DataWatcherRegistry.i);
	private static final DataWatcherObject<Integer> bC = DataWatcher.a(EntityDolphinPet.class, DataWatcherRegistry.b);

	public EntityDolphinPet(World world){
		super(EntityTypes.DOLPHIN, world);
	}

	public EntityDolphinPet(World world, IPet pet){
		super(EntityTypes.DOLPHIN, world, pet);
	}

	protected void initDatawatcher(){
		super.initDatawatcher();
		this.datawatcher.register(b, BlockPosition.ZERO);
		this.datawatcher.register(c, Boolean.valueOf(false));
		this.datawatcher.register(bC, Integer.valueOf(2400));
	}

	@Override
	public SizeCategory getSizeCategory(){
		return SizeCategory.REGULAR;
	}
}
