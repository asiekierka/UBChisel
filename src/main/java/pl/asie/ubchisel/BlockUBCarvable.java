package pl.asie.ubchisel;

import com.cricketcraft.chisel.block.BlockCarvable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.StatCollector;

public class BlockUBCarvable extends BlockCarvable {
	public BlockUBCarvable(Material material) {
		super(material);
	}

	public void registerBlockIcons(IIconRegister register) {
		this.carverHelper.registerBlockIcons("ubchisel", this, register);
	}

	@Override
	public String getLocalizedName() {
		return StatCollector.translateToLocal(SplendidRegistry.get(this));
	}

	@Override
	public String getUnlocalizedName() {
		return SplendidRegistry.get(this);
	}
}
