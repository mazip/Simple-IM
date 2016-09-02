# Simple-IM
## 协议层
> 1.协议内容定义  
> 2.协议解析和封装  
> 3.相关帮助类  
> 4.默认协议xmpp  

### V0.0.1 
> 实现xmpp协议，客户端为spark
> ***标准协议***
  RFC6120(xmpp-core:可扩展的消息和出席信息协议)
  RFC6121(xmpp-im:即时消息和出席信息)
  RFC6122(xmpp-address:地址格式)
> ***jingle***
  XEP-0166: Jingle
  XEP-0167: Jingle RTP Sessions
  XEP-0176: Jingle ICE-UDP Transport Method
  XEP-0177: Jingle Raw UDP Transport Method
  XEP-0181: Jingle DTMF
  XEP-0234: Jingle File Transfer
> ***MUC***
  XEP-0045: Multi-User Chat
  XEP-0249: Direct MUC Invitations
  XEP-0272: Multiparty Jingle
> ***Pub/Sub***
  XEP-0060: Publish-Subscribe
  XEP-0163: Personal Eventing Protocol
  XEP-0248: PubSub Collection Nodes
  
### V0.0.2
> 实现自定义协议，利用protocol buffer
  