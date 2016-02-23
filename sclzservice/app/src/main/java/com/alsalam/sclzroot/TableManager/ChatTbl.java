package com.alsalam.sclzroot.TableManager;

import java.sql.Date;

/**
 * Created by משתמש on 2/23/2016.
 */
public class ChatTbl {
    private String id;
    private String chatMsg;
    private Date   chatMsgDate;

    public ChatTbl(String id, String chatMsg, Date chatMsgDate) {
        this.id = id;
        this.chatMsg = chatMsg;
        this.chatMsgDate = chatMsgDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChatMsg() {
        return chatMsg;
    }

    public void setChatMsg(String chatMsg) {
        this.chatMsg = chatMsg;
    }

    public Date getChatMsgDate() {
        return chatMsgDate;
    }

    public void setChatMsgDate(Date chatMsgDate) {
        this.chatMsgDate = chatMsgDate;
    }
}
