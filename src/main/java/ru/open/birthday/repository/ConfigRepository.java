package ru.open.birthday.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.open.birthday.entity.Config;

public interface ConfigRepository extends JpaRepository<Config, String> {
}
