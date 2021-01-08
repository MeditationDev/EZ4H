package me.liuli.ez4h.translators.bedrockTranslators;

import com.github.steveice10.mc.protocol.data.game.world.sound.SoundCategory;
import com.github.steveice10.mc.protocol.packet.ingame.server.world.ServerPlayBuiltinSoundPacket;
import com.nukkitx.math.vector.Vector3f;
import com.nukkitx.protocol.bedrock.BedrockPacket;
import com.nukkitx.protocol.bedrock.packet.PlaySoundPacket;
import me.liuli.ez4h.bedrock.Client;
import me.liuli.ez4h.translators.BedrockTranslator;
import me.liuli.ez4h.translators.converters.SoundConverter;

public class PlaySoundPacketTranslator implements BedrockTranslator {
    @Override
    public void translate(BedrockPacket inPacket, Client client) {
        PlaySoundPacket packet=(PlaySoundPacket)inPacket;
        Vector3f pos=packet.getPosition();
        client.sendPacket(new ServerPlayBuiltinSoundPacket(SoundConverter.convert(packet.getSound()), SoundCategory.VOICE, pos.getX(), pos.getY(), pos.getZ(), packet.getVolume(), packet.getPitch()));
    }
}