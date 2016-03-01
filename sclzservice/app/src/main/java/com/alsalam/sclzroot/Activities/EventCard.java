package com.alsalam.sclzroot.Activities;

import android.widget.Button;

/**
 * Created by bana on 29/02/2016.
 */
public class EventCard
{
    private String tvBegin2;
    private String tvEventP2;
    private String tvLocation2;
    private Button btMore;



    private long id;

    public EventCard( String tvBegin2, String tvEventP2,String tvLocation2, Button btMore,long id)
    {

        this.tvBegin2 = tvBegin2;
        this.tvEventP2 = tvEventP2;
        this.tvLocation2 = tvLocation2;
        this.btMore = btMore;
        this.id=id;
    }

    public String getTvBegin2() {
        return tvBegin2;
    }

    public String getTvEventP2() {
        return tvEventP2;
    }

    public String getTvLocation2() {
        return tvLocation2;
    }

    public Button getBtMore() {
        return btMore;
    }

    public void setTvBegin2(String tvBegin2) {
        this.tvBegin2 = tvBegin2;
    }

    public void setTvEventP2(String tvEventP2) {
        this.tvEventP2 = tvEventP2;
    }

    public void setTvLocation2(String tvLocation2) {
        this.tvLocation2 = tvLocation2;
    }

    public void setBtMore(Button btMore) {
        this.btMore = btMore;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "EventCard{" +
                "tvBegin2='" + tvBegin2 + '\'' +
                ", tvEventP2='" + tvEventP2 + '\'' +
                ", tvLocation2='" + tvLocation2 + '\'' +
                ", btMore=" + btMore +
                '}';
    }
}
