package com.hana.app.service;

import com.hana.app.data.CustDto;
import com.hana.app.exception.DuplicatedIdException;
import com.hana.app.frame.Dao;
import com.hana.app.frame.Service;


@org.springframework.stereotype.Service
public class CustService implements Service<String, CustDto> {

    Dao<String, CustDto> dao;

    public CustService(Dao dao){
        this.dao = dao; // new를 사용해 새로운 객체를 생성하지 않음. -> spring.xml에서 생성된 객체를 받아옴
    }

    @Override
    public int add(CustDto custDto) throws DuplicatedIdException {
        System.out.println("Start TR....");
        try {
            dao.insert(custDto);
            System.out.println("COMMIT....");
        }catch(DuplicatedIdException e){
            System.out.println("ROLLBACK....");
            throw e;
        }finally {
            System.out.println("End TR....");
        }

        // SMS ..
        System.out.println("Send SMS ....");
        return 0;
    }

    @Override
    public int del(String s) throws Exception {
        dao.delete(s);
        return 0;
    }

    @Override
    public int modify(CustDto custDto) throws Exception {
        dao.update(custDto);
        return 0;
    }

    @Override
    public CustDto get(String s) throws Exception {
        return dao.select(s);
    }

    @Override
    public List<CustDto> get() throws Exception {
        return dao.select();
    }


}
