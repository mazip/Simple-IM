package org.mazip.protocol.xmpp;

/**
 * Created by mazip on 2016/8/23.
 */
public class Iq extends Packet {

    public static final  String  START_TAG="iq";

    private String type;

    private String id;

    private Query query;

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
