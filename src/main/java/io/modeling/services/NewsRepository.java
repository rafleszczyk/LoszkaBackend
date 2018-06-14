package io.modeling.services;

import org.springframework.data.jpa.repository.JpaRepository;

import io.modeling.models.Model;

public interface NewsRepository extends JpaRepository<Model, Integer> {

}
