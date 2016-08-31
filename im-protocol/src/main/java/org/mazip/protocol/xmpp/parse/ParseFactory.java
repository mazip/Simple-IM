package org.mazip.protocol.xmpp.parse;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mazip on 2016/8/29.
 */
public class ParseFactory {


    private static Map<String, DefaultParse> map = new HashMap<String, DefaultParse>();

    static {
        map.put(ParseEnum.IQ.getText(), new IQParse());
        map.put(ParseEnum.MESSAGE.getText(), new MessageParse());
        map.put(ParseEnum.PRESENCE.getText(), new PresenceParse());
        map.put(ParseEnum.STREAM.getText(), new StreamParse());
        map.put(ParseEnum.STREAMFEATURES.getText(), new StreamFeatureParse());
    }

    private ParseFactory() {

    }

    public static ParseFactory getInstance() {

        return getParseFactory.parseFactory;
    }

    public Parse doParse(String name){
        return map.get(name);
    }

    private static class getParseFactory {

        private static final ParseFactory parseFactory = new ParseFactory();
    }

}
