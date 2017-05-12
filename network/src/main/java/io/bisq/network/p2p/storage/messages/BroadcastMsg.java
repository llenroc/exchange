package io.bisq.network.p2p.storage.messages;

import io.bisq.common.app.Version;
import io.bisq.common.network.NetworkEnvelope;

public abstract class BroadcastMsg implements NetworkEnvelope {
    //TODO add serialVersionUID also in superclasses as changes would break compatibility
    private final int messageVersion = Version.getP2PMessageVersion();

    @Override
    public int getMsgVersion() {
        return messageVersion;
    }

    @Override
    public String toString() {
        return "DataBroadcastMessage{" +
                "messageVersion=" + messageVersion +
                '}';
    }
}