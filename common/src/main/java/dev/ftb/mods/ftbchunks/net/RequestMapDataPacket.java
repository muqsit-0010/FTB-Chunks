package dev.ftb.mods.ftbchunks.net;

import me.shedaniel.architectury.networking.NetworkManager;
import net.minecraft.network.FriendlyByteBuf;

/**
 * @author LatvianModder
 */
public class RequestMapDataPacket extends MessageBase {
	public final int fromX, fromZ, toX, toZ;

	public RequestMapDataPacket(int fx, int fz, int tx, int tz) {
		fromX = fx;
		fromZ = fz;
		toX = tx;
		toZ = tz;
	}

	RequestMapDataPacket(FriendlyByteBuf buf) {
		fromX = buf.readVarInt();
		fromZ = buf.readVarInt();
		toX = buf.readVarInt();
		toZ = buf.readVarInt();
	}

	@Override
	public void write(FriendlyByteBuf buf) {
		buf.writeVarInt(fromX);
		buf.writeVarInt(fromZ);
		buf.writeVarInt(toX);
		buf.writeVarInt(toZ);
	}

	public void handle(NetworkManager.PacketContext context) {
		//FIXME: SendMapDataPacket.send(Objects.requireNonNull(context.get().getSender())));
	}
}