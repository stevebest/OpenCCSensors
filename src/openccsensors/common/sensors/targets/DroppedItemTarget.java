package openccsensors.common.sensors.targets;

import java.util.HashMap;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.world.World;
import openccsensors.common.api.ISensorTarget;

public class DroppedItemTarget extends EntityTarget implements ISensorTarget {

	public DroppedItemTarget(Object entity, double relativeX, double relativeY,
			double relativeZ) {
		super((Entity) entity, relativeX, relativeY, relativeZ);
	}

	@Override
	public HashMap getExtendedDetails(World world) {
		EntityItem entity = (EntityItem) world.getEntityByID(id);
		HashMap retMap = new HashMap();
		retMap.putAll(getBasicDetails(world));
		retMap.put("IsBurning", entity.isBurning());
		retMap.put("StackSize",
				Integer.toString(entity.getEntityItem().stackSize));
		return retMap;
	}

	@Override
	public String[] getTrackablePropertyNames() {
		return null;
	}

}
