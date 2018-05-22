
package com.xstv.launcher.provider.db;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {
    private final DaoConfig screenInfoDaoConfig;

    private final ScreenInfoDao screenInfoDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        screenInfoDaoConfig = daoConfigMap.get(ScreenInfoDao.class).clone();
        screenInfoDaoConfig.initIdentityScope(type);

        screenInfoDao = new ScreenInfoDao(screenInfoDaoConfig, this);

        registerDao(ScreenInfo.class, screenInfoDao);
    }

    public void clear() {
        screenInfoDaoConfig.getIdentityScope().clear();
    }

    public ScreenInfoDao getScreenInfoDao() {
        return screenInfoDao;
    }

}
