# Getting Started

### spring boot web-socket

#### 三种方式
* 前端发消息过来，经过处理，再回过去。SendTo、SendToUser
* 后端主动推消息给前端。 messagingTemplate.convertAndSend
* 后端主动推送消息给前端--推送到指定用户。  messagingTemplate.convertAndSendToUser
