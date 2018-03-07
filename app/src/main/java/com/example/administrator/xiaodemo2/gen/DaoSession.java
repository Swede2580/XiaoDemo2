package com.example.administrator.xiaodemo2.gen;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.example.administrator.xiaodemo2.clazz.Shou;

import com.example.administrator.xiaodemo2.gen.ShouDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig shouDaoConfig;

    private final ShouDao shouDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        shouDaoConfig = daoConfigMap.get(ShouDao.class).clone();
        shouDaoConfig.initIdentityScope(type);

        shouDao = new ShouDao(shouDaoConfig, this);

        registerDao(Shou.class, shouDao);
    }
    
    public void clear() {
        shouDaoConfig.clearIdentityScope();
    }

    public ShouDao getShouDao() {
        return shouDao;
    }

}
