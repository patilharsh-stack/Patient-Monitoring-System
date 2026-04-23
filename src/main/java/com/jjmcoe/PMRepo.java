package com.jjmcoe;

import org.springframework.data.jpa.repository.JpaRepository;

public interface  PMRepo  extends JpaRepository<PMEntity , Integer>{

	PMEntity findByMobilenumberAndPassword(String mobilenumber, String password);

}
