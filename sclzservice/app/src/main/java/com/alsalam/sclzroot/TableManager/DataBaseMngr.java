package com.alsalam.sclzroot.TableManager;

import android.app.Activity;

import com.alsalam.sclzroot.MyAdapters.EventTblAdapter;
import com.microsoft.windowsazure.mobileservices.MobileServiceClient;
import com.microsoft.windowsazure.mobileservices.table.MobileServiceTable;

/**
 * Created by samih on 09/03/2016.
 */
public class DataBaseMngr
{
    public static Activity activity;


    /**
     * Mobile Service Client reference
     */
    public static MobileServiceClient mClient;

    /**
     * Mobile Service Table used to access data
     */
    public static MobileServiceTable<EventTbl> mToDoTable;

    public static EventTblAdapter mAdapter;

}
