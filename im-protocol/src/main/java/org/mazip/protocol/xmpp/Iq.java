package org.mazip.protocol.xmpp;

import org.mazip.protocol.xmpp.annotation.StartTag;
import org.mazip.protocol.xmpp.annotation.XMPPChild;

/**
 * Created by mazip on 2016/8/23.
 */
@StartTag("iq")
public class Iq extends Packet {
    /*子节点 query */
    @XMPPChild("query")
    private Query query;

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

}
