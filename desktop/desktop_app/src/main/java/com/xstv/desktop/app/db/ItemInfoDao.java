package com.xstv.desktop.app.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * DAO for table "ITEM_INFO".
*/
public class ItemInfoDao extends AbstractDao<ItemInfo, Long> {

    public static final String TABLENAME = "ITEM_INFO";

    /**
     * Properties of entity ItemInfo.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Index = new Property(1, Integer.class, "index", false, "INDEX");
        public final static Property Type = new Property(2, Integer.class, "type", false, "TYPE");
        public final static Property Title = new Property(3, String.class, "title", false, "TITLE");
        public final static Property PackageName = new Property(4, String.class, "packageName", false, "PACKAGE_NAME");
        public final static Property ClassName = new Property(5, String.class, "className", false, "CLASS_NAME");
        public final static Property Flags = new Property(6, Integer.class, "flags", false, "FLAGS");
        public final static Property Container = new Property(7, Long.class, "container", false, "CONTAINER");
        public final static Property ContainerName = new Property(8, String.class, "containerName", false, "CONTAINER_NAME");
        public final static Property InstallTime = new Property(9, Long.class, "installTime", false, "INSTALL_TIME");
        public final static Property ComponentNameStr = new Property(10, String.class, "componentNameStr", false, "COMPONENT_NAME_STR");
        public final static Property InFolderIndex = new Property(11, Integer.class, "inFolderIndex", false, "IN_FOLDER_INDEX");
        public final static Property Folder_id = new Property(12, String.class, "folder_id", false, "FOLDER_ID");
        public final static Property OrderTimestamp = new Property(13, Long.class, "orderTimestamp", false, "ORDER_TIMESTAMP");
        public final static Property ShortcutIntentUrl = new Property(14, String.class, "shortcutIntentUrl", false, "SHORTCUT_INTENT_URL");
        public final static Property ShortcutIcon = new Property(15, byte[].class, "shortcutIcon", false, "SHORTCUT_ICON");
        public final static Property ShortcutResourseName = new Property(16, String.class, "shortcutResourseName", false, "SHORTCUT_RESOURSE_NAME");
        public final static Property Reserve1 = new Property(17, String.class, "reserve1", false, "RESERVE1");
        public final static Property Reserve2 = new Property(18, String.class, "reserve2", false, "RESERVE2");
        public final static Property Reserve3 = new Property(19, String.class, "reserve3", false, "RESERVE3");
    };


    public ItemInfoDao(DaoConfig config) {
        super(config);
    }
    
    public ItemInfoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ITEM_INFO\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"INDEX\" INTEGER," + // 1: index
                "\"TYPE\" INTEGER," + // 2: type
                "\"TITLE\" TEXT," + // 3: title
                "\"PACKAGE_NAME\" TEXT," + // 4: packageName
                "\"CLASS_NAME\" TEXT," + // 5: className
                "\"FLAGS\" INTEGER," + // 6: flags
                "\"CONTAINER\" INTEGER," + // 7: container
                "\"CONTAINER_NAME\" TEXT," + // 8: containerName
                "\"INSTALL_TIME\" INTEGER," + // 9: installTime
                "\"COMPONENT_NAME_STR\" TEXT," + // 10: componentNameStr
                "\"IN_FOLDER_INDEX\" INTEGER," + // 11: inFolderIndex
                "\"FOLDER_ID\" TEXT," + // 12: folder_id
                "\"ORDER_TIMESTAMP\" INTEGER," + // 13: orderTimestamp
                "\"SHORTCUT_INTENT_URL\" TEXT," + // 14: shortcutIntentUrl
                "\"SHORTCUT_ICON\" BLOB," + // 15: shortcutIcon
                "\"SHORTCUT_RESOURSE_NAME\" TEXT," + // 16: shortcutResourseName
                "\"RESERVE1\" TEXT," + // 17: reserve1
                "\"RESERVE2\" TEXT," + // 18: reserve2
                "\"RESERVE3\" TEXT);"); // 19: reserve3
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ITEM_INFO\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, ItemInfo entity) {
        stmt.clearBindings();

        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }

        Integer index = entity.getIndex();
        if (index != null) {
            stmt.bindLong(2, index);
        }

        Integer type = entity.getType();
        if (type != null) {
            stmt.bindLong(3, type);
        }

        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(4, title);
        }

        String packageName = entity.getPackageName();
        if (packageName != null) {
            stmt.bindString(5, packageName);
        }

        String className = entity.getClassName();
        if (className != null) {
            stmt.bindString(6, className);
        }

        Integer flags = entity.getFlags();
        if (flags != null) {
            stmt.bindLong(7, flags);
        }

        Long container = entity.getContainer();
        if (container != null) {
            stmt.bindLong(8, container);
        }

        String containerName = entity.getContainerName();
        if (containerName != null) {
            stmt.bindString(9, containerName);
        }

        Long installTime = entity.getInstallTime();
        if (installTime != null) {
            stmt.bindLong(10, installTime);
        }

        String componentNameStr = entity.getComponentNameStr();
        if (componentNameStr != null) {
            stmt.bindString(11, componentNameStr);
        }

        Integer inFolderIndex = entity.getInFolderIndex();
        if (inFolderIndex != null) {
            stmt.bindLong(12, inFolderIndex);
        }

        String folder_id = entity.getFolder_id();
        if (folder_id != null) {
            stmt.bindString(13, folder_id);
        }

        Long orderTimestamp = entity.getOrderTimestamp();
        if (orderTimestamp != null) {
            stmt.bindLong(14, orderTimestamp);
        }
 
        String shortcutIntentUrl = entity.getShortcutIntentUrl();
        if (shortcutIntentUrl != null) {
            stmt.bindString(15, shortcutIntentUrl);
        }

        byte[] shortcutIcon = entity.getShortcutIcon();
        if (shortcutIcon != null) {
            stmt.bindBlob(16, shortcutIcon);
        }

        String shortcutResourseName = entity.getShortcutResourseName();
        if (shortcutResourseName != null) {
            stmt.bindString(17, shortcutResourseName);
        }

        String reserve1 = entity.getReserve1();
        if (reserve1 != null) {
            stmt.bindString(18, reserve1);
        }

        String reserve2 = entity.getReserve2();
        if (reserve2 != null) {
            stmt.bindString(19, reserve2);
        }

        String reserve3 = entity.getReserve3();
        if (reserve3 != null) {
            stmt.bindString(20, reserve3);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public ItemInfo readEntity(Cursor cursor, int offset) {
        ItemInfo entity = new ItemInfo( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1), // index
            cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2), // type
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // title
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // packageName
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // className
            cursor.isNull(offset + 6) ? null : cursor.getInt(offset + 6), // flags
            cursor.isNull(offset + 7) ? null : cursor.getLong(offset + 7), // container
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // containerName
            cursor.isNull(offset + 9) ? null : cursor.getLong(offset + 9), // installTime
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // componentNameStr
            cursor.isNull(offset + 11) ? null : cursor.getInt(offset + 11), // inFolderIndex
            cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), // folder_id
            cursor.isNull(offset + 13) ? null : cursor.getLong(offset + 13), // orderTimestamp
            cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14), // shortcutIntentUrl
            cursor.isNull(offset + 15) ? null : cursor.getBlob(offset + 15), // shortcutIcon
            cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16), // shortcutResourseName
            cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17), // reserve1
            cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18), // reserve2
            cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19) // reserve3
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, ItemInfo entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setIndex(cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1));
        entity.setType(cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2));
        entity.setTitle(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setPackageName(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setClassName(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setFlags(cursor.isNull(offset + 6) ? null : cursor.getInt(offset + 6));
        entity.setContainer(cursor.isNull(offset + 7) ? null : cursor.getLong(offset + 7));
        entity.setContainerName(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setInstallTime(cursor.isNull(offset + 9) ? null : cursor.getLong(offset + 9));
        entity.setComponentNameStr(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setInFolderIndex(cursor.isNull(offset + 11) ? null : cursor.getInt(offset + 11));
        entity.setFolder_id(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setOrderTimestamp(cursor.isNull(offset + 13) ? null : cursor.getLong(offset + 13));
        entity.setShortcutIntentUrl(cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14));
        entity.setShortcutIcon(cursor.isNull(offset + 15) ? null : cursor.getBlob(offset + 15));
        entity.setShortcutResourseName(cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16));
        entity.setReserve1(cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17));
        entity.setReserve2(cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18));
        entity.setReserve3(cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19));
     }

    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(ItemInfo entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }

    /** @inheritdoc */
    @Override
    public Long getKey(ItemInfo entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
