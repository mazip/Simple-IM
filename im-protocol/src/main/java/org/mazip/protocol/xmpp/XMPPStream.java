package org.mazip.protocol.xmpp;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created by mazip on 2016/8/23.
 * XML流
 * 两个基本概念，使得XMPP实体之间的小的结构化信息有效载荷能快速地进行异步交换：XML流和XML节
 * 我们先看流
 *
 * XML流的定义:
 * XML流是一个容器，用于任何两个实体通过网络进行XML元素的交换.
 * XML流的开始明确表达为一个打开的 "流头"
 * (即, 一个包含了适当树形和命名空间声明的 XML <stream> 标签),
 * 而这个XML流的结尾明确表达为一个关闭的XML </stream> 标签.
 * 在流的生存期间, 发起方实体可以通过这个流发送不限数量的XML元素,
 * 这些元素或用来协商这个流 (例如, 完成 TLS协商 或 SASL协商 ) 或用于 XML节.
 * "发起流" 是从发起方实体 (通常是一个客户端或服务器) 到接收方实体 (通常是一个服务器),
 * 也可视为对应发起方 "连接到" 或 "和......开启会话" 接收方实体.
 * 发起流允许从发起方实体到接收方实体的单向通讯;
 * 为了让接收方实体能够向发起方实体发送节, 接收方实体必须(MUST) 协商一个相反的流 ("应答流").
 *    如何打开流 ( 4.2 )
 *    流协商过程 ( 4.3 )
 *    如何关闭流 ( 4.4 )
 *    XML流的方向性 ( 4.5 )
 *    如何处理沉默的对端 ( 4.6 )
 *    流的XML属性 ( 4.7 )
 *    流的XML命名空间 ( 4.8 )
 *    和XML流相关的错误处理 ( 4.9 )
 *    +----------+--------------------------+-------------------------+
 *    |          |    初始实体 到 接收实体     |    接收实体 到 初始实体    |
 *    +----------+--------------------------+-------------------------+
 *    | to       | 接收实体JID               | 初始实体JID              |
 *    | from     | 初始实体JID               | 接收实体JID              |
 *    | id       | 忽  略                       | 流标识                     |
 *    | xml:lang | 默认语言                     | 默认语言                   |
 *    | version  | XMPP 1.0+ supported      | XMPP 1.0+ supported     |
 *    +----------+--------------------------+-------------------------+
 */
public class XMPPStream {

    public static final  String  START_TAG="stream:stream";
    public static final  String  FROM_ATTR = "from";
    public static final  String  TO_ATTR = "to";
    public static final  String  ID_ATTR ="id";
    public static final  String  LANG_ATTR="xml:lang";
    public static final  String  VERSION_ATTR ="version";
    public static final  String  XMLNS_ATTR="xmlns";
    public static final  String  XMLNSSTREAM_ATTR="xmlns:stream";


    private String from;
    private String to;
    private String id;
    private String lang;
    private String version;
    private String xmlns;
    private String xmlnsStream;

    public String getXmlnsStream() {
        return xmlnsStream;
    }

    public void setXmlnsStream(String xmlnsStream) {
        this.xmlnsStream = xmlnsStream;
    }

    public String getXmlns() {
        return xmlns;
    }

    public void setXmlns(String xmlns) {
        this.xmlns = xmlns;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public static void main(String[] args) throws IllegalAccessException {
        Class c = XMPPStream.class;
        Field[] fields = c.getDeclaredFields();
        for (int i=0;i<fields.length;i++){
            if(Modifier.isPublic(fields[i].getModifiers())){
                if("START_TAG".equals(fields[i].getName())){
                    System.out.println(fields[i].get(c).toString());
                    continue;
                }
            }

            if("private".equals(Modifier.toString(fields[i].getModifiers()))){
                System.out.println(fields[i].getName());
            }

        }
    }
}
