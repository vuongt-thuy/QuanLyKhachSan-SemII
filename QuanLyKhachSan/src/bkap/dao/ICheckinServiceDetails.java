/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.dao;

import bkap.model.CheckinServiceDetails;
import java.util.List;

/**
 *
 * @author THUY
 */
public interface ICheckinServiceDetails {
    void add(CheckinServiceDetails c);
    void delete(int idService);
    void edit (CheckinServiceDetails c);
    List<CheckinServiceDetails> findAll();
    List<CheckinServiceDetails> findByIdCheckinDetail(int id);
}
