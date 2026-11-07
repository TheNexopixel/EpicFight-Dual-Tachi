package net.nexo.dualtachi;

import com.hm.efn.EFN;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.resource.PathPackResources;
import net.nexo.dualtachi.skill.compat.NightfallCompat;
import net.nexo.dualtachi.skill.compat.WoMCompat;
import reascer.wom.main.WeaponsOfMinecraft;
import yesman.epicfight.compat.ICompatModule;

import java.nio.file.Path;

@Mod(EFDT.MODID)
public class EFDT {

    public static final String MODID = "efdt";

    public EFDT(FMLJavaModLoadingContext context) {

        IEventBus bus = context.getModEventBus();
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);
        bus.addListener(this::addPackFindersEvent);

        if(ModList.get().isLoaded(WeaponsOfMinecraft.MODID)) {
            bus.addListener(WoMCompat::buildSkillEvent);
            ICompatModule.loadCompatModule(context, WoMCompat.class);
            DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> bus.addListener(WoMCompat::regIcon));
        }

        if(ModList.get().isLoaded(EFN.MODID)){
            ICompatModule.loadCompatModule(context, NightfallCompat.class);
        }


    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    public void addPackFindersEvent(AddPackFindersEvent event) {
        if (event.getPackType() == PackType.SERVER_DATA) {
            Path resourcePath = ModList.get().getModFileById(EFDT.MODID).getFile().findResource("packs/dt_override");
            PathPackResources pack = new PathPackResources(ModList.get().getModFileById(EFDT.MODID).getFile().getFileName() + ":" + resourcePath, true, resourcePath);
            Pack.ResourcesSupplier resourcesSupplier = (string) -> pack;
            Pack.Info info = Pack.readPackInfo("dt_override", resourcesSupplier);

            if (info != null) {
                event.addRepositorySource((source) ->
                        source.accept(Pack.create("dt_override", Component.translatable("pack.dt_override.title"), false, resourcesSupplier, info, PackType.SERVER_DATA, Pack.Position.TOP, false, PackSource.SERVER)));
            }
        }

    }
}
