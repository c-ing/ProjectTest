package com.java.java_151_adivces.chapter_6;

import sun.reflect.generics.scope.Scope;

/**
 * Created by cdc on 2018/5/14.
 */
public class Role {
    /*Admin("管理员",new lifeTime() {
    },new

    Scope() {
    });

    User("普通用户",new lifeTime() {
    },new

    Scope() {
    });*/

    //中文描述
    private String name;
    //角色的生命周期
    private LifeTime lifeTme;
    //权限范围
    private Scope scope;

    Role(String _name, LifeTime _lf, Scope _scope) {
        name = _name;
        lifeTme = _lf;
        scope = _scope;
    }

    public String getName() {
        return name;
    }

    public LifeTime getLifeTme() {
        return lifeTme;
    }

    public Scope getScope() {
        return scope;
    }

    class LifeTime {
    }

    class Scope {
    }

}
