package com.devswpro.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.devswpro.model.Kit;

public interface IKitDAO extends JpaRepository<Kit, Integer>{

}
