package com.berkedev.weather.user.data.repository;

import com.berkedev.weather.user.data.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity> extends JpaRepository<T,Long>, JpaSpecificationExecutor<T> {
}
