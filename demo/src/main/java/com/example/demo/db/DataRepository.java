package com.example.demo.db;

import java.util.List;
import java.util.Optional;

// 인터페이스라 => 다중 상속을 지원
// 인터페이스(interface)란 다른 클래스를 작성할 때 기본이 되는 틀을 제공하면서, 다른 클래스 사이의 중간 매개 역할
public interface DataRepository<T, ID> extends Repository<T,ID>  {

    // create, update
    T save(T data);

    // read
    /*  null이 올 수 있는 값을 감싸는 Wrapper 클래스
        NullPointerException 발생하지 않도록 */
    Optional<T> findById(ID id);

    List<T> findAll();

    // delete
    void delete(ID id);

}
