package com.pinming.wk.service;

import com.pinming.wk.model.t0;

import java.util.List;

/**
 * @author： wangkai
 * @date： 2021-09-01 09:29:58
 */
public interface T0Service {
    void add(t0 t);

    void delete(int id);

    List<t0> query();
}
