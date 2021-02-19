/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.dao.impl;

import bkap.dao.IService;
import bkap.mapper.ServiceMapper;
import bkap.model.Service;
import java.util.List;

/**
 *
 * @author THUY
 */
public class ServiceDAO extends AbstractDAO<Service> implements IService {

    @Override
    public void add(Service s) {
        String sql = "{call service_insert(?,?,?,?,?)}";
        insert(sql, s.getName(), s.getInputPrice(), s.getOutputPrice(), s.getUnit(), s.getCatService());
    }

    @Override
    public void edit(Service s) {
        String sql = "{call service_update(?,?,?,?,?,?)}";
        update(sql, s.getId(), s.getName(), s.getInputPrice(), s.getOutputPrice(), s.getUnit(), s.getCatService());
    }

    @Override
    public void delete(int id) {
        String sql = "{call service_delete(?)}";
        update(sql, id);
    }

    @Override
    public List<Service> findAll() {
        String sql = "{call service_findAll()}";
        return query(sql, new ServiceMapper());
    }

    @Override
    public List<Service> findByName(String name) {
        String sql = "{call service_findByName(?)}";
        return query(sql, new ServiceMapper(), name);
    }

    public Service findByID(int id) {
        String sql = "{call service_findByServiceId(?)}";
        List<Service> list = query(sql, new ServiceMapper(), id);
        return list.isEmpty() ? null : list.get(0);
    }

}
