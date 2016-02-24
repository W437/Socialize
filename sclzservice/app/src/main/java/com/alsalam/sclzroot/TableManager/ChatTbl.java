package com.alsalam.sclzroot.TableManager;

import java.sql.Date;

/**
 * Created by משתמש on 2/23/2016.
 */
public class ChatTbl {
    @com.google.gson.annotations.SerializedName("id")
    private String id;
    @com.google.gson.annotations.SerializedName("chatMsg")
    private String chatMsg;
    @com.google.gson.annotations.SerializedName("chatMsgDate")
    private Date   chatMsgDate;

    public ChatTbl(String id, String chatMsg, Date chatMsgDate) {
        setId(id);
        setChatMsg(chatMsg);
        setChatMsgDate(chatMsgDate);
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
