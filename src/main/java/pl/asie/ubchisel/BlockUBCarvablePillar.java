package pl.asie.ubchisel;

import com.cricketcraft.chisel.block.BlockCarvablePillar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.StatCollector;

public class BlockUBCarvablePillar extends BlockCarvablePillar {
	public BlockUBCarvablePillar(Material material) {
		super(material);
	}

	@Override
	public String getLocalizedName() {
		return StatCollector.translateToLocal(SplendidRegistry.get(this))+ " (Pillar)";
	}

	@Override
	public void registerBlockIcons(IIconRegister register) {
		this.carverHelper.registerBlockIcons("ubchisel", this, register);
	}

	@Override
	public String getUnlocalizedName() {
		return SplendidRegistry.get(this);
	}
}
