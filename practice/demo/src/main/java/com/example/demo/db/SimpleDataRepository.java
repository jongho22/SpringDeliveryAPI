package com.example.demo.db;

import com.example.demo.entity.Entity;

import java.util.*;
import java.util.stream.Collectors;

abstract public class SimpleDataRepository<T extends Entity, ID extends Long> implements DataRepository<T,ID> {

    private List<T> dataList = new ArrayList<T>();

    private static long index = 0;

    private Comparator<T> sort = new Comparator<T>() {

        @Override
        public int compare(T o1, T o2) {
            return Long.compare(o1.getId(), o2.getId());
        }
    };

    // create, update
    @Override
    public T save(T data) {

        if (Objects.isNull(data)) {
            throw new RuntimeException("Data can not be null");
        }

        // db에 이미 있는 데이터 인가?
        var preData = dataList.stream()
                .filter(e -> {
                    return e.getId().equals(data.getId());
                }).findFirst();

        // 기존 데이터가 있을경우
        if (preData.isPresent()) {
            // 기존 데이터가 있을 경우에는 업데이트
            dataList.remove(preData.get());
            dataList.add(data);

        } else {
            // 기존 데이터가 없는 경우 새로운 데이터 저장
            // 데이터 아이디 지정
            index++;
            data.setId(index);
            dataList.add(data);
        }
        return data;
    };

    // read
    @Override
    public Optional<T> findById(ID id) {
        return dataList.stream().filter(e -> {
            return (e.getId().equals(id));
        }).findFirst();
    }

    @Override
    public List<T> findAll() {
        return dataList
                .stream()
                .sorted(sort) // 정렬
                .collect(Collectors.toList());
    }

    // delete
    @Override
    public void delete(ID id) {
        var deleteEntity = dataList.stream().filter(e-> {
            return (e.getId().equals(id));
        }).findFirst();

        if (deleteEntity.isPresent()) {
            dataList.remove(deleteEntity.get());
        }
    }
}
