package com.mariusz.empexp.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mariusz.empexp.core.domain.Pracownik;

public interface IPracownikDAO extends JpaRepository<Pracownik, Integer>{

}
