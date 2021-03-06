package com.xstv.desktop.app.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import com.xstv.base.LetvLog;

import de.greenrobot.dao.AbstractDaoMaster;
import de.greenrobot.dao.identityscope.IdentityScopeType;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * Master of DAO (schema version 1): knows all DAOs.
*/
public class DaoMaster extends AbstractDaoMaster {
    public static final int SCHEMA_VERSION = 1;
    /**
     * 数据库升级
     * 1.去掉一些冗余字段
     * spanX,spanY,row,column,width,height,description,iconUrl,backgroundResID,apkUrl,downType,downState
     * superscriptType,superscriptCount,multi_language;
     * 增加字段orderTimestamp 常用应用位排序需要的时间戳
     * 2.为添加快捷方式增加一些字段
     * shortcutIntentUrl 快捷方式intent转换成url
     * shortcutIcon      快捷方式图标
     * shortcutResourseName 资源名字
     */
    public static final int SCHEMA_VERSION_1 = 2;

    /**
     * 修改SHORTCUT_INFO为ITEM_INFO
     */
    public static final int SCHEMA_VERSION_2 = 3;


    /** Creates underlying database table using DAOs. */
    public static void createAllTables(SQLiteDatabase db, boolean ifNotExists) {
        ItemInfoDao.createTable(db, ifNotExists);
    }

    /** Drops underlying database table using DAOs. */
    public static void dropAllTables(SQLiteDatabase db, boolean ifExists) {
        ItemInfoDao.dropTable(db, ifExists);
    }

    public static abstract class OpenHelper extends SQLiteOpenHelper {

        public OpenHelper(Context context, String name, CursorFactory factory) {
            super(context, name, factory, SCHEMA_VERSION_2);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.i("greenDAO", "Creating tables for schema version " + SCHEMA_VERSION_2);
            createAllTables(db, false);
        }

        @Override
        public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            LetvLog.i("greenDAO", " Downgrade schema from version " + oldVersion + " to " + newVersion + " by dropping all tables");
            dropAllTables(db, true);
            onCreate(db);
        }
    }

    /** WARNING: Drops all table on Upgrade! Use only during development. */
    public static class DevOpenHelper extends OpenHelper {
        public DevOpenHelper(Context context, String name, CursorFactory factory) {
            super(context, name, factory);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            /*dropAllTables(db, true);
            onCreate(db);*/
            Log.i("greenDAO", "Upgrading schema from version " + oldVersion + " to " +
                    newVersion + " by ItemInfoMigrationV1");
            switch (oldVersion) {
                case SCHEMA_VERSION:
                    if (newVersion <= SCHEMA_VERSION) {
                        return;
                    }
                    try {
                        Migration migration = new ItemInfoMigrationV1();
                        migration.migrate(db);
                    } catch (Exception ex) {
                        LetvLog.e("greenDAO", "onUpgrade v1 error", ex);
                        break;
                    }
                case SCHEMA_VERSION_1:
                    if (newVersion <= SCHEMA_VERSION_1) {
                        return;
                    }
                    try {
                        Migration migration = new ItemInfoMigrationV2();
                        migration.migrate(db);
                    } catch (Exception ex) {
                        LetvLog.e("greenDAO", "onUpgrade v2 error", ex);
                        break;
                    }
            }
        }
    }

    public DaoMaster(SQLiteDatabase db) {
        super(db, SCHEMA_VERSION_2);
        registerDaoClass(ItemInfoDao.class);
    }

    public DaoSession newSession() {
        return new DaoSession(db, IdentityScopeType.Session, daoConfigMap);
    }

    public DaoSession newSession(IdentityScopeType type) {
        return new DaoSession(db, type, daoConfigMap);
    }
    
}
