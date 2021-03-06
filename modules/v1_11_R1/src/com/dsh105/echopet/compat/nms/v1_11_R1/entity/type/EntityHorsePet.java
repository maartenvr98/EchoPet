/*
 * This file is part of EchoPet.
 *
 * EchoPet is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * EchoPet is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with EchoPet.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.dsh105.echopet.compat.nms.v1_11_R1.entity.type;

import org.bukkit.entity.Horse;

import com.dsh105.echopet.compat.api.entity.*;
import com.dsh105.echopet.compat.api.entity.type.nms.IEntityHorsePet;

import net.minecraft.server.v1_11_R1.*;

@EntitySize(width = 1.4F, height = 1.6F)
@EntityPetType(petType = PetType.HORSE)
public class EntityHorsePet extends EntityHorseAbstractPet implements IEntityHorsePet{

	// EntityHorse
	private static final DataWatcherObject<Integer> STYLE = DataWatcher.a(EntityHorsePet.class, DataWatcherRegistry.b);// Pattern
	private static final DataWatcherObject<Integer> ARMOR = DataWatcher.a(EntityHorsePet.class, DataWatcherRegistry.b);// Self explanatory.

	public EntityHorsePet(World world){
		super(world);
	}

	public EntityHorsePet(World world, IPet pet){
		super(world, pet);
	}

	public void setVariant(HorseVariant variant){}

	public int getVariant(){
		return datawatcher.get(STYLE);
	}

	public void setColor(Horse.Color color){
		datawatcher.set(STYLE, (color.ordinal() & 0xFF | getStyle().ordinal() << 8));
	}

	public void setStyle(Horse.Style style){
		datawatcher.set(STYLE, getColor().ordinal() & 0xFF | style.ordinal() << 8);
	}

	public Horse.Style getStyle(){
		return Horse.Style.values()[(getVariant() >>> 8)];
	}

	public Horse.Color getColor(){
		return Horse.Color.values()[(getVariant() & 0xFF)];
	}

	@Override
	public void setArmour(HorseArmour a){
		this.datawatcher.set(ARMOR, EnumHorseArmor.values()[a.ordinal()].a());
	}

	@Override
	public boolean attack(Entity entity){
		boolean flag = super.attack(entity);
		if(flag){
			setHorseVisual(64, true);
			// TODO:
			/*if(getType().g()){
				makeSound("entity.horse.angry", 1.0F, 1.0F);
			}else{
				makeSound("entity.donkey.angry", 1.0F, 1.0F);
			}*/
		}
		return flag;
	}

	@Override
	protected void initDatawatcher(){
		super.initDatawatcher();
		this.datawatcher.register(STYLE, 0);
		this.datawatcher.register(ARMOR, EnumHorseArmor.NONE.a());
	}
}
